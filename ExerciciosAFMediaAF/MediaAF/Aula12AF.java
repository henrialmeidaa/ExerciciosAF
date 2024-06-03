package MediaAF;

import java.util.Scanner;

public class Aula12AF {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        double[] pesos = null;
        int numNotas = 0;
        int numAlunos = 0;

        System.out.print("Digite a quantidade de alunos: ");
        numAlunos = scn.nextInt();

        System.out.print("Digite a quantidade de notas para os alunos: ");
        numNotas = scn.nextInt();

        pesos = new double[numNotas];

        for (int i = 1; i <= numNotas; i++) {
            System.out.print("Digite o peso (em porcentagem) da nota número " + i + ": ");
            pesos[i - 1] = scn.nextInt();
        }

        for (int i = 1; i <= numAlunos; i++) {
            String nomeAluno = null;
            double mediaFinalAluno = 0.0;

            System.out.print("Digite o nome do aluno: ");
            nomeAluno = scn.next();

            for (int a = 1; a <= numNotas; a++) {
                double notaAluno = 0.0;
                do {
                    System.out.print("Digite a nota número " + a + ": ");
                    notaAluno = scn.nextDouble();
                } while (notaAluno < 0.0 || notaAluno > 10.0);

                mediaFinalAluno += notaAluno * (pesos[a - 1] / 100);
            }

            if (mediaFinalAluno >= 0 && mediaFinalAluno <= 2) {
                System.out.println(nomeAluno + " tirou " + mediaFinalAluno + " e esta Reprovado");
            } else if (mediaFinalAluno >= 2.1 && mediaFinalAluno <= 4.9) {
                System.out.println(nomeAluno + " tirou " + mediaFinalAluno + " e tera que fazer substitutiva");
            } else {
                System.out.println(nomeAluno + " tirou " + mediaFinalAluno + " e  esta Aprovado");
            }

        }

        scn.close();
    }
}