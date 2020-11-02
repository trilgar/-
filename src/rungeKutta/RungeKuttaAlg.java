package rungeKutta;

import interfaces.Algorithm;
import interfaces.Function;

import java.io.FileWriter;
import java.io.IOException;

public class RungeKuttaAlg implements Algorithm {
    double x0;
    double y0;
    Function func;
    double y;
    double x;
    double h;
    double [] result;
    FileWriter file;
    public RungeKuttaAlg(double x0,double y0,double h, Function func, FileWriter myfile) {
        this.x0=x0;
        this.y0=y0;
        this.h=h;
        this.func=func;
        this.file=myfile;
        int cells = (int)(1/h)+1;
        result = new double[cells];
    }

    double k1(){
        return func.result(x,y);
    }
    double k2(){
        return func.result(x+(h/2),y+h*(k1())/2);
    }
    double k3(){
        return func.result(x+h/2 , y+h*k2()/2);
    }
    double k4(){
        return func.result(x+h , y+h*k3());
    }

    @Override
    public double[] solve() {
        x=x0;
        y=y0;
        result[0]=y0;
        for(int i=1;x<x0+1;x+=h,i++){
            y=y+(h/6)*(k1()+2*k2()+2*k3()+k4());
            result[i]=y;
        }
        return result;
    }

    @Override
    public void print() {
        System.out.println("Solved method RungeKutta gave us answer:");
        for(int i=0; i<result.length;i++){
            System.out.println("y"+i+"= "+result[i]);
        }
    }

    @Override
    public void printf (FileWriter file) throws IOException {
        file.write("Solved method RungeKutta gave us answer:\n");
        file.write("y= "+ y +"\n");

    }
}
