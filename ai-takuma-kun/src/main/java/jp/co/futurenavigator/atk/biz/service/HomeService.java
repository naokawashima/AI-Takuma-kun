package jp.co.futurenavigator.atk.biz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import jp.co.futurenavigator.atk.dao.mapper.TtChatMapper;
import jp.co.futurenavigator.atk.dao.mapper.TtChatterMapper;
import jp.co.futurenavigator.atk.web.dto.HomeDto;
import jp.co.futurenavigator.atk.web.dto.HubInDto;
import jp.co.futurenavigator.atk.web.dto.HubOutDto;

@Component
public class HomeService {

	//***********************************
	//TableMapper
	//***********************************
	/** 話者 */
	@Autowired
	private TtChatterMapper ttChatterMapper;

	/** チャット履歴  */
	@Autowired
	private TtChatMapper ttChatMapper;

	/** REST通信呼び出し用Bean設定 */
	@Autowired
	@Qualifier("aiTtakumaKunHubApiRestTemplate")
	private RestTemplate restTemplate;

	/** 郵便番号検索API リクエストURL */
	private static final String URL = "http://localhost:8080/hub";

	/**
	 *
	 * @param dto
	 * @return
	 */
	@Transactional(readOnly = true)
	public HomeDto saveChat(HomeDto dto) {

		HubInDto inDto = new HubInDto();
		inDto.setYourName(dto.getYourName());
		inDto.setInputTxt(dto.getInputTxt());
		inDto.setBotName(dto.getBotName());
		inDto.setOutputTxt(dto.getOutputTxt());

		HubOutDto outDto = restTemplate.postForObject(URL, inDto, HubOutDto.class);

		dto.setYourName(outDto.getYourName());
		dto.setInputTxt(outDto.getInputTxt());
		dto.setBotName(outDto.getBotName());
		dto.setOutputTxt(outDto.getOutputTxt());

		return dto;
	}

}
