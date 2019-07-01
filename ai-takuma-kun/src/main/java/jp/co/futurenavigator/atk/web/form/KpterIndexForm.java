package jp.co.futurenavigator.atk.web.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jp.co.futurenavigator.atk.web.dto.KptForm;

public class KpterIndexForm implements Serializable {

	//******************************************************
	//フィールド
	//******************************************************
	/** ケプター情報 */
	private List<KptForm> kptList = new ArrayList<>();

	//******************************************************
	//アクセサメソッド
	//******************************************************
	/**
	 * @return kptList
	 */
	public List<KptForm> getKptList() {
		return kptList;
	}

	/**
	 * @param kptList セットする kptList
	 */
	public void setKptList(List<KptForm> kptList) {
		this.kptList = kptList;
	}

}
