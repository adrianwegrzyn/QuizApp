package com.awegrzyn.quizapp;

import org.parceler.Parcel;

/**
 * Created by Adrian on 30.11.2018.
 */

@Parcel
public class Answer {
    public String text;
    public boolean isCorrect;

    public Answer() {
    }

    public Answer(String text) {
        this.text = text;
    }

    public Answer(String text, boolean isCorrect) {
        this.text = text;
        this.isCorrect = isCorrect;
    }
}
