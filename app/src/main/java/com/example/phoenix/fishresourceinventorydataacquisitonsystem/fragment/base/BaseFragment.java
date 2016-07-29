package com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.base;

import android.app.Fragment;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;

/**
 * Created by Phoenix on 2016/7/21.
 */
public abstract class BaseFragment extends Fragment {
    protected BaseNode baseNode = null;

    public BaseFragment(BaseNode baseNode) {
        super();
        this.baseNode = baseNode;
    }

    public abstract BaseNode save();
}
