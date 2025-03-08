import java.util.ArrayList;
import java.util.Scanner;

public class Zoologico {

    private ArrayList<Animal> animais;
    private ArrayList<Funcionario> funcionarios;
    private Scanner scanner;

    public Zoologico() {
        this.animais = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;

        System.out.print("\t-------------------------\n");
        System.out.print("\t     ZOOLÓGICO UBERZOO\n");
        System.out.print("\t-------------------------\n");
        System.out.print("\tSistema de Gerenciamento\n");

        System.out.print("\n\t    w  c(..)o     \n");
        System.out.print("\t     \\__(- ) __)\n");
        System.out.print("\t         /\\ (\n");
        System.out.print("\t        /(_)_)\n");
        System.out.print("\t       w /|\n");
        System.out.print("\t         | \\\n");
        System.out.print("\t        m  m\n");

        do {
            System.out.println("\n######## ZOO ########");
            System.out.println("1. Cadastrar Animal 🐾");
            System.out.println("2. Cadastrar Funcionário 👨");
            System.out.println("3. Listar Animais por Setores 🐊");
            System.out.println("4. Listar Comportamentos dos Animais 🦁");
            System.out.println("5. Listar Funcionários por Função 👩‍🔬");
            System.out.println("6. Listar Atividades dos Funcionários 🛠️");
            System.out.println("7. Encerrar Programa ❌");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarAnimal();
                case 2 -> cadastrarFuncionario();
                case 3 -> listarAnimaisPorSetor();
                case 4 -> listarComportamentosDosAnimais();
                case 5 -> listarFuncionariosPorFuncao();
                case 6 -> listarAtividadesFuncionarios();
                case 7 -> System.err.println("\nEncerrando o sistema... 👋");
                default -> System.err.println("Digite uma opção válida. ⚠️\n");
            }
        } while (opcao != 7);
    }

    public void cadastrarAnimal() {
        System.out.print("\nDigite o nome do animal: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a idade do animal: ");
        int idade = scanner.nextInt();
        System.out.print("Digite o peso do animal: ");
        int peso = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nSelecione a necessidade alimentar do animal:");
        System.out.println("1. Carnívoro | 2. Herbívoro | 3. Onívoro");
        System.out.print("Escolha uma opção: ");
        int necessidadeOpcao = scanner.nextInt();
        scanner.nextLine();

        String necessidadeAlimentar = "";
        switch (necessidadeOpcao) {
            case 1 -> necessidadeAlimentar = "Carnívoro";
            case 2 -> necessidadeAlimentar = "Herbívoro";
            case 3 -> necessidadeAlimentar = "Onívoro";
            default -> {
                System.out.println("Opção inválida. Animal não cadastrado.");
                return;
            }
        }

        System.out.println("\nSelecione a classe biológica do animal:");
        System.out.println("1. Mamífero | 2. Ave | 3. Réptil | 4. Anfíbio");
        System.out.print("Escolha uma opção: ");
        int classeOpcao = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nSelecione o setor que o animal será alocado:");
        System.out.println("1. Setor de Mamíferos | 2. Setor de Aves | 3. Setor de Répteis | 4. Setor de Animais Aquáticos | 5. Setor de Anfíbios");
        System.out.print("Escolha uma opção: ");
        int setorOpcao = scanner.nextInt();
        scanner.nextLine();

        Setor setor;
        switch (setorOpcao) {
            case 1 -> setor = new SetorMamiferos();
            case 2 -> setor = new SetorAves();
            case 3 -> setor = new SetorRepteis();
            case 4 -> setor = new SetorAnimaisAquaticos();
            case 5 -> setor = new SetorAnfibios();
            default -> {
                System.out.println("Opção inválida. Setor não encontrado. Animal não cadastrado.");
                return;
            }
        }

        Animal animal;
        switch (classeOpcao) {
            case 1 -> animal = new Mamifero(idade, nome, peso, necessidadeAlimentar, setor);
            case 2 -> animal = new Ave(idade, nome, peso, necessidadeAlimentar, setor);
            case 3 -> animal = new Reptil(idade, nome, peso, necessidadeAlimentar, setor);
            case 4 -> animal = new Anfibio(idade, nome, peso, necessidadeAlimentar, setor);
            default -> {
                System.out.println("Opção inválida. Classe biológica não encontrada. Animal não cadastrado.");
                return;
            }
        }

        animal.setSetor(setor);
        animais.add(animal);
        System.out.println("Animal cadastrado com sucesso!");
    }

    public void cadastrarFuncionario() {
        System.out.print("\nDigite o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o número de registro do funcionário: ");
        String identificacao = scanner.nextLine();

        System.out.println("Função do funcionário:");
        System.out.println("1. Veterinário | 2. Biólogo | 3. Cuidador de Animais");
        System.out.print("Escolha uma opção: ");
        int funcaoOpcao = scanner.nextInt();
        scanner.nextLine();

        Funcionario funcionario;
        switch (funcaoOpcao) {
            case 1 -> funcionario = new Veterinario(nome, identificacao);
            case 2 -> funcionario = new Biologo(nome, identificacao);
            case 3 -> funcionario = new CuidadorAnimais(nome, identificacao);
            default -> {
                System.out.println("Opção inválida. Funcionário não cadastrado.");
                return;
            }
        }

        funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public void listarAnimaisPorSetor() {
        if (animais.isEmpty()) {
            System.out.println("\nNenhum animal cadastrado.");
        } else {
            System.out.println("\nANIMAIS POR SETORES:");
            for (Animal animal : animais) {
                System.out.println(animal.getSetor().getNome() + ": " + animal.getNome());
            }
        }
    }

    public void listarComportamentosDosAnimais() {
        if (animais.isEmpty()) {
            System.out.println("\nNenhum animal cadastrado. Por favor, cadastre um animal para listar os comportamentos.");
            return;
        }

        int opcao;

        do {
            System.out.println("\n###### COMPORTAMENTOS DOS ANIMAIS ######");
            System.out.println("1. Alimentar por necessidade alimentar");
            System.out.println("2. Brincar");
            System.out.println("3. Emitir som");
            System.out.println("4. Descansar");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> alimentarAnimaisPorNecessidadeAlimentar();
                case 2 -> brincarAnimais();
                case 3 -> emitirSomAnimais();
                case 4 -> descansarAnimais();
                case 5 -> System.out.println("Retornando ao menu principal...");
                default -> System.err.println("Digite uma opção válida.");
            }
        } while (opcao != 5);
    }

    public void alimentarAnimaisPorNecessidadeAlimentar() {
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
        } else {
            System.out.println("\nSelecione a necessidade alimentar:");
            System.out.println("1. Carnívoro | 2. Herbívoro | 3. Onívoro");
            System.out.print("Escolha uma opção: ");
            int necessidadeOpcao = scanner.nextInt();
            scanner.nextLine();

            String necessidadeAlimentar = "";
            switch (necessidadeOpcao) {
                case 1 -> necessidadeAlimentar = "Carnívoro";
                case 2 -> necessidadeAlimentar = "Herbívoro";
                case 3 -> necessidadeAlimentar = "Onívoro";
                default -> {
                    System.err.println("Digite uma opção válida.\n");
                    return;
                }
            }

            boolean encontrouAnimal = false;
            for (Animal animal : animais) {
                if (animal.getNecessidadeAlimentar().equalsIgnoreCase(necessidadeAlimentar)) {
                    animal.comer();
                    encontrouAnimal = true;
                }
            }

            if (!encontrouAnimal) {
                System.out.println("\nNenhum animal com a necessidade alimentar selecionada.");
            }
        }
    }

    private void brincarAnimais() {
        for (Animal animal : animais) {
            animal.brincar();
        }
    }

    private void emitirSomAnimais() {
        for (Animal animal : animais) {
            animal.emitirSom();
        }
    }

    private void descansarAnimais() {
        for (Animal animal : animais) {
            animal.descansar();
        }
    }

    public void listarFuncionariosPorFuncao() {
        if (funcionarios.isEmpty()) {
            System.out.println("\nNenhum funcionário cadastrado.");
            return;
        }

        boolean temVetCadastrado = false;
        System.out.println("\nVETERINÁRIOS:");
        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof Veterinario) {
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("Registro: " + funcionario.getRegistro());
                temVetCadastrado = true;
            }
        }
        if (!temVetCadastrado) {
            System.out.println("Nenhum veterinário cadastrado.");
        }

        boolean temBioCadastrado = false;
        System.out.println("\nBIÓLOGOS:");
        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof Biologo) {
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("Registro: " + funcionario.getRegistro());
                temBioCadastrado = true;
            }
        }
        if (!temBioCadastrado) {
            System.out.println("Nenhum biólogo cadastrado.");
        }

        boolean temCuidadorCadastrado = false;
        System.out.println("\nCUIDADORES DE ANIMAIS:");
        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof CuidadorAnimais) {
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("Registro: " + funcionario.getRegistro());
                temCuidadorCadastrado = true;
            }
        }
        if (!temCuidadorCadastrado) {
            System.out.println("Nenhum cuidador de animais cadastrado.");
        }
    }

    public void listarAtividadesFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("\nNenhum funcionário cadastrado. Por favor, cadastre um funcionário para listar as atividades.");
            return;
        }

        int opcao;

        do {
            System.out.println("\n###### ATIVIDADES DOS FUNCIONÁRIOS ######");
            System.out.println("1. Limpar recinto");
            System.out.println("2. Abastecer comida e água");
            System.out.println("3. Realizar check-up");
            System.out.println("4. Registrar estado de saúde");
            System.out.println("5. Estudar comportamento do animal");
            System.out.println("6. Registrar informação do animal");
            System.out.println("7. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> limparRecinto();
                case 2 -> abastecerComidaEAgua();
                case 3 -> realizarCheckUp();
                case 4 -> registrarEstadoSaude();
                case 5 -> estudarComportamentoAnimal();
                case 6 -> registrarInformacaoAnimal();
                case 7 -> System.out.println("Retornando ao menu principal...");
                default -> System.err.println("Digite uma opção válida.");
            }
        } while (opcao != 7);
    }

    private void limparRecinto() {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof CuidadorAnimais) {
                ((CuidadorAnimais) funcionario).limparRecinto();
            }
        }
    }

    private void abastecerComidaEAgua() {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof CuidadorAnimais) {
                ((CuidadorAnimais) funcionario).abastecerComidaEAgua();
            }
        }
    }

    private void realizarCheckUp() {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof Veterinario) {
                ((Veterinario) funcionario).realizarCheckUp();
            }
        }
    }

    private void registrarEstadoSaude() {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof Veterinario) {
                ((Veterinario) funcionario).registrarEstadoSaude();
            }
        }
    }

    private void estudarComportamentoAnimal() {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof Biologo) {
                ((Biologo) funcionario).estudarComportamentoAnimal();
            }
        }
    }

    private void registrarInformacaoAnimal() {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof Biologo) {
                ((Biologo) funcionario).registrarInformacaoAnimal();
            }
        }
    }

}