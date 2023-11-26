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

    // Método para registrar uma chamada
    public void fazerChamada(GregorianCalendar data, int duracao) {
        float custoChamada = 1.45f * duracao;

        if (credito >= custoChamada) {
            credito -= custoChamada;

            // Registra a chamada (supondo que exista uma classe Call)
            Chamada chamada = new Chamada(data, duracao);
            // ... código para adicionar chamada ao vetor de chamadas ...

            System.out.println("Chamada realizada com sucesso!");
        } else {
            System.out.println("Créditos insuficientes para fazer a chamada.");
        }
    }

    // Método para registrar uma recarga
    public void recarga(GregorianCalendar date, float value) { // Corrigido o nome do método e vetor
        if (numRecargas < recargas.length) { // Corrigido o nome do vetor
            // Registra a recarga (supondo que exista uma classe Recarga)
            Recarga recarga = new Recarga(date, value);
            recargas[numRecargas] = recarga; // Corrigido o nome do vetor
            numRecargas++;
            credito += value;

            System.out.println("Recarga realizada com sucesso!");
        } else {
            System.out.println("Limite de recargas atingido.");
        }
    }
