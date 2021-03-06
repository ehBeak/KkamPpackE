package com.cookandroid.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHome extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // view 설정
    private View view;

    /* recycler view 변수 설정: task */
    private ArrayList<TaskData> taskDataArrayList;
    private TaskAdapter taskAdapter;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;

    /* recycler view 변수 설정: daily */
    private ArrayList<DailyData> dailyDataArrayList;
    private DailyAdapter dailyAdapter;
    private RecyclerView dailyrecyclerView;
    private GridLayoutManager dailygridLayoutManager;

    /* drag&drop: task, daily */
    private ItemTouchHelper itemTouchHelper;
    private ItemTouchHelper itemTouchHelperDaily;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentHome.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentHome newInstance(String param1, String param2) {
        FragmentHome fragment = new FragmentHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        /* recycler view: task */
        view = inflater.inflate(R.layout.fragment_home, container,false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview_checklist);

        gridLayoutManager = new GridLayoutManager(view.getContext(), 3);

        recyclerView.setLayoutManager(gridLayoutManager);

        taskDataArrayList = new ArrayList<>();

        taskAdapter = new TaskAdapter(taskDataArrayList);

        recyclerView.setAdapter(taskAdapter);

        /* recycler view: daily */
        dailyrecyclerView = (RecyclerView)view.findViewById(R.id.recyclerview_daily);

        dailygridLayoutManager = new GridLayoutManager(view.getContext(), 3);

        dailyrecyclerView.setLayoutManager(dailygridLayoutManager);

        dailyDataArrayList = new ArrayList<>();

        dailyAdapter = new DailyAdapter(dailyDataArrayList);

        dailyrecyclerView.setAdapter(dailyAdapter);

        /* drag & drop */
        // task
        itemTouchHelper = new ItemTouchHelper(new ItemTouchHelperCallback(taskAdapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);
        // daily
        itemTouchHelperDaily = new ItemTouchHelper(new ItemTouchHelperCallback(dailyAdapter));
        itemTouchHelperDaily.attachToRecyclerView(dailyrecyclerView);


        /* 6개 데이터 각각 추가: task */
        for(int i=0; i<6; i++) {
            TaskData taskData = new TaskData(R.drawable.ic_launcher_background, "task", 0);
            taskDataArrayList.add(taskData);
            taskAdapter.notifyDataSetChanged();
        }

        /* 6개 데이터 각각 추가: daily */
        for(int i=0; i<6; i++) {
            DailyData dailyData = new DailyData(R.drawable.ic_launcher_foreground, "daily", 0);
            dailyDataArrayList.add(dailyData);
            dailyAdapter.notifyDataSetChanged();
        }

        /* btn: task add */
        Button btn_add = (Button)view.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0; i<3; i++) {
                    TaskData taskData = new TaskData(R.drawable.ic_launcher_background, "task", 0);
                    taskDataArrayList.add(taskData);
                    taskAdapter.notifyDataSetChanged();
                }
            }
        });

        /* btn: daily add */
        Button btn_dailyadd = (Button)view.findViewById(R.id.btn_dailyadd);
        btn_dailyadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0; i<3; i++) {
                    DailyData dailyData = new DailyData(R.drawable.ic_launcher_foreground, "daily", 0);
                    dailyDataArrayList.add(dailyData);
                    dailyAdapter.notifyDataSetChanged();
                }
            }
        });

        return view;
    }
}