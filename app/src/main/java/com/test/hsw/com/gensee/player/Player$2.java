package com.gensee.player;

import android.content.Context;
import com.gensee.entity.LoginResEntity;
import com.gensee.net.RtmpReq.Callback;

class Player$2
  implements RtmpReq.Callback
{
  public void onErr(int paramInt)
  {
    if (Player.access$0(this.this$0) != null)
      Player.access$0(this.this$0).onErr(paramInt);
  }

  public void onResult(LoginResEntity paramLoginResEntity)
  {
    Player.access$5(this.this$0, this.val$context, paramLoginResEntity);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.player.Player.2
 * JD-Core Version:    0.6.0
 */