package org.android.agoo.impl;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.message.b.af;
import com.umeng.message.b.ao;
import com.umeng.message.b.ap;
import com.umeng.message.b.aq;
import com.umeng.message.b.ar;
import com.umeng.message.b.ay;
import com.umeng.message.b.be;
import com.umeng.message.b.bh;
import com.umeng.message.b.bq;
import com.umeng.message.b.by;
import com.umeng.message.b.cb;
import com.umeng.message.b.ce;
import com.umeng.message.b.cp;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.agoo.a.b;
import org.android.agoo.c;
import org.android.agoo.service.IMessageService.Stub;
import org.android.agoo.service.SendMessage;
import org.android.agoo.service.SendMessage.Stub;

public class PushService
  implements Handler.Callback, be, c
{
  private static by B;
  private static volatile boolean C = false;
  private static final String a = "PushService";
  private static final int b = 45613913;
  private static final String c = "agoo_action_re_election";
  private static final int d = 0;
  private static final String e = "cockroach";
  private static final String f = "cockroach-PPreotect";
  private static final String g = "pack";
  private static final int h = 0;
  private static final int i = 1;
  private static final int j = 2;
  private static final int k = 3;
  private static final int l = 4;
  private static final int m = 5;
  private final AtomicBoolean A = new AtomicBoolean(false);
  private volatile b D = null;
  private final BroadcastReceiver E = new PushService.2(this);
  private final IMessageService.Stub F = new PushService.3(this);
  private Context n;
  private HandlerThread o = null;
  private Handler p = null;
  private boolean q = false;
  private PendingIntent r = null;
  private boolean s = false;
  private bh t;
  private long u;
  private AlarmManager v = null;
  private String w = null;
  private String x = null;
  private String y = null;
  private String z = null;

  private static final int a(int paramInt1, int paramInt2)
  {
    return 0x0 | (paramInt1 & 0xFF | (0xFFFF & paramInt2) << 16);
  }

  private static final void a(Context paramContext)
  {
    try
    {
      if ((org.android.a.y(paramContext)) && (paramContext != null))
      {
        paramContext.getPackageName();
        paramContext.getClass().getName();
        a(2, 60);
        String str = org.android.agoo.b.a.d(paramContext);
        ay.c("PushService", "registerNotKill--->[current-thread-name:" + Thread.currentThread().getName() + "][action:" + str + "]");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    try
    {
      String str1 = paramIntent.getAction();
      String str2 = org.android.agoo.b.a.c(this.n);
      ay.c("PushService", "action [" + str1 + "]");
      if (TextUtils.equals(str1, str2))
      {
        String str3 = paramIntent.getStringExtra("method");
        if ((!TextUtils.isEmpty(str3)) && (TextUtils.equals(str3, "stop")))
        {
          c();
          return;
        }
        if ((!TextUtils.isEmpty(str3)) && (TextUtils.equals(str3, "start")))
        {
          if (e())
          {
            b(null);
            return;
          }
          c();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private void a(String paramString)
  {
    while (true)
    {
      long l1;
      try
      {
        if (this.s)
          return;
        this.s = true;
        Intent localIntent = new Intent("agoo_action_re_election");
        localIntent.setPackage(this.n.getPackageName());
        localIntent.putExtra("eventId", paramString);
        int i1 = 1320 + new Random().nextInt(120);
        l1 = System.currentTimeMillis() + 1000L * (60L * i1);
        long l2 = af.q(this.n);
        if (l2 > 1800000L + System.currentTimeMillis())
        {
          l3 = l2;
          this.v = ((AlarmManager)this.n.getSystemService("alarm"));
          if (this.r == null)
            continue;
          this.r.cancel();
          this.v.cancel(this.r);
          this.r = PendingIntent.getBroadcast(this.n, 45613913, localIntent, 134217728);
          ay.c("PushService", "election next time[current-thread-name:" + Thread.currentThread().getName() + "][" + ce.a(l3) + "][timeout:" + l2 + "] ");
          this.v.set(1, l3, this.r);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        ay.e("PushService", "ReElection start", localThrowable);
        return;
      }
      long l3 = l1;
    }
  }

  private static final void b(Context paramContext)
  {
    try
    {
      if (org.android.a.y(paramContext))
      {
        B.b();
        ay.c("PushService", "unregisterNotKill--->[current-thread-name:" + Thread.currentThread().getName() + "]");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private void b(String paramString)
  {
    try
    {
      if (this.t != null)
        this.t.e();
      a(paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private void d()
  {
    try
    {
      this.u = System.currentTimeMillis();
      this.t = new bh(this.n, this);
      return;
    }
    catch (Throwable localThrowable)
    {
      ay.d("PushService", "initMessage", localThrowable);
    }
  }

  private boolean e()
  {
    try
    {
      if (this.n == null)
      {
        ay.c("PushService", "mContext == null");
        return false;
      }
      this.w = af.f(this.n);
      if (TextUtils.isEmpty(this.w))
      {
        onHandleError("ERROR_APPKEY_NULL");
        return false;
      }
      this.y = af.h(this.n);
      if (TextUtils.isEmpty(this.y))
      {
        onHandleError("ERROR_TTID_NULL");
        return false;
      }
      this.x = af.j(this.n);
      this.z = af.n(this.n);
      if (TextUtils.isEmpty(this.z))
      {
        onHandleError("ERROR_DEVICETOKEN_NULL");
        return false;
      }
      if (this.t == null)
        d();
      this.t.b(this.w);
      this.t.a(this.x);
      this.t.c(this.y);
      this.t.d(this.z);
      return true;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  private boolean f()
  {
    try
    {
      if (!af.m(this.n))
        return true;
      String str = ar.a(this.n);
      if (TextUtils.isEmpty(str))
      {
        ay.c("PushService", "[currentSudoPack==null]");
        return true;
      }
      if (!TextUtils.equals(this.n.getPackageName(), str))
      {
        ay.c("PushService", "[currentSudoPack(" + str + ")!=appPackage(" + this.n.getPackageName() + ")]");
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  private final void g()
  {
    try
    {
      if (this.n != null)
      {
        long l1 = 60000L + System.currentTimeMillis();
        String str = org.android.agoo.b.a.c(this.n);
        if (TextUtils.isEmpty(str))
        {
          ay.a("PushService", "action==null");
          return;
        }
        ay.a("PushService", "handleDestroyService [" + ce.a(l1) + "][" + str + ":restart]");
        AlarmManager localAlarmManager = (AlarmManager)this.n.getSystemService("alarm");
        Intent localIntent = new Intent();
        localIntent.setAction(str);
        localIntent.setPackage(this.n.getPackageName());
        localIntent.putExtra("method", "start");
        localIntent.putExtra("eventId", "handleDestroyService");
        localIntent.addFlags(32);
        localIntent.addFlags(268435456);
        localAlarmManager.set(1, l1, PendingIntent.getService(this.n, 0, localIntent, 134217728));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ay.e("PushService", "handleDestroyService", localThrowable);
    }
  }

  protected void a()
  {
    try
    {
      aq.d(this.n);
      String str = ar.a(this.n);
      new bq(this.n, "androidSystem").a(org.android.a.B(this.n));
      aq.c(this.n, str, "androidSystem");
      if (f())
      {
        onHandleError("ERROR_NEED_ELECTION");
        c();
        return;
      }
      if (!e())
      {
        c();
        return;
      }
      b("androidSystemSuccess");
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  protected void b()
  {
    try
    {
      String str = ar.a(this.n);
      aq.d(this.n);
      bq localbq = new bq(this.n, "hasComeFromCock");
      LinkedHashMap localLinkedHashMap = org.android.a.B(this.n);
      localLinkedHashMap.put("currentSudoPack", str);
      localbq.a(localLinkedHashMap);
      aq.c(this.n, str, "hasComeFromCock");
      if (f())
      {
        onHandleError("ERROR_NEED_ELECTION");
        c();
        return;
      }
      if (!e())
      {
        c();
        return;
      }
      b("hasComeFromCock");
      if (ao.a(this.n))
        new bq(this.n, "hasComeFromCockSuccess").a(localLinkedHashMap);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public IBinder bind(Intent paramIntent)
  {
    String str1 = paramIntent.getAction();
    Set localSet = paramIntent.getCategories();
    StringBuilder localStringBuilder = new StringBuilder().append("onBind:[").append(str1).append("],intent categries[");
    if ((localSet == null) || (localSet.isEmpty()));
    for (String str2 = null; ; str2 = localSet.toString())
    {
      ay.c("PushService", str2 + "]");
      boolean bool1 = TextUtils.isEmpty(str1);
      IMessageService.Stub localStub = null;
      if (!bool1)
      {
        boolean bool2 = TextUtils.equals(str1, "org.agoo.android.intent.action.PING_V4");
        localStub = null;
        if (bool2)
        {
          localStub = null;
          if (localSet != null)
          {
            boolean bool3 = localSet.isEmpty();
            localStub = null;
            if (!bool3)
            {
              boolean bool4 = localSet.contains(org.android.a.m(this.n));
              localStub = null;
              if (bool4)
                localStub = this.F;
            }
          }
        }
      }
      return localStub;
    }
  }

  protected final void c()
  {
    try
    {
      this.q = false;
      if (this.p != null)
        this.p.sendEmptyMessage(1);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void create(Context paramContext, b paramb)
  {
    try
    {
      Log.w("PushService", ">>> agoo system is creating >>>");
      cb.a(paramContext, "agoo.pid");
      B = by.a(paramContext, 600, false);
      this.n = paramContext;
      ay.a(this.n);
      aq.a(this.n);
      this.q = true;
      this.o = new HandlerThread("se-service");
      this.o.start();
      this.p = new Handler(this.o.getLooper(), this);
      String str = paramContext.getPackageName();
      Log.w("PushService", "create currentPack=" + str);
      Log.w("PushService", "getCurrentSudo(context)" + ar.a(paramContext));
      boolean bool = str.equals(ar.a(paramContext));
      Log.w("PushService", str + ",  " + bool);
      if (bool)
        B.a();
      this.D = paramb;
      this.v = ((AlarmManager)paramContext.getSystemService("alarm"));
      if (!this.A.get())
      {
        this.A.set(true);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("agoo_action_re_election");
        this.n.registerReceiver(this.E, localIntentFilter);
      }
      d();
      return;
    }
    catch (Throwable localThrowable)
    {
      ay.d("PushService", "create", localThrowable);
    }
  }

  public void destroy(Context paramContext)
  {
    try
    {
      ay.c("PushService", "PushService destroying");
      if (this.A.get())
      {
        this.A.set(false);
        if (this.t != null)
          this.t.i();
        cp.a(new PushService.1(this));
        this.n.unregisterReceiver(this.E);
        if (this.r != null)
          this.r.cancel();
        if (this.v != null)
          this.v.cancel(this.r);
      }
      ay.c("PushService", "PushService destroyed");
      ay.c("PushService", "PushService hasNeedNotKill[handleDestroyService]+hasNeedNotKill=" + this.q);
      if (this.q)
      {
        ay.c("PushService", "PushService hasNeedNotKill[handleDestroyService]");
        g();
      }
      while (true)
      {
        this.r = null;
        this.v = null;
        return;
        ap.b(paramContext);
      }
    }
    catch (Throwable localThrowable)
    {
      ay.d("PushService", "destroy", localThrowable);
      ay.c("PushService", "PushService hasNeedNotKill[handleDestroyService]+hasNeedNotKill=" + this.q);
      if (this.q)
      {
        ay.c("PushService", "PushService hasNeedNotKill[handleDestroyService]");
        g();
      }
      while (true)
      {
        this.r = null;
        this.v = null;
        return;
        ap.b(paramContext);
      }
    }
    finally
    {
      ay.c("PushService", "PushService hasNeedNotKill[handleDestroyService]+hasNeedNotKill=" + this.q);
      if (!this.q)
        break label302;
    }
    ay.c("PushService", "PushService hasNeedNotKill[handleDestroyService]");
    g();
    while (true)
    {
      this.r = null;
      this.v = null;
      throw localObject;
      label302: ap.b(paramContext);
    }
  }

  public boolean handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 0:
        a(this.n);
        break;
      case 1:
        b(this.n);
        this.D.stop();
        break;
      case 2:
        a(this.n);
        a((Intent)paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
        break;
      case 3:
        by.b(this.n);
        a(this.n);
        b();
        break;
      case 4:
        a(this.n);
        a();
        break;
      case 5:
        onHandleError("ERROR_NEED_ELECTION");
        this.s = false;
      }
      label149: return true;
    }
    catch (Throwable localThrowable)
    {
      break label149;
    }
  }

  public boolean hasComeFromCock(Intent paramIntent)
  {
    try
    {
      if (!this.n.getPackageName().equals(ar.a(this.n)))
        c();
      if (paramIntent == null)
      {
        ay.c("PushService", "hasComeFromCock[intent==null]");
        return false;
      }
      String str1 = paramIntent.getAction();
      String str2 = org.android.agoo.b.a.d(this.n);
      if ((TextUtils.isEmpty(str1)) || (!TextUtils.equals(str1, str2)))
      {
        ay.c("PushService", "hasComeFromCock[action==null]or[action!=" + str2 + "]");
        return false;
      }
      String str3 = paramIntent.getStringExtra("cockroach");
      if ((TextUtils.isEmpty(str3)) || (!TextUtils.equals(str3, "cockroach-PPreotect")))
      {
        ay.c("PushService", "hasComeFromCock[cockroach==null]or[cockroach!=" + str3 + "]");
        return false;
      }
      String str4 = paramIntent.getStringExtra("pack");
      if ((TextUtils.isEmpty(str4)) || (!TextUtils.equals(str4, this.n.getPackageName())))
      {
        ay.c("PushService", "hasComeFromCock[pack==null] or [" + str4 + "!=" + this.n.getPackageName() + "]");
        return false;
      }
      ay.c("PushService", "hasComeFromCock[" + str1 + "] [" + str4 + "==" + this.n.getPackageName() + "]");
    }
    catch (Throwable localThrowable)
    {
    }
    return true;
  }

  public void onHandleCommand(String paramString)
  {
    try
    {
      Intent localIntent = org.android.agoo.b.a.a(this.n, paramString);
      localIntent.setPackage(this.n.getPackageName());
      this.n.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      ay.d("PushService", "handleError", localThrowable);
    }
  }

  public void onHandleError(String paramString)
  {
    try
    {
      Intent localIntent = org.android.agoo.b.a.a(this.n, "error");
      localIntent.setPackage(this.n.getPackageName());
      localIntent.putExtra("error", paramString);
      this.n.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      ay.d("PushService", "handleError", localThrowable);
    }
  }

  public void onHandleMessage(String paramString, Bundle paramBundle)
  {
    try
    {
      ay.c("PushService", "onHandleMessage current tid:" + Thread.currentThread().getId());
      this.p.post(new b(paramString, paramBundle, this.t));
      return;
    }
    catch (Throwable localThrowable)
    {
      ay.e("PushService", "handleMessage error >>", localThrowable);
    }
  }

  public int startCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null);
    try
    {
      this.p.sendEmptyMessage(4);
      return 1;
      Message localMessage = Message.obtain();
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      localMessage.obj = paramIntent;
      if (hasComeFromCock(paramIntent))
      {
        localMessage.what = 3;
        this.p.sendMessage(localMessage);
        return 1;
      }
      localMessage.what = 2;
      this.p.sendMessage(localMessage);
      if (ao.a(this.n))
      {
        String str = paramIntent.getStringExtra("eventId");
        Log.d("PushService", "pushService startCommand,eventId=" + str + "_Success");
        if (!TextUtils.isEmpty(str))
          new bq(this.n, str + "_Success").a(org.android.a.B(this.n));
      }
      return 1;
    }
    catch (Throwable localThrowable)
    {
    }
    return 1;
  }

  public boolean unbind(Intent paramIntent)
  {
    return false;
  }

  class a
    implements ServiceConnection
  {
    private Intent b;
    private bh c;
    private String d;
    private SendMessage e;
    private ServiceConnection f;

    public a(String paramIntent, Intent parambh, bh arg4)
    {
      this.d = paramIntent;
      this.b = parambh;
      Object localObject;
      this.c = localObject;
      this.f = this;
    }

    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      ay.c("PushService", "MessageConnection conneted:" + paramComponentName);
      this.e = SendMessage.Stub.asInterface(paramIBinder);
      ay.c("PushService", "onConnected current tid:" + Thread.currentThread().getId());
      ay.c("PushService", "MessageConnection sent:" + this.b);
      if (this.e != null)
        PushService.c(PushService.this).post(new PushService.a.1(this));
    }

    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      ay.c("PushService", "MessageConnection disConnected");
    }
  }

  class b
    implements Runnable
  {
    private String b;
    private Bundle c;
    private bh d;

    public b(String paramBundle, Bundle parambh, bh arg4)
    {
      this.b = paramBundle;
      this.c = parambh;
      Object localObject;
      this.d = localObject;
    }

    public void run()
    {
      ay.c("PushService", "running tid:" + Thread.currentThread().getId());
      Intent localIntent1 = new Intent();
      localIntent1.setAction("org.agoo.android.intent.action.RECEIVE");
      localIntent1.setPackage(this.b);
      localIntent1.putExtras(this.c);
      localIntent1.putExtra("type", "common-push");
      localIntent1.putExtra("message_source", "apoll");
      localIntent1.addFlags(32);
      ay.c("PushService", "cast intent:" + this.c);
      PushService.a(PushService.this).sendBroadcast(localIntent1);
      Intent localIntent2 = new Intent("org.android.agoo.client.MessageReceiverService");
      localIntent2.setPackage(this.b);
      ay.c("PushService", "this message pack:" + this.b);
      ay.c("PushService", "start to service...");
      try
      {
        PushService.a locala = new PushService.a(PushService.this, this.c.getString("i"), localIntent1, this.d);
        boolean bool = PushService.a(PushService.this).bindService(localIntent2, locala, 17);
        ay.c("PushService", "start service ret:" + bool);
        if (!bool)
        {
          bh localbh = this.d;
          String str = this.c.getString("id");
          localbh.a(str, null, "14");
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        ay.c("PushService", "bindService error...e=" + localThrowable);
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.impl.PushService
 * JD-Core Version:    0.6.0
 */