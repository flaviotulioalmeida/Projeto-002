import java.io.*;
import java.util.*;


class Disciplina implements Serializable {
    private int idDisciplina;
    private String tipoDisciplina;
    private Turma turma;
    private List<Aluno> alunos;
    private Aluno aluno;
    private Map<Aluno, Integer> presencas;
    private Map<Aluno, Integer> faltas;
    private Map<Aluno, double[]> notas;

    public Disciplina(int idDisciplina, String tipoDisciplina, Turma turma) {
        this.idDisciplina = idDisciplina;
        this.tipoDisciplina = tipoDisciplina;
        this.turma = turma;
        this.alunos = new ArrayList<>();
        presencas = new HashMap<>();
        faltas = new HashMap<>();
        notas = new HashMap<>();

    }

    // Método para confirmar presença ou falta de aluno em disciplina
    public void confirmarPresencaOuFalta(Aluno aluno, boolean presente) {
        if (presente) {
            presencas.put(aluno, presencas.getOrDefault(aluno, 0) + 1);
        } else {
            faltas.put(aluno, faltas.getOrDefault(aluno, 0) + 1);
        }
    }

    // Método para informar notas e média de aluno em disciplina
    public void informarNotasEMedia(Aluno aluno, double[] novasNotas) {
        if (notas.containsKey(aluno)) {
            // Se o aluno já tem notas registradas, atualiza as notas existentes
            double[] notasAtuais = notas.get(aluno);
            for (int i = 0; i < notasAtuais.length; i++) {
                notasAtuais[i] = novasNotas[i];
            }
        } else {
            // Se o aluno não tem notas registradas, adiciona as novas notas
            notas.put(aluno, novasNotas);
        }
    }

    public double calcularMedia(Aluno aluno) {
        if (notas.containsKey(aluno)) {
            double[] notasAluno = notas.get(aluno);
            double soma = 0.0;
            for (double nota : notasAluno) {
                soma += nota;
            }
            return soma / notasAluno.length;
        }
        return -1.0; // Retorna -1 se o aluno não tiver notas registradas
    }

    // Método para mostrar dados da disciplina
    public void mostrarDados() {
        System.out.println("ID Disciplina: " + idDisciplina);
        System.out.println("Tipo Disciplina: " + tipoDisciplina);
        System.out.println("Turma: " + turma.getIdTurma());
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public String getTipoDisciplina() {
        return tipoDisciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    // Methods to manage students in the discipline
    public boolean adicionarAlunoIfNotExists(Aluno aluno) {
        if (!alunos.contains(aluno)) {
            alunos.add(aluno);
            return true;
        }
        return false;
    }

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public static List<Disciplina> listarDisciplinas() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Disciplinas.txt"));
            List<Disciplina> lista = (List<Disciplina>) in.readObject();
            in.close();
            return lista;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static boolean atualizarArquivo(List<Disciplina> lista) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Disciplinas.txt"));
            out.writeObject(lista);
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void adicionarAluno(Aluno aluno) {
        this.aluno = aluno;
        alunos.add(aluno);
    }

    public boolean alterarNotaAluno(Aluno aluno, double novaNota) {
        Optional<Aluno> alunoOptional = alunos.stream().filter(a -> a.equals(aluno)).findFirst();
        if (((Optional<?>) alunoOptional).isPresent()) {
            alunoOptional.get().setNotaAluno(novaNota);
            return true;
        }
        return false;
    }
}