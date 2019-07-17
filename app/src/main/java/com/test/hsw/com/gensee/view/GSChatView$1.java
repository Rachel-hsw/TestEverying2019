package com.gensee.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.gensee.adapter.AbsChatAdapter;
import com.gensee.chat.msg.AbsChatMessage;
import com.gensee.chat.msg.PrivateMessage;
import com.gensee.entity.UserInfo;
import com.gensee.player.IPlayerChat;
import com.gensee.utils.GenseeLog;
import com.gensee.view.xlistview.XListView;
import java.util.Iterator;
import java.util.List;

class GSChatView$1 extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    label380: AbsChatMessage localAbsChatMessage;
    int i;
    switch (paramMessage.what)
    {
    default:
    case 3:
    case 2002:
    case 2000:
    case 2001:
    case 10003:
    case 10002:
    case 10004:
      UserInfo localUserInfo;
      Iterator localIterator;
      while (true)
      {
        super.handleMessage(paramMessage);
        do
        {
          return;
          GSChatView.access$0(this.this$0, null, 3);
          break;
          GSChatView.access$0(this.this$0, (UserInfo)paramMessage.obj, 2);
          break;
          GSChatView.access$0(this.this$0, (UserInfo)paramMessage.obj, 0);
          break;
          GSChatView.access$0(this.this$0, (UserInfo)paramMessage.obj, 1);
          break;
          GSChatView.access$1(this.this$0).stopLoadMore();
          if (GSChatView.access$2(this.this$0) != null)
            GSChatView.access$2(this.this$0).notifyData((List)paramMessage.obj);
          boolean bool3 = paramMessage.getData().getBoolean("LATEST");
          GenseeLog.d("GSChatView refresh NEW_LOADMORE bLatest = " + bool3);
          GSChatView.access$3(this.this$0, bool3);
          GSChatView.access$4(this.this$0, false);
          break;
          boolean bool2 = paramMessage.getData().getBoolean("LATEST");
          GenseeLog.d("GSChatView refresh NEW_REFRESH bLatest1 = " + bool2);
          GSChatView.access$3(this.this$0, bool2);
          if (GSChatView.access$2(this.this$0) != null)
            GSChatView.access$2(this.this$0).notifyData((List)paramMessage.obj);
          this.this$0.onLvReLoad();
          GSChatView.access$4(this.this$0, false);
          break;
        }
        while (paramMessage.obj == null);
        List localList = (List)paramMessage.obj;
        localUserInfo = GSChatView.access$5(this.this$0).getSelfInfo();
        if ((localUserInfo == null) || (!GSChatView.access$6(this.this$0).isSelected()))
          continue;
        localIterator = localList.iterator();
        if (localIterator.hasNext())
          break;
        if (GSChatView.access$2(this.this$0) == null)
          continue;
        GSChatView.access$2(this.this$0).notifyData(this.this$0.selfList);
      }
      localAbsChatMessage = (AbsChatMessage)localIterator.next();
      if (localAbsChatMessage.getSendUserId() != localUserInfo.getUserId())
        break;
      i = 1;
      label449: if ((!(localAbsChatMessage instanceof PrivateMessage)) || (((PrivateMessage)localAbsChatMessage).getReceiveUserId() != localUserInfo.getUserId()));
    case 10000:
    }
    for (int j = 1; ; j = 0)
    {
      if ((i == 0) && (j == 0))
        break label380;
      this.this$0.selfList.add(localAbsChatMessage);
      break label380;
      i = 0;
      break label449;
      boolean bool1 = paramMessage.getData().getBoolean("LATEST");
      GenseeLog.d("GSChatView refresh NEW_MSG bLatestNewMsg = " + bool1);
      if ((GSChatView.access$6(this.this$0).isSelected()) || (!bool1))
        break;
      if (GSChatView.access$2(this.this$0) != null)
        GSChatView.access$2(this.this$0).notifyData((List)paramMessage.obj);
      GSChatView.access$3(this.this$0, bool1);
      break;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSChatView.1
 * JD-Core Version:    0.6.0
 */