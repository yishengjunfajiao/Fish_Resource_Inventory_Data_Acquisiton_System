package com.example.phoenix.fishresourceinventorydataacquisitonsystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.R;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.constant.ConstantData;

/**
 * 维护 监测点 界面
 * */
public class MonitoringSiteActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,
        View.OnClickListener{
    //新增断面
    private GridLayout addFraSur = null;
    //监测单位
    private EditText detectionUnit = null;
    //监测人员
    private EditText monitors = null;
    //监测日期
    private EditText monitoringDate = null;
    //省
    private Spinner province = null;
    //市
    private Spinner city = null;
    //镇/村
    private EditText village = null;
    //水域
    private EditText waterArea = null;
    //开始时间
    private EditText startTime = null;
    //结束时间
    private EditText endTime = null;
    //天气
    private EditText weather = null;
    //气温
    private EditText temperature = null;
    //起点经度
    private EditText startLongitude = null;
    //起点纬度
    private EditText startLatitude = null;
    //终点经度
    private EditText endLongitude = null;
    //终点纬度
    private EditText endLatitude = null;
    //添加照片
    private GridLayout addPicture = null;

    private ArrayAdapter<String> provinceAdapter = null;
    private ArrayAdapter<String> cityAdapter = null;

    private View addSurfaceView = null;
    private View addPictureView = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    private static long current_time = 0;      //记录系统当前时间

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoring_site);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        init();
    }

    private void init(){
        size = getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size/5,size/5);

        addFraSur = (GridLayout) findViewById(R.id.mon_site_add_fra_sur);
        addSurfaceView = LayoutInflater.from(MonitoringSiteActivity.this)
                .inflate(R.layout.monitor_site_grid_add_fra_surface,null);
        addSurfaceView.setLayoutParams(params);
        ImageView add1 = (ImageView) addSurfaceView.findViewById(R.id.image_add_surf);
        add1.setOnClickListener(this);
        addFraSur.addView(addSurfaceView);

        detectionUnit = (EditText) findViewById(R.id.detection_unit);
        monitors = (EditText) findViewById(R.id.monitors);
        monitoringDate = (EditText) findViewById(R.id.monitoring_date);

        province = (Spinner) findViewById(R.id.province);
        provinceAdapter = new ArrayAdapter<>(MonitoringSiteActivity.this,
                android.R.layout.simple_spinner_item, ConstantData.PROVINCE);
        province.setAdapter(provinceAdapter);
        province.setSelection(16);
        province.setOnItemSelectedListener(this);

        city = (Spinner) findViewById(R.id.city);
        cityAdapter = new ArrayAdapter<>(MonitoringSiteActivity.this,
                android.R.layout.simple_spinner_item,ConstantData.CITY[16]);
        city.setAdapter(cityAdapter);
        city.setOnItemSelectedListener(this);

        village = (EditText) findViewById(R.id.village);
        waterArea = (EditText) findViewById(R.id.water_area);
        startTime = (EditText) findViewById(R.id.start_time);
        endTime = (EditText) findViewById(R.id.end_time);
        weather = (EditText) findViewById(R.id.weather);
        temperature = (EditText) findViewById(R.id.temperature);
        startLongitude = (EditText) findViewById(R.id.start_longitude);
        startLatitude = (EditText) findViewById(R.id.start_latitude);
        endLongitude = (EditText) findViewById(R.id.end_longitude);
        endLatitude = (EditText) findViewById(R.id.end_latitude);

        addPicture = (GridLayout) findViewById(R.id.mon_site_add_pic);
        addPictureView = LayoutInflater.from(MonitoringSiteActivity.this)
                .inflate(R.layout.monitor_site_grid_add_pic,null);
        addPictureView.setLayoutParams(params);
        ImageView add2 = (ImageView) addPictureView.findViewById(R.id.image_add_pic);
        add2.setOnClickListener(this);
        addPicture.addView(addPictureView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.data_share){

            return true;
        }else if (itemId == R.id.data_submit){

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.province:
                cityAdapter = new ArrayAdapter<>(MonitoringSiteActivity.this,
                        android.R.layout.simple_spinner_item,ConstantData.CITY[position]);
                city.setAdapter(cityAdapter);
                break;
            case R.id.city:

                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_add_surf:
                startActivity(new Intent(MonitoringSiteActivity.this, FractureSurfaceActivity.class));
                break;
            case R.id.image_add_pic:
                Toast.makeText(MonitoringSiteActivity.this, "添加图片", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if((System.currentTimeMillis() - current_time) > 2000){
            Toast.makeText(MonitoringSiteActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            current_time = System.currentTimeMillis();
        } else{
            finish();
        }
    }
}
