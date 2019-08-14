package com.a.a.a.b.a;

import android.graphics.Bitmap;
import com.a.a.a.b.b;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class a extends b
{
  private final List<Bitmap> a = Collections.synchronizedList(new LinkedList());

  public a(int paramInt)
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
      this.a.add(paramBitmap);
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
    return (Bitmap)this.a.remove(0);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.a.b.a.a
 * JD-Core Version:    0.6.0
 */