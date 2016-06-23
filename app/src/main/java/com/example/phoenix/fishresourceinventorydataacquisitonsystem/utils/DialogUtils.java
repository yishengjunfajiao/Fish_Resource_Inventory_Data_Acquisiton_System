package com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.R;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableIds;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;
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
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.menu.MenuAdapter;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.menu.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phoenix on 2016/6/23.
 */
public class DialogUtils {
    public static void showAddNodeDialog(Context context, final MenuAdapter menuAdapter, final int position) throws Exception {
        //获取被长按的节点，得到能够新添加节点的种类
        List<String> avaliable_node = getAvaliableNode(menuAdapter, position);
        if (avaliable_node == null) {
            throw new Exception("no avaliable node.");
        }
        //初始化dialog组件，并向其中添加数据
        View dialog_view = View.inflate(context, R.layout.dialog_add_node, null);
        final RadioGroup rg = (RadioGroup) dialog_view.findViewById(R.id.rg_choose_node);
        RadioButton rb;
        for (String node_name : avaliable_node) {
            rb = new RadioButton(context);
            rb.setText(node_name);
            setId(rb, node_name);
            rg.addView(rb);
        }

        //构建对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(dialog_view);
        final AlertDialog dialog = builder.create();

        TextView btn = (TextView) dialog_view.findViewById(R.id.dialog_choose_new_node_ok);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = rg.getCheckedRadioButtonId();
                Log.e("onclick", String.valueOf(id));
                BaseNode node = null;
                switch (id) {
                    case TableIds.BENTHOS:
                        node = new Benthos();
                        break;
                    case TableIds.CATCH_TOOLS:
                        node = new CatchTools();
                        break;
                    case TableIds.CATCHES:
                        node = new Catches();
                        break;
                    case TableIds.DOMINANT_BENTHOS_SPECIES:
                        node = new DominantBenthosSpecies();
                        break;
                    case TableIds.DOMINANT_PHYTOPLANKTON_SPECIES:
                        node = new DominantPhytoplanktonSpecies();
                        break;
                    case TableIds.DOMINANT_ZOOPLANKTON_SPECIES:
                        node = new DominantZooplanktonSpecies();
                        break;
                    case TableIds.FISH_EGGS:
                        node = new FishEggs();
                        break;
                    case TableIds.FISHES:
                        node = new Fishes();
                        break;
                    case TableIds.FRACTURE_SURFACE:
                        node = new FractureSurface();
                        break;
                    case TableIds.MEASURING_LINE:
                        node = new MeasuringLine();
                        break;
                    case TableIds.MEASURING_POINT:
                        node = new MeasuringPoint();
                        break;
                    case TableIds.MONITORING_SITE:
                        node = new MonitoringSite();
                        break;
                    case TableIds.PHYTOPLANKTON:
                        node = new Phytoplankton();
                        break;
                    case TableIds.SEDIMENT:
                        node = new Sediment();
                        break;
                    case TableIds.WATER_LAYER:
                        node = new WaterLayer();
                        Log.e("test",node.toString());
                        break;
                    case TableIds.ZOOPLANKTON:
                        node = new Zooplankton();
                        break;
                    default:
                        node = null;
                        break;
                }

                if (node != null) {
                    TreeNode t = new TreeNode(node);
                    menuAdapter.addNode(t, position);
                    menuAdapter.notifyDataSetChanged();
                }
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private static void setId(RadioButton rb, String node_name) {
        if (node_name.equals(TableNames.BENTHOS)) {
            rb.setId(TableIds.BENTHOS);
        } else if (node_name.equals(TableNames.CATCHES)) {
            rb.setId(TableIds.CATCHES);
        } else if (node_name.equals(TableNames.CATCH_TOOLS)) {
            rb.setId(TableIds.CATCH_TOOLS);
        } else if (node_name.equals(TableNames.DOMINANT_BENTHOS_SPECIES)) {
            rb.setId(TableIds.DOMINANT_BENTHOS_SPECIES);
        } else if (node_name.equals(TableNames.DOMINANT_PHYTOPLANKTON_SPECIES)) {
            rb.setId(TableIds.DOMINANT_PHYTOPLANKTON_SPECIES);
        } else if (node_name.equals(TableNames.DOMINANT_ZOOPLANKTON_SPECIES)) {
            rb.setId(TableIds.DOMINANT_ZOOPLANKTON_SPECIES);
        } else if (node_name.equals(TableNames.FISH_EGGS)) {
            rb.setId(TableIds.FISH_EGGS);
        } else if (node_name.equals(TableNames.FISHES)) {
            rb.setId(TableIds.FISHES);
        } else if (node_name.equals(TableNames.FRACTURE_SURFACE)) {
            rb.setId(TableIds.FRACTURE_SURFACE);
        } else if (node_name.equals(TableNames.MEASURING_LINE)) {
            rb.setId(TableIds.MEASURING_LINE);
        } else if (node_name.equals(TableNames.MEASURING_POINT)) {
            rb.setId(TableIds.MEASURING_POINT);
        } else if (node_name.equals(TableNames.MONITORING_SITE)) {
            rb.setId(TableIds.MONITORING_SITE);
        } else if (node_name.equals(TableNames.PHYTOPLANKTON)) {
            rb.setId(TableIds.PHYTOPLANKTON);
        } else if (node_name.equals(TableNames.SEDIMENT)) {
            rb.setId(TableIds.SEDIMENT);
        } else if (node_name.equals(TableNames.WATER_LAYER)) {
            rb.setId(TableIds.WATER_LAYER);
        } else if (node_name.equals(TableNames.ZOOPLANKTON)) {
            rb.setId(TableIds.ZOOPLANKTON);
        } else {
            rb.setId(-1);
        }
    }

    private static List<String> getAvaliableNode(MenuAdapter menuAdapter, int position) {
        List<String> result = null;
        if (position == -1) {
            result = new ArrayList<>();
            result.add(TableNames.MONITORING_SITE);
            return result;
        }
        TreeNode node = menuAdapter.getContentList().get(position);
        if (node.getValue() instanceof MonitoringSite) {
            result = new ArrayList<>();
            result.add(TableNames.FRACTURE_SURFACE);
        } else if (node.getValue() instanceof FractureSurface) {
            result = new ArrayList<>();
            result.add(TableNames.MEASURING_LINE);
            result.add(TableNames.SEDIMENT);
            result.add(TableNames.ZOOPLANKTON);
            result.add(TableNames.PHYTOPLANKTON);
            result.add(TableNames.BENTHOS);
        } else if (node.getValue() instanceof Benthos) {
            result = new ArrayList<>();
            result.add(TableNames.DOMINANT_BENTHOS_SPECIES);
        } else if (node.getValue() instanceof Phytoplankton) {
            result = new ArrayList<>();
            result.add(TableNames.DOMINANT_PHYTOPLANKTON_SPECIES);
        } else if (node.getValue() instanceof Zooplankton) {
            result = new ArrayList<>();
            result.add(TableNames.DOMINANT_ZOOPLANKTON_SPECIES);
        } else if (node.getValue() instanceof MeasuringLine) {
            result = new ArrayList<>();
            result.add(TableNames.MEASURING_POINT);
        } else if (node.getValue() instanceof MeasuringPoint) {
            result = new ArrayList<>();
            result.add(TableNames.WATER_LAYER);
        } else if (node.getValue() instanceof WaterLayer) {
            result = new ArrayList<>();
            result.add(TableNames.CATCH_TOOLS);
            result.add(TableNames.CATCHES);
        } else if (node.getValue() instanceof Catches) {
            result = new ArrayList<>();
            result.add(TableNames.FISHES);
            result.add(TableNames.FISH_EGGS);
        }
        return result;
    }


}
