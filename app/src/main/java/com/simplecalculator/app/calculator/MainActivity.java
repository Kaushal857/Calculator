package com.simplecalculator.app.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.StreamHandler;

public class MainActivity extends AppCompatActivity {

    TextView edtNum;
    EditText disText;
    Button add, subtract, multiply, divide, root, mod, calculate, clear, log;
    String str;
    double num1, num2, i=0, number, secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNum = findViewById(R.id.number);
        disText = findViewById(R.id.text);
        str = "\0";
        num1 = num2 = 0;
        //
        subtract = findViewById(R.id.subtract);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        root = findViewById(R.id.root);
        mod = findViewById(R.id.mod);
        calculate = findViewById(R.id.calculate);
        //

        disText.setMovementMethod(new ScrollingMovementMethod());

        log = findViewById(R.id.log);
        log.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                edtNum.setText("");
                disText.setText("log ");
                edtNum = findViewById(R.id.number);
                i = 7;
//                edtNum = findViewById(R.id.number);
//                disText = findViewById(R.id.text);
            }
        });

        add = findViewById(R.id.plus);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String str1 = edtNum.getText().toString();
                if (str == "\0")
                    str = str1 + " + ";
                else
                    str = str + str1 + " + ";
                try{
                    num1 = num1 + Double.parseDouble(str1);
                }catch(NumberFormatException ex){
                    num1 = num1+0;
                }
                disText.setText(str);
                edtNum.setText("");
                edtNum = findViewById(R.id.number);
                disText = findViewById(R.id.text);
                i = 1;
            }
        });

        subtract = findViewById(R.id.subtract);
        subtract.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String str1 = edtNum.getText().toString();
                if (str == "\0")
                    str = str1 + " - ";
                else
                    str = str + str1 + " - ";
                try{
                    num2 = Integer.parseInt(str1);
                }catch(NumberFormatException ex){
                    num2 = 0;
                }
                if (num1 == 0)
                    num1 = num2;
                else
                    num1 = num1 - num2;
                disText.setText(str);
                edtNum.setText("");
                edtNum = findViewById(R.id.number);
                disText = findViewById(R.id.text);
                i = 2;
            }
        });

        multiply = findViewById(R.id.multiply);
        multiply.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String str1 = edtNum.getText().toString();
                if (str == "\0")
                    str = str1 + " x ";
                else
                    str = str + str1 + " x ";
                try{
                    num2 = Integer.parseInt(str1);
                }catch(NumberFormatException ex){
                    num2 = 1;
                }
                if (num1 == 0)
                    num1 = num2;
                else
                    num1 = num1 * num2;
                disText.setText(str);
                edtNum.setText("");
                edtNum = findViewById(R.id.number);
                disText = findViewById(R.id.text);
                i = 3;
            }
        });

        divide = findViewById(R.id.divide);
        divide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String str1 = edtNum.getText().toString();
                if (str == "\0")
                    str = str1 + " ÷ ";
                else
                    str = str + str1 + " ÷ ";
                try{
                    num2 = Double.parseDouble(str1);
                }catch(NumberFormatException ex){
                    secondNumber = 1;
                }
                if (num1 == 0)
                    num1 = num2;
                else
                    num1 = num1 / num2;
                disText.setText(str);
                edtNum.setText("");
                edtNum = findViewById(R.id.number);
                disText = findViewById(R.id.text);
                i = 4;
            }
        });

        mod = findViewById(R.id.mod);
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = edtNum.getText().toString();
                if (str == "\0")
                    str = str1 + " % ";
                else
                    str = str + str1 + " % ";
                try{
                    num2 = Double.parseDouble(edtNum.getText().toString());
                }catch(NumberFormatException ex){
                    num2 = 0;
                }
                if (num1 == 0)
                    num1 = num2;
                else
                    num1 = num1 % num2;
                disText.setText(str);
                edtNum.setText("");
                edtNum = findViewById(R.id.number);
                disText = findViewById(R.id.text);
                i = 5;
            }
        });

        clear = findViewById(R.id.clearText);
        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String str = edtNum.getText().toString();
                if(str.length() <= 0) {
                    edtNum.setText("");
                    edtNum = findViewById(R.id.number);
                    disText.setText("");
                    disText = findViewById(R.id.text);
                }
                else {
                    str = str.substring(0, str.length() - 1);
                    edtNum.setText(str);
                }
            }
        });

        clear = findViewById(R.id.clearText);
        clear.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {

                edtNum.setText("");
                edtNum = findViewById(R.id.number);
                disText.setText("");
                disText = findViewById(R.id.text);
                num1 = num2 = 0;
                str = "\0";
                return true;

            }
        });
    }

    public void button0ButtonPressed(View buttonView) {

        String str = edtNum.getText().toString();
        str = str + "0";
        edtNum.setText(str);
    }

    public void button1ButtonPressed(View buttonView) {

        String str = edtNum.getText().toString();
        str = str + "1";
        edtNum.setText(str);
    }

    public void button2ButtonPressed(View buttonView) {

        String str = edtNum.getText().toString();
        str = str + "2";
        edtNum.setText(str);
    }

    public void button3ButtonPressed(View buttonView) {

        String str = edtNum.getText().toString();
        str = str + "3";
        edtNum.setText(str);
    }

    public void button4ButtonPressed(View buttonView) {

        String str = edtNum.getText().toString();
        str = str + "4";
        edtNum.setText(str);
    }

    public void button5ButtonPressed(View buttonView) {

        String str = edtNum.getText().toString();
        str = str + "5";
        edtNum.setText(str);
    }

    public void button6ButtonPressed(View buttonView) {

        String str = edtNum.getText().toString();
        str = str + "6";
        edtNum.setText(str);
    }

    public void button7ButtonPressed(View buttonView) {

        String str = edtNum.getText().toString();
        str = str + "7";
        edtNum.setText(str);
    }

    public void button8ButtonPressed(View buttonView) {

        String str = edtNum.getText().toString();
        str = str + "8";
        edtNum.setText(str);
    }

    public void button9ButtonPressed(View buttonView) {

        String str = edtNum.getText().toString();
        str = str + "9";
        edtNum.setText(str);
    }

    public void buttonDotButtonPressed(View buttonView) {

        String str = edtNum.getText().toString();
        str = str + ".";
        edtNum.setText(str);
    }

    public void rootButtonPressed(View buttonView) {

        try {
            num1 = Integer.parseInt(edtNum.getText().toString());
        } catch (NumberFormatException ex) {
            num1 = 0;
        }
        disText.setText(" √  " + num1 + "");
        edtNum.setText("");
        edtNum = findViewById(R.id.number);
        disText = findViewById(R.id.text);
        i = 6;

    }

    public void calculateButtonPressed(View buttonView) {
//        if(i!=6) {
//            try{
//                num2 = Integer.parseInt(edtNum.getText().toString());
//            }catch(NumberFormatException ex){
//                num2 = 0;
//            }
//        }
        if (i == 1) {
            String str1 = edtNum.getText().toString();
            str = str + str1;
            try{
                num1 = num1+Double.parseDouble(str1);
            }catch(NumberFormatException ex){
                num1 = num1 + 0;
            }
            disText.setText(str);
            if (num1 % 1 == 0)
                edtNum.setText((int)num1 + "");
            else {
                double answer = Math.round(num1 * 100000) / 100000.0;
                edtNum.setText(answer + "");
            }
            num1 = num2 =0;
            str = "\0";
        }

        else if (i == 2) {

            String str1 = edtNum.getText().toString();
            str = str + str1;
            try{
                num1 = num1-Integer.parseInt(str1);
            }catch(NumberFormatException ex){
                num1 = num1-0;
            }
            disText.setText(str);
            if (num1 % 1 == 0)
                edtNum.setText((int)num1 + "");
            else {
                double answer = Math.round(num1 * 100000) / 100000.0;
                edtNum.setText(answer + "");
            }
            num1 = num2 =0;
            str = "\0";

        }

        else if (i == 3) {

            String str1 = edtNum.getText().toString();
            str = str + str1;
            try{
                num1 = num1*Integer.parseInt(str1);
            }catch(NumberFormatException ex){
                num1 = num1*1;
            }
            disText.setText(str);
            if (num1 % 1 == 0)
                edtNum.setText((int)num1 + "");
            else {
                double answer = Math.round(num1 * 100000) / 100000.0;
                edtNum.setText(answer + "");
            }
            num1 = num2 =0;
            str = "\0";

        }

        else if (i == 4) {

            String str1 = edtNum.getText().toString();
            str = str + str1;
            try{
                num1 = num1/Double.parseDouble(str1);
            }catch(NumberFormatException ex){
                num1 = num1/1;
            }
            disText.setText(str);
            if (num1 % 1 == 0)
                edtNum.setText((int)num1 + "");
            else {
                double answer = Math.round(num1 * 100000) / 100000.0;
                edtNum.setText(answer + "");
            }
            num1 = num2 = 0;
            str = "\0";
        }

        else if (i == 5) {

            String str1 = edtNum.getText().toString();
            str = str + str1;
            try{
                num1 = num1 % Double.parseDouble(str1);
            }catch(NumberFormatException ex){
                num1 = num1 / 1;
            }
            disText.setText(str);
            if (num1 % 1 == 0)
                edtNum.setText((int)num1 + "");
            else {
                double answer = Math.round(num1 * 100000) / 100000.0;
                edtNum.setText(answer + "");
            }
            num1 = num2 = 0;
            str = "\0";

//            num2 = Double.parseDouble(edtNum.getText().toString());
//            disText.setText((int)num1 + "" + " % " + (int)num2 + "");
//            calculatedValue = num1 % num2;
//            num1 = calculatedValue;
//            edtNum.setText(calculatedValue + "");
        }

        else if (i == 6) {
            //disText.setText(num1 + "" + " √ " + num2 + "");
            //int sum = num1 + num2;
            double sqroot = Math.sqrt(num1);
            edtNum.setText(sqroot + "");
        }

        else if (i == 7) {
            try{
                num1 = Integer.parseInt(edtNum.getText().toString());
            }catch(NumberFormatException ex){
                num1 = 0;
            }
            double logNum = Math.log(num1);
            disText.setText("log " + num1 + "");
            edtNum.setText(logNum + "");
        }
    }
}