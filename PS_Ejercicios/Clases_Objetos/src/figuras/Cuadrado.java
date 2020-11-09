package figuras;

public class Cuadrado {
    //Atributo de la clase cuadrado que puede ser heredado a las clases hijas
    protected double lado = 0; 

    //Funcion para configurar el lado ya que es protected y no puede ser configurado directamente
    public void configurar_lado(double p_lado){
        this.lado = p_lado;
    }

    //Función para calcular perimetro
    public Double obtener_lado(){
        return this.lado;
    }    
    //Función para calcular el area
    public Double calcular_area(){
        return Math.pow(this.lado, 2);
    }

    //Función para calcular el perimetro
    public Double calcular_perimetro(){
        return this.lado * 4;
    }

    //Metodo constructor para inicializar la variable protegida
    public Cuadrado (){
        this.lado = 0;
    }
    
    //Metodo constructor para inicializar la variable desde un objeto
    public Cuadrado(double p_lado){
        this.lado = p_lado;
    }
}
