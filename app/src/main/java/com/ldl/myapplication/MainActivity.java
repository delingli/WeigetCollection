package com.ldl.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ldl.myapplication.givelike.GiveLikeActivity;
import com.ldl.myapplication.locusset.LocusSetActivity;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleview;
    private GridLayoutManager mGridLayoutManager;
    private MainRecycleAdapter mMainRecycleAdapter;
    private List<MainItem> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycleview = findViewById(R.id.recycleview);
        mGridLayoutManager = new GridLayoutManager(MainActivity.this, 3);
        mRecycleview.setLayoutManager(mGridLayoutManager);
        String[] strs = getResources().getStringArray(R.array.main_item);
        mList = new ArrayList<>();
        MainItem mainItem;
        for (String s : strs) {
            mainItem = new MainItem();
            mainItem.title = s;
            mList.add(mainItem);
        }
        mMainRecycleAdapter = new MainRecycleAdapter(getApplicationContext(), mList, 0);
        mRecycleview.setAdapter(mMainRecycleAdapter);
        mMainRecycleAdapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                if (position == 0) {
                    LocusSetActivity.startActivity(MainActivity.this);
                } else if (position == 1) {
                    GiveLikeActivity.startActivity(MainActivity.this);
                } else {
                    Toast.makeText(MainActivity.this, "敬请等待", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
