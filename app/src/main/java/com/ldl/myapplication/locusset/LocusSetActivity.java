package com.ldl.myapplication.locusset;

import com.ldl.dllibrary.weiget.locuspass.LocusPassView;
import com.ldl.myapplication.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class LocusSetActivity extends Activity {
    public static void startActivity(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, LocusSetActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_locus);
        final SharedPreferences sp = this.getSharedPreferences("data", Context.MODE_PRIVATE);
        LocusPassView locusView = (LocusPassView) this.findViewById(R.id.locusview);
        locusView.setOnCompleteListener(new LocusPassView.OnCompleteListener() {

            @Override
            public void onComplete(String pass) {
                // TODO Auto-generated method stub
                Toast.makeText(LocusSetActivity.this, "设的密码" + pass, Toast.LENGTH_LONG).show();
                sp.edit().putString("password", pass).commit();
//                LocusSetActivity.this.finish();
            }

        });
    }

}
