package com.test.hsw.newton;

import org.apache.commons.math3.analysis.solvers.NewtonRaphsonSolver;
import org.apache.commons.math3.util.FastMath;

/**
 * 使用牛顿迭代法求方程的解：
 * x^3-2x-5=0
 * 区间为[2,3]
 * 这里的"^"表示乘方。
 */
public class NewtonIterationMethod2 {
    private final static double a = 0;
    private final static double b = 0;
    private final static double c = 6555.58;
    private final static double d = 0.4475;
    private final static double e = 21.387;
    private final static double f = 1.9902;
    private final static double g = 17.177;

    public NewtonIterationMethod2() {

    }
//    public static void main(String[] args) {
//        double x = 14;
//        for (int i = 0; i < 20; i++) {
//            x = -yuan(x) / dao(x) + x;
//        }
//        System.out.println(x + "");
//    }

    public static void main(String[] args) {
//        UnivariateDifferentiableFunction func
//                = FunctionUtils.add(FunctionUtils.multiply(new Constant(1e2), sqrt),
//                FunctionUtils.multiply(new Constant(1e6), inv),
//                FunctionUtils.multiply(new Constant(1e4),
//                        FunctionUtils.compose(inv, sqrt)));
        NewtonRaphsonSolver newtonRaphsonSolver = new NewtonRaphsonSolver();
        //param f函数求解。
        // param是区间的最小下界。
        // param是区间的最大值上限。
        // param maxEval最大计算次数。
        // 返回函数为零的值。
//        UnivariateDifferentiableFunction function = FunctionUtils.multiply(2);
        newtonRaphsonSolver.solve(20, null, -100, +100);
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
