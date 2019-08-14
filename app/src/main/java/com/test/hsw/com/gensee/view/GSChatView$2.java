package com.gensee.view;

import com.gensee.entity.UserInfo;

class GSChatView$2
  implements Runnable
{
  public void run()
  {
    if ((GSChatView.access$9(this.this$0) != null) && (GSChatView.access$9(this.this$0).getUserId() == this.val$chatTo.getUserId()))
    {
      if (!this.val$bLeave)
        GSChatView.access$9(this.this$0).update(this.val$chatTo);
    }
    else
      return;
    GSChatView.access$10(this.this$0, null);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSChatView.2
 * JD-Core Version:    0.6.0
 */