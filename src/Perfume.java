import java.util.Random;
class Perfume extends Produto {
    public Perfume(String modelo, String tamanho) {
        super(modelo, tamanho, switch(modelo) {
            case "Dia a dia" -> 99.90;
            case "Marcantes" -> 129.90;
            case "Frescos" -> 109.90;
            default -> 109.90;
        }, 51, new Random().nextInt(1000));
    }

    @Override
    public String toString() {
        return "Perfume: " + getModelo() + " - Tamanho " + getTamanho();
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
        return "Perfume";
    }

}

