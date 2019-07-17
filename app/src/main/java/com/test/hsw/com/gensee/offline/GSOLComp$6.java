package com.gensee.offline;

import com.gensee.entity.InitParam;
import com.gensee.entity.VodParam;
import com.gensee.net.IHttpHandler;
import com.gensee.net.IHttpHandler.Response;

class GSOLComp$6
  implements IHttpHandler.Response
{
  public void onConnectError(int paramInt, String paramString)
  {
    GSOLComp.access$1(this.this$0).onConnectError(3, "");
  }

  public void onRes(String paramString)
  {
    VodParam localVodParam = (VodParam)GSOLComp.access$1(this.this$0).onLoginVod(paramString);
    if (localVodParam != null)
    {
      localVodParam.setDomain(this.val$domain);
      String str = GSOLComp.access$4(this.this$0).getNumber();
      if ((str != null) && (!"".equals(str)))
        localVodParam.setNumber(str);
      GSOLComp.access$5(this.this$0, localVodParam);
      GSOLComp.initOfflineComp(GSOLComp.access$6(this.this$0), new GSOLComp.6.1(this, localVodParam));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.offline.GSOLComp.6
 * JD-Core Version:    0.6.0
 */