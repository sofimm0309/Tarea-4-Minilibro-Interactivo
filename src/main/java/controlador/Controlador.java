/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Libro;
import modelo.Pregunta;
import vista.VistaLibro;

/**
 *
 * @author sofia
 */
public class Controlador implements ActionListener {

    private Libro modelo;
    private VistaLibro vista;
    private int paginaActual = 0;

    public Controlador() {
        modelo = new Libro();
        vista = new VistaLibro();
        vista.addButtonListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();

        switch (opcion) {
            case "MENU":
                mostrarMenu();
                break;
            case "Anterior":
                anterior();
                break;
            case "Iniciar lectura":
                paginaActual = 0;
                mostrarPagina();
                break;
            case "Siguiente":
                siguiente();
                break;
            case "Responder":
                responder();
                break;
            case "Resultados":
                consultarResultados();
                break;
            case "SALIR":
                System.exit(0);

        }
    }

    public void mostrarPagina() {
        try {
            vista.mostrarTexto(modelo.obtenerPagina(paginaActual).mostrarContenido());
            vista.habilitarBotones(
                    //1. menu
                    true,
                    //2.anterior
                    paginaActual > 0,
                    //3.iniciar
                    false,
                    //4.siguiente
                    paginaActual < modelo.cantidadPaginas() - 1,
                    //5.responder
                    paginaActual == modelo.cantidadPaginas() - 1,
                    //6.resultados
                    true
            );
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(vista, ex.getMessage());
        }
    }

    private void anterior() {
        if (paginaActual > 0) {
            paginaActual--;
            mostrarPagina();
        }
    }

    private void siguiente() {
        if (paginaActual < modelo.cantidadPaginas() - 1) {
            paginaActual++;
            mostrarPagina();
        }
    }

    private void mostrarMenu() {
        vista.mostrarTexto("BIODIVERCR\n\n"
                + "Tema: la biodiversidad del Pacífico costarricense\n\n"
                + "Autor: sofi");
        //                    menu   anterior iniciar siguiente responder resultados
        vista.habilitarBotones(false, false, true, false, false, true);
    }

    private void responder() {
        if (modelo.getIntentos() >= 3) {
            JOptionPane.showMessageDialog(vista, "¡Ups! Ya usaste los tres intentos.");
            return;
        }
        try {
            int[] respuestas = new int[3];
            for (int i = 0; i < respuestas.length; i++) {
                Pregunta pregunta = modelo.obtenerPregunta(i);
                int eleccion = JOptionPane.showOptionDialog(vista, pregunta.getTexto(),
                        "Pregunta " + (i + 1) + " de 3", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, pregunta.getOpciones(),
                        pregunta.getOpciones()[0]);
                respuestas[i] = eleccion;
                if (eleccion == -1) {
                    break;
                }
            }
            int puntos = modelo.registrarRespuestas(respuestas);
            mostrarResultados("Respuestas correctas: " + puntos + " de 3");
        } catch (IllegalArgumentException | IllegalStateException | IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(vista, ex.getMessage());
        }
    }

    private void consultarResultados() {
        if (modelo.getIntentos() == 0) {
            JOptionPane.showMessageDialog(vista, "Todavía no has hecho ningún intento.");
            return;
        }
        mostrarResultados("Tus resultados");
    }

    private void mostrarResultados(String encabezado) {
        String texto = encabezado + "\n\n" + modelo.mostrarHistorial();
        if (modelo.getIntentos() < 3) {
            texto += "\nPuedes intentarlo de nuevo con el botón Responder.";
        } else {
            texto += "\nUsaste los 3 intentos. Buen trabajo";
        }
        vista.mostrarTexto(texto);
        //                    menu  anterior iniciar siguiente responder                   resultados
        vista.habilitarBotones(true, false, false, false, modelo.getIntentos() < 3, false);
    }

    public void iniciar() {
        mostrarMenu();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

    }
}
