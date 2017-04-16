package com.example.etudiant.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ConvertorDevise extends AppCompatActivity {

    private int positionList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertor_devise);

        final EditText texttoConvert = (EditText) findViewById(R.id.editText_withoutTip);

        final EditText textConverted = (EditText) findViewById(R.id.editText_converted);

        Spinner spinner = (Spinner) findViewById(R.id.list_convert);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.list_convertion, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("list", String.valueOf(position));
                positionList=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        TextWatcher tw = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s){
                if(texttoConvert.hasFocus()) {
                    if (texttoConvert.getText().toString().length() > 0) {
                        float fToConvert = Float.valueOf(texttoConvert.getText().toString());
                        float fConverted = convertTo(fToConvert,positionList,false);
                        textConverted.setText(String.valueOf(fConverted));

                    }
                }

            }
        };


        TextWatcher tw2 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(textConverted.hasFocus()) {
                    if (textConverted.getText().toString().length() > 0) {
                        float fToConvert = Float.valueOf(textConverted.getText().toString());
                        float fConverted = convertTo(fToConvert,positionList,true);
                        texttoConvert.setText(String.valueOf(fConverted));
                    }
                }
            }
        };

        Button but = (Button) findViewById(R.id.button2);

        texttoConvert.addTextChangedListener(tw);
        textConverted.addTextChangedListener(tw2);




        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float fToConvert = Float.valueOf(texttoConvert.getText().toString());

                float fConverted = convertTo(fToConvert,positionList,false);

                textConverted.setText(String.valueOf(fConverted));

            }
        });

        //textConverted.setText(texttoConvert.getText());
    }

    public float convertTo(float toConvert , int idConvertion , boolean reverse){
        float converted = 0;
        float convertor = 1 ;

        Log.d("convert", String.valueOf(idConvertion));
        switch (idConvertion)
        {
            case 0:
                //lb to kg
                convertor = 0.453592f;
                break;
            case 1:
                //inch to cm
                convertor = 2.54f;
                break;
            case 2:
                //feet to m
                convertor = 0.3048f;
                break;
            case 3:
                //oz to g
                convertor = 28.3495f;
                break;

            case 4:
                //ozl to ml
                convertor = 28.4131f;
                break;

            case 5:
                //F to C
                if(reverse)
                    converted = toConvert * 9/5 + 32;
                else
                    converted = (toConvert - 32) * 5/9;

                return converted;

            case 6:
                //dollarCAD to Euro
                convertor = 1.43020f;
                break;

            default:
        }

        if (reverse){
            converted = toConvert/convertor;
        }
        else {
            converted = toConvert * convertor;
        }
        return converted;
    }

}
