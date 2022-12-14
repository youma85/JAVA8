package ma.gp.formation.java;

public class Provider {
    private Integer id;
    private String name;

    public Provider(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public Provider setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Provider setName(String name) {
        this.name = name;
        return this;
    }
}
