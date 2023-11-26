import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Pospago extends Assinantes{
    
    private float assinatura;


    // Construtor
    public Pospago(long cpf, String nome, int numCelular, float assinatura) {
        super(cpf, nome, numCelular);
        this.assinatura = assinatura;
    }
    public float getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(float assinatura) {
        this.assinatura = assinatura;
    }

    public void fazerChamada(GregorianCalendar data, int duracao) {
        if (this.chamadas.length == this.numChamadas) {
            System.out.println("A execução da chamada não esta disponível.");
        } else {
            for (int i = 0; i <= numChamadas; i++) {
                if (this.chamadas[i] == null) {
                    this.chamadas[i] = new Chamada(data, duracao);
                }
            }
            this.numChamadas++;
            System.out.println("Execução da chamada concluída com sucesso!");
        }
    }

    public void imprimirFatura(int mes) {

        float total = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Dados do assinante: " + this.toString());
        System.out.println("Valor total da assinatura: " + this.assinatura);

        if (this.numChamadas <= 0) {
            System.out.println("Chamadas Inexistentes.");
        } else {
            System.out.println("Dados da chamada:");
            for (int i = 0; i < this.numChamadas; i++) {
                if (this.chamadas[i] != null && this.chamadas[i].getData().get(GregorianCalendar.MONTH) == mes - 1) {
                    System.out.println("Data da chamada: " + sdf.format(this.chamadas[i].getData().getTime()));
                    System.out.println("Duração: " + this.chamadas[i].getDuracao() + " minutos;");
                    System.out.println("Valor: R$" + this.chamadas[i].getDuracao() * 1.45);
                    total += this.chamadas[i].getDuracao() * 1.45;
                }
            }

            System.out.println("\nValor total das chamadas: R$" + total);

            total += this.assinatura;
            System.out.println("\nValor total da fatura no mês de " + getMes(mes) + ": R$" + total);
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
            default: return "Mês inválido";
        }
    }
}