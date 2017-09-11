import java.io.*;

public class ObjectStream{
    public static void main(String [] args){
        ObjectOutputStream objectwriter = null;
        ObjectInputStream objectreader = null;

        try{
            objectwriter = new ObjectOutputStream(new FileOutputStream("/home/hyzsherry.txt"));
            objectwriter.writeObject(new Student("gg", 22));
            objectwriter.writeObject(new Student("tt", 24));
            objectwriter.writeObject(new Student("rr", 23));

            objectreader = new ObjectInputStream(new FileInputStream("/home/hyzsherry.txt"));

            for (int i = 0; i<3; i++){
                System.out.println(objectreader.readObject());
            } 
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }finally{
            try{
                objectreader.close();
                objectwriter.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

class Student implements Serializable{
    private String name;
    private int age;

    public Student(String name, int age){
        super();
        this.name = name;
        this.age  = age;
    }

    @Override
    public String toString(){
        return "Student [name=" + name + ", age=" + age + "]";
    }
}