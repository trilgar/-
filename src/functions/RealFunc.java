package functions;

import interfaces.Function;

public class RealFunc implements Function {
    @Override
    public double result(double x, double y) {
        return x*x;
    }
}
