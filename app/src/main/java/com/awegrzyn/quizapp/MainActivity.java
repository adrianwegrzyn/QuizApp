package com.awegrzyn.quizapp;

import android.content.Intent;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.textViewQuestion)
    TextView textViewQuestion;
    Quiz quiz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if(getIntent().hasExtra("quiz")){
            quiz = Parcels.unwrap(getIntent().getParcelableExtra("quiz"));
        }else{
            initQuiz();
        }

        setQuestion(quiz.questions.get(quiz.answersSoFar));
    }

    private void initQuiz() {
        quiz = new Quiz();
        Question question = new Question(getString(R.string.question_one));
        question.answers.add(new Answer(getString(R.string.answer_one), false));
        question.answers.add(new Answer(getString(R.string.answer_two), false));
        question.answers.add(new Answer(getString(R.string.answer_three), false));
        question.answers.add(new Answer(getString(R.string.answer_four), true));
        quiz.questions.add(question);

        question= new Question(getString(R.string.question_two));
        question.answers.add(new Answer(getString(R.string.answer_one_2), true));
        question.answers.add(new Answer(getString(R.string.answer_two_2), false));
        question.answers.add(new Answer(getString(R.string.answer_three_2), false));
        question.answers.add(new Answer(getString(R.string.answer_four_2), false));
        quiz.questions.add(question);
    }

    private void setQuestion(Question question) {
        textViewQuestion.setText(question.text);
        for(Answer answer: question.answers){
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(answer.text);
            radioGroup.addView(radioButton);
        }
    }

    private int getSelectedIndex() {
        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        View radioButton = radioGroup.findViewById(radioButtonID);
        return radioGroup.indexOfChild(radioButton);
    }


    @OnClick(R.id.buttonNext)
    public void onClickNext() {
        if(getSelectedIndex() >= 0){
            if(quiz.questions.get(quiz.answersSoFar).answers.get(getSelectedIndex()).isCorrect){
                Toast.makeText(this, "IS CORRECT", Toast.LENGTH_SHORT).show();
                quiz.correctAnswers++;
            } else {
                Toast.makeText(this, "IS NOT CORRECT", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Select one!", Toast.LENGTH_LONG).show();
            return;
        }
        



        Intent intent;
        if(quiz.answersSoFar >= 1){
            intent= new Intent(this, HightScoreActivity.class);
        }else{
            intent= new Intent(this, MainActivity.class);
        }
        quiz.answersSoFar++;
        intent.putExtra("quiz", Parcels.wrap(quiz));
        startActivity(intent);
        this.finish();
    }
}
