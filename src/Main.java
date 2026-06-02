package app;

import abstracts.Sensor;
import interfaces.Monitoravel;
import model.Alerta;
import model.SensorAgua;
import model.SensorChuva;
import service.SistemaMonitoramento;
import util.NivelRisco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaMonitoramento sistema = new SistemaMonitoramento();

        int opcao;

        do {
            System.out.println("\n=== SmartInfra FloodAlert ===");
            System.out.println("1 - Cadastrar sensor de água");
            System.out.println("2 - Cadastrar sensor de chuva");
            System.out.println("3 - Registrar medição");
            System.out.println("4 - Listar sensores");
            System.out.println("5 - Emitir alerta");
            System.out.println("0 - Encerrar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("ID do sensor: ");
                    int idAgua = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Localização: ");
                    String localAgua = scanner.nextLine();

                    sistema.adicionarSensor(new SensorAgua(idAgua, localAgua));
                    System.out.println("Sensor de água cadastrado com sucesso.");
                    break;

                case 2:
                    System.out.print("ID do sensor: ");
                    int idChuva = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Localização: ");
                    String localChuva = scanner.nextLine();

                    sistema.adicionarSensor(new SensorChuva(idChuva, localChuva));
                    System.out.println("Sensor de chuva cadastrado com sucesso.");
                    break;

                case 3:
                    System.out.print("Informe o ID do sensor: ");
                    int idBusca = scanner.nextInt();

                    Sensor sensor = sistema.buscarSensorPorId(idBusca);

                    if (sensor != null && sensor instanceof Monitoravel) {
                        System.out.print("Digite o valor da medição: ");
                        double valor = scanner.nextDouble();

                        Monitoravel monitoravel = (Monitoravel) sensor;
                        monitoravel.registrarMedicao(valor);

                        System.out.println("Medição registrada.");
                        System.out.println("Status: " + monitoravel.verificarStatus());
                    } else {
                        System.out.println("Sensor não encontrado.");
                    }
                    break;

                case 4:
                    sistema.listarSensores();
                    break;

                case 5:
                    System.out.print("Mensagem do alerta: ");
                    String mensagem = scanner.nextLine();

                    System.out.println("Escolha o nível do alerta:");
                    System.out.println("1 - Baixo");
                    System.out.println("2 - Moderado");
                    System.out.println("3 - Alto");
                    System.out.println("4 - Emergência");
                    System.out.print("Opção: ");
                    int opcaoNivel = scanner.nextInt();

                    NivelRisco nivel;

                    switch (opcaoNivel) {
                        case 1:
                            nivel = NivelRisco.BAIXO;
                            break;
                        case 2:
                            nivel = NivelRisco.MODERADO;
                            break;
                        case 3:
                            nivel = NivelRisco.ALTO;
                            break;
                        case 4:
                            nivel = NivelRisco.EMERGENCIA;
                            break;
                        default:
                            nivel = NivelRisco.BAIXO;
                            System.out.println("Opção inválida. Nível definido como baixo.");
                    }

                    Alerta alerta = new Alerta(mensagem, nivel);
                    alerta.enviarNotificacao();
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}