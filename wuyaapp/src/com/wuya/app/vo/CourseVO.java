package com.wuya.app.vo;

public class CourseVO {
	private Long id; //课程ID
	private Long tutorId; //教师ID
	private Long category1Id; //一级所属类目
	private Long category2Id; //二级所属类目
	private Long category3Id; //三级所属类目
	private String category1Name;
	private String category2Name;
	private String category3Name;
	
	private Integer tuition; //学费（单位元）
	private Integer duration; //时长（单位小时）
	private String courseIntro; //课程简介
	private Integer approvalStatus; //审批状态：1，待审批；2，审批通过；3，审批不通过
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTutorId() {
		return tutorId;
	}
	public void setTutorId(Long tutorId) {
		this.tutorId = tutorId;
	}
	public Long getCategory1Id() {
		return category1Id;
	}
	public void setCategory1Id(Long category1Id) {
		this.category1Id = category1Id;
	}
	public Long getCategory2Id() {
		return category2Id;
	}
	public void setCategory2Id(Long category2Id) {
		this.category2Id = category2Id;
	}
	public Long getCategory3Id() {
		return category3Id;
	}
	public void setCategory3Id(Long category3Id) {
		this.category3Id = category3Id;
	}
	public String getCategory1Name() {
		return category1Name;
	}
	public void setCategory1Name(String category1Name) {
		this.category1Name = category1Name;
	}
	public String getCategory2Name() {
		return category2Name;
	}
	public void setCategory2Name(String category2Name) {
		this.category2Name = category2Name;
	}
	public String getCategory3Name() {
		return category3Name;
	}
	public void setCategory3Name(String category3Name) {
		this.category3Name = category3Name;
	}
	public Integer getTuition() {
		return tuition;
	}
	public void setTuition(Integer tuition) {
		this.tuition = tuition;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getCourseIntro() {
		return courseIntro;
	}
	public void setCourseIntro(String courseIntro) {
		this.courseIntro = courseIntro;
	}
	public Integer getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(Integer approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
}
