package org.a.a.a.e;

public class b
{
  public static double a(double paramDouble1, double paramDouble2)
  {
    if (Double.isNaN(paramDouble1))
      return paramDouble2;
    if (Double.isNaN(paramDouble2))
      return paramDouble1;
    return Math.min(paramDouble1, paramDouble2);
  }

  public static double a(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return a(a(paramDouble1, paramDouble2), paramDouble3);
  }

  public static double a(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfDouble.length == 0)
      throw new IllegalArgumentException("Array cannot be empty.");
    double d = paramArrayOfDouble[0];
    for (int i = 1; i < paramArrayOfDouble.length; i++)
      d = a(paramArrayOfDouble[i], d);
    return d;
  }

  public static float a(float paramFloat1, float paramFloat2)
  {
    if (Float.isNaN(paramFloat1))
      return paramFloat2;
    if (Float.isNaN(paramFloat2))
      return paramFloat1;
    return Math.min(paramFloat1, paramFloat2);
  }

  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return a(a(paramFloat1, paramFloat2), paramFloat3);
  }

  public static float a(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfFloat.length == 0)
      throw new IllegalArgumentException("Array cannot be empty.");
    float f = paramArrayOfFloat[0];
    for (int i = 1; i < paramArrayOfFloat.length; i++)
      f = a(paramArrayOfFloat[i], f);
    return f;
  }

  public static double b(double paramDouble1, double paramDouble2)
  {
    if (Double.isNaN(paramDouble1))
      return paramDouble2;
    if (Double.isNaN(paramDouble2))
      return paramDouble1;
    return Math.max(paramDouble1, paramDouble2);
  }

  public static double b(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return b(b(paramDouble1, paramDouble2), paramDouble3);
  }

  public static double b(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfDouble.length == 0)
      throw new IllegalArgumentException("Array cannot be empty.");
    double d = paramArrayOfDouble[0];
    for (int i = 1; i < paramArrayOfDouble.length; i++)
      d = b(paramArrayOfDouble[i], d);
    return d;
  }

  public static float b(float paramFloat1, float paramFloat2)
  {
    if (Float.isNaN(paramFloat1))
      return paramFloat2;
    if (Float.isNaN(paramFloat2))
      return paramFloat1;
    return Math.max(paramFloat1, paramFloat2);
  }

  public static float b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return b(b(paramFloat1, paramFloat2), paramFloat3);
  }

  public static float b(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfFloat.length == 0)
      throw new IllegalArgumentException("Array cannot be empty.");
    float f = paramArrayOfFloat[0];
    for (int i = 1; i < paramArrayOfFloat.length; i++)
      f = b(paramArrayOfFloat[i], f);
    return f;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.e.b
 * JD-Core Version:    0.6.0
 */