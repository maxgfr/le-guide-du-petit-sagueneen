package com.example.etudiant.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by etudiant on 2017-04-17.
 */

public class DetailsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.article_view, container, false);
        ((WebView) view.findViewById(R.id.webViewInArticle)).loadData(ArticleActivity.c.getString(0), "text/html; charset=utf-8", null);
        return view;
    }

}
