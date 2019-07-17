package org.android.agoo.c.c;

import com.umeng.message.b.ay;
import java.util.Map;
import org.android.agoo.c.a.b;

public abstract class f extends b
{
  private static final String a = "MtopResponseHandler";
  public static final String g = "SUCCESS";
  public static final String h = "FAIL";
  public static final String i = "ERROR_SERVICE_NOT_AVAILABLE";

  protected void a(Map<String, String> paramMap, String paramString)
  {
    try
    {
      i locali = g.a(paramString);
      if (locali.b())
      {
        onSuccess(paramMap, locali.c());
        return;
      }
      onFailure(locali.e(), locali.d());
      return;
    }
    catch (Throwable localThrowable)
    {
      ay.e("MtopResponseHandler", "handleSuccessMessage:" + paramString, localThrowable);
      onFailure(localThrowable, paramMap, paramString);
    }
  }

  public void onFailure(String paramString1, String paramString2)
  {
  }

  public void onFailure(Throwable paramThrowable, String paramString)
  {
    onFailure("ERROR_SERVICE_NOT_AVAILABLE", paramString);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.c.c.f
 * JD-Core Version:    0.6.0
 */