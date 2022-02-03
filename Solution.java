import java.util.*; 
import java.io.*; 
import java.util.Scanner; 
 
public class Main{ 
    public static void main(String []argh) 
    { 
        Map<String, String> phoneBook = new HashMap<String, String>(); 
        Scanner in = new Scanner(System.in); 
        int n = in.nextInt(); 
        in.nextLine(); 
        for(int i=0;i<n;i++) { 
            String name = in.nextLine(); 
            String phone = in.nextLine(); 
            phoneBook.put(name, phone); 
        } 
        System.out.println(); 
        while(in.hasNext()){ 
            String s=in.nextLine(); 
            if (phoneBook.containsKey(s)) { 
                System.out.println(s + "=" + phoneBook.get(s)); 
            } else { 
                System.out.println("Not found"); 
            } 
        } 
    } 
}