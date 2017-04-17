package com.example.etudiant.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewGroupCompat;
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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

public class DictionnaireActivity extends Fragment {
    
    class Expression{
        
        public Expression(String qc, String fr) {
            this.qc = qc;
            this.fr = fr;
        }

        public String getQc() {
            return qc;
        }

        public void setQc(String qc) {
            this.qc = qc;
        }

        public String getFr() {
            return fr;
        }

        public void setFr(String fr) {
            this.fr = fr;
        }

        private String qc;
        private String fr;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.content_dictionnaire, container, false);
        Expression[] expressions= new Expression[50];
        for (int i =0;i<10;i+=1){
            expressions[i*5]=new Expression("Yup","Oui");
            expressions[i*5+1]=new Expression("Ostie de tarbarnak","Zut!");
            expressions[i*5+2]=new Expression("asdadasdasdasdasdasdasdasdasdadadwadwasdwasdwasdwasdwasdwasdwasdLoL","MDR");
            expressions[i*5+3]=new Expression("Salut","Bonjour");
            expressions[i*5+4]=new Expression("Nope","Non");
        }
        DictionnaireAdapter da = new DictionnaireAdapter(view.getContext(),expressions);
        ((ListView) view.findViewById(R.id.dicoListView)).setAdapter(da);

        return view;
    }




    private class DictionnaireAdapter extends ArrayAdapter<Expression>{
        private final Context context;
        private final Expression[] values;

        public DictionnaireAdapter(Context context, Expression[] values) {
            super(context, -1, values);
            this.context = context;
            this.values = values;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Log.e("yo",String.valueOf(position));
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.item_dictionnaire, parent, false);
            TextView qcTextView = (TextView) rowView.findViewById(R.id.qcTextView);
            TextView frTextView = (TextView) rowView.findViewById(R.id.frTextView);
            qcTextView.setText(values[position].getQc());
            frTextView.setText(values[position].getFr());
            return rowView;
        }
    }
}
