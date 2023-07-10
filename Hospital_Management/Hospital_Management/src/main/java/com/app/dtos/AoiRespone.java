package com.app.dtos;

import java.time.LocalDateTime;

public class AoiRespone {

	private String msg;
	private LocalDateTime stamp;
	
	public AoiRespone(String msg) {
		
		this.msg = msg;
		this.stamp = LocalDateTime.now();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
