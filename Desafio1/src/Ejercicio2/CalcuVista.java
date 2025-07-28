package Ejercicio2;

import javax.swing.*;
import java.awt.*;

// Codigo del swing para crear la calculadora
// ACLARACION: Esta clase crea la interfaz gráfica de la calculadora, no se utilizó el Swing UI designer por cuestiones de tiempo
// sin embargo, si se puede escribir desde el código sin necesidad de usar un diseñador visual

public class CalcuVista extends JFrame {
    JTextField campoEntrada;
    JTextArea campoSalida;
    JButton[] botones;
    JButton btnSeno, btnCoseno, btnTangente, btnRaiz, btnLn;
    JButton btnDecBin, btnBinDec, btnHexDec, btnCE;

    public CalcuVista() {
        setTitle("Calculadora Científica");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);
        setLayout(new BorderLayout());

        campoEntrada = new JTextField();
        campoSalida = new JTextArea(2, 20);
        campoSalida.setEditable(false);

        JPanel panelCampos = new JPanel(new GridLayout(2,1));
        panelCampos.add(campoEntrada);
        panelCampos.add(new JScrollPane(campoSalida));
        add(panelCampos, BorderLayout.NORTH);

        // posicion de los botones de la calculadora
        String[] etiquetas = {
                "7","8","9","/","sin",
                "4","5","6","*","cos",
                "1","2","3","-","tan",
                "0",".","=","+","√",
                "ln","Dec→Bin","Bin→Dec","Hex→Dec","CE"
        };
        botones = new JButton[25];
        JPanel panelBotones = new JPanel(new GridLayout(5,5,5,5));
        for (int i = 0; i < 25; i++) {
            botones[i] = new JButton(etiquetas[i]);
            panelBotones.add(botones[i]);
        }
        add(panelBotones, BorderLayout.CENTER);

        setVisible(true);
    }
}