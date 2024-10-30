import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Estacionamento> estacionamentos = new ArrayList<>();
    public static List<Veiculo> veiculos = new ArrayList<Veiculo>();
    public static List<Vaga> vagas = new ArrayList<>();
    public static Scanner scan = new Scanner(System.in);
    public static Veiculo veiculo = new Veiculo();
    public static Vaga vaga = new Vaga();

    public static void main(String[] args) {


    }
    public static void cadastraVeiculo() {
        System.out.println("cadastrar veiculo \n");
        boolean rodar = true;
        while (rodar) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

            System.out.println("digite a placa do veiculo: \n");
            String placa = scan.next();
            System.out.println("digite o modelo do veiculo: \n");
            String modelo = scan.next();
            System.out.println("qual o tamanho do veiculo?: ( pequeno | medio | grande ) \n");
            String tamanho = scan.next();

            System.out.println("qual a hora de entrada? \n");
            String horaDeEntrada = scan.next();
            LocalTime horaEntrada = LocalTime.parse(horaDeEntrada, formato);

            System.out.println("qual a hora de saida? \n");
            String horaDeSaida = scan.next();
            LocalTime horaSaida = LocalTime.parse(horaDeSaida, formato);

            System.out.println(" deseja adicionar mais um veiculo? ( 1 - sim | 2 - não ) \n");
            int escolha = scan.nextInt();

            Veiculo veiculo = new Veiculo(placa, modelo, tamanho, horaEntrada, horaSaida);
            veiculos.add(veiculo);

            if (escolha == 2) {
                rodar = false;
            }
        }
    }
    public static void cadastraVaga() {
        System.out.println("cadastrar vaga \n");
        boolean rodar = true;
        while (rodar) {
            System.out.println("digite o numero da vaga: \n");
            int numero = scan.nextInt();
            System.out.println("digite o tamanho da vaga: ( pequeno | medio | grande ) \n");
            String tamanho = scan.next();
            System.out.println("disponibilidade automaticamente definida para sim: \n");
            boolean disponibilidade = true;

            System.out.println(" deseja adicionar mais vagas ( 1 - sim | 2 ) \n");
            int escolha = scan.nextInt();

            Vaga vaga = new Vaga(numero, tamanho, disponibilidade);
            vagas.add(vaga);

            if (escolha == 2) {
                rodar = false;
            }

        }

    }
    public static void ocuparVaga() {
        System.out.println(" ocupar vaga \n");
        boolean rodar = true;
        while (rodar) {
            System.out.println("vagas disponiveis: \n");
            for (Vaga vaga1 : vagas) {
                System.out.println(vaga1.toString());
            }

            System.out.println(" escolha uma vaga pelo numero: \n");
            int numero = scan.nextInt();

            System.out.println(" veiculos disponiveis: \n");
            for (Veiculo veiculo1 : veiculos) {
                System.out.println(veiculo1.toString());
            }
            System.out.println(" digite a placa do veiculo que deseja atribuir a vaga \n");
            String placa = scan.next();

            LocalTime horain= null;
            LocalTime horaout = null;

            for (Veiculo veiculo2 : veiculos) {
                if (veiculo2.getPlaca().equals(placa)) {
                    horain = veiculo.getHoraEntrada();
                    horaout = veiculo2.getHoraSaida();
                }
            }

            Estacionamento estacionamento = new Estacionamento(null, placa, numero, horain, horaout);
            estacionamentos.add(estacionamento);

            System.out.println(" veiculos atribuidos as vagas com sucesso ");

            System.out.println(" deseja adicionar mais veiculos as vagas ( 1 - sim | 2 - não ) \n");
            int escolha = scan.nextInt();

            if (escolha == 2) {
                rodar = false;
            }
        }
    }
    public static void removerVaga() {
        System.out.println("remover vaga \n");
        boolean rodar = true;
        while (rodar) {
            System.out.println("vagas disponiveis: \n");
            for (Vaga vaga1 : vagas) {
                System.out.println(vaga1.toString());
            }
            System.out.println(" escolha uma vaga pelo numero: \n");
            int numero = scan.nextInt();

            for (Vaga vaga2 : vagas) {
                if (vaga2.getNumero() == numero) {
                    vaga2.setDisponivel(true);
                    vagas.remove(vaga2);
                }
            }
        }
    }
}