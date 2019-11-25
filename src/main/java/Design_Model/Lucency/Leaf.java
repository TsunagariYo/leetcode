package Design_Model.Lucency;

/// <summary>
/// 叶子节点
/// </summary>
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }
    /// <summary>
    /// 由于叶子节点没有子节点，所以Add和Remove方法对它来说没有意义，但它继承自Component，这样做可以消除叶节点和枝节点对象在抽象层次的区别，它们具备完全一致的接口。
    /// </summary>
    /// <param name="component"></param>
    @Override
    public void Add(Component component) {
        System.out.println("Can not add a component to a leaf.");
    }

    @Override
    public void Remove(Component component) {
        System.out.println("Can not remove a component to a leaf.");
    }

    @Override
    public void Display(int level) {
        System.out.println("-"+level + name);
    }
}
