package com.baidu.location.e;

import android.location.Location;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.m;
import com.baidu.location.h.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public abstract class b
  implements com.baidu.location.b.f
{
  public static String fN = null;
  private boolean fM = false;
  private boolean fO = true;
  final Handler fP = new b();
  public h fQ = null;
  public com.baidu.location.h.f fR = null;

  public abstract void a4();

  public abstract void jdMethod_if(Message paramMessage);

  public String k(String paramString)
  {
    if ((this.fQ == null) || (!this.fQ.du()))
      this.fQ = com.baidu.location.h.c.a().cM();
    if ((this.fR == null) || (!this.fR.dq()))
      this.fR = com.baidu.location.h.l.a().dc();
    if (com.baidu.location.h.d.a().cH());
    for (Location localLocation = com.baidu.location.h.d.a().cB(); ; localLocation = null)
    {
      if (((this.fQ == null) || (this.fQ.dv())) && ((this.fR == null) || (this.fR.dl() == 0)) && (localLocation == null))
        return null;
      String str1 = c.bp().bs();
      String str2;
      if (com.baidu.location.h.l.a().c9())
      {
        str2 = "&cn=32";
        if (!this.fO)
          break label311;
        this.fO = false;
        com.baidu.location.b.o.aX().aU().jdMethod_for(true);
        String str5 = com.baidu.location.h.l.a().c5();
        if (!TextUtils.isEmpty(str5))
        {
          String str6 = str5.replace(":", "");
          str2 = String.format(Locale.CHINA, "%s&mac=%s", new Object[] { str2, str6 });
        }
        if (Build.VERSION.SDK_INT <= 17);
      }
      while (true)
      {
        String str4 = str2 + str1;
        if (paramString != null)
          str4 = paramString + str4;
        return com.baidu.location.b.k.jdMethod_if(this.fQ, this.fR, localLocation, str4, 0);
        Locale localLocale = Locale.CHINA;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(com.baidu.location.h.c.a().cP());
        str2 = String.format(localLocale, "&cn=%d", arrayOfObject);
        break;
        label311: if (this.fM)
          continue;
        String str3 = o.ci();
        if (str3 != null)
          str2 = str2 + str3;
        this.fM = true;
      }
    }
  }

  class a extends m
  {
    String ew = null;
    String ex = null;

    public a()
    {
      this.c7 = new ArrayList();
    }

    public void au()
    {
      this.c5 = com.baidu.location.b.k.Z();
      String str1 = com.baidu.location.b.d.U().S();
      if ((c8 == com.baidu.location.b.g.for) || (c8 == com.baidu.location.b.g.o))
        this.c5 = ("http://" + str1 + "/sdk.php");
      if (str1 != null)
        com.baidu.location.b.o.aX().aU().jdMethod_else("&host=" + str1);
      String str2 = Jni.K(this.ew);
      this.ew = null;
      if (this.ex == null)
        this.ex = o.cl();
      this.c7.add(new BasicNameValuePair("bloc", str2));
      if (this.ex != null)
        this.c7.add(new BasicNameValuePair("up", this.ex));
      StringBuffer localStringBuffer = new StringBuffer(512);
      Locale localLocale1 = Locale.CHINA;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = com.baidu.location.b.j.a(com.baidu.location.f.getServiceContext());
      arrayOfObject1[1] = com.baidu.location.b.j.jdMethod_if(com.baidu.location.f.getServiceContext());
      localStringBuffer.append(String.format(localLocale1, "&ki=%s&sn=%s", arrayOfObject1));
      if (localStringBuffer.length() > 0)
        this.c7.add(new BasicNameValuePair("ext", Jni.H(localStringBuffer.toString())));
      Locale localLocale2 = Locale.CHINA;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Long.valueOf(System.currentTimeMillis());
      String str3 = String.format(localLocale2, "%d", arrayOfObject2);
      this.c7.add(new BasicNameValuePair("trtm", str3));
    }

    public void jdMethod_int(boolean paramBoolean)
    {
      if ((b.this.fQ != null) && (b.this.fQ.dt() == 0))
        return;
      if ((paramBoolean) && (this.c6 != null));
      while (true)
      {
        try
        {
          while (true)
          {
            String str = EntityUtils.toString(this.c6, "utf-8");
            b.fN = str;
            try
            {
              localBDLocation = new BDLocation(str);
              localBDLocation.setOperators(com.baidu.location.h.c.a().cQ());
              if (l.ce().cb())
                localBDLocation.setDirection(l.ce().cg());
              this.ex = null;
              if ((localBDLocation.getLocType() == 0) && (localBDLocation.getLatitude() == 4.9E-324D) && (localBDLocation.getLongitude() == 4.9E-324D))
              {
                Message localMessage4 = b.this.fP.obtainMessage(63);
                localMessage4.obj = "HttpStatus error";
                localMessage4.sendToTarget();
                if (this.c7 == null)
                  break;
                this.c7.clear();
                return;
              }
            }
            catch (Exception localException2)
            {
              while (true)
              {
                localBDLocation = new BDLocation();
                localBDLocation.setLocType(0);
              }
            }
          }
        }
        catch (Exception localException1)
        {
          BDLocation localBDLocation;
          Message localMessage2 = b.this.fP.obtainMessage(63);
          localMessage2.obj = "HttpStatus error";
          localMessage2.sendToTarget();
          continue;
          Message localMessage3 = b.this.fP.obtainMessage(21);
          localMessage3.obj = localBDLocation;
          localMessage3.sendToTarget();
          continue;
        }
        Message localMessage1 = b.this.fP.obtainMessage(63);
        localMessage1.obj = "HttpStatus error";
        localMessage1.sendToTarget();
      }
    }

    public void jdMethod_long(String paramString)
    {
      this.ew = paramString;
      ao();
    }
  }

  public class b extends Handler
  {
    public b()
    {
    }

    public void handleMessage(Message paramMessage)
    {
      if (!com.baidu.location.f.isServing)
        return;
      switch (paramMessage.what)
      {
      default:
        return;
      case 21:
        b.this.jdMethod_if(paramMessage);
        return;
      case 62:
      case 63:
      }
      b.this.a4();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.e.b
 * JD-Core Version:    0.6.0
 */