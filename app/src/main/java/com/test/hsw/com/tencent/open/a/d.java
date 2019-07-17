package com.tencent.open.a;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.text.SimpleDateFormat;

public class d
{
  public static final class a
  {
    public static final boolean a(int paramInt1, int paramInt2)
    {
      return paramInt2 == (paramInt1 & paramInt2);
    }
  }

  public static final class b
  {
    public static boolean a(File paramFile)
    {
      int i = 0;
      if (paramFile != null)
      {
        if (!paramFile.isFile())
          break label28;
        if (paramFile.delete())
          break label26;
        paramFile.deleteOnExit();
      }
      label26: label28: 
      do
      {
        return false;
        return true;
      }
      while (!paramFile.isDirectory());
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      while (i < j)
      {
        a(arrayOfFile[i]);
        i++;
      }
      return paramFile.delete();
    }
  }

  public static final class c
  {
    public static boolean a()
    {
      String str = Environment.getExternalStorageState();
      return ("mounted".equals(str)) || ("mounted_ro".equals(str));
    }

    public static d.d b()
    {
      if (!a())
        return null;
      return d.d.b(Environment.getExternalStorageDirectory());
    }
  }

  public static class d
  {
    private File a;
    private long b;
    private long c;

    public static d b(File paramFile)
    {
      d locald = new d();
      locald.a(paramFile);
      StatFs localStatFs = new StatFs(paramFile.getAbsolutePath());
      long l1 = localStatFs.getBlockSize();
      long l2 = localStatFs.getBlockCount();
      long l3 = localStatFs.getAvailableBlocks();
      locald.a(l2 * l1);
      locald.b(l1 * l3);
      return locald;
    }

    public File a()
    {
      return this.a;
    }

    public void a(long paramLong)
    {
      this.b = paramLong;
    }

    public void a(File paramFile)
    {
      this.a = paramFile;
    }

    public long b()
    {
      return this.b;
    }

    public void b(long paramLong)
    {
      this.c = paramLong;
    }

    public long c()
    {
      return this.c;
    }

    public String toString()
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = a().getAbsolutePath();
      arrayOfObject[1] = Long.valueOf(c());
      arrayOfObject[2] = Long.valueOf(b());
      return String.format("[%s : %d / %d]", arrayOfObject);
    }
  }

  public static final class e
  {
    @SuppressLint({"SimpleDateFormat"})
    public static SimpleDateFormat a(String paramString)
    {
      return new SimpleDateFormat(paramString);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.a.d
 * JD-Core Version:    0.6.0
 */