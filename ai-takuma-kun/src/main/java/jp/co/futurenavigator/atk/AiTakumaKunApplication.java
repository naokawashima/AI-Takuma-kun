package jp.co.futurenavigator.atk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AiTakumaKunApplication {

	/**
	 * アプリケーションの起点となるMainクラス.
	 * このクラスが格納されているパッケージよりも下の階層のクラスはAutowired対象としてComponentScanがかかる。
	 * @author naoka
	 *
	 */
	public static void main(String[] args) {
		SpringApplication.run(AiTakumaKunApplication.class, args);
	}

}
