package com.test.hsw.newton;

import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.FastMath;

public class DoubleSigmoid2 implements UnivariateDifferentiableFunction, UnivariateFunction {

    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;
    private final double g;

    public DoubleSigmoid2(double... params) {
        if (params == null) {
            throw new NullArgumentException();
        }
        if (params.length != 7) {
            throw new DimensionMismatchException(params.length, 7);
        }
        this.a = params[0];
        this.b = params[1];
        this.c = params[2];
        this.d = params[3];
        this.e = params[4];
        this.f = params[5];
        this.g = params[6];
    }

    @Override
    public double value(double x) {
        return DoubleSigmoid2.getValue(x, a, b, c, d, e, f, g);
    }

    private static double getValue(double x,
                                   double a,
                                   double b,
                                   double c,
                                   double d,
                                   double e,
                                   double f,
                                   double g) {
        return a + b * x + c / ((1 + FastMath.exp(-d * (x - e))) * (1 + FastMath.exp(-f * (x - g))));
    }

    @Override
    public DerivativeStructure value(DerivativeStructure t) throws DimensionMismatchException {
        return t.subtract(e).multiply(-d).exp().add(1)
                .multiply(t.subtract(g).multiply(-f).exp().add(1))
                .reciprocal()
                .multiply(c)
                .add(t.multiply(b))
                .add(a);
    }

    public static class Parametric implements ParametricUnivariateFunction {

        @Override
        public double value(double x, double... param)
                throws NullArgumentException,
                DimensionMismatchException {
            validateParameters(param);
            return DoubleSigmoid2.getValue(x, param[0], param[1], param[2], param[3], param[4], param[5], param[6]);
        }

        @Override
        public double[] gradient(double x, double... param)
                throws NullArgumentException,
                DimensionMismatchException {
            validateParameters(param);

            double c = param[2];
            double d = param[3];
            double e = param[4];
            double f = param[5];
            double g = param[6];

            double exp1 = FastMath.exp(-d * (x - e));
            double exp2 = FastMath.exp(-f * (x - g));
            double onePlusExp1 = 1 + exp1;
            double onePlusExp2 = 1 + exp2;
            double under = onePlusExp1 * onePlusExp2;
            double awful1 = c * exp1 * FastMath.pow(onePlusExp1, -2) / onePlusExp2;
            double awful2 = c * exp2 * FastMath.pow(onePlusExp2, -2) / onePlusExp1;

            final double ga = 0;
            final double gb = x;
            final double gc = 1.0 / under;
            final double gd = (x - e) * awful1;
            final double ge = -d * awful1;
            final double gf = (x - g) * awful2;
            final double gg = -f * awful2;
            return new double[]{ga, gb, gc, gd, ge, gf, gg};
        }

        private void validateParameters(double[] param)
                throws NullArgumentException,
                DimensionMismatchException {
            if (param == null) {
                throw new NullArgumentException();
            }
            if (param.length != 7) {
                throw new DimensionMismatchException(param.length, 7);
            }
        }
    }
}