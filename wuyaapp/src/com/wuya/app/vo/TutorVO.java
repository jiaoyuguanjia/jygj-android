package com.wuya.app.vo;

import com.wuya.app.vo.enums.Gender;
import com.wuya.app.vo.enums.ProfessionType;
import com.wuya.app.vo.enums.UserType;

public class TutorVO {
	
	private Long tutorId;
	private Long userId;
	private UserType userType = UserType.TUTOR;// 用户类型：1，老师；2，学生
	private String realName;// 名称
	private String alias;// 别名，称谓
	private String mobile; // 注册手机
	private Gender gender; // 性别：0，男；1，女
	private String icon;// 头像

	private ProfessionType profession;// 职业类型：1，大学生兼职；2，在职教师
	private Integer teachingAge;// 教龄
	private String profile;// 个人简介

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Long getTutorId() {
		return tutorId;
	}

	public void setTutorId(Long tutorId) {
		this.tutorId = tutorId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public ProfessionType getProfession() {
		return profession;
	}

	public void setProfession(ProfessionType profession) {
		this.profession = profession;
	}

	public Integer getTeachingAge() {
		return teachingAge;
	}

	public void setTeachingAge(Integer teachingAge) {
		this.teachingAge = teachingAge;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
}
