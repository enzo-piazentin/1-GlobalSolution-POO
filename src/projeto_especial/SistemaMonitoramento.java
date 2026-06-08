package projeto_especial;

import java.util.Scanner;

/**
 * Classe principal que implementa o sistema de monitoramento espacial.
 * Fornece um menu interativo para acessar os sensores e dados da missão.
 */
public class SistemaMonitoramento {

    /**
     * Metodo principal que inicia o sistema de monitoramento.
     * Cria os sensores e dados da missão, e exibe um menu interativo.
     * @param args Argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Criação dos sensores do sistema
        SensorTemperatura temperatura = new SensorTemperatura();
        SensorPressao pressao = new SensorPressao();
        SensorRadiacao radiacao = new SensorRadiacao();

        // Instâncias de propulsão
        PropulsaoQuimica propQuimica = new PropulsaoQuimica(0);
        PropulsaoEletrica propEletrica = new PropulsaoEletrica(0);

        // Sistemas de gerenciamento de componentes
        SistemaCadastro sistemaCadastro = new SistemaCadastro();
        SistemaRastreamento sistemaRastreamento = new SistemaRastreamento();

        // Adicionar alguns componentes iniciais de exemplo
        sistemaCadastro.adicionarPlaneta("Marte", 65, 225, "Rochoso", true);
        sistemaCadastro.adicionarPlaneta("Vênus", 450, 108, "Rochoso", false);
        sistemaRastreamento.adicionarAsteroide("Apophis", 300, 0.5, 12.5, "BEM", true);

        // Criação dos dados da missão com informações iniciais
        DadosMissao missao = new DadosMissao(
                "10.20,30.40",  // Coordenadas iniciais
                "1234",          // Código de acesso
                80,              // Nível de combustível inicial (80%)
                "Terra -> Marte", // Trajetória da missão
                5                // Número de tripulantes
        );

        int opcao;

        // Loop principal do menu interativo
        do {
            System.out.println("\n=== SISTEMA ESPACIAL ===");
            System.out.println("1 - Ler Sensores e checar alertas");
            System.out.println("2 - Ver Combustivel");
            System.out.println("3 - Ver Coordenadas");
            System.out.println("4 - Controlar Propulsão");
            System.out.println("5 - Simular/Ver Alertas (sensores + combustível)");
            System.out.println("6 - Exibir status completo");
            System.out.println("0 - Sair");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    // Lê e exibe os valores de todos os sensores e verifica alertas
                    SistemaAlertas.verificarSensores(temperatura, pressao, radiacao);
                    break;

                case 2:
                    // Exibe o nível atual de combustível
                    System.out.println("Combustivel: " + missao.getCombustivel() + "%");
                    SistemaAlertas.verificarCombustivel(missao);
                    break;

                case 3:
                    // Solicita senha para acessar as coordenadas (informação sensível)
                    System.out.print("Senha: ");
                    scanner.nextLine();
                    String senha = scanner.nextLine();
                    System.out.println(missao.acessarCoordenadas(senha));
                    break;

                case 4:
                    // Submenu de controle de propulsão
                    int sub;
                    do {
                        System.out.println("\n--- CONTROLE DE PROPULSÃO ---");
                        System.out.println("1 - Ligar/Desligar propulsão química");
                        System.out.println("2 - Ligar/Desligar propulsão elétrica");
                        System.out.println("3 - Definir potência (química)");
                        System.out.println("4 - Definir potência (elétrica)");
                        System.out.println("5 - Acelerar (química)");
                        System.out.println("6 - Acelerar (elétrica)");
                        System.out.println("7 - Mostrar empuxo");
                        System.out.println("0 - Voltar");
                        sub = scanner.nextInt();
                        switch (sub) {
                            case 1:
                                if (propQuimica.isLigado()) { propQuimica.desligarMotor(); System.out.println("Propulsão química desligada"); }
                                else { propQuimica.ligarMotor(); System.out.println("Propulsão química ligada"); }
                                break;
                            case 2:
                                if (propEletrica.isLigado()) { propEletrica.desligarMotor(); System.out.println("Propulsão elétrica desligada"); }
                                else { propEletrica.ligarMotor(); System.out.println("Propulsão elétrica ligada"); }
                                break;
                            case 3:
                                System.out.print("Digite potência (%) para propulsão química: ");
                                double pQ = scanner.nextDouble();
                                try { propQuimica.setPotencia(pQ); System.out.println("Potência química definida."); } catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
                                break;
                            case 4:
                                System.out.print("Digite potência (%) para propulsão elétrica: ");
                                double pE = scanner.nextDouble();
                                try { propEletrica.setPotencia(pE); System.out.println("Potência elétrica definida."); } catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
                                break;
                            case 5:
                                propQuimica.acelerar();
                                break;
                            case 6:
                                propEletrica.acelerar();
                                break;
                            case 7:
                                System.out.println("Empuxo (química): " + propQuimica.calcularEmpuxo());
                                System.out.println("Empuxo (elétrica): " + propEletrica.calcularEmpuxo());
                                break;
                        }
                    } while (sub != 0);
                    break;

                case 5:
                    // Simula/verifica alertas
                    SistemaAlertas.verificarSensores(temperatura, pressao, radiacao);
                    SistemaAlertas.verificarCombustivel(missao);
                    break;

                case 6:
                    // Exibe status completo do sistema
                    System.out.println("\n--- STATUS COMPLETO ---");
                    System.out.println("Sensores:");
                    SistemaAlertas.verificarSensores(temperatura, pressao, radiacao);
                    System.out.println("\nPropulsão:");
                    System.out.println("Química - ligado=" + propQuimica.isLigado() + ", potência=" + propQuimica.getPotencia() + ", empuxo=" + propQuimica.calcularEmpuxo());
                    System.out.println("Elétrica - ligado=" + propEletrica.isLigado() + ", potência=" + propEletrica.getPotencia() + ", empuxo=" + propEletrica.calcularEmpuxo());
                    System.out.println("\nMissão:");
                    System.out.println("Combustível: " + missao.getCombustivel() + "%");
                    System.out.println("Trajetória: " + missao.getTrajetoria());
                    System.out.println("Tripulantes: " + missao.getTripulantes());
                    break;
            }

        } while (opcao != 0); // Continua até o usuário escolher sair (opção 0)

        scanner.close();
    }
}
