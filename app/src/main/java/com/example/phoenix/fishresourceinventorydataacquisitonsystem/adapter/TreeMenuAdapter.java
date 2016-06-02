package com.example.phoenix.fishresourceinventorydataacquisitonsystem.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.R;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.Benthos;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.CatchTools;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.Catches;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.DominantBenthosSpecies;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.DominantPhytoplanktonSpecies;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.DominantZooplanktonSpecies;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.FishEggs;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.FishRoot;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.Fishes;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.FractureSurface;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.MeasuringLine;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.MeasuringPoint;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.MonitoringSite;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.Phytoplankton;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.Sediment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.WaterLayer;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.Zooplankton;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;


/**
 * Created by Phoenix on 2016/5/31.
 */
public class TreeMenuAdapter extends BaseAdapter {

    private TreeList<BaseNode> list;
    private Context context;

    public TreeMenuAdapter(Context context, TreeList<BaseNode> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.getShownNodeSize();
    }

    @Override
    public Object getItem(int position) {
        return list.getItemInShownList(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View inflate = null;
        BaseNode node = list.getItemInShownList(position);
        if (node instanceof MonitoringSite) {
            inflate = View.inflate(context, R.layout.item_monitoring_site, null);
        } else if (node instanceof FractureSurface) {
            inflate = View.inflate(context, R.layout.item_fracture_surface, null);
        } else if (node instanceof MeasuringLine) {
            inflate = View.inflate(context, R.layout.item_measuring_line, null);
        } else if (node instanceof MeasuringPoint) {
            inflate = View.inflate(context, R.layout.item_measuring_point, null);
        } else if (node instanceof Benthos) {
            inflate = View.inflate(context, R.layout.item_benthos, null);
        } else if (node instanceof Catches) {
            inflate = View.inflate(context, R.layout.item_catches, null);
        } else if (node instanceof CatchTools) {
            inflate = View.inflate(context, R.layout.item_catch_tools, null);
        } else if (node instanceof DominantBenthosSpecies) {
            inflate = View.inflate(context, R.layout.item_dominant_benthos_species, null);
        } else if (node instanceof DominantPhytoplanktonSpecies) {
            inflate = View.inflate(context, R.layout.item_dominant_phytoplankton, null);
        } else if (node instanceof DominantZooplanktonSpecies) {
            inflate = View.inflate(context, R.layout.item_dominant_benthos_species, null);
        } else if (node instanceof FishEggs) {
            inflate = View.inflate(context, R.layout.item_fisheggs, null);
        } else if (node instanceof Fishes) {
            inflate = View.inflate(context, R.layout.item_fishes, null);
        } else if (node instanceof Phytoplankton) {
            inflate = View.inflate(context, R.layout.item_phytoplankton, null);
        } else if (node instanceof Sediment) {
            inflate = View.inflate(context, R.layout.item_sediment, null);
        } else if (node instanceof WaterLayer) {
            inflate = View.inflate(context, R.layout.item_water_layer, null);
        } else if (node instanceof Zooplankton) {
            inflate = View.inflate(context, R.layout.item_water_layer, null);
        } else if (node instanceof FishRoot) {
            inflate = View.inflate(context, R.layout.item_tree_menu_root, null);
        }
        TextView tv = (TextView) inflate.findViewById(R.id.tv);
        tv.setText(node.toString());
        return inflate;
    }

    public TreeList<BaseNode> getTreeList() {
        return list;
    }

    public void setTreeList(TreeList<BaseNode> list) {
        this.list = list;
    }

    private void changeNodeState(int index) {
        list.changeNodeState(index);
    }

    public BaseNode onItemClick(int index) {
        changeNodeState(index);
        notifyDataSetChanged();
        return this.list.getItemInShownList(index);
    }

}
