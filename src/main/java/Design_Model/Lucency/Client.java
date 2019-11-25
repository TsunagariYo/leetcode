package Design_Model.Lucency;

public class Client {
    public static void main(String[] args) {
        // 生成树根，并为其增加两个叶子节点
        Component root = new Composite("Root");
        root.Add(new Leaf("Leaf A in Root"));
        root.Add(new Leaf("Leaf B in Root"));

        // 为根增加两个枝节点
        Component branchX = new Composite("Branch X in Root");
        Component branchY = new Composite("Branch Y in Root");
        root.Add(branchX);
        root.Add(branchY);

        // 为BranchX增加页节点
        branchX.Add(new Leaf("Leaf A in Branch X"));

        // 为BranchX增加枝节点
        Component branchZ = new Composite("Branch Z in Branch X");
        branchX.Add(branchZ);

        // 为BranchY增加叶节点
        branchY.Add(new Leaf("Leaf in Branch Y"));

        // 为BranchZ增加叶节点
        branchZ.Add(new Leaf("Leaf in Branch Z"));

        // 显示树
        root.Display(1);
    }
}
