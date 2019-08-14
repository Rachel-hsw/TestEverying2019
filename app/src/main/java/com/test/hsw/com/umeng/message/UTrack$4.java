package com.umeng.message;

import com.umeng.b.a.a;
import java.util.ArrayList;

class UTrack$4
  implements Runnable
{
  public void run()
  {
    try
    {
      ArrayList localArrayList = MsgLogStore.getInstance(UTrack.a(this.a)).getMsgLogsForAgoo();
      for (int i = 0; ; i++)
      {
        int j = localArrayList.size();
        if (i >= j)
          return;
        MsgLogStore.MsgLogForAgoo localMsgLogForAgoo = (MsgLogStore.MsgLogForAgoo)localArrayList.get(i);
        this.a.sendMsgLogForAgoo(localMsgLogForAgoo.msgId, localMsgLogForAgoo.taskId, localMsgLogForAgoo.msgStatus, localMsgLogForAgoo.time);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      a.c(UTrack.a(), localThrowable.toString());
      return;
    }
    finally
    {
      UTrack.b(false);
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.UTrack.4
 * JD-Core Version:    0.6.0
 */