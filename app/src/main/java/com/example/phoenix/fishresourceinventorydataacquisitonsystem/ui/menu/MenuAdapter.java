package com.example.phoenix.fishresourceinventorydataacquisitonsystem.ui.menu;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.R;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.activity.MainActivity;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Benthos;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.CatchTools;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Catches;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.DominantBenthosSpecies;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.DominantPhytoplanktonSpecies;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.DominantZooplanktonSpecies;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.FishEggs;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Fishes;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.FractureSurface;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.MeasuringLine;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.MeasuringPoint;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.MonitoringSite;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Phytoplankton;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Sediment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.WaterLayer;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.Zooplankton;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.base.BaseFragment;

import java.util.List;

/**
 * Created by Phoenix on 2016/6/23.
 */
public class MenuAdapter extends BaseAdapter {

    private MenuList list;
    private Context context;

    public MenuAdapter(Context context, MenuList list) {
        this.context = context;
        this.list = list;
    }

    /**
     * 获取所有展现出来的节点
     *
     * @return
     */
    public List<TreeNode> getContentList() {
        return list.getShownList();
    }

    public void addNode(TreeNode t, int index) {
        list.addNode(t, index);
    }

    @Override
    public int getCount() {
        return list.getShownList().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View inflate = null;
        TreeNode node = list.getShownList().get(position);
        if (node.getValue() instanceof MonitoringSite) {
            inflate = View.inflate(context, R.layout.item_monitoring_site, null);
        } else if (node.getValue() instanceof FractureSurface) {
            inflate = View.inflate(context, R.layout.item_fracture_surface, null);
        } else if (node.getValue() instanceof MeasuringLine) {
            inflate = View.inflate(context, R.layout.item_measuring_line, null);
        } else if (node.getValue() instanceof MeasuringPoint) {
            inflate = View.inflate(context, R.layout.item_measuring_point, null);
        } else if (node.getValue() instanceof Benthos) {
            inflate = View.inflate(context, R.layout.item_benthos, null);
        } else if (node.getValue() instanceof Catches) {
            inflate = View.inflate(context, R.layout.item_catches, null);
        } else if (node.getValue() instanceof CatchTools) {
            inflate = View.inflate(context, R.layout.item_catch_tools, null);
        } else if (node.getValue() instanceof DominantBenthosSpecies) {
            inflate = View.inflate(context, R.layout.item_dominant_benthos_species, null);
        } else if (node.getValue() instanceof DominantPhytoplanktonSpecies) {
            inflate = View.inflate(context, R.layout.item_dominant_phytoplankton, null);
        } else if (node.getValue() instanceof DominantZooplanktonSpecies) {
            inflate = View.inflate(context, R.layout.item_dominant_benthos_species, null);
        } else if (node.getValue() instanceof FishEggs) {
            inflate = View.inflate(context, R.layout.item_fisheggs, null);
        } else if (node.getValue() instanceof Fishes) {
            inflate = View.inflate(context, R.layout.item_fishes, null);
        } else if (node.getValue() instanceof Phytoplankton) {
            inflate = View.inflate(context, R.layout.item_phytoplankton, null);
        } else if (node.getValue() instanceof Sediment) {
            inflate = View.inflate(context, R.layout.item_sediment, null);
        } else if (node.getValue() instanceof WaterLayer) {
            inflate = View.inflate(context, R.layout.item_water_layer, null);
        } else if (node.getValue() instanceof Zooplankton) {
            inflate = View.inflate(context, R.layout.item_zooplankton, null);
        }
        TextView tv = (TextView) inflate.findViewById(R.id.tv);
        tv.setText(node.getValue().toString());
        return inflate;
    }

    public void changeNodeStatus(int position) {
        if (list.getShownList().get(position).isExtended()) {
            list.close(position);
        } else {
            list.open(position);
        }
    }

    public void showNodeInfo(int position, FragmentTransaction transaction) {
        for (TreeNode t : list.getTotalList()) {
            if (t.getFragment() != null) {
                transaction.hide(t.getFragment());
            }
        }
        BaseFragment f = null;
        if (list.getShownList().size() != 0) {
            f = list.getShownList().get(position).getFragment();
        }
        if (f != null) {
            transaction.show(f);
        }
        ((MainActivity) context).setCurrentFragment(f);
    }
}
