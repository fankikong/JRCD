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
        ArrayList<DocumentoNecesario> prestamos = new ArrayList<>();
        if(prestamos.isEmpty()) {
            prestamos.add(new DocumentoNecesario("DNI", R.drawable.ic_documentonecesario));
            prestamos.add(new DocumentoNecesario("Declaración de la renta", R.drawable.ic_documentonecesario));
            prestamos.add(new DocumentoNecesario("Nomina", R.drawable.ic_documentonecesario));
            prestamos.add(new DocumentoNecesario("Declaración de Bienes", R.drawable.ic_documentonecesario));
            prestamos.add(new DocumentoNecesario("Declaración Trimestral", R.drawable.ic_documentonecesario));
            prestamos.add(new DocumentoNecesario("Avales", R.drawable.ic_documentonecesario));
        }

        ArrayList<DocumentoNecesario> hipoteca = new ArrayList<>();
        if(hipoteca.isEmpty()) {
            hipoteca.add(new DocumentoNecesario("DNI", R.drawable.ic_documentonecesario));
            hipoteca.add(new DocumentoNecesario("Declaración de la renta", R.drawable.ic_documentonecesario));
            hipoteca.add(new DocumentoNecesario("Nomina", R.drawable.ic_documentonecesario));
            hipoteca.add(new DocumentoNecesario("Declaración de Bienes", R.drawable.ic_documentonecesario));
            hipoteca.add(new DocumentoNecesario("Declaración Trimestral", R.drawable.ic_documentonecesario));
            hipoteca.add(new DocumentoNecesario("Avales", R.drawable.ic_documentonecesario));
        }

        ArrayList<DocumentoNecesario> pension = new ArrayList<>();
        if(pension.isEmpty()) {
            pension.add(new DocumentoNecesario("DNI", R.drawable.ic_documentonecesario));
            pension.add(new DocumentoNecesario("Declaración de la renta", R.drawable.ic_documentonecesario));
            pension.add(new DocumentoNecesario("Nomina", R.drawable.ic_documentonecesario));
        }

        ArrayList<DocumentoNecesario> apertura = new ArrayList<>();
        if(apertura.isEmpty()) {
            apertura.add(new DocumentoNecesario("DNI", R.drawable.ic_documentonecesario));
            apertura.add(new DocumentoNecesario("Nomina", R.drawable.ic_documentonecesario));
            apertura.add(new DocumentoNecesario("IRPF", R.drawable.ic_documentonecesario));
        }

        ArrayList<DocumentoNecesario> cierre = new ArrayList<>();
        if(cierre.isEmpty()) {
            cierre.add(new DocumentoNecesario("DNI", R.drawable.ic_documentonecesario));
            cierre.add(new DocumentoNecesario("Nomina", R.drawable.ic_documentonecesario));
            cierre.add(new DocumentoNecesario("IRPF", R.drawable.ic_documentonecesario));
        }

        ArrayList<DocumentoNecesario> transferencia = new ArrayList<>();
        if(transferencia.isEmpty()) {
            transferencia.add(new DocumentoNecesario("DNI", R.drawable.ic_documentonecesario));
            transferencia.add(new DocumentoNecesario("Nomina", R.drawable.ic_documentonecesario));
        }

        ArrayList<DocumentoNecesario> tarjeta = new ArrayList<>();
        if(tarjeta.isEmpty()){
            tarjeta.add(new DocumentoNecesario("DNI", R.drawable.ic_documentonecesario));
            tarjeta.add(new DocumentoNecesario("Nomina", R.drawable.ic_documentonecesario));
        }

        ArrayList<DocumentoNecesario> pin = new ArrayList<>();
        if(pin.isEmpty()) {
            pin.add(new DocumentoNecesario("DNI", R.drawable.ic_documentonecesario));
            pin.add(new DocumentoNecesario("Tarjeta", R.drawable.ic_documentonecesario));
        }

        ArrayList<DocumentoNecesario> fijo = new ArrayList<>();
        if(fijo.isEmpty()) {
            fijo.add(new DocumentoNecesario("DNI", R.drawable.ic_documentonecesario));
            fijo.add(new DocumentoNecesario("Nomina", R.drawable.ic_documentonecesario));
            fijo.add(new DocumentoNecesario("Tasas", R.drawable.ic_documentonecesario));
        }

        ArrayList<DocumentoNecesario> seguros = new ArrayList<>();
        if(seguros.isEmpty()) {
            seguros.add(new DocumentoNecesario("DNI", R.drawable.ic_documentonecesario));
            seguros.add(new DocumentoNecesario("Nomina", R.drawable.ic_documentonecesario));
            seguros.add(new DocumentoNecesario("Vida laboral", R.drawable.ic_documentonecesario));
        }

        ArrayList<DocumentoNecesario> cobrar = new ArrayList<>();
        if(cobrar.isEmpty()) {
            cobrar.add(new DocumentoNecesario("DNI", R.drawable.ic_documentonecesario));
            cobrar.add(new DocumentoNecesario("Cuenta", R.drawable.ic_documentonecesario));
            cobrar.add(new DocumentoNecesario("Talon", R.drawable.ic_documentonecesario));
        }

        ArrayList<DocumentoNecesario> talon = new ArrayList<>();
        if(talon.isEmpty()) {
            talon.add(new DocumentoNecesario("DNI", R.drawable.ic_documentonecesario));
            talon.add(new DocumentoNecesario("Cuenta", R.drawable.ic_documentonecesario));
        }

        ArrayList<DocumentoNecesario> nomina = new ArrayList<>();
        if(nomina.isEmpty()) {
            nomina.add(new DocumentoNecesario("DNI", R.drawable.ic_documentonecesario));
            nomina.add(new DocumentoNecesario("Cuenta", R.drawable.ic_documentonecesario));
        }

        ArrayList<DocumentoNecesario> credito = new ArrayList<>();
        if(credito.isEmpty()) {
            credito.add(new DocumentoNecesario("DNI", R.drawable.ic_documentonecesario));
            credito.add(new DocumentoNecesario("Cuenta", R.drawable.ic_documentonecesario));
        }


        ArrayList<Formularios> formularios = new ArrayList<>();
        if(formularios.isEmpty()) {
            formularios.add(new Formularios("Prestamo", prestamos, R.drawable.ic_prestamo));
            formularios.add(new Formularios("Hipoteca", hipoteca, R.drawable.ic_hipoteca));
            formularios.add(new Formularios("Pensiones", pension, R.drawable.ic_pensiones));
            formularios.add(new Formularios("Apertura de Cuenta", apertura, R.drawable.ic_cuentamas));
            formularios.add(new Formularios("Cierre de Cuenta", cierre, R.drawable.ic_eliminarcuenta));
            formularios.add(new Formularios("Transferencia", transferencia, R.drawable.ic_transferencia));
            formularios.add(new Formularios("Hacer Tarjeta", tarjeta, R.drawable.ic_cuentas));
            formularios.add(new Formularios("Cambiar Pin Tarjeta", pin, R.drawable.ic_cambiarpin));
            formularios.add(new Formularios("Plazo Fijo", fijo, R.drawable.ic_plazofijo));
            formularios.add(new Formularios("Seguros", seguros, R.drawable.ic_security));
            formularios.add(new Formularios("Cobrar Talones", cobrar, R.drawable.ic_talones));
            formularios.add(new Formularios("Talon Nominativo", talon, R.drawable.ic_talonnominativo));
            formularios.add(new Formularios("Domiciliar Nomina", nomina, R.drawable.ic_nomina));
            formularios.add(new Formularios("Creditos", credito, R.drawable.ic_creditos));
        }
    }
    public static ArrayList<Formularios> getForms() {
        return forms;
    }

    public static ArrayList<DocumentoNecesario> getDocs() {
        return docs;
    }
}
