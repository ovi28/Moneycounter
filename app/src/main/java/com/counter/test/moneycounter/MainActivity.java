package com.counter.test.moneycounter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String text="";
    private final String TAG = "MainActivity";
    private TextView tvTotal, tv20,tv10,tv5,tv2,tv1,tv05;

    ArrayList<String> moneyValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeTextFields();
        moneyValues = new ArrayList<>();
        text = Io.getTextFromFile(this,getResources().getString(R.string.file_name));
        if(!text.equals("")){
            moneyValues = getMoneyFromText(text);
            setTextfields(moneyValues);
        }else{
            for(int i=0;i<7;i++){
               moneyValues.add("0");
            }
        }
    }

    private void initializeTextFields(){
       tvTotal = (TextView) findViewById(R.id.tvTotal);
       tv20 = (TextView) findViewById(R.id.tvTwenty);
       tv10 = (TextView) findViewById(R.id.tvTen);
       tv5 = (TextView) findViewById(R.id.tvFive);
       tv2 = (TextView) findViewById(R.id.tvTwo);
       tv1 = (TextView) findViewById(R.id.tvOne);
       tv05 = (TextView) findViewById(R.id.tvPointFive);

    }
    private void setTextfields(ArrayList<String> moneyValues){
        tvTotal.setText(moneyValues.get(0));
        tv20.setText(moneyValues.get(1));
        tv10.setText(moneyValues.get(2));
        tv5.setText(moneyValues.get(3));
        tv2.setText(moneyValues.get(4));
        tv1.setText(moneyValues.get(5));
        tv05.setText(moneyValues.get(6));
    }

    private ArrayList<String> getMoneyFromText(String text){
        ArrayList<String> moneyValues = new ArrayList<>();
        String[] tip = text.split("\\n");
        for(int i=0;i<tip.length;i++){
            moneyValues.add(tip[i]);
        }
        return moneyValues;

    }

    private void makeText(){
        text="";
        for(int i = 0; i< moneyValues.size(); i++){
            text=text+ moneyValues.get(i)+"\n";
        }
    }

    public void addMoney(View view){

        switch(view.getId()){
            case R.id.bAddTwenty:
                add(20,1);
                break;
            case R.id.bAddTen:
                add(10,2);
                break;
            case R.id.bAddFive:
                add(5,3);
                break;
            case R.id.bAddTwo:
                add(2,4);
                break;
            case R.id.bAddOne:
                add(1,5);
                break;
            case R.id.bAddPointFive:
                add(0.5,6);
                break;
        }
    }


    public void subMoney(View view){

        switch(view.getId()){
            case R.id.bSubTwenty:
                substract(20,1);
                break;
            case R.id.bSubTen:
                substract(10,2);
                break;
            case R.id.bSubFive:
                substract(5,3);
                break;
            case R.id.bSubTwo:
                substract(2,4);
                break;
            case R.id.bSubOne:
                substract(1,5);
                break;
            case R.id.bSubPointFive:
                substract(0.5,6);
                break;
        }
    }

    public void add(double amount, int id){
        double total = Double.parseDouble(moneyValues.get(0));
        total+=amount;
        int multiplier =  Integer.parseInt(moneyValues.get(id))+1;
        moneyValues.set(id,""+multiplier);
        moneyValues.set(0,""+total);
        makeText();
        try {
            Io.writeToFile(this,text,getResources().getString(R.string.file_name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setTextfields(moneyValues);
    }

    public void substract(double amount, int id){
        double total = Double.parseDouble(moneyValues.get(0));
        int multiplier = Integer.parseInt(moneyValues.get(id)) ;
        if(total>(amount-1)&&multiplier>0) {
            total -= amount;
            multiplier-=1;
            moneyValues.set(id, "" + multiplier);
            moneyValues.set(0, "" + total);
            makeText();
            try {
                Io.writeToFile(this,text,getResources().getString(R.string.file_name));
            } catch (IOException e) {
                e.printStackTrace();
            }
            setTextfields(moneyValues);
        }
    }

    public void reset(View view){
        for(int i=0;i<7;i++){
            moneyValues.set(i,"0");
        }
        makeText();
        try {
            Io.writeToFile(this,text,getResources().getString(R.string.file_name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setTextfields(moneyValues);
    }


}
