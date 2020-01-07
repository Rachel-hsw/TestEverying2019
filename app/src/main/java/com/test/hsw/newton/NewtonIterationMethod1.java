package com.test.hsw.newton;

import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.analysis.solvers.NewtonRaphsonSolver;
import org.apache.commons.math3.util.FastMath;

/**
 * 使用牛顿迭代法求方程的解：
 * x^3-2x-5=0
 * 区间为[2,3]
 * 这里的"^"表示乘方。
 */
public class NewtonIterationMethod1 {
    private final static double a = 0;
    private final static double b = 0;
    private final static double c = 6555.58;
    private final static double d = 0.4475;
    private final static double e = 21.387;
    private final static double f = 1.9902;
    private final static double g = 17.177;

    public NewtonIterationMethod1() {

    }

    public static void main(String[] args) {
        NewtonRaphsonSolver newtonRaphsonSolver = new NewtonRaphsonSolver();
        // 返回函数为零的值。
        DoubleSigmoid2 sigmoid2 = new DoubleSigmoid2(30004, 35.51, 6555.38, 0.4475, 21.387, 1.9902, 17.177);
        double x2 = 18.54546566;
        double x1 = sigmoid2.value(x2) - 30004 - x2 * 35.51;
        System.out.println(x1 + "");
        UnivariateDifferentiableFunction function = new DoubleSigmoid(6555.38, 0.4475, 21.387, 1.9902, 17.177, x1);
        double x = newtonRaphsonSolver.solve(10, function, 0, 40);
        System.out.println(x + "");
    }


    /**
     * 导数
     *
     * @param x
     * @return
     */
    static double dao(double x) {
        double exp1 = FastMath.exp(d * (e - x));
        double exp2 = FastMath.exp(f * (g - x));
        double onePlusExp1 = 1 + exp1;
        double onePlusExp2 = 1 + exp2;
        double value = (onePlusExp2 * exp1 * d + f * onePlusExp1 * exp2) * c / onePlusExp1 * onePlusExp1 * onePlusExp2 * onePlusExp2;
        return value;
    }

    /**
     * 原函数
     *
     * @param x
     * @return
     */
    static double yuan(double x) {
        double exp1 = FastMath.exp(-d * (x - e));
        double exp2 = FastMath.exp(-f * (x - g));
        double onePlusExp1 = 1 + exp1;
        double onePlusExp2 = 1 + exp2;


        double value = c / (onePlusExp1 * onePlusExp2);
        return value;
    }

}
