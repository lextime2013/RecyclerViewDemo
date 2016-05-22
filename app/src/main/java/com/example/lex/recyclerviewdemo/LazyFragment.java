package com.example.lex.recyclerviewdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * lazy fragment
 *
 * Created by lex on 16/5/17.
 */
public class LazyFragment extends Fragment{
    protected boolean isVisible = false;
    private boolean isPrepared = false;

    /**
     * frahment从不可见到完全可见的时候，会调用该方法
     *
     * @param isVisibleToUser isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInVisible();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_recycler, container, false);
//        initView();
        isPrepared = true;
        onLazy();
        return view;
    }

    private void onVisible() {
        onLazy();
    }

    private void onInVisible() {

    }

    private void onLazy() {
        if(isPrepared && isVisible) {
            // 在这个方法里面去给我们的Fragment添加数据

            isPrepared = false;
        }
    }
}
