package study.winter.todo.domain;

import javax.persistence.*;

@Entity
public class Subtask {
    @Id @GeneratedValue
    @Column(name = "subtask_id")
    private Long id;

    @Column(name = "subtask_title")
    private String title;

    @Column(name = "subtask_done")
    private Boolean done;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
