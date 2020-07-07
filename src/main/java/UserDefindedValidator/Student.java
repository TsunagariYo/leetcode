package UserDefindedValidator;


/**
 * @ClassName Student
 * @Description
 * @Author Administrator
 * @Date 2020/7/7 0007 10:12
 */

public class Student {
    private String name;
    @FlagValidator(value = {"18"}, message = "年龄不正确")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
