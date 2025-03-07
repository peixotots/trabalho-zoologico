public class Reptil extends Animal {

    public Reptil(int idade, String nome, int peso, String necessidadeAlimentar) {
        super(idade, "Réptil", new Setor("Setor de Répteis\n"), nome, peso, necessidadeAlimentar);
    }

    @Override
    public void comer(){
        System.out.println(getNome() + " está comendo");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " está sibilando.");
    }

    @Override
    public void brincar() {
        System.out.println(getNome() + " está rastejando.");
    }

    @Override
    public void descansar(){
        System.out.println(getNome() + " está descansando.");
    }

}