package com.gensee.player;

import com.gensee.entity.UserInfo;

class NativePlayer$2
  implements Runnable
{
  public void run()
  {
    switch (this.val$notifytype)
    {
    default:
      return;
    case 0:
      NativePlayer.access$0(this.this$0).onUserJoin(new UserInfo(this.val$userId, this.val$name, this.val$role, this.val$chatId));
      return;
    case 1:
      NativePlayer.access$0(this.this$0).onUserLeave(new UserInfo(this.val$userId, this.val$name, this.val$role, this.val$chatId));
      return;
    case 2:
    }
    NativePlayer.access$0(this.this$0).onUserUpdate(new UserInfo(this.val$userId, this.val$name, this.val$role, this.val$chatId));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.player.NativePlayer.2
 * JD-Core Version:    0.6.0
 */