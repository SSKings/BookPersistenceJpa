package VIEW;

import DAO.LivroDAO;
import MODEL.Livro;

import java.util.Scanner;

public class TelaDeExclusaoDeLivro {
    public static void main(String[] args) {


        try{
            System.out.println("<<EXCLUSÃO DE LIVRO>>\n");
            Scanner scan = new Scanner(System.in);
            System.out.println("Digite o ID do Livro a ser excluído: ");
            Integer id = Integer.parseInt(scan.nextLine());
            Livro livro = new Livro();
            livro.setId(id);
            new LivroDAO().excluir(livro);
            System.out.println("Livro deletado com sucesso.");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Erro ao tentar Excluir");
        }
    }
}
