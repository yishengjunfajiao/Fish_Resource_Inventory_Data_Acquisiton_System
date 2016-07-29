package com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.R;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.MeasuringPoint;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.base.BaseFragment;

/**
 * 维护 测点 界面
 */
@SuppressLint("ValidFragment")
public class MeasuringPointFragment extends BaseFragment implements View.OnClickListener {
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
        super(null);
    }

    public MeasuringPointFragment(BaseNode baseNode) {
        super(baseNode);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_measuring_point, container, false);
        init(view);
        return view;
    }

    private void init(View view) {

        MeasuringPoint mp = (MeasuringPoint) this.baseNode;

        size = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size / 5, size / 5);

        longitude = (EditText) view.findViewById(R.id.longitude);
        longitude.setText(String.valueOf(mp.getLongitude()));

        latitude = (EditText) view.findViewById(R.id.latitude);
        latitude.setText(String.valueOf(mp.getLatitude()));

        locate = (ImageView) view.findViewById(R.id.img_start_location_);
        locate.setOnClickListener(this);

        addWaterCourse = (GridLayout) view.findViewById(R.id.mea_sit_add_watercourse);
        addWaterCourseView = LayoutInflater.from(getActivity())
                .inflate(R.layout.mea_sit_add_watercourse, null);
        addWaterCourseView.setLayoutParams(params);
        addWaterCourseView.setOnClickListener(this);
        addWaterCourse.addView(addWaterCourseView);

        ensure = (com.rey.material.widget.Button) view.findViewById(R.id.ensure);
        ensure.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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

    @Override
    public BaseNode save() {
        MeasuringPoint mp = null;
        if (this.baseNode != null) {
            mp = (MeasuringPoint) this.baseNode;
            float laF = Float.parseFloat(latitude.getText().toString());
            float loF = Float.parseFloat(longitude.getText().toString());
            mp.setLatitude(laF);
            mp.setLongitude(loF);
        }
        return mp;
    }
}
