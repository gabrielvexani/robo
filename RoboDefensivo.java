
public class RoboDefensivo extends Robo {

    public RoboDefensivo(int codigo, String nome, int ataque, int defesa) {

        super(codigo, nome, ataque, defesa);
    }

    @Override
    public String getTipo() {
        return "Defensivo";
    }

    @Override
    protected int reduzirDanoRecebido(int dano) {

        dano -= 3;

        if (dano < 2) {
            dano = 2;
        }

        return dano;
    }
}
