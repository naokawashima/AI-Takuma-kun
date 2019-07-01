package jp.co.futurenavigator.atk.web.dto;

import java.io.Serializable;

public class KptTypeDto implements Serializable {

	public KptTypeDto() {	}

	public KptTypeDto(String id ,String name) {
		this.id = id;
		this.name = name;
	}

	/** id */
	private String id;
	/** name */
	private String name ;
	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}




}
