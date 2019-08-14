package com.himamis.retex.renderer.a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class bg extends d
{
  private static cu A;
  public static cu a = new cu(0, 1.0F, 0.0F, 0.0F);
  public static cu b = new cu(0, 0.5F, 0.0F, 0.0F);
  public static cu f = new cu(1, 0.0F, 1.0F, 0.0F);
  public static cu g = new cu(1, 0.0F, 0.4F, 0.0F);
  public static cu h = new cu(1, 0.0F, 0.4F, 0.0F);
  public static final int i = 0;
  public static final int j = 1;
  public static final int k = 2;
  public static final int l = 3;
  public static final int m = 4;
  public static final int n = 5;
  public static final int o = 6;
  public static final int p = 7;
  private static final i q = new dk(0.0F, 0.0F, 0.0F, 0.0F);
  private c r;
  private int[] s;
  private Map<Integer, ek> t = new HashMap();
  private boolean u;
  private boolean v;
  private boolean w;
  private int x;
  private boolean y;
  private boolean z;

  static
  {
    A = new cu(2);
  }

  public bg(c paramc, int paramInt)
  {
    this(false, paramc, paramInt);
  }

  public bg(c paramc, String paramString)
  {
    this(false, paramc, paramString);
  }

  public bg(boolean paramBoolean, c paramc, int paramInt)
  {
    this(paramBoolean, paramc, paramInt, false);
  }

  public bg(boolean paramBoolean, c paramc, int paramInt1, int paramInt2)
  {
    this(paramBoolean, paramc, paramInt1, paramInt2, true);
  }

  public bg(boolean paramBoolean1, c paramc, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    this.y = paramBoolean1;
    this.r = paramc;
    this.x = paramInt1;
    this.z = paramBoolean2;
    this.s = new int[this.r.b];
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= this.r.b)
        return;
      this.s[i1] = paramInt2;
    }
  }

  public bg(boolean paramBoolean1, c paramc, int paramInt, boolean paramBoolean2)
  {
    this.y = paramBoolean1;
    this.r = paramc;
    this.x = paramInt;
    this.z = paramBoolean2;
    int i2;
    if ((paramInt != 1) && (paramInt != 5))
    {
      this.s = new int[this.r.b];
      i2 = 0;
      if (i2 < this.r.b);
    }
    while (true)
    {
      return;
      this.s[i2] = 1;
      if (i2 + 1 < this.r.b)
        this.s[(i2 + 1)] = 0;
      i2 += 2;
      break;
      this.s = new int[this.r.b];
      while (i1 < this.r.b)
      {
        this.s[i1] = 2;
        i1++;
      }
    }
  }

  public bg(boolean paramBoolean, c paramc, String paramString)
  {
    this(paramBoolean, paramc, paramString, false);
  }

  public bg(boolean paramBoolean1, c paramc, String paramString, boolean paramBoolean2)
  {
    this.y = paramBoolean1;
    this.r = paramc;
    this.x = 0;
    this.z = paramBoolean2;
    a(new StringBuffer(paramString));
  }

  private i a(dp paramdp, i[] paramArrayOfi, float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    bk localbk = (bk)((LinkedList)this.r.a.get(paramInt1)).get(paramInt2);
    int i1 = localbk.d();
    int i2 = paramInt2;
    float f1 = 0.0F;
    if (i2 >= -1 + (paramInt2 + i1))
    {
      float f3 = f1 + paramArrayOfFloat[i2];
      if (localbk.a(paramdp).c() > f3)
        f3 = 0.0F;
      localbk.a(f3);
      return localbk.a(paramdp);
    }
    float f2 = f1 + (paramArrayOfFloat[i2] + paramArrayOfi[(i2 + 1)].c());
    if (this.t.get(Integer.valueOf(i2 + 1)) != null)
      f1 = f2 + ((ek)this.t.get(Integer.valueOf(i2 + 1))).b(paramdp);
    while (true)
    {
      i2++;
      break;
      f1 = f2;
    }
  }

  private void a(StringBuffer paramStringBuffer)
  {
    int i1 = 0;
    int i2 = paramStringBuffer.length();
    ArrayList localArrayList = new ArrayList();
    int i3 = 0;
    int i12;
    label34: Integer[] arrayOfInteger;
    if (i3 >= i2)
    {
      i12 = localArrayList.size();
      if (i12 < this.r.b)
        break label595;
      if (localArrayList.size() == 0)
        break label632;
      arrayOfInteger = (Integer[])localArrayList.toArray(new Integer[0]);
      this.s = new int[arrayOfInteger.length];
    }
    while (true)
    {
      if (i1 >= arrayOfInteger.length)
      {
        return;
        int i4;
        switch (paramStringBuffer.charAt(i3))
        {
        default:
          localArrayList.add(Integer.valueOf(2));
          i4 = i2;
        case 'l':
        case 'r':
        case 'c':
        case '|':
        case '@':
        case '*':
        case '\t':
        case ' ':
        }
        while (true)
        {
          i3++;
          i2 = i4;
          break;
          localArrayList.add(Integer.valueOf(0));
          i4 = i2;
          continue;
          localArrayList.add(Integer.valueOf(1));
          i4 = i2;
          continue;
          localArrayList.add(Integer.valueOf(2));
          i4 = i2;
          continue;
          label310: for (int i11 = 1; ; i11++)
          {
            i3++;
            if (i3 >= i2);
            while (true)
            {
              this.t.put(Integer.valueOf(localArrayList.size()), new ek(i11));
              i4 = i2;
              break;
              if (paramStringBuffer.charAt(i3) == '|')
                break label310;
              i3--;
            }
          }
          int i9 = i3 + 1;
          dr localdr2 = new dr();
          dv localdv2 = new dv(this.y, paramStringBuffer.substring(i9), localdr2, false);
          d locald = localdv2.q();
          c localc = this.r;
          localc.b = (1 + localc.b);
          for (int i10 = 0; ; i10++)
          {
            if (i10 >= this.r.c)
            {
              localArrayList.add(Integer.valueOf(5));
              i3 = -1 + (i9 + localdv2.l());
              i4 = i2;
              break;
            }
            ((LinkedList)this.r.a.get(i10)).add(localArrayList.size(), locald);
          }
          int i5 = i3 + 1;
          dr localdr1 = new dr();
          dv localdv1 = new dv(this.y, paramStringBuffer.substring(i5), localdr1, false);
          String[] arrayOfString = localdv1.a(2, 0);
          int i6 = i5 + localdv1.l();
          int i7 = Integer.parseInt(arrayOfString[1]);
          String str = "";
          for (int i8 = 0; ; i8++)
          {
            if (i8 >= i7)
            {
              paramStringBuffer.insert(i6, str);
              i4 = paramStringBuffer.length();
              i3 = i6 - 1;
              break;
            }
            str = str + arrayOfString[2];
          }
          i4 = i2;
        }
        label595: localArrayList.add(Integer.valueOf(2));
        i12++;
        break label34;
      }
      this.s[i1] = arrayOfInteger[i1].intValue();
      i1++;
    }
    label632: this.s = new int[] { 2 };
  }

  public i a(dp paramdp)
  {
    int i1 = this.r.c;
    int i2 = this.r.b;
    i[][] arrayOfi = (i[][])Array.newInstance(i.class, new int[] { i1, i2 });
    float[] arrayOfFloat1 = new float[i1];
    float[] arrayOfFloat2 = new float[i1];
    float[] arrayOfFloat3 = new float[i2];
    float f1 = paramdp.m().h(paramdp.j());
    dp localdp;
    if (this.x == 5)
    {
      localdp = paramdp.d();
      localdp.a(4);
    }
    while (true)
    {
      ArrayList localArrayList = new ArrayList();
      int i3 = 0;
      int i5;
      int i11;
      float f4;
      if (i3 >= i1)
      {
        i5 = 0;
        if (i5 < localArrayList.size())
          break label516;
        i11 = 0;
        f4 = 0.0F;
      }
      i[] arrayOfi2;
      int i12;
      float f5;
      ej localej;
      i locali2;
      int i13;
      while (true)
      {
        if (i11 >= i2)
        {
          arrayOfi2 = a(localdp, f4);
          i12 = 0;
          f5 = f4;
          if (i12 < i2 + 1)
            break label676;
          localej = new ej();
          locali2 = f.a(localdp);
          localej.a(g.a(localdp));
          locali2.e();
          i13 = 0;
          if (i13 < i1)
            break label743;
          localej.a(h.a(localdp));
          float f7 = localej.e() + localej.f();
          float f8 = localdp.m().b(localdp.j());
          localej.c(f8 + f7 / 2.0F);
          localej.b(f7 / 2.0F - f8);
          return localej;
          arrayOfFloat1[i3] = 0.0F;
          arrayOfFloat2[i3] = 0.0F;
          int i4 = 0;
          while (true)
          {
            if (i4 >= i2)
            {
              i3++;
              break;
            }
            try
            {
              d locald2 = (d)((LinkedList)this.r.a.get(i3)).get(i4);
              locald1 = locald2;
              i[] arrayOfi1 = arrayOfi[i3];
              if (locald1 == null)
              {
                locali1 = q;
                arrayOfi1[i4] = locali1;
                arrayOfFloat1[i3] = Math.max(arrayOfi[i3][i4].f(), arrayOfFloat1[i3]);
                arrayOfFloat2[i3] = Math.max(arrayOfi[i3][i4].e(), arrayOfFloat2[i3]);
                if (arrayOfi[i3][i4].j == 12)
                  break label488;
                arrayOfFloat3[i4] = Math.max(arrayOfi[i3][i4].c(), arrayOfFloat3[i4]);
                i4++;
              }
            }
            catch (Exception localException)
            {
              while (true)
              {
                arrayOfi[i3][(i4 - 1)].j = 11;
                i4 = i2 - 1;
                d locald1 = null;
                continue;
                i locali1 = locald1.a(localdp);
                continue;
                label488: ((bk)locald1).a(i3, i4);
                localArrayList.add((bk)locald1);
              }
            }
          }
          label516: bk localbk1 = (bk)localArrayList.get(i5);
          int i6 = localbk1.g();
          int i7 = localbk1.f();
          int i8 = localbk1.d();
          float f2 = 0.0F;
          int i9 = i6;
          label558: float f3;
          if (i9 >= i6 + i8)
            if (arrayOfi[i7][i6].c() > f2)
              f3 = (arrayOfi[i7][i6].c() - f2) / i8;
          for (int i10 = i6; ; i10++)
          {
            if (i10 >= i6 + i8)
            {
              i5++;
              break;
              f2 += arrayOfFloat3[i9];
              i9++;
              break label558;
            }
            arrayOfFloat3[i10] = (f3 + arrayOfFloat3[i10]);
          }
        }
        f4 += arrayOfFloat3[i11];
        i11++;
      }
      label676: float f9 = f5 + arrayOfi2[i12].c();
      float f10;
      if (this.t.get(Integer.valueOf(i12)) != null)
        f10 = f9 + ((ek)this.t.get(Integer.valueOf(i12))).b(localdp);
      while (true)
      {
        i12++;
        f5 = f10;
        break;
        label743: Object localObject1 = new at();
        int i14 = 0;
        if (i14 >= i2)
        {
          if (arrayOfi[i13][0].j == 13)
            break label1529;
          ((at)localObject1).c(arrayOfFloat2[i13]);
          ((at)localObject1).b(arrayOfFloat1[i13]);
          localej.a((i)localObject1);
          if (i13 < i1 - 1)
            localej.a(locali2);
        }
        while (true)
        {
          i13++;
          break;
          Object localObject2;
          switch (arrayOfi[i13][i14].j)
          {
          default:
            localObject2 = localObject1;
          case -1:
          case 12:
          case 11:
            while (true)
            {
              i14++;
              localObject1 = localObject2;
              break;
              label1006: boolean bool;
              if (i14 == 0)
              {
                if (this.t.get(Integer.valueOf(0)) != null)
                {
                  ek localek2 = (ek)this.t.get(Integer.valueOf(0));
                  localek2.a(arrayOfFloat2[i13] + arrayOfFloat1[i13] + locali2.e());
                  localek2.b(arrayOfFloat1[i13] + locali2.e() / 2.0F);
                  i locali5 = localek2.a(localdp);
                  ((at)localObject1).a(new at(locali5, arrayOfi2[0].c() + locali5.c(), 0));
                }
              }
              else
              {
                bool = true;
                if (arrayOfi[i13][i14].j != -1)
                  break label1208;
                ((at)localObject1).a(new at(arrayOfi[i13][i14], arrayOfFloat3[i14], this.s[i14]));
              }
              i locali4;
              while (true)
              {
                if ((!bool) || (this.t.get(Integer.valueOf(i14 + 1)) == null))
                  break label1316;
                ek localek1 = (ek)this.t.get(Integer.valueOf(i14 + 1));
                localek1.a(arrayOfFloat2[i13] + arrayOfFloat1[i13] + locali2.e());
                localek1.b(arrayOfFloat1[i13] + locali2.e() / 2.0F);
                locali4 = localek1.a(localdp);
                if (i14 >= i2 - 1)
                  break label1278;
                ((at)localObject1).a(new at(locali4, arrayOfi2[(i14 + 1)].c() + locali4.c(), 2));
                localObject2 = localObject1;
                break;
                ((at)localObject1).a(arrayOfi2[0]);
                break label1006;
                label1208: i locali3 = a(localdp, arrayOfi2, arrayOfFloat3, i13, i14);
                bk localbk2 = (bk)((LinkedList)this.r.a.get(i13)).get(i14);
                i14 += -1 + localbk2.d();
                ((at)localObject1).a(locali3);
                bool = localbk2.e();
              }
              label1278: ((at)localObject1).a(new at(locali4, arrayOfi2[(i14 + 1)].c() + locali4.c(), 1));
              localObject2 = localObject1;
              continue;
              label1316: ((at)localObject1).a(arrayOfi2[(i14 + 1)]);
              localObject2 = localObject1;
              continue;
              float f6 = localdp.b();
              if (f6 == (1.0F / 1.0F))
                f6 = arrayOfFloat3[i14];
              at localat = new at(arrayOfi[i13][i14], f6, 0);
              i14 = i2 - 1;
              localObject2 = localat;
            }
          case 13:
          }
          as localas = (as)((LinkedList)this.r.a.get(i13)).get(i14);
          localas.a(f5);
          if ((i13 >= 1) && ((((LinkedList)this.r.a.get(i13 - 1)).get(i14) instanceof as)))
          {
            ((at)localObject1).a(new dk(0.0F, 2.0F * f1, 0.0F, 0.0F));
            localas.b(f1 + -locali2.e() / 2.0F);
          }
          while (true)
          {
            ((at)localObject1).a(localas.a(localdp));
            i14 = i2;
            localObject2 = localObject1;
            break;
            localas.b(-locali2.e() / 2.0F);
          }
          label1529: localej.a((i)localObject1);
        }
        f10 = f9;
      }
      localdp = paramdp;
    }
  }

  public i[] a(dp paramdp, float paramFloat)
  {
    int i1 = 1;
    int i2 = this.r.b;
    i[] arrayOfi = new i[i2 + 1];
    float f1 = paramdp.b();
    if ((this.x == 6) || (this.x == 7))
      f1 = (1.0F / 1.0F);
    switch (this.x)
    {
    default:
      if (f1 == (1.0F / 1.0F))
      {
        arrayOfi[0] = q;
        arrayOfi[i2] = arrayOfi[0];
      }
      return arrayOfi;
    case 0:
      if (this.s[0] != 5)
        break;
      arrayOfi[i1] = new dk(0.0F, 0.0F, 0.0F, 0.0F);
    case 1:
    case 5:
    case 2:
    case 6:
    case 3:
    case 7:
    case 4:
    }
    for (int i4 = 2; ; i4 = i1)
    {
      if (this.z)
        arrayOfi[0] = b.a(paramdp);
      i locali6;
      while (true)
      {
        arrayOfi[i2] = arrayOfi[0];
        locali6 = a.a(paramdp);
        if (i4 < i2)
          break;
        return arrayOfi;
        arrayOfi[0] = new dk(0.0F, 0.0F, 0.0F, 0.0F);
      }
      if (this.s[i4] == 5)
      {
        arrayOfi[i4] = new dk(0.0F, 0.0F, 0.0F, 0.0F);
        arrayOfi[(i4 + 1)] = arrayOfi[i4];
        i4++;
      }
      while (true)
      {
        i4++;
        break;
        arrayOfi[i4] = locali6;
      }
      arrayOfi[0] = q;
      arrayOfi[i2] = arrayOfi[0];
      i locali5 = a.a(paramdp);
      while (true)
      {
        if (i1 >= i2)
          return arrayOfi;
        arrayOfi[i1] = locali5;
        i1++;
      }
      i locali4 = A.a(paramdp);
      Object localObject2;
      int i3;
      if (f1 != (1.0F / 1.0F))
      {
        localObject2 = new dk(Math.max((f1 - paramFloat - i2 / 2 * locali4.c()) / (float)Math.floor((i2 + 3) / 2), 0.0F), 0.0F, 0.0F, 0.0F);
        arrayOfi[i2] = localObject2;
        i3 = 0;
        label404: if (i3 >= i2)
          break;
        if (i3 % 2 != 0)
          break label443;
        arrayOfi[i3] = localObject2;
      }
      while (true)
      {
        i3++;
        break label404;
        localObject2 = a.a(paramdp);
        break;
        label443: arrayOfi[i3] = locali4;
      }
      float f2;
      i locali2;
      if (f1 != (1.0F / 1.0F))
      {
        f2 = Math.max((f1 - paramFloat) / 2.0F, 0.0F);
        locali2 = A.a(paramdp);
        i locali3 = q;
        arrayOfi[0] = new dk(f2, 0.0F, 0.0F, 0.0F);
        arrayOfi[i2] = arrayOfi[0];
        label513: if (i1 >= i2)
          break;
        if (i1 % 2 != 0)
          break label543;
        arrayOfi[i1] = locali3;
      }
      while (true)
      {
        i1++;
        break label513;
        f2 = 0.0F;
        break;
        label543: arrayOfi[i1] = locali2;
      }
      i locali1 = A.a(paramdp);
      Object localObject1;
      if (f1 != (1.0F / 1.0F))
      {
        localObject1 = new dk(Math.max((f1 - paramFloat - i2 / 2 * locali1.c()) / (float)Math.floor((i2 - 1) / 2), 0.0F), 0.0F, 0.0F, 0.0F);
        label614: arrayOfi[0] = q;
        arrayOfi[i2] = arrayOfi[0];
        label630: if (i1 < i2)
        {
          if (i1 % 2 != 0)
            break label666;
          arrayOfi[i1] = localObject1;
        }
      }
      while (true)
      {
        i1++;
        break label630;
        break;
        localObject1 = a.a(paramdp);
        break label614;
        label666: arrayOfi[i1] = locali1;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.bg
 * JD-Core Version:    0.6.0
 */