package com.example.se_5.Objects;

public class E01object {

    private int drawable;
    private String name;

    public E01object(int drawable, String name){
        this.drawable= drawable;
        this.name= name;
    }

    public E01object(){

    }



    public void setDrawable(int drawable){
        this.drawable= drawable;
    }

    public int getDrawable(){
    return this.drawable;
    }

    public void setName(String name){
        this.name= name;
    }

    public String getName(){
        return name;
    }


}
