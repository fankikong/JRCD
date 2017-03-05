package com.example.jose.layouts;

import java.util.ArrayList;

/**
 * Created by Dani on 05/03/2017.
 */

public class BaseDeDatos {
    private static ArrayList<Formularios> forms = new ArrayList<>();
    private static ArrayList<DocumentoNecesario> docs = new ArrayList<>();
    private BaseDeDatos db = new BaseDeDatos();

    private BaseDeDatos() {
        //TODO: cambiar iconos
        ArrayList<DocumentoNecesario> necesario = new ArrayList<>();
        necesario.add(new DocumentoNecesario("DNI", R.drawable.ic_explore_black_24dp));
        necesario.add(new DocumentoNecesario("Cuenta Bancaria", R.drawable.ic_explore_black_24dp));
        Formularios a = new Formularios("Transferencia", necesario, R.drawable.ic_explore_black_24dp);
        forms.add(a);
        ArrayList<DocumentoNecesario> necesarioo = new ArrayList<>();
        necesarioo.add(new DocumentoNecesario("DNI", R.drawable.ic_explore_black_24dp));
        necesarioo.add(new DocumentoNecesario("Cuenta Bancaria",R.drawable.ic_explore_black_24dp));
        necesarioo.add(new DocumentoNecesario("Pasaporte", R.drawable.ic_explore_black_24dp));
        necesarioo.add(new DocumentoNecesario("Abal", R.drawable.ic_explore_black_24dp));
        a=new Formularios("Cobrar Cheque", necesarioo, R.drawable.ic_explore_black_24dp);
        forms.add(a);
    }
    public static ArrayList<Formularios> getForms() {
        return forms;
    }

    public static ArrayList<DocumentoNecesario> getDocs() {
        return docs;
    }
}
