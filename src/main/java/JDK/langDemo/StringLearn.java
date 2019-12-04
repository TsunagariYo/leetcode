package JDK.langDemo;


import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * serialVersionUID   实现序列化和反序列化
 * 实现Serializable(序列化和反序列化),Comparable(比较器),CharSequence(长度,字符集,字符序列,迭代器,)接口
 * <p>
 * 静态变量
 * ObjectStreamField[] serialPersistentFields = new ObjectStreamField[0];
 * <p>
 * 全局变量:
 * final char value[];  字符串的存储,不可变的
 * hash
 * <p>
 * 构造方法
 * 无参  this.value = "".value;
 * 有参  参数为String ①this.value = original.value;    this.hash = original.hash;
 * 参数为char数组②this.value = Arrays.copyOf(value, value.length);(复制数组,可以达到扩容的效果)
 * 参数为(char value[], int offset, int count)
 * 参数为int[] codePoints, int offset, int count
 * ......
 * <p>
 * 方法
 *
 *
 *
 *
 * CaseInsensitiveComparator   实现Comparator接口   类似于equalsIgnoreCase方法,不区分大小写
 */
public class StringLearn {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "a,b,c,d,e,f";
        int length = s.length();        //长度
        boolean empty = s.isEmpty();    //是否为空
        char c = s.charAt(1);           //例:b  指定位置的字符
        int point = s.codePointAt(1);   //例:98   指定索引的code码
        int codePointBefore = s.codePointBefore(1);  //例: 97    指定索引前一个值的code码
        int codePointCount = s.codePointCount(1, 4);   //例: 3     计算两个索引中值得个数
        int offsetByCodePoints = s.offsetByCodePoints(1, 5); // 6   计算偏移后的索引数
        char dst[] = new char[10];
        s.getChars(1, 2, dst, 3); //dst =____b_______  无返回, 把从1-2索引的char复制到dst上从3索引开始
        byte[] bytes = s.getBytes(StandardCharsets.ISO_8859_1);  //指定字符集转化为字节形式
        byte[] bytes1 = s.getBytes();           //指定字符集
        boolean equals = s.equals("dddd");     //判断字符内容是否相等    判断一个个字符是否相等实现
        StringBuffer buffer = new StringBuffer("abcdef");
        boolean b = s.contentEquals(buffer);   //true   判断和StringBuffer的数是否相等
        CharSequence charSequence = "abcdef";  //接口   是很多字符集的统一接口
        boolean contentEquals = s.contentEquals(charSequence);// true
        boolean b1 = s.equalsIgnoreCase(s.toUpperCase());   //忽略大小写
        int i = s.compareTo("abcdef");          //比较器 返回0位true,其他为0
        int compare = s.compareToIgnoreCase("ABCDef");    //忽略大小写的比较
        boolean r = s.regionMatches(true, 0, "abcdefgh", 0, s.length());//测试两个字符串区域是否相等,toffset为原字符串的起始位置,ooffset为比较的字符串你的起始位,s.length为比较的长度。 true为忽略大小
        boolean starts = s.startsWith("ab");        //true   是否是参数字符串开始
        boolean bc = s.startsWith("bc", 1);   //true   从第toffset索引开始  是否是以prefix开头
        boolean f = s.endsWith("f");        //true    是否是以"f"结尾
        int hashCode = s.hashCode();        //计算hashcode值      31*hash + value[i]  循环生成的一个int参数
        int indexOf = s.indexOf(98, 0);  //例: 1     寻找对应asc码的字符串的位置索引,fromIndex是指从哪个位置开始
        int index = s.indexOf("ab", 0);     //判断是否是s的子串并且从哪个索引开始的子串
        String substring = s.substring(2);          //截取字符串
        String concat = s.concat("jhgi");       //abcdefjhgi    合并字符串   通过新的字符串然后通过getChars方法吧"jhgi"加入到新的char数组里
        String replace = s.replace('a', ' '); //替换对应的字符    通过构建一个新的字符数组替换;
        boolean matches = s.matches("");        //正则校验,          通过Pattern对象来实现
        boolean contains = s.contains("ab");        //是否包含字符串"ab"       通过indexof方法实现
        String replaceFirst = s.replaceFirst("", "aa");     //替换匹配的第一个字符串
        String s1 = s.replaceAll("", "");       //替换正则匹配的所有的字符串
        String[] split = s.split(",");       //字符分割                                             ****************************************** 难点


        System.out.println(contains);
    }
}