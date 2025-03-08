public class Ave extends Animal {

    public Ave(int idade, String nome, int peso, String necessidadeAlimentar, Setor setor) {
        super(idade, "Ave", setor, nome, peso, necessidadeAlimentar);
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " está comendo");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " está cantando.");
    }

    @Override
    public void brincar() {
        System.out.println(getNome() + " está voando.");
    }

    @Override
    public void descansar() {
        System.out.println(getNome() + " está descansando.");
    }

}