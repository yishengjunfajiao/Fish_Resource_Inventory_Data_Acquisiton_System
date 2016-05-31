package com.example.phoenix.fishresourceinventorydataacquisitonsystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.R;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.constant.ConstantData;

/**
 * 维护 水层 界面
 * */
public class WaterCourseActivity extends AppCompatActivity implements View.OnClickListener{
    //新增渔获物
    private GridLayout addCatch = null;
    //水层
    private Spinner waterCourse = null;
    //深度
    private EditText deep = null;
    //水温
    private EditText temperature = null;
    //水位
    private EditText level = null;
    //流量
    private EditText flow = null;
    //新增网具
    private GridLayout addNetGear = null;
    //确认按钮
    private com.rey.material.widget.Button ensure = null;

    private View addCatchView = null;
    private View addNetGearView = null;

    private ArrayAdapter<String> waterCourseAdapter = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_course);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("水层");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
    }

    private void init(){
        size = getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size/5,size/5);

        addCatch = (GridLayout) findViewById(R.id.con_water_add_catch);
        addCatchView = LayoutInflater.from(WaterCourseActivity.this)
                .inflate(R.layout.con_water_add_catch,null);
        addCatchView.setLayoutParams(params);
        addCatchView.setOnClickListener(this);
        addCatch.addView(addCatchView);

        waterCourse = (Spinner) findViewById(R.id.water_course);
        waterCourseAdapter = new ArrayAdapter<>(WaterCourseActivity.this,
                android.R.layout.simple_spinner_item, ConstantData.WATERCOURSE);
        waterCourse.setAdapter(waterCourseAdapter);

        deep = (EditText) findViewById(R.id.deep);
        temperature = (EditText) findViewById(R.id.water_temperature);
        level = (EditText) findViewById(R.id.water_level);
        flow = (EditText) findViewById(R.id.water_flow);

        addNetGear = (GridLayout) findViewById(R.id.con_water_add_net);
        addNetGearView = LayoutInflater.from(WaterCourseActivity.this)
                .inflate(R.layout.water_add_net,null);
        addNetGearView.setLayoutParams(params);
        addNetGearView.setOnClickListener(this);
        addNetGear.addView(addNetGearView);

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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_catch:

                startActivityForResult(new Intent(WaterCourseActivity.this,
                        CatchActivity.class), ConstantData.INPUTMOREDATA);
                break;
            case R.id.add_net:

                startActivityForResult(new Intent(WaterCourseActivity.this,
                        NettingGearActivity.class), ConstantData.INPUTMOREDATA);
                break;
            case R.id.ensure:
                //确认数据之前做一些提示

                Intent intent = getIntent();

                setResult(ConstantData.WATERCOURSE_SUCCESSFUL,intent);
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ConstantData.INPUTMOREDATA){
            if (resultCode == ConstantData.CATCH_SUCCESSFUL){   //新增渔获物成功
                //动态改变GridLayout的View

            }else if (resultCode == ConstantData.NETTINGGEAR_SUCCESSFUL){   //新增网具成功
                //动态改变GridLayout的View

            }
        }
    }
}
