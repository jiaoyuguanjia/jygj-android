package com.wuya.app.vo.enums;

/**
 * 用户类型
 * @author Jinjiang
 *
 */
public enum UserType {

	TUTOR(1,"老师"),
	
	STUDENT(2,"学生");
	
	private int code;
	
	private String message;
	
	public int getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}

	private UserType(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
}
