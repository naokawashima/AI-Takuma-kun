/**
 *
 */
package jp.co.futurenavigator.ptk.ap.api.back.bridge.dto;

import lombok.Data;

/**
 * @author naoka
 *
 */
@Data
public class BridgeOutDto {

	/** 入力者名 */
	private String yourName ;

	/** 入力テキスト*/
	private String inputTxt;

	/** ボット名 */
	private String botName;

	/** 出力テキスト*/
	private String outputTxt;


}
