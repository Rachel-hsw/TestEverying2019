package com.gensee.view;

import com.gensee.chat.MsgQueue;
import com.gensee.entity.UserInfo;
import java.util.List;

class GSChatView$5
  implements Runnable
{
  public void run()
  {
    this.this$0.selfList.addAll(MsgQueue.getIns().getMsgsByOwnerId(this.val$self.getUserId()));
    this.this$0.post(new GSChatView.5.1(this));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSChatView.5
 * JD-Core Version:    0.6.0
 */