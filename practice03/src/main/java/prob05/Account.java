package prob05;

public class Account {
    public Account(String accountNo) {
        System.out.println(accountNo + " 계좌가 개설 되었습니다.");
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    private String accountNo;
    private int balance;

    public void save(int i) {
        System.out.println(accountNo + " 계좌에 " + i + "만원이 입금 되었습니다.");
        balance += i;
    }

    public void deposit(int i) {
        if (balance < i) {
            System.out.println(accountNo + " 계좌에 잔액이 부족합니다. 다시 입력해주세요.");
            return;
        }
        System.out.println(accountNo + " 계좌에 " + i + "만원이 출금 되었습니다.");
        balance -= i;
    }

}
