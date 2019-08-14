package com.gensee.view;

import com.gensee.chat.QaMsgQueue;

class GSQaView$4
  implements Runnable
{
  public void run()
  {
    QaMsgQueue.getIns().onMessageFresh();
    GSQaView.access$13(this.this$0, 20004);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSQaView.4
 * JD-Core Version:    0.6.0
 */