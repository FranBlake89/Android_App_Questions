package com.example.assignment_3;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;

public class MyQuestions extends Application {

    ArrayList<Question> questionArrayList = new ArrayList<Question>(Arrays.asList(
            new Question ("Android Studio is a development environment for building apps for the Android operating system.", true),
            new Question ("Android Studio is based on Eclipse, a popular Java IDE.", false),
            new Question ("Android Studio has built-in support for version control systems like Git.", true),
            new Question ("Android Studio provides a visual layout editor for designing app interfaces.", true),
            new Question ("Android Studio can be used to develop apps for iOS devices.", false),
            new Question ("Android Studio includes a tool for testing apps on different virtual devices.", true),
            new Question ("Android Studio provides a built-in profiler for analyzing app performance.", true),
            new Question ("Android Studio only supports the Java programming language.", false),
            new Question ("Android Studio allows you to create custom Gradle tasks for building your app.", true)
    ));
    public void modifyArray(int index, Question element) { questionArrayList.set(index, element); }
}
