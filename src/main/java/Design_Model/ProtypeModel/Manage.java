package Design_Model.ProtypeModel;

import java.util.HashMap;

/**
 * 使用product接口来复制实例
 */
public class Manage {
    //保存实例和实例名称之间的对应关系
    private HashMap<String,Product> showcase = new HashMap<String, Product>();
    //register方法将接收到的一组“名字”和“Product接口”注册到showcase中。这里Product是实现Product接口的实例，具体还未确定
    public void register(String name ,Product product){
        showcase.put(name, product);
    }
    public Product create(String productname){
        Product p=showcase.get(productname);
        return p.creatClone();
    }

}
