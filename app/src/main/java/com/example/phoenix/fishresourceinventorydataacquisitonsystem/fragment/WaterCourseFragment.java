package com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment;


import android.annotation.SuppressLint;
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
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.WaterLayer;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.base.BaseFragment;

/**
 * 维护 水层 界面
 */
@SuppressLint("ValidFragment")
public class WaterCourseFragment extends BaseFragment implements View.OnClickListener,
        AdapterView.OnItemSelectedListener {

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
    //水层位置
    private int layerPosition = 0;

    private View addCatchView = null;
    private View addNetGearView = null;

    private ArrayAdapter<String> waterCourseAdapter = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    public WaterCourseFragment() {
        super(null);
    }

    public WaterCourseFragment(BaseNode node) {
        super(node);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_water_course, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        WaterLayer wl = (WaterLayer) this.baseNode;

        size = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size / 5, size / 5);

        addCatch = (GridLayout) view.findViewById(R.id.con_water_add_catch);
        addCatchView = LayoutInflater.from(getActivity())
                .inflate(R.layout.con_water_add_catch, null);
        addCatchView.setLayoutParams(params);
        addCatchView.setOnClickListener(this);
        addCatch.addView(addCatchView);

        waterCourse = (Spinner) view.findViewById(R.id.water_course);
        waterCourseAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, ConstantData.WATERCOURSE);
        waterCourse.setAdapter(waterCourseAdapter);
        waterCourse.setOnItemSelectedListener(this);
        if (wl.getLayer() == null || wl.getLayer().equals("")) {
            waterCourse.setSelection(0);
        } else {
            waterCourse.setSelection(Integer.parseInt(wl.getLayer()));
        }

        deep = (EditText) view.findViewById(R.id.deep);
        deep.setText(String.valueOf(wl.getDepth()));

        temperature = (EditText) view.findViewById(R.id.water_temperature);
        temperature.setText(String.valueOf(wl.getTemperature()));

        level = (EditText) view.findViewById(R.id.water_level);
        level.setText(String.valueOf(wl.getWaterLevel()));

        flow = (EditText) view.findViewById(R.id.water_flow);
        flow.setText(String.valueOf(wl.getVelocity()));

        addNetGear = (GridLayout) view.findViewById(R.id.con_water_add_net);
        addNetGearView = LayoutInflater.from(getActivity())
                .inflate(R.layout.water_add_net, null);
        addNetGearView.setLayoutParams(params);
        addNetGearView.setOnClickListener(this);
        addNetGear.addView(addNetGearView);

        ensure = (com.rey.material.widget.Button) view.findViewById(R.id.ensure);
        ensure.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
        layerPosition = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public BaseNode save() {
        WaterLayer wl = null;
        if (this.baseNode != null) {
            wl = (WaterLayer) this.baseNode;
            float deepF = Float.parseFloat(deep.getText().toString());
            float tempF = Float.parseFloat(temperature.getText().toString());
            float levelF = Float.parseFloat(level.getText().toString());
            float velocF = Float.parseFloat(flow.getText().toString());
            wl.setVelocity(velocF);
            wl.setWaterLevel(levelF);
            wl.setTemperature(tempF);
            wl.setDepth(deepF);
            wl.setLayer(String.valueOf(layerPosition));
        }
        return wl;
    }
}
