package com.gensee.common;

import com.gensee.heartbeat.GSWork;

public class PlayerWork extends GSWork
{
  protected static boolean isEnvInited()
  {
    return PlayerEnv.isInited;
  }

  protected static void startHeartbeat(boolean paramBoolean)
  {
    PlayerEnv.startHeartBeat(paramBoolean);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.common.PlayerWork
 * JD-Core Version:    0.6.0
 */