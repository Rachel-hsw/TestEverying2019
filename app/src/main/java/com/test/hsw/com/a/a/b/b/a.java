package com.a.a.b.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.a.a.b.a.e;
import com.a.a.b.a.h;
import com.a.a.b.d.b.a;
import java.io.IOException;
import java.io.InputStream;

public class a
  implements b
{
  protected static final String a = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";
  protected static final String b = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";
  protected static final String c = "Rotate image on %1$d° [%2$s]";
  protected static final String d = "Flip image horizontally [%s]";
  protected static final String e = "Image can't be decoded [%s]";
  protected final boolean f;

  public a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  private boolean a(String paramString1, String paramString2)
  {
    return ("image/jpeg".equalsIgnoreCase(paramString2)) && (b.a.a(paramString1) == b.a.c);
  }

  protected Bitmap a(Bitmap paramBitmap, c paramc, int paramInt, boolean paramBoolean)
  {
    Matrix localMatrix = new Matrix();
    com.a.a.b.a.d locald = paramc.e();
    e locale1;
    e locale2;
    h localh;
    if ((locald == com.a.a.b.a.d.e) || (locald == com.a.a.b.a.d.f))
    {
      locale1 = new e(paramBitmap.getWidth(), paramBitmap.getHeight(), paramInt);
      locale2 = paramc.d();
      localh = paramc.f();
      if (locald != com.a.a.b.a.d.f)
        break label279;
    }
    label279: for (boolean bool = true; ; bool = false)
    {
      float f1 = com.a.a.c.b.b(locale1, locale2, localh, bool);
      if (Float.compare(f1, 1.0F) != 0)
      {
        localMatrix.setScale(f1, f1);
        if (this.f)
        {
          Object[] arrayOfObject3 = new Object[4];
          arrayOfObject3[0] = locale1;
          arrayOfObject3[1] = locale1.a(f1);
          arrayOfObject3[2] = Float.valueOf(f1);
          arrayOfObject3[3] = paramc.a();
          com.a.a.c.d.a("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", arrayOfObject3);
        }
      }
      if (paramBoolean)
      {
        localMatrix.postScale(-1.0F, 1.0F);
        if (this.f)
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = paramc.a();
          com.a.a.c.d.a("Flip image horizontally [%s]", arrayOfObject2);
        }
      }
      if (paramInt != 0)
      {
        localMatrix.postRotate(paramInt);
        if (this.f)
        {
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = Integer.valueOf(paramInt);
          arrayOfObject1[1] = paramc.a();
          com.a.a.c.d.a("Rotate image on %1$d° [%2$s]", arrayOfObject1);
        }
      }
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
      if (localBitmap != paramBitmap)
        paramBitmap.recycle();
      return localBitmap;
    }
  }

  public Bitmap a(c paramc)
    throws IOException
  {
    InputStream localInputStream = b(paramc);
    b localb;
    Bitmap localBitmap;
    try
    {
      localb = a(localInputStream, paramc);
      localInputStream = b(localInputStream, paramc);
      localBitmap = BitmapFactory.decodeStream(localInputStream, null, a(localb.a, paramc));
      com.a.a.c.c.a(localInputStream);
      if (localBitmap == null)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramc.a();
        com.a.a.c.d.d("Image can't be decoded [%s]", arrayOfObject);
        return localBitmap;
      }
    }
    finally
    {
      com.a.a.c.c.a(localInputStream);
    }
    return a(localBitmap, paramc, localb.b.a, localb.b.b);
  }

  protected BitmapFactory.Options a(e parame, c paramc)
  {
    com.a.a.b.a.d locald = paramc.e();
    if (locald == com.a.a.b.a.d.a);
    for (int i = 1; ; i = com.a.a.c.b.a(parame))
    {
      if ((i > 1) && (this.f))
      {
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[0] = parame;
        arrayOfObject[1] = parame.a(i);
        arrayOfObject[2] = Integer.valueOf(i);
        arrayOfObject[3] = paramc.a();
        com.a.a.c.d.a("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", arrayOfObject);
      }
      BitmapFactory.Options localOptions = paramc.j();
      localOptions.inSampleSize = i;
      return localOptions;
      if (locald != com.a.a.b.a.d.b)
        break;
    }
    e locale = paramc.d();
    if (locald == com.a.a.b.a.d.c);
    for (boolean bool = true; ; bool = false)
    {
      i = com.a.a.c.b.a(parame, locale, paramc.f(), bool);
      break;
    }
  }

  protected a a(String paramString)
  {
    int i = 0;
    boolean bool = true;
    try
    {
      int j = new ExifInterface(b.a.c.c(paramString)).getAttributeInt("Orientation", 1);
      i = 0;
      switch (j)
      {
      case 1:
      default:
        bool = false;
      case 2:
      case 6:
      case 7:
      case 3:
      case 4:
      case 8:
      case 5:
      }
      while (true)
      {
        return new a(i, bool);
        bool = false;
        i = 90;
        continue;
        bool = false;
        i = 180;
        continue;
        bool = false;
        i = 270;
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        Object[] arrayOfObject = new Object[bool];
        arrayOfObject[0] = paramString;
        com.a.a.c.d.c("Can't read EXIF tags from file [%s]", arrayOfObject);
      }
    }
  }

  protected b a(InputStream paramInputStream, c paramc)
    throws IOException
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    String str = paramc.b();
    if ((paramc.i()) && (a(str, localOptions.outMimeType)));
    for (a locala = a(str); ; locala = new a())
      return new b(new e(localOptions.outWidth, localOptions.outHeight, locala.a), locala);
  }

  protected InputStream b(c paramc)
    throws IOException
  {
    return paramc.g().a(paramc.b(), paramc.h());
  }

  protected InputStream b(InputStream paramInputStream, c paramc)
    throws IOException
  {
    try
    {
      paramInputStream.reset();
      return paramInputStream;
    }
    catch (IOException localIOException)
    {
      com.a.a.c.c.a(paramInputStream);
    }
    return b(paramc);
  }

  protected static class a
  {
    public final int a;
    public final boolean b;

    protected a()
    {
      this.a = 0;
      this.b = false;
    }

    protected a(int paramInt, boolean paramBoolean)
    {
      this.a = paramInt;
      this.b = paramBoolean;
    }
  }

  protected static class b
  {
    public final e a;
    public final a.a b;

    protected b(e parame, a.a parama)
    {
      this.a = parame;
      this.b = parama;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.b.b.a
 * JD-Core Version:    0.6.0
 */