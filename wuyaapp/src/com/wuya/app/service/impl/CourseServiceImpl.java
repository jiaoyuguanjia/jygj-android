package com.wuya.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.wuya.app.service.CourseService;
import com.wuya.app.vo.CourseVO;

public class CourseServiceImpl implements CourseService {

	@Override
	public CourseVO getCourseById(Long courseId) {
		// TODO
		CourseVO vo = new CourseVO();
		
		vo.setId(courseId);
		vo.setTutorId(1L);
		vo.setCategory1Id(1L);
		vo.setCategory2Id(2L);
		vo.setCategory3Id(3L);
		vo.setCategory1Name("初中");
		vo.setCategory2Name("二年级");
		vo.setCategory3Name("数学");
		vo.setTuition(150);
		vo.setDuration(2);
		vo.setCourseIntro("数学教父");
		vo.setApprovalStatus(1);
		
		return vo;
	}

	@Override
	public List<CourseVO> getValidCourseListByTutorId(Long tutorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseVO> getAllCourseListByTutorId(Long tutorId) {
		List<CourseVO> list = new ArrayList<CourseVO>();
		// TODO
		
		for (int i = 0; i < 4; i++) {
			list.add(this.getCourseById(1L));
		}
		
		return list;
	}

	@Override
	public void saveCourse(CourseVO course) {
		// TODO Auto-generated method stub

	}

}
