package com.gensee.player;

import android.content.Context;
import com.gensee.entity.LoginResEntity;
import com.gensee.entity.UserInfo;
import com.gensee.taskret.OnTaskRet;
import com.gensee.utils.FileUtil;
import com.gensee.utils.GenseeLog;

class Player$4
  implements OnTaskRet
{
  public void onTaskRet(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      if (Player.access$0(this.this$0) != null)
        Player.access$0(this.this$0).onSubject(this.val$lEntity.getWebcastSubject());
      int i = (int)this.val$lEntity.getSiteId();
      long l = this.val$lEntity.getUserId();
      String str1 = this.val$lEntity.getWebcastSubject();
      String str2 = this.val$lEntity.getAlbServer();
      String str3 = Player.access$6(this.this$0, str2);
      int j = Player.access$7(this.this$0, this.val$lEntity.getServicetype());
      String str4 = this.val$lEntity.getWebcastId();
      String str5 = this.val$lEntity.getNickName();
      String str6 = this.val$lEntity.getUserData();
      if (str6 == null)
        str6 = "";
      String str7 = FileUtil.getCachDir(this.val$context, "rtmpplayer");
      Player.access$8(this.this$0, new UserInfo(l, str5, 16, -1));
      GenseeLog.d("Player", "join room confId = " + str4 + " cachDir = " + str7);
      Player.access$9(this.this$0).join(i, l, str5, str3, j, str4, str1, str6, Player.access$10(this.this$0), str7);
    }
    do
      return;
    while (Player.access$0(this.this$0) == null);
    Player.access$0(this.this$0).onJoin(8);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.player.Player.4
 * JD-Core Version:    0.6.0
 */