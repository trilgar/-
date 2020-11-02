package interfaces;

import java.io.FileWriter;
import java.io.IOException;

public interface Algorithm {
    double [] solve();
    void print();
    void printf (FileWriter file) throws IOException;
}
