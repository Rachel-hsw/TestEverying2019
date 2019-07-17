package com.himamis.retex.renderer.a;

import java.util.Map;

public class ci extends d
{
  private d a;
  private double b;
  private int f = -1;
  private int g;
  private int h;
  private float i;
  private float j;

  public ci(d paramd, double paramDouble, String paramString)
  {
    this.c = paramd.c;
    this.a = paramd;
    this.b = paramDouble;
    Map localMap = bw.a(paramString);
    if (localMap.containsKey("origin"))
    {
      this.f = cj.a((String)localMap.get("origin"));
      return;
    }
    float[] arrayOfFloat2;
    if (localMap.containsKey("x"))
    {
      arrayOfFloat2 = cu.b((String)localMap.get("x"));
      this.g = (int)arrayOfFloat2[0];
    }
    for (this.i = arrayOfFloat2[1]; localMap.containsKey("y"); this.i = 0.0F)
    {
      float[] arrayOfFloat1 = cu.b((String)localMap.get("y"));
      this.h = (int)arrayOfFloat1[0];
      this.j = arrayOfFloat1[1];
      return;
      this.g = 3;
    }
    this.h = 3;
    this.j = 0.0F;
  }

  public ci(d paramd, String paramString1, String paramString2)
  {
    this.c = paramd.c;
    this.a = paramd;
    this.b = Double.parseDouble(paramString1);
    this.f = cj.a(paramString2);
  }

  public i a(dp paramdp)
  {
    if (this.f != -1)
      return new cj(this.a.a(paramdp), this.b, this.f);
    return new cj(this.a.a(paramdp), this.b, this.i * cu.a(this.g, paramdp), this.j * cu.a(this.h, paramdp));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.ci
 * JD-Core Version:    0.6.0
 */