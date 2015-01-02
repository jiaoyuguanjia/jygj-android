package com.wuya.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wuya.app.core.ReflectionUtils;
import com.wuya.app.vo.TutorVO;
import com.wuya.app.vo.enums.Gender;
import com.wuya.app.vo.enums.ProfessionType;
import com.wuya.app.vo.enums.UserType;

public class TutorApi {

	public List<TutorVO> getNewlyTutorList() {
		List<TutorVO> tutorVOList = new ArrayList<TutorVO>();
		for (int i = 0; i < 10; i++) {
			TutorVO tutorVO = new TutorVO();
			tutorVO.setTutorId(1L);
			tutorVO.setUserId(10010L);
			tutorVO.setUserType(UserType.TUTOR);
			tutorVO.setRealName("周廉贵");
			tutorVO.setAlias("小贵子");
			tutorVO.setMobile("13122227788");
			tutorVO.setGender(Gender.FEMALE);
			tutorVO.setProfession(ProfessionType.INSERVICE_TEACHER);
			tutorVO.setTeachingAge(4); 
			tutorVO.setProfile("8年软件开发，5年软件架构，3年团队管理经验!!"); 
			
			tutorVOList.add(tutorVO);
		}
		return tutorVOList;
	}
	
	public List<Map<String, Object>> getNewlyTutorMapList() throws Exception {
		return ReflectionUtils.getMapList(getNewlyTutorList());
	}

}
