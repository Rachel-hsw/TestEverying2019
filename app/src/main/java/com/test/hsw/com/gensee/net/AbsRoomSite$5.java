package com.gensee.net;

import com.gensee.entity.LoginResEntity;

class AbsRoomSite$5
  implements AbsRtAction.Response
{
  public void onConnectError(int paramInt, String paramString)
  {
    this.this$0.mHttpHandler.onError(paramInt, paramString);
  }

  public void onRes(String paramString)
  {
    LoginResEntity localLoginResEntity = this.this$0.mHttpHandler.onLoginInfoRes(paramString, true);
    if (localLoginResEntity != null)
    {
      localLoginResEntity.setRole(8);
      AbsRoomSite.access$1(this.this$0, localLoginResEntity);
      this.this$0.mHttpHandler.onLoginFinish(localLoginResEntity);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.net.AbsRoomSite.5
 * JD-Core Version:    0.6.0
 */