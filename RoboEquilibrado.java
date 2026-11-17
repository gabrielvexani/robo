
// Herança: RoboEquilibrado também herda da classe Robo.
public class RoboEquilibrado extends Robo {

    public RoboEquilibrado(int codigo, String nome, int ataque, int defesa) {
        super(codigo, nome, ataque, defesa);
    }

    // Polimorfismo: implementa a identificação do tipo equilibrado.
    @Override
    public String getTipo() {
        return "Equilibrado";
    }
}
