public class Database {
    public static  BankAccount[] allAccounts = new BankAccount[10];
    static {
        allAccounts[0] = new CityBankAccount("Dilshat","Yussupzhanov",50000,"0101", "2000");
        allAccounts[1] = new CityBankAccount("Erbol","Assanbek",100000,"0110", "9900");
        allAccounts[2] = new CityBankAccount("Brad","Pitt",200000,"0102", "1000");
        allAccounts[3] = new CityBankAccount("Johnny","Depp",450000,"0103", "3000");
        allAccounts[4] = new CityBankAccount("Amir","Altayev",1000000,"0104", "0001");

        allAccounts[5] = new KaspiBankAccount("Leo DiCaprio",300000,"0105", "4000");
        allAccounts[6] = new KaspiBankAccount("Robert De Niro",500000,"0106", "5000");
        allAccounts[7] = new KaspiBankAccount("Martin Scorcese",600000,"0107", "6000");
        allAccounts[8] = new KaspiBankAccount("Quentin Tarantino",700000,"0108", "7000");
        allAccounts[9] = new KaspiBankAccount("Guy Ritchie",800000,"0109", "8000");
    }

}
