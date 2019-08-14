package com.gensee.net;

import com.gensee.entity.AccessResEntity;

class AbsRoomSite$2
  implements AbsRtAction.Response
{
  public void onConnectError(int paramInt, String paramString)
  {
    this.this$0.mHttpHandler.onError(paramInt, paramString);
  }

  public void onRes(String paramString)
  {
    AccessResEntity localAccessResEntity = this.this$0.mHttpHandler.onAccessInfoRes(paramString);
    this.this$0.onAccessResult(localAccessResEntity);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.net.AbsRoomSite.2
 * JD-Core Version:    0.6.0
 */