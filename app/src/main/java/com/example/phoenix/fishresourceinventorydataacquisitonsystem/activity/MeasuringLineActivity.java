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
 * 维护 测线 界面
 * */
public class MeasuringLineActivity extends AppCompatActivity implements View.OnClickListener{

    //起点经度
    private EditText startLongitude = null;
    //起点纬度
    private EditText startLatitude = null;
    //终点经度
    private EditText endLongitude = null;
    //终点纬度
    private EditText endLatitude = null;
    //新增测点
    private GridLayout addMeaSite = null;
    //起点定位
    private ImageView startLocate = null;
    //终点定位
    private ImageView endLocate = null;
    //确认按钮
    private com.rey.material.widget.Button ensure = null;

    private View addMeaSiteView = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measuring_line);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("测线");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
    }

    private void init(){
        size = getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size/5,size/5);

        startLongitude = (EditText) findViewById(R.id._start_longitude);
        startLatitude = (EditText) findViewById(R.id._start_latitude);
        endLongitude = (EditText) findViewById(R.id._end_longitude);
        endLatitude = (EditText) findViewById(R.id._end_latitude);

        startLocate = (ImageView) findViewById(R.id._img_start_location);
        startLocate.setOnClickListener(this);
        endLocate = (ImageView) findViewById(R.id._img_end_location);
        endLocate.setOnClickListener(this);

        addMeaSite = (GridLayout) findViewById(R.id.mea_lin_add_mea_site);
        addMeaSiteView = LayoutInflater.from(MeasuringLineActivity.this)
                .inflate(R.layout.mea_lin_add_mea_site,null);
        addMeaSiteView.setLayoutParams(params);
        addMeaSiteView.setOnClickListener(this);
        addMeaSite.addView(addMeaSiteView);

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
                resultCode == ConstantData.MEASURINGSITE_SUCCESSFUL){   //新增测点成功
            //动态改变GridLayout的View

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id._img_start_location:
                Toast.makeText(MeasuringLineActivity.this, "起点定位", Toast.LENGTH_SHORT).show();
                break;
            case R.id._img_end_location:
                Toast.makeText(MeasuringLineActivity.this, "终点定位", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_mea_site:

                startActivityForResult(new Intent(MeasuringLineActivity.this,
                        MeasuringSiteActivity.class), ConstantData.INPUTMOREDATA);
                break;
            case R.id.ensure:
                //确认数据之前做一些提示

                Intent intent = getIntent();

                setResult(ConstantData.MEASURINGLINE_SUCCESSFUL,intent);
                finish();
                break;
        }
    }
}