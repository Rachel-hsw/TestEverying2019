package com.test.hsw.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.test.hsw.R;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    private List<String> strings;

    public RvAdapter(List<String> strings) {
        this.strings = strings;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        //返回适配器持有的数据集中数据的总数
        return strings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.img);

        }
    }
}
