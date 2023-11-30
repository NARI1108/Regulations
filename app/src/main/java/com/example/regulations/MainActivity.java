package com.example.regulations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    TextView txt_time;
    int time=1200000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        snackBar();
        timer();
    }
//    This method is for connecting views from the XML layer to this layer.
    public void findViews(){
        coordinatorLayout = findViewById(R.id.coordinator);
        txt_time = findViewById(R.id.txt_time);
    }
//    This method is for a box at the bottom of the app that represents the snack bar.
    public void snackBar(){
        String result ="این یک متن تستی است.", text = "تلاش دوباره";
        Snackbar mysnackbar = Snackbar.make(coordinatorLayout,result,Snackbar.LENGTH_SHORT);
        mysnackbar.setDuration(15000);
        mysnackbar.show();
        mysnackbar.setAction(text, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
        View snack_View = mysnackbar.getView();
        snack_View.setBackgroundColor(getResources().getColor(R.color.orange));
        TextView textView = snack_View.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.BLUE);
    }
//    This method is for counting time.
    private void timer(){
        String result ="زمان به پایان رسید";
        time-=1000;
        txt_time.setText(formatTime(time));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(time == 0){
                      Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                }else {
                    timer();
                }
            }
        }, 1000);
    }
    private String formatTime(int time){
        int second = (time/1000);
        int minute = (second/60);
        second%=60;
        return "زمان باقیمانده:" + String.format(Locale.ENGLISH, "%02d", second) + " : " + String.format(Locale.ENGLISH,"%20d",minute);
    }
    public void btnClick(View view){

      Intent msg = new Intent(Intent.ACTION_VIEW);
      msg.setData(Uri.parse("https://telegram.com/Nr_Ai80"));
      startActivity(msg);
    }
}