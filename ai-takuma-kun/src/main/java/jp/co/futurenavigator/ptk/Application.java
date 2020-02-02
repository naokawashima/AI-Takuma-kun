package jp.co.futurenavigator.ptk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	/**
	 * アプリケーションの起点となるMainクラス.
	 * このクラスが格納されているパッケージよりも下の階層のクラスはAutowired対象としてComponentScanがかかる。
	 * @author naoka
	 *
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
