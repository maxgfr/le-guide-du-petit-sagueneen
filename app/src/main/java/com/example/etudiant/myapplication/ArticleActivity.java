package com.example.etudiant.myapplication;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by etudiant on 2017-03-27.
 */

public class ArticleActivity extends Fragment {

    ListView list;
    WebView articleVue;
    boolean detail=false;
    public static Cursor c;

    public static String css = "<style>h1{color : #FF0000;} p{text-align : justify;}</style>";

    public static String article1 = "<head>"+css+"</head><body><br/><h1>Les grandes villes</h1><br/><p>Montréal est la deuxième ville la plus peuplée du Canada. Elle se situe principalement sur l’île fluviale de Montréal, sur le Fleuve Saint-Laurent (entre Québec et le Lac Ontario) dans le sud de la province du Québec, dont elle est la principale métropole3.\n" +
            "\n" +
            "Ville francophone la plus peuplée d'Amérique4, Montréal est considérée comme ayant la deuxième population francophone au monde après ParisNote 1,5,6. En 2016, la ville de comptait 1 704 694 habitants7[réf. incomplète] et son aire urbaine plus de quatre millions, soit environ la moitié de la population du Québec8,9[réf. insuffisante]. Montréal est ainsi la 19e agglomération la plus peuplée d'Amérique du Nord10 et la 122e ville la plus peuplée du monde11. En 2011, environ 50 % de la population de Montréal était de langue maternelle française, 13 % était de langue anglaise et 33 % était d'une autre langue12, ce qui fait d'elle l'une des villes les plus cosmopolites du monde13.\n" +
            "\n" +
            "Cœur économique du Québec, Montréal demeure le second plus grand centre financier du pays et possède une économie fortement diversifiée14 par le commerce, l’éducation, les technologies de l'information et les industries aérospatiale, pharmaceutique, du tourisme et du cinéma. Classée ville mondiale en 2012, Montréal est la deuxième ville consulaire d'Amérique du Nord, abrite le siège de l'Organisation de l'aviation civile internationale et est le siège de plus de 60 organisations internationales15. De plus, la ville est la première d'Amérique du Nord pour le nombre de congrès internationaux16. En 2017, Montréal est consacrée « meilleure ville étudiante » au monde17 et est considérée comme la métropole universitaire du Canada18.\n" +
            "\n" +
            "Montréal a accueilli plusieurs événements internationaux d'envergure, dont l'Exposition universelle de 1967 et les Jeux olympiques d'été de 1976. Hôte du grand prix de Formule 1 du Canada, elle accueille annuellement de nombreux festivals, tels le Festival international de jazz de Montréal, les FrancoFolies, et le festival Juste pour rire. Le club de hockey des Canadiens de Montréal y a élu domicile dès sa création en 1909.</p><p>Québec (prononciation en français [ke.bɛk]) est la capitale nationale du Québec3, une des provinces du Canada. Elle est située dans la région administrative de la Capitale-Nationale. Elle est le siège de nombreuses institutions dont le Parlement du Québec.\n" +
            "\n" +
            "La ville de Québec compte 531 902 habitants ( Juillet 2016 ) et une communauté métropolitaine de 800 296 ( Juillet 2016 ), faisant d'elle la deuxième ville la plus peuplée du Québec après Montréal. Le nom officiel de la ville est « Québec », bien que l'expression « Ville de Québec » soit souvent employée afin de distinguer la ville de la province. De la même façon, bien que le gentilé officiel soit « Québécois(e) », on va plus couramment employer l'expression « Gens de Québec ».\n" +
            "\n" +
            "Le rétrécissement du fleuve Saint-Laurent entre les villes de Québec et de Lévis, sur la rive opposée, a donné le nom à la ville, Kébec étant un mot algonquin signifiant « là où le fleuve se rétrécit ». Fondée en 1608 par Samuel de Champlain, Québec est une des plus anciennes villes d'Amérique du Nord. Les remparts font de Québec la seule ville fortifiée au nord du Mexique. Le Vieux-Québec a été déclaré patrimoine mondial en 1985 par l'UNESCO4,5.</p></body>";

    public static String article2 = "<head>"+css+"</head><body><br/><h1>Le français québecois</h1><br/><p>Le français québécois, aussi appelé français du Québec ou simplement québécois, est la variété de la langue française parlée essentiellement par les francophones du Québec3.\n" +
            "\n" +
            "Le français écrit du Québec est syntaxiquement identique au français européen et international. Il ne s'en distingue que marginalement sur le plan lexical. Quant au français oral, passablement différent du français écrit, il comporte des écarts syntaxiques et phonétiques parfois prononcés par rapport à la norme. Le québécois connaît des variétés régionales, dont le joual, parler populaire de Montréal (voir Variations régionales).\n" +
            "\n" +
            "L'Office québécois de la langue française travaille au développement de la langue française et appuie certaines particularités qui peuvent diverger parfois avec l'usage européen mais sans écarter ces dernières.</p><p>\n" +
            "Il ne faut pas confondre français québécois et français canadien. En effet, à strictement parler, le français canadien constitue un ensemble qui comprend le français québécois et des français de diverses autres régions et origines. Ainsi, le français acadien et le français terre-neuvien ont des origines différentes du français québécois. Quant au français ontarien, au français du Nouveau-Brunswick et au français du Manitoba4, ils ont les mêmes origines que le français québécois (la population francophone de ces provinces étant historiquement issue d'une colonisation en provenance du Québec) mais celui-ci s'est différencié avec le temps, notamment à la suite de la Révolution tranquille5. Il en va de même du français des petites communautés francophones du New Hampshire et du Vermont, aux États-Unis, également issu du français québécois mais aujourd'hui moribond et fortement teinté de l'anglais. Dans certaines régions limitrophes orientales du Québec (baie des Chaleurs, Basse-Côte-Nord, îles de la Madeleine) c'est le français acadien plutôt que le français québécois qui constitue le parler ancestral, quoique la jeune génération s'aligne de plus en plus sur le parler du reste du Québec6,7. Quant au français parlé au Madawaska, une région séparée entre le Nouveau-Brunswick et le Maine, il serait foncièrement québécois selon certains auteurs, mais selon d'autres, il serait un mélange de français acadien et de français québécois8.\n" +
            "\n" +
            "Par ailleurs, 86,2 % des francophones du Canada vivent au Québec9.</p></body>";

    public static String article1sanshtml = "Les grandes villes :\n\tMontréal est la deuxième ville la plus peuplée du Canada. Elle se situe principalement sur l’île fluviale de Montréal, sur le Fleuve Saint-Laurent (entre Québec et le Lac Ontario) dans le sud de la province du Québec, dont elle est la principale métropole3. " +
            "" +
            "Ville francophone la plus peuplée d'Amérique4, Montréal est considérée comme ayant la deuxième population francophone au monde après ParisNote 1,5,6. En 2016, la ville de comptait 1 704 694 habitants7[réf. incomplète] et son aire urbaine plus de quatre millions, soit environ la moitié de la population du Québec8,9[réf. insuffisante]. Montréal est ainsi la 19e agglomération la plus peuplée d'Amérique du Nord10 et la 122e ville la plus peuplée du monde11. En 2011, environ 50 % de la population de Montréal était de langue maternelle française, 13 % était de langue anglaise et 33 % était d'une autre langue12, ce qui fait d'elle l'une des villes les plus cosmopolites du monde13.\n" +
            "" +
            "Cœur économique du Québec, Montréal demeure le second plus grand centre financier du pays et possède une économie fortement diversifiée14 par le commerce, l’éducation, les technologies de l'information et les industries aérospatiale, pharmaceutique, du tourisme et du cinéma. Classée ville mondiale en 2012, Montréal est la deuxième ville consulaire d'Amérique du Nord, abrite le siège de l'Organisation de l'aviation civile internationale et est le siège de plus de 60 organisations internationales15. De plus, la ville est la première d'Amérique du Nord pour le nombre de congrès internationaux16. En 2017, Montréal est consacrée « meilleure ville étudiante » au monde17 et est considérée comme la métropole universitaire du Canada18.\n" +
            "" +
            "Montréal a accueilli plusieurs événements internationaux d'envergure, dont l'Exposition universelle de 1967 et les Jeux olympiques d'été de 1976. Hôte du grand prix de Formule 1 du Canada, elle accueille annuellement de nombreux festivals, tels le Festival international de jazz de Montréal, les FrancoFolies, et le festival Juste pour rire. Le club de hockey des Canadiens de Montréal y a élu domicile dès sa création en 1909. Québec (prononciation en français [ke.bɛk]) est la capitale nationale du Québec3, une des provinces du Canada. Elle est située dans la région administrative de la Capitale-Nationale. Elle est le siège de nombreuses institutions dont le Parlement du Québec.\n" +
            "" +
            "La ville de Québec compte 531 902 habitants ( Juillet 2016 ) et une communauté métropolitaine de 800 296 ( Juillet 2016 ), faisant d'elle la deuxième ville la plus peuplée du Québec après Montréal. Le nom officiel de la ville est « Québec », bien que l'expression « Ville de Québec » soit souvent employée afin de distinguer la ville de la province. De la même façon, bien que le gentilé officiel soit « Québécois(e) », on va plus couramment employer l'expression « Gens de Québec ».\n" +
            "" +
            "Le rétrécissement du fleuve Saint-Laurent entre les villes de Québec et de Lévis, sur la rive opposée, a donné le nom à la ville, Kébec étant un mot algonquin signifiant « là où le fleuve se rétrécit ». Fondée en 1608 par Samuel de Champlain, Québec est une des plus anciennes villes d'Amérique du Nord. Les remparts font de Québec la seule ville fortifiée au nord du Mexique. Le Vieux-Québec a été déclaré patrimoine mondial en 1985 par l'UNESCO4,5.";

    public static String article2sanshtml = "Le français québécois :\n\tLe français québécois, aussi appelé français du Québec ou simplement québécois, est la variété de la langue française parlée essentiellement par les francophones du Québec3. " +
            "" +
            "Le français écrit du Québec est syntaxiquement identique au français européen et international. Il ne s'en distingue que marginalement sur le plan lexical. Quant au français oral, passablement différent du français écrit, il comporte des écarts syntaxiques et phonétiques parfois prononcés par rapport à la norme. Le québécois connaît des variétés régionales, dont le joual, parler populaire de Montréal (voir Variations régionales).\n" +
            "" +
            "L'Office québécois de la langue française travaille au développement de la langue française et appuie certaines particularités qui peuvent diverger parfois avec l'usage européen mais sans écarter ces dernières. " +
            "Il ne faut pas confondre français québécois et français canadien. En effet, à strictement parler, le français canadien constitue un ensemble qui comprend le français québécois et des français de diverses autres régions et origines. Ainsi, le français acadien et le français terre-neuvien ont des origines différentes du français québécois. Quant au français ontarien, au français du Nouveau-Brunswick et au français du Manitoba4, ils ont les mêmes origines que le français québécois (la population francophone de ces provinces étant historiquement issue d'une colonisation en provenance du Québec) mais celui-ci s'est différencié avec le temps, notamment à la suite de la Révolution tranquille5. Il en va de même du français des petites communautés francophones du New Hampshire et du Vermont, aux États-Unis, également issu du français québécois mais aujourd'hui moribond et fortement teinté de l'anglais. Dans certaines régions limitrophes orientales du Québec (baie des Chaleurs, Basse-Côte-Nord, îles de la Madeleine) c'est le français acadien plutôt que le français québécois qui constitue le parler ancestral, quoique la jeune génération s'aligne de plus en plus sur le parler du reste du Québec6,7. Quant au français parlé au Madawaska, une région séparée entre le Nouveau-Brunswick et le Maine, il serait foncièrement québécois selon certains auteurs, mais selon d'autres, il serait un mélange de français acadien et de français québécois8.\n" +
            "" +
            "Par ailleurs, 86,2 % des francophones du Canada vivent au Québec.";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_articles, container, false);

        populateListView(view);

        return view;
    }


    private void populateListView(View v) {
        SQLiteOpenHelper helper=new DatabaseHandler(v.getContext(), MainActivity.bddName, null, 3);
        Cursor c = helper.getWritableDatabase().rawQuery("select "+DatabaseHandler.ARTICLE_CONTENU_STRING+" from " + DatabaseHandler.ARTICLE_TABLE_NAME+";", null);
        List<String> titres=new ArrayList<String>();
        String debutArticle;
        while(c.moveToNext()){
            debutArticle=c.getString(0);
            if(debutArticle.length()<150){
                titres.add(debutArticle);
            }else{
                titres.add(debutArticle.substring(0, 145)+"...");
            }
        }
        c.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(v.getContext(), R.layout.item, titres);
        list = (ListView) v.findViewById(R.id.listViewArticles);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SQLiteOpenHelper helper=new DatabaseHandler(view.getContext(), MainActivity.bddName, null, 3);
                ArticleActivity.c = helper.getReadableDatabase().rawQuery("select "+DatabaseHandler.ARTICLE_CONTENU_HTML+" from " + DatabaseHandler.ARTICLE_TABLE_NAME+" where "+DatabaseHandler.ARTICLE_KEY+"="+String.valueOf(position+1)+";", null);
                ArticleActivity.c.moveToFirst();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                DetailsFragment newFrag = new DetailsFragment();
                transaction.replace(R.id.frameLayout, newFrag);
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction.commit();
                MainActivity.detail = true;
            }
        });
    }
}
