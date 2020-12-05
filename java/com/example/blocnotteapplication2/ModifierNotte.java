package com.example.blocnotteapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ModifierNotte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_notte);
        final EditText editText = findViewById(R.id.editText);
        Button ajouter = findViewById(R.id.maj);
        Button supp = findViewById(R.id.retourn);
        final String Heure = "heure";
        final String DATE = "date";
        final String DATA = "data_notte";
        String date_extra = "";
        String heure_extra = "";
        String data_extra = "";
        Intent intent = getIntent();
        if (intent != null){
            data_extra = intent.getStringExtra(DATA);
            date_extra = intent.getStringExtra(DATE);
            heure_extra= intent.getStringExtra(Heure);
            editText.setText(data_extra);
            Toast.makeText(ModifierNotte.this,"donner: "+data_extra+" date: "+data_extra+" heure: "+heure_extra
                    ,Toast.LENGTH_LONG).show();
        }
        final String data = editText.getText().toString();
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String donner = editText.getText().toString();
                Date date = new Date();
                Date heure = new Date();
                final String Heure = "heure";
                final String DATE = "date";
                final String DATA = "data_notte";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat simpleHeureFormat = new SimpleDateFormat("HH:mm");
                String result = simpleDateFormat.format(date);
                String resulte = simpleHeureFormat.format(heure);
                Intent intent = new Intent(ModifierNotte.this,MainActivity.class);
                intent.putExtra(DATA,donner);
                intent.putExtra(DATE,result);
                intent.putExtra(Heure,resulte);
                startActivity(intent);
                
            }
        });
        final String finalData_extra = data_extra;
        final String finalHeure_extra = heure_extra;
        final String finalDate_extra = date_extra;
        supp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Intent intent = new Intent(ModifierNotte.this,MainActivity.class);
        intent.putExtra(DATA, finalData_extra);
        intent.putExtra(Heure, finalHeure_extra);
        intent.putExtra(DATE, finalDate_extra);
        startActivity(intent);
            }
        });

    }

}
