package org.android.agoo.e;

import android.content.Context;
import android.text.TextUtils;

public class b
{
  private static final b a = new b();
  private static final String c = "agoo_android_module";
  private volatile a b = null;

  public static b a()
  {
    return a;
  }

  public final a a(Context paramContext)
    throws Throwable
  {
    try
    {
      if (this.b == null)
      {
        String str1 = org.android.a.l(paramContext);
        if (!TextUtils.isEmpty(str1))
        {
          this.b = ((a)Class.forName(str1).newInstance());
          String str2 = org.android.a.d(paramContext);
          String str3 = org.android.a.e(paramContext);
          if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)))
            break label88;
          String str4 = org.android.a.f(paramContext);
          this.b.a(paramContext, str2, str4, str3);
        }
      }
      while (true)
      {
        return this.b;
        label88: this.b = null;
      }
    }
    catch (Throwable localThrowable)
    {
    }
    throw localThrowable;
  }

  public final void a(Context paramContext, Object paramObject, String[] paramArrayOfString)
  {
    try
    {
      if (this.b != null)
      {
        String str = org.android.a.g(paramContext);
        a(paramContext).a(273791437, "agoo_android_module", str, paramObject, paramArrayOfString);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.e.b
 * JD-Core Version:    0.6.0
 */