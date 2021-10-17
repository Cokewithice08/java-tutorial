package cn.jastz.prototype;

public class Client {

    public static void main(String[] args) {

        try {
            Email email = new Email();
            email.setTo("337235669@qq.com");
            Email emailCopy = (Email) email.clone();
            System.out.println(email);
            System.out.println(emailCopy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
/*

        try {
            NoCloneableEmail email = new NoCloneableEmail();
            email.setTo("337235669@qq.com");
            NoCloneableEmail emailCopy = (NoCloneableEmail) email.clone();//抛出CloneNotSupportedException
            System.out.println(email);
            System.out.println(emailCopy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
*/

    }
}
