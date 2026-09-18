import java.util.ArrayList;
import java.util.List;

List<Veiculo> veiculos = new ArrayList<>();

void main() {
    linhas();
    IO.println("Sistema de Cadastro de Veículos");
    linhas();
    IO.println("""
            1 - Cadastrar Veiculo
            2 - Listar Veículos
            3 - Remover Veículos
            0 - Sair
            """);
    int opcao;
    do{
        opcao = Input.readInt("\nDigite um número: ");

        switch (opcao) {
            case 1 ->cadastrarVeiculo();
            case 2 -> listarVeiculos();
            case 3 -> removerVeiculo();
            case 0 -> IO.println("Saindo do sistema....");
            
            default -> {
                IO.println("Opção inválida");
            }
        }
    }while (opcao != 0);
};

void linhas() {
    IO.println("--------------------------------------");
}

void cadastrarVeiculo() {

    Veiculo novoVeiculo = new Veiculo();
    novoVeiculo.setMarca(IO.readln("Marca do Veículo a ser cadastrado: ").trim());
    novoVeiculo.setModelo(IO.readln("Modelo do Veículo a ser cadastrado: ").trim());
    novoVeiculo.setAno(Input.readInt("Ano do Veículo a ser cadastrado: "));
    novoVeiculo.setPlaca(IO.readln("Placa do Veículo a ser cadastrado: ").trim());

    veiculos.add(novoVeiculo);
  
}

void listarVeiculos() {
    IO.println("Veiculos Cadastrados");
    for (int i = 0; i < veiculos.size(); i++){
        String marcaCarro = veiculos.get(i).getMarca();
        String modeloCarro = veiculos.get(i).getModelo();
        int anoCarro = veiculos.get(i).getAno();
        String placaCarro = veiculos.get(i).getPlaca();

        IO.println((i + 1) + " - " + marcaCarro + " | " + modeloCarro + " | " + anoCarro + " | " + placaCarro);
        
    
    }
}

void removerVeiculo(){
    int indice = Input.readInt("Digite o indice do veículo a ser removido");
    if (indice > 0 && indice <= veiculos.size()){
        veiculos.remove(--indice);
    }
}