
// Herança: RoboDefensivo herda as características da classe Robo.
public class RoboDefensivo extends Robo {

    public RoboDefensivo(int codigo, String nome, int ataque, int defesa) {
        super(codigo, nome, ataque, defesa);
    }

    // Polimorfismo: informa que o robô é do tipo defensivo.
    @Override
    public String getTipo() {
        return "Defensivo";
    }

    // Polimorfismo: reduz o dano recebido em 3 pontos.
    @Override
    protected int reduzirDanoRecebido(int dano) {
        dano -= 3;

        if (dano < 2) {
            dano = 2;
        }

        return dano;
    }
}
