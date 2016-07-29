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
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Phytoplankton;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.base.BaseFragment;

/**
 * 维护 浮游植物 界面
 */
@SuppressLint("ValidFragment")
public class PhytoplanktonFragment extends BaseFragment implements View.OnClickListener {
    //新增优势种
    private GridLayout addDominantSpecies = null;
    //数量
    private EditText mount = null;
    //生物量
    private EditText biomass = null;
    //添加照片
    private GridLayout addPic = null;
    //确认按钮
    private com.rey.material.widget.Button ensure = null;

    private View addDominantSpeciesView = null;
    private View addPicView = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    public PhytoplanktonFragment() {
        super(null);
    }

    public PhytoplanktonFragment(BaseNode baseNode) {
        super(baseNode);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_phytoplankton, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        Phytoplankton p = (Phytoplankton) this.baseNode;

        size = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size / 5, size / 5);

        addDominantSpecies = (GridLayout) view.findViewById(R.id.phy_add_dom_spe);
        addDominantSpeciesView = LayoutInflater.from(getActivity())
                .inflate(R.layout.add_dom_spe, null);
        addDominantSpeciesView.setLayoutParams(params);
        addDominantSpeciesView.setOnClickListener(this);
        addDominantSpecies.addView(addDominantSpeciesView);

        mount = (EditText) view.findViewById(R.id.mount);
        mount.setText(String.valueOf(p.getQuality()));

        biomass = (EditText) view.findViewById(R.id.biomass);
        biomass.setText(String.valueOf(p.getBiomass()));

        addPic = (GridLayout) view.findViewById(R.id.phy_add_pic);
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
            case R.id.add_dom_spe:

                Toast.makeText(getActivity(), "优势种", Toast.LENGTH_SHORT).show();
                break;
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
        Phytoplankton p = (Phytoplankton) this.baseNode;
        if (this.baseNode != null) {
            p.setQuality(Integer.parseInt(mount.getText().toString()));
            p.setBiomass(Float.parseFloat(biomass.getText().toString()));
        }
        return p;
    }
}
