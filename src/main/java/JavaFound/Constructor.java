package JavaFound;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Arrays;

/**
 * @ClassName Constructor
 * @Description 构造器加载
 * @Author Administrator
 * @Date 2019/12/25 0025 10:30
 * <p>
 * 构造器的加载顺序是:基类的构造器 -->成员变量的构造方法 -->  导出类的构造器
 * <p>
 * 方法的执行顺序是自下而上的
 */

//案例1       继承和清理
class Characteristic {
    private String s;

    Characteristic(String s) {
        this.s = s;
        System.out.println("Creating Characteristic " + s);
    }

    protected void dispose() {
        System.out.println("Dispose Characteristic" + s);
    }
}

class Description {
    private String s;

    Description(String s) {
        this.s = s;
        System.out.println("Creating Description " + s);
    }

    protected void dispose() {
        System.out.println("Dispose Description" + s);
    }
}

class LivingCreature {
    private Characteristic p = new Characteristic("is alive");
    private Description t = new Description("Basic Living Creature");

    public LivingCreature() {
        System.out.println("LivingCreature()");
    }

    protected void dispose() {
        System.out.println("LivingCreature dispose");
        p.dispose();
        t.dispose();
    }
}

class Animal extends LivingCreature {
    private Characteristic p = new Characteristic("has heart");
    private Description t = new Description("Animal not vegetable");

    Animal() {
        System.out.println("Animal()");
    }

    @Override
    protected void dispose() {
        System.out.println("Animal dispose");
        p.dispose();
        t.dispose();
        super.dispose();
    }
}

class Ampibian extends Animal {
    private Characteristic p = new Characteristic("can live In water");
    private Description t = new Description("both water and land");

    Ampibian() {
        System.out.println("Ampibian()");
    }

    @Override
    protected void dispose() {
        System.out.println("Ampibian dispose");
        p.dispose();
        t.dispose();
        super.dispose();
    }
}

class Frog extends Ampibian {
    private Characteristic p = new Characteristic("Croaks");
    private Description t = new Description("Eats bugs");

    Frog() {
        System.out.println("Frog()");
    }

    @Override
    protected void dispose() {
        System.out.println("Frog dispose");
        p.dispose();
        t.dispose();
        super.dispose();
    }

    public static void main(String[] args) {
        Frog frog = new Frog();
        System.out.println("bye");
        frog.dispose();
    }
}

//案例2
class Shard {
    private int refcount = 0;
    private static long counter = 0;
    private final long id = counter++;

    public Shard() {
        System.out.println("Creating" + this);
    }

    public void addRef() {
        refcount++;
    }

    protected void dispose() {
        if (--refcount == 0) {
            System.out.println("Disposing" + this);
        }
    }

    @Override
    public String toString() {
        return "Shared" + id;
    }
}

class Composing {
    private Shard shard;
    private static long counter = 0;
    private final long id = counter++;

    public Composing(Shard shard) {
        System.out.println("Creating" + this);
        this.shard = shard;
        this.shard.addRef();
    }

    protected void dispose() {
        System.out.println("Disposing" + this);
        shard.dispose();
    }

    @Override
    public String toString() {
        return "Composing" + id;
    }
}

class ReferenceCounting {
    public static void main(String[] args) {
        Shard shard = new Shard();
        Composing[] composings = {new Composing(shard), new Composing(shard), new Composing(shard), new Composing(shard), new Composing(shard)};
        for (Composing composing : composings) {
            composing.dispose();
        }
    }
}


//案例3

class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }

    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    RoundGlyph(int radius) {
        this.radius = radius;
        System.out.println("RoundGlyph.RoundGlyph() , radius = " + this.radius);
    }

    void draw() {
        System.out.println("Roundglyph.draw() , radius = " + radius);
    }
}

class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}

//案例4  协变返回类型

class Grain {
    @Override
    public String toString() {
        return "Grain";
    }
}

class Wheat extends Grain {
    @Override
    public String toString() {
        return "Wheat";
    }
}

class Mill {
    Grain process() {
        return new Grain();
    }
}

class WheatMill extends Mill {
    Wheat process() {
        return new Wheat();
    }
}

class CovariantReturn {
    public static void main(String[] args) {
        Mill mill = new Mill();
        Grain grain = mill.process();
        System.out.println(grain);
        mill = new WheatMill();
        grain = mill.process();
        System.out.println(grain);
    }
}


//案例 5   纯继承和扩展
class Actor {
    public void act() {
    }
}

class HappyActor extends Actor {
    @Override
    public void act() {
        System.out.println("HappyActor");
    }
}

class SadActor extends Actor {
    @Override
    public void act() {
        System.out.println("SadActor");
    }
}

class Stage {
    private Actor actor = new HappyActor();

    public void change() {
        actor = new SadActor();
    }

    public void performplay() {
        actor.act();
    }
}

class Transmogrify {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performplay();
        stage.change();
        stage.performplay();
    }
}

//案例6 向下转型
class Useful {
    public void f() {
    }

    ;

    public void g() {
    }

    ;
}

class MoreUseful extends Useful {
    @Override
    public void f() {
    };

    @Override
    public void g() {
    };

    public void u() {
    };

    public void v() {
    };

    public void w() {
    };
}

class RTTI {
    public static void main(String[] args) {
        Useful[] usefuls = {new Useful(), new MoreUseful()};
        usefuls[0].f();
        usefuls[1].g();
        ((MoreUseful) usefuls[0]).u();   //异常 java.lang.ClassCastException
        ((MoreUseful) usefuls[1]).u();
    }
}


