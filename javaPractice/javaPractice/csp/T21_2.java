
import java.io.*;
import java.util.*;

public class T21_2 {

  public void run(String filename) throws FileNotFoundException {
      File file = new File(filename);
//      Scanner sc = new Scanner(file);
      Scanner cin = new Scanner(new BufferedInputStream(new FileInputStream(file)));
      
      
      
      
      
      sc.close();
  }


  public static void main(String[] args) throws FileNotFoundException {
      new T21_2().run("eg1.txt");
  }
}