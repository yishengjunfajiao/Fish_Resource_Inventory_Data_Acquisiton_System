package com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.R;

/**
 * 维护 测点 界面
 * */
public class MeasuringPointFragment extends Fragment implements View.OnClickListener{
    //经度
    private EditText longitude = null;
    //纬度
    private EditText latitude = null;
    //定位按钮
    private ImageView locate = null;
    //添加采样水层
    private GridLayout addWaterCourse = null;
    //确认按钮
    private com.rey.material.widget.Button ensure = null;

    private View addWaterCourseView = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    public MeasuringPointFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_measuring_point, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        size = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size/5,size/5);

        longitude = (EditText) view.findViewById(R.id.longitude);
        latitude = (EditText) view.findViewById(R.id.latitude);

        locate = (ImageView) view.findViewById(R.id.img_start_location_);
        locate.setOnClickListener(this);

        addWaterCourse = (GridLayout) view.findViewById(R.id.mea_sit_add_watercourse);
        addWaterCourseView = LayoutInflater.from(getActivity())
                .inflate(R.layout.mea_sit_add_watercourse,null);
        addWaterCourseView.setLayoutParams(params);
        addWaterCourseView.setOnClickListener(this);
        addWaterCourse.addView(addWaterCourseView);

        ensure = (com.rey.material.widget.Button) view.findViewById(R.id.ensure);
        ensure.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_start_location_:

                Toast.makeText(getActivity(), "定位", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_watercourse:

                Toast.makeText(getActivity(), "新增水层", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ensure:

                Toast.makeText(getActivity(), "确定", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
