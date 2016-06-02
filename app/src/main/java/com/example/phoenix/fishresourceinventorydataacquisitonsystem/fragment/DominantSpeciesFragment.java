package com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment;


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

/**
 * 维护 优势种 界面
 * */
public class DominantSpeciesFragment extends Fragment implements View.OnClickListener{
    //数量
    private EditText mount = null;
    //生物量
    private EditText biomass = null;
    //添加照片
    private GridLayout addPic = null;
    //确认按钮
    private com.rey.material.widget.Button ensure = null;

    private View addPicView = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    public DominantSpeciesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dominant_species, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        size = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size/5,size/5);

        mount = (EditText) view.findViewById(R.id.mount);
        biomass = (EditText) view.findViewById(R.id.biomass);

        addPic = (GridLayout) view.findViewById(R.id.dom_add_pic);
        addPicView = LayoutInflater.from(getActivity())
                .inflate(R.layout.grid_view_add_pic,null);
        addPicView.setLayoutParams(params);
        addPicView.setOnClickListener(this);
        addPic.addView(addPicView);

        ensure = (com.rey.material.widget.Button) view.findViewById(R.id.ensure);
        ensure.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_pic:

                Toast.makeText(getActivity(), "照片", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ensure:

                Toast.makeText(getActivity(), "确定", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
