package com.example.etudiant.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class TipCalculatorActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        final EditText texttoCalc = (EditText) findViewById(R.id.editText_withoutTip);
        final EditText textPercentage = (EditText) findViewById(R.id.editText_tipPercentage);

        final TextView textTip = (TextView) findViewById(R.id.textView_tip);
        final TextView textTotalTip = (TextView) findViewById(R.id.textView_WithTip);

        TextWatcher tw = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(texttoCalc.getText().toString().trim().length() > 0 && textPercentage.getText().toString().trim().length() > 0){
                    float fToCalc = Float.valueOf(texttoCalc.getText().toString());
                    float fPercentage = Float.valueOf(textPercentage.getText().toString());
                    float fTip = (Math.round(fToCalc * fPercentage)) / 100.0f;
                    textTip.setText(String.valueOf(fTip));
                    textTotalTip.setText(String.valueOf(fToCalc + fTip));
                }
            }
        };
        Button but = (Button) findViewById(R.id.button2);

        texttoCalc.addTextChangedListener(tw);
        textPercentage.addTextChangedListener(tw);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float fToCalc = Float.valueOf(texttoCalc.getText().toString());
                float fPercentage = Float.valueOf(textPercentage.getText().toString());
                float fTip = (Math.round(fToCalc*fPercentage))/100.0f;
                textTip.setText(String.valueOf(fTip));
                textTotalTip.setText(String.valueOf(fToCalc+fTip));

            }
        });

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.articles) {
            // Handle the camera action
        } else if (id == R.id.convertor) {
            Intent intent =  new Intent(this, ConvertorDevise.class);
            startActivity(intent);
        } else if (id == R.id.calculator_tips) {
            Intent intent =  new Intent(this, TipCalculatorActivity.class);
            startActivity(intent);
        } /*else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
