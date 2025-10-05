package com.example.cis183_rgbhomework;

import static android.graphics.Color.parseColor;
import static android.graphics.Color.rgb;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class ColorDataAdapter extends BaseAdapter
{
    public interface OnColorCellClickListener
    {
        void onColorCellClick(ColorData color);
    }
    Context context;
    ArrayList<ColorData> listofcolors;
    private OnColorCellClickListener clicklistener;


    public ColorDataAdapter(Context c, ArrayList<ColorData> ls)
    {
      context = c;
      listofcolors = ls;
        if (c instanceof OnColorCellClickListener) {
            this.clicklistener = (OnColorCellClickListener) c;
        } else {
            throw new RuntimeException(c.toString() + " must implement OnColorCellClickListener");
        }

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
           view = mInflater.inflate(R.layout.color_cell, null);


       }
        TextView red = view.findViewById(R.id.tv_v_cell_red);
       TextView red2 = view.findViewById(R.id.tv_red);
        TextView green = view.findViewById(R.id.tv_v_cell_green);
        TextView green2 = view.findViewById(R.id.tv_green);
        TextView blue = view.findViewById(R.id.tv_v_cell_blue);
        TextView blue2 = view.findViewById(R.id.tv_blue);
        TextView hexa = view.findViewById(R.id.tv_v_cell_hexa);
        TextView hexa2 = view.findViewById(R.id.tv_hexa);
        FrameLayout fl = view.findViewById(R.id.fl_v_cell_container);
        ConstraintLayout Main2 = view.findViewById(R.id.main);

        ColorData color = listofcolors.get(position);
        red.setText(Integer.toString(color.getRed()));
        blue.setText(Integer.toString(color.getBlue()));
        green.setText(Integer.toString(color.getGreen()));
        int backgroundColor = rgb(color.getRed(),color.getGreen(),color.getBlue());
        fl.setBackgroundColor(rgb(color.getRed(),color.getGreen(),color.getBlue()));
        hexa.setText(color.getHexadecimal());

        if (androidx.core.graphics.ColorUtils.calculateLuminance(backgroundColor) < 0.5) {
            // Background is dark, set text to white
            red.setTextColor(Color.WHITE);
            green.setTextColor(Color.WHITE);
            blue.setTextColor(Color.WHITE);
            hexa.setTextColor(Color.WHITE);
            red2.setTextColor(Color.WHITE);
            green2.setTextColor(Color.WHITE);
            blue2.setTextColor(Color.WHITE);
            hexa2.setTextColor(Color.WHITE);

        } else {
            // Background is light, set text to black (or your default color)
            red.setTextColor(Color.BLACK);
            green.setTextColor(Color.BLACK);
            blue.setTextColor(Color.BLACK);
            hexa.setTextColor(Color.BLACK);
            red2.setTextColor(Color.BLACK);
            green2.setTextColor(Color.BLACK);
            blue2.setTextColor(Color.BLACK);
            hexa2.setTextColor(Color.BLACK);
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicklistener.onColorCellClick(color);
            }
        });




        return view;


    }
}
