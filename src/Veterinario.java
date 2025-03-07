public class Veterinario extends Funcionario {

    public Veterinario(String nome, String identificacao) {
        super(nome, identificacao);
    }

    @Override
    public void realizarTarefa() {
        System.out.println("Realizando check-up nos animais.");
    }

    public void realizarCheckUp() {
        System.out.println(getNome() + " está realizando um check-up nos animais.");
    }

    public void registrarEstadoSaude() {
        System.out.println(getNome() + " está registrando o estado de saúde dos animais.");
    }


}
