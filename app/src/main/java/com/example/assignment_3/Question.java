package com.example.assignment_3;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ListView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Question  implements Parcelable {
    private String _question;
    private Boolean _correctAnswer;
    private Boolean _userAnswer;

    protected Question(Parcel in) {
        _question = in.readString();
        byte tmp_correctAnswer = in.readByte();
        _correctAnswer = tmp_correctAnswer == 0 ? null : tmp_correctAnswer == 1;
        byte tmp_userAnswer = in.readByte();
        _userAnswer = tmp_userAnswer == 0 ? null : tmp_userAnswer == 1;
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    private void setQuestion(String question){ _question = question; }
    private void set_correctAnswer( Boolean answer ) { _correctAnswer = answer; }
    private void set_userAnswer ( Boolean userAnswer ) { _userAnswer = userAnswer; }
    public String getQuestion(){ return _question; }
    public Boolean get_correctAnswer() { return this._correctAnswer; }
    public Boolean get_userAnswer ( ) { return this._userAnswer; }
    public Question( String ques, Boolean answer){
        setQuestion(ques);
        set_correctAnswer(answer);
    }

    public Boolean compareAnswer(Boolean userAnswer){
        Boolean isCorrect = false;
        set_userAnswer(userAnswer);

        if( get_correctAnswer() == get_userAnswer()){
            isCorrect = true;
        }

        return isCorrect;
    }
    public void setAnswer(Boolean userInput){
        set_userAnswer(userInput);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(_question);
        parcel.writeByte((byte) (_correctAnswer == null ? 0 : _correctAnswer ? 1 : 2));
        parcel.writeByte((byte) (_userAnswer == null ? 0 : _userAnswer ? 1 : 2));
    }
}
