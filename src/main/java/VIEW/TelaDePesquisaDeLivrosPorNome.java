package VIEW;

import DAO.LivroDAO;
import MODEL.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TelaDePesquisaDeLivrosPorNome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("<<PESQUISA DE LIVROS POR NOME>>\n");
        System.out.println("Digite o nome do filme: ");
        String nome = scan.nextLine();
        Livro livro = new Livro();
        livro.setNome(nome);
        List<Livro> listaDeLivros = new ArrayList<>();

        try {
            listaDeLivros = new LivroDAO().buscarPorNome(livro);
            if(!listaDeLivros.isEmpty()){
                System.out.println("<<LIVRO(S) ENCONTRADO(S)>>\n");
                for (Livro l : listaDeLivros) {
                    System.out.print("|ID: " + l.getId());
                    System.out.print(", NOME: " + l.getNome());
                    System.out.print(", EDITORA: " + l.getEditora());
                    System.out.print(", PÁGINAS: " + l.getPaginas());
                    System.out.print(", ANO: " + l.getAno() + "|\n");
                }

            }else {
                System.out.println("Não foram encontrados resultados para esse nome.");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Erro ao tentar obter resultados.");
        }


    }
}
