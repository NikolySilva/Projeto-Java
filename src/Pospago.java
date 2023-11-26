import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Pospago extends Assinantes{
    private float assinatura;
    private Chamada[] chamadas;
    private int numChamadas;

    // Construtor
    public Pospago(long cpf, String nome, int numero,float assinatura) {
        super(cpf, nome, numero);
        this.assinatura = assinatura;
        this.chamadas = new Chamada[100]; // Tamanho arbitrário para o vetor de chamadas
        this.numChamadas = 0;
    }

    // Método para registrar uma chamada
    public void fazerChamada(GregorianCalendar data, int duracao) {
        float custoChamada = 1.04f * duracao;

        if (numChamadas < chamadas.length) {
            // Registra a chamada (supondo que exista uma classe Chamada)
            Chamada chamada = new Chamada(data, duracao);
            chamadas[numChamadas] = chamada;
            numChamadas++;

            System.out.println("Chamada realizada com sucesso!");
        } else {
            System.out.println("Limite de chamadas atingido. Não foi possível realizar a chamada.");
        }
    }
