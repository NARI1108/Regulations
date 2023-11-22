package com.example.regulations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Objects;

public class Exam extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    TextView txt_questions, txt_answer1, txt_answer2, txt_answer3, txt_answer4;
    Button btn_next;
    ImageView img_questions, img_question1, img_question2, img_question3, img_question4;
    LinearLayout layout_1, layout_2;
    long time = 1200000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        findViews();
        setTexts();
        Timer();
    }
//    This method actually connects views and layers from an XML layer to this layer.
    public void findViews(){

        coordinatorLayout = findViewById(R.id.coordinatorLayout);

        txt_questions = findViewById(R.id.txt_questions);

        txt_answer1 = findViewById(R.id.txt_answer1);
        txt_answer2 = findViewById(R.id.txt_answer2);
        txt_answer3 = findViewById(R.id.txt_answer3);
        txt_answer4 = findViewById(R.id.txt_answer4);

        btn_next = findViewById(R.id.btn_next);

        img_questions = findViewById(R.id.img_questions);

        img_question1 = findViewById(R.id.img_answer1);
        img_question2 = findViewById(R.id.img_answer2);
        img_question3 = findViewById(R.id.img_answer3);
        img_question4 = findViewById(R.id.img_answer4);

        layout_1 = findViewById(R.id.layout_1);
        layout_2 = findViewById(R.id.layout_2);
    }
//    This method is actually for setting the texts from the strings section on this layer.
    public void setTexts(){
        txt_questions.setText(R.string.question1);
        txt_answer1.setText(R.string.answer1_1);
        txt_answer2.setText(R.string.answer1_2);
        txt_answer3.setText(R.string.answer1_3);
        txt_answer4.setText(R.string.answer1_4);
    }
//    This time method is for counting time.
    private void Timer(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(time == 0){
                  Objects.requireNonNull(getSupportActionBar()).setTitle("00:00");
                  new AlertDialog.Builder(Exam.this).setMessage(getResources().getString(R.string.result)).show();
                    setEnable(false);
                  btn_next.setEnabled(false);
                }else{
                  time-=1000;
                  Objects.requireNonNull(getSupportActionBar()).setTitle(formatTime(time));
                  Timer();
                }
            }
        }, 1000);
    }
//    The method of creating time in seconds and minutes.
    public String formatTime(long time){
        long second = (time/1000);
        long minute = (second/60);
        second=(second%60);
        return ": زمان باقی مانده"+String.format(Locale.ENGLISH,"%02d",second)+" : "+String.format(Locale.ENGLISH,"%02d",minute);
    }

}