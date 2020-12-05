package com.example.blocnotteapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AppAdapter extends ArrayAdapter<Notte> {
    ArrayList<Notte> nottes;
    Context context;
    int viewRes;

    public AppAdapter(Context context, int resource, ArrayList<Notte> list) {
        super(context, resource, list);
        this.context = context;
        this.viewRes = resource;
        this.nottes = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        view = convertView;
        if (view == null){
            LayoutInflater v = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = v.inflate(viewRes,parent,false);
        }
        Notte notte = nottes.get(position);
        if (notte != null){
            TextView note = view.findViewById(R.id.donner);
            TextView date = view.findViewById(R.id.datte);
            TextView heure = view.findViewById(R.id.heure);
            if (note != null){note.setText(""+notte.getNottes());}
            if (date != null){date.setText(""+notte.getDattes());}
            if (heure != null){heure.setText(""+notte.getHeure());}
        }
        return view;
    }
}
