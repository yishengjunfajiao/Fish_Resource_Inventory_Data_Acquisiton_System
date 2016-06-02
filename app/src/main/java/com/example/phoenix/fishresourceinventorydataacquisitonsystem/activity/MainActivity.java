package com.example.phoenix.fishresourceinventorydataacquisitonsystem.activity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.R;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.adapter.TreeList;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.adapter.TreeMenuAdapter;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.FishRoot;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.FractureSurface;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.MonitoringSite;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.constant.ConstantData;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableIds;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.db.TableNames;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * 维护 监测点 界面
 */
public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener,
        View.OnClickListener {

    public Toolbar toolbar = null;

    private FragmentTransaction transaction = null;
    //记录系统当前时间
    private static long current_time = 0;      //记录系统当前时间

    private TextView name = null;
    private com.thinkcool.circletextimageview.CircleTextImageView headImag = null;

    //树形菜单组件，同时设置每一项的点击监听
    @ViewInject(value = R.id.lv_tree_menu)
    private ListView lv_tree_menu = null;
    private TreeMenuAdapter treeAdapter = null;
    private TreeList<BaseNode> treeDataList = null;

    //设置ListView的点击监听，用于展开或者扩展节点
    @Event(value = R.id.lv_tree_menu, type = AdapterView.OnItemClickListener.class)
    private void openOrCloseMenu(AdapterView<?> parent, View view, int position, long id) {
        if (treeAdapter != null) {
            treeAdapter.onItemClick(position);
        }
    }

    //设置ListView的长按监听，用于添加节点
    @Event(value = R.id.lv_tree_menu, type = AdapterView.OnItemLongClickListener.class)
    private boolean addNewNode(AdapterView<?> parent, View view, int position, long id) throws Exception {
        showAddNodeDialog(position);
        return true;
    }

    private void showAddNodeDialog(final int position) throws Exception {
        //获取被长按的节点，得到能够新添加节点的种类
        List<String> avaliable_node = getAvaliableNode(position);
        if (avaliable_node == null) {
            throw new Exception("no avaliable node");
        }
        //初始化dialog组件，并向其中添加数据
        View dialog_view = View.inflate(this, R.layout.dialog_add_node, null);
        final RadioGroup rg = (RadioGroup) dialog_view.findViewById(R.id.rg_choose_node);
        RadioButton rb;
        for (String node_name : avaliable_node) {
            rb = new RadioButton(this);
            rb.setText(node_name);
            setId(rb, node_name);
            rg.addView(rb);
        }

        //构建对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialog_view);
        final AlertDialog dialog = builder.create();

        TextView btn = (TextView) dialog_view.findViewById(R.id.dialog_choose_new_node_ok);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = rg.getCheckedRadioButtonId();
                Log.e("onclick", String.valueOf(id));
                treeDataList.add(treeDataList.getNodeIndexInTreeList(position) + 1, new MonitoringSite());
                treeAdapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void setId(RadioButton rb, String node_name) {
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
        } else if (node_name.equals(TableIds.WATER_LAYER)) {
            rb.setId(TableIds.WATER_LAYER);
        } else if (node_name.equals(TableNames.ZOOPLANKTON)) {
            rb.setId(TableIds.ZOOPLANKTON);
        } else {
            rb.setId(-1);
        }
    }

    private List<String> getAvaliableNode(int position) {
        BaseNode node = treeDataList.getItemInShownList(position);
        List<String> result = null;
        if (node instanceof FishRoot) {
            result = new ArrayList<>();
            result.add(TableNames.MONITORING_SITE);
        } else if (node instanceof MonitoringSite) {
            result = new ArrayList<>();
            result.add(TableNames.FRACTURE_SURFACE);
        } else if (node instanceof FractureSurface) {
            result = new ArrayList<>();
            result.add(TableNames.MEASURING_LINE);
            result.add(TableNames.SEDIMENT);
            result.add(TableNames.ZOOPLANKTON);
            result.add(TableNames.PHYTOPLANKTON);
            result.add(TableNames.BENTHOS);
        }
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //enable xUtils
        x.view().inject(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("FRIDAS");
        setSupportActionBar(toolbar);

        //初始化抽屉组件
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //连接抽屉，并设置监听器,toggle是一个监听器，这个是可以自由选择是否添加监听
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        init();
    }

    private void init() {

        transaction = getFragmentManager().beginTransaction();

        headImag = (com.thinkcool.circletextimageview.CircleTextImageView) findViewById(R.id.head_image);
        headImag.setOnClickListener(this);

        name = (TextView) findViewById(R.id.name);
        name.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);       //下划线

        initTreeMenu();

        /*tab = (TabLayout) findViewById(R.id.title_tab);
        for(int i = 0;i < ConstantData.TITLE.length;i ++){
            tab.addTab(tab.newTab().setText(ConstantData.TITLE[i]));
        }
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        fragmentList = new ArrayList<>();
        fragmentList.add(new MyTaskFragment());
        fragmentList.add(new DistributeTaskFragment());
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),fragmentList);

        viewPager.setAdapter(pagerAdapter);
        tab.setupWithViewPager(viewPager);*/


        //测试界面
        //transaction.replace(R.id.fragment_container,new SedimentFragment()).commit();

        initTreeMenu();

    }

    private void initTreeMenu() {
        treeDataList = new TreeList<BaseNode>();
        treeDataList.add(new FishRoot());
        treeAdapter = new TreeMenuAdapter(this, treeDataList);
        lv_tree_menu.setAdapter(treeAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if ((System.currentTimeMillis() - current_time) > 2000) {
            Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            current_time = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            //数据提交云端

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.about_us) {

        } else if (id == R.id.login_out) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.head_image:

                Toast.makeText(MainActivity.this, "换头像", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
