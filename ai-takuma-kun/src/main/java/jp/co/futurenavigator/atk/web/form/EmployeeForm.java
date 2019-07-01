package jp.co.futurenavigator.atk.web.form;

import lombok.Data;

@Data
public class EmployeeForm {

    private String id            = "";
    private String name          = "";
    private String email         = "";
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
	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email セットする email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}

