package Enum;

public enum DemoEnum {
    Red("红色"),Green("绿色"),Yellow("黄色"),Blank("白色");
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    DemoEnum() {
    }

    DemoEnum(String name) {
        this.name = name;
    }
}
