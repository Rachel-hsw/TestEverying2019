package com.a.a.a.b.a;

import android.graphics.Bitmap;
import com.a.a.a.b.b;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class c extends b
{
  private static final int a = 10;
  private static final float b = 1.1F;
  private final Map<String, Bitmap> c = Collections.synchronizedMap(new LinkedHashMap(10, 1.1F, true));

  public c(int paramInt)
  {
    super(paramInt);
  }

  public Bitmap a(String paramString)
  {
    this.c.get(paramString);
    return super.a(paramString);
  }

  protected Reference<Bitmap> a(Bitmap paramBitmap)
  {
    return new WeakReference(paramBitmap);
  }

  public boolean a(String paramString, Bitmap paramBitmap)
  {
    if (super.a(paramString, paramBitmap))
    {
      this.c.put(paramString, paramBitmap);
      return true;
    }
    return false;
  }

  protected int b(Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }

  public Bitmap b(String paramString)
  {
    this.c.remove(paramString);
    return super.b(paramString);
  }

  public void b()
  {
    this.c.clear();
    super.b();
  }

  protected Bitmap d()
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.c.entrySet().iterator();
      boolean bool = localIterator.hasNext();
      Bitmap localBitmap = null;
      if (bool)
      {
        localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
        localIterator.remove();
      }
      return localBitmap;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.a.b.a.c
 * JD-Core Version:    0.6.0
 */