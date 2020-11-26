package com.mmt.hitservice.model;

public class InputRequest {
	
	String url;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isParallel() {
		return isParallel;
	}
	public void setParallel(boolean isParallel) {
		this.isParallel = isParallel;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	boolean isParallel;
	String count;
	
}
