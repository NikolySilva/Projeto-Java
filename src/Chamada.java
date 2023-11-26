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

    