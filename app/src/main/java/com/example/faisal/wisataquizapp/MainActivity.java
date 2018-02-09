package com.example.faisal.wisataquizapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtName;
    private Button btnStart;
    private Spinner spCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //memanggil edittex nama
        edtName = findViewById(R.id.et_name);
        //memanggil spinner count
        spCount = findViewById(R.id.sp_count);
        //membuat dan mensetting spinner
        spCount.setAdapter(adapterCount());
        //memanggil button mulai
        btnStart = findViewById(R.id.btn_start);
        //event button mulai ketika di klik
        btnStart.setOnClickListener(this);
    }

    private SpinnerAdapter adapterCount() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.question_amount, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spCount.setAdapter(adapter);
        return adapter;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:

                //menampilkan progressbar
                final ProgressBar progressBar = findViewById(R.id.progressBar);
                progressBar.setVisibility(View.VISIBLE);

                //mengecek apakah nama sudah diisi
                if (edtName.getText().toString().isEmpty()) {
                    edtName.setError("Silahkan masukkan nama anda");
                } else {
                    Intent intent_quiz = new Intent(MainActivity.this, QuestionActivity.class);
                    //kirim nama user ke acvity selanjutnya
                    intent_quiz.putExtra("name", edtName.getText().toString());
                    //kirim jumlah soal yang diinginkan
                    intent_quiz.putExtra("amount", spCount.getSelectedItem().toString());
                    //membuka activity QuestionActivity
                    startActivity(intent_quiz);
                    //agar tidak bisa kembali ke activity sebelumnya
                    finish();
                }

                //mengatur waktu tampil progressbar selama 2 detik
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //menyembunyikan progressbar
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }, 2000);

                break;
        }
    }

}
