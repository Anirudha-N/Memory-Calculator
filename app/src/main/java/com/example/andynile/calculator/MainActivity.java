package com.example.andynile.calculator;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    SharedPreferences sharedPreferences;
    public static final String Calc = "CALCULATOR" ;
    public void calc(View v) {
     try {
         EditText n1 = (EditText) findViewById(R.id.num1);
         TextView t1 = (TextView) findViewById(R.id.result);

         float a = Float.parseFloat(n1.getText().toString());
         String a1= String.valueOf(a);
         float c = 0;
         Double r;


         switch (v.getId()) {
             case R.id.Add:

                 EditText n2 = (EditText) findViewById(R.id.num2);
                 Float b = Float.parseFloat(n2.getText().toString());
                 c = a + b;
                 String c1=String.valueOf(c);
                 String b1=String.valueOf(b);
                 String d1= a1+ "+" + b1+"=";
                 try{
                     sharedPreferences= getSharedPreferences(Calc,MODE_APPEND);
                     SharedPreferences.Editor editor = sharedPreferences.edit();
                     editor.putString(d1,c1);
                     editor.apply();
                     String ret = d1+c1;
                     t1.setText(ret);
                     }
                    catch (Exception e) {
                     e.printStackTrace();
                    }
                 break;

             case R.id.Divide:
                 EditText n3 = (EditText) findViewById(R.id.num2);
                 Float e = Float.parseFloat(n3.getText().toString());
                 c = a / e;
                 c1=String.valueOf(c);
                 b1=String.valueOf(e);
                 d1= a1+ "/" + b1+"=";

                 try{
                     sharedPreferences= getSharedPreferences(Calc,MODE_APPEND);
                     SharedPreferences.Editor editor = sharedPreferences.edit();
                     editor.putString(d1,c1);
                     editor.apply();
                     String ret = d1+c1;
                     t1.setText(ret);

                 }
                 catch (Exception d) {
                     d.printStackTrace();
                 }
                 break;

             case R.id.Mul:
                 EditText n4 = (EditText) findViewById(R.id.num2);
                 Float f = Float.parseFloat(n4.getText().toString());
                 c = a * f;
                 c1=String.valueOf(c);
                 b1=String.valueOf(f);
                 d1= a1+ "*" + b1+"=";
                 try{
                     sharedPreferences= getSharedPreferences(Calc,MODE_APPEND);
                     SharedPreferences.Editor editor = sharedPreferences.edit();
                     editor.putString(d1,c1);
                     editor.apply();
                     String ret = d1+c1;
                     t1.setText(ret);

                 }
                 catch (Exception g) {
                     g.printStackTrace();
                 }
                 break;

             case R.id.Sub:
                 EditText n5 = (EditText) findViewById(R.id.num2);
                 Float g = Float.parseFloat(n5.getText().toString());
                 c = a - g;
                 c1=String.valueOf(c);
                 b1=String.valueOf(g);
                 d1= a1+ "-" + b1+"=";

                 try{
                     sharedPreferences= getSharedPreferences(Calc,MODE_APPEND);
                     SharedPreferences.Editor editor = sharedPreferences.edit();
                     editor.putString(d1,c1);
                     editor.apply();
                     String ret = d1+c1;
                     t1.setText(ret);
                 }

                 catch (Exception m) {
                     m.printStackTrace();
                 }
                 break;

             case R.id.sin:
                 r = Math.sin(Math.toRadians(a));
                 b1=String.valueOf(r);
                 d1= "Sin" +"("+ a1 +")"+"=";
                 try{
                     sharedPreferences= getSharedPreferences(Calc,MODE_APPEND);
                     SharedPreferences.Editor editor = sharedPreferences.edit();
                     editor.putString(d1,b1);
                     editor.apply();
                     String ret = d1+b1;
                     t1.setText(ret);

                 }
                 catch (Exception m) {
                     m.printStackTrace();
                 }
                 break;

             case R.id.cos:
                 r = Math.cos(Math.toRadians(a));
                 b1=String.valueOf(r);
                 d1= "Cos" +"("+ a1 +")"+"=";
                 try{
                     sharedPreferences= getSharedPreferences(Calc,MODE_APPEND);
                     SharedPreferences.Editor editor = sharedPreferences.edit();
                     editor.putString(d1,b1);
                     editor.apply();
                     String ret = d1+b1;
                     t1.setText(ret);
                 }
                 catch (Exception m) {
                     m.printStackTrace();
                 }
                 break;

             case R.id.tan:


                 r = Math.tan(Math.toRadians(a));
                 b1=String.valueOf(r);
                 d1= "Tan" +"("+ a1 +")"+"=";

                 try{
                     sharedPreferences= getSharedPreferences(Calc,MODE_APPEND);
                     SharedPreferences.Editor editor = sharedPreferences.edit();
                     editor.putString(d1,b1);
                     editor.apply();
                     String ret = d1+b1;
                     t1.setText(ret);

                 }
                 catch (Exception m) {
                     m.printStackTrace();
                 }
                 break;
         }
       //  t1.setText(Double.toString(c));
     }
     catch (Exception e)
     {
         Toast.makeText(MainActivity.this,"No input,Plz insert input",Toast.LENGTH_LONG).show();
     }
    }

    public void Show(View v)
    {

        TextView t1 = (TextView) findViewById(R.id.result);
        try{


            String temp="";
            Map<String, ? > allEntries = sharedPreferences.getAll();
            for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
                String temp1=entry.getKey();
                String temp2=entry.getValue().toString();
                temp=temp+(temp1+temp2);
                t1.setText(temp);
            }

        }

        catch(Exception e)
        {e.printStackTrace();}
    }

}
