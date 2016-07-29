package com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.R;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.CatchTools;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.base.BaseFragment;

/**
 * 维护 网具 界面
 */
@SuppressLint("ValidFragment")
public class NettingGearFragment extends BaseFragment implements View.OnClickListener {
    //名称
    private EditText name = null;
    //网型
    private EditText type = null;
    //网口面积
    private EditText area = null;
    //网口倾角
    private EditText angle = null;
    //网口流速
    private EditText velocity = null;
    //开始时间
    private EditText startTime = null;
    //结束时间
    private EditText endTime = null;
    //添加照片
    private GridLayout addPic = null;
    //确认按钮
    private com.rey.material.widget.Button ensure = null;

    private View addPicView = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    public NettingGearFragment() {
        super(null);
    }

    public NettingGearFragment(BaseNode baseNode) {
        super(baseNode);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_netting_gear, container, false);
        init(view);
        return view;
    }

    private void init(View view) {

        CatchTools ct = (CatchTools) this.baseNode;

        size = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size / 5, size / 5);

        name = (EditText) view.findViewById(R.id.net_name);
        name.setText(ct.getName());

        type = (EditText) view.findViewById(R.id.net_type);
        type.setText(ct.getNetsModel());

        area = (EditText) view.findViewById(R.id.net_area);
        area.setText(String.valueOf(ct.getNetMouthArea()));

        angle = (EditText) view.findViewById(R.id.net_angle);
        angle.setText(String.valueOf(ct.getNetMouthDip()));

        velocity = (EditText) view.findViewById(R.id.net_velocity);
        velocity.setText(String.valueOf(ct.getNetMouthVelocity()));

        startTime = (EditText) view.findViewById(R.id.start_time);
        startTime.setText(ct.getStartTime());

        endTime = (EditText) view.findViewById(R.id.end_time);
        endTime.setText(ct.getEndTime());

        addPic = (GridLayout) view.findViewById(R.id.cont_net_add_pic);
        addPicView = LayoutInflater.from(getActivity())
                .inflate(R.layout.grid_view_add_pic, null);
        addPicView.setLayoutParams(params);
        addPicView.setOnClickListener(this);
        addPic.addView(addPicView);

        ensure = (com.rey.material.widget.Button) view.findViewById(R.id.ensure);
        ensure.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_pic:

                Toast.makeText(getActivity(), "照片", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ensure:

                Toast.makeText(getActivity(), "确定", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public BaseNode save() {
        CatchTools ct = null;
        if (this.baseNode != null) {
            ct = (CatchTools) this.baseNode;
            ct.setName(name.getText().toString());
            ct.setNetsModel(type.getText().toString());
            ct.setNetMouthArea(Float.parseFloat(area.getText().toString()));
            ct.setNetMouthDip(Float.parseFloat(angle.getText().toString()));
            ct.setNetMouthVelocity(Float.parseFloat(velocity.getText().toString()));
            ct.setStartTime(startTime.getText().toString());
            ct.setEndTime(endTime.getText().toString());
        }
        return ct;
    }
}
