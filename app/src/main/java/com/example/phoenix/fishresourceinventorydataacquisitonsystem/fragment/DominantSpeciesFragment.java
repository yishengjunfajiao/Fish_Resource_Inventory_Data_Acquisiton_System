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
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.DominantBenthosSpecies;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.DominantPhytoplanktonSpecies;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.DominantZooplanktonSpecies;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.base.BaseFragment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.StringUtils;

/**
 * 维护 优势种 界面
 */
@SuppressLint("ValidFragment")
public class DominantSpeciesFragment extends BaseFragment implements View.OnClickListener {
    //数量
    private EditText mount = null;
    //生物量
    private EditText biomass = null;
    //名字
    private EditText name = null;
    //添加照片
    private GridLayout addPic = null;
    //确认按钮
    private com.rey.material.widget.Button ensure = null;

    private View addPicView = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    public DominantSpeciesFragment() {
        super(null);
    }

    public DominantSpeciesFragment(BaseNode baseNode) {
        super(baseNode);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dominant_species, container, false);
        init(view);
        return view;
    }

    private void init(View view) {


        size = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size / 5, size / 5);

        mount = (EditText) view.findViewById(R.id.mount);
        biomass = (EditText) view.findViewById(R.id.biomass);
        name = (EditText) view.findViewById(R.id.name);

        if (this.baseNode instanceof DominantBenthosSpecies) {
            mount.setText(String.valueOf(((DominantBenthosSpecies) this.baseNode).getQuality()));
            biomass.setText(String.valueOf(((DominantBenthosSpecies) this.baseNode).getBiomass()));
            mount.setText(((DominantBenthosSpecies) this.baseNode).getName());
        } else if (this.baseNode instanceof DominantZooplanktonSpecies) {
            mount.setText(String.valueOf(((DominantZooplanktonSpecies) this.baseNode).getQuality()));
            biomass.setText(String.valueOf(((DominantZooplanktonSpecies) this.baseNode).getBiomass()));
            mount.setText(((DominantZooplanktonSpecies) this.baseNode).getName());
        } else if (this.baseNode instanceof DominantPhytoplanktonSpecies) {
            mount.setText(String.valueOf(((DominantPhytoplanktonSpecies) this.baseNode).getQuality()));
            biomass.setText(String.valueOf(((DominantPhytoplanktonSpecies) this.baseNode).getBiomass()));
            mount.setText(((DominantPhytoplanktonSpecies) this.baseNode).getName());
        }

        addPic = (GridLayout) view.findViewById(R.id.dom_add_pic);
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
        if (this.baseNode != null) {

            int mountNum = 0;
            int bimossNum = 0;

            if (!StringUtils.isStringEmpty(mount.getText().toString())) {
                mountNum = Integer.parseInt(mount.getText().toString());
            }

            if (!StringUtils.isStringEmpty(biomass.getText().toString())) {
                bimossNum = Integer.parseInt(biomass.getText().toString());
            }

            if (this.baseNode instanceof DominantBenthosSpecies) {
                DominantBenthosSpecies dbs = (DominantBenthosSpecies) this.baseNode;
                dbs.setBiomass(bimossNum);
                dbs.setQuality(mountNum);
                dbs.setName(name.getText().toString());
                return dbs;
            } else if (this.baseNode instanceof DominantPhytoplanktonSpecies) {
                DominantPhytoplanktonSpecies dbs = (DominantPhytoplanktonSpecies) this.baseNode;
                dbs.setBiomass(bimossNum);
                dbs.setQuality(mountNum);
                dbs.setName(name.getText().toString());
                return dbs;
            } else if (this.baseNode instanceof DominantZooplanktonSpecies) {
                DominantZooplanktonSpecies dbs = (DominantZooplanktonSpecies) this.baseNode;
                dbs.setBiomass(bimossNum);
                dbs.setQuality(mountNum);
                dbs.setName(name.getText().toString());
                return dbs;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
