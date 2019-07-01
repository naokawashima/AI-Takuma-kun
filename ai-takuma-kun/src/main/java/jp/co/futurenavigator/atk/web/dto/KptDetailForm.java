package jp.co.futurenavigator.atk.web.dto;

import java.io.Serializable;

public class KptDetailForm implements Serializable {

	/** ケプター詳細ID */
	private String kptDetailId;
	/** KPT区分 */
	private String kptType;
	/** 内容 */
	private String kptText;
	/** ステータス */
	private String kptState;

	/** 配置情報 */
	private KptDetailPosForm kptDetailPos = new KptDetailPosForm();

	/**
	 * @return kptDetailId
	 */
	public String getKptDetailId() {
		return kptDetailId;
	}

	/**
	 * @param kptDetailId セットする kptDetailId
	 */
	public void setKptDetailId(String kptDetailId) {
		this.kptDetailId = kptDetailId;
	}

	/**
	 * @return kptType
	 */
	public String getKptType() {
		return kptType;
	}

	/**
	 * @param kptType セットする kptType
	 */
	public void setKptType(String kptType) {
		this.kptType = kptType;
	}

	/**
	 * @return kptText
	 */
	public String getKptText() {
		return kptText;
	}

	/**
	 * @param kptText セットする kptText
	 */
	public void setKptText(String kptText) {
		this.kptText = kptText;
	}

	/**
	 * @return kptState
	 */
	public String getKptState() {
		return kptState;
	}

	/**
	 * @param kptState セットする kptState
	 */
	public void setKptState(String kptState) {
		this.kptState = kptState;
	}

	/**
	 * @return kptDetailPos
	 */
	public KptDetailPosForm getKptDetailPos() {
		return kptDetailPos;
	}

	/**
	 * @param kptDetailPos セットする kptDetailPos
	 */
	public void setKptDetailPos(KptDetailPosForm kptDetailPos) {
		this.kptDetailPos = kptDetailPos;
	}

}
