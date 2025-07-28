package Ejercicio2;

import javax.swing.*;


// ACLARACION: Esta clase es el controlador de la calculadora, maneja los eventos de los botones y realiza las operaciones
// y cálculos necesarios. Se encarga de la lógica de la calculadora científica, incluyendo
// operaciones aritméticas, funciones científicas y conversiones entre sistemas numéricos.

public class CalcuControlador {
    private CalcuVista vista;
    private String operador = "";
    private double primerNumero = 0;
    private boolean nuevaOperacion = true;

    public CalcuControlador(CalcuVista vista) {
        this.vista = vista;
        for (JButton boton : vista.botones) {
            boton.addActionListener(e -> manejarBoton(boton.getText()));
        }
    }

    // Maneja los eventos de los botones
    private void manejarBoton(String texto) {
        try {
            switch (texto) {
                case "CE":
                    vista.campoEntrada.setText("");
                    vista.campoSalida.setText("");
                    operador = "";
                    primerNumero = 0;
                    break;
                case "=":
                    calcularResultado();
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    prepararOperacion(texto);
                    break;
                case "sin":
                case "cos":
                case "tan":
                case "√":
                case "ln":
                    calcularFuncion(texto);
                    break;
                case "Dec→Bin":
                    convertirDecimalABinario();
                    break;
                case "Bin→Dec":
                    convertirBinarioADecimal();
                    break;
                case "Hex→Dec":
                    convertirHexADecimal();
                    break;
                default:
                    if (nuevaOperacion) {
                        vista.campoEntrada.setText("");
                        nuevaOperacion = false;
                    }
                    vista.campoEntrada.setText(vista.campoEntrada.getText() + texto);
            }
        } catch (Exception ex) {
            vista.campoSalida.setText("Error: " + ex.getMessage());
        }
    }
    // Prepara la operación aritmética
    private void prepararOperacion(String op) {
        primerNumero = Double.parseDouble(vista.campoEntrada.getText());
        operador = op;
        nuevaOperacion = true;
    }
    // Calcula el resultado de la operación aritmética
    private void calcularResultado() {
        double segundoNumero = Double.parseDouble(vista.campoEntrada.getText());
        double resultado = 0;
        switch (operador) {
            case "+": resultado = primerNumero + segundoNumero; break;
            case "-": resultado = primerNumero - segundoNumero; break;
            case "*": resultado = primerNumero * segundoNumero; break;
            case "/": resultado = segundoNumero != 0 ? primerNumero / segundoNumero : Double.NaN; break;
        }
        vista.campoSalida.setText(String.valueOf(resultado));
        vista.campoEntrada.setText(String.valueOf(resultado));
        nuevaOperacion = true;
    }
    // Calcula funciones científicas
    private void calcularFuncion(String funcion) {
        double valor = Double.parseDouble(vista.campoEntrada.getText());
        double resultado = 0;
        switch (funcion) {
            case "sin": resultado = Math.sin(Math.toRadians(valor)); break;
            case "cos": resultado = Math.cos(Math.toRadians(valor)); break;
            case "tan": resultado = Math.tan(Math.toRadians(valor)); break;
            case "√": resultado = Math.sqrt(valor); break;
            case "ln": resultado = Math.log(valor); break;
        }
        vista.campoSalida.setText(String.valueOf(resultado));
        vista.campoEntrada.setText(String.valueOf(resultado));
        nuevaOperacion = true;
    }
    // Conversión decimal a binario
    private void convertirDecimalABinario() {
        int valor = Integer.parseInt(vista.campoEntrada.getText());
        vista.campoSalida.setText(Integer.toBinaryString(valor));
        nuevaOperacion = true;
    }
    // Conversión binario a decimal
    private void convertirBinarioADecimal() {
        String bin = vista.campoEntrada.getText();
        int dec = Integer.parseInt(bin, 2);
        vista.campoSalida.setText(String.valueOf(dec));
        nuevaOperacion = true;
    }
    // Conversión hexadecimal a decimal
    private void convertirHexADecimal() {
        String hex = vista.campoEntrada.getText();
        int dec = Integer.parseInt(hex, 16);
        vista.campoSalida.setText(String.valueOf(dec));
        nuevaOperacion = true;
    }
}