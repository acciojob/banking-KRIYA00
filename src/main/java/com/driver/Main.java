package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {

        BankAccount ba=new BankAccount("Lotak",10000,2000);
        String a=ba.generateAccountNumber(3,20);
        System.out.println("generate account number "+a);
        ba.withdraw(5000);
        CurrentAccount ca=new CurrentAccount("Kotak",1000,"BBBAACCDDE");
        ca.validateLicenseId();
        String b=ca.getTradeLicenseId();
        System.out.println("license id "+b);
    }
}