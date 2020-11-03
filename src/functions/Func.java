package functions;

import interfaces.Function;

public class Func implements Function {
    @Override
    public double result(double x, double y) {
        return 5+((2*x-5)/(x*x))*y;
    }
}
