package com.gensee.net;

import com.gensee.entity.LoginResEntity;

class AbsRoomSite$4
  implements AbsRtAction.Response
{
  public void onConnectError(int paramInt, String paramString)
  {
    this.this$0.mHttpHandler.onError(paramInt, paramString);
  }

  public void onRes(String paramString)
  {
    LoginResEntity localLoginResEntity = this.this$0.mHttpHandler.onLoginInfoRes(paramString, false);
    if (localLoginResEntity != null)
    {
      localLoginResEntity.setRole(4);
      AbsRoomSite.access$1(this.this$0, localLoginResEntity);
      this.this$0.mHttpHandler.onLoginFinish(localLoginResEntity);
      return;
    }
    AbsRoomSite.access$3(this.this$0, this.val$strUrl, this.val$param);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.net.AbsRoomSite.4
 * JD-Core Version:    0.6.0
 */