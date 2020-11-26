package com.mmt.hitservice.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HitServiceParallel {

	
	@Autowired
	RestTemplate restTemplate;
	
	
	@Async
	public CompletableFuture hitServiceInParallel(String url) {
		
		String response = restTemplate.getForObject(url, String.class);
		return CompletableFuture.completedFuture(response);
	}
}
