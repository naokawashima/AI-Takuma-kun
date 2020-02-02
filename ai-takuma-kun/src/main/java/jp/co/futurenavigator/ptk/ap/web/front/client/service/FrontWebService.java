package jp.co.futurenavigator.ptk.ap.web.front.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import jp.co.futurenavigator.ptk.ap.api.back.bridge.dto.BackBridgeInDto;
import jp.co.futurenavigator.ptk.ap.api.back.bridge.dto.BackBridgeOutDto;
import jp.co.futurenavigator.ptk.ap.web.front.client.form.FrontWebForm;

@Component
public class FrontWebService {

	//***********************************
	//サービス設定
	//***********************************
	/** REST通信呼び出し用Bean設定 */
	@Autowired
	private RestTemplate gsonRestTemplate;

	/** ブリッジAPIリクエストURL */
	private static final String URL = "http://localhost:8080/frontBridge";

	/**
	 *
	 * @param dto
	 * @return
	 */
	@Transactional(readOnly = true)
	public FrontWebForm saveChat(FrontWebForm form) {

		BackBridgeInDto inDto = new BackBridgeInDto();
		inDto.setYourName(form.getYourName());
		inDto.setInputTxt(form.getInputTxt());
		inDto.setBotName(form.getBotName());
		inDto.setOutputTxt(form.getOutputTxt());

		BackBridgeOutDto outDto = gsonRestTemplate.postForObject(URL, inDto, BackBridgeOutDto.class);

		form.setYourName(outDto.getYourName());
		form.setInputTxt(outDto.getInputTxt());
		form.setBotName(outDto.getBotName());
		form.setOutputTxt(outDto.getOutputTxt());

		return form;
	}

}
