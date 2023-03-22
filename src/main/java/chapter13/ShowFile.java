package chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile {
    public static void main(String[] args) {
        int i;
        FileInputStream fin = null;

        if (args.length != 1) {
            System.out.println("ShowFile ______");
            return;
        }
        try {
            fin = new FileInputStream(args[0]);
            do {
                i = fin.read();
                if (i != -1) System.out.println((char) i);
            } while (i != -1);
        } catch (FileNotFoundException e) {
            System.out.println("Can not open file");
        } catch (
                IOException e) {
            System.out.println("error reading file");
        } finally {
            try {
                fin.close();
            } catch (IOException e) {
                System.out.println("error closing file");
            }
        }
    }
}
