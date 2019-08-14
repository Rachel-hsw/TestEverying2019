package com.a.a.a.b.a;

import android.graphics.Bitmap;
import com.a.a.a.b.c;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class b
  implements c
{
  private final c a;
  private final Comparator<String> b;

  public b(c paramc, Comparator<String> paramComparator)
  {
    this.a = paramc;
    this.b = paramComparator;
  }

  public Bitmap a(String paramString)
  {
    return (Bitmap)this.a.b(paramString);
  }

  public Collection<String> a()
  {
    return this.a.a();
  }

  public boolean a(String paramString, Bitmap paramBitmap)
  {
    while (true)
    {
      synchronized (this.a)
      {
        Iterator localIterator = this.a.a().iterator();
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (this.b.compare(paramString, str) != 0)
            continue;
          if (str == null)
            continue;
          this.a.a(str);
          return this.a.a(paramString, paramBitmap);
        }
      }
      String str = null;
    }
  }

  public Bitmap b(String paramString)
  {
    return (Bitmap)this.a.a(paramString);
  }

  public void b()
  {
    this.a.b();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.a.b.a.b
 * JD-Core Version:    0.6.0
 */