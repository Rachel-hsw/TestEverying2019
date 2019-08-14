package com.xiaomi.mipush;

import com.android.http.n.a;
import com.withustudy.koudaizikao.g.h;
import java.util.Map;

class a
  implements n.a
{
  a(MiPushReceiver paramMiPushReceiver)
  {
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
  }

  public void onRequest()
  {
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    h.a("res", paramString1);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.a
 * JD-Core Version:    0.6.0
 */