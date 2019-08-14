package com.umeng.socialize.weixin.a;

import android.text.TextUtils;
import com.umeng.socialize.common.s;
import com.umeng.socialize.controller.listener.SocializeListeners.UMDataListener;
import java.util.Map;

class f extends s<Map<String, Object>>
{
  f(a parama, StringBuilder paramStringBuilder, SocializeListeners.UMDataListener paramUMDataListener)
  {
  }

  protected void a(Map<String, Object> paramMap)
  {
    super.a(paramMap);
    int i = 200;
    Object localObject = paramMap.get("errcode");
    if ((localObject != null) && (!TextUtils.isEmpty(localObject.toString())))
      i = Integer.parseInt(localObject.toString());
    this.b.a(i, paramMap);
  }

  protected Map<String, Object> d()
  {
    String str = com.umeng.socialize.weixin.b.a.a(this.a.toString());
    return a.d(this.c, str);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.weixin.a.f
 * JD-Core Version:    0.6.0
 */