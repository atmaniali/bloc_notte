package com.example.blocnotteapplication2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<Notte> mList = new ArrayList<>();
        final ListView lists = findViewById(R.id.malist);
        final String Heure = "heure";
        final String DATE = "date";
        final String DATA = "data_notte";
        final String POSITION = "position";
        int position;
        @SuppressLint("WrongViewCast")
        FloatingActionButton ajouterNote = findViewById(R.id.addFloant);
        //initialisation(mList);
        final AppAdapter adapter = new AppAdapter(this,R.layout.list_of_notte,mList);
        lists.setAdapter(adapter);
        ajouterNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            addActivity();
            }
        });
        lists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Notte selectedItem = adapter.getItem(position);
                Intent intent = new Intent(MainActivity.this,ModifierNotte.class);
                intent.putExtra(DATA,selectedItem.getNottes());
                intent.putExtra(Heure,selectedItem.getHeure());
                intent.putExtra(DATE,selectedItem.getDattes());
                //adapter.remove(selectedItem);
                startActivity(intent);
                mList.remove(selectedItem);
            }
        });
        Intent intent = getIntent();
        if (intent != null){
            Notte notte = new Notte();
            notte.setDattes(intent.getStringExtra(DATE));
            notte.setHeure(intent.getStringExtra(Heure));
            notte.setNottes(intent.getStringExtra(DATA));

            if (notte.getNottes() != null){
            mList.add(notte);
            //Toast.makeText(MainActivity.this,""+notte.getNottes(),Toast.LENGTH_LONG).show();
            initialisation(mList);}
            else{
            if (notte.getNottes()==null){
                initialisation(mList);
            }}
        }
    }
//   methode pour initialiser les vues d'une ListView
    private void initialisation(ArrayList<Notte> nottes){
        Notte notte = new Notte();
        notte.setNottes("je vaulais creer ma first nottes");
        notte.setDattes("23/10/2020");
        notte.setHeure("14:23");
        nottes.add(notte);

        Notte notte1 = new Notte();
        notte1.setNottes("je vaulais creer ma secand nottes");
        notte1.setDattes("22/10/2020");
        notte1.setHeure("16:23");
        nottes.add(notte1);

        Notte notte2 = new Notte();
        notte2.setNottes("je vaulais creer ma trodieme nottes");
        notte2.setDattes("23/10/2020");
        notte2.setHeure("10:20");
        nottes.add(notte2);

        Notte notte3 = new Notte();
        notte3.setNottes("je vaulais creer ma quatrieme nottes");
        notte3.setDattes("20/10/2020");
        notte3.setHeure("18:23");
        nottes.add(notte3);
    }

    //methode pour en Go to addActivity
    private void addActivity(){
        Intent intent = new Intent(this,AddNotte.class);
        startActivity(intent);
    }
    //methde por modifier notte
    private void modifier(){

    }
}
