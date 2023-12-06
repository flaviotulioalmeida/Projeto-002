import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Aluno {
    private String nome;
    private String cpf;
    private String matricula;
    private String dataNascimento;
    private double notaAluno;
    private String email;

    public Aluno(String nome, String cpf, String matricula, String dataNascimento, double notaAluno, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.notaAluno = notaAluno;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getNotaAluno() {
        return notaAluno;
    }

    public void setNotaAluno(double notaAluno) {
        this.notaAluno = notaAluno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static List<Aluno> listarAlunos() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Alunos.txt"));
            List<Aluno> lista = (List<Aluno>) in.readObject();
            in.close();
            return lista;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static boolean atualizarArquivo(List<Aluno> lista) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Alunos.txt"));
            out.writeObject(lista);
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
