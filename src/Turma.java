import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Turma implements Serializable {
    private int idTurma;
    private Professor professor;
    private List<Aluno> alunos;

    public Turma(int idTurma) {
        this.idTurma = idTurma;
        this.alunos = new ArrayList<>();
    }


    public int getIdTurma() {
        return idTurma;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    // Methods to add and remove students
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public static List<Turma> listarTurmas() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Turmas.txt"));
            List<Turma> lista = (List<Turma>) in.readObject();
            in.close();
            return lista;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static boolean atualizarArquivo(List<Turma> lista) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Turmas.txt"));
            out.writeObject(lista);
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para listar todas as turmas
    public static List<Turma> listarTodasAsTurmas() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Turmas.txt"));
            List<Turma> lista = (List<Turma>) in.readObject();
            in.close();
            return lista;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void removerProfessor(Professor professor) {
        this.professor = null;
    }

    // Método para definir um novo professor
    public void setProfessor(Professor novoProfessor) {
        this.professor = novoProfessor;
    }

    // Método para mostrar dados da turma
    public void mostrarDados() {
        System.out.println("ID Turma: " + idTurma);
        System.out.println("Professor: " + (professor != null ? professor.getNome() : "Nenhum"));
    }


}