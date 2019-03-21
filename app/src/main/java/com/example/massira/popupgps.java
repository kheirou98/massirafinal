package com.example.massira;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class popupgps extends DialogFragment implements View.OnClickListener {

        View view;
        EditText et;
        Button buok;
        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceCreate) {
            view=inflater.inflate(R.layout.popupgps,container,false);
            et=view.findViewById(R.id.etname);
            buok= view.findViewById(R.id.ok);
            getDialog().setTitle("Veuillez entrer le lieu dans la carte!");
            buok.setOnClickListener(this);
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
                    AjoutManifestation.gps.setText(et.getText().toString());
                    this.dismiss();
                }
            }

        }

}

