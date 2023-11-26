import java.util.GregorianCalendar;
import java.util.Scanner;

public class Telefonia {
    private Prepago[] prepagos;
    private int numPrePagos;
    private Pospago[] pospagos;
    private int numPosPagos;
    Scanner entrada = new Scanner(System.in);

    public Telefonia() {
        prepagos = new Prepago[10];
        numPrePagos = 0;
        pospagos = new Pospago[10];
        numPosPagos = 0;
    }


    public void registrarAssinantes() {
        String nome;
        long cpf;
        int opcao, numCelular;

        // solicitar assinante
        do {
            System.out.println("\nAssinaturas: ");
            System.out.println("1- Pré-pago \n2- Pós-pago");
            System.out.print("Opção desejada: ");
            opcao = entrada.nextInt();
        } while (opcao != 1 && opcao != 2); 

        // conferir o cadastro
        if (opcao == 1 && numPrePagos >= prepagos.length) {
            System.out.println("Não foi possivel realizar a execução do cadastro do assinante pré-pago."); 
           
        } else if (opcao == 2 && numPosPagos >= pospagos.length) {
            System.out.println("Não foi possivel realizar a execução do cadastro do assinante pós-pago.");
        } else {
            // solicitar os dados do assinante
            System.out.print("\nNome: ");
            nome = entrada.next();
            System.out.print("CPF: ");
            cpf = entrada.nextLong();
            System.out.print("Número de telefone: ");
            numCelular = entrada.nextInt();

            if (opcao == 1) { 
                prepagos[numPrePagos] = new Prepago(cpf, nome, numCelular);

                // adicionar o número de assinantes cadastrados 
                this.numPrePagos++;

                System.out.println("Cadastro concluído com sucesso!\n");
            } else {
                float assinatura;
                System.out.print("Valor total da assinatura: ");
                assinatura = entrada.nextFloat();

                pospagos[numPosPagos] = new Pospago(cpf, nome, numCelular, assinatura);

                // adicionar o número de assinantes cadastrados 
                this.numPosPagos++;

                System.out.println("Cadastro concluído com sucesso!.\n");
            }
        }
    }


    public void addPrepago(Prepago prepago) {
        if (numPrePagos < prepagos.length) {
            prepagos[numPrePagos++] = prepago;
        } else {
            System.out.println("Tamanho de assinantes pré-pagos atingido.");
        }
    }

    public void addPospago(Pospago pospago) {
        if (numPosPagos < pospagos.length) {
            pospagos[numPosPagos++] = pospago;
        } else {
            System.out.println("Tamanho de assinantes pós-pagos atingido.");
        }
    }

    // Método para registrar assinante pré-pago
    private void registraPrepago(String nome, long cpf, int numCelular) {
        // Criar e adicionar o assinante pré-pago
        Prepago prepago = new Prepago(cpf, nome, numCelular);
        addPrepago(prepago);
        System.out.println("Assinante pré-pago cadastrado.");
    }

    // Método para registrar assinante pós-pago
    private void registraPospago(String nome, long cpf, int numCelular) {


        // Criar e adicionar o assinante pós-pago
        Pospago pospago = new Pospago(cpf, nome, numCelular, numCelular);
        addPospago(pospago);
        System.out.println("Assinante pós-pago cadastrado.");
    }


    public void listaAssinantes() {
        if (this.numPrePagos > 0) {
            System.out.println("Assinantes pré-pago: ");

            for (int i = 0; i < this.numPrePagos; i++) {
                System.out.println((i + 1) + " - " + this.prepagos[i].toString() + ";\n");
            }
        } else {
            System.out.println("Assinantes pré-pago inexistentes.\n");
        }

        // lista de assinantes pos pagos
        if (this.numPosPagos > 0) {
            System.out.println("\nAssinantes pos-pago: ");

            for (int i = 0; i < this.numPosPagos; i++) {
                System.out.println((i + 1) + " - " + this.pospagos[i].toString() + ";\n");
            }
        } else {
            System.out.println("Assinantes pós-pago inexistentes.\n");
        }

    }

    public Prepago localizaPrepago(long cpf) {
        for (int i = 0; i < numPrePagos; i++) {
            if (prepagos[i].getCpf() == cpf) {
                return prepagos[i];
            }
        }
        return null; // Retorna null se não encontrar o assinante pré-pago com o CPF cadastrado
    }

    public Pospago localizaPospago(long cpf) {
        for (int i = 0; i < numPosPagos; i++) {
            if (pospagos[i].getCpf() == cpf) {
                return pospagos[i];
            }
        }
        return null; // Retorna null se não encontrar o assinante pós-pago com o CPF cadastrado
    }





    public void fazRecarga() {

        GregorianCalendar data = new GregorianCalendar();
        float valor;
        long cpf;

        // solicitar cpf
        System.out.println("\nCPF: ");
        cpf = entrada.nextLong();

        // procura assinante
        if (this.localizaPrepago(cpf) != null) {
            System.out.println("Digite a data da recarga");
            data = retornaData();
            do {
                System.out.println("\nDigite o valor da recarga: ");
                valor = entrada.nextFloat();
            } while (valor <= 0);

            // fazer chamada pre-paga
            Prepago localizado = this.localizaPrepago(cpf);
            localizado.recarga(data, valor);
        } else { // se nao encontrar...
            // ...exibir mensagem "não encontrado"
            System.out.println("Assinante pré-pago'" + cpf + "' não encontrado");
        }
    }


    public GregorianCalendar retornaData() {
        int data, mes, ano;
        boolean validade;

        do {

            // solicitar o dia até que o usuário insira um valor válido
            do {
                System.out.print("Dia: ");
                data = entrada.nextInt();
            } while (data < 1 || data > 31);

            // método de exibir e solicitar mês
            mes = mostrarMes();

            // verificar se data dia/mes é válida
            if (((mes == 4 || mes == 6 || mes == 9 || mes == 11) && data > 30) || (mes == 2 && data > 28)) {
                validade = false;
                System.out.println("Data " + data + "/" + mes + " inválida!");
                System.out.println("Insira novamente a data.\n");
            } else {
                validade = true;
            }
        } while (validade == false); // enquanto dia/mes for invalido, solicitar novamente

        // solicitar um ano até o usuário digitar corretamente
        do {
            System.out.print("Ano: ");
            ano = entrada.nextInt();
        } while (ano < 1877 || String.valueOf(ano).length() != 4); 

        GregorianCalendar calendario = new GregorianCalendar(ano, mes - 1, data);
        return calendario;
    }

    public int mostrarMes() {
        System.out.println("1 - Janeiro");
        System.out.println("2 - Fevereiro");
        System.out.println("3 - Março");
        System.out.println("4 - Abril");
        System.out.println("5 - Maio");
        System.out.println("6 - Junho");
        System.out.println("7 - Julho");
        System.out.println("8 - Agosto");
        System.out.println("9 - Setembro");
        System.out.println("10 - Outubro");
        System.out.println("11 - Novembro");
        System.out.println("12 - Dezembro\n");

        int resposta;

        do {
            System.out.print("Mês: ");
            resposta = entrada.nextInt();
        } while (resposta < 1 || resposta > 12); 

        return resposta;
    }



    public void fazerChamada() {

        int opcao, duracao;
        long cpf;

        System.out.println("\nAssinaturas");
        System.out.println("1- Pré-pago \n2- Pós-pago");

        // solicitar tipo de assinante
        do {
            System.out.print("Digite a opção: ");
            opcao = entrada.nextInt();
        } while (opcao != 1 && opcao != 2); // repete até que o usuário insira um valor correto

        System.out.println("\nCPF: ");
        cpf = entrada.nextLong();

        // procura assinante
        if (opcao == 1 && this.localizaPrepago(cpf) != null) {

            System.out.println("Digite a duração da chamada: ");
            duracao = entrada.nextInt();
            System.out.println("Digite a data da chamada");
            GregorianCalendar dateFuncao =  retornaData();

            // fazer chamada pre-paga
            Prepago localizado = this.localizaPrepago(cpf);
            localizado.fazerChamada(dateFuncao, duracao);

        } else if (opcao == 2 && this.localizaPospago(cpf) != null) {

            System.out.println("Digite a duração da chamada: ");
            duracao = entrada.nextInt();
            System.out.println("Digite a data da chamada");
            GregorianCalendar dateFuncao = retornaData();

            // fazer chamada pos-paga
            Pospago localizado = this.localizaPospago(cpf);
            localizado.fazerChamada(dateFuncao, duracao);

        } else { // se nao encontrar...
            // ...exibir mensagem "não encontrado"
            System.out.println("Assinante '" + cpf + "' não encontrado!\n");
        }

    }


    private void imprimirFatura() {
        int mes = mostrarMes();

        System.out.println("\nFaturas");
        // pre pagos
        System.out.println("\nPre Pago: ");

        if (this.numPrePagos > 0) {
            for (int i = 0; i < this.numPrePagos; i++) {
                // exibir metodo imprimirFatura 
                this.prepagos[i].imprimirFatura(mes);
            }
        } else {
            System.out.println("Assinantes pré-pago inexistentes.\n");
        }

        // pos pagos
        System.out.println("Pos Pago: ");

        if (numPosPagos > 0) {
            for (int i = 0; i < numPosPagos; i++) {
                // exibir método imprimirFatura 
                this.pospagos[i].imprimirFatura(mes);
            }
        } else {
            System.out.println("Assinantes pós-pago inexistentes.");
        }
    }




    public static void main(String[] args) {

        // declarar um objeto da classe telefonia
        Telefonia tel = new Telefonia();

        try (Scanner entrada = new Scanner(System.in)) {
            int op;
            do {
                System.out.println("\n\n==========MENU==========");
                System.out.println("1- Cadastrar assinante");
                System.out.println("2- Listar assinantes");
                System.out.println("3- Fazer chamada");
                System.out.println("4- Fazer recarga");
                System.out.println("5- Imprimir faturas");
                System.out.println("6- Fechar o programa \n");

                System.out.print("Opção: ");
                op = entrada.nextInt();

                // chamar o método que o usuário escolher
                switch (op) {
                    case 1:
                        tel.registrarAssinantes();
                        break;
                    case 2:
                        tel.listaAssinantes();
                        break;
                    case 3:
                        tel.fazerChamada();
                        break;
                    case 4:
                        tel.fazRecarga();
                        break;
                    case 5:
                        tel.imprimirFatura();
                        break;
                    case 6:
                        System.out.println("Encerrando sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida!\n");
                        break;
                }

            } while (op != 6); 
        }
    }
}