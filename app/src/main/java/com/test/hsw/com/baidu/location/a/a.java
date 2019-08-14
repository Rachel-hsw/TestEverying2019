package com.baidu.location.a;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.baidu.location.LLSInterface;
import com.baidu.location.c.b;
import com.baidu.location.e.e;
import com.baidu.location.e.h;
import com.baidu.location.e.i;
import com.baidu.location.e.m;
import com.baidu.location.e.n;
import com.baidu.location.e.o;
import com.baidu.location.h.g;
import com.baidu.location.h.j;
import com.baidu.location.h.k;
import com.baidu.location.h.l;

public class a extends Service
  implements LLSInterface, com.baidu.location.b.f
{
  static a l8 = null;
  private static long mc = 0L;
  private HandlerThread l7;
  private boolean l9 = false;
  Messenger ma = null;
  private Looper mb;

  public static long dN()
  {
    return mc;
  }

  public static Handler dO()
  {
    return l8;
  }

  private void dP()
  {
    l.a().db();
    i.bW().bY();
    com.baidu.location.c.d.jdMethod_try().h();
    com.baidu.location.e.f.bA().bG();
    com.baidu.location.h.d.a().cE();
    e.bv().by();
    com.baidu.location.h.c.a().cR();
    m.a9().ba();
    o.ch();
    com.baidu.location.e.c.bp().br();
    h.bI().bJ();
    Log.d("baidu_location_service", "baidu location service has stoped ...");
    if (!this.l9)
      Process.killProcess(Process.myPid());
  }

  private void dQ()
  {
    com.baidu.location.h.c.a().cN();
    l.a().c4();
    com.baidu.location.b.c.N();
    m.a9().bh();
    b.aZ().a0();
    e.bv().bx();
  }

  private void l(Message paramMessage)
  {
    com.baidu.location.e.c.bp().jdMethod_char(paramMessage);
  }

  private void m(Message paramMessage)
  {
    Log.d("baidu_location_service", "baidu location service register ...");
    com.baidu.location.e.c.bp().jdMethod_long(paramMessage);
    com.baidu.location.c.d.jdMethod_try();
    com.baidu.location.e.f.bA().bD();
    com.baidu.location.e.d.aR().aQ();
  }

  private void n(Message paramMessage)
  {
    com.baidu.location.e.c.bp().jdMethod_goto(paramMessage);
  }

  public double getVersion()
  {
    return 6.130000114440918D;
  }

  public IBinder onBind(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle != null)
    {
      com.baidu.location.b.c.bl = localBundle.getString("key");
      com.baidu.location.b.c.bk = localBundle.getString("sign");
      this.l9 = localBundle.getBoolean("kill_process");
    }
    return this.ma.getBinder();
  }

  public void onCreate(Context paramContext)
  {
    mc = System.currentTimeMillis();
    this.l7 = n.a();
    this.mb = this.l7.getLooper();
    l8 = new a(this.mb);
    this.ma = new Messenger(l8);
    l8.sendEmptyMessage(0);
    Log.d("baidu_location_service", "baidu location service start1 ..." + Process.myPid());
  }

  public void onDestroy()
  {
    l8.sendEmptyMessage(1);
    Log.d("baidu_location_service", "baidu location service stop ...");
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 1;
  }

  public boolean onUnBind(Intent paramIntent)
  {
    return false;
  }

  public class a extends Handler
  {
    public a(Looper arg2)
    {
      super();
    }

    public void handleMessage(Message paramMessage)
    {
      if (com.baidu.location.f.isServing == true)
        switch (paramMessage.what)
        {
        case 110:
        case 111:
        case 112:
        case 121:
        case 122:
        case 302:
        default:
        case 11:
        case 12:
        case 15:
        case 22:
        case 28:
        case 41:
        case 401:
        }
      while (true)
      {
        if (paramMessage.what == 1)
          a.jdMethod_if(a.this);
        if (paramMessage.what == 0)
          a.jdMethod_do(a.this);
        super.handleMessage(paramMessage);
        return;
        a.jdMethod_do(a.this, paramMessage);
        continue;
        a.jdMethod_for(a.this, paramMessage);
        continue;
        a.jdMethod_if(a.this, paramMessage);
        continue;
        m.a9().jdMethod_do(paramMessage);
        continue;
        m.a9().bb();
        continue;
        m.a9().a8();
        continue;
        try
        {
          paramMessage.getData();
        }
        catch (Exception localException)
        {
        }
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.a.a
 * JD-Core Version:    0.6.0
 */