package com.nfs.foodmyproject.beans.adapter;

import android.content.Context;
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

import java.util.List;

public class BoxListAdapter extends BaseAdapter {

    private static String logTag = "BOX ADAPTER";

    private List<Box> boxes;
    private LayoutInflater layoutInflater;
    private Context context;

    public BoxListAdapter(Context context, List<Box> boxes) {
        this.boxes = boxes;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return boxes.size();
    }

    @Override
    public Object getItem(int position) {
        return boxes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.box, null);
            holder = new ViewHolder();
            holder.titleView = (TextView) convertView.findViewById(R.id.TitleTextView);
            holder.descriptionView = (TextView) convertView.findViewById(R.id.DescriptionTextView);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            holder.progressBar = (ProgressBar) convertView.findViewById(R.id.progressBar);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Box box = boxes.get(position);
        holder.titleView.setText(box.getTitle());
        holder.descriptionView.setText(box.getDescription());
//        holder.imageView.setImageResource(box.getImage());
        holder.progressBar.setProgress(box.getPercentage());
        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        ProgressBar progressBar;
        TextView titleView;
        TextView descriptionView;
    }

}
