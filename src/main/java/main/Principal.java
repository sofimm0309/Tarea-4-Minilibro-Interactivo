/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package main;

import controlador.Controlador;
import javax.swing.JOptionPane;
import modelo.Libro;
import modelo.Pagina;
import modelo.Pregunta;

/**
 *
 * @author sofia
 */
public class Principal {

    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        controlador.iniciar();

    }
}
