package com.tencent.connect.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.open.a.f;
import com.tencent.open.utils.AsynLoadImgBack;
import com.tencent.open.utils.Util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class a
{
  public static final int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = b(paramOptions, paramInt1, paramInt2);
    if (i <= 8)
    {
      j = 1;
      while (j < i)
        j <<= 1;
    }
    int j = 8 * ((i + 7) / 8);
    return j;
  }

  private static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Matrix localMatrix = new Matrix();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if (i > j);
    while (true)
    {
      float f = paramInt / i;
      localMatrix.postScale(f, f);
      return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
      i = j;
    }
  }

  public static final Bitmap a(String paramString, int paramInt)
  {
    Bitmap localBitmap;
    if (TextUtils.isEmpty(paramString))
      localBitmap = null;
    while (true)
    {
      return localBitmap;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      int i = localOptions.outWidth;
      int j = localOptions.outHeight;
      if ((localOptions.mCancel) || (localOptions.outWidth == -1) || (localOptions.outHeight == -1))
        return null;
      if (i > j);
      while (true)
      {
        localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        if (i > paramInt)
          localOptions.inSampleSize = a(localOptions, -1, paramInt * paramInt);
        localOptions.inJustDecodeBounds = false;
        localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
        if (localBitmap != null)
          break;
        return null;
        i = j;
      }
      int k = localOptions.outWidth;
      int m = localOptions.outHeight;
      if (k > m);
      while (k > paramInt)
      {
        return a(localBitmap, paramInt);
        k = m;
      }
    }
  }

  protected static final String a(Bitmap paramBitmap, String paramString1, String paramString2)
  {
    File localFile1 = new File(paramString1);
    if (!localFile1.exists())
      localFile1.mkdirs();
    String str = paramString1 + paramString2;
    File localFile2 = new File(str);
    if (localFile2.exists())
      localFile2.delete();
    if (paramBitmap != null);
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile2);
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 80, localFileOutputStream);
      localFileOutputStream.flush();
      localFileOutputStream.close();
      paramBitmap.recycle();
      return str;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      return null;
    }
    catch (IOException localIOException)
    {
      while (true)
        localIOException.printStackTrace();
    }
  }

  public static final void a(Context paramContext, String paramString, AsynLoadImgBack paramAsynLoadImgBack)
  {
    f.b("AsynScaleCompressImage", "scaleCompressImage");
    if (TextUtils.isEmpty(paramString))
    {
      paramAsynLoadImgBack.saved(1, null);
      return;
    }
    if (!Util.hasSDCard())
    {
      paramAsynLoadImgBack.saved(2, null);
      return;
    }
    new Thread(new a.2(paramString, new a.1(paramContext.getMainLooper(), paramAsynLoadImgBack))).start();
  }

  public static final void a(Context paramContext, ArrayList<String> paramArrayList, AsynLoadImgBack paramAsynLoadImgBack)
  {
    f.b("AsynScaleCompressImage", "batchScaleCompressImage");
    if (paramArrayList == null)
    {
      paramAsynLoadImgBack.saved(1, null);
      return;
    }
    new Thread(new a.4(paramArrayList, new a.3(paramContext.getMainLooper(), paramAsynLoadImgBack))).start();
  }

  private static int b(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    double d1 = paramOptions.outWidth;
    double d2 = paramOptions.outHeight;
    int i;
    int j;
    if (paramInt2 == -1)
    {
      i = 1;
      if (paramInt1 != -1)
        break label60;
      j = 128;
      label31: if (j >= i)
        break label84;
    }
    label60: label84: 
    do
    {
      return i;
      i = (int)Math.ceil(Math.sqrt(d1 * d2 / paramInt2));
      break;
      j = (int)Math.min(Math.floor(d1 / paramInt1), Math.floor(d2 / paramInt1));
      break label31;
      if ((paramInt2 == -1) && (paramInt1 == -1))
        return 1;
    }
    while (paramInt1 == -1);
    return j;
  }

  private static final boolean b(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString))
      return false;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    int i = localOptions.outWidth;
    int j = localOptions.outHeight;
    if ((localOptions.mCancel) || (localOptions.outWidth == -1) || (localOptions.outHeight == -1))
      return false;
    int k;
    if (i > j)
    {
      k = i;
      if (i >= j)
        break label146;
    }
    while (true)
    {
      f.b("AsynScaleCompressImage", "longSide=" + k + "shortSide=" + i);
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      if ((k <= paramInt2) && (i <= paramInt1))
        break label153;
      return true;
      k = j;
      break;
      label146: i = j;
    }
    label153: return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.connect.share.a
 * JD-Core Version:    0.6.0
 */