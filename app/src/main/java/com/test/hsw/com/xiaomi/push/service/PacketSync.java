package com.xiaomi.push.service;

import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.d.c.d;
import com.xiaomi.d.c.h;
import com.xiaomi.d.e.k;
import com.xiaomi.d.k.b;
import com.xiaomi.d.k.b.a;
import com.xiaomi.d.l;
import com.xiaomi.network.f;
import java.util.Date;

public class PacketSync
{
  private XMPushService a;

  PacketSync(XMPushService paramXMPushService)
  {
    this.a = paramXMPushService;
  }

  private void a(com.xiaomi.d.c.a parama)
  {
    String str = parama.c();
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = str.split(";");
      com.xiaomi.network.b localb = f.a().a(com.xiaomi.d.b.b(), false);
      if ((localb != null) && (arrayOfString.length > 0))
      {
        localb.a(arrayOfString);
        this.a.a(20, null);
        this.a.a(true);
      }
    }
  }

  private void b(d paramd)
  {
    String str1 = paramd.m();
    String str2 = paramd.l();
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      an.b localb = an.a().b(str2, str1);
      if (localb != null)
        k.a(this.a, localb.a, k.a(paramd.a()), true, System.currentTimeMillis());
    }
  }

  public void a(d paramd)
  {
    if (!"5".equals(paramd.l()))
      b(paramd);
    k.b localb2;
    k.b.a locala5;
    String str10;
    String str11;
    if ((paramd instanceof k.b))
    {
      localb2 = (k.b)paramd;
      locala5 = localb2.b();
      str10 = localb2.l();
      str11 = localb2.m();
      if (!TextUtils.isEmpty(str10));
    }
    String str1;
    com.xiaomi.d.c.b localb;
    do
    {
      do
      {
        an.b localb3;
        h localh;
        do
        {
          do
          {
            return;
            localb3 = an.a().b(str10, str11);
          }
          while (localb3 == null);
          if (locala5 == k.b.a.a)
          {
            localb3.a(an.c.c, 1, 0, null, null);
            com.xiaomi.a.a.c.c.a("SMACK: channel bind succeeded, chid=" + str10);
            return;
          }
          localh = localb2.p();
          com.xiaomi.a.a.c.c.a("SMACK: channel bind failed, error=" + localh.d());
        }
        while (localh == null);
        if ("auth".equals(localh.b()))
        {
          if ("invalid-sig".equals(localh.a()))
          {
            com.xiaomi.a.a.c.c.a("SMACK: bind error invalid-sig token = " + localb3.c + " sec = " + localb3.i);
            com.xiaomi.e.g.a(0, com.xiaomi.push.d.a.P.a(), 1, null);
          }
          localb3.a(an.c.a, 1, 5, localh.a(), localh.b());
          an.a().a(str10, str11);
        }
        while (true)
        {
          com.xiaomi.a.a.c.c.a("SMACK: channel bind failed, chid=" + str10 + " reason=" + localh.a());
          return;
          if ("cancel".equals(localh.b()))
          {
            localb3.a(an.c.a, 1, 7, localh.a(), localh.b());
            an.a().a(str10, str11);
            continue;
          }
          if (!"wait".equals(localh.b()))
            continue;
          this.a.b(localb3);
          localb3.a(an.c.a, 1, 7, localh.a(), localh.b());
        }
        str1 = paramd.l();
        if (TextUtils.isEmpty(str1))
        {
          str1 = "1";
          paramd.l(str1);
        }
        if (!str1.equals("0"))
          break;
      }
      while (!(paramd instanceof com.xiaomi.d.c.b));
      localb = (com.xiaomi.d.c.b)paramd;
      if ((!"0".equals(paramd.k())) || (!"result".equals(localb.b().toString())))
        break;
      com.xiaomi.d.a locala4 = this.a.g();
      if ((locala4 instanceof l))
        ((l)locala4).w();
      com.xiaomi.e.g.b();
    }
    while (localb.a("ps") == null);
    while (true)
    {
      try
      {
        com.xiaomi.push.b.b.a locala = com.xiaomi.push.b.b.a.b(Base64.decode(localb.a("ps"), 8));
        g.a().a(locala);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        while (true)
        {
          com.xiaomi.a.a.c.c.a("invalid Base64 exception + " + localIllegalArgumentException.getMessage());
          return;
          if (!"command".equals(localb.b().toString()))
            break;
          com.xiaomi.d.c.a locala3 = paramd.p("u");
          if (locala3 == null)
            break;
          String str5 = locala3.a("url");
          String str6 = locala3.a("startts");
          String str7 = locala3.a("endts");
          try
          {
            Date localDate1 = new Date(Long.parseLong(str6));
            Date localDate2 = new Date(Long.parseLong(str7));
            String str8 = locala3.a("token");
            boolean bool = "true".equals(locala3.a("force"));
            String str9 = locala3.a("maxlen");
            if (TextUtils.isEmpty(str9))
              break label1031;
            i = 1024 * Integer.parseInt(str9);
            com.xiaomi.push.a.b.a(this.a).a(str5, str8, localDate2, localDate1, i, bool);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            com.xiaomi.a.a.c.c.a("parseLong fail " + localNumberFormatException.getMessage());
          }
        }
      }
      catch (com.google.a.a.c localc1)
      {
        com.xiaomi.a.a.c.c.a("invalid pb exception + " + localc1.getMessage());
        return;
      }
      if ((paramd instanceof com.xiaomi.d.c.b))
      {
        com.xiaomi.d.c.a locala2 = paramd.p("kick");
        if (locala2 != null)
        {
          String str2 = paramd.m();
          String str3 = locala2.a("type");
          String str4 = locala2.a("reason");
          com.xiaomi.a.a.c.c.a("kicked by server, chid=" + str1 + " userid=" + str2 + " type=" + str3 + " reason=" + str4);
          if ("wait".equals(str3))
          {
            an.b localb1 = an.a().b(str1, str2);
            if (localb1 == null)
              break;
            this.a.b(localb1);
            localb1.a(an.c.a, 3, 0, str4, str3);
            return;
          }
          this.a.a(str1, str2, 3, str4, str3);
          an.a().a(str1, str2);
          return;
        }
      }
      else if ((paramd instanceof com.xiaomi.d.c.c))
      {
        com.xiaomi.d.c.c localc = (com.xiaomi.d.c.c)paramd;
        if ("redir".equals(localc.b()))
        {
          com.xiaomi.d.c.a locala1 = localc.p("hosts");
          if (locala1 == null)
            break;
          a(locala1);
          return;
        }
      }
      this.a.d().a(this.a, str1, paramd);
      return;
      label1031: int i = 0;
    }
  }

  public static abstract interface PacketReceiveHandler extends Parcelable
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.PacketSync
 * JD-Core Version:    0.6.0
 */