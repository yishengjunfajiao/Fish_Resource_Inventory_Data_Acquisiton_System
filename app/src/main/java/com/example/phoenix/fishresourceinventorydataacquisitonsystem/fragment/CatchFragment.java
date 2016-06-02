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
 * 维护 渔获物 界面
 * */
public class CatchFragment extends Fragment implements View.OnClickListener{
    //新增鱼样本
    private GridLayout addFish = null;
    //新增卵样本
    private GridLayout addEgg = null;
    //鱼类名称
    private EditText name = null;
    //卵苗总数
    private EditText mount = null;
    //鱼卵数
    private EditText eggMount = null;
    //幼鱼数
    private EditText fishMount = null;
    //添加照片
    private GridLayout addPic = null;
    //确认按钮
    private com.rey.material.widget.Button ensure = null;

    private View addFishView = null;
    private View addEggView = null;
    private View addPicView = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    public CatchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catch, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        size = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size/5,size/5);

        addFish = (GridLayout) view.findViewById(R.id.catch_addfish);
        addFishView = LayoutInflater.from(getActivity())
                .inflate(R.layout.catch_addfish,null);
        addFishView.setLayoutParams(params);
        addFishView.setOnClickListener(this);
        addFish.addView(addFishView);

        addEgg = (GridLayout) view.findViewById(R.id.catch_addegg);
        addEggView = LayoutInflater.from(getActivity())
                .inflate(R.layout.catch_addegg,null);
        addEggView.setLayoutParams(params);
        addEggView.setOnClickListener(this);
        addEgg.addView(addEggView);

        name = (EditText) view.findViewById(R.id.fish_name);
        mount = (EditText) view.findViewById(R.id.ovum_seedlings_num);
        eggMount = (EditText) view.findViewById(R.id.fish_ovum_num);
        fishMount = (EditText) view.findViewById(R.id.kid_fish_num);

        addPic = (GridLayout) view.findViewById(R.id.catch_addpic);
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
            case R.id.add_fish:

                Toast.makeText(getActivity(), "鱼", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_egg:

                Toast.makeText(getActivity(), "卵", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_pic:

                Toast.makeText(getActivity(), "照片", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ensure:

                Toast.makeText(getActivity(), "确定", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
