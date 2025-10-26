package com.leetcode.arrays;

public class SimpleBankSystem {

    //https://leetcode.com/problems/simple-bank-system
    //Time Complexity: O(1) for each operation
    //Space Complexity: O(n)

    long[] balance;
    int size;

    public SimpleBankSystem(long[] balance) {
        this.balance = balance;
        size = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(validAccount(account1) && validAccount(account2) && balance[account1 - 1] >= money){
            balance[account2 -1] += money;
            balance[account1 -1] -= money;
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if(validAccount(account)){
            balance[account -1] += money;
            return true;
        }
        return false;

    }

    public boolean withdraw(int account, long money) {
        if(validAccount(account) && balance[account - 1] >= money){
            balance[account -1] -= money;
            return true;
        }
        return false;
    }

    private boolean validAccount(int account){
        return account > 0 && account <= size;
    }
}
