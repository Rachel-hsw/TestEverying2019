package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.e.l;
import java.util.HashMap;
import java.util.Map;

public class cu extends d
{
  private static Map<String, Integer> a = new HashMap();
  private static a[] b;
  private boolean f;
  private int g;
  private float h;
  private float i;
  private float j;
  private int k;
  private int l;
  private int m;

  static
  {
    a.put("em", Integer.valueOf(0));
    a.put("ex", Integer.valueOf(1));
    a.put("px", Integer.valueOf(2));
    a.put("pix", Integer.valueOf(2));
    a.put("pixel", Integer.valueOf(2));
    a.put("pt", Integer.valueOf(10));
    a.put("bp", Integer.valueOf(3));
    a.put("pica", Integer.valueOf(4));
    a.put("pc", Integer.valueOf(4));
    a.put("mu", Integer.valueOf(5));
    a.put("cm", Integer.valueOf(6));
    a.put("mm", Integer.valueOf(7));
    a.put("in", Integer.valueOf(8));
    a.put("sp", Integer.valueOf(9));
    a.put("dd", Integer.valueOf(11));
    a.put("cc", Integer.valueOf(12));
    a[] arrayOfa = new a[13];
    arrayOfa[0] = new cv();
    arrayOfa[1] = new da();
    arrayOfa[2] = new db();
    arrayOfa[3] = new dc();
    arrayOfa[4] = new dd();
    arrayOfa[5] = new de();
    arrayOfa[6] = new df();
    arrayOfa[7] = new dg();
    arrayOfa[8] = new dh();
    arrayOfa[9] = new cw();
    arrayOfa[10] = new cx();
    arrayOfa[11] = new cy();
    arrayOfa[12] = new cz();
    b = arrayOfa;
  }

  public cu()
  {
    this.f = true;
  }

  public cu(int paramInt)
  {
    this.f = true;
    this.g = paramInt;
  }

  public cu(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
    throws l
  {
    a(paramInt);
    this.k = paramInt;
    this.l = paramInt;
    this.m = paramInt;
    this.h = paramFloat1;
    this.i = paramFloat2;
    this.j = paramFloat3;
  }

  public cu(int paramInt1, float paramFloat1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3)
    throws l
  {
    a(paramInt1);
    a(paramInt2);
    a(paramInt3);
    this.k = paramInt1;
    this.l = paramInt2;
    this.m = paramInt3;
    this.h = paramFloat1;
    this.i = paramFloat2;
    this.j = paramFloat3;
  }

  public static float a(int paramInt, dp paramdp)
  {
    return b[paramInt].a(paramdp);
  }

  public static int a(String paramString)
  {
    Integer localInteger = (Integer)a.get(paramString);
    if (localInteger == null)
      return 2;
    return localInteger.intValue();
  }

  public static void a(int paramInt)
    throws l
  {
    if ((paramInt < 0) || (paramInt >= b.length))
      throw new l();
  }

  public static float[] b(String paramString)
  {
    if (paramString == null)
      return new float[] { 2.0F, 0.0F };
    int n = 0;
    if ((n >= paramString.length()) || (Character.isLetter(paramString.charAt(n))));
    while (true)
    {
      try
      {
        float f1 = Float.parseFloat(paramString.substring(0, n));
        if (n != paramString.length())
        {
          i1 = a(paramString.substring(n).toLowerCase());
          float[] arrayOfFloat = new float[2];
          arrayOfFloat[0] = i1;
          arrayOfFloat[1] = f1;
          return arrayOfFloat;
          n++;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return new float[] { (0.0F / 0.0F) };
      }
      int i1 = 2;
    }
  }

  public i a(dp paramdp)
  {
    if (this.f)
    {
      Object localObject;
      if (this.g == 0)
        localObject = new dk(paramdp.s(), 0.0F, 0.0F, 0.0F);
      label78: label101: 
      while (true)
      {
        return localObject;
        int n;
        if (this.g < 0)
        {
          n = -this.g;
          if (n != 1)
            break label78;
          localObject = am.a(7, 1, paramdp);
        }
        while (true)
        {
          if (this.g >= 0)
            break label101;
          ((i)localObject).d();
          return localObject;
          n = this.g;
          break;
          if (n == 2)
          {
            localObject = am.a(2, 1, paramdp);
            continue;
          }
          localObject = am.a(3, 1, paramdp);
        }
      }
    }
    return (i)new dk(this.h * a(this.k, paramdp), this.i * a(this.l, paramdp), this.j * a(this.m, paramdp), 0.0F);
  }

  private static abstract interface a
  {
    public abstract float a(dp paramdp);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.cu
 * JD-Core Version:    0.6.0
 */