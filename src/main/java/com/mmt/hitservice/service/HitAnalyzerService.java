package com.mmt.hitservice.service;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmt.hitservice.model.InputRequest;

@Service
public class HitAnalyzerService {

	@Autowired
	HitService hitService;

	public long analyze(InputRequest[] inputRequests) throws InterruptedException, ExecutionException {

		long startTime = System.currentTimeMillis();

		for (InputRequest inputRequest : inputRequests) {

			if (inputRequest.isParallel()) {
				
				hitService.hitParallelService(inputRequest.getUrl(), inputRequest.getCount());

			} else {

				

				hitService.hitSeqentailService(inputRequest.getUrl(), inputRequest.getCount());

			}

		}

		long endTime = System.currentTimeMillis();

		return endTime - startTime;

	}
}
