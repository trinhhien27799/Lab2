package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class B3 extends AppCompatActivity {
    EditText inLength;
    TextView txtResult;
    Button btnB2;
    String length, link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b3);

        inLength = findViewById(R.id.inNumB3);
        txtResult = findViewById(R.id.txtResultB3);
        btnB2 = findViewById(R.id.btnB3);
        link = "http://192.168.55.111/B3_lab2/b3.php";

        btnB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                length = inLength.getText().toString();

                B3_BackgroundTask_POST backgroundTaskPost = new B3_BackgroundTask_POST(link, B3.this, length, txtResult);
                backgroundTaskPost.execute();
            }
        });
    }
}