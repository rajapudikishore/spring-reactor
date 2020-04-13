package com.example.asyncmethod;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {
	
	
	
	private final CallAsyncService callAsyncService;

	public AsyncController(CallAsyncService callAsyncService) {
		this.callAsyncService = callAsyncService;
	}
	
	
	@GetMapping(value="/async")
	public String async() throws InterruptedException, ExecutionException{
		
		// Kick of multiple, asynchronous lookups
		CompletableFuture<String> page1 = callAsyncService.findUser("8091","1");
		CompletableFuture<String> page2 = callAsyncService.findUser("8092","2");
		CompletableFuture<String> page3 = callAsyncService.findUser("8093","3");
		CompletableFuture<String> page4 = callAsyncService.findUser("8094","4");
		CompletableFuture<String> page5 = callAsyncService.findUser("8095","5");


		// Wait until they are all done
      	CompletableFuture.allOf(page1,page2,page3,page4,page5).join();
				
		return page1.get() + " || " + page2.get() + " || " + page3.get() + 
				page4.get() + " || " + page5.get() ;
	}
	
}


