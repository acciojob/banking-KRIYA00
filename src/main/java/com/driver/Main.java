package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {

        BankAccount ba=new BankAccount("Lotak",10000,2000);
        ba.generateAccountNumber(3,20);
        ba.withdraw(5000);
        CurrentAccount ca=new CurrentAccount("Kotak",1000,"BBBAACCDDE");
        ca.validateLicenseId();
        String b=ca.getTradeLicenseId();
        System.out.println("license id "+b);
    }
}