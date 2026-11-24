/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author sofia
 */
public class PaginaActividad extends Pagina {

    public PaginaActividad(String titulo, int numeroPagina, String contenido) {
        super(titulo, numeroPagina, contenido);
    }

    @Override
    public String mostrarContenido() {
        return "Actividad - Página " + getNumeroPagina() + ": " + getTitulo() + "\n\n" + getContenido()
                + "\n\nElige una opción y dale a RESPONDER.";
    }
    
}
