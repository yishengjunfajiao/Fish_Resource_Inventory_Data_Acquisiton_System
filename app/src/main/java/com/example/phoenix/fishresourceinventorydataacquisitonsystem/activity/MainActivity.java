package com.example.phoenix.fishresourceinventorydataacquisitonsystem.activity;

import android.app.FragmentTransaction;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.R;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.adapter.TreeList;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.adapter.TreeMenuAdapter;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.FishRoot;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.bean.base.BaseNode;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
/**
 * 维护所有的 fragment
 * */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    public Toolbar toolbar = null;

    private FragmentTransaction transaction = null;
    //记录系统当前时间
    private static long current_time = 0;

    private TextView name = null;
    private com.thinkcool.circletextimageview.CircleTextImageView headImag = null;

    //树形菜单组件，同时设置每一项的点击监听
    @ViewInject(value = R.id.lv_tree_menu)
    private ListView lv_tree_menu = null;
    private TreeMenuAdapter treeAdapter = null;
    private TreeList<BaseNode> treeData = null;

    //设置ListView的点击监听，用于展开或者扩展节点
    @Event(value = R.id.lv_tree_menu, type = AdapterView.OnItemClickListener.class)
    private void openOrCloseMenu(AdapterView<?> parent, View view, int position, long id) {
        if (treeAdapter != null) {
            treeAdapter.onItemClick(position);
        }
    }

    //设置ListView的长按监听，用于添加节点
    @Event(value = R.id.lv_tree_menu, type = AdapterView.OnItemLongClickListener.class)
    private boolean addNewNode(AdapterView<?> parent, View view, int position, long id) {

        return true;
    }

    /*private TabLayout tab = null;
    private ViewPager viewPager = null;
    private PagerAdapter pagerAdapter = null;
    private List<Fragment> fragmentList = null;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //enable xUtils
        x.view().inject(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("FRIDAS");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //连接抽屉，并设置监听器,toggle是一个监听器，这个是可以自由选择是否添加监听
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        init();
    }

    private void init(){
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


    }

    private void initTreeMenu() {
        treeData = new TreeList<BaseNode>();
        treeData.add(new FishRoot());
        treeAdapter = new TreeMenuAdapter(this, treeData);
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
        switch (v.getId()){
            case R.id.head_image:

                Toast.makeText(MainActivity.this, "换头像", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
