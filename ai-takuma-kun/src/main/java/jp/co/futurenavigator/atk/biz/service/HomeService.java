package jp.co.futurenavigator.atk.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futurenavigator.atk.dao.mapper.TtChatMapper;
import jp.co.futurenavigator.atk.dao.model.TtChat;
import jp.co.futurenavigator.atk.dao.model.TtChatCondition;
import jp.co.futurenavigator.atk.dao.model.TtChatKey;


@Component
public class HomeService {

	//***********************************
	//TableMapper
	//***********************************
	/** ケプター  */
	@Autowired
	private TtChatMapper thChatMapper;

	@Transactional(readOnly = true)
	public List<TtChat> getKpterList(Long kptId) {

		//絞込条件
		TtChatCondition condition = new TtChatCondition();

		if (kptId != null) {
			condition.createCriteria();
		} else {
			condition.createCriteria();
			TtChatKey key = new TtChatKey();
		}

		List<TtChat> kptList = thChatMapper.selectByExample(condition);

		return kptList;
	}

	@Transactional
	public TtChat saveKpterDetailPos(TtChat record) {

		int saveCnt = thChatMapper.updateByPrimaryKeySelective(record);

		if (saveCnt < 1) {
			int chatId = thChatMapper.insertSelectiveReturnedId(record);
			record.setChatId(Long.valueOf(chatId));
		}

		return record;
	}

}
