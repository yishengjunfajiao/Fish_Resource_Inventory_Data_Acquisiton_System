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
 * 维护 断面 界面
 * */
public class FractureSurfaceActivity extends AppCompatActivity {
    //新增测线
    private GridLayout addMeaLine = null;
    //采样方位
    private Spinner samplingPosition = null;
    //距岸距离
    private EditText distanceFromShore = null;
    //添加沉积物
    private GridLayout addSediment = null;
    //添加浮游动物
    private GridLayout addZooplankton = null;
    //添加浮游植物
    private GridLayout addPhytoplankton = null;
    //添加底栖生物
    private GridLayout addBenthicOrganism = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    private View addMeaLineView = null;
    private View addSedimentView = null;
    private View addZooplanktonView = null;
    private View addPhytoplanktonView = null;
    private View addBenthicOrganismView = null;

    private ArrayAdapter<String> samplingPositionAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fracture_surface);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("断面");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
    }

    private void init(){
        size = getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size/5,size/5);

        addMeaLine = (GridLayout) findViewById(R.id.fra_sur_add_mea_line);
        addMeaLineView = LayoutInflater.from(FractureSurfaceActivity.this)
                .inflate(R.layout.fra_sur_add_mea_line,null);
        addMeaLineView.setLayoutParams(params);
        addMeaLine.addView(addMeaLineView);

        samplingPosition = (Spinner) findViewById(R.id.sampling_position);
        samplingPositionAdapter = new ArrayAdapter<>(FractureSurfaceActivity.this,
                android.R.layout.simple_spinner_item, ConstantData.SAMPLEPOSITION);
        samplingPosition.setAdapter(samplingPositionAdapter);

        distanceFromShore = (EditText) findViewById(R.id.distance_from_shore);
        addSediment = (GridLayout) findViewById(R.id.fra_sur_add_sediment);
        addSedimentView = LayoutInflater.from(FractureSurfaceActivity.this)
                .inflate(R.layout.fra_sur_add_sediment,null);
        addSedimentView.setLayoutParams(params);
        addSediment.addView(addSedimentView);

        addZooplankton = (GridLayout) findViewById(R.id.fra_sur_add_zooplankton);
        addZooplanktonView = LayoutInflater.from(FractureSurfaceActivity.this)
                .inflate(R.layout.fra_sur_add_zooplankton,null);
        addZooplanktonView.setLayoutParams(params);
        addZooplankton.addView(addZooplanktonView);

        addPhytoplankton = (GridLayout) findViewById(R.id.fra_sur_add_phytoplankton);
        addPhytoplanktonView = LayoutInflater.from(FractureSurfaceActivity.this)
                .inflate(R.layout.fra_sur_add_phytoplankton,null);
        addPhytoplanktonView.setLayoutParams(params);
        addPhytoplankton.addView(addPhytoplanktonView);

        addBenthicOrganism = (GridLayout) findViewById(R.id.fra_sur_add_benthic_organism);
        addBenthicOrganismView = LayoutInflater.from(FractureSurfaceActivity.this)
                .inflate(R.layout.fra_sur_add_benthic_organism,null);
        addBenthicOrganismView.setLayoutParams(params);
        addBenthicOrganism.addView(addBenthicOrganismView);

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
            //当前界面若已输入数据，Dialog提示数据会丢失

            finish();
            return true;
        }else if (itemId == R.id.turn){     //测试用，到时候删除
            startActivity(new Intent(FractureSurfaceActivity.this, MeasuringLineActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
