package com.example.etudiant.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    //Permission pour accéder au GPS
    private static final int MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION = 123 ;
    public static String bddName="bdd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //getActionBar().setTitle("Calculateur de tip");

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setTitle("Le guide du petit sag");
        requestPermission();
        createDatabase();
    }

    private void createDatabase(){
        SQLiteOpenHelper helper=new DatabaseHandler(getApplicationContext(), bddName, null, 3);
        helper.onUpgrade(helper.getWritableDatabase(), 3, 3);
        ContentValues value = new ContentValues();
        value.put(DatabaseHandler.ARTICLE_TITRE, ArticleActivity.titre1);
        value.put(DatabaseHandler.ARTICLE_CONTENU, ArticleActivity.article1);
        helper.getWritableDatabase().insert(DatabaseHandler.ARTICLE_TABLE_NAME, null, value);
        ContentValues value2 = new ContentValues();
        value2.put(DatabaseHandler.ARTICLE_TITRE, ArticleActivity.titre2);
        value2.put(DatabaseHandler.ARTICLE_CONTENU, ArticleActivity.article2);
        helper.getWritableDatabase().insert(DatabaseHandler.ARTICLE_TABLE_NAME, null, value2);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.articles) {
            Intent intent =  new Intent(this, ArticleActivity.class);
            startActivity(intent);
        } else if (id == R.id.convertor) {
            Intent intent =  new Intent(this, ConvertorDevise.class);
            startActivity(intent);
        } else if (id == R.id.calculator_tips) {
            Intent intent =  new Intent(this, activity_tip_calculator.class);
            startActivity(intent);
        } else if (id == R.id.point_interet) {
            Intent intent =  new Intent(this, InteretActivity.class);
            startActivity(intent);

        } else if (id == R.id.dico_expression) {
            Intent intent = new Intent(this,DictionnaireActivity.class);
            startActivity(intent);
        } /*else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_COARSE_LOCATION);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION);
    }
}
