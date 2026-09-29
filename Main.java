import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner e = new Scanner(System.in);

        ArrayList<Robo> robos = new ArrayList<>();

        int opcao = 0;

        while (opcao != 8) {

            System.out.println("\n---- CAMPEONATO DE ROBOS ----");
            System.out.println("1 - Cadastrar robo");
            System.out.println("2 - Listar robos");
            System.out.println("3 - Realizar combate");
            System.out.println("4 - Recuperar energia");
            System.out.println("5 - Rodada geral");
            System.out.println("6 - Exibir classificacao");
            System.out.println("7 - Estatisticas");
            System.out.println("8 - Sair");
            System.out.println("Escolha uma opcao: ");

            opcao = e.nextInt();
            e.nextLine();

            if (opcao == 1) {

                int codigo;
                String nome;
                int ataque;
                int defesa;

                System.out.println("Digite o codigo do robo: ");
                codigo = e.nextInt();
                e.nextLine();

                boolean codigoExiste = false;

                for (int i = 0; i < robos.size(); i++) {

                    if (robos.get(i).codigo == codigo) {
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

                        if (robos.get(i).codigo == codigo) {
                            codigoExiste = true;
                        }
                    }
                }

                System.out.println("Digite o nome do robo: ");
                nome = e.nextLine();

                while (nome.isEmpty()) {

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

                Robo novoRobo = new Robo(codigo, nome, ataque, defesa);

                robos.add(novoRobo);

                System.out.println("Robo cadastrado com sucesso!");

            } else if (opcao == 2) {

                if (robos.isEmpty()) {

                    System.out.println("Nenhum robo cadastrado!");

                } else {

                    System.out.println("\n===== ROBOS CADASTRADOS =====");

                    for (int i = 0; i < robos.size(); i++) {

                        Robo robo = robos.get(i);

                        System.out.println("Codigo: " + robo.codigo);
                        System.out.println("Nome: " + robo.nome);
                        System.out.println("Ataque: " + robo.ataque);
                        System.out.println("Defesa: " + robo.defesa);
                        System.out.println("Energia: " + robo.energia);
                        System.out.println("Vitorias: " + robo.vitorias);
                        System.out.println("Derrotas: " + robo.derrotas);
                        System.out.println("Pontos: " + robo.pontos);

                        if (robo.energia >= 30) {
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

                        if (robos.get(i).codigo == codigo1) {
                            robo1 = robos.get(i);
                        }

                        if (robos.get(i).codigo == codigo2) {
                            robo2 = robos.get(i);
                        }
                    }

                    if (robo1 == null || robo2 == null) {

                        System.out.println("Um ou os dois robos nao foram encontrados!");

                    } else if (robo1 == robo2) {

                        System.out.println("Os robos precisam ser diferentes!");

                    } else if (robo1.energia < 30 || robo2.energia < 30) {

                        System.out.println("Os dois robos precisam ter pelo menos 30 de energia!");

                    } else {

                        Robo primeiro;
                        Robo segundo;

                        if (robo1.pontos < robo2.pontos) {

                            primeiro = robo1;
                            segundo = robo2;

                        } else if (robo2.pontos < robo1.pontos) {

                            primeiro = robo2;
                            segundo = robo1;

                        } else {

                            if (robo1.codigo < robo2.codigo) {
                                primeiro = robo1;
                                segundo = robo2;
                            } else {
                                primeiro = robo2;
                                segundo = robo1;
                            }
                        }

                        System.out.println("\n===== COMBATE =====");
                        System.out.println(primeiro.nome + " comeca atacando!");

                        boolean combateTerminou = false;

                        for (int rodada = 1; rodada <= 5 && !combateTerminou; rodada++) {

                            System.out.println("\n--- Rodada " + rodada + " ---");

                            int dano = primeiro.ataque - segundo.defesa;

                            if (dano < 5) {
                                dano = 5;
                            }

                            if (rodada % 2 == 0) {
                                dano += 5;
                            }

                            segundo.energia -= dano;

                            if (segundo.energia < 0) {
                                segundo.energia = 0;
                            }

                            System.out.println(primeiro.nome + " atacou " + segundo.nome);
                            System.out.println("Dano causado: " + dano);
                            System.out.println("Energia de " + segundo.nome + ": " + segundo.energia);

                            if (segundo.energia == 0) {

                                System.out.println(segundo.nome + " chegou a 0 de energia!");
                                combateTerminou = true;

                            } else {

                                int danoSegundo = segundo.ataque - primeiro.defesa;

                                if (danoSegundo < 5) {
                                    danoSegundo = 5;
                                }

                                if (rodada % 2 == 0) {
                                    danoSegundo += 5;
                                }

                                primeiro.energia -= danoSegundo;

                                if (primeiro.energia < 0) {
                                    primeiro.energia = 0;
                                }

                                System.out.println(segundo.nome + " atacou " + primeiro.nome);
                                System.out.println("Dano causado: " + danoSegundo);
                                System.out.println("Energia de " + primeiro.nome + ": " + primeiro.energia);

                                if (primeiro.energia == 0) {

                                    System.out.println(primeiro.nome + " chegou a 0 de energia!");
                                    combateTerminou = true;
                                }
                            }
                        }

                        if (primeiro.energia > segundo.energia) {

                            primeiro.vitorias++;
                            primeiro.pontos += 3;
                            segundo.derrotas++;

                            System.out.println("\nVencedor: " + primeiro.nome);

                        } else if (segundo.energia > primeiro.energia) {

                            segundo.vitorias++;
                            segundo.pontos += 3;
                            primeiro.derrotas++;

                            System.out.println("\nVencedor: " + segundo.nome);

                        } else {

                            primeiro.pontos++;
                            segundo.pontos++;

                            System.out.println("\nResultado: EMPATE!");
                        }
                    }
                }

            } else if (opcao == 8) {

                System.out.println("Programa encerrado!");

            } else {

                System.out.println("Opcao ainda nao implementada!");
            }
        }

        e.close();
    }
}