package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class WebClientRunner implements ApplicationRunner {

	@Autowired
	WebClient.Builder builder;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		WebClient webClient = builder.build();

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		Mono<String> helloResult = webClient.get().uri("http://localhost:8080/hello").retrieve()
				.bodyToMono(String.class);

		// subscribe 를 호출하면 실제 호출하여 값을 가져오게 된다.
		// 응답이 오면 콜백으로 함수가 호출이 되어진다.
		helloResult.subscribe(s -> {
			System.out.println(s);
			if (stopWatch.isRunning())
				stopWatch.stop();

			System.out.println(stopWatch.prettyPrint());
			stopWatch.start();

		});

		Mono<String> worldResult = webClient.get().uri("http://localhost:8080/world").retrieve()
				.bodyToMono(String.class);

		worldResult.subscribe(s -> {
			System.out.println(s);
			if (stopWatch.isRunning())
				stopWatch.stop();

			System.out.println(stopWatch.prettyPrint());
			stopWatch.start();

		});

	}

}
