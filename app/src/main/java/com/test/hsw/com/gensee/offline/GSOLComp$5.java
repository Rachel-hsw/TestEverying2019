package com.gensee.offline;

import com.gensee.entity.AccVodResEntity;
import com.gensee.net.IHttpHandler;
import com.gensee.net.IHttpHandler.Response;

class GSOLComp$5
  implements IHttpHandler.Response
{
  public void onConnectError(int paramInt, String paramString)
  {
    GSOLComp.access$1(this.this$0).onConnectError(paramInt, paramString);
  }

  public void onRes(String paramString)
  {
    AccVodResEntity localAccVodResEntity = (AccVodResEntity)GSOLComp.access$1(this.this$0).onAccessVod(paramString);
    this.this$0.onAccessResult(localAccVodResEntity);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.offline.GSOLComp.5
 * JD-Core Version:    0.6.0
 */