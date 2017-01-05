package com.anyconfusionhere.boltz;


import com.anyconfusionhere.boltz.math.*;

public class BoltFactory {

    public static Bolt createBolt(String boltType) {
        if (boltType.equals("Addition")) {
            return new AdditionBolt();
        }
        if (boltType.equals("Subtraction")) {
            return new SubtractionBolt();
        }
        if (boltType.equals("Multiplication")) {
            return new MultiplicationBolt();
        }
        if (boltType.equals("Division")) {
            return new DivisionBolt();
        }
        if (boltType.equals("Exponents")) {
            return new ExponentBolt();
        }
        if (boltType.equals("Root")) {
            return new RootBolt();
        }
        if (boltType.equals("Log")) {
            return new LogBolt();
        }
        if (boltType.equals("Modulus")) {
            return new ModulusBolt();
        }
        if (boltType.equals("DecimalAddition")) {
            return new DecimalAdditionBolt();
        }
        if (boltType.equals("DecimalSubtraction")) {
            return new DecimalSubtractionBolt();
        }
        if (boltType.equals("Factorization")) {
            return new FactorizationBolt();
        }
        return new AdditionBolt();

    }
}
