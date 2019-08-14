package com.withustudy.koudaizikao.a.a;

import android.content.Context;
import com.android.http.n;
import com.android.http.n.a;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.g.h;

public class at extends a
{
  public void a(n.a parama, String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    super.a(parama, paramArrayOfString, paramInt, paramContext);
    String str = "http://api.weibo.com/2/short_url/shorten.json?source=933807290&url_long=" + paramArrayOfString[0];
    h.a("微博加密串:", str);
    n.a().a(str, parama, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.a.a.at
 * JD-Core Version:    0.6.0
 */