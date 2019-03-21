package com.example.massira;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import static java.security.AccessController.getContext;

public class AjoutManifestation extends AppCompatActivity {
   static EditText desc;
   static EditText gps;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_manifestation);
        gps=findViewById(R.id.etgps);
        desc=findViewById(R.id.etdescription);
        Button ok = findViewById(R.id.button2);

        final EditText mDisplayDate = findViewById(R.id.etdate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        AjoutManifestation.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                EditText datemanife=findViewById(R.id.etdate);
                String date = day + "/" + month + "/" + year;
                datemanife.setText(date);
                if(! datemanife.getText().toString().equals("")){
                    FragmentTransaction manager =getSupportFragmentManager().beginTransaction();
                    popup popupclass= new popup();
                    popupclass.show(manager,null);

                }

            }
        };

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDisplayDate.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "veuillez remplir les champs d'abord!", Toast.LENGTH_LONG).show();
                } else {
                    String name= "manif1";String description=desc.getText().toString(); String created_at=mDisplayDate.getText().toString();
                    String updated_at="";String gpsr=gps.getText().toString() ;int Userid =1 ;
                    final BddHelper db = new BddHelper(getBaseContext()) ;
                    db.addItenerary(name,description,created_at,updated_at,gpsr,Userid);
                    db.close();
                    Toast.makeText(getApplicationContext(),"Manssira ajoutée avec succès!",Toast.LENGTH_LONG).show();
                }
            }
        });;
    }

}
