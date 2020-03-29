package com.ldl.myapplication.horizontalprogressbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ldl.dllibrary.weiget.givelike.DLCustomGiveLikeView;
import com.ldl.dllibrary.weiget.horizontalprogressbar.HorizontalProgressBar;
import com.ldl.myapplication.R;

public class HorizontalProgressBarActivity extends AppCompatActivity {

    private HorizontalProgressBar progress_horizontal;

    public static void startActivity(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, HorizontalProgressBarActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontalprogress);
        progress_horizontal = findViewById(R.id.progress_horizontal);

        //        DLCustomGiveLikeView
    }

    boolean canClick = true;

    public void start(View v) {
        if (!canClick) {
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                canClick = !canClick;
                try {
                    for (int i = 1; i <= 100; i++) {
                        Thread.sleep(200);
                        progress_horizontal.setProgress(i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }).start();


    }
}
