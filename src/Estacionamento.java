import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Estacionamento> estacionamentos = new ArrayList<Estacionamento>();
    private String placa;
    private int numero;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;

    public Estacionamento(List<Estacionamento> estacionamentos, String placa, int numero, LocalTime horaEntrada, LocalTime horaSalida) {
        this.estacionamentos = estacionamentos;
        this.placa = placa;
        this.numero = numero;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    public Estacionamento() {

    }
    public List<Estacionamento> getEstacionamentos() {
        return estacionamentos;
    }

    public void setEstacionamentos(List<Estacionamento> estacionamentos) {
        this.estacionamentos = estacionamentos;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Override
    public String toString() {
        return "Estacionamento{" +
                "estacionamentos=" + estacionamentos +
                ", placa='" + placa + '\'' +
                ", numero=" + numero +
                ", horaEntrada=" + horaEntrada +
                ", horaSalida=" + horaSalida +
                '}';
    }
}
