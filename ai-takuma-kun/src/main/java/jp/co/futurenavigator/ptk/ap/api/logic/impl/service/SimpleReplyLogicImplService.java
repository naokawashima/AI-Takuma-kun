package jp.co.futurenavigator.ptk.ap.api.logic.impl.service;

import java.util.List;
import java.util.Random;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futurenavigator.ptk.ap.api.back.bridge.dto.BridgeInDto;
import jp.co.futurenavigator.ptk.ap.api.back.bridge.dto.BridgeOutDto;
import jp.co.futurenavigator.ptk.dao.mapper.TtChatMapper;
import jp.co.futurenavigator.ptk.dao.mapper.TtChatterMapper;
import jp.co.futurenavigator.ptk.dao.model.TtChat;
import jp.co.futurenavigator.ptk.dao.model.TtChatCondition;
import jp.co.futurenavigator.ptk.dao.model.TtChatter;
import jp.co.futurenavigator.ptk.dao.model.TtChatterCondition;

@Service
public class SimpleReplyLogicImplService {

	//***********************************
	//TableMapper
	//***********************************
	/** 話者 */
	@Autowired
	private TtChatterMapper ttChatterMapper;
	/** チャット履歴  */
	@Autowired
	private TtChatMapper ttChatMapper;


	@Transactional(readOnly = true)
	public BridgeOutDto saveChat(BridgeInDto dto) {

		BridgeOutDto outDto = new BridgeOutDto();
		if (StringUtils.isEmpty(dto.getYourName()) || StringUtils.isEmpty(dto.getBotName())) {
			return 	outDto;
		}else {
			outDto.setYourName(dto.getYourName());
			outDto.setBotName(dto.getBotName());
		}

		//話者情報取得（あなた）
		TtChatterCondition youChatterCond = new TtChatterCondition();
		youChatterCond.createCriteria().andChatterNameLike(dto.getYourName());
		List<TtChatter> youList = ttChatterMapper.selectByExample(youChatterCond);
		TtChatter you = new TtChatter();
		if (CollectionUtils.isNotEmpty(youList)) {
			you = youList.get(0);
		} else {
			//新規話者の場合、登録
			you.setChatterName(dto.getYourName());
			int chatterId = ttChatterMapper.insertSelectiveReturnedId(you);
			you.setChatterId(Long.valueOf(chatterId));
		}

		//話者情報取得（ボット）
		TtChatterCondition botChatterCond = new TtChatterCondition();
		botChatterCond.createCriteria().andChatterNameLike(dto.getBotName());
		List<TtChatter> botList = ttChatterMapper.selectByExample(botChatterCond);
		TtChatter bot = new TtChatter();
		if (CollectionUtils.isNotEmpty(botList)) {
			bot = botList.get(0);
		} else {
			//新規話者の場合、登録
			bot.setChatterName(dto.getYourName());
			int chatterId = ttChatterMapper.insertSelectiveReturnedId(bot);
			bot.setChatterId(Long.valueOf(chatterId));
		}

		//チャット履歴登録
		TtChat chat = new TtChat();
		chat.setChatText(dto.getInputTxt());
		chat.setChatterId(you.getChatterId());

		int chatId = ttChatMapper.insertSelectiveReturnedId(chat);
		chat.setChatId(Long.valueOf(chatId));

		//		応答作成
		TtChatCondition chatCond = new TtChatCondition();
		chatCond.createCriteria().andChatTextLike("%" + dto.getInputTxt() + "%");
		List<TtChat> chatList = ttChatMapper.selectByExample(chatCond);
		if (CollectionUtils.isNotEmpty(chatList) && chatList.size() > 1) {
			//複数取れたレコードの中から適当にチャット履歴のPK取得
			Long keyChatId = chatList.get(new Random().nextInt(chatList.size() - 1)).getChatId();

			//応答の候補を適当に取得
			TtChatCondition respChatCond = new TtChatCondition();

			respChatCond.createCriteria().andChatIdBetween(keyChatId + 1, keyChatId + 9);
			List<TtChat> respChatList = ttChatMapper.selectByExample(respChatCond);
			if (CollectionUtils.isNotEmpty(respChatList)) {
				//複数取れたレコードの中から適当にチャット履歴.文章を応答に設定
				outDto.setOutputTxt(respChatList.get(new Random().nextInt(respChatList.size())).getChatText());

				//応答をチャット履歴に登録
				TtChat respChat = new TtChat();
				respChat.setChatText(dto.getOutputTxt());
				respChat.setChatterId(Long.valueOf(bot.getChatterId()));

				ttChatMapper.insertSelectiveReturnedId(respChat);
			} else {
				outDto.setOutputTxt("");

			}
		} else {
			outDto.setOutputTxt("");
		}

		outDto.setInputTxt("");

		return outDto;
	}
}
