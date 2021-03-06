package com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment;


import android.annotation.SuppressLint;
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
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.MeasuringLine;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.MeasuringPoint;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.MonitoringSite;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.base.BaseFragment;

/**
 * 维护 测线 界面
 */
@SuppressLint("ValidFragment")
public class MeasuringLineFragment extends BaseFragment implements View.OnClickListener {
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
        super(null);
    }

    public MeasuringLineFragment(BaseNode baseNode) {
        super(baseNode);
    }

    @Override
    public BaseNode save() {
        MeasuringLine ml = null;

        if (this.baseNode != null) {
            ml = (MeasuringLine) this.baseNode;
        } else {
            return null;
        }

        float startLaF = Float.parseFloat(startLatitude.getText().toString());
        float startLoF = Float.parseFloat(startLongitude.getText().toString());
        float endLaF = Float.parseFloat(endLatitude.getText().toString());
        float endLoF = Float.parseFloat(endLongitude.getText().toString());

        ml.setStartLatitude(startLaF);
        ml.setStartLongitude(startLoF);
        ml.setEndLatitude(endLaF);
        ml.setEndLongitude(endLoF);

        return ml;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_measuring_line, container, false);
        init(view);
        return view;
    }

    private void init(View view) {

        MeasuringLine ml = (MeasuringLine) this.baseNode;

        size = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size / 5, size / 5);

        startLongitude = (EditText) view.findViewById(R.id._start_longitude);
        startLongitude.setText(String.valueOf(ml.getStartLongitude()));

        startLatitude = (EditText) view.findViewById(R.id._start_latitude);
        startLatitude.setText(String.valueOf(ml.getStartLongitude()));

        endLongitude = (EditText) view.findViewById(R.id._end_longitude);
        endLongitude.setText(String.valueOf(ml.getEndLongitude()));

        endLatitude = (EditText) view.findViewById(R.id._end_latitude);
        endLatitude.setText(String.valueOf(ml.getEndLatitude()));

        startLocate = (ImageView) view.findViewById(R.id._img_start_location);
        startLocate.setOnClickListener(this);
        endLocate = (ImageView) view.findViewById(R.id._img_end_location);
        endLocate.setOnClickListener(this);

        addMeaSite = (GridLayout) view.findViewById(R.id.mea_lin_add_mea_site);
        addMeaSiteView = LayoutInflater.from(getActivity())
                .inflate(R.layout.mea_lin_add_mea_site, null);
        addMeaSiteView.setLayoutParams(params);
        addMeaSiteView.setOnClickListener(this);
        addMeaSite.addView(addMeaSiteView);

        ensure = (com.rey.material.widget.Button) view.findViewById(R.id.ensure);
        ensure.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
