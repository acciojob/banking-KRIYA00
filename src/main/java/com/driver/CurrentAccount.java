package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
       super(name,balance,5000);
       this.tradeLicenseId=tradeLicenseId;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if(check(tradeLicenseId)) {
            String ans = reorganizeString(tradeLicenseId);
            if (ans == "") {
                throw new Exception("Valid License can not be generated");
            } else {
                tradeLicenseId = ans;
            }
        }


    }
    public boolean check(String tradeLicenseId)
    {
        int len=tradeLicenseId.length();
        for(int i=1;i<len;i++)
        {
            if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i-1))
                return true;
        }
        return false;

    }
    public String reorganizeString(String s)
    {
        int len=s.length();
        int[]temp=new int[26];
        int max=0;
        char in='a';
        char[]ch=s.toCharArray();
        for(int i=0;i<len;i++)
        {
            temp[ch[i]-'A']++;
            if(temp[ch[i]-'A']>max)
            {
                max=temp[ch[i]-'A'];
                in=ch[i];
            }
        }
        if(max>(len+1)/2)
            return "";
        char[]ans=new char[len];

        int i=0;
        while(temp[in-'A']>0)
        {
            ans[i]=in;
            i+=2;
            temp[in-'A']--;
        }
        for(int j=0;j<26;j++)
        {
            while(temp[j]>0)
            {
                if(i>=len)
                {
                    i=1;
                }
                ans[i]=(char)(j+'A');
                i+=2;
                temp[j]--;
            }
        }
        return String.valueOf(ans);

    }

}
