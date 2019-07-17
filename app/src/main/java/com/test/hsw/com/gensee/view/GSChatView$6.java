package com.gensee.view;

import com.gensee.chat.MsgQueue;

class GSChatView$6
  implements Runnable
{
  public void run()
  {
    MsgQueue.getIns().onMessageFresh();
    GSChatView.access$12(this.this$0, 10002);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSChatView.6
 * JD-Core Version:    0.6.0
 */