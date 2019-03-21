package com.example.massira;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class popup extends DialogFragment implements View.OnClickListener {
    View view;
    EditText et;
    Button bsearch;
    Button bcancel;
    TextView tvresult;
    EditText desc;
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceCreate) {
    view=inflater.inflate(R.layout.popup,container,false);
        et=view.findViewById(R.id.etname);
        bsearch= view.findViewById(R.id.recherche);
        bcancel= view.findViewById(R.id.quitter);
        tvresult = view.findViewById(R.id.tvresultat);
        getDialog().setTitle("Veuillez entrer la description svp!");
        bsearch.setOnClickListener(this);
        bcancel.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View view) {

        Button bu =(Button) view;
        if (bu.getText().toString().equals("OK")){
            if (et.getText().toString().equals("")){
                Toast.makeText(getContext(),"Veuillez remplir le champs de la description",Toast.LENGTH_LONG).show();
            }
            else {
                AjoutManifestation.desc.setText(et.getText().toString());
                this.dismiss();
                FragmentTransaction manager =getFragmentManager().beginTransaction();
                popupgps popupgpsclass= new popupgps();
                popupgpsclass.show(manager,null);
            }
            this.dismiss();
        }
        else {
            this.dismiss();
            FragmentTransaction manager =getFragmentManager().beginTransaction();
            popupgps popupgpsclass= new popupgps();
            popupgpsclass.show(manager,null);
        }

    }

}
