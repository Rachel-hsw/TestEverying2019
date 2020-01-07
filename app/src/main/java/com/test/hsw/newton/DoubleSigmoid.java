package com.test.hsw.newton;

import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.FastMath;

public class DoubleSigmoid implements UnivariateDifferentiableFunction, UnivariateFunction {

    private final double c;
    private final double d;
    private final double e;
    private final double f;
    private final double g;
    private final double h;

    public DoubleSigmoid(double... params) {
        if (params == null) {
            throw new NullArgumentException();
        }
        if (params.length != 6) {
            throw new DimensionMismatchException(params.length, 6);
        }
        this.c = params[0];
        this.d = params[1];
        this.e = params[2];
        this.f = params[3];
        this.g = params[4];
        this.h = params[5];
    }

    @Override
    public double value(double x) {
        return DoubleSigmoid.getValue(x,c, d, e, f, g,h);
    }

    private static double getValue(double x,
                                   double c,
                                   double d,
                                   double e,
                                   double f,
                                   double g,
                                   double h) {
        return c / ((1 + FastMath.exp(-d * (x - e))) * (1 + FastMath.exp(-f * (x - g))))-h;
    }

    @Override
    public DerivativeStructure value(DerivativeStructure t) throws DimensionMismatchException {
        return t.subtract(e).multiply(-d).exp().add(1)
                .multiply(t.subtract(g).multiply(-f).exp().add(1))
                .reciprocal()
                .multiply(c)
                .subtract(h);
    }

    public static class Parametric implements ParametricUnivariateFunction {

        @Override
        public double value(double x, double... param)
                throws NullArgumentException,
                DimensionMismatchException {
            validateParameters(param);
            return DoubleSigmoid.getValue(x, param[0], param[1], param[2], param[3], param[4], param[5]);
        }

        @Override
        public double[] gradient(double x, double... param)
                throws NullArgumentException,
                DimensionMismatchException {
            validateParameters(param);

            double c = param[0];
            double d = param[1];
            double e = param[2];
            double f = param[3];
            double g = param[4];

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
            if (param.length != 6) {
                throw new DimensionMismatchException(param.length, 6);
            }
        }
    }
}