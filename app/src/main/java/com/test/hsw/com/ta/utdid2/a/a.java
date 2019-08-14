package com.ta.utdid2.a;

import android.content.Context;
import android.util.Log;
import com.ta.utdid2.b.a.e;
import com.ta.utdid2.b.a.h;
import com.ta.utdid2.b.a.i;
import com.ut.device.AidCallback;

public class a
{
  private static a a = null;
  private static final String b = a.class.getName();
  private Context c;

  private a(Context paramContext)
  {
    this.c = paramContext;
  }

  public static a a(Context paramContext)
  {
    monitorenter;
    try
    {
      if (a == null)
        a = new a(paramContext);
      a locala = a;
      return locala;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private String b(String paramString1, String paramString2, String paramString3)
  {
    monitorenter;
    try
    {
      String str;
      if (this.c == null)
      {
        Log.e(b, "no context!");
        str = "";
      }
      while (true)
      {
        return str;
        str = "";
        if (e.a(this.c))
          str = b.a(this.c).a(paramString1, paramString2, paramString3, c.a(this.c, paramString1, paramString2));
        c.a(this.c, paramString1, str, paramString2);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public final String a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool1 = true;
    boolean bool2;
    label84: String str2;
    if ((this.c == null) || (h.a(paramString1)) || (h.a(paramString2)))
    {
      String str1 = b;
      StringBuilder localStringBuilder1 = new StringBuilder("mContext:").append(this.c).append("; has appName:");
      if (!h.a(paramString1))
      {
        bool2 = bool1;
        StringBuilder localStringBuilder2 = localStringBuilder1.append(bool2).append("; has token:");
        if (h.a(paramString2))
          break label113;
        Log.e(str1, bool1);
        str2 = "";
      }
    }
    label113: 
    do
    {
      return str2;
      bool2 = false;
      break;
      bool1 = false;
      break label84;
      str2 = c.a(this.c, paramString1, paramString2);
    }
    while (((!h.a(str2)) && (i.a(c.b(this.c, paramString1, paramString2)))) || (!e.a(this.c)));
    return b(paramString1, paramString2, paramString3);
  }

  public final void a(String paramString1, String paramString2, String paramString3, AidCallback paramAidCallback)
  {
    boolean bool1 = true;
    if (paramAidCallback == null)
    {
      Log.e(b, "callback is null!");
      return;
    }
    if ((this.c == null) || (h.a(paramString1)) || (h.a(paramString2)))
    {
      String str1 = b;
      StringBuilder localStringBuilder1 = new StringBuilder("mContext:").append(this.c).append("; callback:").append(paramAidCallback).append("; has appName:");
      boolean bool2;
      StringBuilder localStringBuilder2;
      if (!h.a(paramString1))
      {
        bool2 = bool1;
        localStringBuilder2 = localStringBuilder1.append(bool2).append("; has token:");
        if (h.a(paramString2))
          break label144;
      }
      while (true)
      {
        Log.e(str1, bool1);
        paramAidCallback.onAidEventChanged(1002, "");
        return;
        bool2 = false;
        break;
        label144: bool1 = false;
      }
    }
    String str2 = c.a(this.c, paramString1, paramString2);
    if ((!h.a(str2)) && (i.a(c.b(this.c, paramString1, paramString2))))
    {
      paramAidCallback.onAidEventChanged(1001, str2);
      return;
    }
    if (e.a(this.c))
    {
      b.a(this.c).a(paramString1, paramString2, paramString3, str2, paramAidCallback);
      return;
    }
    paramAidCallback.onAidEventChanged(1003, str2);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.ta.utdid2.a.a
 * JD-Core Version:    0.6.0
 */