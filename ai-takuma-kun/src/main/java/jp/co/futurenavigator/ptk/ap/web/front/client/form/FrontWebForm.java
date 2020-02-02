/**
 *
 */
package jp.co.futurenavigator.ptk.ap.web.front.client.form;

import lombok.Data;

/**
 * @author naoka
 *
 */
@Data
public class FrontWebForm {

	/** 入力者名 */
	private String yourName ;

	/** 入力テキスト*/
	private String inputTxt;

	/** ボット名 */
	private String botName;

	/** 出力テキスト*/
	private String outputTxt;


}
