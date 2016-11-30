package com.example.pol.s5.com.spinner.sesiones;

/**
 * Created by alexbruch on 16/11/16.
 */


/**
 * OBJETO LISTA PARA LOS DIFERENTES EJERCICIOS
 */

public class ListaSpinner {
    private String id;
    private String text;

    public ListaSpinner(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof ListaSpinner) {
            ListaSpinner lista = (ListaSpinner)o;
            if (lista.getText().equals(text)&& lista.getId()==id) return true;
        }
        return false;
    }

}
