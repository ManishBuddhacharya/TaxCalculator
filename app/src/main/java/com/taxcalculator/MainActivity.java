package com.taxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnCalculate;
    private EditText etSalary;
    private TextView tvOutput;

    double salary, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate = findViewById(R.id.btnCalculate);
        etSalary= findViewById(R.id.etSalary);
        tvOutput = findViewById(R.id.tvOutput);

        btnCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalculate) {
            if (validation()) {
                salary = Double.parseDouble(etSalary.getText().toString())*12;
                TaxCalc obj = new TaxCalc();
                obj.setSalary(salary);
                res = obj.calculateTax();
                tvOutput.setText("Your Tax is " + Double.toString(res));
            }
        }
    }

    public boolean validation(){
        boolean flag = true;
        if (TextUtils.isEmpty(etSalary.getText().toString())) {
            etSalary.setError("Please enter Salary");
            etSalary.requestFocus();
            flag = false;
        }
        return flag;
    }
}
