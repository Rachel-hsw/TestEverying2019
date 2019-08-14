package com.gensee.view;

import com.gensee.chat.MsgQueue;

class GSChatView$7
  implements Runnable
{
  public void run()
  {
    MsgQueue.getIns().onMessageLoadMore();
    GSChatView.access$12(this.this$0, 10003);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSChatView.7
 * JD-Core Version:    0.6.0
 */