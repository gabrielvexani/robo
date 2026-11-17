# Campeonato de Robôs

Projeto desenvolvido em Java para a disciplina de Programação Orientada a Objetos (POO).

## Sobre o projeto

O projeto consiste em um sistema de campeonato de robôs de combate. O programa funciona pelo terminal e permite cadastrar robôs, visualizar os robôs cadastrados e realizar combates entre eles.

## Funcionalidades

Atualmente o projeto possui:

- Cadastro de robôs
- Listagem dos robôs cadastrados
- Realização de combates entre dois robôs
- Escolha do tipo de robô
- Sistema de energia
- Sistema de ataque e defesa
- Contagem de vitórias, derrotas e pontos
- Definição de quem começa o combate
- Combate com até 5 rodadas

As opções de recuperação de energia, rodada geral, classificação e estatísticas aparecem no menu, mas ainda não foram implementadas.

## Tipos de robôs

O projeto possui três tipos de robôs:

- **RoboOfensivo:** possui bônus de ataque.
- **RoboDefensivo:** recebe menos dano dos adversários.
- **RoboEquilibrado:** não possui modificadores de ataque ou defesa.

## Estrutura do projeto

```text
Robo
│
├── Main.java
├── Robo.java
├── RoboOfensivo.java
├── RoboDefensivo.java
├── RoboEquilibrado.java
├── README.md
└── .gitignore
```

## Tecnologias utilizadas

- Java
- Visual Studio Code
- Programação Orientada a Objetos

## Como executar

1. Abrir a pasta do projeto no Visual Studio Code.
2. Abrir o terminal.
3. Compilar os arquivos:

```bash
javac *.java
```

4. Executar o programa:

```bash
java Main
```