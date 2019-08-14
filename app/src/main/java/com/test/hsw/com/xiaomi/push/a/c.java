package com.xiaomi.push.a;

import android.content.Context;
import java.io.File;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

class c extends b.b
{
  File a;

  c(b paramb, int paramInt, Date paramDate1, Date paramDate2, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramb);
  }

  public void b()
  {
    if (!com.xiaomi.a.a.b.c.d());
    while (true)
    {
      return;
      try
      {
        File localFile = new File(b.a(this.j).getExternalFilesDir(null) + "/.logcache");
        localFile.mkdirs();
        if (!localFile.isDirectory())
          continue;
        a locala = new a();
        locala.a(this.d);
        this.a = locala.a(b.a(this.j), this.e, this.f, localFile);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
      }
    }
  }

  public void c()
  {
    if ((this.a != null) && (this.a.exists()))
      b.b(this.j).add(new b.c(this.j, this.g, this.h, this.a, this.i));
    b.a(this.j, 0L);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.a.c
 * JD-Core Version:    0.6.0
 */