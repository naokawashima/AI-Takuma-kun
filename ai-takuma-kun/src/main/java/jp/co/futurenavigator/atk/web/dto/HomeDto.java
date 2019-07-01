/**
 *
 */
package jp.co.futurenavigator.atk.web.dto;

import lombok.Data;

/**
 * @author naoka
 *
 */
@Data
public class HomeDto {

	/** 入力者名 */
	private String yourName ;

	/** 入力テキスト*/
	private String inputTxt;

	/** ボット名 */
	private String botName;

	/** 出力テキスト*/
	private String outputTxt;

	/**
	 * @return yourName
	 */
	public String getYourName() {
		return yourName;
	}

	/**
	 * @param yourName セットする yourName
	 */
	public void setYourName(String yourName) {
		this.yourName = yourName;
	}

	/**
	 * @return inputTxt
	 */
	public String getInputTxt() {
		return inputTxt;
	}

	/**
	 * @param inputTxt セットする inputTxt
	 */
	public void setInputTxt(String inputTxt) {
		this.inputTxt = inputTxt;
	}

	/**
	 * @return botName
	 */
	public String getBotName() {
		return botName;
	}

	/**
	 * @param botName セットする botName
	 */
	public void setBotName(String botName) {
		this.botName = botName;
	}

	/**
	 * @return outputTxt
	 */
	public String getOutputTxt() {
		return outputTxt;
	}

	/**
	 * @param outputTxt セットする outputTxt
	 */
	public void setOutputTxt(String outputTxt) {
		this.outputTxt = outputTxt;
	}







}
