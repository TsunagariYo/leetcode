package DataStructure.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Children
 * @Description
 * @Author Administrator
 * @Date 2020/6/5 0005 11:16
 */
public class Children {
    private List<Node> list =new ArrayList<Node>();
    public List<Node> getList() {
        return list;
    }

    public void setList(List<Node> list) {
        this.list = list;
    }
    public int getSize() {
        return list.size();
    }
    public void addChild(Node node) {
        list.add(node);
    }
}
