public class Animal {

    private String classeBiologica;
    private Setor setor;
    private String nome;
    private int idade;
    private int peso;
    private String necessidadeAlimentar;

    public Animal(int idade, String classeBiologica, Setor setor, String nome, int peso, String necessidadeAlimentar) {
        this.idade = idade;
        this.classeBiologica = classeBiologica;
        this.setor = alocarSetor(classeBiologica);
        this.nome = nome;
        this.peso = peso;
        this.necessidadeAlimentar = necessidadeAlimentar;
    }

    public String getClasseBiologica() {
        return classeBiologica;
    }

    public void setClasseBiologica(String classeBiologica) {
        this.classeBiologica = classeBiologica;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getNecessidadeAlimentar() {
        return necessidadeAlimentar;
    }

    public void setNecessidadeAlimentar(String necessidadeAlimentar) {
        this.necessidadeAlimentar = necessidadeAlimentar;
    }

    private Setor alocarSetor(String classeBiologica) {
        switch (classeBiologica) {
            case "Mamífero":
                return new Setor("Setor de Mamíferos");
            case "Ave":
                return new Setor("Setor de Animais Aquáticos");
            case "Réptil":
                return new Setor("Setor de Répteis");
            case "Anfíbio":
                return new Setor("Setor de Anfíbios");
            default:
                throw new IllegalArgumentException("Classe biológica desconhecida: " + classeBiologica);
        }
    }

    public void comer() {
        System.out.println(nome + " está comendo.");
    }

    public void emitirSom() {
        System.out.println(nome + " está emitindo som.");
    }

    public void brincar() {
        System.out.println(nome + " está brincando.");
    }

    public void descansar(){
        System.out.println(nome + "está descansando.");
    }

}