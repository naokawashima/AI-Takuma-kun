package jp.co.futurenavigator.ptk.ap.api.logic.bridge.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futurenavigator.ptk.ap.api.back.bridge.dto.BridgeInDto;
import jp.co.futurenavigator.ptk.ap.api.back.bridge.dto.BridgeOutDto;

/**
 * テキスト解析サービス
 * @author naoka
 */
@Service
public class AnalizeLogicBridgeService {

	/**
	 * テキスト解析実行
	 * @param inDto 要求DTO
	 * @return 応答DTO
	 */
	@Transactional(readOnly = true)
	public BridgeOutDto saveChat(BridgeInDto inDto) {
		BridgeOutDto outDto = new BridgeOutDto();
		return outDto;

	}
}
