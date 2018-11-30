package com.awegrzyn.quizapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HightScoreActivity extends AppCompatActivity {
    @BindView(R.id.textViewResult)
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        ButterKnife.bind(this);
        SharedPreferences sharedPreferences = getSharedPreferences("com.awegrzyn.quizapp", MODE_PRIVATE);
        if(getIntent().hasExtra("quiz")){
            Quiz quiz = Parcels.unwrap(getIntent().getParcelableExtra("quiz"));
            if(quiz != null){
                textViewResult.setText(Integer.toString(quiz.correctAnswers));
                if(quiz.correctAnswers > sharedPreferences.getInt("highscore", 0)){
                    Toast.makeText(this, "Hey! New Height score!", Toast.LENGTH_SHORT).show();
                    sharedPreferences.edit().putInt("highscore", quiz.correctAnswers).apply();
                }
            }
        }
    }
}
