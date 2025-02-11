package lanqiaobei;

import java.io.*;
import java.util.*;


public class T1 {

public void run(String filename) throws FileNotFoundException {
    File file = new File(filename);
    Scanner sc = new Scanner(file);
    
    //在此输入您的代码...
    sc.close();
}


public static void main(String[] args) throws FileNotFoundException {
    new T1().run("/lanqiaobei/T1.txt");
}
}