package com.umeng.socialize.weixin.a;

import android.content.Context;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.utils.m;

class d
  implements IWXAPIEventHandler
{
  d(a parama)
  {
  }

  public void onReq(BaseReq paramBaseReq)
  {
  }

  public void onResp(BaseResp paramBaseResp)
  {
    if (a.u(this.a))
      a.a(this.a, paramBaseResp);
    int i;
    do
    {
      p localp;
      do
      {
        return;
        i = 0;
        localp = ax.o();
        switch (paramBaseResp.errCode)
        {
        default:
          i.c("UMWXHandler", "### 微信发送 -- 未知错误.");
        case 0:
        case -1:
        case -2:
        case -3:
        case -4:
        }
      }
      while (a.u(this.a));
      a.v(this.a).a(SocializeListeners.SnsPostListener.class, localp, i, a.g());
    }
    while ((i != 200) || (a.g() == null));
    Context localContext = a.w(this.a);
    String str1 = a.g().c;
    String str2 = this.a.E;
    UMediaObject localUMediaObject = this.a.F;
    if (a.x(this.a));
    for (String str3 = "wxtimeline"; ; str3 = "wxsession")
    {
      m.a(localContext, str1, str2, localUMediaObject, str3);
      return;
      i.c("UMWXHandler", "### 微信分享成功.");
      i = 200;
      break;
      i = -1;
      break;
      i = 40000;
      i.c("UMWXHandler", "### 微信分享取消");
      break;
      i = -3;
      break;
      i = -4;
      i.c("UMWXHandler", "### 微信发送被拒绝");
      break;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.weixin.a.d
 * JD-Core Version:    0.6.0
 */