package com.gensee.view;

import com.gensee.taskret.OnTaskRet;

class GSChatView$4
  implements OnTaskRet
{
  public void onTaskRet(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
      this.this$0.onChatToPerson(this.val$receiverId, this.val$receiverName, this.val$content, this.val$richText);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSChatView.4
 * JD-Core Version:    0.6.0
 */