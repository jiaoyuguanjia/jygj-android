package com.wuya.app.core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectionUtils {

	/**
	 * 将指定对象的所有属性打平成map类型
	 * 
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> getMap(Object object) throws Exception {
		Class<?> clz = object.getClass();
		Field[] fields = clz.getDeclaredFields();
		Map<String, Object> map = new HashMap<String, Object>();
		for (Field field : fields) {
			Method getMethod = (Method) clz.getMethod("get" + getMethodName(field.getName()));
			Object value = getMethod.invoke(object);
			map.put(field.getName(), value);
		}
		return map;
	}

	/**
	 * 把一个字符串的第一个字母大写、效率是最高的
	 * 
	 * @param fildeName
	 *            属性字段名称
	 * @return
	 * @throws Exception
	 */
	private static String getMethodName(String fildeName) throws Exception {
		byte[] items = fildeName.getBytes();
		items[0] = (byte) ((char) items[0] - 'a' + 'A');
		return new String(items);
	}
	
	public static List<Map<String, Object>> getMapList(List<?> list) throws Exception {
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		for (Object obj : list) {
			data.add(ReflectionUtils.getMap(obj));
		}
		return data;
	}

}
