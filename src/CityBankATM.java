import java.util.Scanner;

public class CityBankATM {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите ваш AccountNumber:");
        String accountNumber = in.next();
        System.out.println("Введите ваш пин-код");
        String pinCode = in.next();
        int activeUser = -1;

        for (int i = 0; i < Database.allAccounts.length; i++) {
            if (accountNumber.equals(Database.allAccounts[i].getAccountNumber()) && pinCode.equals(Database.allAccounts[i].getPinCode())) {
                activeUser = i;
            }
        }
        if (activeUser != -1) {
            if (Database.allAccounts[activeUser] instanceof CityBankAccount) {
                while (true) {
                    System.out.println("PRESS [1] TO CASH WITHDRAWAL  // снять деньги");
                    System.out.println("PRESS [2] TO VIEW BALANCE // просмотр баланса");
                    System.out.println("PRESS [3] TO CHANGE PIN CODE // изменить пин код");
                    System.out.println("PRESS [4] TO CASH IN ACCOUNT // добавить деньги в счет");
                    System.out.println("PRESS [5] TO VIEW ACCOUNT DATA // просмотр данные счета");
                    System.out.println("PRESS [6] Exit ");
                    String choice = in.next();

                    if (choice.equals("1")) {
                        System.out.println("Введите сумму снятия денег");
                        int money = in.nextInt();
                        if (money > ((CityBankAccount) Database.allAccounts[activeUser]).balance) {
                            System.out.println();
                            System.out.println("У вас недостаточно денег для снятия");
                            System.out.println();
                        } else {
                            Database.allAccounts[activeUser].creditBalance(money);
                            System.out.println();
                            System.out.println("Your balance" + ((CityBankAccount) Database.allAccounts[activeUser]).getBalance());
                            System.out.println();
                        }
                    }
                    if (choice.equals("2")) {
                        System.out.println("Ваш баланс равен = " + ((CityBankAccount) Database.allAccounts[activeUser]).totalBalance());
                    }
                    if (choice.equals("3")) {
                        System.out.println("Введите пин-код: ");
                        String pinCode1 = in.next();
                        if(pinCode1.equals(Database.allAccounts[activeUser].getPinCode())){
                            System.out.println("Введите новый пин-код:");
                            String newPinCode = in.next();
                            Database.allAccounts[activeUser].setPinCode(newPinCode);
                            System.out.println("Ваш новый пин-код = " + (((CityBankAccount) Database.allAccounts[activeUser]).pinCode));
                        }else {
                            System.out.println("Неврно введен пин-код");
                        }
                    }
                    if (choice.equals("4")) {
                        System.out.print("Введите сумму пополнения: ");
                        int debet = in.nextInt();
                        Database.allAccounts[activeUser].debetBalance(debet);
                        System.out.println(Database.allAccounts[activeUser].totalBalance());
                    }
                    if (choice.equals("5")) {
                        System.out.println("Account Data: " + Database.allAccounts[activeUser].accountData());
                    }
                    if (choice.equals("6")) {
                        break;
                    }
                }
            } else {
                while (true) {
                    System.out.println("[PRESS 1] для снятия денег");
                    System.out.println("[PRESS 2] для просмотра баланса");
                    System.out.println("[PRESS 3] EXIT");
                    String choiseKaspi = in.next();
                    if (choiseKaspi.equals("1")) {
                        System.out.println("Введите сумму для снятия");
                        int creditKaspi = in.nextInt();
                        if (creditKaspi > Database.allAccounts[activeUser].totalBalance()) {
                            System.out.println("У вас недостаточно средств");
                        } else {
                            Database.allAccounts[activeUser].creditBalance(creditKaspi - 200);
                        }
                    }
                    if (choiseKaspi.equals("2")){
                        System.out.println("Ваш баланс = " + Database.allAccounts[activeUser].totalBalance());
                    }
                    if (choiseKaspi.equals("3")){
                        break;
                    }
                }
            }
        }
    }
}