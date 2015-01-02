package com.wuya.app.service;

import java.util.ArrayList;
import java.util.List;

import com.wuya.app.vo.CategoryVO;

public class CategoryApi {
	
	
	public List<List<CategoryVO>> getCategoryVosList() {
		List<CategoryVO> categoryList = new ArrayList<CategoryVO>();
		CategoryVO vo1 = new CategoryVO(1, "小学", "#86BA75");
		vo1.getSubcategoryList().add(vo1);
		vo1.getSubcategoryList().add(vo1);
		vo1.getSubcategoryList().add(vo1);
		vo1.getSubcategoryList().add(vo1);
		categoryList.add(vo1);
		
		CategoryVO vo2 = new CategoryVO(2, "初中", "#4EA8C7");
		vo2.getSubcategoryList().add(vo2);
		vo2.getSubcategoryList().add(vo2);
		vo2.getSubcategoryList().add(vo2);
		vo2.getSubcategoryList().add(vo2);
		categoryList.add(vo2);
		
		CategoryVO vo3 = new CategoryVO(3, "高中", "#D9A24D");
		vo3.getSubcategoryList().add(vo3);
		vo3.getSubcategoryList().add(vo3);
		vo3.getSubcategoryList().add(vo3);
		categoryList.add(vo3);
		
		CategoryVO vo4 = new CategoryVO(4, "学前教育", "#E26A68");
		vo4.getSubcategoryList().add(vo4);
		vo4.getSubcategoryList().add(vo4);
		vo4.getSubcategoryList().add(vo4);
		categoryList.add(vo4);
		
		
		CategoryVO vo5 = new CategoryVO(5, "大学", "#D9792B");
		vo5.getSubcategoryList().add(vo5);
		vo5.getSubcategoryList().add(vo5);
		vo5.getSubcategoryList().add(vo5);
		categoryList.add(vo5);
		
		CategoryVO vo6 = new CategoryVO(6, "出国留学", "#51B1A3");
		vo6.getSubcategoryList().add(vo6);
		vo6.getSubcategoryList().add(vo6);
		vo6.getSubcategoryList().add(vo6);
		categoryList.add(vo6);
		
		CategoryVO vo7 = new CategoryVO(7, "艺术体育", "#7383C0");
		vo7.getSubcategoryList().add(vo7);
		vo7.getSubcategoryList().add(vo7);
		categoryList.add(vo7);
		
		CategoryVO vo8 = new CategoryVO(8, "生活技能", "#6BA74E");
		vo8.getSubcategoryList().add(vo8);
		vo8.getSubcategoryList().add(vo8);
		categoryList.add(vo8);
		
		CategoryVO vo9 = new CategoryVO(9, "语言培训", "#DE6444");
		vo9.getSubcategoryList().add(vo9);
		vo9.getSubcategoryList().add(vo9);
		vo9.getSubcategoryList().add(vo9);
		categoryList.add(vo9);
		
		List<List<CategoryVO>> categoryVosList = new ArrayList<List<CategoryVO>>();
		if (categoryList != null) {
			List<CategoryVO> itemData = new ArrayList<CategoryVO>();
			for (int i = 0; i < categoryList.size(); i++) {
				itemData.add(categoryList.get(i));
				if ((i + 1) % 3 == 0) {
					categoryVosList.add(itemData);
					itemData = new ArrayList<CategoryVO>();
				}
			}
		}
		
		return categoryVosList;
	}

}
