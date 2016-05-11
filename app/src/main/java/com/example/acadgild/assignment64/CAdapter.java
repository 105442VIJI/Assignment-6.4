package com.example.acadgild.assignment64;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Vijailakshmi on 11-05-2016.
 */
public class CAdapter extends ArrayAdapter<String>{

    Activity context;
    String[] names;
    String[] numbers;

    public CAdapter(Activity context, String[] names, String[] numbers)
    {
        super(context, R.layout.list_item,names);

        this.context=context;
        this.names=names;
        this.numbers=numbers;

    }


    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater =context.getLayoutInflater();
        View v = inflater.inflate(R.layout.list_item, null, true);

        TextView listnames = (TextView)v.findViewById(R.id.name);
        TextView listnumbers = (TextView)v.findViewById(R.id.phone_number);

        listnames.setText(names[position]);
        listnumbers.setText(numbers[position]);

        return v;

    }




}
