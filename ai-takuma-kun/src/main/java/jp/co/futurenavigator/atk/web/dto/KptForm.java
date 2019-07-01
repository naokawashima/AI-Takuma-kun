package jp.co.futurenavigator.atk.web.dto;

import java.io.Serializable;

public class KptForm implements Serializable {

	//******************************************************
	//フィールド
	//******************************************************
	/** ケプターID */
	private String kptId;

	//******************************************************
	//アクセサメソッド
	//******************************************************
	/**
	 * @return kptId
	 */
	public String getKptId() {
		return kptId;
	}

	/**
	 * @param kptId セットする kptId
	 */
	public void setKptId(String kptId) {
		this.kptId = kptId;
	}

}
