package JavaFound;

import java.util.Random;

/**
 * 多态是通过动态绑定(也称为后期绑定或者运行时绑定)实现的: java除了static和final方法外都是后期绑定
 * 1.多态访问的,子类具有父类的接口方法,所以子类可以作为父类的参数替代
 * 2.
 * <p>
 * 优点:1.使得对象类型得到复用
 * 缺点:1.需要对每一个子类编写方法(知识把类方法分写到了不同个的子类上)
 * 2.覆盖私有方法
 * 3.域和静态方法
 *
 * @ClassName Polymorphic
 * @Description 多态的理解
 * @Author Administrator
 * @Date 2019/12/18 0018 15:59
 */
enum Note {
    MIDDE_C, C_SHARP, B_FLAT;
}

class Instrument {
    public void play(Note n) {
        System.out.println("Instrument.play()");
    }
}

class wind extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("wind.play()" + n);
    }
}

public class Polymorphic {
    //音符的枚举类
    public static void tune(Instrument i) {
        i.play(Note.MIDDE_C);
    }

    public static void main(String[] args) {
        wind wind = new wind();
        tune(wind);
    }

}


/**
 * 图形生成
 */
//图形
class shape {
    void draw() {
    }

    ;

    void erase() {
    }

    ;
}

class Circle extends shape {
    @Override
    void draw() {
        System.out.println("Circle.draw()");
    }

    @Override
    void erase() {
        System.out.println("circle.erase()");
    }
}

class Square extends shape {
    @Override
    void draw() {
        System.out.println("Square.draw()");
    }

    @Override
    void erase() {
        System.out.println("Square.erase()");
    }
}

class Triangle extends shape {
    @Override
    void draw() {
        System.out.println("Triangle.draw()");
    }

    @Override
    void erase() {
        System.out.println("Triangle.erase()");
    }
}

class RandomShapGenerator {
    private Random random = new Random(47);

    public shape next() {
        switch (random.nextInt(3)) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
        }
    }
}

class Shaps {
    private static RandomShapGenerator gen = new RandomShapGenerator();

    public static void main(String[] args) {
        shape[] shapes = new shape[9];
        for (int i = 0; i < shapes.length; i++)
            shapes[i] = gen.next();
        for (shape shape : shapes) {
            shape.draw();
        }

    }
}

class PrivateOverride {
    private void f() {
        System.out.println("private f");
    }

    public static void main(String[] args) {
        Derived derived = new Derived();
        derived.f();

    }
}

class Derived extends PrivateOverride {
    public void f() {
        System.out.println("public f");
    }
}


class sup {
    public int filed = 0;

    public int getFiled() {
        return filed;
    }
}

class sub extends sup {
    public int filed = 1;

    @Override
    public int getFiled() {
        return filed;
    }

    public int getSupFiled() {
        return super.filed;
    }
}

/**
 * 问题原因:在多态的情况下,sub 实际上拥有两个Filed的域,在getFiled()时候引用指向了sub.filed,但是要想得到sup.filed,则需要super.filed
 *
 * 多态下,域使用的是父类的域,而方法使用的是子类的方法,但是静态方法不是
 */
class FiledAccess {
    public static void main(String[] args) {
        sup sup = new sub();
        System.out.println("sup.filed:" + sup.filed + ",sup.getFiled():" + sup.getFiled());
        sub sub = new sub();
        System.out.println("sub.filed:"+sub.filed+",sub.getFiled():"+sub.getFiled()+",sub.getSupFiled():"+sub.getSupFiled());
    }
}

