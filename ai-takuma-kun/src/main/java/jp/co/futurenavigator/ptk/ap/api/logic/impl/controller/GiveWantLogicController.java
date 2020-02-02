package jp.co.futurenavigator.ptk.ap.api.logic.impl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.futurenavigator.ptk.ap.api.logic.impl.givewant.dto.GiveWantBasisDto;
import jp.co.futurenavigator.ptk.ap.api.logic.impl.service.GiveWantLogicImplService;

@RequestMapping("/giveWantLogicImpl")
@RestController
public class GiveWantLogicController {

	/** 基盤DTO */
	private GiveWantBasisDto basisDto = new GiveWantBasisDto();

	/** REST通信呼び出し用Bean設定 */
	@Autowired
	private GiveWantLogicImplService service;

	/**
	 * 登録
	 * @param inDto 要求DTO
	 * @return 応答DTO
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String post(@Validated @RequestBody String input) {
		return service.process(input, basisDto);
	}

	/**
	 * 更新
	 * @param inDto 要求DTO
	 * @return 応答DTO
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public String put(@RequestBody String input) {
		return service.process(input, basisDto);
	}

}