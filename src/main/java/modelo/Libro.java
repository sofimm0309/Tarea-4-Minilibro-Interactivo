/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author sofia
 */
public class Libro {

    private ArrayList<Pagina> paginas = new ArrayList<>();
    private Pregunta[] preguntas = new Pregunta[3];
    private int[] respuestasCorrectas = {2, 1, 0};
    private int[][] registro = new int[3][3];
    private int intentos = 0;

    public Libro() {
        //info
        paginas.add(new PaginaInformativa("¿Qué es la biodiversidad?\n", 1, "La biodiversidad es la variedad de seres vivos que hay en un lugar: "
                + "plantas, animales, hongos y hasta los más pequeñitos. "
                + "Costa Rica es un país pequeño, pero en él vive cerca del 5 % "
                + "de todas las especies del planeta."));

        paginas.add(new PaginaInformativa("Los hogares del Pacífico\n", 2, "En el Pacífico costarricense hay: "
                + "playas, manglares, bosque seco y selva lluviosa. "
                + "Allí viven la lapa roja, el mono tití y la tortuga lora, que llega a las playas a poner sus huevos. "
                + "También nos visita la ballena jorobada, que viene a tener a sus crías."));

        paginas.add(new PaginaInformativa("¡Cuidemos nuestro hogar!\n", 3, "Muchos animales y plantas están en peligro por "
                + "la basura, la contaminación y la pérdida de sus hogares. "
                + "Todos podemos ayudar: "
                + "cuidando los árboles, no tirando basura y respetando a los animales silvestres."));

        paginas.add(new PaginaInformativa("Ultima actividad\n", 4, "Comprueba lo aprendido sobre la biodiversidad del Pacifico"));

        //opciones
        preguntas[0] = new Pregunta("¿Qué es la biodiversidad?", new String[]{"El clima de un lugar", "Un animal muy raro",
            "La variedad de seres vivos de un lugar"});

        preguntas[1] = new Pregunta("¿Qué animal visita el Pacífico para tener a sus crías?", new String[]{"El pingüino",
            "La ballena jorobada", "El camello"});

        preguntas[2] = new Pregunta("¿Qué podemos hacer para cuidar la biodiversidad?", new String[]{"Cuidar los arboles y no tirar basura",
            "Llevarnos animales silvestres a casa", "Hacer ruido para ahuyentarlos"});
    }

    public int cantidadPaginas() {
        return paginas.size();
    }

    //obtener
    public Pagina obtenerPagina(int numero) {
        if (numero < 0 || numero >= paginas.size()) {
            throw new IndexOutOfBoundsException("Ups, esa pagina no existe.");
        }
        return paginas.get(numero);
    }

    public Pregunta obtenerPregunta(int numero) {
        return preguntas[numero];
    }

    public int getIntentos() {
        return intentos;
    }

    public int registrarRespuestas(int[] respuestas) {
        if (intentos >= 3) {
            throw new IllegalStateException("Ya se realizaron los 3 intentos disponibles.");
        }
        if (respuestas.length != 3) {
            throw new IllegalArgumentException("Debe responder las 3 preguntas.");
        }
        //respuesta invalida
        for (int i = 0; i < respuestas.length; i++) {
            if (respuestas[i] < 0 || respuestas[i] > 2) {
                throw new IllegalArgumentException("Ups, elige una de las tres opciones.");
            }
        }
        int puntos = 0;
        for (int i = 0; i < respuestas.length; i++) {
            registro[intentos][i] = respuestas[i];
            if (respuestas[i] == respuestasCorrectas[i]) {
                puntos++;

            }

        }
        intentos++;
        return puntos;

    }

    public String obtenerIntento(int numero) {
        if (numero < 0 || numero >= intentos) {
            throw new IndexOutOfBoundsException("Ups, ese intento todavia no existe");
        }
        String texto = "Intento " + (numero + 1) + ": ";
        for (int i = 0; i < 3; i++) {
            texto += (registro[numero][i] + 1) + " ";
        }
        return texto;
    }

    public String mostrarHistorial() {
        String texto = "Historial de intentos:\n";
        for (int i = 0; i < intentos; i++) {
            texto += "Intento " + (i + 1) + ": ";
            for (int j = 0; j < 3; j++) {
                texto += (registro[i][j] + 1) + " ";
            }
            texto += "\n";
        }
        return texto;
    }

}
