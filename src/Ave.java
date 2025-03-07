public class Ave extends Animal {

    public Ave(int idade, String nome, int peso, String necessidadeAlimentar) {
        super(idade, "Ave", new Setor("Setor de Aves\n"), nome, peso, necessidadeAlimentar);
    }

    @Override
    public void comer(){
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
    public void descansar(){
        System.out.println(getNome() + " está descansando.");
    }

}