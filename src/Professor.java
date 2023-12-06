import java.io.Serializable;

class Professor implements Serializable {
    private String nome;
    private String matricula;
    private double salario;
    private String dataAdmissao;
    private String tipoGraduacao;

    public Professor(String nome, String matricula, double salario, String dataAdmissao,String tipoGraduacao) {
        this.nome = nome;
        this.matricula = matricula;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
        this.tipoGraduacao = tipoGraduacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getTipoGraduacao() {
        return tipoGraduacao;
    }

    public void setTipoGraduacao(String tipoGraduacao) {
        this.tipoGraduacao = tipoGraduacao;
    }

    public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Salário: " + salario);
        System.out.println("Data de Admissão: " + dataAdmissao);
        System.out.println("Graduação: " + tipoGraduacao);
    }
}