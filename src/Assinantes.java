// declarando variáveis
public class Assinantes {
    private long cpf;
    private String nome;
    private int numCelular;
    protected int numChamadas;
    protected Chamada[] chamadas;

    // Construtor
    public Assinantes(long cpf, String nome, int numero) {
        this.cpf = cpf;
        this.nome = nome;
        this.numCelular = numCelular;
        this.chamadas = new Chamada[10];
        this.numChamadas = 0;
    }

    // Pegando o CPF
 public Long getCpf() {
        return cpf;
}
 
 public String getNome(){
    return nome;
 }

 public int getnumCelular(){
    return numCelular;
 }
    //Retorna os resultados de uma forma mais legível

   @Override
 public String toString() {
      return "CPF: " + cpf + "\nNome: " + nome + "\nnumero: " + numCelular  + "\nchamadas: " + numChamadas;
   }
}