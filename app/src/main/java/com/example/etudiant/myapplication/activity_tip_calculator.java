package com.example.etudiant.myapplication;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity_tip_calculator extends Fragment
         {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_tip_calculator2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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
       texttoCalc.addTextChangedListener(tw);
        textPercentage.addTextChangedListener(tw);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportActionBar().setTitle("Calculateur de tip");*/

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                      Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_activity_tip_calculator, container, false);
        final EditText texttoCalc = (EditText) view.findViewById(R.id.editText_withoutTip);
        final EditText textPercentage = (EditText) view.findViewById(R.id.editText_tipPercentage);

        final TextView textTip = (TextView) view.findViewById(R.id.textView_tip);
        final TextView textTotalTip = (TextView) view.findViewById(R.id.textView_WithTip);

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
        texttoCalc.addTextChangedListener(tw);
        textPercentage.addTextChangedListener(tw);
        return view;
    }





}
