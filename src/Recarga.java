import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Recarga {
    private GregorianCalendar data;
    private float valor;

    //Construtor da Classe
    public Recarga(GregorianCalendar data, float valor) {
        this.data = data;
        this.valor = valor;
    }

    // getters e setters
    public GregorianCalendar getData() {
        return data;
    }

    public float getValor() {
        return valor;
    }

    // Método toString para representação textual
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Data: " + sdf.format(data.getTime()) + "\nValor: R$ " + valor;
    }
}
