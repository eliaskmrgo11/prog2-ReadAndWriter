package models;

import java.util.ArrayList;
import services.FileUtil;

public class Editor {
    private FileUtil route = new FileUtil(
            "D:\\Desktop\\UPTC\\3erSemestre\\1er Cincuenta\\Programacion II\\prog2-ReadAndWriter/documento.txt");
    private String[] contenido = null;

    public void addCon(String newCon) {
        if (contenido == null) {
            contenido = new String[1];
        }
    
        contenido[contenido.length - 1] = newCon;
        addSpace();
        writeData();
    }

    private void addSpace() {
        String[] newArray = new String[this.contenido.length + 1];
        for (int i = 0; i < this.contenido.length; i++) {
            newArray[i] = contenido[i];
        }
        newArray[contenido.length] = null;
        setContenido(newArray);
    }

    public void readData() {
        route.open('r');

        ArrayList<String> lineasImportadas = new ArrayList<>();
        String linea;

        while ((linea = route.read()) != null) {
            lineasImportadas.add(linea);
        }

        route.close();

        contenido = lineasImportadas.toArray(new String[0]);
    }

    public void writeData() {
        route.open('w');
        for (int i = 0; i < contenido.length; i++) {
            if (contenido[i] != null) {
                route.record(contenido[i]);
            }
        }
        route.close();
    }
    public String mostrarContenido(){
        String cont ="";
        for (int i = 0; i < contenido.length; i++) {
            cont+=contenido[i]+"\n";
        }
        return cont;
    }

    public String[] getContenido() {
        return contenido;
    }

    public void setContenido(String[] contenido) {
        this.contenido = contenido;
    }

}
