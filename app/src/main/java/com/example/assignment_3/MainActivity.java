package com.example.assignment_3;

import androidx.appcompat.app.AppCompatActivity;
import com.example.assignment_3.MyQuestions;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView questionTextView;
    int currentPos= 0;
    MyQuestions myQuestions;
    Button trueBtn;
    Button falseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons
         trueBtn = (Button)findViewById(R.id.True_btn);
         falseBtn = (Button)findViewById(R.id.false_btn);

        String btnTrueTxt = trueBtn.getText().toString();
        String btnFalseTxt = falseBtn.getText().toString();
        final Boolean[] userInput = new Boolean[1];
        //*******************************
        try {

            questionTextView = findViewById(R.id.textView);
            //trueButton = findViewById(R.id.true_button);

             myQuestions = (MyQuestions) getApplicationContext();
            Question currentQuestion = myQuestions.questionArrayList.get(currentPos);
            questionTextView.setText(currentQuestion.getQuestion());

            Log.d("QUESTION", currentQuestion.getQuestion());
        }catch ( Exception e ){
            Log.d("ERROR", e.toString());
        }
// >> true button
        trueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                userInput[0] = Boolean.parseBoolean(btnTrueTxt);
                //TODO CHECK BOOLEAN VALUES
                // questionList[currentPos].setAnswer(userInput);
            Log.d("VALUE BTN", btnTrueTxt);
                currentPos++;
                if (currentPos < myQuestions.questionArrayList.size()) {
                    // NEXT QUESTION AFTER CLICK
                    Question nextQuestion = myQuestions.questionArrayList.get(currentPos);
                    questionTextView.setText(nextQuestion.getQuestion());
                } else {
                    Toast.makeText(MainActivity.this, "No more questions!", Toast.LENGTH_SHORT).show();
                }
            }

        });

// >> false button
        falseBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                userInput[0]= Boolean.parseBoolean(btnFalseTxt);
                currentPos++;
                Log.d("VALUE BTN", btnFalseTxt);

                if (currentPos < myQuestions.questionArrayList.size()) {
                    // NEXT QUESTION AFTER CLICK
                    Question nextQuestion = myQuestions.questionArrayList.get(currentPos);
                    //SET VIEW ON TEXT VIEW
                    questionTextView.setText(nextQuestion.getQuestion());
                } else {
                    Toast.makeText(MainActivity.this, "No more questions!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}