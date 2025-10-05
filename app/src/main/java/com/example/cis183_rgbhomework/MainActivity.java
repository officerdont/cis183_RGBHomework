package com.example.cis183_rgbhomework;

import static android.graphics.Color.rgb;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.slider.RangeSlider;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ColorDataAdapter.OnColorCellClickListener {

    ListView lv_j_ListOfColors;
    private ArrayList<ColorData> ListOfColors;
    private ColorDataAdapter clAdapter;
    TextView tv_j_red;
    TextView tv_j_green;
    TextView tv_j_blue;
    SeekBar sb_j_red;
    SeekBar sb_j_green;
    SeekBar sb_j_blue;
    Button btn_j_addcolor;
    TextView tv_j_hexa;
    ConstraintLayout main;

    TextView tv_j_hexatext;
    TextView tv_j_red3;
    TextView tv_j_green2;
    TextView tv_j_blue2;

   // ConstraintLayout Main2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lv_j_ListOfColors = findViewById(R.id.lv_v_listofcolors);
        tv_j_red = findViewById(R.id.tv_v_red);
        tv_j_green = findViewById(R.id.tv_v_green);
        tv_j_blue = findViewById(R.id.tv_v_blue);
        sb_j_red = findViewById(R.id.sb_v_red);
        sb_j_green = findViewById(R.id.sb_v_green);
        sb_j_blue = findViewById(R.id.sb_v_blue);
        btn_j_addcolor = findViewById(R.id.btn_v_addcolor);
        main = findViewById(R.id.main);
        tv_j_hexa = findViewById(R.id.tv_v_hexa);
        tv_j_hexatext = findViewById(R.id.tv_v_hexatext);
        tv_j_red3 = findViewById(R.id.tv_v_red3);
        tv_j_green2 = findViewById(R.id.tv_v_green2);
        tv_j_blue2 = findViewById(R.id.tv_v_blue2);

       // Main2 = findViewById(R.id.Main2);



        ListOfColors = new ArrayList<>();
        ColorData color = new ColorData();
        clAdapter = new ColorDataAdapter(this, ListOfColors);
        lv_j_ListOfColors.setAdapter(clAdapter);



       color.setRed(7);
       color.setGreen(7);
       color.setBlue(7);
       color.setHexadecimal("7777");
       ListOfColors.add(color);

       filllistview();
       onseekbarchangelistner();
       onButtonClickListner();


    }
    public void onColorCellClick(ColorData color)
    {
        sb_j_red.setProgress(color.getRed());
        tv_j_red.setText(Integer.toString(color.getRed()));
        sb_j_green.setProgress(color.getGreen());
        tv_j_green.setText(Integer.toString(color.getGreen()));
        sb_j_blue.setProgress(color.getBlue());
        tv_j_blue.setText(Integer.toString(color.getBlue()));
        main.setBackgroundColor(rgb(color.getRed(),color.getGreen(),color.getBlue()));


    }

    private void filllistview()
    {
        clAdapter = new ColorDataAdapter(this, ListOfColors);
        lv_j_ListOfColors.setAdapter(clAdapter);
    }
    private void onseekbarchangelistner()
    {
        sb_j_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               tv_j_red.setText(Integer.toString(progress));
               BackroundChange();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb_j_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_j_green.setText(Integer.toString(progress));
                BackroundChange();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb_j_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_j_blue.setText(Integer.toString(progress));
                BackroundChange();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    private void onButtonClickListner()
    {
        btn_j_addcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addcolor();
            }
        });
    }
    private void BackroundChange()
    {
        int r = Integer.parseInt(tv_j_red.getText().toString());
        int g = Integer.parseInt(tv_j_green.getText().toString());
        int b =Integer.parseInt(tv_j_blue.getText().toString());
        main.setBackgroundColor(rgb(r,g,b));
        String h = String.format("#%02x%02x%02x",r,g,b);
        tv_j_hexa.setText(h);

        if (androidx.core.graphics.ColorUtils.calculateLuminance(rgb(r,g,b)) < 0.5)
        {
            // Background is dark, set text to white
            tv_j_red.setTextColor(Color.WHITE);
            tv_j_green.setTextColor(Color.WHITE);
            tv_j_blue.setTextColor(Color.WHITE);
            tv_j_hexa.setTextColor(Color.WHITE);
            tv_j_red3.setTextColor(Color.WHITE);
            tv_j_green2.setTextColor(Color.WHITE);
            tv_j_blue2.setTextColor(Color.WHITE);
            tv_j_hexatext.setTextColor(Color.WHITE);

        }
        else
        {
            // Background is light, set text to black
            tv_j_red.setTextColor(Color.BLACK);
            tv_j_green.setTextColor(Color.BLACK);
            tv_j_blue.setTextColor(Color.BLACK);
            tv_j_hexa.setTextColor(Color.BLACK);
            tv_j_red3.setTextColor(Color.BLACK);
            tv_j_green2.setTextColor(Color.BLACK);
            tv_j_blue2.setTextColor(Color.BLACK);
            tv_j_hexatext.setTextColor(Color.BLACK);

        }

       // ColorData newcolor = new ColorData(r,g,b,h);
      //  ListOfColors.add(newcolor);
      //  filllistview();

    }
    private void addcolor()
    {
        int r = Integer.parseInt(tv_j_red.getText().toString());
        int g = Integer.parseInt(tv_j_green.getText().toString());
        int b =Integer.parseInt(tv_j_blue.getText().toString());

        main.setBackgroundColor(rgb(r,g,b));

        String h = String.format("#%02x%02x%02x",r,g,b);

        ColorData newcolor = new ColorData(r,g,b,h);
        ListOfColors.add(newcolor);

        filllistview();
    }


}