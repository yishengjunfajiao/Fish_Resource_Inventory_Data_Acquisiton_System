package com.example.phoenix.fishresourceinventorydataacquisitonsystem.activity;

import android.app.Fragment;
import android.app.FragmentManager;
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
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.dao.DbDao;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.MonitoringSite;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.MonitoringSiteFragment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.base.BaseFragment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.ui.menu.MenuAdapter;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.ui.menu.MenuList;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.DialogUtils;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.MenuUtils;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * 维护 监测点 界面
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        View.OnClickListener {

    public Toolbar toolbar = null;
    private MenuAdapter menuAdapter;
    private FragmentManager fragmentManager = null;
    private MenuList menuList = null;
    private BaseFragment currentFragment = null;

    //记录系统当前时间
    private static long current_time = 0;      //记录系统当前时间

    private TextView name = null;
    private com.thinkcool.circletextimageview.CircleTextImageView headImag = null;

    //树形菜单组件，同时设置每一项的点击监听
    @ViewInject(value = R.id.lv_tree_menu)
    private ListView lv_tree_menu = null;

    //设置ListView的点击监听，用于展开或者扩展节点
    @Event(value = R.id.lv_tree_menu, type = AdapterView.OnItemClickListener.class)
    private void openOrCloseMenu(AdapterView<?> parent, View view, int position, long id) {
        menuAdapter.changeNodeStatus(position);
        menuAdapter.notifyDataSetChanged();
        MenuUtils.showNodeInfo(fragmentManager, menuAdapter, position);
    }

    /**
     * 添加新的检测点
     *
     * @param view
     * @throws Exception
     */
    @Event(value = R.id.add_monitor_site, type = View.OnClickListener.class)
    private void addMonitorSite(View view) throws Exception {
        DialogUtils.showAddNodeDialog(fragmentManager, MainActivity.this, MainActivity.this.menuAdapter, -1);
    }

    //设置ListView的长按监听，用于添加节点
    @Event(value = R.id.lv_tree_menu, type = AdapterView.OnItemLongClickListener.class)
    private boolean addNewNode(AdapterView<?> parent, View view, int position, long id) {
        try {
            DialogUtils.showAddNodeDialog(fragmentManager, MainActivity.this, MainActivity.this.menuAdapter, position);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //enable xUtils
        x.view().inject(this);
        init();
    }

    private void init() {
        fragmentManager = getFragmentManager();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("鱼类管理系统");
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

        headImag = (com.thinkcool.circletextimageview.CircleTextImageView) findViewById(R.id.head_image);
        headImag.setOnClickListener(this);

        name = (TextView) findViewById(R.id.name);
        name.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);       //下划线


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
        menuList = new MenuList();
        MenuUtils.initMenu(MainActivity.this, menuList, fragmentManager);
        menuAdapter = new MenuAdapter(this, menuList);
        lv_tree_menu.setAdapter(menuAdapter);
        MenuUtils.showNodeInfo(fragmentManager, menuAdapter, 0);
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
        if (id == R.id.action_submit_cloud) {
            //数据提交云端
            return true;
        } else if (id == R.id.action_save_native) {
            //数据提交到本地
            DbDao dbDao = new DbDao(MainActivity.this);
            if (currentFragment != null) {
                dbDao.updateNode(currentFragment.save());
            }
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

    public void setCurrentFragment(BaseFragment currentFragment) {
        this.currentFragment = currentFragment;
    }
}
