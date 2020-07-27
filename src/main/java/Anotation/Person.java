package Anotation;

/**
 * @ClassName Person
 * @Description
 * @Author Administrator
 * @Date 2020/7/27 0027 14:55
 */
public class Person {
    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
    protected void test(){
        System.out.println("哈哈");
    }
}
