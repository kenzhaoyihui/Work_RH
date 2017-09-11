
import java.io.*;

public class FileExample {
    public static void main(String[] args) {
        createFile();
        //System.out.println("hello world!");
    }

    public static void createFile() {
        File f = new File("/home/hyzsherry.txt");
        try {
            //f.mkdirs();
            if (!f.exists()){
                f.createNewFile();
            }
            
            
            //f.createNewFile();
            System.out.println("The partition size: " + f.getTotalSpace() / (1024 * 1024 * 1024) + "G");
            //f.mkdirs();
            System.out.println("Filename is :" + f.getName());
            System.out.println("The parent dir is:" + f.getParent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


