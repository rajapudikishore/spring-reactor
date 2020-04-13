package com.reactiveapigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Schedulers;

@RestController
public class FluxController {
	
	WebClient webClient1 = WebClient.create("http://localhost:8091");
	WebClient webClient2 = WebClient.create("http://localhost:8092");
	WebClient webClient3 = WebClient.create("http://localhost:8093");
	WebClient webClient4 = WebClient.create("http://localhost:8094");
	WebClient webClient5 = WebClient.create("http://localhost:8095");

	@GetMapping(value="/ParallelFlux")
	public ParallelFlux<String> returnParallelFlux(){
		
		
		return Flux.merge(
				getStudent(webClient1,"1"),
				getStudent(webClient2,"2"),
				getStudent(webClient3,"3"),
				getStudent(webClient4,"4"),
				getStudent(webClient5,"5")
				).parallel(5);
		        //.runOn(Schedulers.elastic());
				//.runOn(Schedulers.boundedElastic());
				//.runOn(Schedulers.newBoundedElastic(int threadCap, int queuedTaskCap, String name, int ttlSeconds));
				//.runOn(Schedulers.newBoundedElastic(5, 50000, "student", 10));
				
	}
	
	private Mono<String> getStudent(WebClient webClient, String rollno){
		return webClient.get().uri("/api/student/"+rollno)
                .retrieve()
                .bodyToMono(String.class);
		
	}
	
	@GetMapping(value="/flux")
	public Flux<String> returnFlux(){
		
				Flux<String> flux1 = webClient1.get().uri("/api/student/1")
						  .retrieve()
						  .bodyToFlux(String.class);
				
				Flux<String> flux2 = webClient2.get().uri("/api/student/2")
				  .retrieve()
				  .bodyToFlux(String.class);
				
				Flux<String> flux3 = webClient3.get().uri("/api/student/3")
				  .retrieve()
				  .bodyToFlux(String.class);
				
				Flux<String> flux4 = webClient4.get().uri("/api/student/4")
				  .retrieve()
				  .bodyToFlux(String.class);
				
				Flux<String> flux5 = webClient5.get().uri("/api/student/5")
				  .retrieve()
				  .bodyToFlux(String.class);
				
				return Flux.concat(flux1,flux2,flux3,flux4,flux5);
		
		
	}

	
}
