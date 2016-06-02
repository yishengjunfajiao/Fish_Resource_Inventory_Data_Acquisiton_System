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
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.R;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.constant.ConstantData;

/**
 * 维护 水层 界面
 * */
public class WaterCourseFragment extends Fragment implements View.OnClickListener,
        AdapterView.OnItemSelectedListener{

    //新增渔获物
    private GridLayout addCatch = null;
    //水层
    private Spinner waterCourse = null;
    //深度
    private EditText deep = null;
    //水温
    private EditText temperature = null;
    //水位
    private EditText level = null;
    //流量
    private EditText flow = null;
    //新增网具
    private GridLayout addNetGear = null;
    //确认按钮
    private com.rey.material.widget.Button ensure = null;

    private View addCatchView = null;
    private View addNetGearView = null;

    private ArrayAdapter<String> waterCourseAdapter = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    public WaterCourseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_water_course, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        size = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size/5,size/5);

        addCatch = (GridLayout) view.findViewById(R.id.con_water_add_catch);
        addCatchView = LayoutInflater.from(getActivity())
                .inflate(R.layout.con_water_add_catch,null);
        addCatchView.setLayoutParams(params);
        addCatchView.setOnClickListener(this);
        addCatch.addView(addCatchView);

        waterCourse = (Spinner) view.findViewById(R.id.water_course);
        waterCourseAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, ConstantData.WATERCOURSE);
        waterCourse.setAdapter(waterCourseAdapter);

        deep = (EditText) view.findViewById(R.id.deep);
        temperature = (EditText) view.findViewById(R.id.water_temperature);
        level = (EditText) view.findViewById(R.id.water_level);
        flow = (EditText) view.findViewById(R.id.water_flow);

        addNetGear = (GridLayout) view.findViewById(R.id.con_water_add_net);
        addNetGearView = LayoutInflater.from(getActivity())
                .inflate(R.layout.water_add_net,null);
        addNetGearView.setLayoutParams(params);
        addNetGearView.setOnClickListener(this);
        addNetGear.addView(addNetGearView);

        ensure = (com.rey.material.widget.Button) view.findViewById(R.id.ensure);
        ensure.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_catch:

                Toast.makeText(getActivity(), "渔获物", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_net:

                Toast.makeText(getActivity(), "网具", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ensure:

                Toast.makeText(getActivity(), "确定", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
