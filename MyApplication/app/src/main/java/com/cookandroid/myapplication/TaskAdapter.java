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

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.CustomViewHolder> {

    private ArrayList<TaskData> taskList;

    public TaskAdapter(ArrayList<TaskData> taskList) {
        this.taskList = taskList;
    }

    // 리스트 뷰 메뉴가 처음으로 생성될 때
    @NonNull
    @Override
    public TaskAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // item_task_list.xml 파일을 보여줌
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_task, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    // 실제 추가 될 때
    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.CustomViewHolder holder, int position) {
        holder.iv_task_icon.setImageResource(taskList.get(position).getIv_icon());
        holder.tv_task_name.setText(taskList.get(position).getTv_task());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String curName = holder.tv_task_name.getText().toString();
                Toast.makeText(view.getContext(), curName, Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                remove(holder.getAbsoluteAdapterPosition());
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != taskList ? taskList.size() : 0);
    }


    public void remove(int position) {
        try {
            taskList.remove(position);
            notifyItemRemoved(position);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        protected ImageView iv_task_icon;
        protected TextView tv_task_name;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            this.iv_task_icon = (ImageView) itemView.findViewById(R.id.iv_task_icon);
            this.tv_task_name = (TextView)itemView.findViewById(R.id.tv_task_name);
        }
    }
}
