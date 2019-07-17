package com.umeng.socialize.b;

import android.content.Context;
import com.umeng.socialize.b.a.b;
import com.umeng.socialize.b.a.b.b;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.common.r;
import com.umeng.socialize.utils.m;
import java.util.Map;

public class d extends b
{
  private static final String f = "/share/validate_token/";
  private static final int j = 24;
  private p[] k;

  public d(Context paramContext, ay paramay, p[] paramArrayOfp)
  {
    super(paramContext, "", e.class, paramay, 24, b.b.a);
    this.k = paramArrayOfp;
  }

  protected String a()
  {
    return "/share/validate_token/" + m.a(this.d) + "/";
  }

  protected Map<String, Object> a(Map<String, Object> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.k != null) && (this.k.length > 0))
    {
      for (p localp : this.k)
      {
        if (localp == p.b)
          continue;
        localStringBuilder.append(localp.toString()).append(",");
      }
      localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
    }
    paramMap.put("platforms", localStringBuilder.toString());
    paramMap.put("uid", r.g);
    return paramMap;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.d
 * JD-Core Version:    0.6.0
 */