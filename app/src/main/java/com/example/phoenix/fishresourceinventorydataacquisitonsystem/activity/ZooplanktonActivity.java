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
 * 维护 浮游动物 界面
 * */
public class ZooplanktonActivity extends AppCompatActivity implements View.OnClickListener{
    //新增优势种
    private GridLayout addDominantSpecies = null;
    //数量
    private EditText mount = null;
    //生物量
    private EditText biomass = null;
    //添加照片
    private GridLayout addPic = null;
    //确认按钮
    private com.rey.material.widget.Button ensure = null;

    private View addDominantSpeciesView = null;
    private View addPicView = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zooplankton);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("浮游动物");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        init();
    }

    private void init(){
        size = getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size/5,size/5);

        addDominantSpecies = (GridLayout) findViewById(R.id.zoo_add_dom_spe);
        addDominantSpeciesView = LayoutInflater.from(ZooplanktonActivity.this)
                .inflate(R.layout.add_dom_spe,null);
        addDominantSpeciesView.setLayoutParams(params);
        addDominantSpeciesView.setOnClickListener(this);
        addDominantSpecies.addView(addDominantSpeciesView);

        mount = (EditText) findViewById(R.id.mount);
        biomass = (EditText) findViewById(R.id.biomass);

        addPic = (GridLayout) findViewById(R.id.zoo_add_pic);
        addPicView = LayoutInflater.from(ZooplanktonActivity.this)
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
            case R.id.add_dom_spe:

                startActivityForResult(new Intent(ZooplanktonActivity.this,
                        DominantSpeciesActivity.class), ConstantData.INPUTMOREDATA);
                break;
            case R.id.add_pic:

                Toast.makeText(ZooplanktonActivity.this, "照片", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ensure:
                //确认数据之前做一些提示

                Intent intent = getIntent();

                setResult(ConstantData.ZOOPLANKTON_SUCCESSFUL,intent);
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ConstantData.INPUTMOREDATA){
            if (resultCode == ConstantData.DOMINANTSPECIES_SUCCESSFUL){ //新增优势种成功

            }
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
