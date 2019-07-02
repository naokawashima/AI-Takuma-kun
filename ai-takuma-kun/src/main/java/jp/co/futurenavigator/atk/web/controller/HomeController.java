package jp.co.futurenavigator.atk.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.futurenavigator.atk.biz.service.HomeService;
import jp.co.futurenavigator.atk.web.dto.HomeDto;

@Controller
public class HomeController {

	@Autowired
	private HomeService homeService;

	/**
	 * 初期表示
	 * @return
	 */
	@RequestMapping("/home")
	public ModelAndView index(ModelAndView mv, @ModelAttribute HomeDto dto) {

		if(dto == null) {
			dto = new HomeDto();

			dto.setYourName("一見さん");
			dto.setInputTxt("");
			dto.setBotName("たくまくん");
			dto.setInputTxt("");
		}


		dto = homeService.saveChat(dto);

		mv.addObject("homeDto", dto);
		mv.setViewName("home");
		System.out.println("test");

		return mv;
	}

}