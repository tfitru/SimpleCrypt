import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.io.FileReader;
import java.io.IOException;

public class ROT13Test {


    @Test
    public void rotateStringTest0() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "ABCDEF";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'A');

        // Then
        Assert.assertTrue(actual.equals(s2));
    }

    @Test
    public void rotateStringTest1() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "DEFABC";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'D');

        // Then
        Assert.assertTrue(actual.equals(s2));
    }

    @Test
    public void rotateStringTest2() {
        // Given
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s2 = "NOPQRSTUVWXYZABCDEFGHIJKLM";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'N');
        System.out.println(s1);
        System.out.println(actual);
        // Then
        Assert.assertTrue(actual.equals(s2));
    }

    @Test
    public void cryptTest1() {
        // Given
        ROT13 cipher = new ROT13('a', 'n');

        String Q1 = "Why did the chicken cross the road?";
        String A1 = "Jul qvq gur puvpxra pebff gur ebnq?";

        String Q2 = "Gb trg gb gur bgure fvqr!";
        String A2 = "To get to the other side!";

        // When
        String actual = cipher.encrypt(Q1);
        System.out.println(Q1);
        System.out.println(A1);
        // Then
        Assert.assertTrue(actual.equals(A1));

        // When
        String actual2 = cipher.decrypt(Q2);
        System.out.println(Q2);
        System.out.println(A2);
        // Then
        Assert.assertTrue(actual2.equals(A2));
    }
    @Test
    public void cryptTest2() {
        // Given
        ROT13 cipher = new ROT13('a', 'n');

        String Q1 = "Why did the chicken cross the road?";
        System.out.println(Q1);

        // When
        String actual = cipher.crypt(cipher.crypt(Q1));
        System.out.println(actual);
        // Then
        Assert.assertTrue(actual.equals(Q1));
    }

    @Test
    public void readTextFileTest() throws IOException {
        // Given
        ROT13 cipher = new ROT13('a', 'n');
        String Q1 = "\n" +
                "Shall I compare thee to a summer’s day?\n" +
                "Thou art more lovely and more temperate:\n" +
                "Rough winds do shake the darling buds of May,\n" +
                "And summer’s lease hath all too short a date;\n" +
                "Sometime too hot the eye of heaven shines,\n" +
                "And often is his gold complexion dimm'd;\n" +
                "And every fair from fair sometime declines,\n" +
                "By chance or nature’s changing course untrimm'd;\n" +
                "But thy eternal summer shall not fade,\n" +
                "Nor lose possession of that fair thou ow’st;\n" +
                "Nor shall death brag thou wander’st in his shade,\n" +
                "When in eternal lines to time thou grow’st:\n" +
                "   So long as men can breathe or eyes can see,\n" +
                "   So long lives this, and this gives life to thee.";

        // When
        String actual = cipher.readTextFile();
        System.out.println(actual);
        // Then
        Assert.assertEquals(actual, Q1);
    }

    @Test
    public void cryptTextFileTest() throws IOException {
        // Given
        ROT13 cipher = new ROT13('a', 'n');
        String Q1 = "\n" +
                "Funyy V pbzcner gurr gb n fhzzre’f qnl?\n" +
                "Gubh neg zber ybiryl naq zber grzcrengr:\n" +
                "Ebhtu jvaqf qb funxr gur qneyvat ohqf bs Znl,\n" +
                "Naq fhzzre’f yrnfr ungu nyy gbb fubeg n qngr;\n" +
                "Fbzrgvzr gbb ubg gur rlr bs urnira fuvarf,\n" +
                "Naq bsgra vf uvf tbyq pbzcyrkvba qvzz'q;\n" +
                "Naq rirel snve sebz snve fbzrgvzr qrpyvarf,\n" +
                "Ol punapr be angher’f punatvat pbhefr hagevzz'q;\n" +
                "Ohg gul rgreany fhzzre funyy abg snqr,\n" +
                "Abe ybfr cbffrffvba bs gung snve gubh bj’fg;\n" +
                "Abe funyy qrngu oent gubh jnaqre’fg va uvf funqr,\n" +
                "Jura va rgreany yvarf gb gvzr gubh tebj’fg:\n" +
                "   Fb ybat nf zra pna oerngur be rlrf pna frr,\n" +
                "   Fb ybat yvirf guvf, naq guvf tvirf yvsr gb gurr.";

        // When
        String actual = cipher.cryptTextFile();
        System.out.println(actual);
        // Then
        Assert.assertEquals(actual, Q1);

    }

    @Test
    public void decryptTextFile() throws IOException {
        // Given
        ROT13 cipher = new ROT13('a', 'n');
        String Q1 = "\n" +
                "Shall I compare thee to a summer’s day?\n" +
                "Thou art more lovely and more temperate:\n" +
                "Rough winds do shake the darling buds of May,\n" +
                "And summer’s lease hath all too short a date;\n" +
                "Sometime too hot the eye of heaven shines,\n" +
                "And often is his gold complexion dimm'd;\n" +
                "And every fair from fair sometime declines,\n" +
                "By chance or nature’s changing course untrimm'd;\n" +
                "But thy eternal summer shall not fade,\n" +
                "Nor lose possession of that fair thou ow’st;\n" +
                "Nor shall death brag thou wander’st in his shade,\n" +
                "When in eternal lines to time thou grow’st:\n" +
                "   So long as men can breathe or eyes can see,\n" +
                "   So long lives this, and this gives life to thee.";

        // When
        String actual = cipher.decryptTextFile();
        System.out.println(actual);
        // Then
        Assert.assertEquals(actual, Q1);
    }


    @Test
    public void encryptTextFileTest() throws IOException {
        // Given
        ROT13 cipher = new ROT13('a', 'n');
        String Q1 = "Funyy V pbzcner gurr gb n fhzzre’f qnl?\n" +
                "Gubh neg zber ybiryl naq zber grzcrengr:\n" +
                "Ebhtu jvaqf qb funxr gur qneyvat ohqf bs Znl,\n" +
                "Naq fhzzre’f yrnfr ungu nyy gbb fubeg n qngr;\n" +
                "Fbzrgvzr gbb ubg gur rlr bs urnira fuvarf,\n" +
                "Naq bsgra vf uvf tbyq pbzcyrkvba qvzz'q;\n" +
                "Naq rirel snve sebz snve fbzrgvzr qrpyvarf,\n" +
                "Ol punapr be angher’f punatvat pbhefr hagevzz'q;\n" +
                "Ohg gul rgreany fhzzre funyy abg snqr,\n" +
                "Abe ybfr cbffrffvba bs gung snve gubh bj’fg;\n" +
                "Abe funyy qrngu oent gubh jnaqre’fg va uvf funqr,\n" +
                "Jura va rgreany yvarf gb gvzr gubh tebj’fg:\n" +
                "   Fb ybat nf zra pna oerngur be rlrf pna frr,\n" +
                "   Fb ybat yvirf guvf, naq guvf tvirf yvsr gb gurr.";
        // When
        String actual = cipher.encryptFile();
        FileReader fr = new FileReader("/Users/fitru/Projects/SimpleCrypt/SimpleCryptClass/sonnet18.enc");
        String f = "";
        int i;
        while((i = fr.read()) != -1){
            f += (char)i;
        }
        fr.close();
        String actualRead = f;
        System.out.println(actualRead);
        // Then
        Assert.assertEquals(actual, actualRead);
    }

    @Test
    public void decryptTextFileTest() throws IOException {
        // Given
        ROT13 cipher = new ROT13('a', 'n');
        String Q1 = "\n" +
                "Shall I compare thee to a summer’s day?\n" +
                "Thou art more lovely and more temperate:\n" +
                "Rough winds do shake the darling buds of May,\n" +
                "And summer’s lease hath all too short a date;\n" +
                "Sometime too hot the eye of heaven shines,\n" +
                "And often is his gold complexion dimm'd;\n" +
                "And every fair from fair sometime declines,\n" +
                "By chance or nature’s changing course untrimm'd;\n" +
                "But thy eternal summer shall not fade,\n" +
                "Nor lose possession of that fair thou ow’st;\n" +
                "Nor shall death brag thou wander’st in his shade,\n" +
                "When in eternal lines to time thou grow’st:\n" +
                "   So long as men can breathe or eyes can see,\n" +
                "   So long lives this, and this gives life to thee.";
        // When
        String encrypt = cipher.encryptFile();
        String actual = cipher.decryptFile();
        FileReader fr = new FileReader("/Users/fitru/Projects/SimpleCrypt/SimpleCryptClass/sonnet18.enc");
        String f = "";
        int i;
        while((i = fr.read()) != -1){
            f += (char)i;
        }
        fr.close();
        String actualRead = f;
        System.out.println(actualRead);
        // Then
        Assert.assertEquals(actual, actualRead);
    }


}