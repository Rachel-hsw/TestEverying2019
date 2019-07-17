package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.b.a.f;
import com.ta.utdid2.b.a.h;
import java.util.zip.Adler32;

public final class b
{
  static String a;
  static final Object b;
  private static a c = null;

  static
  {
    a = "d6fc3a4a06adbde89223bvefedc24fecde188aaa9161";
    b = new Object();
  }

  public static a a(Context paramContext)
  {
    monitorenter;
    while (true)
    {
      try
      {
        if (c == null)
          continue;
        locala = c;
        return locala;
        if (paramContext != null)
        {
          locala = b(paramContext);
          c = locala;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      a locala = null;
    }
  }

  private static a b(Context paramContext)
  {
    if (paramContext != null)
      new a();
    while (true)
    {
      String str1;
      synchronized (b)
      {
        str1 = c.a(paramContext).a();
        if (h.a(str1))
          continue;
        if (str1.endsWith("\n"))
        {
          str2 = str1.substring(0, -1 + str1.length());
          a locala = new a();
          long l1 = System.currentTimeMillis();
          String str3 = f.a(paramContext);
          String str4 = f.b(paramContext);
          locala.c(str3);
          locala.a(str3);
          locala.b(l1);
          locala.b(str4);
          locala.d(str2);
          Object[] arrayOfObject = new Object[5];
          arrayOfObject[0] = locala.e();
          arrayOfObject[1] = locala.d();
          arrayOfObject[2] = Long.valueOf(locala.a());
          arrayOfObject[3] = locala.c();
          arrayOfObject[4] = locala.b();
          String str5 = String.format("%s%s%s%s%s", arrayOfObject);
          if (h.a(str5))
            continue;
          Adler32 localAdler32 = new Adler32();
          localAdler32.reset();
          localAdler32.update(str5.getBytes());
          long l2 = localAdler32.getValue();
          locala.a(l2);
          return locala;
          l2 = 0L;
          continue;
          return null;
        }
      }
      String str2 = str1;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.ta.utdid2.device.b
 * JD-Core Version:    0.6.0
 */