package mocks;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class May19 {
    public static void main(String[] args) {
        fib(1);
    }
    public static void fib(int n){
        // 1 , 1+0 , 1+1, 2+1...
        // 1 2 3 4 5
        int prev = 0;
        int prev2 = 0;
        for(int i=0; i<n;i++){
            if(i==0){
                System.out.print(1 + " ");
                prev = 1;
                prev2 = 0;
            }
            else{
                int curr = prev + prev2;
                System.out.print((prev+ prev2) + " ");
                prev2 = prev;
                prev = curr;
            }
        }

    }

        }
