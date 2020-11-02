package main;

import interfaces.Algorithm;
import interfaces.Function;
import rungeKutta.Func;
import rungeKutta.RungeKuttaAlg;

import java.io.FileWriter;
import java.io.IOException;

public class MainProgram {
    public static void main(String [] args){
        Function function =new Func();
        Function real = new Function() {
            @Override
            public double result(double x, double y) {
                return x*x;
            }
        }

        try(FileWriter myFile = new FileWriter("result.txt")){
            Algorithm alg = new RungeKuttaAlg(2,4,0.1,function,myFile);
            alg.solve();
            alg.print();
        }
        catch (IOException io){
            System.out.println("exception with file result.txt occured");
        }
    }
}
