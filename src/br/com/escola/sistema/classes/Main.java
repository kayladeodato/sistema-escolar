package br.com.escola.sistema.classes;

import br.com.escola.sistema.constantes.StatusAluno;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Aluno> alunos = new ArrayList<>();
        HashMap<String, List<Aluno>> maps = new HashMap<>();

        System.out.println("Olá Aluno! Bem vindo!");
        for (int i = 1; i <=2; i++) {


            String nome = JOptionPane.showInputDialog("Digite o nome do aluno " + i + ": ");
            String curso = JOptionPane.showInputDialog("Digite o seu curso matriculado: ");
            String matricula = JOptionPane.showInputDialog("Digite a sua matrícula: ");

            Aluno aluno = new Aluno();
            aluno.setNomeAluno(nome);
            aluno.setNomeCurso(curso);
            aluno.setMatricula(matricula);

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

            maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
            maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
            maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());

            for (Aluno aluno1 : alunos) {
                if (aluno.mostrarNovaAprovacao().equalsIgnoreCase(StatusAluno.APROVADO)) {
                    maps.get(StatusAluno.APROVADO).add(aluno1);
                } else if (aluno.mostrarNovaAprovacao().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
                    maps.get(StatusAluno.RECUPERACAO).add(aluno1);
                } else if (aluno.mostrarNovaAprovacao().equalsIgnoreCase(StatusAluno.REPROVADO)) {
                    maps.get(StatusAluno.REPROVADO).add(aluno1);
                }
            }
        }

        for (int i = 0; i < alunos.size(); i++) {
            Aluno aluno = alunos.get(i);

            System.out.println("=============== Boletim ===============");
            System.out.println("Aluno = " + aluno.getNomeAluno());
            System.out.println("Curso = " + aluno.getNomeCurso());
            System.out.println("Matrícula = " + aluno.getMatricula());

            for (int j = 0; j < aluno.getDisciplinas().size(); j++) {
                Disciplina disciplina = aluno.getDisciplinas().get(j);
                System.out.println(disciplina.getNome() + " Nota = " + disciplina.getNotas());
            }

            System.out.printf("A média do aluno =  %.2f\n", aluno.calcularMedia());
            System.out.println("Resultado: " + aluno.mostrarNovaAprovacao());
        }

        System.out.println("---------------- Lista de Aprovados ----------------");
        for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
            System.out.println("Resultado = " + aluno.getNomeAluno() + " " + aluno.mostrarNovaAprovacao() + " com média " + aluno.calcularMedia());
        }

        System.out.println("---------------- Lista em Recuperação ----------------");
        for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
            System.out.println("Resultado = " + aluno.getNomeAluno() + " " + aluno.mostrarNovaAprovacao() + " com média " + aluno.calcularMedia());
        }

        System.out.println("---------------- Lista de Reprovados ----------------");
        for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
            System.out.println("Resultado = " + aluno.getNomeAluno() + " " + aluno.mostrarNovaAprovacao() + " com média " + aluno.calcularMedia());
        }

    }
}
