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
    public void recarga(GregorianCalendar data, float valor) { // Corrigido o nome do método e vetor
        if (numRecargas < recargas.length) { // Corrigido o nome do vetor
            // Registra a recarga (supondo que exista uma classe Recarga)
            Recarga recarga = new Recarga(data, valor);
            recargas[numRecargas] = recarga; // Corrigido o nome do vetor
            numRecargas++;
            credito += valor;

            System.out.println("Recarga realizada com sucesso!");
        } else {
            System.out.println("Limite de recargas atingido.");
        }
    }

    // Método para imprimir a fatura
    public void imprimirFatura(int mes) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("CPF: " + cpf); // Corrigido o acesso ao CPF usando método getter
        System.out.println("Nome: " + nome); // Corrigido o acesso ao nome usando método getter
        System.out.println("Número: " + numero); // Corrigido o acesso ao número usando método getter

        System.out.println("Chamadas e recargas do mês " + mes + ":");

        // ... código para iterar sobre chamadas e recargas do mês e imprimir os detalhes ...

        System.out.println("Valor total de chamadas e recargas: " + calculaValorTotal());
        System.out.println("Créditos disponíveis: " + credito);
    }

    // Método auxiliar para calcular o valor total de chamadas e recargas
    private float calculaValorTotal() {
        float valorTotal = 0;

        // ... código para somar os valores de chamadas e recargas ...

        return valorTotal;
    }
}
