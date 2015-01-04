package com.wuya.app.tutor;

import com.wuya.app.R;
import com.wuya.app.vo.TutorVO;
import com.wuya.app.vo.enums.Gender;
import com.wuya.app.vo.enums.ProfessionType;

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

public class TutorPersonalCenterActivity extends Activity implements OnClickListener{
	private EditText tutorInputNameTV;
	private TextView tutorGenderTV;
	private EditText tutorInputTeachingAgeTV;
	private TextView tutorProfessionTV;
	private EditText tutorInputProfileTV;
	private Button saveBtn;
	private TutorVO tutorVo;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutor_personal_info_activity);
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
		    .setSingleChoiceItems(new String[] {"男","女"}, tutorVo.getGender().getCode(),   
		      new DialogInterface.OnClickListener() {         
		         public void onClick(DialogInterface dialog, int which) {  
		        	tutorVo.setGender(Gender.valueOf(which));
		        	tutorGenderTV.setText(tutorVo.getGender().getMessage());
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
		    .setSingleChoiceItems(new String[] {"大学生兼职","在职教师"}, tutorVo.getProfession()==null?null:tutorVo.getProfession().getCode(),   
		      new DialogInterface.OnClickListener() {         
		         public void onClick(DialogInterface dialog, int which) {  
		        	tutorVo.setProfession(ProfessionType.valueOf(which));
		        	tutorProfessionTV.setText(tutorVo.getProfession().getMessage());
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
    	tutorVo = new TutorVO();
    	tutorVo.setRealName("周老师");
    	tutorVo.setGender(Gender.MALE);
    	tutorVo.setTeachingAge(8);
    	tutorVo.setProfession(ProfessionType.INSERVICE_TEACHER);
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
    		tutorGenderTV.setText(tutorVo.getGender().getMessage());
    	}
    	if(tutorVo.getTeachingAge() != null){
    		tutorInputTeachingAgeTV.setText(tutorVo.getTeachingAge()+"");
    	}
    	if(tutorVo.getProfession() != null){
    		tutorProfessionTV.setText(tutorVo.getProfession().getMessage());
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
    	tutorVo.setGender(Gender.valueOf(Integer.parseInt(tutorGenderTV.getText().toString())));
    	String ageStr = tutorInputTeachingAgeTV.getText().toString();
    	tutorVo.setTeachingAge(TextUtils.isEmpty(ageStr)?null:Integer.valueOf(ageStr));
    	tutorVo.setProfession(ProfessionType.valueOf(Integer.parseInt(tutorProfessionTV.getText().toString())));
    	tutorVo.setProfile(tutorInputProfileTV.getText().toString());
    	
    	if(TextUtils.isEmpty(tutorVo.getRealName())){
    		Toast.makeText(this, "请输入名称", Toast.LENGTH_SHORT).show();
    		return;
    	}
    	Toast.makeText(this, "保存老师基本信息成功", Toast.LENGTH_LONG).show();
    }
}
