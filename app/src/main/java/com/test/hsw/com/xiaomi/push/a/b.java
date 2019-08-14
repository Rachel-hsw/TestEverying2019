package com.xiaomi.push.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.xiaomi.d.e.h;
import com.xiaomi.d.e.i;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static b c = null;
  private final ConcurrentLinkedQueue<b> a = new ConcurrentLinkedQueue();
  private Context b;

  private b(Context paramContext)
  {
    this.b = paramContext;
    this.a.add(new a());
    b(0L);
  }

  public static b a(Context paramContext)
  {
    if (c == null)
      monitorenter;
    try
    {
      if (c == null)
        c = new b(paramContext);
      monitorexit;
      c.b = paramContext;
      return c;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void a(long paramLong)
  {
    b localb = (b)this.a.peek();
    if ((localb != null) && (localb.d()))
      b(paramLong);
  }

  private void b()
  {
    if ((com.xiaomi.a.a.b.c.b()) || (com.xiaomi.a.a.b.c.a()));
    while (true)
    {
      return;
      try
      {
        File localFile = new File(this.b.getExternalFilesDir(null) + "/.logcache");
        if ((!localFile.exists()) || (!localFile.isDirectory()))
          continue;
        File[] arrayOfFile = localFile.listFiles();
        int i = arrayOfFile.length;
        for (int j = 0; j < i; j++)
          arrayOfFile[j].delete();
      }
      catch (NullPointerException localNullPointerException)
      {
      }
    }
  }

  private void b(long paramLong)
  {
    if (!this.a.isEmpty())
      i.a(new d(this), paramLong);
  }

  private void c()
  {
    while ((!this.a.isEmpty()) && ((((b)this.a.peek()).e()) || (this.a.size() > 6)))
    {
      com.xiaomi.a.a.c.c.c("remove Expired task");
      this.a.remove();
    }
  }

  public void a()
  {
    c();
    a(0L);
  }

  public void a(String paramString1, String paramString2, Date paramDate1, Date paramDate2, int paramInt, boolean paramBoolean)
  {
    this.a.add(new c(this, paramInt, paramDate1, paramDate2, paramString1, paramString2, paramBoolean));
    b(0L);
  }

  class a extends b.b
  {
    a()
    {
      super();
    }

    public void b()
    {
      b.c(b.this);
    }
  }

  class b extends com.xiaomi.a.a.d.b.b
  {
    long b = System.currentTimeMillis();

    b()
    {
    }

    public void b()
    {
    }

    public boolean d()
    {
      return true;
    }

    final boolean e()
    {
      return System.currentTimeMillis() - this.b > 172800000L;
    }
  }

  class c extends b.b
  {
    String a;
    String d;
    File e;
    int f;
    boolean g;
    boolean h;

    c(String paramString1, String paramFile, File paramBoolean, boolean arg5)
    {
      super();
      this.a = paramString1;
      this.d = paramFile;
      this.e = paramBoolean;
      boolean bool;
      this.h = bool;
    }

    private boolean f()
    {
      SharedPreferences localSharedPreferences = b.a(b.this).getSharedPreferences("log.timestamp", 0);
      String str = localSharedPreferences.getString("log.requst", "");
      long l = System.currentTimeMillis();
      int j;
      label96: JSONObject localJSONObject2;
      try
      {
        JSONObject localJSONObject1 = new JSONObject(str);
        l = localJSONObject1.getLong("time");
        int k = localJSONObject1.getInt("times");
        j = k;
        if (System.currentTimeMillis() - l < 86400000L)
        {
          if (j <= 10)
            break label96;
          return false;
        }
      }
      catch (JSONException localJSONException1)
      {
        while (true)
          j = 0;
        l = System.currentTimeMillis();
        j = 0;
        localJSONObject2 = new JSONObject();
      }
      try
      {
        localJSONObject2.put("time", l);
        localJSONObject2.put("times", j + 1);
        localSharedPreferences.edit().putString("log.requst", localJSONObject2.toString()).commit();
        return true;
      }
      catch (JSONException localJSONException2)
      {
        while (true)
          com.xiaomi.a.a.c.c.c("JSONException on put " + localJSONException2.getMessage());
      }
    }

    public void b()
    {
      try
      {
        if (f())
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("uid", h.b());
          localHashMap.put("token", this.d);
          localHashMap.put("net", com.xiaomi.a.a.e.d.f(b.a(b.this)));
          com.xiaomi.a.a.e.d.a(this.a, localHashMap, this.e, "file");
        }
        this.g = true;
        return;
      }
      catch (IOException localIOException)
      {
      }
    }

    public void c()
    {
      if (!this.g)
      {
        this.f = (1 + this.f);
        if (this.f < 3)
          b.b(b.this).add(this);
      }
      if ((this.g) || (this.f >= 3))
        this.e.delete();
      b.a(b.this, 1000 * (1 << this.f));
    }

    public boolean d()
    {
      return (com.xiaomi.a.a.e.d.e(b.a(b.this))) || ((this.h) && (com.xiaomi.a.a.e.d.d(b.a(b.this))));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.a.b
 * JD-Core Version:    0.6.0
 */