package com.wuya.app.vo.enums;

/**
 * 职业类型
 * 
 * @author xiaocilin
 * 
 */
public enum ProfessionType {

	PARTTIME_JOB(0, "大学生兼职"),

	INSERVICE_TEACHER(1, "在职教师");

	private int code;

	private String message;

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	private ProfessionType(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public static ProfessionType valueOf(int code) {
		for(ProfessionType profession: values()) {
			if (profession.getCode() == code) {
				return profession;
			}
		}
		return null;
	}

}
