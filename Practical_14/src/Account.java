public class Account {
    int money = 0;
    int accNumber = 0;
    boolean status = false;

    public Account(int money, int accNumber) {
        this.money = money;
        this.accNumber = accNumber;
    }

    public int addMoney(int money){
        return this.money += money;
    }

    public int subtract(int money){
        return this.money -= money;
    }

    public int getMoney() {
        return money;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public boolean getStatus() {
        return status;
    }

    public void blockAccNumber(){
        status = true;
    }
}
