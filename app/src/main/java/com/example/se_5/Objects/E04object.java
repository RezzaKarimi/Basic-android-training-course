package com.example.se_5.Objects;

import java.io.Serializable;

public class E04object implements Serializable {
    int Img_Id, Like, View, Comment;
    String Name, Artist, Date;

    public E04object(String Name, String Artist, String Date, int Img_Id, int Like, int View, int Comment ){
        this.Name= Name;
        this.Artist= Artist;
        this.Date= Date;
        this.Img_Id= Img_Id;
        this.Like= Like;
        this.View= View;
        this.Comment= Comment;
    }

    public E04object(){

    }

    public void setImg_Id(int img_Id){Img_Id= img_Id;}
    public int getImg_Id(){return Img_Id;}

    public void setLike(int like){Like= like;}
    public int getLike(){return Like;}

    public void setView(int view){View= view;}
    public int getView(){return View;}

    public void setComment(int comment){Comment= comment;}
    public int getComment(){return Comment;}

    public void setName(String name){Name= name;}
    public String getName(){return Name;}

    public void setArtist(String artist){Artist= artist;}
    public String getArtist(){return Artist;}

    public void setDate(String date){Date= date;}
    public String getDate(){return Date;}
}
