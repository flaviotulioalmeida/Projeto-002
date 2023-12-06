import java.util.ArrayList;
import java.util.List;

public class ControleAcademico {
    private List<Aluno> alunos;
    private List<Professor> professores;
    private List<Turma> turmas;
    private List<Disciplina> disciplinas;

    public ControleAcademico() {
        this.alunos = new ArrayList<>(); // Inicializa a lista de alunos
        this.professores = new ArrayList<>();
        this.turmas = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
    }

    // Método para adicionar professor
    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }

    // Método para remover professor de turma
    public void removerProfessorDeTurma(Turma turma, Professor professor) {
        turma.removerProfessor(professor);
    }

    // Método para trocar professor de turma
    public void trocarProfessorDeTurma(Turma turma, Professor novoProfessor) {
        turma.setProfessor(novoProfessor);
    }

    // Método para mostrar todas as turmas
    public void mostrarTodasAsTurmas() {
        List<Turma> todasAsTurmas = Turma.listarTodasAsTurmas();
        for (Turma turma : todasAsTurmas) {
            turma.mostrarDados();
        }
    }

    // Methods to add and remove entities
    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public void removerProfessor(Professor professor) {
        professores.remove(professor);
    }

    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }

    public void removerTurma(Turma turma) {
        turmas.remove(turma);
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public void removerDisciplina(Disciplina disciplina) {
        disciplinas.remove(disciplina);
    }

    // Método para remover aluno de uma turma específica
    public void removerAlunoDeTurma(Aluno aluno, Turma turma) {
        if (turma != null) {
            turma.removerAluno(aluno);
        }
    }

    // Método para remover aluno de uma disciplina específica
    public void removerAlunoDeDisciplina(Aluno aluno, Disciplina disciplina) {
        if (disciplina != null) {
            disciplina.removerAluno(aluno);
        }
    }
}