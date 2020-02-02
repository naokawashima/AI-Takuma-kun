package jp.co.futurenavigator.ptk.ap.api.logic.bridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import jp.co.futurenavigator.ptk.ap.api.back.bridge.dto.BridgeInDto;
import jp.co.futurenavigator.ptk.ap.api.back.bridge.dto.BridgeOutDto;

@Service
public class ReplyLogicBridgeService {
	//***********************************
	//後続APIエンドポイント一覧
	//***********************************
	/** シンプル応答ロジックAPIリクエストURL */
	private static final String LOGIC_REPLY_SIMPLE_URL = "http://localhost:8080/simpleReplyLogicImpl";
	/** シンプル応答ロジックAPIリクエストURL */
	private static final String LOGIC_GIVE_WANT_URL = "http://localhost:8080/giveWantLogicImpl";

	//***********************************
	//サービス設定
	//***********************************
	/** REST通信呼び出し用Bean設定 */
	@Autowired
	private RestTemplate gsonRestTemplate;

	@Autowired
	private RestTemplate stringRestTemplate;


	/**
	 * テキスト解析結果保存実行
	 * @param inDto 要求DTO
	 * @return 応答DTO
	 */
	@Transactional(readOnly = true)
	public BridgeOutDto saveChat(BridgeInDto inDto) {
		//応答ロジック呼び出し
		BridgeOutDto outDto = gsonRestTemplate.postForObject(LOGIC_REPLY_SIMPLE_URL, inDto, BridgeOutDto.class);


//		if(StringUtils.isNotEmpty(inDto.getInputTxt())) {
//			//応答ロジック呼び出し
//			String outTxt = stringRestTemplate.postForObject(LOGIC_GIVE_WANT_URL, inDto.getInputTxt(), String.class);
//		}

		return outDto;

	}
}
