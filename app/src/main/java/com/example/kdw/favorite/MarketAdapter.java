package com.example.kdw.favorite;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kdw.favorite.board.Market;

import java.util.Iterator;
import java.util.List;

/**
 * Created by kdw on 2015-12-07.
 */
public class MarketAdapter extends BaseAdapter{
    Context context;
    TextView item_title;
    TextView item_area;
    TextView item_business;

    String TAG = getClass().getName();
    List<Market> list;
    int count =0;


    @Override
    public int getCount() {
        return count;
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

        View view = null;
        Log.d(TAG," 포시션 "+position);
        if(convertView  == null){


            LayoutInflater iterator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = iterator.inflate(R.layout.marketitem,parent,false);
            view.setId(position);
           item_title  = (TextView)view.findViewById(R.id.item_title);
           item_area  = (TextView)view.findViewById(R.id.item_area);
           item_business  = (TextView)view.findViewById(R.id.item_business);
            Log.d(TAG," 포시션 "+list.get(position).getMarket_title());
            item_title.setText(list.get(position).getMarket_title());
            item_area.setText(list.get(position).getArea().getArea_name());
            item_business.setText(list.get(position).getBusiness().getBusiness_name());
        }else{
            view = convertView;
        }


        return view;
    }

    public void setInit(Context context, List<Market> list){
        this.context = context;
        this.list = list;
        count = list.size();
        this.notifyDataSetChanged();
    }
}
