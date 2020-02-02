package jp.co.futurenavigator.ptk.ap.web.front.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.futurenavigator.ptk.ap.web.front.client.form.FrontWebForm;
import jp.co.futurenavigator.ptk.ap.web.front.client.service.FrontWebService;

@Controller
public class FrontWebController {

	@Autowired
	private FrontWebService service;

	/**
	 * 初期表示
	 * @return
	 */
	@RequestMapping("/frontWeb")
	public ModelAndView index(ModelAndView mv, @ModelAttribute FrontWebForm form) {

		if(form == null) {
			form = new FrontWebForm();
			form.setYourName("一見さん");
			form.setInputTxt("");
			form.setBotName("たくまくん");
			form.setInputTxt("");
		}else {
			form = service.saveChat(form);
		}



		mv.addObject("frontWebForm", form);
		mv.setViewName("frontWeb");

		return mv;
	}

}