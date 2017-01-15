package com.anyconfusionhere.boltz;


import com.anyconfusionhere.boltz.math.*;

public class BoltFactory {

    public static Bolt createBolt(String boltType, Storm storm) {
        if (boltType.equals("Addition")) {
            return new AdditionBolt(storm);
        }
        if (boltType.equals("Subtraction")) {
            return new SubtractionBolt(storm);
        }
        if (boltType.equals("Multiplication")) {
            return new MultiplicationBolt(storm);
        }
        if (boltType.equals("Division")) {
            return new DivisionBolt(storm);
        }
        if (boltType.equals("Exponents")) {
            return new ExponentBolt(storm);
        }
        if (boltType.equals("Root")) {
            return new RootBolt(storm);
        }
        if (boltType.equals("Log")) {
            return new LogBolt(storm);
        }
        if (boltType.equals("Modulus")) {
            return new ModulusBolt(storm);
        }
        if (boltType.equals("DecimalAddition")) {
            return new DecimalAdditionBolt(storm);
        }
        if (boltType.equals("DecimalSubtraction")) {
            return new DecimalSubtractionBolt(storm);
        }
        if (boltType.equals("Factorization")) {
            return new FactorizationBolt(storm);
        }
        return new AdditionBolt(storm);

    }
}
