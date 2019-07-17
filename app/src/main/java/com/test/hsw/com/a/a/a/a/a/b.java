package com.a.a.a.a.a;

import android.graphics.Bitmap;
import com.a.a.c.c.a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class b extends a
{
  private final long j;
  private final Map<File, Long> k = Collections.synchronizedMap(new HashMap());

  public b(File paramFile, long paramLong)
  {
    this(paramFile, null, com.a.a.b.a.b(), paramLong);
  }

  public b(File paramFile1, File paramFile2, long paramLong)
  {
    this(paramFile1, paramFile2, com.a.a.b.a.b(), paramLong);
  }

  public b(File paramFile1, File paramFile2, com.a.a.a.a.b.a parama, long paramLong)
  {
    super(paramFile1, paramFile2, parama);
    this.j = (1000L * paramLong);
  }

  private void d(String paramString)
  {
    File localFile = c(paramString);
    long l = System.currentTimeMillis();
    localFile.setLastModified(l);
    this.k.put(localFile, Long.valueOf(l));
  }

  public File a(String paramString)
  {
    File localFile = super.a(paramString);
    Long localLong;
    int i;
    if ((localFile != null) && (localFile.exists()))
    {
      localLong = (Long)this.k.get(localFile);
      if (localLong != null)
        break label80;
      i = 0;
      localLong = Long.valueOf(localFile.lastModified());
      if (System.currentTimeMillis() - localLong.longValue() <= this.j)
        break label86;
      localFile.delete();
      this.k.remove(localFile);
    }
    label80: label86: 
    do
    {
      return localFile;
      i = 1;
      break;
    }
    while (i != 0);
    this.k.put(localFile, localLong);
    return localFile;
  }

  public boolean a(String paramString, Bitmap paramBitmap)
    throws IOException
  {
    boolean bool = super.a(paramString, paramBitmap);
    d(paramString);
    return bool;
  }

  public boolean a(String paramString, InputStream paramInputStream, c.a parama)
    throws IOException
  {
    boolean bool = super.a(paramString, paramInputStream, parama);
    d(paramString);
    return bool;
  }

  public boolean b(String paramString)
  {
    this.k.remove(c(paramString));
    return super.b(paramString);
  }

  public void c()
  {
    super.c();
    this.k.clear();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.a.a.a.b
 * JD-Core Version:    0.6.0
 */