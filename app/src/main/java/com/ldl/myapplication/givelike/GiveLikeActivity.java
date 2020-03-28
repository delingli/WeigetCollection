package com.ldl.myapplication.givelike;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ldl.dllibrary.weiget.givelike.DLCustomGiveLikeView;
import com.ldl.myapplication.R;

public class GiveLikeActivity extends AppCompatActivity {
    public static void startActivity(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, GiveLikeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_givelike);
//        DLCustomGiveLikeView
        DLCustomGiveLikeView mDLCustomGiveLikeView = findViewById(R.id.dl_likeview);
        mDLCustomGiveLikeView.addOnItemClickListener(new DLCustomGiveLikeView.OnItemClickListener() {
            @Override
            public void onItemClick(boolean liked) {
                Toast.makeText(GiveLikeActivity.this, "点赞?" + liked, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
