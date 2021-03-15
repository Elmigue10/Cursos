import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.scanner;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Ingrese un numero.");

        Scanner teclado= new Scanner(System.in);

        int n = teclado.nextInt();

        if(n<=5){
            if(n>2){
                if(n%2==0){
                    System.out.println("Not Weird");
                }
                else{
                    System.out.println("Weird");
                }
            }
        }
        if(n<=20){
            if(n>=6){
                System.out.println("Weird");
            }
        }
        if(n>20){
            
            if(n%2==0){
                System.out.println("Not Weird");
            }
            else{
                System.out.println("Weird");
            }
            
        }

    }
}
