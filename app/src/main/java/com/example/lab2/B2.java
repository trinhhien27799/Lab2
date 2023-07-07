package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class B2 extends AppCompatActivity {
    EditText inWidth, inHeight;
    TextView txtResult;
    Button btnB2;
    String width, height, link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b2);

        inWidth = findViewById(R.id.inWidth);
        inHeight = findViewById(R.id.inHeight);
        btnB2 = findViewById(R.id.btnB2);
        txtResult = findViewById(R.id.txtResult);
        link = "http://192.168.55.112/B2_lab2/b2.php";

        btnB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                width = inWidth.getText().toString();
                height = inHeight.getText().toString();

                B2_BackgroundTask_POST backgroundTaskPost = new B2_BackgroundTask_POST(link, B2.this, width, height, txtResult);
                backgroundTaskPost.execute();
            }
        });
    }
}