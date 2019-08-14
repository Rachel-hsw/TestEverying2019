package com.a.a.a.b.a;

import android.graphics.Bitmap;
import com.a.a.a.b.b;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class d extends b
{
  private final Map<Bitmap, Integer> a = Collections.synchronizedMap(new HashMap());

  public d(int paramInt)
  {
    super(paramInt);
  }

  protected Reference<Bitmap> a(Bitmap paramBitmap)
  {
    return new WeakReference(paramBitmap);
  }

  public boolean a(String paramString, Bitmap paramBitmap)
  {
    if (super.a(paramString, paramBitmap))
    {
      this.a.put(paramBitmap, Integer.valueOf(b(paramBitmap)));
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
    Bitmap localBitmap = super.a(paramString);
    if (localBitmap != null)
      this.a.remove(localBitmap);
    return super.b(paramString);
  }

  public void b()
  {
    this.a.clear();
    super.b();
  }

  protected Bitmap d()
  {
    Object localObject1 = null;
    Set localSet = this.a.entrySet();
    while (true)
    {
      synchronized (this.a)
      {
        Iterator localIterator = localSet.iterator();
        localObject3 = null;
        if (!localIterator.hasNext())
          continue;
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localObject1 != null)
          continue;
        localObject4 = (Bitmap)localEntry.getKey();
        localObject5 = (Integer)localEntry.getValue();
        break label160;
        Integer localInteger = (Integer)localEntry.getValue();
        if (localInteger.intValue() > localObject3.intValue())
        {
          Bitmap localBitmap = (Bitmap)localEntry.getKey();
          localObject5 = localInteger;
          localObject4 = localBitmap;
          break label160;
          this.a.remove(localObject1);
          return localObject1;
        }
      }
      Object localObject4 = localObject1;
      Object localObject5 = localObject3;
      label160: localObject1 = localObject4;
      Object localObject3 = localObject5;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.a.b.a.d
 * JD-Core Version:    0.6.0
 */