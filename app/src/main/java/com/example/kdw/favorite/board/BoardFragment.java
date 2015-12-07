package com.example.kdw.favorite.board;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.kdw.favorite.MarketAdapter;
import com.example.kdw.favorite.R;

import java.util.ArrayList;


/**
 * ListView와 어댑터 와의 연결
 */
public class BoardFragment extends android.support.v4.app.Fragment{
    ListView listView;
    MarketAdapter marketAdapter;
    /*BoardItemAdapter boardItemAdapter;*/
    Spinner areaSpinner;
    Spinner businessSpinner;
    ArrayAdapter areaAdapter;
    ArrayAdapter businessAdapter;

    String flag;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_board,container,false);
        /*listView=(ListView)view.findViewById(R.id.listView);
        boardItemAdapter=new BoardItemAdapter(this.getContext());
        listView.setAdapter(boardItemAdapter);*/
        // 스피너 적용
        areaSpinner = (Spinner)view.findViewById(R.id.area);
        businessSpinner = (Spinner)view.findViewById(R.id.business);
        ArrayList<String> areaArray = new ArrayList<String>();
        ArrayList<String> businessArray = new ArrayList<String>();
        areaArray.add("전제 지역 ");
        businessArray.add("전체 업종 ");
        areaAdapter = new ArrayAdapter(this.getContext(),R.layout.support_simple_spinner_dropdown_item,areaArray);
        businessAdapter = new ArrayAdapter(this.getContext(),R.layout.support_simple_spinner_dropdown_item,businessArray);
        areaSpinner.setAdapter(areaAdapter);
        businessSpinner.setAdapter(businessAdapter);

        // 지역 정보 불러오기
        flag = "area";
        BoardHttpTask areaHttp = new BoardHttpTask();
        areaHttp.execute("http://70.12.109.53:8080/AreaList.do",this.getContext(),flag,areaAdapter);

        // 업종 정보 불러오기
        flag="business";
        BoardHttpTask businessHttp = new BoardHttpTask();
        businessHttp.execute("http://70.12.109.53:8080/BusinessList.do",this.getContext(),flag,businessAdapter);

        // listview 보유
        listView = (ListView)view.findViewById(R.id.board_list);
        // adapter 생성
        marketAdapter = new MarketAdapter();
        // listview adapter 세팅
        listView.setAdapter(marketAdapter);
        // 가계정보 불러오기
        flag="market";
        BoardHttpTask httpTask = new BoardHttpTask();
        httpTask.execute("http://70.12.109.53:8080/MarketList.do?agree=1",this.getContext(),flag,marketAdapter);

        return view;
    }
}
