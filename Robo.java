public class Robo {

    int codigo;
    String nome;
    int ataque;
    int defesa;
    int energia;
    int vitorias;
    int derrotas;
    int pontos;

    public Robo(int codigo, String nome, int ataque, int defesa) {

        this.codigo = codigo;
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;

        energia = 100;
        vitorias = 0;
        derrotas = 0;
        pontos = 0;
    }

    void receberDano(int dano) {

        energia -= dano;

        if (energia < 0) {
            energia = 0;
        }
    }

    void recuperarEnergia(int quantidade) {

        energia += quantidade;

        if (energia > 100) {
            energia = 100;
        }
    }

    void registrarVitoria() {

        vitorias++;
        pontos += 3;
    }

    void registrarDerrota() {

        derrotas++;
    }

    void registrarEmpate() {

        pontos++;
    }
}