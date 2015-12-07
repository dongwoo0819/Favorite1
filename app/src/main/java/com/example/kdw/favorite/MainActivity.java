package com.example.kdw.favorite;




import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;


import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.kdw.favorite.board.BoardHttpTask;


public class MainActivity extends AppCompatActivity {

    ActionBarDrawerToggle actionBarDrawerToggle;
    ListView listView;
    DrawerLayout drawerLayout;
    FrameLayout contantFrame;

    FragmentManager fragmentManager;
    FragmentTransaction transaction;

    ViewPager viewPager;
    MyPagerAdapter myPagerAdapter;

    String TAG = getClass().getName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*drawerLayout*/
        listView = (ListView) findViewById(R.id.listView);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);




        /*서랍을 열고 닫는 기능을 가진 토글 버튼!!*/
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.closed);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        /*fragment 설정*/
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myPagerAdapter);
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();

        // 탭레이아웃에 viewpager 추가  탭 메뉴 이름은 myPagerAdapter 지정
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);



        /*서랍과 서랍 상태리스너와의 연결*/
        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        /*DrawerLayout 에서 리스트 뷰의 아이템이 선택될때 서랍을 닫고 해당컨텐츠 나오게*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        contantFrame.setBackgroundColor(Color.RED);
                        break;
                }
                drawerLayout.closeDrawer(listView);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }


}
