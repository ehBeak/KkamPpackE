package com.cookandroid.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.CustomViewHolder> implements ItemTouchHelperListener{

    private ArrayList<DailyData> dailyList;

    public DailyAdapter(ArrayList<DailyData> dailyList) {
        this.dailyList = dailyList;
    }

    @NonNull
    @Override
    public DailyAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_daily, parent, false);
        DailyAdapter.CustomViewHolder holder = new DailyAdapter.CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DailyAdapter.CustomViewHolder holder, int position) {
        holder.iv_daily_icon.setImageResource(dailyList.get(position).getIv_icon());
        holder.tv_daily_name.setText(dailyList.get(position).getTv_task());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String curName = holder.tv_daily_name.getText().toString();
                Toast.makeText(view.getContext(), curName, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != dailyList ? dailyList.size() : 0);
    }

    public void remove(int position) {
        try {
            dailyList.remove(position);
            notifyItemRemoved(position);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void setItems(ArrayList<DailyData> dailyList) {
        this.dailyList = dailyList;
        notifyDataSetChanged();
    }

    @Override
    public boolean onItemMove(int from_position, int to_position) {
        DailyData item = dailyList.get(from_position);
        dailyList.remove(from_position);

        dailyList.add(to_position, item);
        item.setNumber(to_position);
        notifyItemMoved(from_position, to_position);
        return true;
    }

    @Override
    public void onItemSwipe(int position) {
        dailyList.remove(position);
        notifyItemRemoved(position);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView iv_daily_icon;
        protected TextView tv_daily_name;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_daily_icon = (ImageView) itemView.findViewById(R.id.iv_daily_icon);
            this.tv_daily_name = (TextView)itemView.findViewById(R.id.tv_daily_name);
        }

    }
}
