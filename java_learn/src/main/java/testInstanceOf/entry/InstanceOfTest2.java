package testInstanceOf.entry;

import testInstanceOf.entity.Accounts;
import testInstanceOf.entity.ElectricityAccounts;
import testInstanceOf.entity.WaterAccounts;

/**
 * Created by yukai on 15-9-8.
 */
public class InstanceOfTest2 {

    /**
     *
     * 我们应该尽量少用instanceof 运算符
     * 应该尽量用多态来替代它
     * @param args
     */
    public static void main(String[] args) {

        Accounts waterAccounts = new WaterAccounts();
        Accounts electricityAccounts = new ElectricityAccounts();

        acceptAccounts1(waterAccounts);
        acceptAccounts1(electricityAccounts);

        acceptAccounts2(waterAccounts);
        acceptAccounts2(electricityAccounts);
    }


    /**
     * 第一种使用instanceof
     */
    public static void acceptAccounts1(Accounts accounts) {
        if (accounts instanceof WaterAccounts) {
            System.out.println("收水费");
        } else if (accounts instanceof ElectricityAccounts) {
            System.out.println("收电费");
        }
    }

    /**
     * 第二种使用多态
     */
    public static void acceptAccounts2(Accounts accounts){
        accounts.acceptAcounts();
    }
}
