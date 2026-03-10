import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProdutoDAO dao = new ProdutoDAO();

        int opcao = 0;

        while (opcao != 5) {

            System.out.println("\n1 - Listar");
            System.out.println("2 - Inserir");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:

                    List<Produto> lista = dao.listar();

                    for (Produto p : lista) {
                        System.out.println(p.getId() + " - " + p.getNome() + " - " + p.getPreco());
                    }

                    break;

                case 2:

                    scanner.nextLine();

                    System.out.println("Nome:");
                    String nome = scanner.nextLine();

                    System.out.println("Preço:");
                    double preco = scanner.nextDouble();

                    Produto produto = new Produto(nome, preco);
                    dao.inserir(produto);

                    break;

                case 3:

                    System.out.println("ID:");
                    int id = scanner.nextInt();

                    scanner.nextLine();

                    System.out.println("Novo nome:");
                    String novoNome = scanner.nextLine();

                    System.out.println("Novo preço:");
                    double novoPreco = scanner.nextDouble();

                    Produto p = new Produto(novoNome, novoPreco);
                    p.setId(id);

                    dao.atualizar(p);

                    break;

                case 4:

                    System.out.println("ID para excluir:");
                    int idExcluir = scanner.nextInt();

                    dao.excluir(idExcluir);

                    break;
            }
        }

        scanner.close();
    }
}
