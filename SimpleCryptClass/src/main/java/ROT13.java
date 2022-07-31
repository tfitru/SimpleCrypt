import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {

    String str = "";
    String encrypt = "";

    Character cs;

    Character cf;

    ROT13(Character cs, Character cf) {
        this.cs = cs;
        this.cf = cf;
    }

    ROT13() {
    }


    public String crypt(String text) throws UnsupportedOperationException {
        char[] textChar = text.toCharArray();
        for(int i = 0; i<textChar.length; i++){
            char letter = textChar[i];

            if(letter >= 'a' && letter <= 'z'){
                if(letter > 'm'){
                    letter -= 13;
                } else {
                    letter += 13;
                }
            } else if (letter>= Character.toUpperCase('a') && letter <= Character.toUpperCase('z')){
                if(letter > 'M'){
                    letter -= 13;
                } else {
                    letter += 13;
                }
            }
            textChar[i] = letter;
        }


        return new String(textChar);
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        String left = "";
        String right = "";
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)<c){
                left = left + s.charAt(i);
            } else
                right = right + s.charAt(i);
        }
        return right + left;
    }

    public String readTextFile() throws IOException {
        File file = new File("/Users/fitru/projects/simplecrypt/sonnet18.txt");
        Scanner myReader = new Scanner(file);

        String st = "";
        while(myReader.hasNextLine()){
            st += "\n" +myReader.nextLine();
        }



        return st;
    }

    public String cryptTextFile() throws IOException {
        File file = new File("/Users/fitru/projects/simplecrypt/sonnet18.txt");
        Scanner myReader = new Scanner(file);

        String st = "";
        while(myReader.hasNextLine()){
            st += "\n" +myReader.nextLine();
        }

        String crypt = crypt(st);


        return crypt;

    }


    public String decryptTextFile() throws IOException {
        File file = new File("/Users/fitru/projects/simplecrypt/sonnet18.txt");
        Scanner myReader = new Scanner(file);


        while(myReader.hasNextLine()){
            str += "\n" +myReader.nextLine();
        }

        String crypt = crypt(str);


        return decrypt(crypt);

    }

    public String encryptFile() throws IOException {
//        File f = new File("Icecream.txt");
//        System.out.println(f.getAbsoluteFile());
        FileReader fr = new FileReader("/Users/fitru/Projects/SimpleCrypt/sonnet18.txt");

        FileWriter fw = new FileWriter("sonnet18.enc");

        int i;

        while((i = fr.read()) != -1){
            str += (char)i;
        }

        encrypt = crypt(str);

        fw.write(encrypt);

        fr.close();
        fw.close();


        return encrypt;


    }

    public String decryptFile() throws IOException {
//        File f = new File("Icecream.txt");
//        System.out.println(f.getAbsoluteFile());
        FileReader fr = new FileReader("/Users/fitru/Projects/SimpleCrypt/SimpleCryptClass/sonnet18.enc");


        int i;

        while((i = fr.read()) == -1){
            str += (char)i;

        }



        fr.close();
        String decrypt = decrypt(encrypt);
        PrintWriter pr = new PrintWriter("/Users/fitru/Projects/SimpleCrypt/SimpleCryptClass/sonnet18.enc");

        pr.write(decrypt);
        pr.close();


        return decrypt;


    }


}
