package com.umeng.message;

import com.umeng.b.a.a;
import com.umeng.message.b.dl;
import com.umeng.message.local.UmengLocalNotificationManager;
import com.umeng.message.local.UmengLocalNotificationService;
import java.util.ArrayList;
import java.util.Iterator;

class UmengMessageBootReceiver$1
  implements Runnable
{
  public void run()
  {
    while (true)
    {
      Iterator localIterator2;
      try
      {
        Iterator localIterator1 = MsgLogStore.getInstance(UmengMessageBootReceiver.a(this.a)).getMsgLogIdTypes().iterator();
        if (localIterator1.hasNext())
          continue;
        localIterator2 = MsgLogStore.getInstance(UmengMessageBootReceiver.a(this.a)).getMsgLogIdTypesForAgoo().iterator();
        if (!localIterator2.hasNext())
        {
          if (dl.c(UmengMessageBootReceiver.a(this.a), UmengLocalNotificationService.class.getName()))
            break;
          UmengLocalNotificationManager.getInstance(UmengMessageBootReceiver.a(this.a)).resetLocalNotifications();
          return;
          MsgLogStore.MsgLogIdType localMsgLogIdType = (MsgLogStore.MsgLogIdType)localIterator1.next();
          if ((MsgLogStore.getInstance(UmengMessageBootReceiver.a(this.a)).getMsgLog(localMsgLogIdType.msgId) != null) || (!localMsgLogIdType.msgType.equals("notification")))
            continue;
          MsgLogStore.getInstance(UmengMessageBootReceiver.a(this.a)).addLog(localMsgLogIdType.msgId, 2, System.currentTimeMillis());
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        a.c(UmengMessageBootReceiver.a(), localException.toString());
        return;
      }
      MsgLogStore.MsgLogIdTypeForAgoo localMsgLogIdTypeForAgoo = (MsgLogStore.MsgLogIdTypeForAgoo)localIterator2.next();
      if ((MsgLogStore.getInstance(UmengMessageBootReceiver.a(this.a)).getMsgLogForAgoo(localMsgLogIdTypeForAgoo.msgId) != null) || (!localMsgLogIdTypeForAgoo.msgStatus.equals("notification")))
        continue;
      MsgLogStore.getInstance(UmengMessageBootReceiver.a(this.a)).addLogForAgoo(localMsgLogIdTypeForAgoo.msgId, localMsgLogIdTypeForAgoo.taskId, "9", System.currentTimeMillis());
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.UmengMessageBootReceiver.1
 * JD-Core Version:    0.6.0
 */