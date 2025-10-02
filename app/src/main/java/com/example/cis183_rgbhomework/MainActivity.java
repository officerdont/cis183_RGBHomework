package com.example.cis183_rgbhomework;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv_j_ListOfColors;
    private ArrayList<ColorData> ListOfColors;
    ColorDataAdapter clAdapter;
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
        ColorData color = new ColorData();
        ArrayList<ColorData> ListOfColors = new ArrayList<>();
        ListOfColors = new ArrayList<>();

       color.setRed(7);
       color.setGreen(7);
       color.setBlue(7);
       color.setHexadecimal("7777");
       ListOfColors.add(color);
     filllistview();


    }
    private void filllistview()
    {
        clAdapter = new ColorDataAdapter(this, ListOfColors );
        lv_j_ListOfColors.setAdapter(clAdapter);
    }
}