package com.baidu.location.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Handler;
import com.baidu.location.b.b;
import com.baidu.location.b.k;
import com.baidu.location.b.o;
import com.baidu.location.c.d;

public class i
  implements com.baidu.location.b.f, g
{
  private static i hx = null;
  final Handler hA = new Handler();
  private boolean hB = false;
  private boolean hC = false;
  private boolean hD = false;
  private a hE = null;
  private boolean hy = false;
  private boolean hz = true;

  public static i bW()
  {
    if (hx == null)
      hx = new i();
    return hx;
  }

  private void bZ()
  {
    NetworkInfo.State localState1 = NetworkInfo.State.UNKNOWN;
    try
    {
      NetworkInfo.State localState3 = ((ConnectivityManager)com.baidu.location.f.getServiceContext().getSystemService("connectivity")).getNetworkInfo(1).getState();
      localState2 = localState3;
      if (NetworkInfo.State.CONNECTED == localState2)
        if (this.hC)
          return;
    }
    catch (Exception localException)
    {
      while (true)
        NetworkInfo.State localState2 = localState1;
      this.hC = true;
      this.hA.postDelayed(new b(null), k.cy);
      this.hD = true;
      return;
    }
    this.hC = false;
  }

  public void bT()
  {
    this.hz = false;
  }

  public void bU()
  {
    if (!this.hy);
    do
    {
      return;
      this.hz = true;
    }
    while ((this.hD) || (!this.hz));
    this.hA.postDelayed(new b(null), k.cy);
    this.hD = true;
  }

  // ERROR //
  public void bV()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 114	com/baidu/location/f:isServing	Z
    //   5: istore_2
    //   6: iload_2
    //   7: ifne +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: getfield 39	com/baidu/location/e/i:hy	Z
    //   17: istore_3
    //   18: iload_3
    //   19: ifne -9 -> 10
    //   22: aload_0
    //   23: new 116	com/baidu/location/e/i$a
    //   26: dup
    //   27: aload_0
    //   28: aconst_null
    //   29: invokespecial 117	com/baidu/location/e/i$a:<init>	(Lcom/baidu/location/e/i;Lcom/baidu/location/e/i$1;)V
    //   32: putfield 29	com/baidu/location/e/i:hE	Lcom/baidu/location/e/i$a;
    //   35: new 119	android/content/IntentFilter
    //   38: dup
    //   39: invokespecial 120	android/content/IntentFilter:<init>	()V
    //   42: astore 5
    //   44: aload 5
    //   46: ldc 122
    //   48: invokevirtual 126	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   51: invokestatic 62	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   54: aload_0
    //   55: getfield 29	com/baidu/location/e/i:hE	Lcom/baidu/location/e/i$a;
    //   58: aload 5
    //   60: invokevirtual 130	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   63: pop
    //   64: aload_0
    //   65: iconst_1
    //   66: putfield 33	com/baidu/location/e/i:hB	Z
    //   69: aload_0
    //   70: invokespecial 106	com/baidu/location/e/i:bZ	()V
    //   73: aload_0
    //   74: iconst_1
    //   75: putfield 37	com/baidu/location/e/i:hz	Z
    //   78: aload_0
    //   79: iconst_1
    //   80: putfield 39	com/baidu/location/e/i:hy	Z
    //   83: goto -73 -> 10
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: astore 4
    //   93: goto -20 -> 73
    //
    // Exception table:
    //   from	to	target	type
    //   2	6	86	finally
    //   13	18	86	finally
    //   22	73	86	finally
    //   73	83	86	finally
    //   22	73	91	java/lang/Exception
  }

  public void bX()
  {
    if (this.hE == null)
      this.hE = new a(null);
    try
    {
      if (!this.hB)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        com.baidu.location.f.getServiceContext().registerReceiver(this.hE, localIntentFilter);
        bZ();
        this.hB = true;
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  // ERROR //
  public void bY()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/baidu/location/e/i:hy	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic 62	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   17: aload_0
    //   18: getfield 29	com/baidu/location/e/i:hE	Lcom/baidu/location/e/i$a;
    //   21: invokevirtual 136	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 37	com/baidu/location/e/i:hz	Z
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield 39	com/baidu/location/e/i:hy	Z
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 29	com/baidu/location/e/i:hE	Lcom/baidu/location/e/i$a;
    //   39: goto -28 -> 11
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: astore_3
    //   48: goto -24 -> 24
    //
    // Exception table:
    //   from	to	target	type
    //   2	7	42	finally
    //   14	24	42	finally
    //   24	39	42	finally
    //   14	24	47	java/lang/Exception
  }

  private class a extends BroadcastReceiver
  {
    private a()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramContext == null) || (i.this.hA == null))
        return;
      i.jdMethod_for(i.this);
    }
  }

  private class b
    implements b, Runnable
  {
    private b()
    {
    }

    public void run()
    {
      if (!i.jdMethod_if(i.this))
        return;
      if ((i.jdMethod_do(i.this)) && (e.bv().bt()) && (d.jdMethod_try().jdMethod_long()))
        new i.b.1(this).start();
      if ((i.jdMethod_do(i.this)) && (e.bv().bt()))
        o.aX().aV();
      if ((i.jdMethod_do(i.this)) && (i.jdMethod_if(i.this)))
      {
        i.this.hA.postDelayed(this, k.cy);
        i.jdMethod_if(i.this, true);
        return;
      }
      i.jdMethod_if(i.this, false);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.e.i
 * JD-Core Version:    0.6.0
 */