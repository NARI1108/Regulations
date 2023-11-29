package com.example.regulations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Locale;
import java.util.Objects;

public class Exam extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    TextView txt_questions, txt_answer1, txt_answer2, txt_answer3, txt_answer4;
    Button btn_next;
    ImageView img_questions,  img_answer1,  img_answer2,  img_answer3,  img_answer4;
    LinearLayout layout_1, layout_2;
    long time = 1200000;
    int number=1;
    int incorrect=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        findViews();
        btn_nextOnClick();
        txt_answersOnClick();
        img_answersOnClick();
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

         img_answer1 = findViewById(R.id.img_answer1);
         img_answer2 = findViewById(R.id.img_answer2);
         img_answer3 = findViewById(R.id.img_answer3);
         img_answer4 = findViewById(R.id.img_answer4);

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
//    This method creates the ability to click the button and also sets a series of questions to be displayed.
    public void btn_nextOnClick(){
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEnable(true);
                btn_next.setEnabled(false);
                btn_next.setBackgroundColor(getResources().getColor(R.color.btnDisable));
                layout_1.setVisibility(View.VISIBLE);

                number++;
                txt_answer1.setBackgroundColor(Color.parseColor("#ffffff"));
                txt_answer2.setBackgroundColor(Color.parseColor("#ffffff"));
                txt_answer3.setBackgroundColor(Color.parseColor("#ffffff"));
                txt_answer4.setBackgroundColor(Color.parseColor("#ffffff"));

                img_questions.setVisibility(View.INVISIBLE);

                switch(number){
                    case 2:
                    txt_questions.setText(R.string.question2);
                    img_questions.setImageResource(R.drawable.question2);
                    img_questions.setVisibility(View.VISIBLE);
                    txt_answer1.setText(R.string.answer2_1);
                    txt_answer2.setText(R.string.answer2_2);
                    txt_answer3.setText(R.string.answer2_3);
                    txt_answer4.setText(R.string.answer2_4);
                    break;
                    case 3:
                    txt_questions.setText(R.string.question3);
                    txt_answer1.setText(R.string.answer3_1);
                    txt_answer2.setText(R.string.answer3_2);
                    txt_answer3.setText(R.string.answer3_3);
                    txt_answer4.setText(R.string.answer3_4);
                    break;
                    case 4:
                        txt_questions.setText(R.string.question4);
                        txt_answer1.setText(R.string.answer4_1);
                        txt_answer2.setText(R.string.answer4_2);
                        txt_answer3.setText(R.string.answer4_3);
                        txt_answer4.setText(R.string.answer4_4);
                        break;
                    case 5:
                        txt_questions.setText(R.string.question5);
                        txt_answer1.setText(R.string.answer5_1);
                        txt_answer2.setText(R.string.answer5_2);
                        txt_answer3.setText(R.string.answer5_3);
                        txt_answer4.setText(R.string.answer5_4);
                        break;
                    case 6:
                        txt_questions.setText(R.string.question6);
                        txt_answer1.setText(R.string.answer6_1);
                        txt_answer2.setText(R.string.answer6_2);
                        txt_answer3.setText(R.string.answer6_3);
                        txt_answer4.setText(R.string.answer6_4);
                        break;
                    case 7:
                        txt_questions.setText(R.string.question7);
                        txt_answer1.setText(R.string.answer7_1);
                        txt_answer2.setText(R.string.answer7_2);
                        txt_answer3.setText(R.string.answer7_3);
                        txt_answer4.setText(R.string.answer7_4);
                        break;
                    case 8:
                        txt_questions.setText(R.string.question8);
                        txt_answer1.setText(R.string.answer8_1);
                        txt_answer2.setText(R.string.answer8_2);
                        txt_answer3.setText(R.string.answer8_3);
                        txt_answer4.setText(R.string.answer8_4);
                        break;
                    case 9:
                        txt_questions.setText(R.string.question9);
                        txt_answer1.setText(R.string.answer9_1);
                        txt_answer2.setText(R.string.answer9_2);
                        txt_answer3.setText(R.string.answer9_3);
                        txt_answer4.setText(R.string.answer9_4);
                        break;
                    case 10:
                        txt_questions.setText(R.string.question10);
                        layout_1.setVisibility(View.GONE);
                        layout_2.setVisibility(View.VISIBLE);
                        break;
                    case 11:
                        layout_2.setVisibility(View.GONE);
                        txt_questions.setText(R.string.question11);
                        txt_answer1.setText(R.string.answer11_1);
                        txt_answer2.setText(R.string.answer11_2);
                        txt_answer3.setText(R.string.answer11_3);
                        txt_answer4.setText(R.string.answer11_4);
                        break;
                    default:
                        result();
                }
            }
        });
    }
//    When the user clicks on an option, this method is activated and performs different functions based on different conditions. For example,
//    changing the color of options, enabling or disabling next buttons, etc.
    protected void txt_answersOnClick() {
        txt_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_next.setEnabled(true);
                btn_next.setBackgroundColor(getResources().getColor(R.color.btnEnable));
                setEnable(false);
                switch (number) {
                    case 1:
                    case 11:
                    case 5:
                        txt_answer1.setBackgroundColor(Color.parseColor("#13dc74"));
                        break;
                    case 2:
                        txt_answer2.setBackgroundColor(Color.parseColor("13dc74"));
                        break;
                    case 3:
                        incorrect++;
                        txt_answer1.setBackgroundColor(Color.parseColor("#dc1358"));
                        txt_answer2.setBackgroundColor(Color.parseColor("#13dc74"));
                        break;
                    case 4:
                    case 7:
                        incorrect++;
                        txt_answer1.setBackgroundColor(Color.parseColor("#dc1358"));
                        txt_answer3.setBackgroundColor(Color.parseColor("#13dc74"));
                        break;
                    case 6:
                    case 9:
                        incorrect++;
                        txt_answer1.setBackgroundColor(Color.parseColor("#dc1358"));
                        txt_answer4.setBackgroundColor(Color.parseColor("#13dc74"));
                        break;
                    case 8:
                        incorrect++;
                        txt_answer1.setBackgroundColor(Color.parseColor("dc1358"));
                        txt_answer2.setBackgroundColor(Color.parseColor("#13dc74"));
                        break;

                }
            }
        });
        txt_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_next.setEnabled(true);
                btn_next.setBackgroundColor(getResources().getColor(R.color.btnEnable));
                setEnable(false);
                switch (number) {
                    case 1:
                    case 11:
                    case 5:
                    case 2:
                        incorrect++;
                        txt_answer2.setBackgroundColor(Color.parseColor("#dc1358"));
                        txt_answer1.setBackgroundColor(Color.parseColor("#13dc74"));
                        break;
                    case 3:
                    case 8:
                        txt_answer2.setBackgroundColor(Color.parseColor("#13dc74"));
                        break;
                    case 4:
                    case 7:
                        incorrect++;
                        txt_answer2.setBackgroundColor(Color.parseColor("#dc1358"));
                        txt_answer3.setBackgroundColor(Color.parseColor("#13dc74"));
                        break;
                    case 6:
                    case 9:
                        incorrect++;
                        txt_answer2.setBackgroundColor(Color.parseColor("#dc1358"));
                        txt_answer4.setBackgroundColor(Color.parseColor("#13dc74"));
                        break;
                }
            }
        });
        txt_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_next.setEnabled(true);
                btn_next.setBackgroundColor(getResources().getColor(R.color.btnEnable));
                setEnable(false);
                switch (number) {
                    case 1:
                    case 11:
                    case 5:
                    case 2:
                        incorrect++;
                        txt_answer3.setBackgroundColor(Color.parseColor("#dc1358"));
                        txt_answer1.setBackgroundColor(Color.parseColor("#13dc74"));
                        break;
                    case 3:
                    case 8:
                        incorrect++;
                        txt_answer3.setBackgroundColor(Color.parseColor("#dc1358"));
                        txt_answer2.setBackgroundColor(Color.parseColor("#13dc74"));
                        break;
                    case 4:
                        txt_answer3.setBackgroundColor(Color.parseColor("#dc1358"));
                        break;
                    case 6:
                    case 9:
                        incorrect++;
                        txt_answer3.setBackgroundColor(Color.parseColor("#dc1358"));
                        txt_answer4.setBackgroundColor(Color.parseColor("#13dc74"));
                        break;
                    case 7:
                        txt_answer3.setBackgroundColor(Color.parseColor("#13dc74"));
                        break;
                }
            }
        });
        txt_answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_next.setEnabled(true);
                btn_next.setBackgroundColor(getResources().getColor(R.color.btnEnable));
                setEnable(false);
                switch (number) {
                    case 1:
                    case 2:
                    case 5:
                    case 11:
                        incorrect++;
                        txt_answer4.setBackgroundColor(Color.parseColor("#dc1358"));
                        txt_answer1.setBackgroundColor(Color.parseColor("#13dc74"));
                        break;
                    case 3:
                    case 8:
                        incorrect++;
                        txt_answer4.setBackgroundColor(Color.parseColor("#dc1358"));
                        txt_answer2.setBackgroundColor(Color.parseColor("#13dc74"));
                        break;
                    case 4:
                    case 7:
                        incorrect++;
                        txt_answer4.setBackgroundColor(Color.parseColor("#dc1358"));
                        txt_answer3.setBackgroundColor(Color.parseColor("#13dc74"));
                        break;
                    case 6:
                    case 9:
                        txt_answer4.setBackgroundColor(Color.parseColor("#13dc74"));
                        break;
                }
            }
        });
    }
//    This method in Android is for defining behaviors related to clicking on answer images in an application.
    public void  img_answersOnClick(){
        img_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_next.setEnabled(true);
                btn_next.setBackgroundColor(getResources().getColor(R.color.btnEnable));
                img_answer1.setBackgroundColor(Color.parseColor("#13dc74"));
            }
        });
        img_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_next.setEnabled(true);
                btn_next.setBackgroundColor(getResources().getColor(R.color.btnEnable));
                incorrect++;
                img_answer1.setBackgroundColor(Color.parseColor("#13dc74"));
                txt_answer2.setBackgroundColor(Color.parseColor("#dc1358"));
            }
        });
        img_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_next.setEnabled(true);
                btn_next.setBackgroundColor(getResources().getColor(R.color.btnEnable));
                incorrect++;
                img_answer1.setBackgroundColor(Color.parseColor("#13dc74"));
                txt_answer3.setBackgroundColor(Color.parseColor("#dc1358"));
            }
        });
        img_answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_next.setEnabled(true);
                btn_next.setBackgroundColor(getResources().getColor(R.color.btnEnable));
                incorrect++;
                img_answer1.setBackgroundColor(Color.parseColor("#13dc74"));
                txt_answer4.setBackgroundColor(Color.parseColor("#dc1358"));
            }
        });
    }
//    This method is used in Android to enable or disable the ability to edit and change values in four text fields (txt_answer1 to txt_answer4).
    public void setEnable(boolean b){
       txt_answer1.setEnabled(b);
       txt_answer2.setEnabled(b);
       txt_answer3.setEnabled(b);
       txt_answer4.setEnabled(b);
    }
//    This method is used in Android to display the results of a test.
    public void result(){
        if(incorrect>=4){
            String result = "شما"+incorrect+"غلط داشتید و متاسفانه رد شدید.";
            Snackbar snackbar = Snackbar.make(coordinatorLayout,result,Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction("تلاش دوباره", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
            View snackView = snackbar.getView();
            snackView.setBackgroundColor(Color.BLACK);
            TextView textView = snackView.findViewById(com.google.android.material.R.id.snackbar_text);
            textView.setTextColor(Color.RED);
            snackbar.show();
        }else if(incorrect<4){
            String result="تبریک می گوییم شما قبول شدید.";
            Snackbar snackbar = Snackbar.make(coordinatorLayout,result,Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction("باشه", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
            View snackView = snackbar.getView();
            snackView.setBackgroundColor(Color.BLACK);
            TextView textView = snackView.findViewById(com.google.android.material.R.id.snackbar_text);
            textView.setTextColor(Color.GREEN);
            snackbar.show();
        }
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