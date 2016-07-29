package com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.FractureSurface;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.base.BaseFragment;

/**
 * 维护 断面 界面
 */
@SuppressLint("ValidFragment")
public class FractureSurfaceFragment extends BaseFragment implements View.OnClickListener,
        AdapterView.OnItemSelectedListener {

    private int samplePosition = 0;

    //新增测线
    private GridLayout addMeaLine = null;
    //采样方位
    private Spinner samplingPosition = null;
    //距岸距离
    private EditText distanceFromShore = null;
    //添加沉积物
    private GridLayout addSediment = null;
    //添加浮游动物
    private GridLayout addZooplankton = null;
    //添加浮游植物
    private GridLayout addPhytoplankton = null;
    //添加底栖生物
    private GridLayout addBenthicOrganism = null;
    //确认按钮
    private com.rey.material.widget.Button ensure = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    private View addMeaLineView = null;
    private View addSedimentView = null;
    private View addZooplanktonView = null;
    private View addPhytoplanktonView = null;
    private View addBenthicOrganismView = null;

    private ArrayAdapter<String> samplingPositionAdapter = null;

    public FractureSurfaceFragment() {
        super(null);
    }

    public FractureSurfaceFragment(BaseNode baseNode) {
        super(baseNode);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fracture_surface, container, false);
        init(view);
        return view;
    }

    private void init(View view) {

        FractureSurface fs = (FractureSurface) this.baseNode;

        size = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size / 5, size / 5);

        addMeaLine = (GridLayout) view.findViewById(R.id.fra_sur_add_mea_line);
        addMeaLineView = LayoutInflater.from(getActivity())
                .inflate(R.layout.fra_sur_add_mea_line, null);
        addMeaLineView.setLayoutParams(params);
        addMeaLineView.setOnClickListener(this);
        addMeaLine.addView(addMeaLineView);

        samplingPosition = (Spinner) view.findViewById(R.id.sampling_position);
        samplingPositionAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, ConstantData.SAMPLEPOSITION);
        samplingPosition.setAdapter(samplingPositionAdapter);
        samplingPosition.setOnItemSelectedListener(this);

        //根据传入的节点设置初始值
        if (fs.getPosition() != null && !fs.getPosition().equals("")) {
            samplingPosition.setSelection(Integer.parseInt(fs.getPosition()));
        }

        distanceFromShore = (EditText) view.findViewById(R.id.distance_from_shore);
        distanceFromShore.setText(String.valueOf(fs.getDistance2Bank()));

        addSediment = (GridLayout) view.findViewById(R.id.fra_sur_add_sediment);
        addSedimentView = LayoutInflater.from(getActivity())
                .inflate(R.layout.fra_sur_add_sediment, null);
        addSedimentView.setLayoutParams(params);
        addSedimentView.setOnClickListener(this);
        addSediment.addView(addSedimentView);

        addZooplankton = (GridLayout) view.findViewById(R.id.fra_sur_add_zooplankton);
        addZooplanktonView = LayoutInflater.from(getActivity())
                .inflate(R.layout.fra_sur_add_zooplankton, null);
        addZooplanktonView.setLayoutParams(params);
        addZooplanktonView.setOnClickListener(this);
        addZooplankton.addView(addZooplanktonView);

        addPhytoplankton = (GridLayout) view.findViewById(R.id.fra_sur_add_phytoplankton);
        addPhytoplanktonView = LayoutInflater.from(getActivity())
                .inflate(R.layout.fra_sur_add_phytoplankton, null);
        addPhytoplanktonView.setLayoutParams(params);
        addPhytoplanktonView.setOnClickListener(this);
        addPhytoplankton.addView(addPhytoplanktonView);

        addBenthicOrganism = (GridLayout) view.findViewById(R.id.fra_sur_add_benthic_organism);
        addBenthicOrganismView = LayoutInflater.from(getActivity())
                .inflate(R.layout.fra_sur_add_benthic_organism, null);
        addBenthicOrganismView.setLayoutParams(params);
        addBenthicOrganismView.setOnClickListener(this);
        addBenthicOrganism.addView(addBenthicOrganismView);

        ensure = (com.rey.material.widget.Button) view.findViewById(R.id.ensure);
        ensure.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_mea_line:

                Toast.makeText(getActivity(), "添加测线", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_sediment:

                Toast.makeText(getActivity(), "添加沉积物", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_zooplankton:

                Toast.makeText(getActivity(), "添加浮游动物", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_phytoplankton:

                Toast.makeText(getActivity(), "添加浮游植物", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_benthic_organism:

                Toast.makeText(getActivity(), "添加底栖生物", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ensure:

                Toast.makeText(getActivity(), "确定", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.sampling_position:
                Log.e("position", String.valueOf(position));
                samplePosition = position;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public BaseNode save() {
        FractureSurface fs = null;
        if (this.baseNode != null) {
            fs = (FractureSurface) this.baseNode;
            fs.setPosition(String.valueOf(samplePosition));
            fs.setDistance2Bank(Float.parseFloat(distanceFromShore.getText().toString()));

            return fs;
        } else {
            return null;
        }
    }
}
