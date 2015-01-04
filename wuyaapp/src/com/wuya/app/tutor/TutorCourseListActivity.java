<<<<<<< HEAD
package com.wuya.app.tutor;

import android.app.Activity;
import android.os.Bundle;

public class TutorCourseListActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
	}
}
=======
package com.wuya.app.tutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wuya.app.R;
import com.wuya.app.core.ReflectionUtils;
import com.wuya.app.service.CourseService;
import com.wuya.app.service.impl.CourseServiceImpl;
import com.wuya.app.vo.CourseVO;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class TutorCourseListActivity extends Activity {
	private CourseService courseService = new CourseServiceImpl();
	private List<Map<String, Object>> courseItems;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.tutor_course_list_activity);  
        setTitle("课程列表");
        //绑定Layout里面的ListView  
        ListView list = (ListView) findViewById(R.id.tutor_course_list);  
        //老师课程列表
        List<CourseVO> sourseList = courseService.getAllCourseListByTutorId(1L);
        try {
			courseItems =  ReflectionUtils.getMapList(sourseList);
		} catch (Exception e) {
			courseItems = new ArrayList<Map<String, Object>>();
		}
        //生成适配器的Item和动态数组对应的元素  
        SimpleAdapter listItemAdapter = new SimpleAdapter(this,courseItems,//数据源   
            R.layout.tutor_course_list_item,//ListItem的XML实现  
            //动态数组与ImageItem对应的子项          
            new String[] {"category1Name","category2Name", "category3Name", "duration", "tuition"},   
            //ImageItem的XML文件里面的一个ImageView,两个TextView ID  
            new int[] {R.id.tcli_category1Name,R.id.tcli_category2Name,R.id.tcli_category3Name,R.id.tcli_duration,R.id.tcli_tuition}  
        );  
         
        //添加并且显示  
        list.setAdapter(listItemAdapter);  
        //添加点击  
        list.setOnItemClickListener(new OnItemClickListener() {  
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				//setTitle("编辑第"+position+"个课程"); 
				Long courseId = (long) position;
				Intent intent = new Intent(TutorCourseListActivity.this, TutorCourseActivity.class);
				intent.putExtra("courseId", courseId);
				startActivity(intent);
			}  
        });   
    }  
}
>>>>>>> 87a5a6ccb73cdf34d0e2627c846fe9d54c1062f7
