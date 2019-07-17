package com.gensee.heartbeat;

import android.os.Process;
import java.util.TimerTask;

class GSHeartBeat$1 extends TimerTask
{
  private boolean isSetPriority = false;

  public void run()
  {
    if (!this.isSetPriority)
    {
      this.isSetPriority = true;
      Process.setThreadPriority(-19);
    }
    GSHeartBeat.access$0();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.heartbeat.GSHeartBeat.1
 * JD-Core Version:    0.6.0
 */