public class Vaga {
    private int numero;
    private String tamanho;
    private boolean disponivel;

    public Vaga(int numero, String tamanho, boolean disponivel) {
        this.numero = numero;
        this.tamanho = tamanho;
        this.disponivel = disponivel;
    }
    public Vaga() {

    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Vagas disponiveis{" +
                "numero da vaga " + numero +
                ", tamanho da vaga'" + tamanho + '\'' +
                ", disponibilidade " + disponivel +
                '}';
    }
}
