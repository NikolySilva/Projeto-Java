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

    // Método para imprimir a fatura
    public void imprimirFaturas(int mes) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Dados do assinante:");
        // ... código para imprimir dados do assinante ...

        System.out.println("Chamadas do mês " + mes + ":");

        // ... código para iterar sobre chamadas do mês e imprimir os detalhes ...

        float valorTotalFatura = calculaValorTotalFatura();
        System.out.println("Valor total da fatura: R$ " + (assinatura + valorTotalFatura));
    }

    // Método auxiliar para calcular o valor total das chamadas
    private float calculaValorTotalFatura() {
        float valorTotalFatura = 0;

        for (int i = 0; i < numChamadas; i++) {
            valorTotalFatura += chamadas[i].getDuracao() * 1.04f;
        }

        return valorTotalFatura;
    }
}