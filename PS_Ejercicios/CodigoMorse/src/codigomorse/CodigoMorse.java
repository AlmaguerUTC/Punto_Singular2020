package codigomorse;

import java.util.Scanner;
import java.util.HashMap;

public class CodigoMorse {
    
    //Mapa para contener el codigo y el valor de la codificación y decodificación.
    private static HashMap <String, String> mapa = new HashMap<String, String>();

    //Arreglo para el texto
    private static String[] texto = {"A", "B", "C", "D", "E", "F", "G", "H", "I", 
        "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", 
        "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", 
        "8", "9", "0", " "};

    //Arreglo para el codigo morse
    private static String[] morse = {
        ".-", "-...", "-.-.", "-..", ".", "..-.", 
        "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
        "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", 
        ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", 
        "....-", ".....", "-....", "--...", "---..", "----.", "-----",
        "  "};

    // Rellenando el hasmap
    public static void rellenarmapa(String[] clave, String[] valor){
        for(int i = 0; i < clave.length; i++){
            CodigoMorse.mapa.put(clave[i], valor[i]);
        }
    }

    //Funcion para codificar de texto a morse
    public static String convertirtexto_morse(String p_texto){
        //Variable para almacenar el codigo morse codificado
        String resultado = "";

        // Rellenando mapa con las variables que contienen el texto y el codigo morse
        rellenarmapa(CodigoMorse.texto, CodigoMorse.morse);

        // Conviritiendo Texto a Mayusculas
        p_texto = p_texto.toUpperCase();

        //Convirtiendo a un arreglo de caracteres
        char[] texto_arreglo = p_texto.toCharArray();

        //Ciclo para convertir a codigo morse
        for(int i = 0; i < texto_arreglo.length; i++){
            resultado += CodigoMorse.mapa.get(String.valueOf(texto_arreglo[i]));
            if(texto_arreglo[i] != ' '){
                resultado += " ";
            }
        }

        //Limpiando el hashmap
        CodigoMorse.mapa.clear();

        //Retornar el valor ya codificado
        return resultado;
    }

    //Función para decodificar morse
    public static String convertirmorse_texto(String morse){
        //Variable para guardar el codigo morse decodificado
        String resultado = "";

        // Rellenando mapa con las variables que contienen el texto y el codigo morse
        rellenarmapa(CodigoMorse.morse, CodigoMorse.texto);

        //Dividir codificación por medio de los espacios
        String[] morse_palabras = morse.split("   ");

        //Ciclo para decodificar el codigo morse
        for(int i = 0; i < morse_palabras.length; i++){
            //Asignado letras al arreglo de letras separandolas por un espacio
            String[] morse_arreglo = morse_palabras[i].split(" ");

            //Construyendo texto por medio del hashmap
            for(int j = 0; j < morse_arreglo.length; j++){
                resultado += CodigoMorse.mapa.get(morse_arreglo[j]);
            }
            //Acomodando los espacios que son necesarios para las palabras
            resultado += " ";
        }

        //Limpiando hashmap
        CodigoMorse.mapa.clear();

        //Retornando el valor decodificado
        return resultado;
    }

    public static void main(String[] args) {

        //Clase escaner para recoger datos que digita el usuario
        Scanner entrada_sc = new Scanner(System.in);

        // Opción definida con byte para no asignar tanto espacio en memoria
        byte opcion = 0;

        // Definiendo variable de traducción dependiendo la función
        String traduccion = null;

        //Menú con do while
        do{
            System.out.println("");
            System.out.println("Seleccione Opción");
            System.out.println("1 = Texto a Morse");
            System.out.println("2 = Morse a Texto");
            System.out.println("Teclea 0 para salir.");
            System.out.println("");

            //Validando la opción digitada por el usuario
            try{
                opcion = entrada_sc.nextByte();
                entrada_sc.nextLine();
            }catch(Exception e){
                e.printStackTrace();
            }                        
            //Opción 
            if(opcion == 1){ 

                //Obteniendo texto para convertir en morse
                System.out.println("");
                System.out.println("Inserte los datos para traducir de texto a morse");

                //Validando el texto
                try{
                    traduccion = entrada_sc.nextLine();
                }catch(Exception e){
                    e.printStackTrace();
                }                

                //Imprimiento resultado por medio del valor que retorna la función que encripta texto a morse.
                System.out.println("Texto en morse: " + convertirtexto_morse(traduccion));
                System.out.println("");
                
                //Opción2
            }else if (opcion == 2){ 

                //Obteniendo morse para convertirlo a texto
                System.out.println("");
                System.out.println("Inserte los datos para traducir de morse a texto");
                
                //Validando el codigo morse
                try{
                    traduccion = entrada_sc.nextLine();
                }catch(Exception e){
                    e.printStackTrace();
                }                              

                //Imprimiendo resultado por medio del valor que retorna la función que desencripta el codigo morse a texto.
                System.out.println("Morse en texto: " + convertirmorse_texto(traduccion));
                System.out.println("");
            }else{

                if(opcion != 0){
                    //Mensaje de error en caso de no elegir una opción valida
                    System.out.println("");
                    System.out.println("Seleccione una opción valida");
                }

            }

        }while( opcion != 0 ); //Validando la opción sino terminar
    }
    
}
