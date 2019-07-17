package com.xiaomi.push.service;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.d.c.f.b;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class XMPushService extends Service
  implements com.xiaomi.d.d
{
  public static int a;
  private com.xiaomi.d.b b;
  private e c;
  private long d = 0L;
  private com.xiaomi.d.l e;
  private com.xiaomi.d.a f;
  private s g;
  private PacketSync h = null;
  private com.xiaomi.push.service.a.a i = null;
  private u j = null;
  private com.xiaomi.d.f k = new i(this);

  static
  {
    com.xiaomi.network.f.a("app.chat.xiaomi.net", "42.62.94.2");
    com.xiaomi.network.f.a("app.chat.xiaomi.net", "app01.nodes.gslb.mi-idc.com");
    com.xiaomi.network.f.a("app.chat.xiaomi.net", "120.134.33.29");
    com.xiaomi.network.f.a("app.chat.xiaomi.net", "app02.nodes.gslb.mi-idc.com");
    com.xiaomi.d.l.a = true;
    a = 1;
  }

  private com.xiaomi.d.c.c a(com.xiaomi.d.c.c paramc, String paramString)
  {
    byte[] arrayOfByte = d.a(paramString, paramc.k());
    com.xiaomi.d.c.c localc = new com.xiaomi.d.c.c();
    localc.n(paramc.n());
    localc.m(paramc.m());
    localc.k(paramc.k());
    localc.l(paramc.l());
    localc.b(true);
    String str = d.a(arrayOfByte, com.xiaomi.d.e.g.c(paramc.a()));
    com.xiaomi.d.c.a locala = new com.xiaomi.d.c.a("s", null, (String[])null, (String[])null);
    locala.b(str);
    localc.a(locala);
    return localc;
  }

  private com.xiaomi.d.c.d a(com.xiaomi.d.c.d paramd, String paramString1, String paramString2, boolean paramBoolean)
  {
    an localan = an.a();
    List localList = localan.b(paramString1);
    if (localList.isEmpty())
    {
      com.xiaomi.a.a.c.c.a("open channel should be called first before sending a packet, pkg=" + paramString1);
      paramd = null;
    }
    an.b localb;
    do
    {
      return paramd;
      paramd.o(paramString1);
      String str = paramd.l();
      if (TextUtils.isEmpty(str))
      {
        str = (String)localList.get(0);
        paramd.l(str);
      }
      localb = localan.b(str, paramd.n());
      if (!e())
      {
        com.xiaomi.a.a.c.c.a("drop a packet as the channel is not connected, chid=" + str);
        break;
      }
      if ((localb == null) || (localb.m != an.c.c))
      {
        com.xiaomi.a.a.c.c.a("drop a packet as the channel is not opened, chid=" + str);
        break;
      }
      if (TextUtils.equals(paramString2, localb.j))
        continue;
      com.xiaomi.a.a.c.c.a("invalid session. " + paramString2);
      break;
    }
    while ((!(paramd instanceof com.xiaomi.d.c.c)) || (!paramBoolean));
    return a((com.xiaomi.d.c.c)paramd, localb.i);
  }

  private String a(String paramString)
  {
    return "<iq to='" + paramString + "' id='0' chid='0' type='get'><ping xmlns='urn:xmpp:ping'>%1$s%2$s</ping></iq>";
  }

  private void a(String paramString, int paramInt)
  {
    Collection localCollection = an.a().c(paramString);
    if (localCollection != null)
    {
      Iterator localIterator = localCollection.iterator();
      while (localIterator.hasNext())
      {
        an.b localb = (an.b)localIterator.next();
        if (localb == null)
          continue;
        a(new l(localb, paramInt, null, null));
      }
    }
    an.a().a(paramString);
  }

  private boolean a(String paramString, Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra(ap.p);
    an.b localb = an.a().b(paramString, str1);
    int m = 0;
    if (localb != null)
    {
      m = 0;
      if (paramString != null)
      {
        String str2 = paramIntent.getStringExtra(ap.B);
        String str3 = paramIntent.getStringExtra(ap.u);
        boolean bool1 = TextUtils.isEmpty(localb.j);
        m = 0;
        if (!bool1)
        {
          boolean bool2 = TextUtils.equals(str2, localb.j);
          m = 0;
          if (!bool2)
          {
            com.xiaomi.a.a.c.c.a("session changed. old session=" + localb.j + ", new session=" + str2);
            m = 1;
          }
        }
        if (!str3.equals(localb.i))
        {
          com.xiaomi.a.a.c.c.a("security changed. ");
          m = 1;
        }
      }
    }
    return m;
  }

  private an.b b(String paramString, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra(ap.p);
    an.b localb = an.a().b(paramString, str);
    if (localb == null)
      localb = new an.b(this);
    localb.h = paramIntent.getStringExtra(ap.q);
    localb.b = paramIntent.getStringExtra(ap.p);
    localb.c = paramIntent.getStringExtra(ap.s);
    localb.a = paramIntent.getStringExtra(ap.y);
    localb.f = paramIntent.getStringExtra(ap.w);
    localb.g = paramIntent.getStringExtra(ap.x);
    localb.e = paramIntent.getBooleanExtra(ap.v, false);
    localb.i = paramIntent.getStringExtra(ap.u);
    localb.j = paramIntent.getStringExtra(ap.B);
    localb.d = paramIntent.getStringExtra(ap.t);
    localb.k = this.g;
    localb.l = getApplicationContext();
    an.a().a(localb);
    return localb;
  }

  private void i()
  {
    if (y.a(getApplicationContext()) != null)
    {
      an.b localb = y.a(getApplicationContext()).a(this);
      a(localb);
      an.a().a(localb);
      if (com.xiaomi.a.a.e.d.d(getApplicationContext()))
        a(true);
    }
  }

  private void j()
  {
    if (a())
    {
      if (!this.i.b())
        this.i.a(true);
      return;
    }
    this.i.a();
  }

  private void k()
  {
    if ((this.f != null) && (this.f.g()))
    {
      com.xiaomi.a.a.c.c.d("try to connect while connecting.");
      return;
    }
    if ((this.f != null) && (this.f.h()))
    {
      com.xiaomi.a.a.c.c.d("try to connect while is connected.");
      return;
    }
    this.b.b(com.xiaomi.a.a.e.d.f(this));
    l();
    if (this.f == null)
    {
      an.a().a(this);
      sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
      return;
    }
    sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
  }

  private void l()
  {
    try
    {
      this.e.a(this.k, new r(this));
      this.e.s();
      this.f = this.e;
      return;
    }
    catch (com.xiaomi.d.p localp)
    {
      com.xiaomi.a.a.c.c.a("fail to create xmpp connection", localp);
      this.e.a(new com.xiaomi.d.c.f(f.b.b), 3, localp);
    }
  }

  public com.xiaomi.d.c.c a(com.xiaomi.f.a.h paramh)
  {
    try
    {
      com.xiaomi.d.c.c localc = new com.xiaomi.d.c.c();
      localc.l("5");
      localc.m("xiaomi.com");
      localc.n(y.a(this).a);
      localc.b(true);
      localc.f("push");
      localc.o(paramh.f);
      String str1 = y.a(this).a;
      paramh.g.b = str1.substring(0, str1.indexOf("@"));
      paramh.g.d = str1.substring(1 + str1.indexOf("/"));
      byte[] arrayOfByte = com.xiaomi.f.a.u.a(paramh);
      String str2 = String.valueOf(com.xiaomi.a.a.g.a.a(d.a(d.a(y.a(this).c, localc.k()), arrayOfByte)));
      com.xiaomi.d.c.a locala = new com.xiaomi.d.c.a("s", null, (String[])null, (String[])null);
      locala.b(str2);
      localc.a(locala);
      com.xiaomi.a.a.c.c.a("try send mi push message. packagename:" + paramh.f + " action:" + paramh.a);
      return localc;
    }
    catch (NullPointerException localNullPointerException)
    {
      com.xiaomi.a.a.c.c.a(localNullPointerException);
    }
    return null;
  }

  public com.xiaomi.d.c.c a(byte[] paramArrayOfByte)
  {
    com.xiaomi.f.a.h localh = new com.xiaomi.f.a.h();
    try
    {
      com.xiaomi.f.a.u.a(localh, paramArrayOfByte);
      com.xiaomi.d.c.c localc = a(localh);
      return localc;
    }
    catch (org.a.c.f localf)
    {
      com.xiaomi.a.a.c.c.a(localf);
    }
    return null;
  }

  public com.xiaomi.d.l a(com.xiaomi.d.b paramb)
  {
    return new com.xiaomi.d.l(this, paramb);
  }

  public com.xiaomi.f.a.h a(String paramString1, String paramString2)
  {
    com.xiaomi.f.a.i locali = new com.xiaomi.f.a.i();
    locali.b(paramString2);
    locali.c("package uninstalled");
    locali.a(com.xiaomi.d.c.d.j());
    locali.a(false);
    return a(paramString1, paramString2, locali, com.xiaomi.f.a.a.i);
  }

  public <T extends org.a.c.b<T, ?>> com.xiaomi.f.a.h a(String paramString1, String paramString2, T paramT, com.xiaomi.f.a.a parama)
  {
    byte[] arrayOfByte = com.xiaomi.f.a.u.a(paramT);
    com.xiaomi.f.a.h localh = new com.xiaomi.f.a.h();
    com.xiaomi.f.a.d locald = new com.xiaomi.f.a.d();
    locald.a = 5L;
    locald.b = "fakeid";
    localh.a(locald);
    localh.a(ByteBuffer.wrap(arrayOfByte));
    localh.a(parama);
    localh.c(true);
    localh.b(paramString1);
    localh.a(false);
    localh.a(paramString2);
    return localh;
  }

  public void a(int paramInt)
  {
    this.j.a(paramInt);
  }

  public void a(int paramInt, Exception paramException)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("disconnect ").append(hashCode()).append(", ");
    if (this.f == null);
    for (Object localObject = null; ; localObject = Integer.valueOf(this.f.hashCode()))
    {
      com.xiaomi.a.a.c.c.a(localObject);
      if (this.f != null)
      {
        this.f.a(new com.xiaomi.d.c.f(f.b.b), paramInt, paramException);
        this.f = null;
      }
      a(7);
      a(4);
      an.a().a(this, paramInt);
      return;
    }
  }

  public void a(com.xiaomi.d.a parama)
  {
    this.c.a();
    Iterator localIterator = an.a().b().iterator();
    while (localIterator.hasNext())
      a(new a((an.b)localIterator.next()));
  }

  public void a(com.xiaomi.d.a parama, int paramInt, Exception paramException)
  {
    a(false);
  }

  public void a(com.xiaomi.d.a parama, Exception paramException)
  {
    a(false);
  }

  public void a(com.xiaomi.d.c.d paramd)
  {
    if (this.f != null)
    {
      this.f.a(paramd);
      return;
    }
    throw new com.xiaomi.d.p("try send msg while connection is null.");
  }

  public void a(e parame)
  {
    a(parame, 0L);
  }

  public void a(e parame, long paramLong)
  {
    this.j.a(parame, paramLong);
  }

  public void a(an.b paramb)
  {
    paramb.a(new p(this));
  }

  public void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    an.b localb = an.a().b(paramString1, paramString2);
    if (localb != null)
      a(new l(localb, paramInt, paramString4, paramString3));
    an.a().a(paramString1, paramString2);
  }

  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.f != null)
    {
      com.xiaomi.d.c.c localc = a(paramArrayOfByte);
      if (localc != null)
      {
        this.f.a(localc);
        return;
      }
      ab.a(this, paramString, paramArrayOfByte, 70000003, "not a valid message");
      return;
    }
    throw new com.xiaomi.d.p("try send msg while connection is null.");
  }

  public void a(boolean paramBoolean)
  {
    this.c.a(paramBoolean);
  }

  public void a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null)
    {
      ab.a(this, paramString, paramArrayOfByte, 70000003, "null payload");
      com.xiaomi.a.a.c.c.a("register request without payload");
      return;
    }
    com.xiaomi.f.a.h localh = new com.xiaomi.f.a.h();
    try
    {
      com.xiaomi.f.a.u.a(localh, paramArrayOfByte);
      if (localh.a == com.xiaomi.f.a.a.a)
      {
        com.xiaomi.f.a.j localj = new com.xiaomi.f.a.j();
        try
        {
          com.xiaomi.f.a.u.a(localj, localh.f());
          ab.a(localh.j(), paramArrayOfByte);
          a(new aa(this, localh.j(), localj.d(), localj.h(), paramArrayOfByte));
          return;
        }
        catch (org.a.c.f localf2)
        {
          com.xiaomi.a.a.c.c.a(localf2);
          ab.a(this, paramString, paramArrayOfByte, 70000003, " data action error.");
          return;
        }
      }
    }
    catch (org.a.c.f localf1)
    {
      com.xiaomi.a.a.c.c.a(localf1);
      ab.a(this, paramString, paramArrayOfByte, 70000003, " data container error.");
      return;
    }
    ab.a(this, paramString, paramArrayOfByte, 70000003, " registration action required.");
    com.xiaomi.a.a.c.c.a("register request with invalid payload");
  }

  public void a(com.xiaomi.d.c.d[] paramArrayOfd)
  {
    if (this.f != null)
    {
      this.f.a(paramArrayOfd);
      return;
    }
    throw new com.xiaomi.d.p("try send msg while connection is null.");
  }

  public boolean a()
  {
    return (com.xiaomi.a.a.e.d.d(this)) && (an.a().c() > 0) && (!b());
  }

  public void b(com.xiaomi.d.a parama)
  {
    com.xiaomi.a.a.c.c.c("begin to connect...");
  }

  public void b(com.xiaomi.f.a.h paramh)
  {
    if (this.f != null)
    {
      com.xiaomi.d.c.c localc = a(paramh);
      if (localc != null)
        this.f.a(localc);
      return;
    }
    throw new com.xiaomi.d.p("try send msg while connection is null.");
  }

  public void b(e parame)
  {
    this.j.a(parame.d, parame);
  }

  public void b(an.b paramb)
  {
    if (paramb != null)
    {
      long l = paramb.a();
      com.xiaomi.a.a.c.c.a("schedule rebind job in " + l / 1000L);
      a(new a(paramb), l);
    }
  }

  public boolean b()
  {
    try
    {
      Class localClass = Class.forName("miui.os.Build");
      Field localField1 = localClass.getField("IS_CM_CUSTOMIZATION_TEST");
      Field localField2 = localClass.getField("IS_CU_CUSTOMIZATION_TEST");
      int m;
      if (!localField1.getBoolean(null))
      {
        boolean bool = localField2.getBoolean(null);
        m = 0;
        if (!bool);
      }
      else
      {
        m = 1;
      }
      return m;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  public boolean b(int paramInt)
  {
    return this.j.b(paramInt);
  }

  public s c()
  {
    return new s();
  }

  public s d()
  {
    return this.g;
  }

  public boolean e()
  {
    return (this.f != null) && (this.f.h());
  }

  public boolean f()
  {
    return (this.f != null) && (this.f.g());
  }

  public com.xiaomi.d.a g()
  {
    return this.f;
  }

  public void h()
  {
    a(new j(this, 10), 120000L);
  }

  public IBinder onBind(Intent paramIntent)
  {
    return new g();
  }

  public void onCreate()
  {
    super.onCreate();
    com.xiaomi.d.e.h.a(this);
    x localx = y.a(this);
    if (localx != null)
      com.xiaomi.a.a.d.a.a(localx.g);
    aq.a(this);
    this.b = new k(this, null, 5222, "xiaomi.com", null);
    this.b.a(true);
    this.e = a(this.b);
    this.e.b(a("xiaomi.com"));
    new com.xiaomi.network.b("mibind.chat.gslb.mi-idc.com");
    this.g = c();
    try
    {
      if (TextUtils.equals((String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class }).invoke(null, new Object[] { "sys.boot_completed" }), "1"))
        this.g.a(this);
      this.i = new com.xiaomi.push.service.a.a(this);
      this.e.a(this);
      this.h = new PacketSync(this);
      this.c = new e(this);
      new t().a();
      this.j = new u("Connection Controller Thread");
      this.j.start();
      a(new l(this, 11));
      an localan = an.a();
      localan.e();
      localan.a(new m(this));
      return;
    }
    catch (Exception localException)
    {
      while (true)
        com.xiaomi.a.a.c.c.a(localException);
    }
  }

  public void onDestroy()
  {
    this.j.a();
    a(new q(this, 2));
    a(new f());
    an.a().e();
    an.a().a(this, 15);
    an.a().d();
    this.e.b(this);
    g.a().b();
    this.i.a();
    super.onDestroy();
    com.xiaomi.a.a.c.c.a("Service destroyed");
  }

  public void onStart(Intent paramIntent, int paramInt)
  {
    int m = 1;
    int i1 = 0;
    an localan;
    String str1;
    if (paramIntent == null)
    {
      com.xiaomi.a.a.c.c.d("onStart() with intent NULL");
      localan = an.a();
      if ((paramIntent != null) && (paramIntent.getAction() != null))
      {
        if ((!ap.d.equalsIgnoreCase(paramIntent.getAction())) && (!ap.j.equalsIgnoreCase(paramIntent.getAction())))
          break label307;
        str1 = paramIntent.getStringExtra(ap.q);
        if (!TextUtils.isEmpty(paramIntent.getStringExtra(ap.u)))
          break label125;
        com.xiaomi.a.a.c.c.a("security is empty. ignore.");
      }
    }
    while (true)
    {
      return;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = paramIntent.getAction();
      arrayOfObject1[m] = paramIntent.getStringExtra(ap.q);
      com.xiaomi.a.a.c.c.c(String.format("onStart() with intent.Action = %s, chid = %s", arrayOfObject1));
      break;
      label125: if (str1 != null)
      {
        boolean bool1 = a(str1, paramIntent);
        an.b localb1 = b(str1, paramIntent);
        if (!com.xiaomi.a.a.e.d.d(this))
        {
          this.g.a(this, localb1, false, 2, null);
          return;
        }
        if (e())
        {
          if (localb1.m == an.c.a)
          {
            a(new a(localb1));
            return;
          }
          if (bool1)
          {
            a(new j(localb1));
            return;
          }
          if (localb1.m == an.c.b)
          {
            Object[] arrayOfObject2 = new Object[2];
            arrayOfObject2[0] = localb1.h;
            arrayOfObject2[m] = localb1.b;
            com.xiaomi.a.a.c.c.a(String.format("the client is binding. %1$s %2$s.", arrayOfObject2));
            return;
          }
          if (localb1.m != an.c.c)
            continue;
          this.g.a(this, localb1, m, 0, null);
          return;
        }
        a(m);
        return;
      }
      com.xiaomi.a.a.c.c.d("channel id is empty, do nothing!");
      return;
      label307: if (ap.i.equalsIgnoreCase(paramIntent.getAction()))
      {
        String str22 = paramIntent.getStringExtra(ap.y);
        String str23 = paramIntent.getStringExtra(ap.q);
        String str24 = paramIntent.getStringExtra(ap.p);
        if (TextUtils.isEmpty(str23))
        {
          Iterator localIterator = localan.b(str22).iterator();
          while (localIterator.hasNext())
            a((String)localIterator.next(), 2);
          continue;
        }
        if (TextUtils.isEmpty(str24))
        {
          a(str23, 2);
          return;
        }
        a(str23, str24, 2, null, null);
        return;
      }
      if (ap.e.equalsIgnoreCase(paramIntent.getAction()))
      {
        String str20 = paramIntent.getStringExtra(ap.y);
        String str21 = paramIntent.getStringExtra(ap.B);
        Bundle localBundle = paramIntent.getBundleExtra("ext_packet");
        boolean bool6 = paramIntent.getBooleanExtra("ext_encrypt", m);
        com.xiaomi.d.c.d locald = a(new com.xiaomi.d.c.c(localBundle), str20, str21, bool6);
        if (locald == null)
          continue;
        a(new f(this, locald));
        return;
      }
      if (ap.g.equalsIgnoreCase(paramIntent.getAction()))
      {
        String str18 = paramIntent.getStringExtra(ap.y);
        String str19 = paramIntent.getStringExtra(ap.B);
        Parcelable[] arrayOfParcelable = paramIntent.getParcelableArrayExtra("ext_packets");
        com.xiaomi.d.c.c[] arrayOfc = new com.xiaomi.d.c.c[arrayOfParcelable.length];
        boolean bool5 = paramIntent.getBooleanExtra("ext_encrypt", m);
        while (true)
        {
          if (i1 >= arrayOfParcelable.length)
            break label639;
          arrayOfc[i1] = new com.xiaomi.d.c.c((Bundle)arrayOfParcelable[i1]);
          arrayOfc[i1] = ((com.xiaomi.d.c.c)a(arrayOfc[i1], str18, str19, bool5));
          if (arrayOfc[i1] == null)
            break;
          i1++;
        }
        label639: a(new a(this, arrayOfc));
        return;
      }
      if (ap.f.equalsIgnoreCase(paramIntent.getAction()))
      {
        String str16 = paramIntent.getStringExtra(ap.y);
        String str17 = paramIntent.getStringExtra(ap.B);
        com.xiaomi.d.c.b localb = new com.xiaomi.d.c.b(paramIntent.getBundleExtra("ext_packet"));
        if (a(localb, str16, str17, false) == null)
          continue;
        a(new f(this, localb));
        return;
      }
      if (ap.h.equalsIgnoreCase(paramIntent.getAction()))
      {
        String str14 = paramIntent.getStringExtra(ap.y);
        String str15 = paramIntent.getStringExtra(ap.B);
        com.xiaomi.d.c.f localf = new com.xiaomi.d.c.f(paramIntent.getBundleExtra("ext_packet"));
        if (a(localf, str14, str15, false) == null)
          continue;
        a(new f(this, localf));
        return;
      }
      if (("com.xiaomi.push.timer".equalsIgnoreCase(paramIntent.getAction())) || ("com.xiaomi.push.check_alive".equalsIgnoreCase(paramIntent.getAction())))
      {
        if ("com.xiaomi.push.timer".equalsIgnoreCase(paramIntent.getAction()))
          com.xiaomi.a.a.c.c.a("Service called on timer");
        while (true)
        {
          if (!this.j.b())
            break label912;
          com.xiaomi.a.a.c.c.d("ERROR, the job controller is blocked.");
          an.a().a(this, 14);
          stopSelf();
          return;
          if (System.currentTimeMillis() - this.d < 30000L)
            break;
          this.d = System.currentTimeMillis();
          com.xiaomi.a.a.c.c.a("Service called on check alive.");
        }
        label912: if (!e())
        {
          if ("com.xiaomi.push.timer".equalsIgnoreCase(paramIntent.getAction()))
          {
            a(false);
            return;
          }
          a(m);
          return;
        }
        if (this.f.p())
        {
          a(new i());
          return;
        }
        a(new d(17, null));
        return;
      }
      if ("com.xiaomi.push.network_status_changed".equalsIgnoreCase(paramIntent.getAction()))
        try
        {
          NetworkInfo localNetworkInfo2 = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
          localNetworkInfo1 = localNetworkInfo2;
          if (localNetworkInfo1 != null)
          {
            com.xiaomi.a.a.c.c.a("network changed, " + localNetworkInfo1.toString());
            this.e.q();
            if (!com.xiaomi.a.a.e.d.d(this))
              break label1129;
            if ((!e()) && (!f()))
            {
              this.j.a(m);
              a(new c());
            }
            com.xiaomi.push.a.b.a(this).a();
            j();
            return;
          }
        }
        catch (Exception localException)
        {
          while (true)
          {
            com.xiaomi.a.a.c.c.a(localException);
            NetworkInfo localNetworkInfo1 = null;
            continue;
            com.xiaomi.a.a.c.c.a("network changed, no active network");
            continue;
            label1129: a(new d(2, null));
          }
        }
      if (ap.k.equals(paramIntent.getAction()))
      {
        String str13 = paramIntent.getStringExtra(ap.q);
        if (str13 != null)
          b(str13, paramIntent);
        a(new k());
        return;
      }
      if (ap.l.equals(paramIntent.getAction()))
      {
        String str10 = paramIntent.getStringExtra(ap.y);
        List localList = localan.b(str10);
        if (localList.isEmpty())
        {
          com.xiaomi.a.a.c.c.a("open channel should be called first before update info, pkg=" + str10);
          return;
        }
        String str11 = paramIntent.getStringExtra(ap.q);
        String str12 = paramIntent.getStringExtra(ap.p);
        if (TextUtils.isEmpty(str11))
          str11 = (String)localList.get(0);
        Collection localCollection2;
        if (TextUtils.isEmpty(str12))
        {
          localCollection2 = localan.c(str11);
          localb2 = null;
          if (localCollection2 != null)
          {
            boolean bool4 = localCollection2.isEmpty();
            localb2 = null;
            if (bool4);
          }
        }
        for (an.b localb2 = (an.b)localCollection2.iterator().next(); ; localb2 = localan.b(str11, str12))
        {
          if (localb2 == null)
            break label1420;
          if (paramIntent.hasExtra(ap.w))
            localb2.f = paramIntent.getStringExtra(ap.w);
          if (!paramIntent.hasExtra(ap.x))
            break;
          localb2.g = paramIntent.getStringExtra(ap.x);
          return;
        }
        label1420: continue;
      }
      if ("com.xiaomi.mipush.REGISTER_APP".equals(paramIntent.getAction()))
      {
        if ((b.a(getApplicationContext()).a()) && (b.a(getApplicationContext()).b() == 0))
        {
          com.xiaomi.a.a.c.c.a("register without being provisioned. " + paramIntent.getStringExtra("mipush_app_package"));
          return;
        }
        byte[] arrayOfByte2 = paramIntent.getByteArrayExtra("mipush_payload");
        String str9 = paramIntent.getStringExtra("mipush_app_package");
        boolean bool3 = paramIntent.getBooleanExtra("mipush_env_chanage", false);
        int i4 = paramIntent.getIntExtra("mipush_env_type", m);
        z.a(this).c(str9);
        if ((bool3) && (!"com.xiaomi.xmsf".equals(getPackageName())))
        {
          a(new n(this, 14, i4, arrayOfByte2, str9));
          return;
        }
        a(arrayOfByte2, str9);
        return;
      }
      if (("com.xiaomi.mipush.SEND_MESSAGE".equals(paramIntent.getAction())) || ("com.xiaomi.mipush.UNREGISTER_APP".equals(paramIntent.getAction())))
      {
        String str2 = paramIntent.getStringExtra("mipush_app_package");
        byte[] arrayOfByte1 = paramIntent.getByteArrayExtra("mipush_payload");
        boolean bool2 = paramIntent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", m);
        Collection localCollection1 = an.a().c("5");
        if ("com.xiaomi.mipush.UNREGISTER_APP".equals(paramIntent.getAction()))
          z.a(this).b(str2);
        if (localCollection1.isEmpty())
        {
          if (!bool2)
            continue;
          ab.b(str2, arrayOfByte1);
          return;
        }
        if (((an.b)localCollection1.iterator().next()).m != an.c.c)
        {
          if (!bool2)
            continue;
          ab.b(str2, arrayOfByte1);
          return;
        }
        a(new o(this, 4, str2, arrayOfByte1));
        return;
      }
      String str7;
      if (c.a.equals(paramIntent.getAction()))
      {
        str7 = paramIntent.getStringExtra("uninstall_pkg_name");
        if ((str7 == null) || (TextUtils.isEmpty(str7.trim())))
          continue;
      }
      try
      {
        getPackageManager().getPackageInfo(str7, 256);
        int n = 0;
        label1804: if (("com.xiaomi.channel".equals(str7)) && (!an.a().c("1").isEmpty()) && (n != 0))
        {
          a("1", 0);
          com.xiaomi.a.a.c.c.a("close the miliao channel as the app is uninstalled.");
          return;
        }
        SharedPreferences localSharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
        String str8 = localSharedPreferences.getString(str7, null);
        if ((TextUtils.isEmpty(str8)) || (n == 0))
          continue;
        SharedPreferences.Editor localEditor = localSharedPreferences.edit();
        localEditor.remove(str7);
        localEditor.commit();
        if (aj.e(this, str7))
          aj.d(this, str7);
        aj.b(this, str7);
        if ((!e()) || (str8 == null))
          continue;
        try
        {
          b(a(str7, str8));
          com.xiaomi.a.a.c.c.a("uninstall " + str7 + " msg sent");
          return;
        }
        catch (com.xiaomi.d.p localp)
        {
          com.xiaomi.a.a.c.c.d("Fail to send Message: " + localp.getMessage());
          a(10, localp);
          return;
        }
        if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(paramIntent.getAction()))
        {
          String str6 = paramIntent.getStringExtra(ap.y);
          int i3 = paramIntent.getIntExtra(ap.z, 0);
          if (TextUtils.isEmpty(str6))
            continue;
          if (i3 >= 0)
          {
            aj.a(this, str6, i3);
            return;
          }
          if (i3 != -1)
            continue;
          aj.b(this, str6);
          return;
        }
        if (!"com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(paramIntent.getAction()))
          continue;
        String str3 = paramIntent.getStringExtra(ap.y);
        String str4 = paramIntent.getStringExtra(ap.C);
        int i2;
        String str5;
        if (paramIntent.hasExtra(ap.A))
        {
          i2 = paramIntent.getIntExtra(ap.A, 0);
          str5 = com.xiaomi.a.a.g.c.b(str3 + i2);
        }
        while ((TextUtils.isEmpty(str3)) || (!TextUtils.equals(str4, str5)))
        {
          com.xiaomi.a.a.c.c.d("invalid notification for " + str3);
          return;
          str5 = com.xiaomi.a.a.g.c.b(str3);
          i1 = n;
          i2 = 0;
        }
        if (i1 != 0)
        {
          aj.d(this, str3);
          return;
        }
        aj.b(this, str3, i2);
        return;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        break label1804;
      }
    }
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    onStart(paramIntent, paramInt2);
    return a;
  }

  class a extends XMPushService.e
  {
    an.b a = null;

    public a(an.b arg2)
    {
      super();
      Object localObject;
      this.a = localObject;
    }

    public void a()
    {
      an.b localb;
      try
      {
        if (!XMPushService.this.e())
        {
          com.xiaomi.a.a.c.c.d("trying bind while the connection is not created, quit!");
          return;
        }
        localb = an.a().b(this.a.h, this.a.b);
        if (localb == null)
        {
          com.xiaomi.a.a.c.c.a("ignore bind because the channel " + this.a.h + " is removed ");
          return;
        }
      }
      catch (com.xiaomi.d.p localp)
      {
        com.xiaomi.a.a.c.c.a(localp);
        XMPushService.this.a(10, localp);
        return;
      }
      if (localb.m == an.c.a)
      {
        localb.a(an.c.b, 0, 0, null, null);
        XMPushService.e(XMPushService.this).a(localb);
        com.xiaomi.e.g.a(XMPushService.this, localb);
        return;
      }
      com.xiaomi.a.a.c.c.a("trying duplicate bind, ingore! " + localb.m);
    }

    public String b()
    {
      return "bind the client. " + this.a.h + ", " + this.a.b;
    }
  }

  static class b extends XMPushService.e
  {
    private final an.b a;

    public b(an.b paramb)
    {
      super();
      this.a = paramb;
    }

    public void a()
    {
      this.a.a(an.c.a, 1, 21, null, null);
    }

    public String b()
    {
      return "bind time out. chid=" + this.a.h;
    }

    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof b))
        return false;
      return TextUtils.equals(((b)paramObject).a.h, this.a.h);
    }

    public int hashCode()
    {
      return this.a.h.hashCode();
    }
  }

  public class c extends XMPushService.e
  {
    c()
    {
      super();
    }

    public void a()
    {
      if (XMPushService.this.a())
      {
        XMPushService.h(XMPushService.this);
        return;
      }
      com.xiaomi.a.a.c.c.a("should not connect. quit the job.");
    }

    public String b()
    {
      return "do reconnect..";
    }
  }

  public class d extends XMPushService.e
  {
    public int a;
    public Exception b;

    d(int paramException, Exception arg3)
    {
      super();
      this.a = paramException;
      Object localObject;
      this.b = localObject;
    }

    public void a()
    {
      XMPushService.this.a(this.a, this.b);
    }

    public String b()
    {
      return "disconnect the connection.";
    }
  }

  public static abstract class e
  {
    protected int d;

    public e(int paramInt)
    {
      this.d = paramInt;
    }

    public abstract void a();

    public abstract String b();

    public void c()
    {
      if ((this.d != 4) && (this.d != 8))
        com.xiaomi.a.a.c.c.a("JOB: " + b());
      a();
    }
  }

  class f extends XMPushService.e
  {
    public f()
    {
      super();
    }

    public void a()
    {
      XMPushService.f(XMPushService.this).quit();
    }

    public String b()
    {
      return "ask the job queue to quit";
    }
  }

  public class g extends Binder
  {
    public g()
    {
    }
  }

  class h extends XMPushService.e
  {
    private com.xiaomi.d.c.d b = null;

    public h(com.xiaomi.d.c.d arg2)
    {
      super();
      Object localObject;
      this.b = localObject;
    }

    public void a()
    {
      XMPushService.g(XMPushService.this).a(this.b);
    }

    public String b()
    {
      return "receive a message.";
    }
  }

  class i extends XMPushService.e
  {
    public i()
    {
      super();
    }

    public void a()
    {
      if (XMPushService.this.e());
      try
      {
        com.xiaomi.e.g.a();
        XMPushService.e(XMPushService.this).m();
        return;
      }
      catch (com.xiaomi.d.p localp)
      {
        com.xiaomi.a.a.c.c.a(localp);
        XMPushService.this.a(10, localp);
      }
    }

    public String b()
    {
      return "send ping..";
    }
  }

  class j extends XMPushService.e
  {
    an.b a = null;

    public j(an.b arg2)
    {
      super();
      Object localObject;
      this.a = localObject;
    }

    public void a()
    {
      try
      {
        this.a.a(an.c.a, 1, 16, null, null);
        XMPushService.e(XMPushService.this).a(this.a.h, this.a.b);
        this.a.a(an.c.b, 1, 16, null, null);
        XMPushService.e(XMPushService.this).a(this.a);
        return;
      }
      catch (com.xiaomi.d.p localp)
      {
        com.xiaomi.a.a.c.c.a(localp);
        XMPushService.this.a(10, localp);
      }
    }

    public String b()
    {
      return "bind the client. " + this.a.h + ", " + this.a.b;
    }
  }

  class k extends XMPushService.e
  {
    k()
    {
      super();
    }

    public void a()
    {
      XMPushService.this.a(11, null);
      if (XMPushService.this.a())
        XMPushService.h(XMPushService.this);
    }

    public String b()
    {
      return "reset the connection.";
    }
  }

  class l extends XMPushService.e
  {
    an.b a = null;
    int b;
    String c;
    String e;

    public l(an.b paramInt, int paramString1, String paramString2, String arg5)
    {
      super();
      this.a = paramInt;
      this.b = paramString1;
      this.c = paramString2;
      Object localObject;
      this.e = localObject;
    }

    public void a()
    {
      if ((this.a.m != an.c.a) && (XMPushService.e(XMPushService.this) != null));
      try
      {
        XMPushService.e(XMPushService.this).a(this.a.h, this.a.b);
        this.a.a(an.c.a, this.b, 0, this.e, this.c);
        return;
      }
      catch (com.xiaomi.d.p localp)
      {
        while (true)
        {
          com.xiaomi.a.a.c.c.a(localp);
          XMPushService.this.a(10, localp);
        }
      }
    }

    public String b()
    {
      return "unbind the channel. " + this.a.h + ", " + this.a.b;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.XMPushService
 * JD-Core Version:    0.6.0
 */