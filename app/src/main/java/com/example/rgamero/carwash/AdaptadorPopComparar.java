package com.example.rgamero.carwash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorPopComparar extends BaseAdapter{
    private Context context;

    public AdaptadorPopComparar(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return PopComparar.ITEMS.length;
    }

    @Override
    public PopComparar getItem(int position) {
        return PopComparar.ITEMS[position];
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item, viewGroup, false);
        }
        TextView nombreCoche = (TextView) view.findViewById(R.id.nombre_coche);

        final PopComparar item = getItem(position);
        nombreCoche.setText(item.getContenido());

        return view;
    }
}
