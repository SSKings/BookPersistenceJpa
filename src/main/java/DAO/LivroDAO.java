package DAO;

import MODEL.Livro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

public class LivroDAO {
    private final EntityManagerFactory emf;

    public LivroDAO() {
        this.emf = Persistence.createEntityManagerFactory("aplicativo");
    }

    public void cadastrar(Livro livro) throws Exception {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(livro);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void alterar(Livro livro) throws Exception {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(livro);
            em.getTransaction().commit();

        }catch (Exception e){
            em.getTransaction().rollback();
            throw new Exception(e.getMessage());
        }finally {
            em.close();
        }
    }

    public List<Livro> listar() {
        EntityManager em = emf.createEntityManager();
        try{
            return em.createQuery("FROM Livro", Livro.class).getResultList();
        }catch (Exception e){
            return null;
        } finally {
            em.close();
        }
    }

    public void excluir(Livro livro) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Livro l = em.merge(livro);
            em.remove(l);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            throw new Exception(e.getMessage());
        }finally {
            em.close();
        }
    }

    public Livro buscarPorId(Integer id){
        EntityManager em = emf.createEntityManager();
        try {
            Livro livro = new Livro();
            livro.setId(id);
            return em.find(Livro.class, livro.getId());
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
}
