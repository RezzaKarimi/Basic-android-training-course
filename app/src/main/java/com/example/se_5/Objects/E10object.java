package com.example.se_5.Objects;

public class E10object {

    String name , tel;

    public E10object(String name , String tel){
        this.name = name;
        this.tel  = tel ;
    }
    public E10object(){

    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setTel(String tel){
        this.tel = tel;
    }
    public String getTel(){
        return this.tel;
    }
}
