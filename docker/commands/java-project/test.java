import java.util.Properties;

class test{

    public static void printSystemProperties(){
        System.out.println("Printing Systemproperties using java");
        Properties props = System.getProperties();                                 
        System.out.println(props);

        
    }
    public static void main(String[] args) {
        System.out.println("Java program stated.....");
        printSystemProperties();
    }
}