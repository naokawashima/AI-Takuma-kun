package jp.co.futurenavigator.ptk.ap.api.front.bridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import jp.co.futurenavigator.ptk.ap.api.back.bridge.dto.BridgeInDto;
import jp.co.futurenavigator.ptk.ap.api.back.bridge.dto.BridgeOutDto;

/**
 * フロントエンド側ブリッジサービス
 * 音声、画像、映像、テキストなどの各種インプットを処理可能なテキストに変換して後続のバックエンド側ブリッジ処理に変換結果を引き渡す
 * @author naoka
 */
@Service
public class FrontBridgeService {

	//***********************************
	//後続APIエンドポイント一覧
	//***********************************
	/** バック側ブリッジAPIリクエストURL */
	private static final String URL = "http://localhost:8080/backBridge";

	//***********************************
	//サービス設定
	//***********************************
	/** REST通信呼び出し用Bean設定 */
	@Autowired
	private RestTemplate gsonRestTemplate;

	/**
	 *
	 * @param dto
	 * @return
	 */
	@Transactional(readOnly = true)
	public BridgeOutDto saveChat(BridgeInDto inDto) {

		BridgeOutDto outDto = gsonRestTemplate.postForObject(URL, inDto, BridgeOutDto.class);

		return outDto;
	}
}
