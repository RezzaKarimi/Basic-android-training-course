package com.example.se_5.Objects;

public class E02object {

    private String name;
    private int img;
    private String description;


    public E02object(String name, int img, String description){
        this.name       = name;
        this.img        = img;
        this.description= description;
    }

    public E02object(){

    }

    public void setName(String name){
        this.name= name;
    }
    public String getName(){
        return name;
    }

    public void setImg(int img){
        this.img= img;
    }
    public int getImg(){
        return img;
    }

    public void setDescription(String description){
        this.description= description;
    }
    public String getDescription(){
        return description;
    }

}
