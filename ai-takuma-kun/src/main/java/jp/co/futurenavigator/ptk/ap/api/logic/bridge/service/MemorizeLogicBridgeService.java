package jp.co.futurenavigator.ptk.ap.api.logic.bridge.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futurenavigator.ptk.ap.api.back.bridge.dto.BridgeInDto;
import jp.co.futurenavigator.ptk.ap.api.back.bridge.dto.BridgeOutDto;

/**
 * 記憶サービス
 * @author naoka
 */
@Service
public class MemorizeLogicBridgeService {

	/**
	 * テキスト解析結果保存実行
	 * @param inDto 要求DTO
	 * @return 応答DTO
	 */
	@Transactional(readOnly = true)
	public BridgeOutDto saveChat(BridgeInDto dto) {
		BridgeOutDto outDto = new BridgeOutDto();
		return outDto;

	}
}
