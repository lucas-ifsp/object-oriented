package doo;

import doo.tes.CheckingAccountFacade;

public class ClientClass {
    public static void main(String[] args) {
        CheckingAccountFacade facade = new CheckingAccountFacade();
        facade.deposit("2032X", "0232", "123321", 221.03);
        facade.withdraw("2032-X", "0232", "123321", "1275-3", "04321", 40.32);
    }
}
