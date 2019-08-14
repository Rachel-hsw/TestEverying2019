package com.android.http;

import com.android.volley.l;
import com.android.volley.s.a;
import com.android.volley.s.b;
import com.android.volley.x;

class b extends a
  implements s.a, s.b<l>
{
  private m b;
  private int c = 0;

  public b(m paramm, int paramInt)
  {
    this.b = paramm;
    this.c = paramInt;
  }

  public void a(l paraml)
  {
    this.b.a(paraml.b, paraml.c, b(), this.c);
  }

  public void a(x paramx)
  {
    Object localObject;
    if (paramx.getMessage() != null)
      localObject = paramx.getMessage();
    while (true)
    {
      this.b.a((String)localObject, b(), this.c);
      return;
      try
      {
        String str = "Server Response Error (" + paramx.a.a + ")";
        localObject = str;
      }
      catch (Exception localException)
      {
        localObject = "Server Response Error";
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.http.b
 * JD-Core Version:    0.6.0
 */