package com.example.lab_04;


import android.os.AsyncTask;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class myAsync extends AsyncTask<String, Void, String> {
    private TextView newTextView;

    public myAsync(TextView newTextView) {
        this.newTextView = newTextView;
    }

    @Override
    protected String doInBackground(String... strings) {
        URL url = null;

        try {
            url = new URL(strings[0]);
        }

        catch (MalformedURLException e) {
            e.printStackTrace();
        }

        URLConnection connection = null;

        try {
            connection = url.openConnection();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        InputStreamReader isRead = null;
        try {
            isRead = new InputStreamReader(connection.getInputStream());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader buffRead = new BufferedReader(isRead);

        String userInput =null;

        try {
            userInput = buffRead.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        int i = 0;
        while (i < 20) {
            try {

                userInput += buffRead.readLine();

            }
            catch (IOException e) {
                e.printStackTrace();
            }

            i = i + 1;
        }

        return userInput;
    }

    @Override
    protected void onPostExecute(String string) {
        super.onPostExecute(string);

        this.newTextView.setText(string.substring(10, 23));
    }
}
