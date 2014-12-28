package com.wuya.app.tutor;

import com.wuya.app.R;
import com.wuya.app.vo.TutorVo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TutorPersonalCenter extends Activity implements OnClickListener{
	private EditText tutorInputNameTV;
	private TextView tutorGenderTV;
	private EditText tutorInputTeachingAgeTV;
	private TextView tutorProfessionTV;
	private EditText tutorInputProfileTV;
	private Button saveBtn;
	private TutorVo tutorVo;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutor_personal_info);
        tutorInputNameTV = (EditText) this.findViewById(R.id.tutor_input_name);
        tutorGenderTV = (TextView) this.findViewById(R.id.totur_gender);
        tutorInputTeachingAgeTV = (EditText) this.findViewById(R.id.tutor_input_teaching_age);
        tutorProfessionTV = (TextView) this.findViewById(R.id.tutor_profession);
        tutorInputProfileTV = (EditText) this.findViewById(R.id.tutor_input_profile);
        saveBtn = (Button) this.findViewById(R.id.tutor_personal_center_save_btn);
       
        //获取tutor信息
        initTutorInfo();
        //初始化个人中心表单
        initForm();
        
        
        tutorGenderTV.setOnClickListener(this);
        tutorProfessionTV.setOnClickListener(this);
        saveBtn.setOnClickListener(this);
    }
    
    @Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.totur_gender:
		    new AlertDialog.Builder(this)
		    .setTitle("请选择性别")  
		    .setIcon(android.R.drawable.ic_dialog_info)                  
		    .setSingleChoiceItems(new String[] {"男","女"}, tutorVo.getGender(),   
		      new DialogInterface.OnClickListener() {         
		         public void onClick(DialogInterface dialog, int which) {  
		        	tutorVo.setGender(which);
		    		if(tutorVo.getGender() == 0){
		    			tutorGenderTV.setText("男");
		    		}else{
		    			tutorGenderTV.setText("女");
		    		}	        	
		            dialog.dismiss();  
		         }  
		      }  
		    )  
		    .setNegativeButton("取消", null)  
		    .show();  
			break;
		case R.id.tutor_profession:
		    new AlertDialog.Builder(this)
		    .setTitle("请选择职业类型")  
		    .setIcon(android.R.drawable.ic_dialog_info)                  
		    .setSingleChoiceItems(new String[] {"大学生兼职","在职教师"}, tutorVo.getProfession()==null?null:tutorVo.getProfession()-1,   
		      new DialogInterface.OnClickListener() {         
		         public void onClick(DialogInterface dialog, int which) {  
		        	tutorVo.setProfession(which+1);
		    		if(which == 0){
		    			tutorProfessionTV.setText("大学生兼职");
		    		}else{
		    			tutorProfessionTV.setText("在职教师");
		    		}	        	
		            dialog.dismiss();  
		         }  
		      }  
		    )  
		    .setNegativeButton("取消", null)  
		    .show();  
			break;
		case R.id.tutor_personal_center_save_btn:
		    save();
			break;
		default:
			break;
		}
	}
    /**
     * 通过获取老师信息
     * @return
     */
    private void initTutorInfo(){
        //TODO 后台请求
    	tutorVo = new TutorVo();
    	tutorVo.setRealName("周老师");
    	tutorVo.setGender(0);
    	tutorVo.setTeachingAge(8);
    	tutorVo.setProfession(2);
    	tutorVo.setProfile("我从业8年，的基督教路赛多利斯");
    }
    /**
     * 初始化个人中心表单
     */
    private void initForm(){
    	if(tutorVo == null){
    		return;
    	}
    	
    	if(!TextUtils.isEmpty(tutorVo.getRealName())){
    		tutorInputNameTV.setText(tutorVo.getRealName());
    	}
    	if(tutorVo.getGender() != null){
    		if(tutorVo.getGender() == 0){
    			tutorGenderTV.setText("男");
    		}else{
    			tutorGenderTV.setText("女");
    		}
    	}
    	if(tutorVo.getTeachingAge() != null){
    		tutorInputTeachingAgeTV.setText(tutorVo.getTeachingAge()+"");
    	}
    	if(tutorVo.getProfession() != null){
    		if(tutorVo.getGender() == 1){
    			tutorProfessionTV.setText("大学生兼职");
    		}else{
    			tutorProfessionTV.setText("在职教师");
    		}
    	}
    	if(!TextUtils.isEmpty(tutorVo.getProfile())){
    		tutorInputProfileTV.setText(tutorVo.getProfile());
    	}    	
    }
    /**
     * 保存老师信息
     */
    private void save(){
    	if(tutorVo == null){
    		return;
    	}
    	tutorVo.setRealName(tutorInputNameTV.getText().toString());
    	tutorVo.setGender(tutorGenderTV.getText().toString());
    	String ageStr = tutorInputTeachingAgeTV.getText().toString();
    	tutorVo.setTeachingAge(TextUtils.isEmpty(ageStr)?null:Integer.valueOf(ageStr));
    	tutorVo.setProfession(tutorProfessionTV.getText().toString());
    	tutorVo.setProfile(tutorInputProfileTV.getText().toString());
    	
    	if(TextUtils.isEmpty(tutorVo.getRealName())){
    		Toast.makeText(this, "请输入名称", Toast.LENGTH_SHORT).show();
    		return;
    	}
    	//TODO
    	Toast.makeText(this, "保存成功:"+tutorVo.toString(), Toast.LENGTH_LONG).show();
    }
}
