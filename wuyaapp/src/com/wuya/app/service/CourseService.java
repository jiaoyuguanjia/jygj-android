package com.wuya.app.service;

import java.util.List;

import com.wuya.app.vo.CourseVO;

public interface CourseService {
	
	/**
	 * 通过课程ID获取课程
	 * @param courseId
	 * @return
	 */
	CourseVO getCourseById(Long courseId);
	/**
	 * 通过教师ID获取有效的课程（审批不通过的过滤掉）
	 * @param tutorId
	 * @return
	 */
	List<CourseVO> getValidCourseListByTutorId(Long tutorId);
	/**
	 * 通过教师ID获取全部课程
	 * @param tutorId
	 * @return
	 */
	List<CourseVO> getAllCourseListByTutorId(Long tutorId);
	/**
	 * 新增/修改课程
	 * @param course
	 */
	void saveCourse(CourseVO course);
}
