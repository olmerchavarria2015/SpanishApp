package com.example.adtjc.spanishapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class MainActivity extends AppCompatActivity {
    TextView t1;
    TextView t2;
    Map <String ,String> traductor;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("myculo is fat");
        setSupportActionBar(toolbar);
        traductor= new HashMap <String ,String>();
        traductor.put("corazon","heart");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Typeface CustomFont = Typeface.createFromAsset(getAssets(),"fonts/Pacifico.ttf");
        t1 = (TextView)findViewById(R.id.textView);
        t1.setTypeface(CustomFont);
        t2 = (TextView)findViewById(R.id.textView2);



    }
    public void ButtonClicked(View v){
        traductor= new HashMap <String ,String>();
        traductor.put("corazon","heart");
        traductor.put("zapato","shoe");
        traductor.put("cama","bed");


        EditText n2 = (EditText)findViewById(R.id.editText3);
        String num2 = wordProcessor(n2.getText().toString());
        String count = String.valueOf(num2.length());
        String ese = "s";

        if (num2.substring(num2.length() - 1).equals(ese)
                //||num2.substring((num2.length() - 2)+(num2.length() - 1)).equals(esos)
                ){
            String word= num2.replace(num2.substring(num2.length()- 1),"");
            t1.setText(num2 +" = "+(traductor.get(word))+ese);
            //t1.setText(num2);
            t2.setText(count);

        }
        else{
            t1.setText(num2 +" = "+traductor.get(num2));
            //t1.setText(num2);

            t2.setText(count);



        }
    }
    public String wordProcessor(String str){

        for(int i=1;i <= str.length();i++){
            if (str.substring(i).equals(" ")){

               str = str.replace(str.substring(i),"");
           }

        }
        return str;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
