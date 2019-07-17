package com.gensee.view;

import com.gensee.chat.QaMsgQueue;
import com.gensee.entity.UserInfo;
import java.util.List;

class GSQaView$3
  implements Runnable
{
  public void run()
  {
    this.this$0.selfList.addAll(QaMsgQueue.getIns().queryQaMsgsByOwnerId(this.val$self.getUserId()));
    this.this$0.post(new GSQaView.3.1(this));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSQaView.3
 * JD-Core Version:    0.6.0
 */