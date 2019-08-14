package com.gensee.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.gensee.chat.QaMsgQueue;
import com.gensee.entity.QAMsg;
import com.gensee.utils.GenseeLog;
import com.gensee.view.xlistview.XListView;
import java.util.Iterator;
import java.util.List;

class GSQaView$1 extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 20003:
    default:
    case 20005:
    case 20004:
    case 20002:
    case 20000:
    case 20001:
    }
    while (true)
    {
      super.handleMessage(paramMessage);
      do
      {
        return;
        GSQaView.access$0(this.this$0).stopLoadMore();
        if (GSQaView.access$1(this.this$0) != null)
          GSQaView.access$1(this.this$0).notifyData((List)paramMessage.obj);
        boolean bool3 = paramMessage.getData().getBoolean("QALATEST");
        GenseeLog.d("GSQaView refresh NEW_QA_LOADMORE bLatest = " + bool3);
        GSQaView.access$2(this.this$0, bool3);
        GSQaView.access$3(this.this$0, false);
        break;
        boolean bool2 = paramMessage.getData().getBoolean("QALATEST");
        GenseeLog.d("GSQaView refresh NEW_QA_REFRESH bLatest1 = " + bool2);
        GSQaView.access$2(this.this$0, bool2);
        if (GSQaView.access$1(this.this$0) != null)
          GSQaView.access$1(this.this$0).notifyData((List)paramMessage.obj);
        this.this$0.onLvReLoad();
        GSQaView.access$3(this.this$0, false);
        break;
      }
      while (paramMessage.obj == null);
      List localList = (List)paramMessage.obj;
      if (!GSQaView.access$4(this.this$0).isSelected())
        continue;
      Iterator localIterator = localList.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          if (GSQaView.access$1(this.this$0) == null)
            break;
          GSQaView.access$1(this.this$0).notifyData(this.this$0.selfList);
          break;
        }
        QAMsg localQAMsg = (QAMsg)localIterator.next();
        if (localQAMsg.getQuestOwnerId() != GSQaView.access$5(this.this$0))
          continue;
        this.this$0.selfList.add(localQAMsg);
      }
      boolean bool1 = paramMessage.getData().getBoolean("QALATEST");
      GenseeLog.d("GSQaView refresh NEW_QA_MSG bLatestNewMsg = " + bool1);
      if ((GSQaView.access$4(this.this$0).isSelected()) || (!bool1))
        continue;
      if (GSQaView.access$1(this.this$0) != null)
        GSQaView.access$1(this.this$0).notifyData((List)paramMessage.obj);
      GSQaView.access$2(this.this$0, bool1);
      continue;
      String str = (String)paramMessage.obj;
      if ((QaMsgQueue.getIns().cancelQaMsg(str)) && (!GSQaView.access$4(this.this$0).isSelected()))
        this.this$0.updateData();
      if ((!GSQaView.access$4(this.this$0).isSelected()) || (GSQaView.access$1(this.this$0) == null))
        continue;
      this.this$0.selfList.clear();
      this.this$0.selfList.addAll(QaMsgQueue.getIns().queryQaMsgsByOwnerId(GSQaView.access$5(this.this$0)));
      GSQaView.access$1(this.this$0).notifyData(this.this$0.selfList);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSQaView.1
 * JD-Core Version:    0.6.0
 */