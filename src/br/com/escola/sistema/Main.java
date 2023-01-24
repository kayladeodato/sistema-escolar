package br.com.escola.sistema;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Aluno> alunos = new ArrayList<>();

        System.out.println("Olá Aluno! Bem vindo!");
        for (int i = 1; i <=2; i++) {


            String nome = JOptionPane.showInputDialog("Digite o nome do aluno " + i + ": ");
            //String curso = JOptionPane.showInputDialog("Digite o seu curso matriculado: ");
            //String matricula = JOptionPane.showInputDialog("Digite a sua matrícula: ");

            Aluno aluno = new Aluno();
            aluno.setNomeAluno(nome);
            //aluno.setNomeCurso(curso);
            //aluno.setMatricula(matricula);

            for (int j = 1; j <= 3; j++) {
                String nomeDisciplina = JOptionPane.showInputDialog("Insira a disciplina " + j);
                String notaDisciplina = JOptionPane.showInputDialog("Insira a nota da disciplina " + nomeDisciplina);

                Disciplina disciplina = new Disciplina();
                disciplina.setNome(nomeDisciplina);
                disciplina.setNotas(Double.valueOf(notaDisciplina));

                aluno.getDisciplinas().add(disciplina);
            }


            int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");
            if(escolha == 0) {

                int continuarRemover = 0; // A opção Sim é zero
                int posicao = 1;
                while (continuarRemover == 0) {
                    String disciplinaRemover = JOptionPane.showInputDialog("Qual disciplina deseja remover? 1,2,3 ou 4");
                    aluno.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
                    posicao++;
                    continuarRemover = JOptionPane.showConfirmDialog(null, "Deseja continuar a remover?");
                }
            }

            alunos.add(aluno);
        }

        for (Aluno estudante: alunos) {
            System.out.println(estudante);
            System.out.println("A média do aluno " + estudante.getNomeAluno() + " é " + estudante.calcularMedia());
            System.out.println("Resultado: " + estudante.mostrarNovaAprovacao());
            System.out.println("--------------------------------------------------------------------------");
        }
    }
}
