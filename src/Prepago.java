import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Prepago extends Assinantes {
    private Recarga[] recargas;
    private int numRecargas;
    private float credito;

    // Construtor
    public Prepago(long cpf, String nome, int numero) {
        super(cpf, nome, numero);
        this.recargas = new Recarga[100];
        this.numRecargas = 0;
        this.credito = 0;
    }
