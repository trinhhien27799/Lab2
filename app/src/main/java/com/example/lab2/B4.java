package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class B4 extends AppCompatActivity {
    EditText inA, inB, inC;
    TextView txtResult;
    Button btnB4;
    String numA, numB, numC, link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b4);

        inA = findViewById(R.id.A_Num);
        inB = findViewById(R.id.B_Num);
        inC = findViewById(R.id.C_Num);
        txtResult = findViewById(R.id.txtResultB4);
        btnB4 = findViewById(R.id.btnB4);
        link = "http://192.168.55.111/B4_lab2/b4.php";

        btnB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numA = inA.getText().toString();
                numB = inB.getText().toString();
                numC = inC.getText().toString();

                B4_BackgroundTask_POST backgroundTaskPost = new B4_BackgroundTask_POST(link, B4.this, numA, numB, numC, txtResult);
                backgroundTaskPost.execute();
            }
        });
    }
}