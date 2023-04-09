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
                System.out.println("ID:"+l.getId());
                System.out.println("Nome:"+l.getNome());
                System.out.println("Editora:"+l.getEditora());
                System.out.println("Páginas:"+l.getPaginas());
                System.out.println("Ano:"+l.getAno());
            }
        }catch (Exception e){
            System.out.println("Não foi possível listar...");
        }
    }
}
