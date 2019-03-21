package com.example.massira;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BddHelper  controllerdb = new BddHelper(this);
    SQLiteDatabase db;
    private ArrayList<String> Id = new ArrayList<String>();
    private ArrayList<String> date = new ArrayList<String>();
    private ArrayList<String> name = new ArrayList<String>();
    private ArrayList<String> temps = new ArrayList<String>();
    ListView lv;
    IteneraryListAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         lv=findViewById(R.id.listview);


        }
    protected void onResume() {
        displayData();
        super.onResume();
    }
    private void displayData() {
        db = controllerdb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM  MANIF",null);
        Id.clear();
        date.clear();
        name.clear();
        temps.clear();
        if (cursor.moveToFirst()) {
            do {
                Id.add(cursor.getString(cursor.getColumnIndex("Uid")));
                date.add(cursor.getString(cursor.getColumnIndex("created_at")));
                name.add(cursor.getString(cursor.getColumnIndex("description")));
                temps.add(cursor.getString(cursor.getColumnIndex("created_at")));
            } while (cursor.moveToNext());
        }
        IteneraryListAdapter ca = new IteneraryListAdapter(MainActivity.this,Id, date,name,temps);
        lv.setAdapter(ca);
        //code to set adapter to populate list
        cursor.close();
    }

    public void buClick(View view) {
        Intent intent=new Intent(this,AjoutManifestation.class);
        startActivity(intent);
    }


}
