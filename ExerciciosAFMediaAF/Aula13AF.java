
import java.util.Scanner;

public class Aula13AF {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        double[] pesosNotas = null;
        String[] nomesAlunos = null;
        double[][] notasAlunos = null;
        int numNotas = 0;
        int numAlunos = 0;

        System.out.print("Digite a quantidade de alunos: ");
        numAlunos = scn.nextInt();

        nomesAlunos = new String[numAlunos];
        notasAlunos = new double[numAlunos][];

        System.out.print("Digite a quantidade de notas para os alunos: ");
        numNotas = scn.nextInt();

        pesosNotas = new double[numNotas];

        for (int i = 1; i <= numNotas; i++) {
            System.out.print("Digite o peso (em porcentagem) da nota número " + i + ": ");
            pesosNotas[i - 1] = scn.nextInt();
        }

        for (int i = 1; i <= numAlunos; i++) {
            double mediaFinalAluno = 0.0;

            System.out.print("Digite o nome do aluno: ");
            nomesAlunos[i - 1] = scn.next();

            for (int a = 1; a <= numNotas; a++) {
                double notaAluno = 0.0;
                do {
                    System.out.print("Digite a nota número " + a + ": ");
                    notaAluno = scn.nextDouble();
                } while (notaAluno < 0.0 || notaAluno > 10.0);

                if (notasAlunos[i - 1] == null) {
                    notasAlunos[i - 1] = new double[numNotas];
                }

                notasAlunos[i - 1][a - 1] = notaAluno;
            }
        }

        boolean encerrar = false;

        do {
            int opcao = 0;

            do {
                System.out.println("Digite 1 para consultar os dados de um aluno;");
                System.out.println("Digite 2 para encerrar o programa.");

                opcao = scn.nextInt();
            } while (opcao < 1 || opcao > 2);

            if (opcao == 1) {
                String nomePesquisadoAluno = null;
                boolean alunoEncontrado = false;
                int numAluno = 0;

                do {
                    System.out.print("Digite o nome do aluno para pesquisar:");

                    nomePesquisadoAluno = scn.next();

                    for (int i = 0; i < numAlunos; i++) {
                        if (nomePesquisadoAluno.equalsIgnoreCase(nomesAlunos[i])) {
                            numAluno = i;
                            alunoEncontrado = true;
                        }
                    }

                    if (!alunoEncontrado) {
                        System.out.println("Nenhum aluno foi encontrado com esse nome.");
                    }
                } while (!alunoEncontrado);

                double mediaFinalAluno = 0.0;

                System.out.println("Nome do aluno: " + nomesAlunos[numAluno]);

                for (int i = 0; i < numNotas; i++) {
                    System.out.println("Nota " + i + ": " + notasAlunos[numAluno][i]);
                    mediaFinalAluno += notasAlunos[numAluno][i] * (pesosNotas[i] / 100);
                }

                System.out.println("Média final: " + mediaFinalAluno);

                if (mediaFinalAluno >= 0 && mediaFinalAluno <= 2) {
                    System.out.println("Status: Reprovado");
                } else if (mediaFinalAluno >= 2.1 && mediaFinalAluno <= 4.9) {
                    System.out.println("Status: Substitutiva");
                } else {
                    System.out.println("Status: Aprovado");
                }

            } else {
                encerrar = true;
            }
        } while (!encerrar);

        scn.close();
    }
}