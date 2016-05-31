package com.example.phoenix.fishresourceinventorydataacquisitonsystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
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
public class MonitoringSiteActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        AdapterView.OnItemSelectedListener,
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
    //起点定位
    private ImageView startLocate = null;
    //终点定位
    private ImageView endLocate = null;
    //确认按钮
    private com.rey.material.widget.Button ensure = null;

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
        toolbar.setTitle("监测点");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        init();
    }

    private void init(){
        size = getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size/5,size/5);

        addFraSur = (GridLayout) findViewById(R.id.mon_site_add_fra_sur);
        addSurfaceView = LayoutInflater.from(MonitoringSiteActivity.this)
                .inflate(R.layout.monitor_site_grid_add_fra_surface,null);
        addSurfaceView.setLayoutParams(params);
        addSurfaceView.setOnClickListener(this);
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

        startLocate = (ImageView) findViewById(R.id.img_start_location);
        startLocate.setOnClickListener(this);
        endLocate = (ImageView) findViewById(R.id.img_end_location);
        endLocate.setOnClickListener(this);

        addPicture = (GridLayout) findViewById(R.id.mon_site_add_pic);
        addPictureView = LayoutInflater.from(MonitoringSiteActivity.this)
                .inflate(R.layout.grid_view_add_pic,null);
        addPictureView.setLayoutParams(params);
        addPictureView.setOnClickListener(this);
        addPicture.addView(addPictureView);

        ensure = (com.rey.material.widget.Button) findViewById(R.id.ensure);
        ensure.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if((System.currentTimeMillis() - current_time) > 2000){
            Toast.makeText(MonitoringSiteActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            current_time = System.currentTimeMillis();
        } else{
            finish();
        }
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
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_fra_surface:
                startActivityForResult(new Intent(MonitoringSiteActivity.this, FractureSurfaceActivity.class), ConstantData.INPUTMOREDATA);
                break;
            case R.id.add_pic:
                Toast.makeText(MonitoringSiteActivity.this, "添加图片", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_start_location:
                Toast.makeText(MonitoringSiteActivity.this, "起点定位", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_end_location:
                Toast.makeText(MonitoringSiteActivity.this, "终点定位", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ensure:
                //确认数据之前做一些提示

                break;
        }
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ConstantData.INPUTMOREDATA){
            if (resultCode == ConstantData.FRACTURESURFACE_SUCCESSFUL){     //新增断面成功

            }
        }

    }
}
