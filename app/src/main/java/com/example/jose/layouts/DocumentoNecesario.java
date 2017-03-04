package com.example.jose.layouts;

import java.util.ArrayList;

/**
 * Created by Jose on 04/03/2017.
 */

public class DocumentoNecesario {
    private String documentacion;
    private int  imagenes;

    public String getDocumentacion() {
        return documentacion;
    }

    public void setDocumentacion(String documentacion) {
        this.documentacion = documentacion;
    }

    public int getImagenes() {
        return imagenes;
    }

    public void setImagenes(int imagenes) {
        this.imagenes = imagenes;
    }

    public DocumentoNecesario(String documentacion, int imagenes) {

        this.documentacion = documentacion;
        this.imagenes = imagenes;
    }
}
