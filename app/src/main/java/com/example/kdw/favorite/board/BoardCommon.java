package com.example.kdw.favorite.board;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kdw on 2015-12-07.
 */
public class BoardCommon {

    Gson gson;
    public List<Market> maketJson(String mData){
        List<Market> list = new ArrayList();
        gson = new Gson();
        Market[] markets = gson.fromJson(mData,Market[].class);
        for(int i= 0; i < markets.length;i++){
                list.add(markets[i]);
        }
        return list;
    }

    public List<Area> areaJson(String aData){
        List<Area> list = new ArrayList<Area>();
        gson = new Gson();
        Area[] areas = gson.fromJson(aData,Area[].class);
        for (int i=0; i < areas.length; i++){
            list.add(areas[i]);
        }
        return  list;
    }

    public List<Business> businessJson(String aData){
        List<Business> list = new ArrayList<Business>();
        gson = new Gson();
        Business[] businesses = gson.fromJson(aData,Business[].class);
        for (int i=0; i < businesses.length; i++){
            list.add(businesses[i]);
        }
        return  list;
    }

}
