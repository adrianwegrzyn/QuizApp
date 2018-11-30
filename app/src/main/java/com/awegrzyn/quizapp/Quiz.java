package com.awegrzyn.quizapp;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by Adrian on 30.11.2018.
 */

@Parcel
public class Quiz {
    public ArrayList<Question> questions = new ArrayList<>();
    public int allQuestions;
    public int answersSoFar;
    public int correctAnswers;
}
