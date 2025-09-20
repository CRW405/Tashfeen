
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Decipher {
    public static void main(String[] args) {
        int m = (int) Math.pow(2, 7); // = 128
        char[] cipher = new char[m] // char array with length of 128, set to null by default
        ;
        for (int i = 0; i < m; i++)
            cipher[i] = (char) mod(7 * i + 3, m); // array[1] = mod(10,128) = ((10 % 128) + 128) % 128 = 10 | array[2] =
                                                  // mod(17,128) = 17 | [3] = 24

        String plain = read("./cipher.txt"); // obvious, read plain text in

        // for (int i = 0; i < plain.length(); i++)
        // set each char to corresponding mod value
        // System.out.print(cipher[plain.charAt(i)]);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        String message = "";

        for (int i = 0; i < plain.length(); i++) {
            char cursor = plain.charAt(i);

            for (int j = 0; j < cipher.length; j++) {
                if (cursor == cipher[j]) {
                    message += (char) j;
                }
            }
        }

        System.out.println(message);

        for (int i = 0; i < message.length(); i++) {
            
        }
        
    }

    public static String read(String path) {
        String ret = null;
        try {
            ret = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static int mod(int x, int n) {
        return ((x % n) + n) % n; // always returns positive
    }
}