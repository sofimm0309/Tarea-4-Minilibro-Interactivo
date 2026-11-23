/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author sofia
 */
public abstract class Pagina {
    
    private String titulo;
    private int numeroPagina;
    private String contenido;

    public Pagina(String titulo, int numeroPagina, String contenido) {
        this.titulo = titulo;
        this.numeroPagina = numeroPagina;
        this.contenido = contenido;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public String getContenido() {
        return contenido;
    }
    
    public abstract String mostrarContenido();
        
        
    }
    
