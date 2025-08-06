import java.util.Random;

class Calca extends Produto {
    public Calca(String modelo, String tamanho) {
        super(modelo, tamanho, switch(modelo) {
            case "Social" -> 219.90;
            case "Alfaiataria" -> 239.90;
            case "Jeans" -> 119.90;
            default -> 119.90;
        }, 83, new Random().nextInt(1000));
    }

    @Override
    public String toString() {
        return "Calça: " + getModelo() + " - Tamanho " + getTamanho();
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
        return "Calca";
    }

}