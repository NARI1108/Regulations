package com.example.regulations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
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
    int number=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        findViews();
        btn_nextOnClick();
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