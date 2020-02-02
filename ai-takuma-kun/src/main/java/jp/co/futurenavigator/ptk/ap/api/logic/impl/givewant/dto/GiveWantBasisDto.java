package jp.co.futurenavigator.ptk.ap.api.logic.impl.givewant.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GiveWantBasisDto {

	//************************************************************************************************
	//フィールド
	//************************************************************************************************
	/** 出力欲求フラグ*/
	private Boolean outWantFlg;
	/** 出力欲求率*/
	private Double outWantRate;
	/** 出力欲求時間*/
	private Long outWantTerm;

	/** 直近出力日時*/
	private LocalDateTime lastReplyed;

	/** 入出力履歴 */
	private List<String> shortIOLog = new ArrayList<>();
	/** 出力履歴 */
	private Map<String, List<LocalDateTime>> shortOutputLog = new LinkedHashMap<>();
	/** 入力履歴 */
	private Map<String, List<LocalDateTime>> shortInputLog = new LinkedHashMap<>();


	/** 辞書 */
	private Map<String, SentenceDto> dictionary = new HashMap<>();

	//************************************************************************************************
	//アクセサメソッド
	//************************************************************************************************
	/**
	 * @return outWantFlg
	 */
	public Boolean getOutWantFlg() {
		return outWantFlg;
	}

	/**
	 * @param outWantFlg セットする outWantFlg
	 */
	public void setOutWantFlg(Boolean outWantFlg) {
		this.outWantFlg = outWantFlg;
	}

	/**
	 * @return outWantRate
	 */
	public Double getOutWantRate() {
		return outWantRate;
	}

	/**
	 * @param outWantRate セットする outWantRate
	 */
	public void setOutWantRate(Double outWantRate) {
		this.outWantRate = outWantRate;
	}

	/**
	 * @return outWantTerm
	 */
	public Long getOutWantTerm() {
		return outWantTerm;
	}

	/**
	 * @param outWantTerm セットする outWantTerm
	 */
	public void setOutWantTerm(Long outWantTerm) {
		this.outWantTerm = outWantTerm;
	}

	/**
	 * @return dictionary
	 */
	public Map<String, SentenceDto> getDictionary() {
		return dictionary;
	}

	/**
	 * @param dictionary セットする dictionary
	 */
	public void setDictionary(Map<String, SentenceDto> dictionary) {
		this.dictionary = dictionary;
	}

	/**
	 * @return lastReplyed
	 */
	public LocalDateTime getLastReplyed() {
		return lastReplyed;
	}

	/**
	 * @param lastReplyed セットする lastReplyed
	 */
	public void setLastReplyed(LocalDateTime lastReplyed) {
		this.lastReplyed = lastReplyed;
	}

	/**
	 * @return shortOutputLog
	 */
	public Map<String, List<LocalDateTime>> getShortOutputLog() {
		return shortOutputLog;
	}

	/**
	 * @param shortOutputLog セットする shortOutputLog
	 */
	public void setShortOutputLog(Map<String, List<LocalDateTime>> shortOutputLog) {
		this.shortOutputLog = shortOutputLog;
	}

	/**
	 * @return shortInputLog
	 */
	public Map<String, List<LocalDateTime>> getShortInputLog() {
		return shortInputLog;
	}

	/**
	 * @param shortInputLog セットする shortInputLog
	 */
	public void setShortInputLog(Map<String, List<LocalDateTime>> shortInputLog) {
		this.shortInputLog = shortInputLog;
	}

	/**
	 * @return shortIOLog
	 */
	public List<String> getShortIOLog() {
		return shortIOLog;
	}

	/**
	 * @param shortIOLog セットする shortIOLog
	 */
	public void setShortIOLog(List<String> shortIOLog) {
		this.shortIOLog = shortIOLog;
	}




}
