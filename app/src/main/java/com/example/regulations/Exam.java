package com.example.regulations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Exam extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    TextView txt_questions, txt_answer1, txt_answer2, txt_answer3, txt_answer4;
    Button btn_next;
    ImageView img_questions, img_question1, img_question2, img_question3, img_question4;
    LinearLayout layout_1, layout_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        findViews();
        setTexts();
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
}