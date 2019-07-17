package org.android.agoo.c.c;

import android.content.Context;
import com.umeng.message.b.ay;

public class c extends org.android.agoo.c.a.a
  implements a
{
  private static final String a = "MtopAsyncClientV3";
  private String b;
  private String c;
  private String d;

  public final void a(Context paramContext, d paramd, f paramf)
  {
    try
    {
      e.a(paramd, this.b, this.c);
      org.android.agoo.c.a.d locald = e.a(paramContext, paramd);
      a(paramContext, this.d, locald, paramf);
      return;
    }
    catch (Throwable localThrowable)
    {
      ay.e("MtopAsyncClientV3", "getV3", localThrowable);
      paramf.onFailure(localThrowable, null, null);
    }
  }

  public final void a(String paramString)
  {
    this.b = paramString;
  }

  public final void b(String paramString)
  {
    this.c = paramString;
  }

  public final void c(String paramString)
  {
    this.d = paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.c.c.c
 * JD-Core Version:    0.6.0
 */