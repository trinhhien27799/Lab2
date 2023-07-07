package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class B1 extends AppCompatActivity {
    TextView txtResult;
    String link;
    Button btnInsert;

    EditText inName, inScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b1);

        txtResult = findViewById(R.id.result);
        btnInsert = findViewById(R.id.btnB1);
        inName = findViewById(R.id.inName);
        inScore = findViewById(R.id.inScore);

        link = "http://192.168.55.112/B1_lab2/B1.php";
    }

    public void B1Send(View view) {
        B1AsyncTaskGet b1Active = new B1AsyncTaskGet(this, link, inName.getText().toString(), inScore.getText().toString(), txtResult);
        b1Active.execute();
    }
}

// Link API php = http://localhost/B1_lab2/B1.php?name=therealtrinhhienngo&score=10000000000