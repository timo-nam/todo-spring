package study.winter.todo.repository;

import org.springframework.stereotype.Repository;
import study.winter.todo.domain.Task;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TaskRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Task task) {
        em.persist(task);
    }

    public Task findOne(Long id) {
        return em.find(Task.class, id);
    }

    public void delete(Long id) {
        Task task = em.find(Task.class, id);
        if (task != null) {
            em.remove(task);
        }
    }

    public List<Task> findAll() {
        return em.createQuery("select t from Task t", Task.class)
                .getResultList();
    }

    public List<Task> findByTitle(String title) {
        return em.createQuery("select  t from Task t where t.title = :title", Task.class)
                .setParameter("title", title)
                .getResultList();
    }
}
