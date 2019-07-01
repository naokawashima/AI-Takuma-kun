package jp.co.futurenavigator.atk.web.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jp.co.futurenavigator.atk.web.dto.KptDetailForm;
import jp.co.futurenavigator.atk.web.dto.KptForm;

public class KpterUpdateForm implements Serializable {

	//******************************************************
	//フィールド
	//******************************************************
	/** ケプター情報 */
	private KptForm kpt = new KptForm();

	/** ケプター詳細情報List	 */
	private List<KptDetailForm> kptDetailList = new ArrayList<>();

	//******************************************************
	//アクセサメソッド
	//******************************************************
	/**
	 * @return kpt
	 */
	public KptForm getKpt() {
		return kpt;
	}

	/**
	 * @param kpt セットする kpt
	 */
	public void setKpt(KptForm kpt) {
		this.kpt = kpt;
	}

	/**
	 * @return kptDetailList
	 */
	public List<KptDetailForm> getKptDetailList() {
		return kptDetailList;
	}

	/**
	 * @param kptDetailList セットする kptDetailList
	 */
	public void setKptDetailList(List<KptDetailForm> kptDetailList) {
		this.kptDetailList = kptDetailList;
	}



}
