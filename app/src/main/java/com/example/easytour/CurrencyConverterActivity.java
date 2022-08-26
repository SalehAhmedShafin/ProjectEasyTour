package com.example.easytour;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CurrencyConverterActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Spinner sp1,sp2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);

        editText=findViewById(R.id.txtAmount);
        textView=(TextView)findViewById(R.id.displayTxt);
        sp1=findViewById(R.id.spFrom);
        sp2=findViewById(R.id.spTo);
        btn=findViewById(R.id.converBtn);

        String [] from ={"Australian Dollar","American Dollar","Canadian Dollar","Chinese Yuan","Euro","Indian Rupee","Myanmar Kyat"};
        ArrayAdapter arrayAdapter= new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(arrayAdapter);

        String [] to ={"Bangladeshi Taka"};
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(arrayAdapter2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String et=editText.getText().toString().trim();

                if (et.isEmpty())
                {
                    editText.setError("Provide Amount!");
                }
                else {

                    Double tot;
                    Double amount = Double.parseDouble(editText.getText().toString());


                    if (sp1.getSelectedItem().toString() == "Australian Dollar") {
                        tot = amount * 61.68;
                        textView.setText(tot.toString() + " TK");

                    }
                    else if (sp1.getSelectedItem().toString() == "American Dollar") {
                        tot = amount * 85.50;
                        textView.setText(tot.toString() + " TK");

                    }
                    else if (sp1.getSelectedItem().toString() == "Canadian Dollar") {
                        tot = amount * 67.32;
                        textView.setText(tot.toString() + " TK");

                    }
                    else if (sp1.getSelectedItem().toString() == "Chinese Yuan") {
                        tot = amount * 13.29;
                        textView.setText(tot.toString() + " TK");

                    }
                    else if (sp1.getSelectedItem().toString() == "Euro") {
                        tot = amount * 99.21;
                        textView.setText(tot.toString() + " TK");

                    }
                    else if (sp1.getSelectedItem().toString() == "Indian Rupee") {
                        tot = amount * 1.15;
                        textView.setText(tot.toString() + " TK");

                    }
                    else if (sp1.getSelectedItem().toString() == "Myanmar Kyat") {
                        tot = amount * 0.046;
                        textView.setText(tot.toString() + " TK");

                    }
                }
            }
        });

    }
}