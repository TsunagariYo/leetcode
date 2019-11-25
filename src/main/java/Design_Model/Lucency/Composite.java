package Design_Model.Lucency;

import java.util.ArrayList;
import java.util.List;

/// <summary>
/// 定义有枝节点的行为，用来存储部件，实现在Component接口中对子部件有关的操作
/// </summary>
public class Composite extends Component {
    public Composite(String name) {
        super(name);
    }

    /// <summary>
    /// 一个子对象集合，用来存储其下属的枝节点和叶节点
    /// </summary>
    private List<Component> children = new ArrayList<Component>();

    @Override
    public void Add(Component component) {
        children.add(component);
    }

    @Override
    public void Remove(Component component) {
        children.remove(component);
    }

    @Override
    public void Display(int level) {
        System.out.println("-" + level + name);
    // 遍历其子节点并显示
        for (Component component : children) {
            component.Display(level + 2);
        }
    }
}
