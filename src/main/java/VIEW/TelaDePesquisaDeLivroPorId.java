package VIEW;

import DAO.LivroDAO;
import MODEL.Livro;


import java.util.Scanner;

public class TelaDePesquisaDeLivroPorId {
    public static void main(String[] args) {
        try {
            System.out.println("<<PESQUISA DE LIVRO POR ID>>\n");
            System.out.println("Digite o ID do livro para encontrá-lo: ");
            Scanner scan = new Scanner(System.in);
            Integer id = Integer.parseInt(scan.nextLine());
            Livro livro = new LivroDAO().buscarPorId(id);
            if(livro != null){
                System.out.println("LIVRO ENCONTRADO\n");
                System.out.println("|ID: "+livro.getId()+", Nome: "+livro.getNome()+
                        ", Editora: "+livro.getEditora()+", Páginas: "+livro.getPaginas()+
                        ", Ano: "+livro.getAno()+"|");
            }else {
                System.out.println("LIVRO NÃO ENCONTRADO");
                System.out.println("ID não existe.");
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Erro ao buscar");
        }
    }
}
