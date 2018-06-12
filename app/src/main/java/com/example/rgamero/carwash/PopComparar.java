package com.example.rgamero.carwash;

import android.app.Activity;

class PopComparar extends Activity{
    private String contenido;

    public PopComparar(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getId(){
        return contenido.hashCode();
    }
    public static PopComparar[] ITEMS = {
            new PopComparar("uno"),
            new PopComparar("dos"),
            new PopComparar("tres"),
            new PopComparar("cuatro")
    };

    public static PopComparar getItem(int id){
        for (PopComparar item : ITEMS){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }
}
