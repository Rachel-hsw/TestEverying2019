package com.withustudy.koudaizikao.f;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.android.volley.toolbox.l.b;

public class a extends LruCache<String, Bitmap>
  implements l.b
{
  public a()
  {
    this(a());
  }

  public a(int paramInt)
  {
    super(paramInt);
  }

  public static int a()
  {
    return (int)(Runtime.getRuntime().maxMemory() / 1024L) / 8;
  }

  public Bitmap a(String paramString)
  {
    return (Bitmap)get(paramString);
  }

  public void a(String paramString, Bitmap paramBitmap)
  {
    put(paramString, paramBitmap);
  }

  protected int b(String paramString, Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight() / 1024;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.f.a
 * JD-Core Version:    0.6.0
 */