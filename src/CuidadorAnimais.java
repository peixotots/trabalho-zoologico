public class CuidadorAnimais extends Funcionario {

    public CuidadorAnimais(String nome, String identificacao) {
        super(nome, identificacao);
    }

    @Override
    public void realizarTarefa() {
        System.out.println("Cuidando dos animais.");
    }

    public void limparRecinto() {
        System.out.println(getNome() + " está limpando o recinto dos animais.");
    }

    public void abastecerComidaEAgua() {
        System.out.println(getNome() + " está abastecendo comida e água para os animais.");
    }

}