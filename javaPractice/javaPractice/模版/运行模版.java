package 模版;

public class Test {

    public static void ttt(String input){
        if(input == null)
            throw new IllegalArgumentException();
        char[] data = input.toCharArray();
        permutate(data, 0);
    }


    public static void main(String... args){
        Test.ttt("aac");
    }

}