package com.wuya.app.vo;

public class TutorVo {
	private Long userId;
	private Integer userType = 1;//用户类型：1，老师；2，学生
	private Long tutorId;
	private String realName;//名称
	private String alias;//别名，称谓
	private Integer mobileNo; //注册手机
	private Integer gender; //性别：0，男；1，女
	private String icon;//头像
	
	private Integer profession;//职业类型：1，大学生兼职；2，在职教师
	private Integer teachingAge;//教龄
	private String profile;//个人简介
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
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
	public Integer getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Integer mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getProfession() {
		return profession;
	}
	public void setProfession(Integer profession) {
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
	//性别：0，男；1，女
	public String getGenderStr(){
		if(this.gender == null){
			return null;
		}else if(this.gender == 0){
			return "男";
		}else{
			return "女";
		}
	}
	public void setGender(String v){
		if(v != null){
			if(v.equals("男")){
				this.gender = 0;
			}else{
				this.gender = 1;
			}
		}else{
			this.gender = null;
		}
	}
	//profession 职业类型：1，大学生兼职；2，在职教师
	public String getProfessionStr(){
		if(this.profession == null){
			return null;
		}else if(this.profession == 1){
			return "大学生兼职";
		}else{
			return "在职教师";
		}
	}
	public void setProfession(String v){
		if(v != null){
			if(v.equals("大学生兼职")){
				this.profession = 1;
			}else{
				this.profession = 2;
			}
		}else{
			this.profession = null;
		}
	}
	
	public String toString(){
		return "名称：" + this.getRealName() + ";性别：" + this.getGenderStr()
				+ ";教龄：" + this.getTeachingAge() + ";职业类型：" + this.getProfessionStr()
				+ ";个人简历：" + this.getProfile();
	}
}
