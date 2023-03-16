package homework.homework10.fileutil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(fileSearch());


        List<String> strings = contentSearch();
        for (String string : strings) {
            System.out.println(string);
        }


        findLines();


        System.out.println(printSizeOfPackage());


        createFileWithContent();
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - fileName - ֆայլի անունը, որը փնտրում ենք։
    //Որպես արդյունք պտի ծրագիրը տպի true եթե կա էդ ֆայլը էդ պապկի մեջ, false եթե չկա։
    static boolean fileSearch() {
        String path = scanner.nextLine();
        String fileName = scanner.nextLine();
        File file = new File(path + "/" + fileName);
        if (file.exists()) return true;
        return false;
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - keyword - ինչ որ բառ
    // Մեթոդը պետք է նշված path-ում գտնի բոլոր .txt ֆայլերը, և իրենց մեջ փնտրի
    // մեր տված keyword-ը, եթե գտնի, պետք է տպի տվյալ ֆայլի անունը։
    static List<String> contentSearch() {
        List<String> names = new ArrayList<>();
        String path = scanner.nextLine();
        String keyword = scanner.nextLine();
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".txt");
                }
            });
            for (File file1 : files) {
                if (file1.getName().contains(keyword)) {
                    names.add(file1.getName());
                }
            }
        }
        return names;
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - txtPath txt ֆայլի փաթը
    // 2 - keyword - ինչ որ բառ
    // տալու ենք txt ֆայլի տեղը, ու ինչ որ բառ, ինքը տպելու է էն տողերը, որտեղ գտնի էդ բառը։
    static void findLines() {
        String path = scanner.nextLine();
        String keyword = scanner.nextLine();
        File file = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = reader.readLine()) != null) {
                if (str.contains(keyword)) {
                    System.out.println(str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //այս մեթոդը պետք է սքաններով վերցնի մեկ string.
    // 1 - path թե որ ֆոլդերի չափն ենք ուզում հաշվել
    // ֆոլդերի բոլոր ֆայլերի չափսերը գումարում ենք իրար, ու տպում
    static long printSizeOfPackage() {
        long sum = 0;
        String path = scanner.nextLine();
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                sum += file1.length();
            }
        }
        return sum;
    }

    //այս մեթոդը պետք է սքաններով վերցնի երեք string.
    // 1 - path պապկի տեղը, թե որտեղ է սարքելու նոր ֆայլը
    // 2 - fileName ֆայլի անունը, թե ինչ անունով ֆայլ է սարքելու
    // 3 - content ֆայլի պարունակությունը։ Այսինքն ստեղծված ֆայլի մեջ ինչ է գրելու
    // որպես արդյունք պապկի մեջ սարքելու է նոր ֆայլ, իրա մեջ էլ լինելու է content-ով տվածը
    static void createFileWithContent() {
        String path = scanner.nextLine();
        String fileName = scanner.nextLine();
        String content = scanner.nextLine();
        File file = new File(path + "/" + fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(content);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("file created");
        } else {
            System.out.println("file already exist and didn't create");
        }
    }

}
