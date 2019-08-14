package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView.ScaleType;
import com.android.volley.e;
import com.android.volley.l;
import com.android.volley.n;
import com.android.volley.o;
import com.android.volley.o.b;
import com.android.volley.s;
import com.android.volley.s.a;
import com.android.volley.s.b;
import com.android.volley.s<Landroid.graphics.Bitmap;>;
import com.android.volley.y;

public class q extends o<Bitmap>
{
  private static final int a = 1000;
  private static final int b = 2;
  private static final float c = 2.0F;
  private static final Object i = new Object();
  private final s.b<Bitmap> d;
  private final Bitmap.Config e;
  private final int f;
  private final int g;
  private ImageView.ScaleType h;

  @Deprecated
  public q(String paramString, s.b<Bitmap> paramb, int paramInt1, int paramInt2, Bitmap.Config paramConfig, s.a parama)
  {
    this(paramString, paramb, paramInt1, paramInt2, ImageView.ScaleType.CENTER_INSIDE, paramConfig, parama);
  }

  public q(String paramString, s.b<Bitmap> paramb, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType, Bitmap.Config paramConfig, s.a parama)
  {
    super(0, paramString, parama);
    a(new e(1000, 2, 2.0F));
    this.d = paramb;
    this.e = paramConfig;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramScaleType;
  }

  static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d1 = Math.min(paramInt1 / paramInt3, paramInt2 / paramInt4);
    float f1 = 1.0F;
    while (true)
    {
      if (f1 * 2.0F > d1)
        return (int)f1;
      f1 *= 2.0F;
    }
  }

  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageView.ScaleType paramScaleType)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
      paramInt1 = paramInt3;
    double d1;
    do
      while (true)
      {
        return paramInt1;
        if (paramScaleType == ImageView.ScaleType.FIT_XY)
          if (paramInt1 == 0)
            return paramInt3;
        if (paramInt1 == 0)
          return (int)(paramInt2 / paramInt4 * paramInt3);
        if (paramInt2 == 0)
          continue;
        d1 = paramInt4 / paramInt3;
        if (paramScaleType != ImageView.ScaleType.CENTER_CROP)
          break;
        if (d1 * paramInt1 < paramInt2)
          return (int)(paramInt2 / d1);
      }
    while (d1 * paramInt1 <= paramInt2);
    return (int)(paramInt2 / d1);
  }

  private s<Bitmap> b(l paraml)
  {
    byte[] arrayOfByte = paraml.b;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    Object localObject;
    if ((this.f == 0) && (this.g == 0))
    {
      localOptions.inPreferredConfig = this.e;
      localObject = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
    }
    while (localObject == null)
    {
      return s.a(new n(paraml));
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
      int j = localOptions.outWidth;
      int k = localOptions.outHeight;
      int m = a(this.f, this.g, j, k, this.h);
      int n = a(this.g, this.f, k, j, this.h);
      localOptions.inJustDecodeBounds = false;
      localOptions.inSampleSize = a(j, k, m, n);
      Bitmap localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
      if ((localBitmap != null) && ((localBitmap.getWidth() > m) || (localBitmap.getHeight() > n)))
      {
        localObject = Bitmap.createScaledBitmap(localBitmap, m, n, true);
        localBitmap.recycle();
        continue;
      }
      localObject = localBitmap;
    }
    return (s<Bitmap>)s.a(localObject, i.a(paraml));
  }

  protected s<Bitmap> a(l paraml)
  {
    synchronized (i)
    {
      try
      {
        s locals2 = b(paraml);
        return locals2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(paraml.b.length);
        arrayOfObject[1] = j();
        y.c("Caught OOM for %d byte image, url=%s", arrayOfObject);
        s locals1 = s.a(new n(localOutOfMemoryError));
        return locals1;
      }
    }
  }

  protected void a(Bitmap paramBitmap)
  {
    this.d.a(paramBitmap);
  }

  public o.b w()
  {
    return o.b.a;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.q
 * JD-Core Version:    0.6.0
 */