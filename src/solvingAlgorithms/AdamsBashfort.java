package solvingAlgorithms;

import interfaces.Algorithm;
import interfaces.Function;

import java.io.FileWriter;
import java.io.IOException;

public class AdamsBashfort implements Algorithm {
    double [] start;
    double x0;
    double h;
    double [] y;
    double [] x;
    Function func;
    FileWriter file;

    public AdamsBashfort(double[] start, double x0, double h, Function func, FileWriter file) {
        this.start = start;
        this.x0 = x0;
        this.h = h;
        this.func = func;
        this.y = new double[(int)(1/h)+1];
        System.arraycopy(start, 0, y, 0, start.length);
        this.x = new double[y.length];
        for( int i=0;i<x.length;i++){
            x[i]=x0+i*h;
        }

        this.file=file;

    }

    @Override
    public double[] solve() {
        for(int i =3;i<y.length-1;i++){
            y[i+1]=y[i]+(h/24)*(55*func.result( x[i] , y[i])-59* func.result(x[i-1],y[i-1])+
                    37* func.result(x[i-2],y[i-2])-9* func.result(x[i-3],y[i-3]));
        }
        return y;
    }

    @Override
    public void print() {
        System.out.println("Solved method AdamsBashfort gave us answer:");
        for(int i=0; i<y.length;i++){
            System.out.println("y"+i+"= "+y[i]);
        }
    }

    @Override
    public void printf() throws IOException {
        file.write("h= "+this.h+"\n");
        file.write("Solved method AdamsBashfort gave us answer:\n");
        for(int i=0; i<y.length;i++){
            file.write("y"+i+"= "+y[i]+"\n");
        }
        file.write("\n");
    }
}
