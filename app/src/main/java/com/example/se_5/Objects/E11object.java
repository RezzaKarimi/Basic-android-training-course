package com.example.se_5.Objects;

import android.graphics.Color;

import androidx.annotation.ColorRes;

import com.example.se_5.app.Application;

import java.io.Serializable;

public class E11object implements Serializable {

    String title;
    int img_res , color;

    public E11object(String title , int img , int color){

        this.title   = title;
        this.img_res = img;
        this.color   = color;

    }
    public E11object(){

    }




    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }




    public void setImg_res(int img_res){
        this.img_res = img_res;
    }
    public int getImg_res(){
        return this.img_res;
    }




    public void setColor(int color){
        this.color = color;
    }

    public void setColor(String color){
        this.color = Color.parseColor(color);
    }

    public void setColor(int Red,int Green,int Blue){
        this.color = Color.rgb (Red, Green, Blue);
    }

    public int getColor(){
        return this.color;
    }

}
