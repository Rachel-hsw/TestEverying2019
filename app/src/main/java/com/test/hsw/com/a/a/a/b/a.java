package com.a.a.a.b;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public abstract class a
  implements c
{
  private final Map<String, Reference<Bitmap>> a = Collections.synchronizedMap(new HashMap());

  public Bitmap a(String paramString)
  {
    Reference localReference = (Reference)this.a.get(paramString);
    if (localReference != null)
      return (Bitmap)localReference.get();
    return null;
  }

  protected abstract Reference<Bitmap> a(Bitmap paramBitmap);

  public Collection<String> a()
  {
    synchronized (this.a)
    {
      HashSet localHashSet = new HashSet(this.a.keySet());
      return localHashSet;
    }
  }

  public boolean a(String paramString, Bitmap paramBitmap)
  {
    this.a.put(paramString, a(paramBitmap));
    return true;
  }

  public Bitmap b(String paramString)
  {
    Reference localReference = (Reference)this.a.remove(paramString);
    if (localReference == null)
      return null;
    return (Bitmap)localReference.get();
  }

  public void b()
  {
    this.a.clear();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.a.b.a
 * JD-Core Version:    0.6.0
 */