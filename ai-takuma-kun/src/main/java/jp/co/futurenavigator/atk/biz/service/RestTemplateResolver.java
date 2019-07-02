/**
 *
 */
package jp.co.futurenavigator.atk.biz.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author naoka
 *
 */
@Component
public class RestTemplateResolver {

	/**
	 * RESTテンプレートのDI用Bean定義
	 * @return
	 */
	@Bean
	public RestTemplate aiTtakumaKunHubApiRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		//		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		GsonHttpMessageConverter messageConverter = new GsonHttpMessageConverter();

		List<MediaType> supportedMediaTypes = new ArrayList<>(messageConverter.getSupportedMediaTypes());
		supportedMediaTypes.add(MediaType.APPLICATION_JSON); // application/json
		messageConverter.setSupportedMediaTypes(supportedMediaTypes);
		restTemplate.setMessageConverters(Collections.singletonList(messageConverter)); // カスタムしたHttpMessageConverterを適用
		return restTemplate;
	}
}
