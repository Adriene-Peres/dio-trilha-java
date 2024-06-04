package main.java.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunos;

    public GerenciadorAlunos() {
        this.alunos = new HashSet<>();
    }
    public void adicionarAluno(String nome, Long matricula, double nota){
        alunos.add(new Aluno(nome, matricula, nota));
    }

    public void removerAlunoPorMatricula(long matricula){
        Aluno alunoParaRemover = null;
        if (!alunos.isEmpty()){
            for(Aluno a: alunos){
                if(a.getMatricula() == matricula){
                    alunoParaRemover = a;
                    break;
                }
            }
            alunos.remove(alunoParaRemover);
        }else{
            System.out.println("O conjunto está vazio!");
        }

        if(alunoParaRemover == null){
            System.out.println("Matricula não encontrada!");
        }
    }

    public void exibirAlunosPorNome(){
        Set<Aluno> alunosPorNome = new TreeSet<>(alunos);
        if (!alunos.isEmpty()){
            System.out.println(alunosPorNome);
        }else{
            System.out.println("O conjunto está vazio!");
        }
    }

    public void exibirAlunosPorNota(){
        Set<Aluno> alunosPorNota = new TreeSet<>(new ComparatorNota());
        if (!alunos.isEmpty()){
            alunosPorNota.addAll(alunos);
            System.out.println(alunosPorNota);
        }else{
            System.out.println("O conjunto está vazio!");
        }
    }

    public void exibirAlunos(){
        if (!alunos.isEmpty()){
            System.out.println(alunos);
        }else{
            System.out.println("O conjunto está vazio!");
        }
    }

    public static void main(String[] args) {
        // Criando uma instância do GerenciadorAlunos
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        // Adicionando alunos ao gerenciador
        gerenciadorAlunos.adicionarAluno("João", 123456L, 7.5);
        gerenciadorAlunos.adicionarAluno("Maria", 123457L, 9.0);
        gerenciadorAlunos.adicionarAluno("Carlos", 123458L, 5.0);
        gerenciadorAlunos.adicionarAluno("Ana", 123459L, 6.8);

        // Exibindo todos os alunos no gerenciador
        System.out.println("Alunos no gerenciador:");
        gerenciadorAlunos.exibirAlunos();

        // Removendo um aluno com matrícula inválida e outro pelo número de matrícula
        gerenciadorAlunos.removerAlunoPorMatricula(000L);
        gerenciadorAlunos.removerAlunoPorMatricula(123457L);
        gerenciadorAlunos.exibirAlunos();

        // Exibindo alunos ordenados por nome
        gerenciadorAlunos.exibirAlunosPorNome();

        // Exibindo alunos ordenados por nota
        gerenciadorAlunos.exibirAlunosPorNota();
    }
}
