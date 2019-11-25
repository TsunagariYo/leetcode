package Design_Model.ProtypeModel;

/**
 * 复制功能接口
 */
public interface Product extends Cloneable {
    public abstract void use(String s);
    public abstract Product creatClone();
}
