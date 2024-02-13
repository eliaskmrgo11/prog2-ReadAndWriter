package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
    File f;
    FileWriter fw;
    FileReader fr;
    BufferedWriter bw = null;
    BufferedReader br = null;

    public FileUtil(String nameFile) {
        f = new File(nameFile);
    }

    public void open(char modo) {
        try {
            // modo escritura "w" crea el archivo
            if (modo == 'w') {
                fw = new FileWriter(f);
                bw = new BufferedWriter(fw);
            } else {
                // modo lectura "r" abre el archivo
                fr = new FileReader(f);
                br = new BufferedReader(fr);
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    // Almacena la cadena ingresada por parametro
    public void record(String cad) {
        if (bw != null) {
            try {
                bw.write(cad);
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Lee una l�nea del archivo
    public String read() {
        String cad = "";
        try {
            cad = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cad;
    }

    // cierra archivo modo R/W
    public void close() {
        try {
            if (br != null)
                br.close();
            if (bw != null)
                bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
