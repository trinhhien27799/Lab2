package com.example.lab2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Debug;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class B2_BackgroundTask_POST extends AsyncTask<Void, Void, Void> {
    String link;
    Context context;
    String strWidth, strHeight;
    TextView txtResult;
    ProgressDialog progressDialog;
    String strResult;

    public B2_BackgroundTask_POST(String link, Context context, String strWidth, String strHeight, TextView txtResult) {
        this.link = link;
        this.context = context;
        this.strWidth = strWidth;
        this.strHeight = strHeight;
        this.txtResult = txtResult;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            String param = "rong=" + URLEncoder.encode(strWidth, "utf-8") + "&dai=" + URLEncoder.encode(strHeight, "utf-8");
            URL url = new URL(link);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setFixedLengthStreamingMode(param.getBytes().length);
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            PrintWriter printWriter = new PrintWriter(urlConnection.getOutputStream());
            printWriter.print(param);
            printWriter.close();

            String line = "";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();

            while ((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line);
            }
            strResult = stringBuffer.toString();
            urlConnection.disconnect();
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Calculating...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        txtResult.setText(strResult);
    }
}
