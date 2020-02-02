package jp.co.futurenavigator.ptk.ap.api.logic.impl.givewant.dto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class SentenceDto {

	//************************************************************************************************
	//フィールド
	//************************************************************************************************
	/** 文 */
	private String sentence;

	/** 嫌悪フラグ*/
	private Boolean hateFlg = false;

	/** 出現回数*/
	private Long totalUseCnt = 0L;

	/** 単独出現回数*/
	private Long soloUseCnt;

	/** 語頭回数*/
	private Long headCnt;

	/** 中間回数*/
	private Long midCnt;

	/** 語末回数*/
	private Long tailCnt;

	/** 欲求妨害回数*/
	private Long disturbCnt = 0L;

	/** 欲求妨害率*/
	private Double disturbRate = 0.0;

	/** 直近使用日時 */
	private LocalDateTime lastUsed = LocalDateTime.now();

	/** 連続使用回数Map */
	private Map<Long, Long> repeatCntMap = new HashMap<>();

	/** 応答時差（ミリ秒）Map */
	private Map<Long, Long> delayTermMap = new HashMap<>();

	/** 併用単語既知回数Map */
	private Map<Long, Long> knownCntMap = new HashMap<>();

	/** 併用単語同組合せ回数Map */
	private Map<Long, Long> sameComboCntMap = new HashMap<>();

	/** 対総単語併率(=無作為率) */
	private Double noDirectionRate = 0.0;

	//************************************************************************************************
	//アクセサメソッド
	//************************************************************************************************
	/**
	 * @return sentence
	 */
	public String getSentence() {
		return sentence;
	}

	/**
	 * @param sentence セットする sentence
	 */
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	/**
	 * @return hateFlg
	 */
	public Boolean getHateFlg() {
		return hateFlg;
	}

	/**
	 * @param hateFlg セットする hateFlg
	 */
	public void setHateFlg(Boolean hateFlg) {
		this.hateFlg = hateFlg;
	}

	/**
	 * @return totalUseCnt
	 */
	public Long getTotalUseCnt() {
		return totalUseCnt;
	}

	/**
	 * @param totalUseCnt セットする totalUseCnt
	 */
	public void setTotalUseCnt(Long totalUseCnt) {
		this.totalUseCnt = totalUseCnt;
	}

	/**
	 * @return soloUseCnt
	 */
	public Long getSoloUseCnt() {
		return soloUseCnt;
	}

	/**
	 * @param soloUseCnt セットする soloUseCnt
	 */
	public void setSoloUseCnt(Long soloUseCnt) {
		this.soloUseCnt = soloUseCnt;
	}

	/**
	 * @return headCnt
	 */
	public Long getHeadCnt() {
		return headCnt;
	}

	/**
	 * @param headCnt セットする headCnt
	 */
	public void setHeadCnt(Long headCnt) {
		this.headCnt = headCnt;
	}

	/**
	 * @return midCnt
	 */
	public Long getMidCnt() {
		return midCnt;
	}

	/**
	 * @param midCnt セットする midCnt
	 */
	public void setMidCnt(Long midCnt) {
		this.midCnt = midCnt;
	}

	/**
	 * @return tailCnt
	 */
	public Long getTailCnt() {
		return tailCnt;
	}

	/**
	 * @param tailCnt セットする tailCnt
	 */
	public void setTailCnt(Long tailCnt) {
		this.tailCnt = tailCnt;
	}

	/**
	 * @return disturbCnt
	 */
	public Long getDisturbCnt() {
		return disturbCnt;
	}

	/**
	 * @param disturbCnt セットする disturbCnt
	 */
	public void setDisturbCnt(Long disturbCnt) {
		this.disturbCnt = disturbCnt;
	}

	/**
	 * @return disturbRate
	 */
	public Double getDisturbRate() {
		return disturbRate;
	}

	/**
	 * @param disturbRate セットする disturbRate
	 */
	public void setDisturbRate(Double disturbRate) {
		this.disturbRate = disturbRate;
	}

	/**
	 * @return lastUsed
	 */
	public LocalDateTime getLastUsed() {
		return lastUsed;
	}

	/**
	 * @param lastUsed セットする lastUsed
	 */
	public void setLastUsed(LocalDateTime lastUsed) {
		this.lastUsed = lastUsed;
	}

	/**
	 * @return repeatCntMap
	 */
	public Map<Long, Long> getRepeatCntMap() {
		return repeatCntMap;
	}

	/**
	 * @param repeatCntMap セットする repeatCntMap
	 */
	public void setRepeatCntMap(Map<Long, Long> repeatCntMap) {
		this.repeatCntMap = repeatCntMap;
	}

	/**
	 * @return delayTermMap
	 */
	public Map<Long, Long> getDelayTermMap() {
		return delayTermMap;
	}

	/**
	 * @param delayTermMap セットする delayTermMap
	 */
	public void setDelayTermMap(Map<Long, Long> delayTermMap) {
		this.delayTermMap = delayTermMap;
	}

	/**
	 * @return knownCntMap
	 */
	public Map<Long, Long> getKnownCntMap() {
		return knownCntMap;
	}

	/**
	 * @param knownCntMap セットする knownCntMap
	 */
	public void setKnownCntMap(Map<Long, Long> knownCntMap) {
		this.knownCntMap = knownCntMap;
	}

	/**
	 * @return sameComboCntMap
	 */
	public Map<Long, Long> getSameComboCntMap() {
		return sameComboCntMap;
	}

	/**
	 * @param sameComboCntMap セットする sameComboCntMap
	 */
	public void setSameComboCntMap(Map<Long, Long> sameComboCntMap) {
		this.sameComboCntMap = sameComboCntMap;
	}

	/**
	 * @return noDirectionRate
	 */
	public Double getNoDirectionRate() {
		return noDirectionRate;
	}

	/**
	 * @param noDirectionRate セットする noDirectionRate
	 */
	public void setNoDirectionRate(Double noDirectionRate) {
		this.noDirectionRate = noDirectionRate;
	}

}
