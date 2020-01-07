package Knowledge;

/**
 * @ClassName BooleanTest
 * @Description 测试Boolean占几个字节
 * @Author Administrator
 * @Date 2019/12/23 0023 9:27
 * @Result 在JVM满足规范的情况下, 单个Boolean值在编译时候被转化为int值, 占四个字节. 在Boolean数组下Boolean 占1个字节
 */
class LotsOfBooleans {
    boolean a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, aa, ab, ac, ad, ae, af;
    boolean b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bb, bc, bd, be, bf;
    boolean c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, ca, cb, cc, cd, ce, cf;
    boolean d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, da, db, dc, dd, de, df;
    boolean e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, ea, eb, ec, ed, ee, ef;
}

class LotsOfInts {
    int a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, aa, ab, ac, ad, ae, af;
    int b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bb, bc, bd, be, bf;
    int c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, ca, cb, cc, cd, ce, cf;
    int d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, da, db, dc, dd, de, df;
    int e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, ea, eb, ec, ed, ee, ef;
}
public class BooleanTest {


    private static final int Size = 1000000;

    public static void main(String[] args) {
        LotsOfBooleans[] first = new LotsOfBooleans[Size];
        LotsOfInts[] second = new LotsOfInts[Size];
        System.gc();
        long startMem = getMemory();
        for (int i = 0; i < Size; i++) {
            first[i] = new LotsOfBooleans();
        }
        System.gc();
        long endMem = getMemory();
        System.out.println("Size of Boolean" +(endMem-startMem));
        System.out.println("Average size" + ((endMem-startMem)/(double)Size));
        System.gc();
        startMem = getMemory();
        for (int i=0; i < Size; i++)
        {
            second[i] = new LotsOfInts();
        }
        System.gc();
        endMem = getMemory();

        System.out.println ("Size for LotsOfInts: " + (endMem-startMem));
        System.out.println ("Average size: " + ((endMem-startMem) / ((double)Size)));

        // Make sure nothing gets collected
        long total = 0;
        for (int i=0; i < Size; i++)
        {
            total += (first[i].a0 ? 1 : 0) + second[i].a0;
        }
        System.out.println(total);

    }

    private static long getMemory() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

}
