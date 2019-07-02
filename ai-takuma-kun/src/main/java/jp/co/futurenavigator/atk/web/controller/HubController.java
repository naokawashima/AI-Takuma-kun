package jp.co.futurenavigator.atk.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.futurenavigator.atk.biz.service.HubService;
import jp.co.futurenavigator.atk.web.dto.HubInDto;
import jp.co.futurenavigator.atk.web.dto.HubOutDto;

@RequestMapping("/hub")
@RestController
public class HubController {

	/** REST通信呼び出し用Bean設定 */
	@Autowired
	private HubService hubService;

	//	 @RequestMapping(method = RequestMethod.GET)
	//	    public HubOutDto getUsers() {
	//	        return hubService.saveChat(inDto);
	//	    }
	//
	//	    @RequestMapping(method=RequestMethod.GET, value="{id}")
	//	    public HubOutDto getUser(@PathVariable("id") Long id) {
	//	        return hubService.saveChat(inDto);
	//	    }

	/**
	 * 登録
	 * @param inDto
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public HubOutDto createUser(@Validated @RequestBody HubInDto inDto) {
		return hubService.saveChat(inDto);
	}

	/**
	 * 更新
	 * @param inDto
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public HubOutDto updateUser(@RequestBody HubInDto inDto) {
		return hubService.saveChat(inDto);
	}

	//	    @RequestMapping(method=RequestMethod.DELETE, value="{id}")
	//	    public HubOutDto deleteUser(@PathVariable("id") Long id) {
	//	        userService.delete(id);
	//	    }

}