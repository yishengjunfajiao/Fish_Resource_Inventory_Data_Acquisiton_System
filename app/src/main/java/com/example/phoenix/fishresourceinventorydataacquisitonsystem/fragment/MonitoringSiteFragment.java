package com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.phoenix.fishresourceinventorydataacquisitonsystem.R;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.constant.ConstantData;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.MonitoringSite;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.domain.base.BaseNode;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.fragment.base.BaseFragment;
import com.example.phoenix.fishresourceinventorydataacquisitonsystem.utils.AddressUtils;

/**
 * 维护 监测点 界面
 */
@SuppressLint("ValidFragment")
public class MonitoringSiteFragment extends BaseFragment implements View.OnClickListener,
        AdapterView.OnItemSelectedListener {
    //省份名字
    private String provinceStr = null;
    //市在常量表中的下标值
    private int cityIndex;
    //市名字
    private String cityStr = null;
    //新增断面
    private GridLayout addFraSur = null;
    //监测单位
    private EditText detectionUnit = null;
    //监测人员
    private EditText monitors = null;
    //监测日期
    private EditText monitoringDate = null;
    //省
    private Spinner province = null;
    //市
    private Spinner city = null;
    //镇/村
    private EditText village = null;
    //水域
    private EditText waterArea = null;
    //开始时间
    private EditText startTime = null;
    //结束时间
    private EditText endTime = null;
    //天气
    private EditText weather = null;
    //气温
    private EditText temperature = null;
    //起点经度
    private EditText startLongitude = null;
    //起点纬度
    private EditText startLatitude = null;
    //终点经度
    private EditText endLongitude = null;
    //终点纬度
    private EditText endLatitude = null;
    //添加照片
    private GridLayout addPicture = null;
    //起点定位
    private ImageView startLocate = null;
    //终点定位
    private ImageView endLocate = null;
    //确认按钮
    private com.rey.material.widget.Button ensure = null;

    private ArrayAdapter<String> provinceAdapter = null;
    private ArrayAdapter<String> cityAdapter = null;

    //城市在省级常量表中的下标值
    private int cityPosition = 0;

    private View addSurfaceView = null;
    private View addPictureView = null;

    //用于计算GridLayout一个View的大小
    private int size;
    private RelativeLayout.LayoutParams params = null;

    public MonitoringSiteFragment() {
        super(null);
    }

    public MonitoringSiteFragment(BaseNode baseNode) {
        super(baseNode);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_monitoring_site, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        MonitoringSite ms = (MonitoringSite) this.baseNode;
        size = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        params = new RelativeLayout.LayoutParams(size / 5, size / 5);

        addFraSur = (GridLayout) view.findViewById(R.id.mon_site_add_fra_sur);
        addSurfaceView = LayoutInflater.from(getActivity())
                .inflate(R.layout.monitor_site_grid_add_fra_surface, null);
        addSurfaceView.setLayoutParams(params);
        addSurfaceView.setOnClickListener(this);
        addFraSur.addView(addSurfaceView);

        detectionUnit = (EditText) view.findViewById(R.id.detection_unit);
        detectionUnit.setText(ms.getInstitution());

        monitors = (EditText) view.findViewById(R.id.monitors);
        monitors.setText(ms.getInvestigator());

        monitoringDate = (EditText) view.findViewById(R.id.monitoring_date);
        monitoringDate.setText(ms.getInvestigationDate());

        province = (Spinner) view.findViewById(R.id.province);
        provinceAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, ConstantData.PROVINCE);
        province.setAdapter(provinceAdapter);
        province.setSelection(16);
        province.setOnItemSelectedListener(this);

        //对数据库中的地址字段进行处理
        AddressUtils.processAddress(ms.getSite());
        cityPosition = AddressUtils.getCityPosition();
        cityIndex = AddressUtils.getCityIndex();

        city = (Spinner) view.findViewById(R.id.city);
        cityAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, ConstantData.CITY[cityPosition]);
        city.setAdapter(cityAdapter);
        city.setSelection(cityIndex);
        city.setOnItemSelectedListener(this);

        village = (EditText) view.findViewById(R.id.village);
        village.setText(AddressUtils.getAddressDetails());

        waterArea = (EditText) view.findViewById(R.id.water_area);
        waterArea.setText(ms.getRiver());

        startTime = (EditText) view.findViewById(R.id.start_time);
        startTime.setText(ms.getStartTime());

        endTime = (EditText) view.findViewById(R.id.end_time);
        endTime.setText(ms.getEndTime());

        weather = (EditText) view.findViewById(R.id.weather);
        weather.setText(ms.getWeather());

        temperature = (EditText) view.findViewById(R.id.temperature);
        temperature.setText(String.valueOf(ms.getTemperature()));

        startLongitude = (EditText) view.findViewById(R.id.start_longitude);
        startLongitude.setText(String.valueOf(ms.getStartLongitude()));

        startLatitude = (EditText) view.findViewById(R.id.start_latitude);
        startLatitude.setText(String.valueOf(ms.getStartLatitude()));

        endLongitude = (EditText) view.findViewById(R.id.end_longitude);
        endLongitude.setText(String.valueOf(ms.getEndLongitude()));

        endLatitude = (EditText) view.findViewById(R.id.end_latitude);
        endLatitude.setText(String.valueOf(ms.getEndLatitude()));

        startLocate = (ImageView) view.findViewById(R.id.img_start_location);
        startLocate.setOnClickListener(this);
        endLocate = (ImageView) view.findViewById(R.id.img_end_location);
        endLocate.setOnClickListener(this);

        addPicture = (GridLayout) view.findViewById(R.id.mon_site_add_pic);
        addPictureView = LayoutInflater.from(getActivity())
                .inflate(R.layout.grid_view_add_pic, null);
        addPictureView.setLayoutParams(params);
        addPictureView.setOnClickListener(this);
        addPicture.addView(addPictureView);

        ensure = (com.rey.material.widget.Button) view.findViewById(R.id.ensure);
        ensure.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_fra_surface:

                Toast.makeText(getActivity(), "添加断面", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_start_location:

                Toast.makeText(getActivity(), "起点定位", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_end_location:

                Toast.makeText(getActivity(), "终点定位", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_pic:

                Toast.makeText(getActivity(), "照片", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ensure:

                Toast.makeText(getActivity(), "确定", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.province:
                provinceStr = ConstantData.PROVINCE[position];
                cityPosition = position;
                cityAdapter = new ArrayAdapter<>(getActivity(),
                        android.R.layout.simple_spinner_item, ConstantData.CITY[position]);
                city.setAdapter(cityAdapter);
                city.setSelection(0);
                break;
            case R.id.city:
                Log.e("OnItemSelected", ConstantData.CITY[cityPosition][position]);
                cityIndex = position;
                cityStr = ConstantData.CITY[cityPosition][position];
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public BaseNode save() {
        MonitoringSite monitorSiteNode = null;
        if (this.baseNode != null) {
            monitorSiteNode = (MonitoringSite) this.baseNode;
        } else {
            return null;
        }
        String detectionUnitStr = detectionUnit.getText().toString(); //检测单位
        String monitorsStr = monitors.getText().toString(); //检测人员
        String monitoringDateStr = monitoringDate.getText().toString(); //日期
        String addressDetails = village.getText().toString(); //详细地址
        String waterAreaStr = waterArea.getText().toString(); //水域
        String startTimeStr = startTime.getText().toString();
        String endTimeStr = endTime.getText().toString();
        String weatherStr = weather.getText().toString();
        String temperatureStr = temperature.getText().toString();
        String startLatitudeStr = startLatitude.getText().toString();
        String startLongitudeStr = startLongitude.getText().toString();
        String endLatitudeStr = endLatitude.getText().toString();
        String endLongitudeStr = endLongitude.getText().toString();

        monitorSiteNode.setInstitution(detectionUnitStr);
        monitorSiteNode.setInvestigator(monitorsStr);
        monitorSiteNode.setInvestigationDate(monitoringDateStr);
        monitorSiteNode.setSite(String.valueOf(cityPosition) + "|" + String.valueOf(cityIndex) + "$" + addressDetails);
        monitorSiteNode.setRiver(waterAreaStr);
        monitorSiteNode.setStartTime(startTimeStr);
        monitorSiteNode.setEndTime(endTimeStr);
        monitorSiteNode.setWeather(weatherStr);
        monitorSiteNode.setTemperature(Float.valueOf(temperatureStr));
        monitorSiteNode.setStartLatitude(Float.valueOf(startLatitudeStr));
        monitorSiteNode.setStartLongitude(Float.valueOf(startLongitudeStr));
        monitorSiteNode.setEndLatitude(Float.valueOf(endLatitudeStr));
        monitorSiteNode.setEndLongitude(Float.valueOf(endLongitudeStr));

        return monitorSiteNode;
    }
}
