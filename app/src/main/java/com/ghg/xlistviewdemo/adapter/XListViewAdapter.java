package com.ghg.xlistviewdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ghg.xlistviewdemo.R;

import java.util.List;

/**
 * @Description: 描述
 * @AUTHOR 刘楠  Create By 2016/9/14 0014 10:27
 */
public class XListViewAdapter extends BaseAdapter {

    Context mContext;
    List<String> mDatas;
    public  XListViewAdapter(Context context ,List<String> datas){
        mContext = context;
        mDatas = datas;
    }
    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;

        if(convertView==null){
            convertView = View.inflate(mContext,R.layout.item_listview,null);
            holder = new ViewHolder();
            holder.mTvContent= (TextView) convertView.findViewById(R.id.tvContent);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }


        String str = mDatas.get(position);

        holder.mTvContent.setText(str);

        return convertView;
    }


    public static   class ViewHolder{

        TextView mTvContent;

    }

    public void addHeaderDatas(List<String> headerDatas){
        mDatas.addAll(0,headerDatas);
        notifyDataSetChanged();
    }

    public void addFooterDatas(List<String> footerDatas){
        mDatas.addAll(footerDatas);
        notifyDataSetChanged();
    }
}
