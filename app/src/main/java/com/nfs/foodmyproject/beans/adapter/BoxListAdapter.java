package com.nfs.foodmyproject.beans.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nfs.foodmyproject.R;
import com.nfs.foodmyproject.beans.Box;

import java.util.ArrayList;
import java.util.List;

public class BoxListAdapter extends BaseAdapter {

    private Context context; //context
    private ArrayList<Box> items; //data source of the list adapter

    //public constructor
    public BoxListAdapter(Context context, ArrayList<Box> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.box, parent, false);
        }

        // get current item to be displayed
        Box currentItem = (Box) getItem(position);

        // get the TextView for item name and item description
        TextView textViewItemName = (TextView)
                convertView.findViewById(R.id.TitleTextView);
        TextView textViewItemDescription = (TextView)
                convertView.findViewById(R.id.DescriptionTextView);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        ProgressBar progressBar = (ProgressBar) convertView.findViewById(R.id.progressBar);

        //sets the text for item name and item description from the current item object
        textViewItemName.setText(currentItem.getTitle());
        textViewItemDescription.setText(currentItem.getDescription());
//        imageView.setImageResource(currentItem.getImage());
        progressBar.setProgress(currentItem.getPercentage());

        // returns the view for the current row
        return convertView;
    }
}
