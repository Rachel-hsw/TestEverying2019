package com.a.a.a.b;

import android.graphics.Bitmap;
import com.a.a.c.d;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class b extends a
{
  private static final int a = 16;
  private static final int b = 16777216;
  private final int c;
  private final AtomicInteger d;
  private final List<Bitmap> e = Collections.synchronizedList(new LinkedList());

  public b(int paramInt)
  {
    this.c = paramInt;
    this.d = new AtomicInteger();
    if (paramInt > 16777216)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(16);
      d.c("You set too large memory cache size (more than %1$d Mb)", arrayOfObject);
    }
  }

  public boolean a(String paramString, Bitmap paramBitmap)
  {
    int i = b(paramBitmap);
    int j = c();
    int k = this.d.get();
    int m = 0;
    if (i < j)
    {
      int n = k;
      while (n + i > j)
      {
        Bitmap localBitmap = d();
        if (!this.e.remove(localBitmap))
          continue;
        n = this.d.addAndGet(-b(localBitmap));
      }
      this.e.add(paramBitmap);
      this.d.addAndGet(i);
      m = 1;
    }
    super.a(paramString, paramBitmap);
    return m;
  }

  protected abstract int b(Bitmap paramBitmap);

  public Bitmap b(String paramString)
  {
    Bitmap localBitmap = super.a(paramString);
    if ((localBitmap != null) && (this.e.remove(localBitmap)))
      this.d.addAndGet(-b(localBitmap));
    return super.b(paramString);
  }

  public void b()
  {
    this.e.clear();
    this.d.set(0);
    super.b();
  }

  protected int c()
  {
    return this.c;
  }

  protected abstract Bitmap d();
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.a.b.b
 * JD-Core Version:    0.6.0
 */