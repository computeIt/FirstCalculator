package com.example.addy.firstcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Float.*;

public class MainActivity extends Activity implements View.OnClickListener {
    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;

    Button addition, subtraction, division, multiply;
    EditText op1, op2;
    TextView result;
    String action;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        op1 = (EditText) findViewById(R.id.op1);
        op2 = (EditText) findViewById(R.id.op2);

        addition = (Button) findViewById(R.id.summ);
        subtraction = (Button) findViewById(R.id.subtraction);
        division = (Button) findViewById(R.id.division);
        multiply = (Button) findViewById(R.id.multiply);

        result = findViewById(R.id.result);

        addition.setOnClickListener(this);
        subtraction.setOnClickListener(this);
        division.setOnClickListener(this);
        multiply.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(TextUtils.isEmpty(op1.getText().toString()) || TextUtils.isEmpty(op2.getText().toString()))
            return;

        float num1 = parseFloat(op1.getText().toString());
        float num2 = parseFloat(op2.getText().toString());
        float res = 0;

        switch (view.getId()){
            case R.id.summ:
                res = num1 + num2;
                action = "+";
                break;
            case R.id.subtraction:
                res = num1 - num2;
                action = "-";
                break;
            case R.id.multiply:
                res = num1*num2;
                action = "*";
                break;
            case R.id.division:
                res = num1/num2;
                action = "/";
                break;
            default: break;
        }

//        if("/".equals(action) && compare(num2, 0) == 0){
//            result.setText("division by zero!!!");
//            return;
//        }

        result.setText(num1 + " " + action + " " + num2 + " = " + res);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0, MENU_RESET_ID, 0, "Reset");
        menu.add(0, MENU_QUIT_ID, 0, "Quit");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case MENU_RESET_ID:
                op1.setText("");
                op2.setText("");
                result.setText("");
                break;
            case MENU_QUIT_ID:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
