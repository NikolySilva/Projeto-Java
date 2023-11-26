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

  