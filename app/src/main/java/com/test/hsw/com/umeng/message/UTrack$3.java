package com.umeng.message;

import com.umeng.b.a.a;
import java.util.ArrayList;

class UTrack$3
  implements Runnable
{
  public void run()
  {
    try
    {
      ArrayList localArrayList = MsgLogStore.getInstance(UTrack.a(this.a)).getMsgLogs();
      for (int i = 0; ; i++)
      {
        int j = localArrayList.size();
        if (i >= j)
          return;
        MsgLogStore.MsgLog localMsgLog = (MsgLogStore.MsgLog)localArrayList.get(i);
        UTrack.a(this.a, localMsgLog.msgId, localMsgLog.actionType, localMsgLog.time);
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
      a.c(UTrack.a(), "sendCachedMsgLog finished, clear cacheLogSending flag");
      UTrack.a(false);
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.UTrack.3
 * JD-Core Version:    0.6.0
 */