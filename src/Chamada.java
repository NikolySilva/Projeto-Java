import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

//Declaramos as variáveis 
public class Chamada {
    private GregorianCalendar data;
    private int duracao;

    // Construtor
    public Chamada(GregorianCalendar data, int duracao) {
        this.data = data;
        this.duracao = duracao;
    }

    // Método para obter a data (função que vai retornar a data)

    public GregorianCalendar getData() {
        return data;
    }

    // Método para obter a duração (função que vai retornar a duração)
    public int getDuracao() {
        return duracao;
    }

    // Método para obter uma representação textual da chamada
    
@Override
public String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    return "Data: " + sdf.format(data.getTime()) + "\nDuracao: " + duracao + " minutos"; 
    //O código retorna uma string que combina a data formatada usando um objeto SimpleDateFormat chamado sdf e a duração (em minutos). 
    // A string resultante parece representar informações sobre uma data e sua duração, formatadas de maneira legível.
}
}