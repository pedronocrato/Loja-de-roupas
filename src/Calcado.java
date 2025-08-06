import java.util.Random;

class Calcado extends Produto {
    public Calcado(String modelo, String tamanho) {
        super(modelo, tamanho, switch(modelo) {
            case "Social" -> 359.90;
            case "Tenis" -> 549.90;
            case "Esportivo" -> 239.90;
            default -> 139.90;
        }, 63, new Random().nextInt(1000));
    }

    @Override
    public String toString() {
        return "Calçado: " + getModelo() + " - Tamanho " + getTamanho();
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
        return "Calcado";
    }

}