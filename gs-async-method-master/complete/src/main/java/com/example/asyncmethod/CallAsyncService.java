package com.example.asyncmethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class CallAsyncService {

	private static final Logger logger = LoggerFactory.getLogger(CallAsyncService.class);

	private final RestTemplate restTemplate;

	public CallAsyncService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@Async
	public CompletableFuture<String> findUser(String port, String user) throws InterruptedException {
		String url = "http://localhost:"+port+"/api/student/"+user;
		String results = restTemplate.getForObject(url, String.class);
		return CompletableFuture.completedFuture(results);
	}

}
