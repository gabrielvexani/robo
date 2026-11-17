
// Herança: RoboOfensivo herda os atributos e métodos da classe Robo.
public class RoboOfensivo extends Robo {

    public RoboOfensivo(int codigo, String nome, int ataque, int defesa) {
        super(codigo, nome, ataque, defesa);
    }

    // Polimorfismo: implementa o método abstrato da classe Robo.
    @Override
    public String getTipo() {
        return "Ofensivo";
    }

    // Polimorfismo: aumenta o ataque original em 5 pontos.
    @Override
    protected int modificarAtaque() {
        return getAtaque() + 5;
    }
}
