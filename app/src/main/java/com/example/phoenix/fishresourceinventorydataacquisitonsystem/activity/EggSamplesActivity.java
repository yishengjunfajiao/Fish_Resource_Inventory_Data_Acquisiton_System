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
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.R;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.constant.ConstantData;

/**
 * 维护 卵样本 界面
 * */
public class EggSamplesActivity extends AppCompatActivity implements View.OnClickListener{
    //发育期
    private EditText puberty = null;
    //卵径
    private EditText eggSize = null;
    //卵膜径
    private EditText eggMembraneDiameter = null;
    //色素性状
    private EditText pigmentProperties = null;
    //胚胎性状
    private EditText embryoTraits = null;
    //添加照片
    private GridLayout addPic = null;
    //确认按钮
    private com.rey.material.widget.Button ensure = null;

    private View addPicView = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg_samples);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("卵样本");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
    }

    private void init(){
        size = getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size/5,size/5);

        puberty = (EditText) findViewById(R.id.puberty);
        eggSize = (EditText) findViewById(R.id.egg_size);
        eggMembraneDiameter = (EditText) findViewById(R.id.egg_membrane_diameter);
        pigmentProperties = (EditText) findViewById(R.id.pigment_properties);
        embryoTraits = (EditText) findViewById(R.id.embryo_traits);

        addPic = (GridLayout) findViewById(R.id.cont_egg_add_pic);
        addPicView = LayoutInflater.from(EggSamplesActivity.this)
                .inflate(R.layout.grid_view_add_pic,null);
        addPicView.setLayoutParams(params);
        addPicView.setOnClickListener(this);
        addPic.addView(addPicView);

        ensure = (com.rey.material.widget.Button) findViewById(R.id.ensure);
        ensure.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_pic:
                Toast.makeText(EggSamplesActivity.this, "照片", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ensure:
                //确认数据之前做一些提示

                Intent intent = getIntent();

                setResult(ConstantData.EGGSAMPLE_SUCCESSFUL,intent);
                finish();
                break;
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
        }else if (itemId == android.R.id.home){     //左上角返回按钮点击时间
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
