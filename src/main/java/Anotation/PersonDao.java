package Anotation;

/**
 * @ClassName PersonDao
 * @Description
 * @Author Administrator
 * @Date 2020/7/27 0027 14:40
 */
public class PersonDao {
    private Person person;

    public Person getPerson() {
        return person;
    }

    @InjectPerson(username = "zhongfucheng",age = 20)
    public void setPerson(Person person) {
        this.person = person;
    }
}
