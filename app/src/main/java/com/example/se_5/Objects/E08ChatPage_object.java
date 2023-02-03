package com.example.se_5.Objects;

public class E08ChatPage_object {

    String message;
    String date;
    Boolean me;
    Boolean seen;
    int type;

    public static final int TYPE_MESSAGE = 0;
    public static final int TYPE_DATE    =1;

    public E08ChatPage_object(String message){
        this.message = message;
    }

    public E08ChatPage_object(){

    }

    public void setMessage (String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

    public void setDate (String date){
        this.date = date;
    }

    public String getDate(){
        return this.date;
    }

    public void setMe (Boolean me){
        this.me = me;
    }

    public Boolean getMe(){
        return this.me;
    }

    public void setSeen (Boolean seen){
        this.seen = seen;
    }

    public Boolean getSeen(){
        return this.seen;
    }

    public void setType (int type){
        this.type = type;
    }

    public int getType(){
        return this.type;
    }



    }
