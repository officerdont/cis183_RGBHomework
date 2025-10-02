package com.example.cis183_rgbhomework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorDataAdapter extends BaseAdapter
{
    Context context;
    ArrayList<ColorData> listofcolors;

    public ColorDataAdapter(Context c, ArrayList<ColorData> ls)
    {
      context = c;
      listofcolors = ls;
    }
    @Override
    public int getCount() {
        return listofcolors.size();

    }

    @Override
    public Object getItem(int position) {
        return listofcolors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

       if(view == null)
       {
           LayoutInflater mInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);


       }
        TextView red = view.findViewById(R.id.tv_v_cell_red);
        TextView green = view.findViewById(R.id.tv_v_cell_green);
        TextView blue = view.findViewById(R.id.tv_v_cell_blue);
        TextView hexa = view.findViewById(R.id.tv_v_cell_hexa);

        ColorData color = listofcolors.get(position);
        red.setText(Integer.toString(color.getRed()));
        blue.setText(Integer.toString(color.getBlue()));
        green.setText(Integer.toString(color.getGreen()));
        hexa.setText(color.getHexadecimal());


        return view;


    }
}
