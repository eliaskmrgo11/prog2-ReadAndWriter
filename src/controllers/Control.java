package controllers;

import java.util.Scanner;
import models.Editor;

public class Control {
    Scanner sc = new Scanner(System.in);
    Editor editor;

    public Control() {
        editor = new Editor();
    }
    public void menu() {
        int op = 0;
        do {
            System.out.println("Ingrese 1 para escribir en el archivo\nIngrese 2 para leer el archivo\nIngrese 3 para salir");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Ingrese el contenido para agregar al archivo");
                    editor.addCon(sc.next());
                    break;
                case 2:
                    System.out.println("El contenido del archivo es:\n\n");
                    editor.readData();
                    System.out.println(editor.mostrarContenido());

                    break;
                case 3:
                    // Salir
                    System.out.println("Saliendo");
                    op=3;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        }while(op!=3);
        sc.close();
    }
}
