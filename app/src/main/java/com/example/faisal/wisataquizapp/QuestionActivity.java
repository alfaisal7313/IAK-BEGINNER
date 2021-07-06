package com.example.faisal.wisataquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {

    private int score = 0;
    private int wrongValue = 0;
    private String name;
    private String question_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        //mengambil nilai dari activity sebelumnya
        getIntentResponse();
    }

    private void getIntentResponse() {
        Intent intent = getIntent();
        //mengambil nilai nama
        name = intent.getStringExtra("name");
        //mengambil nilai jumlah pertanyaan yang diinginkan
        question_amount = intent.getStringExtra("amount");

        LinearLayout questionGroup_2 = findViewById(R.id.question_group2);
        if (question_amount.equals("10"))
            questionGroup_2.setVisibility(View.VISIBLE);
    }

    public void submitQuestion(View view) {
        submitAnswer();

        if (score > 0 | wrongValue > 0) {
            openResultActivity();
        } else {
            Toast.makeText(this, "Jawaban belum lengkap", Toast.LENGTH_SHORT).show();
        }
    }

    private void openResultActivity() {
        //membuka activity hasil
        Intent intentResult = new Intent(QuestionActivity.this, ResultActivity.class);
        intentResult.putExtra("name", name);
        intentResult.putExtra("total_question", question_amount);
        intentResult.putExtra("score", score);
        intentResult.putExtra("wrong_score", wrongValue);
        startActivity(intentResult);

        //agar tidak bisa kembali ke activity sebelumnya
        finish();
    }

    private void submitAnswer() {

        if (question_amount.equals("10")) {
            question_1();
            question_2();
            question_3();
            question_4();
            question_5();
            question_6();
            question_7();
            question_8();
            question_9();
            question_10();
        } else {
            question_1();
            question_2();
            question_3();
            question_4();
            question_5();
        }
    }

    //pertanyaan nomor 1

    private void question_1() {
        RadioGroup radioGroupQuestion_1 = findViewById(R.id.rg_question1);
        if (radioGroupQuestion_1.getCheckedRadioButtonId() == -1) {
            score = 0;
            wrongValue = 0;
        } else {
            if (radioGroupQuestion_1.getCheckedRadioButtonId() == R.id.rb_2_q1) {
                incrementScore();
            } else {
                wrongScore();
            }
        }
    }

    //pertanyaan nomor 2
    private void question_2() {
        RadioGroup radioGroupQuestion_2 = findViewById(R.id.rg_question2);
        if (radioGroupQuestion_2.getCheckedRadioButtonId() == -1) {
            score = 0;
            wrongValue = 0;
        } else {
            if (radioGroupQuestion_2.getCheckedRadioButtonId() == R.id.rb_1_q2) {
                incrementScore();
            } else {
                wrongScore();
            }
        }
    }

    //pertanyaan nomor 3
    private void question_3() {
        CheckBox check_1, check_2, check_3, check_4;
        check_1 = findViewById(R.id.cb_1_q1);
        check_2 = findViewById(R.id.cb_2_q1);
        check_3 = findViewById(R.id.cb_3_q1);
        check_4 = findViewById(R.id.cb_4_q1);

        if (!check_1.isChecked() && !check_2.isChecked() && !check_3.isChecked() && !check_4.isChecked()) {
            score = 0;
            wrongValue = 0;
        } else {

            if (check_1.isChecked() && check_3.isChecked() && check_4.isChecked()) {
                incrementScore();
            } else {
                wrongScore();
            }
        }
    }

    //pertanyaan nomor 4
    private void question_4() {
        EditText edtQuestion4 = findViewById(R.id.edt_answer_4);
        String answerQuestion4 = edtQuestion4.getText().toString();

        if (answerQuestion4.isEmpty()) {
            score = 0;
            wrongValue = 0;
        } else {
            if (answerQuestion4.equalsIgnoreCase("Kepulauan Nusa Dua") || answerQuestion4.
                    equalsIgnoreCase("Nusa Dua") || answerQuestion4.equalsIgnoreCase("Pulau Nusa Dua")) {
                incrementScore();
            } else {
                wrongScore();
            }
        }
    }

    //pertanyaan nomor 5
    private void question_5() {
        EditText edtQuestion5 = findViewById(R.id.edt_answer_5);
        String answerQuestion5 = edtQuestion5.getText().toString();

        if (answerQuestion5.isEmpty()) {
            score = 0;
            wrongValue = 0;
        } else {
            if (answerQuestion5.equalsIgnoreCase("Danau Toba") || answerQuestion5.equalsIgnoreCase("Toba")) {
                incrementScore();
            } else {
                wrongScore();

            }
        }
    }

    //pertanyaan nomor 6
    private void question_6() {
        RadioGroup radioGroupQuestion_6 = findViewById(R.id.rg_question6);
        if (radioGroupQuestion_6.getCheckedRadioButtonId() == -1) {
            score = 0;
            wrongValue = 0;
        } else {
            if (radioGroupQuestion_6.getCheckedRadioButtonId() == R.id.rb_3_q6) {
                incrementScore();
            } else {
                wrongScore();
            }
        }
    }

    //pertanyaan nomor 7
    private void question_7() {
        RadioGroup radioGroupQuestion_7 = findViewById(R.id.rg_question7);
        if (radioGroupQuestion_7.getCheckedRadioButtonId() == -1) {
            score = 0;
            wrongValue = 0;
        } else {
            if (radioGroupQuestion_7.getCheckedRadioButtonId() == R.id.rb_4_q7) {
                incrementScore();
            } else {
                wrongScore();
            }
        }
    }

    //pertanyaan nomor 8
    private void question_8() {
        CheckBox check_1, check_2, check_3, check_4;

        check_1 = findViewById(R.id.cb_1_q8);
        check_2 = findViewById(R.id.cb_2_q8);
        check_3 = findViewById(R.id.cb_3_q8);
        check_4 = findViewById(R.id.cb_4_q8);

        if (!check_1.isChecked() && !check_2.isChecked() && !check_3.isChecked() && !check_4.isChecked()) {
            score = 0;
            wrongValue = 0;
        } else {
            if (check_2.isChecked() && check_4.isChecked()) {
                incrementScore();
            } else {
                wrongScore();
            }
        }
    }

    //pertanyaan nomor 9
    private void question_9() {
        EditText edtQuestion9 = findViewById(R.id.edt_answer_9);
        String answerQuestion9 = edtQuestion9.getText().toString();

        if (answerQuestion9.isEmpty()) {
            score = 0;
            wrongValue = 0;
        } else {
            if (answerQuestion9.equalsIgnoreCase("Kabupatan Wakatobi") || answerQuestion9.
                    equalsIgnoreCase("Wakatobi")) {
                incrementScore();
            } else {
                wrongScore();
            }
        }
    }

    //pertanyaan nomor 10
    private void question_10() {
        EditText edtQuestion10 = findViewById(R.id.edt_answer_10);
        String answerQuestion10 = edtQuestion10.getText().toString();

        if (answerQuestion10.isEmpty()) {
            score = 0;
            wrongValue = 0;
        } else {
            if (answerQuestion10.equalsIgnoreCase("Pulau Komodo") || answerQuestion10.
                    equalsIgnoreCase("Komodo")) {
                incrementScore();
            } else {
                wrongScore();
            }
        }
    }

    //fungsi yang digunakan apabila jawaban benar
    public void incrementScore() {
        score++;
    }

    public void wrongScore() {
        wrongValue++;
    }
}
