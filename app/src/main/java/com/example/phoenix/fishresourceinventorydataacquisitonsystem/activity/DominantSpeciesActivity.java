package com.example.phoenix.fishresourceinventorydataacquisitonsystem.activity;

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

/**
 * 维护 优势种 界面
 * */
public class DominantSpeciesActivity extends AppCompatActivity implements View.OnClickListener{
    //数量
    private EditText mount = null;
    //生物量
    private EditText biomass = null;
    //添加照片
    private GridLayout addPic = null;

    private View addPicView = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dominant_species);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("优势种");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
    }

    private void init(){
        size = getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size/5,size/5);

        mount = (EditText) findViewById(R.id.mount);
        biomass = (EditText) findViewById(R.id.biomass);

        addPic = (GridLayout) findViewById(R.id.dom_add_pic);
        addPicView = LayoutInflater.from(DominantSpeciesActivity.this)
                .inflate(R.layout.grid_view_add_pic,null);
        addPicView.setLayoutParams(params);
        addPicView.setOnClickListener(this);
        addPic.addView(addPicView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_pic:

                Toast.makeText(DominantSpeciesActivity.this, "照片", Toast.LENGTH_SHORT).show();
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
