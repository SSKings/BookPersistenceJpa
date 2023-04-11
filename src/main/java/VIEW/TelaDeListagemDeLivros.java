package VIEW;

import DAO.LivroDAO;
import MODEL.Livro;

import java.util.List;

public class TelaDeListagemDeLivros {
    public static void main(String[] args) {

        try{
            List<Livro> listaDeLivros = new LivroDAO().listar();
            System.out.println("<<LISTAGEM DE LIVROS>>\n");
            if (listaDeLivros.isEmpty()) {
                System.out.println("Nenhum livro cadastrado.");
            }
            for (Livro l : listaDeLivros){
                System.out.print("|ID: "+l.getId());
                System.out.print(", Nome:"+l.getNome());
                System.out.print(", Editora:"+l.getEditora());
                System.out.print(", Páginas:"+l.getPaginas());
                System.out.print(", Ano:"+l.getAno()+"|\n");
            }
        }catch (Exception e){
            System.out.println("Não foi possível listar...");
        }
    }
}
