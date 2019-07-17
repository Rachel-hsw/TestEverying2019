package com.gensee.view;

import com.gensee.chat.QaMsgQueue;

class GSQaView$5
  implements Runnable
{
  public void run()
  {
    QaMsgQueue.getIns().onMessageLoadMore();
    GSQaView.access$13(this.this$0, 20005);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSQaView.5
 * JD-Core Version:    0.6.0
 */