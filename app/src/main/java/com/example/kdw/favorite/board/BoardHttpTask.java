package com.example.kdw.favorite.board;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.kdw.favorite.MarketAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by kdw on 2015-12-06.
 */
public class BoardHttpTask extends AsyncTask<Object,Void,Context> {
    URL url;
    HttpURLConnection con;
    StringBuffer buf;
    String TAG = getClass().getName();
    BoardCommon common;
    List list;
    MarketAdapter marketAdapter;
    ArrayAdapter<String> stringArrayAdapter;
    String flag;
    @Override
    protected Context doInBackground(Object... params) {
        common = new BoardCommon();


        // 주소 설정
        String uri = (String)params[0];
        // context 보유
        Context context = (Context)params[1];
        flag = (String)params[2];
        if(flag.equals("market")){
            // MarketAdapter 보유
            marketAdapter = (MarketAdapter)params[3];
        }else if(flag.equals("area") || flag.equals("business")  ){
            stringArrayAdapter =(ArrayAdapter)params[3];
        }

        try {
            Log.d(TAG, "주소 :"+ uri);
            url = new URL(uri);
            con = (HttpURLConnection)url.openConnection();
            // 응답 읽음 데이터 설정
            con.setDoInput(true);
            // 요청 보내기 데이터 설정
            con.setDoOutput(true);
            // 메서드 설정
            con.setRequestMethod("POST");

            int code = con.getResponseCode();
            // 응답 값이 정상적으로 왔는지 확인
            Log.d(TAG, "응답값"+ code);
            buf = new StringBuffer();
            String tmpBuf= "";
            if(code == 200){
                BufferedReader  bufferedR= new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
                // 라인 값이 널이 아닐때
                while( ( tmpBuf = bufferedR.readLine() ) != null ) {
                    // 스트링버퍼에 추가
                    buf.append(tmpBuf);
                }
                bufferedR.close();
            }

            if(flag.equals("market")){
                list = common.maketJson(buf.toString());
            }else if(flag.equals("area")){
                list = common.areaJson(buf.toString());
            }else if(flag.equals("business")){
                list = common.businessJson(buf.toString());
            }

            Log.d(TAG, "배열 길이"+ list.size());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        return context;
    }

    @Override
    protected void onPostExecute(Context context) {
        if(flag.equals("market")){
            // 통신후 파싱이 다 끝나면 lisview 갱신
            marketAdapter.setInit(context,list);
        }else if(flag.equals("area") || flag.equals("business")){
            for (int i=0; i <list.size(); i++){
                if(flag.equals("area")){
                    Area area = (Area)list.get(i);
                    stringArrayAdapter.add(area.getArea_name());
                }else {
                    Business business = (Business) list.get(i);
                    stringArrayAdapter.add(business.getBusiness_name());
                }
            }
            stringArrayAdapter.notifyDataSetChanged();
        }


        super.onPostExecute(context);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
