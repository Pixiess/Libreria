/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JTextField;

/**
 *
 * @author lourdes
 */
public class Restriccion {

    char caracter;
    int limite;
    int longitud;

    public Restriccion() {

    }

    public Restriccion(char caracter, int limite, JTextField campo) {
        this.caracter = caracter;
        this.limite = limite;
        this.longitud = campo.getText().length();
    }

    public boolean esTexto(char caracter, int limite, JTextField campo) {
        boolean res = false;
        int longitudCampo = campo.getText().length();
        String caracteres = " aAbBcCdDeEfFgGhHiIjJkKlLmMnNñÑoOpPqQrRsStTuUvVwWxXyYzZáéíóú";

        boolean ini = comienzaConEspacio(caracter, longitudCampo);
        boolean lim = estaDentroDelLimite(limite, longitudCampo);

        for (int i = 0; i < caracteres.length(); i++) {
            if (caracter == caracteres.charAt(i) && lim == true && ini == false) {
                res = true;
                i = caracteres.length();
            }
        }
        return res;
    }

    private boolean comienzaConEspacio(char caracter, int longitudCampo) {
        boolean res = false;
        int medida = longitudCampo;
        if (medida == 0 && caracter == ' ') {
            res = true;
        }
        return res;
    }

    public boolean esDecimal(char caracter, int limite, JTextField campo) {
        boolean res = false;
        int longitudCampo = campo.getText().length();
        String caracteres = "0123456789.";

        boolean lim = estaDentroDelLimite(limite, longitudCampo);
        boolean iniPunto = comienzaConPunto(caracter, longitudCampo);
        boolean iniCero = comienzaConCero(caracter, longitudCampo);
        boolean otroPunto = hayVariosPuntos(caracter, campo);

        for (int i = 0; i < caracteres.length(); i++) {

            if (caracter == caracteres.charAt(i) && lim == true
                    && iniPunto == false && iniCero == false && otroPunto==false) {
                res = true;
                i = caracteres.length();
            }
        }
        return res;
    }

    private boolean estaDentroDelLimite(int limite, int longitud) {
        boolean res = false;
        if (longitud < limite) {
            res = true;
        }
        return res;
    }

    private boolean comienzaConPunto(char caracter, int longitudCampo) {
        boolean res = false;
        int medida = longitudCampo;
        if (medida == 0 && caracter == '.') {
            res = true;
        }
        return res;
    }

    private boolean comienzaConCero(char caracter, int longitudCampo) {
        boolean res = false;
        int medida = longitudCampo;
        if (medida == 0 && caracter == '0') {
            res = true;
        }
        return res;
    }
    
    private boolean hayVariosPuntos(char caracter, JTextField campo){
        boolean res=false;
        int contador = 0;
        String texto = campo.getText();
        
        if(campo.getText().length()>0){
            for(int i=0; i<texto.length(); i++){
                if(texto.charAt(i) == '.'){
                    contador++;
                    i=texto.length();
                }
             }
            if(contador>0 && caracter=='.'){
                res=true;
            }
        }
        
        return res;
    }

    public boolean esEntero(char caracter, int limite, JTextField campo) {
        boolean res = false;
        int longitudCampo = campo.getText().length();
        String caracteres = "0123456789";

        boolean lim = estaDentroDelLimite(limite, longitudCampo);
        boolean iniCero = comienzaConCero(caracter, longitudCampo);

        for (int i = 0; i < caracteres.length(); i++) {

            if (caracter == caracteres.charAt(i) && lim == true && iniCero == false) {
                res = true;
                i = caracteres.length();
            }
        }
        return res;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    /*private boolean comienzaConPunto(char caracter, JTextField campo){
     boolean res=false;
     int medida = campo.getText().length();
        
     if(campo.getText().startsWith(".")){
     res = true;
     }
        
     return res;
     }*/
}
