package com.tencent.open.b;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.open.utils.Util;

public class d
{
  protected static d a;

  public static d a()
  {
    monitorenter;
    try
    {
      if (a == null)
        a = new d();
      d locald = a;
      return locald;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong, int paramInt2, int paramInt3, String paramString5)
  {
    long l1 = SystemClock.elapsedRealtime() - paramLong.longValue();
    long l2;
    if ((paramLong.longValue() == 0L) || (l1 < 0L))
      l2 = 0L;
    while (true)
    {
      StringBuffer localStringBuffer = new StringBuffer("http://c.isdspeed.qq.com/code.cgi");
      localStringBuffer.append("?domain=mobile.opensdk.com&cgi=opensdk&type=").append(paramInt1).append("&code=").append(paramInt2).append("&time=").append(l2).append("&rate=").append(paramInt3).append("&uin=").append(paramString2).append("&data=");
      Bundle localBundle = Util.composeHaboCgiReportParams(String.valueOf(paramInt1), String.valueOf(paramInt2), String.valueOf(l2), String.valueOf(paramInt3), paramString1, paramString2, paramString3, paramString4, paramString5);
      g.a().a(localStringBuffer.toString(), "GET", localBundle, true);
      return;
      l2 = l1;
    }
  }

  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    Bundle localBundle = Util.composeViaReportParams(paramString1, paramString4, paramString5, paramString3, paramString2, paramString6, "", paramString7, paramString8, "", "", "");
    g.a().a(localBundle, paramString2, false);
  }

  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    Bundle localBundle = Util.composeViaReportParams(paramString1, paramString4, paramString5, paramString3, paramString2, paramString6, paramString7, "", "", paramString8, paramString9, paramString10);
    g.a().a(localBundle, paramString2, false);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.b.d
 * JD-Core Version:    0.6.0
 */