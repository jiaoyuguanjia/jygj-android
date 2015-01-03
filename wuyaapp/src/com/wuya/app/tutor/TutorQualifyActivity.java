package com.wuya.app.tutor;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.*;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.wuya.app.R;
import com.wuya.app.util.ImageTools;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by shengwei on 2014/12/13.
 */
public class TutorQualifyActivity extends Activity {
    private static final int TAKE_PICTURE = 0;
    private static final int CHOOSE_PICTURE = 4;
    private static final int SCALE = 5;//照片缩小比例
    private ImageView tutorIdUploadImg;
    private ImageView tutorTeacherUploadImg;
    private ImageView tutorEduUploadImg;
    private ImageView tutorStudentUploadImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutor_qualify_activity);
        tutorIdUploadImg = (ImageView) this.findViewById(R.id.tutor_id_upload_img);
        tutorTeacherUploadImg = (ImageView) this.findViewById(R.id.tutor_teacher_upload_img);
        tutorEduUploadImg = (ImageView) this.findViewById(R.id.tutor_edu_upload_img);
        tutorStudentUploadImg = (ImageView) this.findViewById(R.id.tutor_student_upload_img);
        //身份认证
        this.findViewById(R.id.tutor_id_upload_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //展示图片选择提示框
                showPicturePicker(TutorQualifyActivity.this,0);
            }
        });
        //教师证认证
        this.findViewById(R.id.tutor_teacher_upload_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPicturePicker(TutorQualifyActivity.this,1);
            }
        });
        //学位认证
        this.findViewById(R.id.tutor_edu_upload_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPicturePicker(TutorQualifyActivity.this,2);
            }
        });
        //学生证认证
        this.findViewById(R.id.tutor_student_upload_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPicturePicker(TutorQualifyActivity.this,3);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            System.out.println(resultCode);
            switch (requestCode / 4) {
                case 0:
                    //将保存在本地的图片取出并缩小后显示在界面上
                    Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "/image.jpg");
                    Bitmap newBitmap = ImageTools.zoomBitmap(bitmap, bitmap.getWidth()/SCALE, bitmap.getHeight()/SCALE);
                    //由于Bitmap内存占用较大，这里需要回收内存，否则会报out of memory异常
                    bitmap.recycle();

                    //将处理过的图片显示在界面上，并保存到本地
                    if(requestCode == 0) {
                        tutorIdUploadImg.setImageBitmap(newBitmap);
                    }else if(requestCode == 1){
                        tutorTeacherUploadImg.setImageBitmap(newBitmap);
                    }
                    else if(requestCode == 2){
                        tutorEduUploadImg.setImageBitmap(newBitmap);
                    }else{
                        tutorStudentUploadImg.setImageBitmap(newBitmap);
                    }
                    //ImageTools.savePhotoToSDCard(newBitmap, Environment.getExternalStorageDirectory().getAbsolutePath(), String.valueOf(System.currentTimeMillis()));
                    break;

                case 1:
                    ContentResolver resolver = getContentResolver();
                    //照片的原始资源地址
                    Uri originalUri = data.getData();
                    try {
                        //使用ContentProvider通过URI获取原始图片
                        Bitmap photo = MediaStore.Images.Media.getBitmap(resolver, originalUri);
                        if (photo != null) {
                            //为防止原始图片过大导致内存溢出，这里先缩小原图显示，然后释放原始Bitmap占用的内存
                            Bitmap smallBitmap = ImageTools.zoomBitmap(photo, photo.getWidth() / SCALE, photo.getHeight() / SCALE);
                            //释放原始图片占用的内存，防止out of memory异常发生
                            photo.recycle();
                            if(requestCode == 4) {
                                tutorIdUploadImg.setImageBitmap(smallBitmap);
                            }else if(requestCode == 5){
                                tutorTeacherUploadImg.setImageBitmap(smallBitmap);
                            }
                            else if(requestCode == 6){
                                tutorEduUploadImg.setImageBitmap(smallBitmap);
                            }else{
                                tutorStudentUploadImg.setImageBitmap(smallBitmap);
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
    }
    //图片选择提示框
    public void showPicturePicker(Context context, final int sourceImg){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("图片来源");
        builder.setNegativeButton("取消", null);
        builder.setItems(new String[]{"拍照","相册"}, new DialogInterface.OnClickListener() {
            //类型码
            int REQUEST_CODE;
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    //拍照
                    case 0:
                        REQUEST_CODE = TAKE_PICTURE + sourceImg;
                        String fileName = "image.jpg";
                        Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),fileName));
                        //指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
                        Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                        startActivityForResult(openCameraIntent, REQUEST_CODE);
                        break;
                    //相册
                    case 1:
                        Intent openAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
                        REQUEST_CODE = CHOOSE_PICTURE + sourceImg;
                        openAlbumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                        startActivityForResult(openAlbumIntent, REQUEST_CODE);
                        break;
                    default:
                        break;
                }
            }
        });
        builder.create().show();
    }
}
