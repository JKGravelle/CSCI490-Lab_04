package com.example.lab_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("input URL" , inputURL("https://jsonplaceholder.typicode.com/users"));
    }

    public String inputURL(String url){
        try {
            URL userURL = new URL(url);

            URLConnection connection = userURL.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));

            return in.readLine();

        }
        catch(MalformedURLException mue){
            System.out.println("Malformed URL Exception");
        }
        catch(IOException io){
            System.out.println("IOException");
        }
        return(" occurred.");
    }
}