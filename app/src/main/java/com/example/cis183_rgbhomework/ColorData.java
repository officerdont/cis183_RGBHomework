package com.example.cis183_rgbhomework;

import java.io.Serializable;

public class ColorData implements Serializable
{
    private   int red;
    private int green;
   private int blue;
   private String hexadecimal;

   public ColorData()
   {

   }
   public ColorData(int r, int g,int b,String h)
   {
     red = r;
     green = g;
     blue = b;
     hexadecimal = h;
   }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public String getHexadecimal() {
        return hexadecimal;
    }

    public void setHexadecimal(String hexadecimal) {
        this.hexadecimal = hexadecimal;
    }

}
