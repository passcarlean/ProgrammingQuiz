package com.example.paschaline.programmingquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class WelcomeActivity extends AppCompatActivity {



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_welcome);


        }
        public void start(View view){
            Intent startQuiz = new Intent(this, QuestionActivity.class);
            startActivity(startQuiz);
        }



    }

