/**
 *
 */
package jp.co.futurenavigator.ptk.fw.gateway;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * REST通信ゲートウェイDI設定クラス
 *
 * @author naoka
 */
@Component
public class RestTemplateResolver {

	/**
	 * RESTテンプレートのDI用Bean定義(GSON用)
	 * @return
	 */
	@Bean
	public RestTemplate gsonRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();

		//メッセージコンバータ設定：GSONを仕様（jsonのGoogle拡張書式、JSONは本来UTF-8のみだが、GSONではUTF-8以外にも対応）
		GsonHttpMessageConverter messageConverter = new GsonHttpMessageConverter();

		//要求・応答をサポートするメディアのタイプ設定
		List<MediaType> supportedMediaTypes = new ArrayList<>(messageConverter.getSupportedMediaTypes());
		supportedMediaTypes.add(MediaType.APPLICATION_JSON); // application/json
		messageConverter.setSupportedMediaTypes(supportedMediaTypes);

		//上記で設定したHttpMessageConverterを適用
		restTemplate.setMessageConverters(Collections.singletonList(messageConverter));

		return restTemplate;
	}


	/**
	 * RESTテンプレートのDI用Bean定義（String用）
	 * @return
	 */
	@Bean
	public RestTemplate stringRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();

		//メッセージコンバータ設定：GSONを仕様（jsonのGoogle拡張書式、JSONは本来UTF-8のみだが、GSONではUTF-8以外にも対応）
		StringHttpMessageConverter messageConverter = new StringHttpMessageConverter(StandardCharsets.UTF_8);

		//要求・応答をサポートするメディアのタイプ設定
		List<MediaType> supportedMediaTypes = new ArrayList<>(messageConverter.getSupportedMediaTypes());
		supportedMediaTypes.add(MediaType.TEXT_PLAIN); // application/json
		messageConverter.setSupportedMediaTypes(supportedMediaTypes);

		//上記で設定したHttpMessageConverterを適用
		restTemplate.setMessageConverters(Collections.singletonList(messageConverter));

		return restTemplate;
	}

}
