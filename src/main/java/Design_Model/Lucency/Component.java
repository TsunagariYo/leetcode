package Design_Model.Lucency;

/**
 * 组合不减的抽象类
 */
public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    /// <summary>
    /// 增加一个节点
    /// </summary>
    /// <param name="component"></param>
    public abstract void Add(Component component);

    /// <summary>
    /// 移除一个节点
    /// </summary>
    /// <param name="component"></param>
    public abstract void Remove(Component component);

    /// <summary>
    /// 显示层级结构
    /// </summary>
    public abstract void Display(int level);

}
