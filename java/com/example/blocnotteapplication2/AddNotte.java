package com.example.blocnotteapplication2;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddNotte extends AppCompatActivity {
     final String TAG = "AddNotte";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notte);
        final EditText editText = findViewById(R.id.editText);
        Button ajouter = findViewById(R.id.ajouter);
        Button supp = findViewById(R.id.anuler);

        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString();
                if (data == null) data = "champs vide";
                add(data);

            }
        });
        supp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            delete();
            }
        });
    }
    // methode pour button add
    private void add(String donner){
        Date date = new Date();
        Date heure = new Date();
        final String Heure = "heure";
        final String DATE = "date";
        final String DATA = "data_notte";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat simpleHeureFormat = new SimpleDateFormat("HH:mm");
        String result = simpleDateFormat.format(date);
        String resulte = simpleHeureFormat.format(heure);
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra(DATA,donner);
        intent.putExtra(DATE,result);
        intent.putExtra(Heure,resulte);
        Log.d(TAG, "add: data"+ donner+"date "+result);
        Toast.makeText(this,"add: data"+ donner+"date "+result,Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
    // methode pour boutton supp
    private void delete(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
