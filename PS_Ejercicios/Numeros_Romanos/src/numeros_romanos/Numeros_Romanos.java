package numeros_romanos;

import java.util.Scanner;

public class Numeros_Romanos {

    public static void main(String[] args) {
        //Instancia de objeto de la clase Scanner para obtener datos introducidos en la consola.
        Scanner entrada_sc = new Scanner(System.in);
      
        //Numero romano detectado en la consola.
        int N_romano_input;
        
        do {
            //Pedir el número al usuario.
            System.out.print("Por favor introduce un número entre 1 y 3999: ");
            N_romano_input = entrada_sc.nextInt();
          
            //El while controla que el numero este en el rango especificado
        } while (N_romano_input < 1 || N_romano_input > 3999);
        
        //Imprimir el resultado 
        System.out.println(N_romano_input + " -> " + Convertir_Romano(N_romano_input));
     }
    
        
        //Método para convetir a números romanos
        public static String Convertir_Romano(int p_numero) {
            int i, miles, centenas, decenas, unidades;
            String romano = "";
      
            //Obtener las unidades para hacer el calculo
            miles = p_numero / 1000;
            centenas = p_numero / 100 % 10;
            decenas = p_numero / 10 % 10;
            unidades = p_numero % 10;

            //Calcular el millar
            for (i = 1; i <= miles; i++) {
                romano = romano + "M";
            }

            //Calcular las centenas
            if (centenas == 9) {
                romano = romano + "CM";
            } else if (centenas >= 5) {
                romano = romano + "D";
                for (i = 6; i <= centenas; i++) {
                    romano = romano + "C";
                 }
            } else if (centenas == 4) {
                romano = romano + "CD";
            } else {
                for (i = 1; i <= centenas; i++) {
                    romano = romano + "C";
            }
        }

        //Calcular las decenas
        if (decenas == 9) {
            romano = romano + "XC";
        } else if (decenas >= 5) {
            romano = romano + "L";
            for (i = 6; i <= decenas; i++) {
                romano = romano + "X";
                 }
        } else if (decenas == 4) {
            romano = romano + "XL";
        } else {
            for (i = 1; i <= decenas; i++) {
                romano = romano + "X";
            }
        }

      //Calcular las unidades
        if (unidades == 9) {
            romano = romano + "IX";
        } else if (unidades >= 5) {
            romano = romano + "V";
            for (i = 6; i <= unidades; i++) {                                                           
                romano = romano + "I";
            }
        } else if (unidades == 4) {
            romano = romano + "IV";
        } else {
            for (i = 1; i <= unidades; i++) {
                romano = romano + "I";
            }
        }
        return romano;
    }
}
