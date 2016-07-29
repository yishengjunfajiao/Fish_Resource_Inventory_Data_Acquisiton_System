package com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.R;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.base.BaseFragment;

/**
 * 维护 卵样本 界面
 */
@SuppressLint("ValidFragment")
public class EggSampleFragment extends BaseFragment implements View.OnClickListener {
    //发育期
    private EditText puberty = null;
    //卵径
    private EditText eggSize = null;
    //卵膜径
    private EditText eggMembraneDiameter = null;
    //色素性状
    private EditText pigmentProperties = null;
    //胚胎性状
    private EditText embryoTraits = null;
    //添加照片
    private GridLayout addPic = null;
    //确认按钮
    private com.rey.material.widget.Button ensure = null;

    private View addPicView = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    public EggSampleFragment() {
        super(null);
    }

    public EggSampleFragment(BaseNode baseNode) {
        super(baseNode);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_egg_sample, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        size = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size / 5, size / 5);

        puberty = (EditText) view.findViewById(R.id.puberty);
        eggSize = (EditText) view.findViewById(R.id.egg_size);
        eggMembraneDiameter = (EditText) view.findViewById(R.id.egg_membrane_diameter);
        pigmentProperties = (EditText) view.findViewById(R.id.pigment_properties);
        embryoTraits = (EditText) view.findViewById(R.id.embryo_traits);

        addPic = (GridLayout) view.findViewById(R.id.cont_egg_add_pic);
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
        return null;
    }
}
