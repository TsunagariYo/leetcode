package DataStructure;

/**
 * 链表
 */
public class ListNodeDemo {

    int val;  //数值
    ListNodeDemo next;  //结点node

    //有参构造
    public ListNodeDemo(int val) {
        this.val = val;
    }

    //添加新的节点
    public void add(int newval) {
        ListNodeDemo newnode = new ListNodeDemo(newval);
        if (this.next == null) {
            this.next = newnode;
        } else {
            this.next.add(newval);
        }
    }

    public ListNodeDemo getNext() {
        return next;
    }

    public int getVal() {
        return val;
    }

    //输入节点
    public void print() {
        System.out.print(this.val);
        if (this.next != null){
            System.out.print("-->");
            this.next.print();
        }
    }
}