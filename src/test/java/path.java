class soap {
    private String s;

    public soap() {
        System.out.println("Soap()");
        s = "Comstructed";
    }

    @Override
    public String toString() {
        return s;
    }
}

public class path {
    private String s1 = "happy", s2 = "happy", s3, s4;
    private soap cast;
    private int i;
    private float toy;

    public path() {
        System.out.println("Inside path()");
        s3 = "joy";
        toy = 3.14f;
        cast = new soap();
    }

    @Override
    public String toString() {
        if (s4 == null) {
            s4 = "joy";
        }
        return "s1 = " + s1 + "\n" +
                "s2 = " + s2 + "\n" +
                "s3 = " + s3 + "\n" +
                "s4 = " + s4 + "\n" +
                "i = " + i + "\n" +
                "toy = " + toy + "\n" +
                "cast = " + cast;
    }

    public static void main(String[] args) {
        path path = new path();
        System.out.println(path);
    }
}
