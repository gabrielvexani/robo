
// Classe abstrata que representa os robôs.
// Encapsulamento: os atributos são privados e acessados por métodos.
public abstract class Robo {

    private int codigo;
    private String nome;
    private int ataque;
    private int defesa;
    private int energia;
    private int vitorias;
    private int derrotas;
    private int pontos;

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

    // Métodos getters: permitem consultar os atributos privados.
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getEnergia() {
        return energia;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getPontos() {
        return pontos;
    }

    // Cada subclasse informa seu próprio tipo de robô.
    public abstract String getTipo();

    // Métodos protegidos que podem ser modificados pelas subclasses.
    protected int modificarAtaque() {
        return ataque;
    }

    protected int reduzirDanoRecebido(int dano) {
        return dano;
    }

    // Polimorfismo: os métodos das subclasses são chamados
    // dependendo do tipo de robô envolvido no combate.
    public int calcularDano(Robo alvo, int rodada) {

        int dano = modificarAtaque() - alvo.getDefesa();

        if (dano < 5) {
            dano = 5;
        }

        if (rodada % 2 == 0) {
            dano += 5;
        }

        dano = alvo.reduzirDanoRecebido(dano);

        return dano;
    }

    public void receberDano(int dano) {

        energia -= dano;

        if (energia < 0) {
            energia = 0;
        }
    }

    public void registrarVitoria() {
        vitorias++;
        pontos += 3;
    }

    public void registrarDerrota() {
        derrotas++;
    }

    public void registrarEmpate() {
        pontos++;
    }
}
