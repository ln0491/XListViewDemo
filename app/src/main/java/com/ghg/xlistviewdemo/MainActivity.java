package com.ghg.xlistviewdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.ghg.xlistviewdemo.adapter.XListViewAdapter;
import com.ghg.xlistviewdemo.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private XListView mXListView;
    private List<String> mDatas = new ArrayList<>();
    private XListViewAdapter mXListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
    }




    private void initView() {

        mXListView = (XListView) findViewById(R.id.xListView);

    }


    private void initData() {


        for(int i = 0; i <12 ; i++) {

            mDatas.add("Item "+i);
        }

        mXListViewAdapter = new XListViewAdapter(this,mDatas);


        mXListView.setAdapter(mXListViewAdapter);

    }

    private void initListener() {

        mXListView.setOnRefreshListener(new XListView.OnRefreshListener() {
            @Override
            public void onRefresh(XListView xListView) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<String> headDatas = new ArrayList<String>();
                        for (int i = 20; i <30 ; i++) {

                            headDatas.add("Heard Item "+i);
                        }
                        mXListViewAdapter.addHeaderDatas(headDatas);
                        mXListView.stopRefresh();
                        mXListView.setHasLoadMore(false);
                    }
                }, 3000);
            }

            @Override
            public void onLoadMore(XListView xListView) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        List<String> footerDatas = new ArrayList<String>();
                        for (int i = 0; i< 10; i++) {

                            footerDatas.add("footer  item" + i);
                        }
                        mXListViewAdapter.addFooterDatas(footerDatas);

                       mXListView.stopLoadMore(true);
                    }
                }, 3000);
            }
        });
    }
}
