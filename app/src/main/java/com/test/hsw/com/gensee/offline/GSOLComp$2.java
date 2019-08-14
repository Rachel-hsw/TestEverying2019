package com.gensee.offline;

import com.gensee.net.IHttpHandler;
import com.gensee.net.IHttpHandler.Response;

class GSOLComp$2
  implements IHttpHandler.Response
{
  public void onConnectError(int paramInt, String paramString)
  {
    GSOLComp.access$1(this.this$0).sendBroadCast("gs.action.rec.msg.vote.submit", "connect");
  }

  public void onRes(String paramString)
  {
    if ((paramString != null) && (paramString.contains("<result>ok</result>")))
    {
      GSOLComp.access$1(this.this$0).sendBroadCast("gs.action.rec.msg.vote.submit", "1");
      return;
    }
    GSOLComp.access$1(this.this$0).sendBroadCast("gs.action.rec.msg.vote.submit", "err");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.offline.GSOLComp.2
 * JD-Core Version:    0.6.0
 */