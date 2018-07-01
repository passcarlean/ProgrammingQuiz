package com.example.paschaline.programmingquiz;




import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;


public class QuestionActivity extends AppCompatActivity {
    private int scores;
    private RadioGroup one;
    private RadioGroup two;
    private RadioGroup three;
    private LinearLayout four;
    private CheckBox fourA;
    private CheckBox fourB;
    private CheckBox fourC;
    private CheckBox fourD;
    private LinearLayout five;
    private CheckBox fiveA;
    private CheckBox fiveB;
    private CheckBox fiveC;
    private CheckBox fiveD;
    private RadioGroup six;
    private RadioGroup seven;
    private EditText eight;
    private EditText nameField;
    private String user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_activity);

        //username
        nameField = findViewById(R.id.userName);
        user = nameField.getText().toString();


        if (TextUtils.isEmpty(user)) {
            nameField.setError("This item cannot be empty");
            nameField.requestFocus();
        }
//Initialize all views
        one = findViewById(R.id.questionOne);
        two = findViewById(R.id.questionTwo);
        three = findViewById(R.id.questionThree);
        four = findViewById(R.id.checkbox);
        fourA = findViewById(R.id.q_four_a);
        fourB = findViewById(R.id.q_four_b);
        fourC = findViewById(R.id.q_four_c);
        fourD = findViewById(R.id.q_four_d);
        five = findViewById(R.id.checkbox_quest);
        fiveA = findViewById(R.id.q_five_a);
        fiveB = findViewById(R.id.q_five_b);
        fiveC = findViewById(R.id.q_five_c);
        fiveD = findViewById(R.id.q_five_d);
        six = findViewById(R.id.questionSix);
        seven = findViewById(R.id.questionSeven);
        eight = findViewById(R.id.questionEight);

    }
    //method for unknown user
    public  void unknownUser(View view){
        Intent unknown = new Intent(this, WelcomeActivity.class);
        startActivity(unknown);
    }
    // Error message for Question 8
    public void questEight(View view) {
        EditText quizAnswer = findViewById(R.id.questionEight);
        String answer = quizAnswer.getText().toString();
        if (TextUtils.isEmpty(answer)) {
            quizAnswer.setError("This item cannot be empty");
            quizAnswer.requestFocus();

        }

    }

    //submit answer
    public void submitQuiz(View view) {
        int totalScore = 16;
        EditText nameField = findViewById(R.id.userName);
        String user = nameField.getText().toString();

            checkAnswer();


        //display score and name

        if (scores == totalScore) {
            showToastMessage(
                    getString(R.string.excellent) + "\n" + getString(R.string.all_answer) + "\n"  + user + " You Scored: " + String.valueOf(scores) + "/" + totalScore
            );

        } else if (scores >= 10) {
            showToastMessage(
                    getString(R.string.good) + "\n" + getString(R.string.all_answer) + "\n" + "\n" + user + " You Scored: " + String.valueOf(scores) + "/" + totalScore
            );

        } else {
            showToastMessage(
                    getString(R.string.poor) + "\n" + getString(R.string.all_question) + "\n"  + user +  " You Scored: " + String.valueOf(scores) + "/" + totalScore
            );
        }


    }


    // to check if all questions were answered


    /**
     * check all the answer and increase the score
     * for each answer 2 point will get added in scores
     */
    private void checkAnswer() {
        //clear the scores
        scores = 0;


        // check for answer one
        if (one.getCheckedRadioButtonId() == R.id.q_one) {
            increaseScore();
        }
        // check for answer two
        if (two.getCheckedRadioButtonId() == R.id.q_two) {
            increaseScore();
        }
        // check for answer three
        if (three.getCheckedRadioButtonId() == R.id.q_three) {
            increaseScore();
        }
        // check for answer four
        if (fourA.isChecked() && fourB.isChecked() && fourC.isChecked() && !fourD.isChecked()) {
            increaseScore();

        }
        // check for answer five
        if (!fiveA.isChecked() && fiveB.isChecked() && fiveC.isChecked() && !fiveD.isChecked()) {
            increaseScore();
        }
        // check for answer six
        if (six.getCheckedRadioButtonId() == R.id.q_six) {
            increaseScore();
        }
        // check for answer seven
        if (seven.getCheckedRadioButtonId() == R.id.q_seven) {
            increaseScore();
        }

        // check for answer eight

        if (eight.getText().toString().equalsIgnoreCase("Hardware")) {
            increaseScore();
        }


    }

    private void increaseScore() {
        scores += 2;
    }

    /**
     * to reset the quiz
     */
    public void resetQuiz(View view) {

        //clear all the answers
        one.clearCheck();
        two.clearCheck();
        three.clearCheck();
        uncheckAllChildren(four);
        uncheckAllChildren(five);
        six.clearCheck();
        seven.clearCheck();
        eight.setText("");


    }


    //uncheck checkbox
    private void uncheckAllChildren(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof CheckBox) {
                ((CheckBox) childAt).setChecked(false);

            }
        }
    }

    //display toast
    private void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }




}



