package VIEW;

import DAO.LivroDAO;
import MODEL.Livro;

import java.util.Scanner;

public class TelaDeCadastroDeLivro {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("<<CADASTRO DE LIVRO>>");
        System.out.println("Informe o nome do livro");
        String nome = scan.nextLine();
        System.out.println("Informe o nome da editora");
        String editora = scan.nextLine();
        System.out.println("Informe o número de páginas");
        Integer pags = Integer.parseInt(scan.nextLine());
        System.out.println("Informe o ano de lançamento");
        Integer ano = Integer.parseInt(scan.nextLine());
        scan.close();

        Livro livro = new Livro(null, nome, editora, pags, ano);
        try {
            new LivroDAO().cadastrar(livro);
            System.out.println("Livro cadastrado com sucesso!");
        }catch (Exception e){
            System.out.println("Não foi possivel cadastrar o livro");
            e.printStackTrace();
        }


    }
}
