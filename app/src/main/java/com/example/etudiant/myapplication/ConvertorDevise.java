package com.example.etudiant.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConvertorDevise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertor_devise);

        final EditText texttoConvert = (EditText) findViewById(R.id.editText_withoutTip);

        final EditText textConverted = (EditText) findViewById(R.id.editText_converted);

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
                        float fConverted = fToConvert * 1.43020f;
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
                        float fConverted = fToConvert / 1.43020f;
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

                float fConverted = fToConvert * 1.43020f;

                textConverted.setText(String.valueOf(fConverted));

            }
        });

        //textConverted.setText(texttoConvert.getText());
    }
}
