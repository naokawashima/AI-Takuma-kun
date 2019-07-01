package jp.co.futurenavigator.atk.web.form;

import java.io.Serializable;

import jp.co.futurenavigator.atk.web.dto.KptDetailForm;
import jp.co.futurenavigator.atk.web.dto.KptForm;

public class KpterCreateForm  implements Serializable {

	//******************************************************
	//フィールド
	//******************************************************
	/** ケプター情報 */
	private KptForm kpt = new KptForm();

	/** ケプター詳細情報	 */
	private KptDetailForm kptDetail = new KptDetailForm();

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
	 * @return kptDetail
	 */
	public KptDetailForm getKptDetail() {
		return kptDetail;
	}

	/**
	 * @param kptDetail セットする kptDetail
	 */
	public void setKptDetail(KptDetailForm kptDetail) {
		this.kptDetail = kptDetail;
	}

}
