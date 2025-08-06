import java.util.Random;

public class Camisa extends Produto{
    public Camisa(String modelo, String tamanho) {
        super(modelo, tamanho, switch(modelo) {
            case "Slim Fit" -> 99.99;
            case "Oversized" -> 139.90;
            case "Polo" -> 259.90;
            default -> 89.90;
        }, 97, new Random().nextInt(1000));  //gera um número aleatório entre 0 e 999 para passar ao construtor (código ou identificador)
    }


    @Override
    public String toString() {
        return "Camisa: " + getModelo() + " - Tamanho " + getTamanho();
    }

    @Override
    public double pagarPix() {
        return preco * 0.90;
    }

    @Override
    public double pagarParcelado() {
        return preco * 1.20;
    }
    @Override
    public String getTipo() {
        return "Camisa";
    }

}