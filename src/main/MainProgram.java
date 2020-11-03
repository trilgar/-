package main;

import functions.RealFunc;
import interfaces.Algorithm;
import interfaces.Function;
import functions.Func;
import solvingAlgorithms.AdamsBashfort;
import solvingAlgorithms.RungeKuttaAlg;

import java.io.FileWriter;
import java.io.IOException;

public class MainProgram {
    public static void main(String [] args){
        Function function =new Func();
        Function real = new RealFunc();

        try(FileWriter myFile = new FileWriter("result.txt")){
            //Для h1=0.1
            Algorithm alg = new RungeKuttaAlg(2,4,0.1,function,myFile);
            double [] rungeKuttaY=alg.solve();
            alg.print();
            alg.printf();

           double [] solve = new double[4];
            System.arraycopy(rungeKuttaY, 0, solve, 0, solve.length);

            alg =new AdamsBashfort(solve,2,0.1,function,myFile);
            double [] adamsBashfortY = alg.solve();
            alg.print();
            alg.printf();

            //Для h2=0.05
            alg = new RungeKuttaAlg(2,4,0.05,function,myFile);
            double [] rungeKuttaY1=alg.solve();
            alg.print();
            alg.printf();

            System.arraycopy(rungeKuttaY1, 0, solve, 0, solve.length);

            alg =new AdamsBashfort(solve,2,0.05,function,myFile);
            double [] adamsBashfortY1 = alg.solve();
            alg.print();
            alg.printf();

            //Для h3 = 0.2
            alg = new RungeKuttaAlg(2,4,0.2,function,myFile);
            double [] rungeKuttaY2=alg.solve();
            alg.print();
            alg.printf();

            System.arraycopy(rungeKuttaY2, 0, solve, 0, solve.length);

            alg =new AdamsBashfort(solve,2,0.2,function,myFile);
            double [] adamsBashfortY2 = alg.solve();
            alg.print();
            alg.printf();


        }
        catch (IOException io){
            System.out.println("exception with file result.txt occurred");
        }
    }
}
