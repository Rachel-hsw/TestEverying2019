package com.a.a.a.b.a;

import android.graphics.Bitmap;
import com.a.a.a.b.c;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class e
  implements c
{
  private final c a;
  private final long b;
  private final Map<String, Long> c = Collections.synchronizedMap(new HashMap());

  public e(c paramc, long paramLong)
  {
    this.a = paramc;
    this.b = (1000L * paramLong);
  }

  public Bitmap a(String paramString)
  {
    Long localLong = (Long)this.c.get(paramString);
    if ((localLong != null) && (System.currentTimeMillis() - localLong.longValue() > this.b))
    {
      this.a.a(paramString);
      this.c.remove(paramString);
    }
    return (Bitmap)this.a.b(paramString);
  }

  public Collection<String> a()
  {
    return this.a.a();
  }

  public boolean a(String paramString, Bitmap paramBitmap)
  {
    boolean bool = this.a.a(paramString, paramBitmap);
    if (bool)
      this.c.put(paramString, Long.valueOf(System.currentTimeMillis()));
    return bool;
  }

  public Bitmap b(String paramString)
  {
    this.c.remove(paramString);
    return (Bitmap)this.a.a(paramString);
  }

  public void b()
  {
    this.a.b();
    this.c.clear();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.a.b.a.e
 * JD-Core Version:    0.6.0
 */