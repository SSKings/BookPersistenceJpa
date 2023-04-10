package VIEW;

import DAO.LivroDAO;
import MODEL.Livro;

import java.util.Scanner;

public class TelaDeAlteracaoDeLivro {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("<<ALTERAÇÂO DE LIVRO>>\n");
        System.out.println("Informe o número do ID do Livro que deve ser alterado: ");
        Integer id = Integer.parseInt(scan.nextLine());
        System.out.println("Informe o novo nome do livro: ");
        String nome = scan.nextLine();
        System.out.println("Informe a nova editora do livro: ");
        String editora = scan.nextLine();
        System.out.println("Informe o novo número de páginas do livro: ");
        Integer pags = Integer.parseInt(scan.nextLine());
        System.out.println("Informe o novo ano de lançamento do livro: ");
        Integer ano  = Integer.parseInt(scan.nextLine());
        scan.close();
        try{
            Livro livro = new Livro(id,nome,editora,pags,ano);
            new LivroDAO().alterar(livro);
            System.out.println("Os Dados do Livro "+id+" foram alterados com sucesso");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Não foi possível alterar os dados do Livro");
        }


    }
}
