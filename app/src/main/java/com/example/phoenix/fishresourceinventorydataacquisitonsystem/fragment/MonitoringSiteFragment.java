package com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 */
public class MonitoringSiteFragment extends Fragment implements View.OnClickListener,
        AdapterView.OnItemSelectedListener{
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

    public MonitoringSiteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_monitoring_site, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        size = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size / 5, size / 5);

        addFraSur = (GridLayout) view.findViewById(R.id.mon_site_add_fra_sur);
        addSurfaceView = LayoutInflater.from(getActivity())
                .inflate(R.layout.monitor_site_grid_add_fra_surface, null);
        addSurfaceView.setLayoutParams(params);
        addSurfaceView.setOnClickListener(this);
        addFraSur.addView(addSurfaceView);

        detectionUnit = (EditText) view.findViewById(R.id.detection_unit);
        monitors = (EditText) view.findViewById(R.id.monitors);
        monitoringDate = (EditText) view.findViewById(R.id.monitoring_date);

        province = (Spinner) view.findViewById(R.id.province);
        provinceAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, ConstantData.PROVINCE);
        province.setAdapter(provinceAdapter);
        province.setSelection(16);
        province.setOnItemSelectedListener(this);

        city = (Spinner) view.findViewById(R.id.city);
        cityAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, ConstantData.CITY[16]);
        city.setAdapter(cityAdapter);
        city.setOnItemSelectedListener(this);

        village = (EditText) view.findViewById(R.id.village);
        waterArea = (EditText) view.findViewById(R.id.water_area);
        startTime = (EditText) view.findViewById(R.id.start_time);
        endTime = (EditText) view.findViewById(R.id.end_time);
        weather = (EditText) view.findViewById(R.id.weather);
        temperature = (EditText) view.findViewById(R.id.temperature);
        startLongitude = (EditText) view.findViewById(R.id.start_longitude);
        startLatitude = (EditText) view.findViewById(R.id.start_latitude);
        endLongitude = (EditText) view.findViewById(R.id.end_longitude);
        endLatitude = (EditText) view.findViewById(R.id.end_latitude);

        startLocate = (ImageView) view.findViewById(R.id.img_start_location);
        startLocate.setOnClickListener(this);
        endLocate = (ImageView) view.findViewById(R.id.img_end_location);
        endLocate.setOnClickListener(this);

        addPicture = (GridLayout) view.findViewById(R.id.mon_site_add_pic);
        addPictureView = LayoutInflater.from(getActivity())
                .inflate(R.layout.grid_view_add_pic, null);
        addPictureView.setLayoutParams(params);
        addPictureView.setOnClickListener(this);
        addPicture.addView(addPictureView);

        ensure = (com.rey.material.widget.Button) view.findViewById(R.id.ensure);
        ensure.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_fra_surface:

                Toast.makeText(getActivity(), "添加断面", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_start_location:

                Toast.makeText(getActivity(), "起点定位", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_end_location:

                Toast.makeText(getActivity(), "终点定位", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_pic:

                Toast.makeText(getActivity(), "照片", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ensure:

                Toast.makeText(getActivity(), "确定", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.province:
                cityAdapter = new ArrayAdapter<>(getActivity(),
                        android.R.layout.simple_spinner_item, ConstantData.CITY[position]);
                city.setAdapter(cityAdapter);
                break;
            case R.id.city:

                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
