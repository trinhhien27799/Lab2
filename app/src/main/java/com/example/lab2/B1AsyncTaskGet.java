package com.example.lab2;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class B1AsyncTaskGet extends AsyncTask<String, Void, String> {
    private Context context;
    private String link;
    private String name;
    private String score;
    private TextView result;
    private String textResult = "";

    public B1AsyncTaskGet (Context context, String link, String name, String score, TextView result){
        this.context = context;
        this.link = link;
        this.name = name;
        this.score = score;
        this.result = result;
    }
    @Override
    protected String doInBackground(String... strings) {
        link += "?name="+name+"&score="+score;
        try {
            URL url = new URL(link);
            HttpURLConnection  httpURLConnection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line = "";

            while ((line = br.readLine()) != null){
                sb.append(line);
            }

            textResult = sb.toString();
            httpURLConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        result.setText(textResult);
    }
}
