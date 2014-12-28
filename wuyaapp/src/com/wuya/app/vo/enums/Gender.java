package com.wuya.app.vo.enums;

/**
 * 性别
 * 
 * @author xiaocilin
 * 
 */
public enum Gender {

	MALE(0, "男"),

	FEMALE(1, "女");

	private int code;

	private String message;

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	private Gender(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public static Gender valueOf(int code) {
		for(Gender gender: values()) {
			if (gender.getCode() == code) {
				return gender;
			}
		}
		return null;
	}

}
