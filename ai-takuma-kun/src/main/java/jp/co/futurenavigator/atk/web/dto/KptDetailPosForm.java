package jp.co.futurenavigator.atk.web.dto;

import java.io.Serializable;

public class KptDetailPosForm  implements Serializable{


	/** ケプター詳細位置ID */
	private String kptDetailPosId;
	/** 水平位置 */
	private String kptPosX;
	/** 垂直位置 */
	private String kptPosY;
	/** 前後位置 */
	private String kptPosZ;



	/**
	 * @return kptDetailPosId
	 */
	public String getKptDetailPosId() {
		return kptDetailPosId;
	}

	/**
	 * @param kptDetailPosId セットする kptDetailPosId
	 */
	public void setKptDetailPosId(String kptDetailPosId) {
		this.kptDetailPosId = kptDetailPosId;
	}

	/**
	 * @return kptPosX
	 */
	public String getKptPosX() {
		return kptPosX;
	}

	/**
	 * @param kptPosX セットする kptPosX
	 */
	public void setKptPosX(String kptPosX) {
		this.kptPosX = kptPosX;
	}

	/**
	 * @return kptPosY
	 */
	public String getKptPosY() {
		return kptPosY;
	}

	/**
	 * @param kptPosY セットする kptPosY
	 */
	public void setKptPosY(String kptPosY) {
		this.kptPosY = kptPosY;
	}

	/**
	 * @return kptPosZ
	 */
	public String getKptPosZ() {
		return kptPosZ;
	}

	/**
	 * @param kptPosZ セットする kptPosZ
	 */
	public void setKptPosZ(String kptPosZ) {
		this.kptPosZ = kptPosZ;
	}



}
