package com.gensee.view;

import com.gensee.taskret.OnTaskRet;

class GSChatView$3
  implements OnTaskRet
{
  public void onTaskRet(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
      this.this$0.onChatWithPublic(this.val$senderId, this.val$senderName, this.val$content, this.val$richText, this.val$chatId);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSChatView.3
 * JD-Core Version:    0.6.0
 */