package com.example.etudiant.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by etudiant on 2017-04-16.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String ARTICLE_KEY = "id";
    public static final String ARTICLE_TITRE = "titre";
    public static final String ARTICLE_CONTENU = "contenu";
    public static final String ARTICLE_TABLE_NAME = "articles";
    public static final String ARTICLE_TABLE_CREATE="CREATE TABLE "+ARTICLE_TABLE_NAME+" ("+ARTICLE_KEY+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ARTICLE_TITRE+" TEXT, "+ARTICLE_CONTENU+" TEXT);";
    public static final String ARTICLE_TABLE_DROP = "DROP TABLE IF EXISTS " + ARTICLE_TABLE_NAME + ";";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ARTICLE_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ARTICLE_TABLE_DROP);
        onCreate(db);
    }
}
