package cn.jast.java.offer;

/**
 * 请实现一个函数/方法，法字符串中的每个空格替换成"%20"。例如输入“We are happy“，则输出“We%20are%20happy”
 */
public class BlankSpaceReplace {

    //TODO
    public void replace(char[] str){
        int blankCount = 0;
        for (char c : str) {
            if(c==' '){
                blankCount++;
            }
        }
    }

    public static void main(String[] args) {
        char[] chars = new char[2000];
        chars[0] = 'a';
        chars[2] = 'b';
        int count = 0;
        for (int i = 0; i < 2000; i++) {
//            System.out.println((int)chars[i]);
            if(chars[i]=='\0'){
                continue;
            }
            count++;
        }
        System.out.println((int)chars[1]);
        System.out.println(count);
        System.out.println(chars.length);
        System.out.println(chars);
    }
}
