package com.example.faisal.wisataquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //menghapus title pada toolbar
        getSupportActionBar().setTitle("");
        getSupportActionBar().setElevation(0);

        //mengambil data dari activity sebelumnya
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String total_question = intent.getStringExtra("total_question");
        int score = intent.getIntExtra("score", 0);

        //manampilkan nama user
        TextView name_user = findViewById(R.id.nm_user);
        name_user.setText("Nama : " + name);

        //menampilakan hasil score yang diperoleh
        TextView scoreResult = findViewById(R.id.tvScore);
        int totalScore;
        if (total_question.equals("10")) {
            //jumlah soal 10
            totalScore = score * 10;
        } else {
            //jumlah soal 5
            totalScore = score * 20;
        }
        scoreResult.setText(String.valueOf(totalScore));

        //menampilakan hasil jumlah soal yang terjawab
        TextView correctAnswer = findViewById(R.id.tv_score_success);
        correctAnswer.setText(String.valueOf(score));

        //menampilkan jumlah soal yang salah
        //dengan cara (total soal - scoce)
        int wrong = Integer.parseInt(total_question) - score;
        TextView wrongAnswer = findViewById(R.id.tv_score_failed);
        wrongAnswer.setText(String.valueOf(wrong));

        //menampilkan rating sesuai totalscore / 20 yang di peroleh user
        int rating = totalScore / 20;
        RatingBar ratingScore = findViewById(R.id.rating_score);
        ratingScore.setRating(rating);
    }
}
