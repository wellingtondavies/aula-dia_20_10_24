import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Estacionamento> estacionamentos = new ArrayList<>();
    public static List<Veiculo> veiculos = new ArrayList<Veiculo>();
    public static List<Vaga> vagas = new ArrayList<>();
    public static List<Custo> custos= new ArrayList<>();
    public static Scanner scan = new Scanner(System.in);
    public static Veiculo veiculo = new Veiculo();
    public static Vaga vaga = new Vaga();

    public static void main(String[] args) {
    inicializador();
    cadastraVeiculo();
    cadastraVaga();
    ocuparVaga();
    removerVaga();
    saidaVeiculo();
    relatorioVagasOcupadas();
    hitoricoDePermanencia();
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
            String tamanho = null;

                for(Vaga vaga : vagas) {
                    if(vaga.getNumero() == numero) {
                        vaga.setDisponivel(true);
                        tamanho = vaga.getTamanho();
                    }
                }

            System.out.println(" veiculos disponiveis: \n");
            for (Veiculo veiculo1 : veiculos) {
                System.out.println(veiculo1.toString());
            }
            System.out.println(" digite a placa do veiculo que deseja atribuir a vaga \n");
            String placa = scan.next();
            String tamanhoVeiculo = null;

            for(Veiculo veiculo : veiculos) {
                if(veiculo.getPlaca().equals(placa)) {
                    tamanhoVeiculo = veiculo.getTamanho();
                }
            }

            LocalTime horain= null;
            LocalTime horaout = null;

            for (Veiculo veiculo2 : veiculos) {
                if (veiculo2.getPlaca().equals(placa)) {
                    horain = veiculo.getHoraEntrada();
                    horaout = veiculo2.getHoraSaida();
                }
            }
                if(tamanho.equalsIgnoreCase(tamanhoVeiculo)){
                    Estacionamento estacionamento = new Estacionamento(null, placa, numero, horain, horaout);
                    estacionamentos.add(estacionamento);
                    System.out.println(" veiculo adicionado a vaga \n");
                }else{
                    System.out.println(" tamanhos incompativeis \n");
                }

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
                    System.out.println(" vaga removida com sucesso: \n");
                }else{
                    System.out.println(" ERRO \n");
                }
            }
        }
    }
    public static void saidaVeiculo(){
        int custoHora = 0;
        LocalTime horain = null;
        LocalTime horaout = null;

        System.out.println("veiculos disponiveis \n");

        for(Veiculo veiculo : veiculos) {
            System.out.println(veiculo.toString());
        }

        System.out.println(" escolha um veiculo pela placa: \n");
        String placa = scan.next();

        boolean veiculoEncontrado = false;
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                horain = veiculo.getHoraEntrada();
                horaout = veiculo.getHoraSaida();
                veiculoEncontrado = true;
                break;
            }
        }

        if (!veiculoEncontrado) {
            System.out.println("Veículo com placa " + placa + " não encontrado.");
            return;
        }

        Duration duracao = Duration.between(horain, horaout); //calcula duração entre horain e horaout
        long totalMinutos = duracao.toMinutes(); //converte a duração total para minutos

        if(totalMinutos < 60){
            custoHora = 5;
        } else if (totalMinutos > 60 && totalMinutos < 180) {
            custoHora = 10;
        }else{
            custoHora = 15;
        }

        System.out.println(" o custo de estacionamento o veiculo de placa: " + placa + " é "+ custoHora);
        System.out.println(" pagar "+custoHora+" ( 1 - sim | 2 - não )");
        int escolha = scan.nextInt();

        if (escolha == 1) {
            for(Estacionamento estacionamento : estacionamentos){
                if(estacionamento.getPlaca().equals(placa)) {
                    int numero = estacionamento.getNumero();
                    for(Vaga vaga : vagas) {
                        if(numero == vaga.getNumero()) {
                            vaga.setDisponivel(true);
                        }
                    }
                    estacionamento.getEstacionamentos().remove(estacionamento);
                }
            }
            System.out.println(" cobrança feita e vaga alterada para disponivel \n");
        }else if(escolha == 2){
            System.out.println(" ERRO, o valor precisa ser pago para liberar o veiculo \n");
        }else{
            System.out.println(" valores invalidos \n");
        }

        Custo custo = new Custo(placa, horain, horaout, custoHora);
        custos.add(custo);
    }
    public static void relatorioVagasOcupadas(){
        System.out.println(" exibindo relatorio de vagas ocupadas \n");

        for(Vaga vaga1 :vagas){
            if(vaga1.isDisponivel() == false){
                System.out.println(vaga1.toString());
            }
        }
    }
    public static void hitoricoDePermanencia(){
        System.out.println(" historico de permanencia \n");

        for(Custo custo : custos){
            System.out.println(custo.toString());
        }
    }
    public static void inicializador(){
        Veiculo inicializador1 = new Veiculo("mcm6j45", "uno", "pequeno", LocalTime.of(10,30,00), LocalTime.of(15,00,00));
        veiculos.add(inicializador1);
        Veiculo inicializador2 = new Veiculo("abc1d23", "fusca", "medio", LocalTime.of(11, 15, 00), LocalTime.of(16, 45, 00));
        veiculos.add(inicializador2);
        Veiculo inicializador3 = new Veiculo("xyz9w87", "civic", "grande", LocalTime.of(12, 00, 00), LocalTime.of(17, 30, 00));
        veiculos.add(inicializador3);

        Vaga inicializador4 = new Vaga(10, "pequeno", true);
        vagas.add(inicializador4);
        Vaga inicializador5 = new Vaga(12, "médio", true);
        vagas.add(inicializador5);
        Vaga inicializador6 = new Vaga(14, "grande", true);
        vagas.add(inicializador6);

    }
}