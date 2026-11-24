/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package main;

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

        Libro libro = new Libro();

        System.out.println("=== PRUEBA 1: PAGINAS ===");
        System.out.println("Cantidad de paginas: " + libro.cantidadPaginas());
        for (int i = 0; i < libro.cantidadPaginas(); i++) {
            Pagina pagina = libro.obtenerPagina(i);
            System.out.println(pagina.mostrarContenido());
            System.out.println();
        }

        System.out.println("=== PRUEBA 2: INTENTOS ===");
        intentar(libro, new int[]{2, 1, 0});   // todas correctas
        intentar(libro, new int[]{2, 1, 1});   // una incorrecta
        intentar(libro, new int[]{5, 0, 0});   // respuesta invalida
        intentar(libro, new int[]{0, 0, 0});   // tercer intento
        intentar(libro, new int[]{2, 1, 0});   // cuarto intento: debe fallar

        System.out.println();
        System.out.println("=== PRUEBA 3: EXCEPCIONES DE CONSULTA ===");
        try {
            libro.obtenerPagina(99);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("ATRAPADA: " + ex.getMessage());
        }
        try {
            libro.obtenerIntento(7);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("ATRAPADA: " + ex.getMessage());
        }

        System.out.println();
        System.out.println("=== PRUEBA 4: HISTORIAL ===");
        System.out.println("Intentos usados: " + libro.getIntentos());
        System.out.println(libro.mostrarHistorial());
    }

    private static void intentar(Libro libro, int[] respuestas) {
        try {
            int puntos = libro.registrarRespuestas(respuestas);
            System.out.println("Puntos obtenidos: " + puntos);
        } catch (IllegalArgumentException | IllegalStateException ex) {
            System.out.println("ATRAPADA: " + ex.getMessage());
        }
    }
}
