import java.util.ArrayList;
import java.util.List;

List<Veiculo> veiculos = new ArrayList<>();

String marcaCarro;
String modeloCarro;
int anoCarro;
String placaCarro;

public void main() {
    linhas();
    IO.println("Sistema de Cadastro de Veículos");
    linhas();
    IO.println("""
            1 - Cadastrar Veiculo
            2 - Listar Veículos
            3 - Buscar Veículos
            0 - Sair
            """);
    int opcao;
    do {
        opcao = Input.readInt("\nDigite um número: ");

        switch (opcao) {
            case 1 -> cadastrarVeiculo();
            case 2 -> listarVeiculos();
            case 3 -> consultarVeiculo();
            case 0 -> IO.println("Saindo do sistema....");

            default -> {
                IO.println("Opção inválida");
            }
        }
    } while (opcao != 0);
};

void linhas() {
    IO.println("--------------------------------------");
}

void cadastrarVeiculo() {

    Veiculo novoVeiculo = new Veiculo();
    novoVeiculo.setMarca(IO.readln("Marca do Veículo a ser cadastrado: ").trim());
    novoVeiculo.setModelo(IO.readln("Modelo do Veículo a ser cadastrado: ").trim());
    
    novoVeiculo.setAno(Input.readInt("Ano do Veículo a ser cadastrado: "));

    while (true) {
        String placaString = (IO.readln("Placa do Veículo a ser cadastrado: ").trim().toUpperCase());
        
        boolean existe = false;
        for (int i = 0; i < veiculos.size(); i++) {
            if (placaString.equals(veiculos.get(i).getPlaca())) {
                existe = true;
                break;
            }
        }
        
        if (existe) {
            IO.println("Placa já cadastrada! Digite uma placa diferente.\n");
        } else {
            novoVeiculo.setPlaca(placaString);  // setPlaca valida aqui
            if (novoVeiculo.getPlaca() != null) {  // Se foi validada com sucesso
                break;
            }
        }
    }
    
    veiculos.add(novoVeiculo);
    IO.println("Veículo cadastrado com sucesso!\n");
}


void listarVeiculos() {
    IO.println("Veiculos Cadastrados");
    for (int i = 0; i < veiculos.size(); i++) {
        marcaCarro = veiculos.get(i).getMarca();
        modeloCarro = veiculos.get(i).getModelo();
        anoCarro = veiculos.get(i).getAno();
        placaCarro = veiculos.get(i).getPlaca();

        System.out.printf("%d - %s | %s | %d | %s\n", (i + 1), marcaCarro, modeloCarro, anoCarro, placaCarro);

    }
}

void consultarVeiculo() {
    String placa = IO.readln("Digite a placa que deseja consultar: ").toUpperCase();
    for (int i = 0; i < veiculos.size(); i++) {
        placaCarro = veiculos.get(i).getPlaca();
        if (placaCarro.equals(placa)) {
            System.out.printf("\nDados do veículo de placa: %s\n", placaCarro);
            System.out.printf("Marca: %s | Modelo: %s | Ano: %d\n", veiculos.get(i).getMarca(),
                    veiculos.get(i).getModelo(), veiculos.get(i).getAno());
        } else
            System.out.println("\nVeículo não encontrado!");
    }

}
