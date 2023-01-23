package br.com.escola.sistema;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Aluno aluno1 = new Aluno();
        Disciplina disciplina = new Disciplina();

        System.out.println("Olá Aluno! Bem vindo!");
        aluno1.setNomeAluno(JOptionPane.showInputDialog("Digite seu nome: "));
        aluno1.setNomeCurso(JOptionPane.showInputDialog("Digite o seu curso matriculado: "));
        aluno1.setMatricula(JOptionPane.showInputDialog("Digite a sua matrícula: "));
        aluno1.setPeriodoMatriculado(JOptionPane.showInputDialog("Insira o período em que está matriculado: "));


        for (int i = 1; i <= 4; i++) {
            String nomeDisciplina = JOptionPane.showInputDialog("Insira a disciplina " + i);
            String notaDisciplina = JOptionPane.showInputDialog("Insira a nota da disciplina " + nomeDisciplina);

            disciplina.setNome(nomeDisciplina);
            disciplina.setNotas(Double.valueOf(notaDisciplina));

            aluno1.getDisciplinas().add(disciplina);
        }

        System.out.println(aluno1.getDisciplinas());

        int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");
        if(escolha == 0) {

            int continuarRemover = 0; // A opção Sim é zero
            int posicao = 1;
            while (continuarRemover == 0) {
                String disciplinaRemover = JOptionPane.showInputDialog("Qual disciplina deseja remover? 1,2,3 ou 4");
                aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
                posicao++;
                continuarRemover = JOptionPane.showConfirmDialog(null, "Deseja continuar a remover?");
            }
        }

        System.out.println(aluno1);
        System.out.println("A média do aluno " + aluno1.getNomeAluno() + " é " + aluno1.calcularMedia());
        System.out.println("Resultado: " + aluno1.mostrarNovaAprovacao());
    }
}
