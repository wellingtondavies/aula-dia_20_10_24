import java.time.LocalTime;

public class Custo {
    private String placa;
    private LocalTime horain;
    private LocalTime horaout;
    private int custoHora;

    public Custo(String placa, LocalTime horain, LocalTime horaout, int custoHora) {
        this.placa = placa;
        this.horain = horain;
        this.horaout = horaout;
        this.custoHora = custoHora;
    }

    public Custo() {

    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalTime getHorain() {
        return horain;
    }

    public void setHorain(LocalTime horain) {
        this.horain = horain;
    }

    public LocalTime getHoraout() {
        return horaout;
    }

    public void setHoraout(LocalTime horaout) {
        this.horaout = horaout;
    }

    public int getCustoHora() {
        return custoHora;
    }

    public void setCustoHora(int custoHora) {
        this.custoHora = custoHora;
    }

    @Override
    public String toString() {
        return "Custo por veiculo {" +
                "placa do veiculo '" + placa + '\'' +
                ", hora de entrada " + horain +
                ", hora de saida " + horaout +
                ", custo por hora " + custoHora +
                '}';
    }
}
