import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Veiculo {
    private String placa;
    private String modelo;
    private String tamanho;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;

    public Veiculo(String placa, String modelo, String tamanho, LocalTime horaEntrada, LocalTime horaSaida) {
        this.placa = placa;
        this.modelo = modelo;
        this.tamanho = tamanho;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    public Veiculo() {

    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }
    @Override
    public String toString() {
        return "Veiculos disponiveis{" +
                "placa '" + placa + '\'' +
                ", modelo '" + modelo + '\'' +
                ", tamanho '" + tamanho + '\'' +
                ", horaEntrada " + horaEntrada +
                ", horaSaida " + horaSaida +
                '}';
    }
}
