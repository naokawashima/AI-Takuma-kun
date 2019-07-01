package jp.co.futurenavigator.atk.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.co.futurenavigator.atk.biz.service.HomeService;
import jp.co.futurenavigator.atk.dao.model.TtChat;
import jp.co.futurenavigator.atk.web.form.EmployeeForm;

@Controller
public class HomeController {

	@Autowired
	private HomeService homeService;

	/**
	 * 初期表示
	 * @return
	 */
	@RequestMapping("/home")
	public ModelAndView index(ModelAndView mv) {
		EmployeeForm form = new EmployeeForm();
		form.setId("1");
		form.setName("Ken");
		form.setEmail("ken@mail.coml");

		TtChat record = new TtChat();
		record.setTalkerId(0L);
		record.setChatText("");
		record = homeService.saveKpterDetailPos(record);

		mv.addObject("employeeForm", form);
		mv.setViewName("home");
		System.out.println("test");

		return mv;
	}
}