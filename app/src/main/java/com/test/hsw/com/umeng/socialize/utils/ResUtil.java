package com.umeng.socialize.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.umeng.socialize.b.b.a;
import com.umeng.socialize.b.b.h.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Stack;
import java.util.WeakHashMap;

public class ResUtil
{
  public static boolean a = false;
  private static final String b = ResUtil.class.getName();
  private static final long c = 104857600L;
  private static final long d = 10485760L;
  private static final Map<ImageView, String> e;

  static
  {
    a = false;
    e = Collections.synchronizedMap(new WeakHashMap());
  }

  private static Bitmap a(Bitmap paramBitmap)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      RectF localRectF = new RectF(localRect);
      localPaint.setAntiAlias(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect(localRectF, paramBitmap.getWidth() / 6, paramBitmap.getHeight() / 6, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
      paramBitmap.recycle();
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      i.e(b, "Cant`t create round corner bitmap. [OutOfMemoryError] ");
    }
    return null;
  }

  public static String a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    label273: String str3;
    try
    {
      String str1 = b(paramString) + ".tmp";
      String str2;
      long l;
      File localFile2;
      if (c.a())
      {
        str2 = Environment.getExternalStorageDirectory().getCanonicalPath();
        l = 104857600L;
        localFile2 = new File(str2 + "/download/.um");
        if (!localFile2.exists())
          break label273;
        if (b(localFile2.getCanonicalFile()) > l)
          new Thread(new l(localFile2)).start();
      }
      while (true)
      {
        localFile1 = new File(localFile2, str1);
        try
        {
          localFile1.createNewFile();
          localFileOutputStream = new FileOutputStream(localFile1);
          localInputStream = (InputStream)new URL(paramString).openConnection().getContent();
          byte[] arrayOfByte = new byte[4096];
          while (true)
          {
            int i = localInputStream.read(arrayOfByte);
            if (i == -1)
              break;
            localFileOutputStream.write(arrayOfByte, 0, i);
          }
        }
        catch (Exception localException1)
        {
        }
        i.a(b, localException1.getStackTrace().toString() + "\t url:\t" + paramString);
        if ((localFile1 != null) && (localFile1.exists()))
          localFile1.deleteOnExit();
        return null;
        str2 = paramContext.getCacheDir().getCanonicalPath();
        l = 10485760L;
        break;
        if (localFile2.mkdirs())
          continue;
        i.b(b, "Failed to create directory" + localFile2.getAbsolutePath() + ". Check permission. Make sure WRITE_EXTERNAL_STORAGE is added in your Manifest.xml");
      }
    }
    catch (Exception localException2)
    {
      File localFile1;
      FileOutputStream localFileOutputStream;
      InputStream localInputStream;
      while (true)
        localFile1 = null;
      localFileOutputStream.flush();
      localInputStream.close();
      localFileOutputStream.close();
      File localFile3 = new File(localFile1.getParent(), localFile1.getName().replace(".tmp", ""));
      localFile1.renameTo(localFile3);
      i.a(b, "download img[" + paramString + "]  to " + localFile3.getCanonicalPath());
      str3 = localFile3.getCanonicalPath();
    }
    return str3;
  }

  public static void a(Context paramContext, ImageView paramImageView, String paramString, boolean paramBoolean, BindDrawableListener paramBindDrawableListener, Animation paramAnimation)
  {
    if (paramImageView == null);
    while (true)
    {
      return;
      e.put(paramImageView, paramString);
      try
      {
        File localFile = b(paramContext, paramString);
        if ((localFile == null) || (!localFile.exists()) || (a))
          break;
        if (paramBindDrawableListener != null)
          paramBindDrawableListener.a(a.a);
        Drawable localDrawable = c(localFile.getAbsolutePath());
        if (localDrawable == null)
          localFile.delete();
        b(paramContext, paramImageView, localDrawable, paramBoolean, paramBindDrawableListener, paramAnimation, paramString);
        return;
      }
      catch (Exception localException)
      {
        i.b(b, "", localException);
      }
      if (paramBindDrawableListener == null)
        continue;
      paramBindDrawableListener.a(h.a.b);
      return;
    }
    new b(paramContext, paramImageView, paramString, a.b, null, paramBoolean, paramBindDrawableListener, paramAnimation).execute(new Object[0]);
  }

  private static boolean a(ImageView paramImageView, String paramString)
  {
    String str = (String)e.get(paramImageView);
    return (str != null) && (!str.equals(paramString));
  }

  private static long b(File paramFile)
  {
    long l1;
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory()))
      l1 = 0L;
    while (true)
    {
      return l1;
      Stack localStack = new Stack();
      localStack.clear();
      localStack.push(paramFile);
      l1 = 0L;
      while (!localStack.isEmpty())
      {
        File[] arrayOfFile = ((File)localStack.pop()).listFiles();
        long l2 = l1;
        int i = 0;
        if (i < arrayOfFile.length)
        {
          long l3;
          if (arrayOfFile[i].isDirectory())
          {
            localStack.push(arrayOfFile[i]);
            l3 = l2;
          }
          while (true)
          {
            i++;
            l2 = l3;
            break;
            l3 = l2 + arrayOfFile[i].length();
          }
        }
        l1 = l2;
      }
    }
  }

  protected static File b(Context paramContext, String paramString)
    throws IOException
  {
    String str1 = b(paramString);
    if (c.a());
    for (String str2 = Environment.getExternalStorageDirectory().getCanonicalPath(); ; str2 = paramContext.getCacheDir().getCanonicalPath())
    {
      File localFile = new File(new File(str2 + "/download/.um"), str1);
      if (!localFile.exists())
        break;
      return localFile;
    }
    return null;
  }

  private static String b(String paramString)
  {
    return a.c(paramString);
  }

  private static void b(Context paramContext, ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean, BindDrawableListener paramBindDrawableListener, Animation paramAnimation, String paramString)
  {
    monitorenter;
    if (paramDrawable != null);
    while (true)
    {
      try
      {
        paramDrawable = new BitmapDrawable(a(((BitmapDrawable)paramDrawable).getBitmap()));
        break label202;
        if (paramBindDrawableListener == null)
          continue;
        paramBindDrawableListener.a(h.a.b);
        i.e(b, "bind drawable failed. drawable [" + paramDrawable + "]  imageView[+" + paramImageView + "+]");
        return;
        if (a(paramImageView, paramString))
        {
          if (paramBindDrawableListener == null)
            continue;
          paramBindDrawableListener.a(h.a.b);
          continue;
        }
      }
      catch (Exception localException)
      {
        i.b(b, "bind failed", localException);
        if (paramBindDrawableListener == null)
          continue;
        paramBindDrawableListener.a(h.a.b);
        continue;
      }
      finally
      {
        monitorexit;
      }
      if (paramBoolean == true)
        paramImageView.setBackgroundDrawable(paramDrawable);
      while (true)
      {
        if (paramAnimation != null)
          paramImageView.startAnimation(paramAnimation);
        if (paramBindDrawableListener == null)
          break;
        paramBindDrawableListener.a(h.a.a);
        break;
        paramImageView.setImageDrawable(paramDrawable);
      }
      label202: if (paramDrawable == null)
        continue;
      if (paramImageView != null)
        continue;
    }
  }

  private static Drawable c(String paramString)
  {
    try
    {
      Drawable localDrawable = Drawable.createFromPath(paramString);
      return localDrawable;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      i.e(b, "Resutil fetchImage OutOfMemoryError:" + localOutOfMemoryError.toString());
    }
    return null;
  }

  private static void c(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.canWrite()) || (!paramFile.isDirectory()))
      return;
    File[] arrayOfFile = paramFile.listFiles();
    int i = 0;
    label33: if (i < arrayOfFile.length)
    {
      if (!arrayOfFile[i].isDirectory())
        break label60;
      c(arrayOfFile[i]);
    }
    while (true)
    {
      i++;
      break label33;
      break;
      label60: if (new Date().getTime() - arrayOfFile[i].lastModified() <= 1800L)
        continue;
      arrayOfFile[i].delete();
    }
  }

  public static abstract interface BindDrawableListener
  {
    public abstract void a(h.a parama);

    public abstract void a(ResUtil.a parama);
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      c = arrayOfa;
    }
  }

  static class b extends AsyncTask<Object, Integer, Drawable>
  {
    private Context a;
    private String b;
    private ImageView c;
    private ResUtil.a d;
    private boolean e;
    private ResUtil.BindDrawableListener f;
    private Animation g;
    private File h;

    public b(Context paramContext, ImageView paramImageView, String paramString, ResUtil.a parama, File paramFile, boolean paramBoolean, ResUtil.BindDrawableListener paramBindDrawableListener, Animation paramAnimation)
    {
      this.h = paramFile;
      this.a = paramContext;
      this.b = paramString;
      this.f = paramBindDrawableListener;
      this.d = parama;
      this.e = paramBoolean;
      this.g = paramAnimation;
      this.c = paramImageView;
    }

    protected Drawable a(Object[] paramArrayOfObject)
    {
      if (ResUtil.a);
      try
      {
        Thread.sleep(3000L);
        if ((this.h != null) && (this.h.exists()))
        {
          Drawable localDrawable2 = ResUtil.a(this.h.getAbsolutePath());
          if (localDrawable2 == null)
            this.h.delete();
          i.c(ResUtil.a(), "get drawable from cacheFile.");
          return localDrawable2;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
          localInterruptedException.printStackTrace();
      }
      while (true)
      {
        try
        {
          ResUtil.a(this.a, this.b);
          File localFile = ResUtil.b(this.a, this.b);
          if ((localFile != null) && (localFile.exists()))
          {
            localDrawable1 = ResUtil.a(localFile.getAbsolutePath());
            i.c(ResUtil.a(), "get drawable from net else file.");
            return localDrawable1;
          }
        }
        catch (Exception localException)
        {
          i.e(ResUtil.a(), localException.toString(), localException);
          return null;
        }
        Drawable localDrawable1 = null;
      }
    }

    protected void a(Drawable paramDrawable)
    {
      ResUtil.a(this.a, this.c, paramDrawable, this.e, this.f, this.g, this.b);
    }

    protected void onPreExecute()
    {
      super.onPreExecute();
      if (this.f != null)
        this.f.a(this.d);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.utils.ResUtil
 * JD-Core Version:    0.6.0
 */