package com.example.kdw.favorite.config;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kdw.favorite.R;


/**
 * Created by jhmfrd on 2015-10-26.
 */
public class ConfigFragment extends android.support.v4.app.Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_config,container,false);
        return view;
    }
}