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
 * 维护 渔获物 界面
 * */
public class CatchActivity extends AppCompatActivity implements View.OnClickListener{
    //新增鱼样本
    private GridLayout addFish = null;
    //新增卵样本
    private GridLayout addEgg = null;
    //鱼类名称
    private EditText name = null;
    //卵苗总数
    private EditText mount = null;
    //鱼卵数
    private EditText eggMount = null;
    //幼鱼数
    private EditText fishMount = null;
    //添加照片
    private GridLayout addPic = null;
    //确认按钮
    private com.rey.material.widget.Button ensure = null;

    private View addFishView = null;
    private View addEggView = null;
    private View addPicView = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catch);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("渔获物");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
    }

    private void init(){
        size = getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size/5,size/5);

        addFish = (GridLayout) findViewById(R.id.catch_addfish);
        addFishView = LayoutInflater.from(CatchActivity.this)
                .inflate(R.layout.catch_addfish,null);
        addFishView.setLayoutParams(params);
        addFishView.setOnClickListener(this);
        addFish.addView(addFishView);

        addEgg = (GridLayout) findViewById(R.id.catch_addegg);
        addEggView = LayoutInflater.from(CatchActivity.this)
                .inflate(R.layout.catch_addegg,null);
        addEggView.setLayoutParams(params);
        addEggView.setOnClickListener(this);
        addEgg.addView(addEggView);

        name = (EditText) findViewById(R.id.fish_name);
        mount = (EditText) findViewById(R.id.ovum_seedlings_num);
        eggMount = (EditText) findViewById(R.id.fish_ovum_num);
        fishMount = (EditText) findViewById(R.id.kid_fish_num);

        addPic = (GridLayout) findViewById(R.id.catch_addpic);
        addPicView = LayoutInflater.from(CatchActivity.this)
                .inflate(R.layout.grid_view_add_pic,null);
        addPicView.setLayoutParams(params);
        addPicView.setOnClickListener(this);
        addPic.addView(addPicView);

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
            case R.id.add_fish:

                startActivityForResult(new Intent(CatchActivity.this,
                        FishSampleActivity.class), ConstantData.INPUTMOREDATA);
                break;
            case R.id.add_egg:

                startActivityForResult(new Intent(CatchActivity.this,
                        EggSamplesActivity.class), ConstantData.INPUTMOREDATA);
                break;
            case R.id.add_pic:

                Toast.makeText(CatchActivity.this, "照片", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ensure:
                //确认数据之前做一些提示

                Intent intent = getIntent();

                setResult(ConstantData.CATCH_SUCCESSFUL,intent);
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ConstantData.INPUTMOREDATA){
            if (resultCode == ConstantData.FISHSAMPLE_SUCCESSFUL){  //新增鱼样本成功

            }else if (resultCode == ConstantData.EGGSAMPLE_SUCCESSFUL){ //新增卵样本成功

            }
        }
    }
}
