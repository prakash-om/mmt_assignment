package com.mmt.hitservice.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.hitservice.model.InputRequest;
import com.mmt.hitservice.service.HitAnalyzerService;


@RestController
public class ThridPartyServiceRequestController {

	
	@Autowired
	HitAnalyzerService hitAnalyzerService;
	
	@RequestMapping(value = "/hitService", method = RequestMethod.POST)
	public ResponseEntity hitService(@RequestBody InputRequest[] inputRequests) throws InterruptedException, ExecutionException {
		
		
		long timeTake = hitAnalyzerService.analyze(inputRequests);
		
		return new ResponseEntity<String>("Time Taken is "+timeTake+" ms",HttpStatus.OK);
		
	}
	
}
