package org.android.spdy;

import android.util.Log;

public class NetTimeGaurd
{
  public static final int CREATE = 0;
  public static final int ERROR = 2;
  public static final int PING = 1;
  public static final int STREAM = 3;
  private static final long calltime = 10L;
  private static final long total = 50L;
  private static long[] totaltime = new long[4];

  public static long begin()
  {
    long l = 0L;
    if (SpdyAgent.enableTimeGaurd)
      l = System.currentTimeMillis();
    return l;
  }

  public static void end(String paramString, int paramInt, long paramLong)
  {
    if (SpdyAgent.enableTimeGaurd)
    {
      long l = System.currentTimeMillis() - paramLong;
      totaltime[paramInt] = (l + totaltime[paramInt]);
      Log.i("NetTimeGaurd", "NetTimeGaurd[end]" + paramString + " time=" + l + " total=" + totaltime[paramInt]);
      if (l > 10L)
        throw new SpdyErrorException("CallBack:" + paramString + " timeconsuming:" + l + "  mustlessthan:" + 10L, -1);
    }
  }

  public static void finish(int paramInt)
  {
    if (SpdyAgent.enableTimeGaurd)
    {
      Log.i("NetTimeGaurd", "NetTimeGaurd[finish]:time=" + totaltime[paramInt]);
      if (totaltime[paramInt] > 50L)
        throw new SpdyErrorException("CallBack totaltimeconsuming:" + totaltime[paramInt] + "  mustlessthan:" + 50L, -1);
    }
  }

  public static void start(int paramInt)
  {
    if (SpdyAgent.enableTimeGaurd)
      totaltime[paramInt] = 0L;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.spdy.NetTimeGaurd
 * JD-Core Version:    0.6.0
 */