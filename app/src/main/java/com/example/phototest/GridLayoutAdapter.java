package com.example.phototest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GridLayoutAdapter extends BaseAdapter {

    private final Context context;
    private final int[] values;
    LayoutInflater inflater;

    public GridLayoutAdapter(Context context, int[] resources) {
        this.context = context;
        this.values = resources;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int i) {
        return values[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_gridlayout, null);
        ImageView icon = (ImageView) convertView.findViewById(R.id.item_img);
        icon.setImageResource(values[position]);
        return convertView;
    }
}
