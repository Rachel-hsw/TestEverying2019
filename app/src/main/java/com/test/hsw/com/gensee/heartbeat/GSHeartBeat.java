package com.gensee.heartbeat;

import android.os.Handler;
import android.os.Looper;
import com.gensee.taskret.IGSTask;
import com.gensee.utils.GenseeLog;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class GSHeartBeat
{
  private static final int DELAY = 10;
  private static final String TAG = "GSHeartBeat";
  private static HeartBeat castHearbeat;
  private static boolean isCastNeed;
  public static boolean isInited;
  private static boolean isVodNeed;
  private static Object lock;
  private static Timer mTimer;
  private static HeartBeat mVodHeartbeat;
  private static Queue<IGSTask> tasks = new LinkedList();
  private static TimerTask timerTask;

  static
  {
    lock = new Object();
    isVodNeed = false;
    isCastNeed = false;
    isInited = false;
    timerTask = new GSHeartBeat.1();
  }

  public static boolean addTask(IGSTask paramIGSTask)
  {
    synchronized (lock)
    {
      boolean bool = tasks.add(paramIGSTask);
      lock.notifyAll();
      return bool;
    }
  }

  // ERROR //
  private static void doTasks()
  {
    // Byte code:
    //   0: getstatic 39	com/gensee/heartbeat/GSHeartBeat:lock	Ljava/lang/Object;
    //   3: astore_0
    //   4: aload_0
    //   5: monitorenter
    //   6: getstatic 36	com/gensee/heartbeat/GSHeartBeat:tasks	Ljava/util/Queue;
    //   9: invokeinterface 75 1 0
    //   14: istore_2
    //   15: aconst_null
    //   16: astore_3
    //   17: iload_2
    //   18: ifne +15 -> 33
    //   21: getstatic 36	com/gensee/heartbeat/GSHeartBeat:tasks	Ljava/util/Queue;
    //   24: invokeinterface 79 1 0
    //   29: checkcast 81	com/gensee/taskret/IGSTask
    //   32: astore_3
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_3
    //   36: ifnull +101 -> 137
    //   39: aload_3
    //   40: invokeinterface 85 1 0
    //   45: istore 8
    //   47: iload 8
    //   49: istore 4
    //   51: iload 4
    //   53: tableswitch	default:+31 -> 84, 1:+90->143, 2:+97->150, 3:+111->164, 4:+104->157
    //   85: nop
    //   86: dload_3
    //   87: ifeq +17 -> 104
    //   90: getstatic 87	com/gensee/heartbeat/GSHeartBeat:mVodHeartbeat	Lcom/gensee/heartbeat/GSHeartBeat$HeartBeat;
    //   93: ifnull +11 -> 104
    //   96: getstatic 87	com/gensee/heartbeat/GSHeartBeat:mVodHeartbeat	Lcom/gensee/heartbeat/GSHeartBeat$HeartBeat;
    //   99: invokeinterface 92 1 0
    //   104: getstatic 43	com/gensee/heartbeat/GSHeartBeat:isCastNeed	Z
    //   107: ifeq +17 -> 124
    //   110: getstatic 94	com/gensee/heartbeat/GSHeartBeat:castHearbeat	Lcom/gensee/heartbeat/GSHeartBeat$HeartBeat;
    //   113: ifnull +11 -> 124
    //   116: getstatic 94	com/gensee/heartbeat/GSHeartBeat:castHearbeat	Lcom/gensee/heartbeat/GSHeartBeat$HeartBeat;
    //   119: invokeinterface 92 1 0
    //   124: return
    //   125: astore_1
    //   126: aload_0
    //   127: monitorexit
    //   128: aload_1
    //   129: athrow
    //   130: astore 7
    //   132: aload 7
    //   134: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   137: iconst_0
    //   138: istore 4
    //   140: goto -89 -> 51
    //   143: iconst_1
    //   144: putstatic 41	com/gensee/heartbeat/GSHeartBeat:isVodNeed	Z
    //   147: goto -63 -> 84
    //   150: iconst_0
    //   151: putstatic 41	com/gensee/heartbeat/GSHeartBeat:isVodNeed	Z
    //   154: goto -70 -> 84
    //   157: iconst_0
    //   158: putstatic 43	com/gensee/heartbeat/GSHeartBeat:isCastNeed	Z
    //   161: goto -77 -> 84
    //   164: iconst_1
    //   165: putstatic 43	com/gensee/heartbeat/GSHeartBeat:isCastNeed	Z
    //   168: goto -84 -> 84
    //   171: astore 6
    //   173: aload 6
    //   175: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   178: goto -74 -> 104
    //   181: astore 5
    //   183: aload 5
    //   185: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   188: return
    //
    // Exception table:
    //   from	to	target	type
    //   6	15	125	finally
    //   21	33	125	finally
    //   33	35	125	finally
    //   126	128	125	finally
    //   39	47	130	java/lang/Exception
    //   96	104	171	java/lang/Exception
    //   116	124	181	java/lang/Exception
  }

  public static void setCastHBeat(HeartBeat paramHeartBeat)
  {
    castHearbeat = paramHeartBeat;
  }

  public static void setVodHBeat(HeartBeat paramHeartBeat)
  {
    mVodHeartbeat = paramHeartBeat;
  }

  private static void startBeat()
  {
    GenseeLog.d("GSHeartBeat", "startBeat");
    if (mTimer == null)
    {
      monitorenter;
      try
      {
        if (mTimer == null)
        {
          mTimer = new Timer("GSHeartBeat");
          mTimer.schedule(timerTask, 0L, 10L);
          GenseeLog.d("GSHeartBeat", "startBeat schedule t = " + mTimer.hashCode());
        }
        return;
      }
      finally
      {
        monitorexit;
      }
    }
  }

  public static void startHeartBeat(HeartBeat paramHeartBeat)
  {
    if (mTimer != null)
      return;
    new Handler(Looper.getMainLooper()).post(new GSHeartBeat.2());
  }

  public static void stopHeartBeat()
  {
    if (mTimer != null)
    {
      mTimer.cancel();
      mTimer = null;
    }
  }

  public static abstract interface HeartBeat
  {
    public abstract void heartBeat();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.heartbeat.GSHeartBeat
 * JD-Core Version:    0.6.0
 */