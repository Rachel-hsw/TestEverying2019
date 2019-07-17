package com.umeng.a.b;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONObject;

public abstract class m
{
  private static void a(Context paramContext, b paramb, String paramString, a[] paramArrayOfa)
  {
    int i = 0;
    if (paramArrayOfa != null);
    try
    {
      int j = paramArrayOfa.length;
      if (i < j)
        if (!paramArrayOfa[i].f())
          throw new n("parameter is not valid.");
    }
    catch (n localn)
    {
      while (true)
      {
        Log.e("MobclickAgent", "unable send event.", localn);
        return;
        i++;
      }
      new a(s.a(paramContext, paramString, paramArrayOfa), paramb, paramArrayOfa).execute(new Void[0]);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MobclickAgent", "", localException);
    }
  }

  public static void a(Context paramContext, String paramString, a[] paramArrayOfa)
  {
    a(paramContext, null, paramString, paramArrayOfa);
  }

  public static void a(Context paramContext, a[] paramArrayOfa)
  {
    a(paramContext, null, null, paramArrayOfa);
  }

  private static class a extends AsyncTask<Void, Void, q>
  {
    String a = paramArrayOfString[0];
    String b = paramArrayOfString[1];
    m.b c;
    a[] d;

    public a(String[] paramArrayOfString, m.b paramb, a[] paramArrayOfa)
    {
      this.c = paramb;
      this.d = paramArrayOfa;
    }

    protected q a(Void[] paramArrayOfVoid)
    {
      String str1;
      if (TextUtils.isEmpty(this.b))
        str1 = p.a(this.a);
      while (true)
      {
        int i;
        try
        {
          JSONObject localJSONObject = new JSONObject(str1);
          i = localJSONObject.optInt("st");
          if (i == 0)
          {
            j = -404;
            q localq = new q(j);
            String str2 = localJSONObject.optString("msg");
            if (TextUtils.isEmpty(str2))
              continue;
            localq.a(str2);
            String str3 = localJSONObject.optString("data");
            if (TextUtils.isEmpty(str3))
              continue;
            localq.b(str3);
            return localq;
            str1 = p.a(this.a, this.b);
            continue;
          }
        }
        catch (Exception localException)
        {
          return new q(-99, localException);
        }
        int j = i;
      }
    }

    protected void a(q paramq)
    {
      if (this.c != null)
        this.c.a(paramq, this.d);
    }

    protected void onPreExecute()
    {
      if (this.c != null)
        this.c.a();
    }
  }

  public static abstract interface b
  {
    public abstract void a();

    public abstract void a(q paramq, a[] paramArrayOfa);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.a.b.m
 * JD-Core Version:    0.6.0
 */