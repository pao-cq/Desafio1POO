package Ejercicio2;

import javax.swing.*;
// Esta clase es el punto de entrada de la aplicación, inicializa la vista y el controlador de la calculadora científica.
public class CalcuCientifica {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalcuVista vista = new CalcuVista();
            new CalcuControlador(vista);
        });
    }
}
