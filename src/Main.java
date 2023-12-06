
public class Main {
    public static void main(String[] args) {
        // Example usage of the academic system
        ControleAcademico controleAcademico = new ControleAcademico();

        Turma turma1 = new Turma(1);
        controleAcademico.adicionarTurma(turma1);

        Aluno aluno1 = new Aluno("NomeAluno1", "CPF1", "Matricula1", "01/01/2000", 8.5, "email1@example.com");
        controleAcademico.adicionarAluno(aluno1);

        Disciplina disciplina1 = new Disciplina(1, "Matematica", turma1);
        controleAcademico.adicionarDisciplina(disciplina1);

        // Add aluno1 to turma1 and disciplina1
        turma1.adicionarAluno(aluno1);
        disciplina1.adicionarAluno(aluno1);

    }
}