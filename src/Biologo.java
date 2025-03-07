public class Biologo extends Funcionario {

    public Biologo(String nome, String identificacao) {
        super(nome, identificacao);
    }

    @Override
    public void realizarTarefa() {
        System.out.println("Estudando comportamento animal.");
    }

    public void estudarComportamentoAnimal() {
        System.out.println(getNome() + " está estudando o comportamento animal.");
    }

    public void registrarInformacaoAnimal() {
        System.out.println(getNome() + " está registrando informações sobre o animal.");
    }

}