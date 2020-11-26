package com.mmt.hitservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HitService {
	
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HitServiceParallel hitServiceParallel;
	
	
	public void hitSeqentailService(String url, String count) {
		
		long stTime = System.currentTimeMillis();
		for(int i = 0; i < Integer.parseInt(count); i++) {
			
			long startTime = System.currentTimeMillis();
			restTemplate.getForObject(url, String.class);
			long endTime = System.currentTimeMillis();
			System.out.println("Time Taken to run sequentail call : " +  (endTime - startTime));
		}
		
		System.out.println("Time Taken to run all 3 sequentail call "+ (System.currentTimeMillis() - stTime));
		
	}
	
	public void hitParallelService(String url, String count) throws InterruptedException, ExecutionException {
		
		long stTime = System.currentTimeMillis();
		List<CompletableFuture> list = new ArrayList<>();
		
		for(int i = 0; i < Integer.parseInt(count); i++) {
			
			long startTime = System.currentTimeMillis();
			list.add(hitServiceParallel.hitServiceInParallel(url));
			long endTime = System.currentTimeMillis();
			System.out.println("Time Taken to run parallel call : " +  (endTime - startTime));
			
		}

		list.get(list.size() - 1).get();
		System.out.println("Time taken to run all 3 parallel call is "+(System.currentTimeMillis() - stTime));
	}	
}
