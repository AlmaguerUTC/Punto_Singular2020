package figuras;

public class Cubo extends Cuadrado {
    //Función para calcular el volumen
    public Double calcular_volumen_cubo(){
        return Math.pow(this.lado, 3);
    }
    
    //Modificacion de la función calcular_perimetro de la clase cuadrado sin afectar a la clase cuadrado
    @Override
    public Double calcular_perimetro(){
        return this.lado*12;
    }
    
    //Función para calcular el area
    @Override
    public Double calcular_area(){
        return (6*(lado*lado));
    }
}
