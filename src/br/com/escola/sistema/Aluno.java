package br.com.escola.sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aluno {

    private String nomeAluno;
    private String matricula;
    private List<Disciplina> disciplinas = new ArrayList<>();
    private String nomeCurso;
    private String periodoMatriculado;

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getPeriodoMatriculado() {
        return periodoMatriculado;
    }

    public void setPeriodoMatriculado(String periodoMatriculado) {
        this.periodoMatriculado = periodoMatriculado;
    }

    public double calcularMedia() {
        double somaNotas = 0.0;
        for (Disciplina disciplina: disciplinas) {
            somaNotas += disciplina.getNotas();
        }

        return somaNotas / getDisciplinas().size();
    }

    public boolean mostrarAprovacao() {
        double media = this.calcularMedia();
        if (media >= 7) {
            return true;
        } else {
            return false;
        }
    }
    public String mostrarNovaAprovacao() {
        double media = this.calcularMedia();
        if (media >= 50) {
            if (media >= 70) {
                return "Aprovado.";
            } else {
                return "Recuperação.";
            }
        } else {
            return "Reprovado.";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(nomeAluno, aluno.nomeAluno) && Objects.equals(matricula, aluno.matricula) && Objects.equals(disciplinas, aluno.disciplinas) && Objects.equals(nomeCurso, aluno.nomeCurso) && Objects.equals(periodoMatriculado, aluno.periodoMatriculado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeAluno, matricula, disciplinas, nomeCurso, periodoMatriculado);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nomeAluno='" + nomeAluno + '\'' +
                ", matricula='" + matricula + '\'' +
                ", disciplinas=" + disciplinas +
                ", nomeCurso='" + nomeCurso + '\'' +
                ", periodoMatriculado='" + periodoMatriculado + '\'' +
                '}';
    }
}
