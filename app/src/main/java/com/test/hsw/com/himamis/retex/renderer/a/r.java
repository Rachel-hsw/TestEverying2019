package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.c.b;
import java.util.HashMap;
import java.util.Map;

public class r extends d
  implements ck
{
  public static Map<String, b> a = new HashMap();
  private final b b;
  private final b f;
  private final cl g;

  static
  {
    d();
  }

  public r(d paramd, b paramb1, b paramb2)
  {
    this.g = new cl(paramd);
    this.b = paramb1;
    this.f = paramb2;
  }

  public r(b paramb1, b paramb2, r paramr)
  {
    this.g = new cl(paramr.g);
    if (paramb1 == null)
      paramb1 = paramr.b;
    this.b = paramb1;
    if (paramb2 == null)
      paramb2 = paramr.f;
    this.f = paramb2;
  }

  private static b a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = 1.0F - paramFloat4;
    return new com.himamis.retex.renderer.a.g.d().a(f1 * (1.0F - paramFloat1), f1 * (1.0F - paramFloat2), f1 * (1.0F - paramFloat3));
  }

  public static b a(String paramString)
  {
    com.himamis.retex.renderer.a.g.d locald = new com.himamis.retex.renderer.a.g.d();
    if ((paramString != null) && (paramString.length() != 0))
    {
      String str1 = paramString.trim();
      b localb1;
      if (str1.charAt(0) == '#')
        localb1 = s.a(str1);
      do
      {
        return localb1;
        if (str1.indexOf(',') != -1)
        {
          String[] arrayOfString = str1.split(";|,");
          int i = arrayOfString.length;
          if (i == 3)
            try
            {
              String str2 = arrayOfString[0].trim();
              String str3 = arrayOfString[1].trim();
              String str4 = arrayOfString[2].trim();
              float f6 = Float.parseFloat(str2);
              float f7 = Float.parseFloat(str3);
              float f8 = Float.parseFloat(str4);
              if ((f6 == (int)f6) && (f7 == (int)f7) && (f8 == (int)f8) && (str2.indexOf('.') == -1) && (str3.indexOf('.') == -1) && (str4.indexOf('.') == -1))
                return locald.a((int)Math.min(255.0F, Math.max(0.0F, f6)), (int)Math.min(255.0F, Math.max(0.0F, f7)), (int)Math.min(255.0F, Math.max(0.0F, f8)));
              b localb4 = locald.a(Math.min(1.0F, Math.max(0.0F, f6)), Math.min(1.0F, Math.max(0.0F, f7)), Math.min(1.0F, Math.max(0.0F, f8)));
              return localb4;
            }
            catch (NumberFormatException localNumberFormatException3)
            {
              return s.b;
            }
          if (i == 4)
            try
            {
              float f2 = Float.parseFloat(arrayOfString[0].trim());
              float f3 = Float.parseFloat(arrayOfString[1].trim());
              float f4 = Float.parseFloat(arrayOfString[2].trim());
              float f5 = Float.parseFloat(arrayOfString[3].trim());
              b localb3 = a(Math.min(1.0F, Math.max(0.0F, f2)), Math.min(1.0F, Math.max(0.0F, f3)), Math.min(1.0F, Math.max(0.0F, f4)), Math.min(1.0F, Math.max(0.0F, f5)));
              return localb3;
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              return s.b;
            }
        }
        localb1 = (b)a.get(str1.toLowerCase());
      }
      while (localb1 != null);
      if (str1.indexOf('.') != -1)
        try
        {
          float f1 = Math.min(1.0F, Math.max(Float.parseFloat(str1), 0.0F));
          b localb2 = locald.a(f1, f1, f1);
          return localb2;
        }
        catch (NumberFormatException localNumberFormatException1)
        {
        }
      return s.a("#" + str1);
    }
    return s.b;
  }

  private static void d()
  {
    a.put("black", s.b);
    a.put("white", s.c);
    a.put("red", s.a);
    a.put("green", s.e);
    a.put("blue", s.d);
    a.put("cyan", s.f);
    a.put("magenta", s.g);
    a.put("yellow", s.h);
    a.put("greenyellow", a(0.15F, 0.0F, 0.69F, 0.0F));
    a.put("goldenrod", a(0.0F, 0.1F, 0.84F, 0.0F));
    a.put("dandelion", a(0.0F, 0.29F, 0.84F, 0.0F));
    a.put("apricot", a(0.0F, 0.32F, 0.52F, 0.0F));
    a.put("peach", a(0.0F, 0.5F, 0.7F, 0.0F));
    a.put("melon", a(0.0F, 0.46F, 0.5F, 0.0F));
    a.put("yelloworange", a(0.0F, 0.42F, 1.0F, 0.0F));
    a.put("orange", a(0.0F, 0.61F, 0.87F, 0.0F));
    a.put("burntorange", a(0.0F, 0.51F, 1.0F, 0.0F));
    a.put("bittersweet", a(0.0F, 0.75F, 1.0F, 0.24F));
    a.put("redorange", a(0.0F, 0.77F, 0.87F, 0.0F));
    a.put("mahogany", a(0.0F, 0.85F, 0.87F, 0.35F));
    a.put("maroon", a(0.0F, 0.87F, 0.68F, 0.32F));
    a.put("brickred", a(0.0F, 0.89F, 0.94F, 0.28F));
    a.put("orangered", a(0.0F, 1.0F, 0.5F, 0.0F));
    a.put("rubinered", a(0.0F, 1.0F, 0.13F, 0.0F));
    a.put("wildstrawberry", a(0.0F, 0.96F, 0.39F, 0.0F));
    a.put("salmon", a(0.0F, 0.53F, 0.38F, 0.0F));
    a.put("carnationpink", a(0.0F, 0.63F, 0.0F, 0.0F));
    a.put("magenta", a(0.0F, 1.0F, 0.0F, 0.0F));
    a.put("violetred", a(0.0F, 0.81F, 0.0F, 0.0F));
    a.put("rhodamine", a(0.0F, 0.82F, 0.0F, 0.0F));
    a.put("mulberry", a(0.34F, 0.9F, 0.0F, 0.02F));
    a.put("redviolet", a(0.07F, 0.9F, 0.0F, 0.34F));
    a.put("fuchsia", a(0.47F, 0.91F, 0.0F, 0.08F));
    a.put("lavender", a(0.0F, 0.48F, 0.0F, 0.0F));
    a.put("thistle", a(0.12F, 0.59F, 0.0F, 0.0F));
    a.put("orchid", a(0.32F, 0.64F, 0.0F, 0.0F));
    a.put("darkorchid", a(0.4F, 0.8F, 0.2F, 0.0F));
    a.put("purple", a(0.45F, 0.86F, 0.0F, 0.0F));
    a.put("plum", a(0.5F, 1.0F, 0.0F, 0.0F));
    a.put("violet", a(0.79F, 0.88F, 0.0F, 0.0F));
    a.put("royalpurple", a(0.75F, 0.9F, 0.0F, 0.0F));
    a.put("blueviolet", a(0.86F, 0.91F, 0.0F, 0.04F));
    a.put("periwinkle", a(0.57F, 0.55F, 0.0F, 0.0F));
    a.put("cadetblue", a(0.62F, 0.57F, 0.23F, 0.0F));
    a.put("cornflowerblue", a(0.65F, 0.13F, 0.0F, 0.0F));
    a.put("midnightblue", a(0.98F, 0.13F, 0.0F, 0.43F));
    a.put("navyblue", a(0.94F, 0.54F, 0.0F, 0.0F));
    a.put("royalblue", a(1.0F, 0.5F, 0.0F, 0.0F));
    a.put("cerulean", a(0.94F, 0.11F, 0.0F, 0.0F));
    a.put("processblue", a(0.96F, 0.0F, 0.0F, 0.0F));
    a.put("skyblue", a(0.62F, 0.0F, 0.12F, 0.0F));
    a.put("turquoise", a(0.85F, 0.0F, 0.2F, 0.0F));
    a.put("tealblue", a(0.86F, 0.0F, 0.34F, 0.02F));
    a.put("aquamarine", a(0.82F, 0.0F, 0.3F, 0.0F));
    a.put("bluegreen", a(0.85F, 0.0F, 0.33F, 0.0F));
    a.put("emerald", a(1.0F, 0.0F, 0.5F, 0.0F));
    a.put("junglegreen", a(0.99F, 0.0F, 0.52F, 0.0F));
    a.put("seagreen", a(0.69F, 0.0F, 0.5F, 0.0F));
    a.put("forestgreen", a(0.91F, 0.0F, 0.88F, 0.12F));
    a.put("pinegreen", a(0.92F, 0.0F, 0.59F, 0.25F));
    a.put("limegreen", a(0.5F, 0.0F, 1.0F, 0.0F));
    a.put("yellowgreen", a(0.44F, 0.0F, 0.74F, 0.0F));
    a.put("springgreen", a(0.26F, 0.0F, 0.76F, 0.0F));
    a.put("olivegreen", a(0.64F, 0.0F, 0.95F, 0.4F));
    a.put("rawsienna", a(0.0F, 0.72F, 1.0F, 0.45F));
    a.put("sepia", a(0.0F, 0.83F, 1.0F, 0.7F));
    a.put("brown", a(0.0F, 0.81F, 1.0F, 0.6F));
    a.put("tan", a(0.14F, 0.42F, 0.56F, 0.0F));
    a.put("gray", a(0.0F, 0.0F, 0.0F, 0.5F));
  }

  public int a()
  {
    return this.g.a();
  }

  public i a(dp paramdp)
  {
    paramdp.a = true;
    dp localdp = paramdp.d();
    if (this.b != null)
      localdp.a(this.b);
    if (this.f != null)
      localdp.b(this.f);
    return this.g.a(localdp);
  }

  public void a(z paramz)
  {
    this.g.a(paramz);
  }

  public int b()
  {
    return this.g.b();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.r
 * JD-Core Version:    0.6.0
 */