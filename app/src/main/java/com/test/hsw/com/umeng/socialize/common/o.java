package com.umeng.socialize.common;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import com.umeng.socialize.utils.i;
import java.io.File;
import java.io.IOException;

class o extends AsyncTask<Object, Integer, Drawable>
{
  o(SocialResHelper.a parama)
  {
  }

  protected Drawable a(Object[] paramArrayOfObject)
  {
    try
    {
      if (SocialResHelper.a)
        Thread.sleep(3000L);
      label12: Integer[] arrayOfInteger1 = new Integer[1];
      arrayOfInteger1[0] = Integer.valueOf(0);
      publishProgress(arrayOfInteger1);
      SocialResHelper.a(this.a.a, this.a.c);
      Drawable localDrawable = null;
      try
      {
        Integer[] arrayOfInteger2 = new Integer[1];
        arrayOfInteger2[0] = Integer.valueOf(1);
        publishProgress(arrayOfInteger2);
        File localFile = SocialResHelper.b(this.a.a, this.a.c);
        localDrawable = null;
        if (localFile != null)
        {
          boolean bool = localFile.exists();
          localDrawable = null;
          if (bool)
          {
            localDrawable = Drawable.createFromPath(localFile.getAbsolutePath());
            if (localDrawable == null)
              localFile.delete();
          }
        }
        return localDrawable;
      }
      catch (IOException localIOException)
      {
        i.e(SocialResHelper.a(), localIOException.toString());
        return localDrawable;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label12;
    }
  }

  protected void a(Drawable paramDrawable)
  {
    SocialResHelper.a.a(this.a, this.a.a, this.a.b, paramDrawable, this.a.i, this.a.d, this.a.f, this.a.h, this.a.e);
  }

  protected void a(Integer[] paramArrayOfInteger)
  {
    super.onProgressUpdate(paramArrayOfInteger);
    if ((paramArrayOfInteger == null) || (paramArrayOfInteger.length < 1));
    do
    {
      do
      {
        return;
        switch (paramArrayOfInteger[0].intValue())
        {
        default:
          return;
        case 0:
        case 1:
        }
      }
      while (this.a.d == null);
      this.a.d.a(SocialResHelper.b.b);
      return;
    }
    while (this.a.d == null);
    this.a.d.a(SocialResHelper.b.a);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.common.o
 * JD-Core Version:    0.6.0
 */