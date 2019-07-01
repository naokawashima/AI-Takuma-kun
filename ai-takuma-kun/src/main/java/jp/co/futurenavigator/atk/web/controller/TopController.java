/**
 *
 */
package jp.co.futurenavigator.atk.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.futurenavigator.atk.dao.mapper.TtChatMapper;
import lombok.AllArgsConstructor;

/**
 * @author naoka
 *
 */

@RestController
@AllArgsConstructor
public class TopController {

	@Autowired
	private TtChatMapper ttChatMapper;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public Map hello() {
		Map<String, Object> res = new HashMap<>();
		res.put("response", "hello");
		return res;
	}

}
