package com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.R;

/**
 * 分配任务
 */
public class DistributeTaskFragment extends Fragment {


    public DistributeTaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_distribute_task, container, false);
        init(view);
        return view;
    }

    private void init(View view){

    }
}
