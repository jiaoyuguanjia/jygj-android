package com.wuya.app.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 类目
 * 
 * @author xiaocilin
 * 
 * @since 2014-11-30
 * 
 */
public class CategoryVO {

	/* 类目id */
	private int id;

	/* 类目名称 */
	private String name;

	/* 类目显示颜色 */
	private String color;

	/* 二级类目 */
	private List<CategoryVO> subcategoryList = new ArrayList<CategoryVO>();

	public CategoryVO(int id, String name, String color) {
		this.id = id;
		this.name = name;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<CategoryVO> getSubcategoryList() {
		return subcategoryList;
	}

	public void setSubcategoryList(List<CategoryVO> subcategoryList) {
		this.subcategoryList = subcategoryList;
	}

}
