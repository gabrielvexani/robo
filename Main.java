
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner e = new Scanner(System.in);

        // ArrayList da classe Robo para armazenar os três tipos de robôs.
        // Polimorfismo: uma mesma lista recebe objetos de subclasses diferentes.
        ArrayList<Robo> robos = new ArrayList<>();

        int opcao = 0;

        while (opcao != 8) {

            System.out.println("\n---- CAMPEONATO DE ROBOS ----");
            System.out.println("1 - Cadastrar robo");
            System.out.println("2 - Listar robos");
            System.out.println("3 - Realizar combate");
            System.out.println("4 - Recuperar energia");
            System.out.println("5 - Realizar rodada geral");
            System.out.println("6 - Mostrar classificacao");
            System.out.println("7 - Mostrar estatisticas");
            System.out.println("8 - Sair");
            System.out.println("Escolha uma opcao: ");

            opcao = e.nextInt();
            e.nextLine();

            if (opcao == 1) {

                int codigo;
                String nome;
                int ataque;
                int defesa;
                int tipo;

                System.out.println("Digite o codigo do robo: ");
                codigo = e.nextInt();
                e.nextLine();

                boolean codigoExiste = false;

                for (int i = 0; i < robos.size(); i++) {

                    if (robos.get(i).getCodigo() == codigo) {
                        codigoExiste = true;
                    }
                }

                while (codigo <= 0 || codigoExiste) {

                    if (codigo <= 0) {
                        System.out.println("Codigo invalido! Digite um codigo positivo: ");
                    } else {
                        System.out.println("Codigo ja cadastrado! Digite outro: ");
                    }

                    codigo = e.nextInt();
                    e.nextLine();

                    codigoExiste = false;

                    for (int i = 0; i < robos.size(); i++) {

                        if (robos.get(i).getCodigo() == codigo) {
                            codigoExiste = true;
                        }
                    }
                }

                System.out.println("Digite o nome do robo: ");
                nome = e.nextLine();

                while (nome.trim().isEmpty()) {

                    System.out.println("Nome nao pode ficar vazio!");
                    System.out.println("Digite o nome do robo: ");
                    nome = e.nextLine();
                }

                System.out.println("Digite o ataque (10 a 30): ");
                ataque = e.nextInt();

                while (ataque < 10 || ataque > 30) {

                    System.out.println("Ataque invalido! Digite entre 10 e 30: ");
                    ataque = e.nextInt();
                }

                System.out.println("Digite a defesa (0 a 20): ");
                defesa = e.nextInt();

                while (defesa < 0 || defesa > 20) {

                    System.out.println("Defesa invalida! Digite entre 0 e 20: ");
                    defesa = e.nextInt();
                }

                System.out.println("\nEscolha o tipo de robo:");
                System.out.println("1 - Ofensivo");
                System.out.println("2 - Defensivo");
                System.out.println("3 - Equilibrado");

                tipo = e.nextInt();

                while (tipo < 1 || tipo > 3) {

                    System.out.println("Tipo invalido! Escolha entre 1 e 3: ");
                    tipo = e.nextInt();
                }

                // Herança: cria um objeto de uma das subclasses de Robo.
                // Polimorfismo: a variável Robo pode receber qualquer uma delas.
                Robo novoRobo = null;

                if (tipo == 1) {

                    novoRobo = new RoboOfensivo(codigo, nome, ataque, defesa);

                } else if (tipo == 2) {

                    novoRobo = new RoboDefensivo(codigo, nome, ataque, defesa);

                } else if (tipo == 3) {

                    novoRobo = new RoboEquilibrado(codigo, nome, ataque, defesa);
                }

                robos.add(novoRobo);

                System.out.println("Robo cadastrado com sucesso!");

                e.nextLine();

            } else if (opcao == 2) {

                if (robos.isEmpty()) {

                    System.out.println("Nenhum robo cadastrado!");

                } else {

                    System.out.println("\n===== ROBOS CADASTRADOS =====");

                    for (int i = 0; i < robos.size(); i++) {

                        Robo robo = robos.get(i);

                        // Os getters acessam os atributos privados da classe Robo.
                        // Isso faz parte do encapsulamento.
                        System.out.println("Codigo: " + robo.getCodigo());
                        System.out.println("Nome: " + robo.getNome());
                        System.out.println("Tipo: " + robo.getTipo());
                        System.out.println("Ataque: " + robo.getAtaque());
                        System.out.println("Defesa: " + robo.getDefesa());
                        System.out.println("Energia: " + robo.getEnergia());
                        System.out.println("Vitorias: " + robo.getVitorias());
                        System.out.println("Derrotas: " + robo.getDerrotas());
                        System.out.println("Pontos: " + robo.getPontos());

                        if (robo.getEnergia() >= 30) {
                            System.out.println("Situacao: Disponivel");
                        } else {
                            System.out.println("Situacao: Em recuperacao");
                        }

                        System.out.println("-----------------------------");
                    }
                }

            } else if (opcao == 3) {

                if (robos.size() < 2) {

                    System.out.println("E necessario ter pelo menos dois robos cadastrados!");

                } else {

                    int codigo1;
                    int codigo2;

                    System.out.println("Digite o codigo do primeiro robo: ");
                    codigo1 = e.nextInt();

                    System.out.println("Digite o codigo do segundo robo: ");
                    codigo2 = e.nextInt();

                    Robo robo1 = null;
                    Robo robo2 = null;

                    for (int i = 0; i < robos.size(); i++) {

                        if (robos.get(i).getCodigo() == codigo1) {
                            robo1 = robos.get(i);
                        }

                        if (robos.get(i).getCodigo() == codigo2) {
                            robo2 = robos.get(i);
                        }
                    }

                    if (robo1 == null || robo2 == null) {

                        System.out.println("Um ou os dois robos nao foram encontrados!");

                    } else if (robo1 == robo2) {

                        System.out.println("Os robos precisam ser diferentes!");

                    } else if (robo1.getEnergia() < 30 || robo2.getEnergia() < 30) {

                        System.out.println("Os dois robos precisam ter pelo menos 30 de energia!");

                    } else {

                        realizarCombate(robo1, robo2);
                    }
                }

            } else if (opcao == 4) {

                System.out.println("Opcao ainda nao implementada!");

            } else if (opcao == 5) {

                System.out.println("Opcao ainda nao implementada!");

            } else if (opcao == 6) {

                System.out.println("Opcao ainda nao implementada!");

            } else if (opcao == 7) {

                System.out.println("Opcao ainda nao implementada!");

            } else if (opcao == 8) {

                System.out.println("Programa encerrado!");

            } else {

                System.out.println("Opcao invalida!");
            }
        }

        e.close();
    }

    public static void realizarCombate(Robo robo1, Robo robo2) {

        // O robo com menos pontos comeca.
        if (robo1.getPontos() > robo2.getPontos()) {

            Robo auxiliar = robo1;
            robo1 = robo2;
            robo2 = auxiliar;

        } else if (robo1.getPontos() == robo2.getPontos() &&
                   robo1.getCodigo() > robo2.getCodigo()) {

            Robo auxiliar = robo1;
            robo1 = robo2;
            robo2 = auxiliar;
        }

        System.out.println("\n===== COMBATE =====");
        System.out.println(robo1.getNome() + " comeca atacando!");

        boolean combateTerminou = false;

        for (int rodada = 1; rodada <= 5 && !combateTerminou; rodada++) {

            System.out.println("\n--- Rodada " + rodada + " ---");

            // Polimorfismo: o cálculo do dano utiliza o comportamento
            // correspondente ao tipo de cada robô.
            int dano = robo1.calcularDano(robo2, rodada);

            // O método receberDano altera a energia do robô.
            robo2.receberDano(dano);

            System.out.println(robo1.getNome() + " atacou " + robo2.getNome());
            System.out.println("Dano causado: " + dano);
            System.out.println("Energia de " + robo2.getNome() + ": " + robo2.getEnergia());

            if (robo2.getEnergia() == 0) {

                System.out.println(robo2.getNome() + " chegou a 0 de energia!");
                combateTerminou = true;

            } else {

                int danoSegundo = robo2.calcularDano(robo1, rodada);

                robo1.receberDano(danoSegundo);

                System.out.println(robo2.getNome() + " atacou " + robo1.getNome());
                System.out.println("Dano causado: " + danoSegundo);
                System.out.println("Energia de " + robo1.getNome() + ": " + robo1.getEnergia());

                if (robo1.getEnergia() == 0) {

                    System.out.println(robo1.getNome() + " chegou a 0 de energia!");
                    combateTerminou = true;
                }
            }
        }

        if (robo1.getEnergia() > robo2.getEnergia()) {

            robo1.registrarVitoria();
            robo2.registrarDerrota();

            System.out.println("\nVencedor: " + robo1.getNome());

        } else if (robo2.getEnergia() > robo1.getEnergia()) {

            robo2.registrarVitoria();
            robo1.registrarDerrota();

            System.out.println("\nVencedor: " + robo2.getNome());

        } else {

            robo1.registrarEmpate();
            robo2.registrarEmpate();

            System.out.println("\nResultado: EMPATE!");
        }
    }
}
