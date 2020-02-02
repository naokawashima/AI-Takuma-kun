package jp.co.futurenavigator.ptk.ap.api.logic.impl.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.futurenavigator.ptk.ap.api.logic.impl.givewant.dto.GiveWantBasisDto;
import jp.co.futurenavigator.ptk.ap.api.logic.impl.givewant.dto.SentenceDto;
import jp.co.futurenavigator.ptk.dao.mapper.TtChatMapper;
import jp.co.futurenavigator.ptk.dao.mapper.TtChatterMapper;

@Service
public class GiveWantLogicImplService {

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
	public String process(String input, GiveWantBasisDto basisDto) {
		String output = "";

		//**********************************************************************
		//入出力日時処理
		//**********************************************************************
		//入力受付日時
		LocalDateTime lastTalked = LocalDateTime.now();

		//直近出力日時
		LocalDateTime lastReplyed = basisDto.getLastReplyed();

		//**********************************************************************
		//履歴保存
		//**********************************************************************
		//入出力履歴
		List<String> shortIOLog = basisDto.getShortIOLog();
		shortIOLog.add(input);

		//入力履歴
		Map<String, List<LocalDateTime>> shortInputLog = basisDto.getShortInputLog();
		if (!shortInputLog.containsKey(input)) {
			shortInputLog.put(input, new ArrayList<>());
		}
		shortInputLog.get(input).add(lastTalked);

		//出力履歴
		Map<String, List<LocalDateTime>> shortOutputLog = basisDto.getShortOutputLog();

		//**********************************************************************
		//解析
		//**********************************************************************
		//辞書
		Map<String, SentenceDto> dictionary = basisDto.getDictionary();

		//辞書から入力と完全一致する単語を探す
		SentenceDto inWord = new SentenceDto();
		if (dictionary.containsKey(input)) {
			inWord = dictionary.get(input);
		} else {
			inWord.setSentence(input);
			dictionary.put(input, inWord);
		}

		//**********************************************************************
		//入力文章そのもの解析＆更新
		//**********************************************************************
		// 嫌悪フラグ*/
		Boolean hateFlg = false;

		// 属性情報更新：連続使用回数Map */
		Map<Long, Long> repeatCntMap = new HashMap<>();

		// 属性情報更新：応答時差（ミリ秒）Map */
		Map<Long, Long> delayTermMap = new HashMap<>();
		Long delayTerm = 0L;
		if (lastReplyed != null) {
			Long.valueOf(lastTalked.compareTo(lastReplyed));
		}
		if (!delayTermMap.containsKey(delayTerm)) {
			delayTermMap.put(delayTerm, 1L);
		} else {
			Long delayTermCnt = delayTermMap.get(delayTerm);
			delayTermCnt++;
			delayTermMap.put(delayTerm, delayTermCnt);
		}

		// 属性情報更新：併用単語既知回数Map */
		Map<Long, Long> knownCntMap = new HashMap<>();

		// 属性情報更新：併用単語同組合せ回数Map */
		Map<Long, Long> sameComboCntMap = new HashMap<>();

		//**********************************************************************
		//入力文章に対する既存辞書の各単語関係を解析＆更新
		//**********************************************************************
		//総単語数
		int totalWordCnt = MapUtils.size(dictionary);
		//併用単語数
		int relateWordCnt = 0;
		//入力文章包含回数（初期化）
		Long includeCnt = 0L;

		//単語情報更新
		for (Entry<String, SentenceDto> elem : dictionary.entrySet()) {
			//文
			String word = elem.getKey();
			//属性情報
			SentenceDto wordInfo = elem.getValue();

			//入力文章包含回数（更新）
			if (StringUtils.contains(word, input) || StringUtils.contains(input, word)) {
				//辞書内の単語の一部に一致する場合カウントアップ
				includeCnt++;
			}

			//*******************************************
			// 属性情報更新
			//*******************************************
			if (StringUtils.contains(word, input)) {
				//入力文章が辞書単語の一部の場合

				//属性情報更新処理呼び出し

			} else if (StringUtils.contains(input, word)) {
				//辞書単語が入力文章の一部の場合

				//属性情報更新処理呼び出し

				// 属性情報更新：出現回数
				Long totalUseCnt = wordInfo.getTotalUseCnt();
				totalUseCnt += StringUtils.countMatches(input, word);
				wordInfo.setTotalUseCnt(totalUseCnt);

				// 属性情報更新：欲求妨害回数*/
				Long disturbCnt = wordInfo.getDisturbCnt();
				if (basisDto.getOutWantFlg()) {
					//入力ほしくないときに入力受付した場合
					disturbCnt++;
					wordInfo.setDisturbCnt(disturbCnt);
				}

				// 属性情報更新：欲求妨害率(欲求妨害回数÷出現回数)*/
				Double disturbRate = BigDecimal.valueOf(disturbCnt).divide(BigDecimal.valueOf(totalUseCnt))
						.doubleValue();
				wordInfo.setDisturbRate(disturbRate);

				// 属性情報更新：単独出現回数*/
				Long soloUseCnt = wordInfo.getSoloUseCnt();
				if (StringUtils.equals(input, word)) {
					soloUseCnt++;
					wordInfo.setSoloUseCnt(soloUseCnt);
				}

				// 属性情報更新：語頭回数*/
				Long headCnt = wordInfo.getHeadCnt();
				if (StringUtils.startsWith(input, word)) {
					headCnt++;
					wordInfo.setHeadCnt(headCnt);
				}

				// 属性情報更新：中間回数*/
				Long midCnt = wordInfo.getMidCnt();
				if (!StringUtils.startsWith(input, word)
						&& !StringUtils.endsWith(input, word)) {
					midCnt++;
					wordInfo.setMidCnt(midCnt);
				}

				// 属性情報更新：語末回数*/
				Long tailCnt = wordInfo.getTailCnt();
				if (StringUtils.endsWith(input, word)) {
					tailCnt++;
					wordInfo.setTailCnt(tailCnt);
				}

				// 属性情報更新：直近使用日時 */
				LocalDateTime lastUsed = lastTalked;
				wordInfo.setLastUsed(lastUsed);
			}

		}

		// 属性情報更新：対総単語併率(=無作為率) */
		Double noDirectionRate = BigDecimal.valueOf(includeCnt).divide(BigDecimal.valueOf(totalWordCnt)).doubleValue();
		inWord.setNoDirectionRate(noDirectionRate);

		return reply(input, basisDto);
	}

	public String reply(String input, GiveWantBasisDto basisDto) {
		String output = "text";

		//辞書
		Map<String, SentenceDto> dictionary = basisDto.getDictionary();

		return output;
	}
}
