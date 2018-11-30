package com.awegrzyn.quizapp;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by Adrian on 30.11.2018.
 */

@Parcel
public class Question {
    public ArrayList<Answer> answers = new ArrayList<>();
    public String text;

    public Question(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public Question() {
    }

    public Question(String text) {
        this.text = text;
    }
}
