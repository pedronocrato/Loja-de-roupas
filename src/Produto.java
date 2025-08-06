import java.io.Serializable;

abstract class Produto implements Pagavel, Serializable {
    private static final long serialVersionUID = 1L; //

    protected String modelo;
    protected String tamanho;
    protected double preco;
    protected int estoque;
    protected int codigo;

    public Produto(String modelo, String tamanho, double preco, int estoque, int codigo) {
        this.modelo = modelo;
        this.tamanho = tamanho;
        this.preco = preco;
        this.estoque = estoque;
        this.codigo = codigo;
    }

    public String getResumo() {
        return String.format("Modelo: %s | Tamanho: %s | Preço: R$%.2f | Estoque: %d | Código: %d",
                modelo, tamanho, preco, estoque, codigo);
    }

    public double calcularPreco() {
        return preco;
    }

    @Override
    public double pagarPix() {
        return 0;
    }

    @Override
    public double pagarParcelado() {
        return 0;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String toCSV() {
        return String.format("Tipo | %s\nModelo | %s\nTamanho | %s\nValor | %s\n ", getTipo(), modelo, tamanho, preco);
    }

    public abstract String getTipo();

}

