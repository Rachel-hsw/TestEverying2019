package com.alipay.sdk.protocol;

import android.text.TextUtils;
import com.alipay.sdk.data.e;
import org.json.JSONObject;

public final class g extends h
{
  private int l;
  private boolean m = false;

  protected g(e parame, com.alipay.sdk.data.f paramf)
  {
    super(parame, paramf);
  }

  private boolean d()
  {
    return this.m;
  }

  public final void a(JSONObject paramJSONObject)
  {
    int i = 0;
    super.a(paramJSONObject);
    if (paramJSONObject.has("form"))
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("form");
      String str = localJSONObject.optString("type");
      this.k = Boolean.parseBoolean(localJSONObject.optString("oneTime"));
      if (TextUtils.equals("page", str))
      {
        this.m = true;
        this.l = 9;
      }
      do
        while (true)
        {
          return;
          if (TextUtils.equals("dialog", str))
          {
            this.l = 7;
            this.m = false;
            return;
          }
          if (!TextUtils.equals("toast", str))
            break;
          b localb = b.a(localJSONObject, "onload");
          this.l = 6;
          if (localb == null)
            continue;
          a[] arrayOfa = a.a(localb);
          int j = arrayOfa.length;
          while (i < j)
          {
            a locala = arrayOfa[i];
            if ((locala == a.d) || (locala == a.e))
              this.l = 10;
            i++;
          }
        }
      while (TextUtils.equals("confirm", str));
      this.m = TextUtils.equals(str, "fullscreen");
      this.l = 4;
      return;
    }
    if (f.a(paramJSONObject.optString("status")) == f.c)
    {
      this.l = -10;
      return;
    }
    this.l = 8;
  }

  public final boolean a()
  {
    return (this.l == 4) || (this.l == 9);
  }

  public final int b()
  {
    return this.l;
  }

  public final String c()
  {
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.protocol.g
 * JD-Core Version:    0.6.0
 */