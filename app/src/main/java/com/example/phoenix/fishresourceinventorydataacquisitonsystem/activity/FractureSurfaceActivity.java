package com.example.phoenix.fishresourceinventorydataacquisitonsystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.R;

/**
 * 维护 断面 界面
 * */
public class FractureSurfaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fracture_surface);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("断面");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
        }else if (itemId == android.R.id.home){     //左上角返回按钮点击时间
            finish();
            return true;
        }else if (itemId == R.id.turn){     //测试用，到时候删除
            startActivity(new Intent(FractureSurfaceActivity.this, MeasuringLineActivity.class));
            return true;
        }else if (itemId == R.id.turn){     //测试用，到时候删除
            startActivity(new Intent(FractureSurfaceActivity.this, MeasuringLineActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
