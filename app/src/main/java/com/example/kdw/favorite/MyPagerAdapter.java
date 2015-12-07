package com.example.kdw.favorite;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.kdw.favorite.board.BoardFragment;
import com.example.kdw.favorite.config.ConfigFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jhmfrd on 2015-10-26.
 */
/*viewPager는 껍데기에 지나지 않기 때문에 FragmentStatePagerAdapter를 상속받는다.
* 어떤 페이지를 총 몇개 보여줄지를 결정하는 어댑터이다.*/
public class MyPagerAdapter extends FragmentStatePagerAdapter {
    /*사용할 프레그먼트 생성*/
    Fragment[] fragments = new Fragment[2];
    List<String> pageTitle = new ArrayList<String>();

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments[0]=new BoardFragment();
        fragments[1]=new ConfigFragment();
        // 탭 메뉴에 들어갈 이름
        pageTitle.add("맞집 정보");
        pageTitle.add("위치 정보");

    }

    public Fragment getItem(int position) {
        return fragments[position];
    }

    public int getCount() {
        return fragments.length;
    }

    // 탭 메뉴에 들어갈 이름
    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitle.get(position);
    }
}
