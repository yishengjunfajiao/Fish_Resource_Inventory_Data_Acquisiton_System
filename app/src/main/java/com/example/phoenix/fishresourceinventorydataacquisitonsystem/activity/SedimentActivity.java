package com.example.phoenix.fishresourceinventorydataacquisitonsystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.R;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.constant.ConstantData;

/**
 * 维护 沉积物 界面
 * */
public class SedimentActivity extends AppCompatActivity implements View.OnClickListener{
    //添加照片
    private GridLayout addPicture = null;
    //确认按钮
    private com.rey.material.widget.Button ensure = null;

    private View addPictureView = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sediment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("沉积物");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
    }

    private void init(){
        size = getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size/5,size/5);

        addPicture = (GridLayout) findViewById(R.id.sediment_add_pic);
        addPictureView = LayoutInflater.from(SedimentActivity.this)
                .inflate(R.layout.grid_view_add_pic,null);
        addPictureView.setLayoutParams(params);
        addPictureView.setOnClickListener(this);
        addPicture.addView(addPictureView);

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
            case R.id.add_pic:

                Toast.makeText(SedimentActivity.this, "照片", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ensure:
                //确认数据之前做一些提示

                Intent intent = getIntent();

                setResult(ConstantData.SEDIMENT_SUCCESSFUL,intent);
                finish();
                break;
        }
    }
}
