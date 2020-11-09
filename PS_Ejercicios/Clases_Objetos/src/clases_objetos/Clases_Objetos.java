package clases_objetos;

import java.util.Scanner;
import figuras.Cuadrado;
import figuras.Cubo;

public class Clases_Objetos {
    
    public static void main(String[] args) {
        //Clase para leer los datos de la entrada
        Scanner entrada_sc = new Scanner(System.in);
        //Opción del menú
        byte opcion = 0;
        //Variable para almacenar el lado requerido
        double lado = 0;
        do{
            //Introduce el tamaño de un lado
            System.out.println("");
            System.out.print("Introduzca tamaño del lado : ");
            try{
                lado = entrada_sc.nextDouble();
                entrada_sc.nextLine();
            }catch(Exception e){
                e.printStackTrace();
            }
            do{
                //Menú de operaciones
                System.out.println("");
                System.out.println("Seleccione Operación");
                System.out.println("----------   Cuadrado   ----------");
                System.out.println("1 : Área de un cuadrado");
                System.out.println("2 : Perímetro de un cuadrado");
                System.out.println("----------   Cubo   ----------");
                System.out.println("3 : Volumen de un cubo");
                System.out.println("4 : Calculo del area de un cubo");
                System.out.println("5 : Perímetro de un cubo");
                        
                System.out.println("");
                System.out.println("0 : Salir del programa");
                System.out.println("");
                try{
                    opcion = entrada_sc.nextByte();
                    entrada_sc.nextLine();
                }catch(Exception e){
                    e.printStackTrace();
                }
                switch(opcion){
                    default:
                        break;
                }
                //Opciones para el cuadrado
                if(opcion == 1 || opcion == 2){
                    //Instancia de la clase cuadrado
                    Cuadrado cuadrado = new Cuadrado(lado);
                    if(opcion == 1){ 
                        // Area del cuadrado      
                        System.out.println("");
                        System.out.println("Calculo de Área del cuadrado");
                        System.out.println("El área es: " + cuadrado.calcular_area());
                        
                    }else{ 
                        // Perimetro                      
                        System.out.println("");
                        System.out.println("Calculo de Perímetro del cuadrado");
                        System.out.println("El área es: " + cuadrado.calcular_perimetro());
                    }
                    //Operaciones para el cubo
                }else if(opcion == 3 || opcion == 4 || opcion == 5){ 
                    // Instancia de la clase cubo
                    Cubo cubo = new Cubo();
                    cubo.configurar_lado(lado);
                    if(opcion == 3){
                        // Volumen
                        System.out.println("");
                        System.out.println("Calculo de volumen del cubo");
                        System.out.println("El volumen es: " + cubo.calcular_volumen_cubo());
                    }else if(opcion == 4){
                        // Area del cubo
                        System.out.println("");
                        System.out.println("Calculo de Área del cubo");
                        System.out.println("El área es: " + cubo.calcular_area());
                    }else if(opcion == 5){
                        // Perimetro del cubo
                        System.out.println("");
                        System.out.println("Calculo de Perímetro del cubo");
                        System.out.println("El área es: " + cubo.calcular_perimetro());  
                    }
                }
            }while(opcion != 6 && opcion != 0);       
        }while(opcion != 0); //Validación de la variable de control del while
    }   
}
