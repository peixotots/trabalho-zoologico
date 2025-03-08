public class Anfibio extends Animal {

    public Anfibio(int idade, String nome, int peso, String necessidadeAlimentar, Setor setor) {
        super(idade, "Anfíbio", setor, nome, peso, necessidadeAlimentar);
    }

    @Override
    public void comer(){
        System.out.println(getNome() + " está comendo");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " está coaxando.");
    }

    @Override
    public void brincar() {
        System.out.println(getNome() + " está nadando.");
    }

    @Override
    public void descansar(){
        System.out.println(getNome() + " está descansando.");
    }

}