package com.example.lex.recyclerviewdemo;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * 监听器
 *
 * Created by lex on 16/5/12.
 */
public abstract class OnItemClickListener implements RecyclerView.OnItemTouchListener{

    private RecyclerView recyclerView;
    private GestureDetectorCompat gestureDetectorCompat;

    public OnItemClickListener(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        gestureDetectorCompat = new GestureDetectorCompat(recyclerView.getContext(), new ItemTouchHelperGestureListener());

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        gestureDetectorCompat.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        gestureDetectorCompat.onTouchEvent(e);
    }

    public abstract void onItemClick(RecyclerView.ViewHolder holder, int position);

    private class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            View view = recyclerView.findChildViewUnder(e.getX(), e.getY());
            if(view != null) {
                onItemClick(recyclerView.getChildViewHolder(view), recyclerView.getChildLayoutPosition(view));
            }
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }
    }
}
