package com.gensee.common;

import com.gensee.heartbeat.GSHeartBeat;
import com.gensee.taskret.OnTaskRet;
import com.gensee.utils.GenseeLog;

public class PlayerEnv
{
  private static final String TAG = "PlayerEnv";
  private static int initCount;
  protected static boolean isInited = false;

  static
  {
    initCount = 0;
    try
    {
      System.loadLibrary("stlport_shared");
      System.loadLibrary("AVCDecoder");
      System.loadLibrary("ucbase");
      System.loadLibrary("speex");
      System.loadLibrary("ucamf");
      System.loadLibrary("ucflv");
      System.loadLibrary("ucnet");
      System.loadLibrary("ucrtp");
      System.loadLibrary("ucrtmpcli");
      System.loadLibrary("ucdflvreader");
      System.loadLibrary("H264Android");
      System.loadLibrary("unidecoder");
      System.loadLibrary("uctinyxml");
      System.loadLibrary("ucoffplayer");
      System.loadLibrary("gsolcomp-jni");
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      localRuntimeException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private static native void clearEnv();

  public static boolean init(boolean paramBoolean, int paramInt1, int paramInt2, OnTaskRet paramOnTaskRet)
  {
    startHeartBeat(paramBoolean);
    return GSHeartBeat.addTask(new PlayerEnv.1(paramInt1, paramInt2, paramOnTaskRet));
  }

  private static native void initEnv(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2);

  private static native void opHeartBeat();

  public static void release()
  {
    isInited = false;
    GSHeartBeat.addTask(new PlayerEnv.3());
  }

  public static native void setTcpProxy(IProxy paramIProxy);

  public static void startHeartBeat(boolean paramBoolean)
  {
    if (isInited)
      return;
    if (paramBoolean)
      GenseeLog.initLog();
    monitorenter;
    try
    {
      if (!isInited)
      {
        isInited = true;
        GenseeLog.w("initOfflineComp startHeartBeat " + isInited);
        GSHeartBeat.setVodHBeat(new PlayerEnv.2());
        GSHeartBeat.startHeartBeat(null);
      }
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static abstract interface IProxy
  {
    public abstract String getProxyIP(String paramString);

    public abstract int getProxyPort(int paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.common.PlayerEnv
 * JD-Core Version:    0.6.0
 */