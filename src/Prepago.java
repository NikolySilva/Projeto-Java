import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class Prepago extends Assinantes {
    private Chamada[] chamadas;
    private Recarga[] recargas;
    private int numRecargas;
    private float credito;
    public int totaldeChamadas;

    // Construtor
    public Prepago(long cpf, String nome, int numCelular) {
        super(cpf, nome, numCelular);
        this.recargas = new Recarga[2];
        this.chamadas = new Chamada[10];
        this.numRecargas = 0;

    }

    // Método para registrar uma chamada
    public float fazerChamada(GregorianCalendar data, int duracao) {
        float custodaChamada = 1.45f * duracao;

        if (this.numChamadas >= this.chamadas.length){
            System.out.println("Não há espaço para novas chamadas.");
            return 0f;
        }

        if (custodaChamada > this.credito) {
            System.out.println("Saldo insuficiente para realizar a chamada chamada.");
            System.out.println("Recarregue seu pré-pago.");
            return 0f;
        }

        for (int i = 0; i <= this.numChamadas; i++){
            if (this.chamadas[i] == null){
                Chamada chamada = new Chamada(data, duracao);
                this.chamadas[i] = chamada;
                this.credito -= custodaChamada;
                System.out.println("Chamada feita com sucesso");
            }
        }
        this.numChamadas++;
        return 1f;
    }

    // Método para salvar uma recarga 

    public void recarga(GregorianCalendar data, float valor) {
        if (numRecargas >= this.recargas.length) {
            System.out.println("Espaço insuficiente para recargas novas");
        }
        else {

            for (int i = 0; i <= numRecargas; i++){
                if (recargas[i] == null){
                    Recarga recarga = new Recarga(data, valor);
                    this.recargas[i] = recarga;
                    this.credito += valor;
                    System.out.println("Recarga realizada com sucesso");
                }

            }

            this.numRecargas++;
        }

    }

    // Método para imprimir a fatura
    
    public void imprimirFatura(int mes) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        float valortotalRecargas = 0;
        float valortotalChamadas = 0;

        System.out.println("DADOS DO ASSINANTE: " + this.toString());
        if(this.numChamadas <= 0){
            System.out.println("Não houveram chamadas");
        } else {
            System.out.println("Dados da chamada:");
            for(int j = 0; j <= this.numChamadas; j++){
                if (this.chamadas[j] != null && this.chamadas[j].getData().get(GregorianCalendar.MONTH) == (mes - 1)) {
                    System.out.println("Data: " + sdf.format(this.chamadas[j].getData().getTime()));
                    System.out.println("Duração: " + this.chamadas[j].getDuracao());
                    System.out.println("Custo: " + this.chamadas[j].getDuracao() * 1.45);
                    valortotalChamadas+=this.chamadas[j].getDuracao()  * 1.45f;
                }
            }
            System.out.println("Valor total das chamadas no mês de " + getMes(mes) + ": R$" + valortotalChamadas);
        }

        if(this.numRecargas <= 0){
            System.out.println("Recargas inexistentes.");
        } else {
            System.out.println("\n========== DADOS RECARGA ==========");
            for(int k = 0; k <= this.numRecargas; k++){
                if (this.recargas[k] != null && this.recargas[k].getData().get(GregorianCalendar.MONTH) == (mes - 1)) {
                    System.out.println("\nData da recarga: " + sdf.format(this.recargas[k].getData().getTime()));
                    System.out.println("Valor da recarga: " + this.recargas[k].getValor());
                    valortotalRecargas+=this.recargas[k].getValor();
                }
            }
            System.out.println("Valor total de recargas no mês de " + getMes(mes) + ": R$" + valortotalRecargas);
        }

    }
    public String getMes(int opcao){
        switch(opcao) {
            case 1: return "Janeiro";
            case 2: return "Fevereiro";
            case 3: return "Março";
            case 4: return "Abril";
            case 5: return "Maio";
            case 6: return "Junho";
            case 7: return "Julho";
            case 8: return "Agosto";
            case 9: return "Setembro";
            case 10: return "Outubro";
            case 11: return "Novembro";
            case 12: return "Dezembro";
            default: return "Inválido";
        }
    }
}
