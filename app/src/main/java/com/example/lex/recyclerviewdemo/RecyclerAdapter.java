package com.example.lex.recyclerviewdemo;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * adapter
 *
 * Created by lex on 16/4/9.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{

    private List<String> mList;

    public void setList(List<String> list){
        this.mList = list;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        RecyclerViewHolder holder = new RecyclerViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "呵呵", Snackbar.LENGTH_LONG).show();
            }
        });
        return holder;
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        if(mList != null && mList.size() > position) {
            holder.textView.setText(mList.get(position));
        }
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public RecyclerViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.text);
        }
    }
}
