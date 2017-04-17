package com.example.etudiant.myapplication;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ConvertorDevise extends android.app.Fragment {

    private int positionList;

    private float[] rates;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*rates = new float[10];

        final EditText texttoConvert = (EditText) getActivity().findViewById(R.id.editText_withoutTip);

        final EditText textConverted = (EditText) getActivity().findViewById(R.id.editText_converted);

        Spinner spinner = (Spinner) getActivity().findViewById(R.id.list_convert);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
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

        Button but = (Button) getActivity().findViewById(R.id.button2);

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

        request("CAD","EUR",0);*/
        //textConverted.setText(texttoConvert.getText());




    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_convertor_devise, container, false);

        // Inflate the layout for this fragment
        rates = new float[10];

        final EditText texttoConvert = (EditText) view.findViewById(R.id.editText_withoutTip);

        final EditText textConverted = (EditText) view.findViewById(R.id.editText_converted);

        Spinner spinner = (Spinner) view.findViewById(R.id.list_convert);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
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

        Button but = (Button) view.findViewById(R.id.button2);

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

        request("CAD","EUR",0);
        return view;
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
                convertor = rates[0];
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


    private void request(final String baseCode, final String goalCode,final int rateID){
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        final String url= "https://openexchangerates.org/api/latest.json?app_id=8d4ef192e4d848c89c4b540f379cc91d";


        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>(){

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            float buffer = Float.valueOf(response.getJSONObject("rates").get(goalCode).toString())/Float.valueOf(response.getJSONObject("rates").get(baseCode).toString());
                            rates[rateID]=buffer;
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        queue.add(jsObjRequest);
    }
}
