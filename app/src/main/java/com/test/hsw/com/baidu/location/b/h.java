package com.baidu.location.b;

import java.util.Iterator;
import java.util.LinkedList;

public class h
  implements f
{
  private static final double[][] bC;
  private static h bD = null;
  private LinkedList bB = null;

  static
  {
    bC = new double[][] { { 120.0618433387417D, 52.993102280803413D }, { 114.4030602114635D, 47.796523164269189D }, { 119.3643163114595D, 47.072753800668799D }, { 111.7970645774334D, 45.245117118706723D }, { 104.9683464256928D, 41.862504156197687D }, { 97.599080653340465D, 43.229770875966622D }, { 90.172611555796934D, 47.840454616690003D }, { 87.088763100354697D, 49.352141072494689D }, { 83.037122886181322D, 47.191596469259132D }, { 72.992644850608954D, 39.20573694893438D }, { 78.453035931162432D, 31.72421462055291D }, { 85.917798717429307D, 27.930639076213879D }, { 92.099129614868886D, 27.71669293109786D }, { 95.273331936203817D, 28.987847625338109D }, { 98.441145440329763D, 27.28076394915907D }, { 97.506815466074045D, 24.714273859299919D }, { 97.52260341956044D, 23.713268294453169D }, { 100.0708944887605D, 21.176736533987601D }, { 101.9206763604854D, 21.133030159808179D }, { 105.2746400703396D, 23.11902125989214D }, { 107.2643282303716D, 21.454138880714609D }, { 108.37613426320191D, 17.314595169353261D }, { 113.0483020881062D, 16.81442875978696D }, { 122.2284167146931D, 21.663740455826971D }, { 123.9556508773411D, 35.664128738043829D }, { 124.2746994608336D, 39.773554305319337D }, { 130.84283673400699D, 42.335144302851738D }, { 132.93686888278461D, 44.59499883995769D }, { 135.34615620473011D, 48.600803994365549D }, { 131.7265723825281D, 48.003302912746562D }, { 124.48501940313891D, 54.244770450983999D }, { 120.0618433387417D, 52.993102280803413D } };
  }

  private h()
  {
    int i = bC.length;
    this.bB = new LinkedList();
    for (int j = 0; j < i - 1; j++)
      this.bB.add(new b(new a(100000.0D * bC[j][0], 100000.0D * bC[j][1]), new a(100000.0D * bC[(j + 1)][0], 100000.0D * bC[(j + 1)][1])));
  }

  public static h W()
  {
    if (bD == null)
      bD = new h();
    return bD;
  }

  public boolean jdMethod_for(double paramDouble1, double paramDouble2)
  {
    while (true)
    {
      int i;
      try
      {
        a locala = new a(100000.0D * paramDouble1, 100000.0D * paramDouble2);
        i = 0;
        Iterator localIterator = this.bB.iterator();
        if (!localIterator.hasNext())
          continue;
        b localb = (b)localIterator.next();
        if (localb.a(locala))
          return true;
        int j = jdMethod_if(localb.jdMethod_if(locala));
        int k = jdMethod_if(localb.jdField_do.jdField_if - locala.jdField_if);
        int m = jdMethod_if(localb.jdField_if.jdField_if - locala.jdField_if);
        if ((j <= 0) || (k > 0) || (m <= 0))
          break label178;
        n = i + 1;
        if ((j >= 0) || (m > 0) || (k <= 0))
          continue;
        n--;
        i = n;
        continue;
        if (i == 0)
          return false;
      }
      catch (Exception localException)
      {
        return true;
      }
      return true;
      label178: int n = i;
    }
  }

  int jdMethod_if(double paramDouble)
  {
    if (paramDouble < -1.0E-008D)
      return -1;
    if (paramDouble > 1.0E-008D)
      return 1;
    return 0;
  }

  class a
  {
    double jdField_do;
    double jdField_if;

    a(double arg2, double arg4)
    {
      this.jdField_do = ???;
      Object localObject;
      this.jdField_if = localObject;
    }
  }

  class b
  {
    h.a jdField_do;
    h.a jdField_if;

    b(h.a parama1, h.a arg3)
    {
      this.jdField_do = parama1;
      Object localObject;
      this.jdField_if = localObject;
    }

    boolean a(h.a parama)
    {
      return (h.this.jdField_if(jdField_if(parama)) == 0) && (parama.jdField_do < 1.0E-008D + Math.max(this.jdField_do.jdField_do, this.jdField_if.jdField_do)) && (parama.jdField_do > Math.min(this.jdField_do.jdField_do, this.jdField_if.jdField_do) - 1.0E-008D) && (parama.jdField_if < 1.0E-008D + Math.max(this.jdField_do.jdField_if, this.jdField_if.jdField_if)) && (parama.jdField_if > Math.min(this.jdField_do.jdField_if, this.jdField_if.jdField_if) - 1.0E-008D);
    }

    double jdField_if(h.a parama)
    {
      h.a locala1 = new h.a(h.this, this.jdField_if.jdField_do - this.jdField_do.jdField_do, this.jdField_if.jdField_if - this.jdField_do.jdField_if);
      h.a locala2 = new h.a(h.this, parama.jdField_do - this.jdField_do.jdField_do, parama.jdField_if - this.jdField_do.jdField_if);
      return locala1.jdField_do * locala2.jdField_if - locala1.jdField_if * locala2.jdField_do;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.b.h
 * JD-Core Version:    0.6.0
 */