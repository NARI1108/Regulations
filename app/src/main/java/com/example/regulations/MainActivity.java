package com.example.regulations;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btn_Exam, btn_Education, btn_contact, btn_about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        onClick();
    }
//    This method is for connecting views from the XML layer to this layer.
    public void findViews(){
      btn_Exam = findViewById(R.id.btn_exam);
      btn_Education = findViewById(R.id.btn_Education);
      btn_contact = findViewById(R.id.btn_contact);
    }
//  This method is for the user to click on the buttons in the home section of the app.
    public void onClick(){
        btn_Exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Exam.class));
            }
        });
        btn_Education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Education.class));
            }
        });
        btn_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent message = new Intent(Intent.ACTION_VIEW);
                message.setData(Uri.parse("https://t.me/Nr_Ai80"));
                startActivity(message);
            }
        });
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this).setTitle(getResources().getString(R.string.about_us)).setMessage(getResources().getString(R.string.about_company)).show();
            }
        });
    }
}