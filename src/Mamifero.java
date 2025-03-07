public class Mamifero extends Animal {

    public Mamifero(int idade, String nome, int peso, String necessidadeAlimentar) {
        super(idade, "Mamífero", new Setor("Setor de Mamíferos\n"), nome, peso, necessidadeAlimentar);
    }

    @Override
    public void comer(){
        System.out.println(getNome() + " está comendo");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " está rugindo.");
    }

    @Override
    public void brincar() {
        System.out.println(getNome() + " está correndo.");
    }

    @Override
    public void descansar(){
        System.out.println(getNome() + " está descansando.");
    }

}