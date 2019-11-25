package Design_Model.FacadeModel;

public class Client {
    public static void main(String[] args) {
        Fund fund = new Fund();
        //基金购买
        fund.buyFund();
        System.out.println("-------------");
        //基金赎回
        fund.sellFund();
    }
}
