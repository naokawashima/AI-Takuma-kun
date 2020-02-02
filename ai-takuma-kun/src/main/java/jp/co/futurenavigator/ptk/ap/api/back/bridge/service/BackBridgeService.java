package jp.co.futurenavigator.ptk.ap.api.back.bridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import jp.co.futurenavigator.ptk.ap.api.back.bridge.dto.BridgeInDto;
import jp.co.futurenavigator.ptk.ap.api.back.bridge.dto.BridgeOutDto;

/**
 * バックエンド側ブリッジサービス
 * 要求情報のテキストを各種システムブリッジAPIに引き渡す
 * <dl>
 * <dt>【システムブリッジAPI】</dt>
 * <dd>・解析ブリッジAPI</dd>
 * <dd>・応答ブリッジAPI</dd>
 * <dd>・記憶ブリッジAPI</dd>
 * </dl>
 * @author naoka
 */
@Service
public class BackBridgeService {

	//***********************************
	//後続APIエンドポイント一覧
	//***********************************
	//システムブリッジAPI
	/** 解析ブリッジAPIリクエストURL */
	private static final String ANALYZE_URL = "http://localhost:8080/analizeLogicBridge";
	/** 記憶ブリッジAPIリクエストURL */
	private static final String MEMORIZE_URL = "http://localhost:8080/memorizeLogicBridge";
	/** 応答ブリッジAPIリクエストURL */
	private static final String REPLY_URL = "http://localhost:8080/replyLogicBridge";

	//***********************************
	//サービス設定
	//***********************************
	/** REST通信呼び出し用Bean設定 */
	@Autowired
	@Qualifier("gsonRestTemplate")
	private RestTemplate gsonRestTemplate;

	@Transactional(readOnly = true)
	public BridgeOutDto saveChat(BridgeInDto inDto) {

		BridgeOutDto outDto = new BridgeOutDto();
		outDto.setYourName(inDto.getYourName());
		outDto.setBotName(inDto.getBotName());

		//解析
		BridgeOutDto analizeOutDto = gsonRestTemplate.postForObject(ANALYZE_URL, inDto, BridgeOutDto.class);

		//解析結果の記憶
		BridgeOutDto memorizeOutDto = gsonRestTemplate.postForObject(MEMORIZE_URL, inDto, BridgeOutDto.class);

		//応答生成
		BridgeOutDto replyOutDto = gsonRestTemplate.postForObject(REPLY_URL, inDto, BridgeOutDto.class);

		outDto.setOutputTxt(replyOutDto.getOutputTxt());


		return replyOutDto;
	}
}
