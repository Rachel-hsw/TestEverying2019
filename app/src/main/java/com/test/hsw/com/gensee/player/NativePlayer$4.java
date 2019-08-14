package com.gensee.player;

import com.gensee.utils.StringUtil;

class NativePlayer$4
  implements Runnable
{
  public void run()
  {
    if (NativePlayer.access$0(this.this$0) != null)
      if (!StringUtil.isEmpty(this.val$richText))
        break label62;
    label62: for (String str = this.val$strContent; this.val$isGroup; str = this.val$richText)
    {
      NativePlayer.access$0(this.this$0).OnChatWithPublic(this.val$senderId, this.val$strSender, this.val$strContent, str, this.val$onChatID);
      return;
    }
    NativePlayer.access$0(this.this$0).OnChatWithPersion(this.val$senderId, this.val$strSender, this.val$strContent, str, this.val$onChatID);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.player.NativePlayer.4
 * JD-Core Version:    0.6.0
 */