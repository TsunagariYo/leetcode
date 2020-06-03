package SpringBootException;



/**
 * @ClassName Person
 * @Description
 * @Author Administrator
 * @Date 2020/6/3 0003 17:43
 */

public class Person {
    private Long id;
    private String name;

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
