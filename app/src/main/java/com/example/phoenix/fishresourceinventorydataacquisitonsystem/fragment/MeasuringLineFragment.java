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
 * 维护 测线 界面
 * */
public class MeasuringLineFragment extends Fragment implements View.OnClickListener{
    //起点经度
    private EditText startLongitude = null;
    //起点纬度
    private EditText startLatitude = null;
    //终点经度
    private EditText endLongitude = null;
    //终点纬度
    private EditText endLatitude = null;
    //新增测点
    private GridLayout addMeaSite = null;
    //起点定位
    private ImageView startLocate = null;
    //终点定位
    private ImageView endLocate = null;
    //确认按钮
    private com.rey.material.widget.Button ensure = null;

    private View addMeaSiteView = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    public MeasuringLineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_measuring_line, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        size = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size/5,size/5);

        startLongitude = (EditText) view.findViewById(R.id._start_longitude);
        startLatitude = (EditText) view.findViewById(R.id._start_latitude);
        endLongitude = (EditText) view.findViewById(R.id._end_longitude);
        endLatitude = (EditText) view.findViewById(R.id._end_latitude);

        startLocate = (ImageView) view.findViewById(R.id._img_start_location);
        startLocate.setOnClickListener(this);
        endLocate = (ImageView) view.findViewById(R.id._img_end_location);
        endLocate.setOnClickListener(this);

        addMeaSite = (GridLayout) view.findViewById(R.id.mea_lin_add_mea_site);
        addMeaSiteView = LayoutInflater.from(getActivity())
                .inflate(R.layout.mea_lin_add_mea_site,null);
        addMeaSiteView.setLayoutParams(params);
        addMeaSiteView.setOnClickListener(this);
        addMeaSite.addView(addMeaSiteView);

        ensure = (com.rey.material.widget.Button) view.findViewById(R.id.ensure);
        ensure.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id._img_start_location:

                Toast.makeText(getActivity(), "起点定位", Toast.LENGTH_SHORT).show();
                break;
            case R.id._img_end_location:

                Toast.makeText(getActivity(), "终点定位", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_mea_site:

                Toast.makeText(getActivity(), "新增测点", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ensure:

                Toast.makeText(getActivity(), "确定", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
