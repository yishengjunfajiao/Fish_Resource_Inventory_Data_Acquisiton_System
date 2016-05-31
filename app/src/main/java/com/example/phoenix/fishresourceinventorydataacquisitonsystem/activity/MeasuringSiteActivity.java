package com.example.phoenix.fishresourceinventorydataacquisitonsystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.R;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.constant.ConstantData;

/**
 * 维护 测点 界面
 * */
public class MeasuringSiteActivity extends AppCompatActivity implements View.OnClickListener{
    //经度
    private EditText longitude = null;
    //纬度
    private EditText latitude = null;
    //定位按钮
    private ImageView locate = null;
    //添加采样水层
    private GridLayout addWaterCourse = null;
    //确认按钮
    private com.rey.material.widget.Button ensure = null;

    private View addWaterCourseView = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measuring_site);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("测点");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
    }

    private void init(){
        size = getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size/5,size/5);

        longitude = (EditText) findViewById(R.id.longitude);
        latitude = (EditText) findViewById(R.id.latitude);

        locate = (ImageView) findViewById(R.id.img_start_location);
        locate.setOnClickListener(this);

        addWaterCourse = (GridLayout) findViewById(R.id.mea_sit_add_watercourse);
        addWaterCourseView = LayoutInflater.from(MeasuringSiteActivity.this)
                .inflate(R.layout.mea_sit_add_watercourse,null);
        addWaterCourseView.setLayoutParams(params);
        addWaterCourseView.setOnClickListener(this);
        addWaterCourse.addView(addWaterCourseView);

        ensure = (com.rey.material.widget.Button) findViewById(R.id.ensure);
        ensure.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.monitoring_site, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.data_share){

            return true;
        }else if (itemId == R.id.data_submit){

            return true;
        }else if (itemId == android.R.id.home){     //左上角返回按钮点击时间
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ConstantData.INPUTMOREDATA &
                resultCode == ConstantData.WATERCOURSE_SUCCESSFUL){ //新增采样水层成功
            //动态改变GridLayout的View

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_start_location:
                Toast.makeText(MeasuringSiteActivity.this, "定位", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_watercourse:

                startActivityForResult(new Intent(MeasuringSiteActivity.this,
                        WaterCourseActivity.class), ConstantData.INPUTMOREDATA);
                break;

            case R.id.ensure:
                //确认数据之前做一些提示

                Intent intent = getIntent();

                setResult(ConstantData.MEASURINGSITE_SUCCESSFUL,intent);
                finish();
                break;
        }
    }
}
