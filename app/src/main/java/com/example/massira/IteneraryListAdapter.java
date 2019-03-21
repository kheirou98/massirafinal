package com.example.massira;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;


public class IteneraryListAdapter extends BaseAdapter {
    private Context mContext;
    BddHelper controldb;
    SQLiteDatabase db;

    private ArrayList<String> Id = new ArrayList<String>();
    private ArrayList<String> date = new ArrayList<String>();
    private ArrayList<String> name = new ArrayList<String>();
    private ArrayList<String> temps = new ArrayList<String>();

    public IteneraryListAdapter(Context  context,ArrayList<String> Id,ArrayList<String> date, ArrayList<String> name,ArrayList<String> temps
    )
    {
        this.mContext = context;
        this.Id = Id;
        this.date = date;
        this.name = name;
        this.temps=temps ;
    }



    @Override
    public int getCount() {
        return Id.size();
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final    ViewHolder holder;
        controldb =new BddHelper(mContext);
        LayoutInflater layoutInflater;
        if (convertView == null) {
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.liste_item, null);
            holder = new ViewHolder();
            holder.id = (TextView) convertView.findViewById(R.id.tv);
            holder.date = (TextView) convertView.findViewById(R.id.tv2);
            holder.name = (TextView) convertView.findViewById(R.id.tv3);
            holder.temps = (TextView) convertView.findViewById(R.id.tv4);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.id.setText(Id.get(position));
        holder.date.setText(date.get(position));
        holder.name.setText(name.get(position));
        holder.temps.setText(temps.get(position));
        return convertView;
    }

    /**
     * This method is to scale down the image
     */

    public class ViewHolder {
        TextView id;
        TextView date;
        TextView name;
        TextView temps;
    }
}
