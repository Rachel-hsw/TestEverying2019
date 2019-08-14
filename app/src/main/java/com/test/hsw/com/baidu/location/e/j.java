package com.baidu.location.e;

import android.os.Bundle;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.m;
import com.baidu.location.c.d.b;
import com.baidu.location.c.d.c;
import com.baidu.location.h.h;
import com.baidu.location.h.l;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

class j
  implements com.baidu.location.b.f
{
  private static j hI;
  private h hF = null;
  private com.baidu.location.h.f hG = null;
  private long hH = 0L;
  private String hJ = null;
  private final long hK = 1000L;

  public static j b1()
  {
    monitorenter;
    try
    {
      if (hI == null)
        hI = new j();
      j localj = hI;
      return localj;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private boolean jdMethod_for(com.baidu.location.h.f paramf)
  {
    int i = 1;
    com.baidu.location.h.f localf = l.a().dc();
    if (paramf == localf)
      i = 0;
    do
      return i;
    while ((localf == null) || (paramf == null) || (!paramf.jdMethod_try(localf)));
    return false;
  }

  private boolean jdMethod_for(h paramh)
  {
    int i = 1;
    h localh = com.baidu.location.h.c.a().cM();
    if (localh == paramh)
      i = 0;
    do
      return i;
    while ((localh == null) || (paramh == null) || (!paramh.jdMethod_case(localh)));
    return false;
  }

  private void t(String paramString)
  {
    this.hJ = paramString;
    Bundle localBundle = new Bundle();
    if ((paramString != null) && (!paramString.equals("")))
      localBundle.putByteArray("locationtag", paramString.getBytes());
    while (true)
    {
      c.bp().jdMethod_if(localBundle, 601);
      return;
      localBundle.putByteArray("locationtag", null);
    }
  }

  public void b0()
  {
    if ((System.currentTimeMillis() - this.hH < 1000L) && (this.hJ != null))
    {
      t(this.hJ);
      return;
    }
    this.hH = System.currentTimeMillis();
    boolean bool1 = jdMethod_for(this.hG);
    boolean bool2 = jdMethod_for(this.hF);
    if ((!bool1) && (!bool2) && (this.hJ != null))
    {
      t(this.hJ);
      return;
    }
    this.hF = com.baidu.location.h.c.a().cM();
    this.hG = l.a().dc();
    StringBuffer localStringBuffer = new StringBuffer(1024);
    if ((this.hF != null) && (this.hF.ds()))
      localStringBuffer.append(this.hF.dx());
    if ((this.hG != null) && (this.hG.dl() > 1))
      localStringBuffer.append(this.hG.e(15));
    String str = com.baidu.location.h.d.a().cG();
    if (str != null)
      localStringBuffer.append(str);
    localStringBuffer.append("&sema=aptag");
    localStringBuffer.append(com.baidu.location.b.c.N().jdMethod_do(false));
    localStringBuffer.append(c.bp().bs());
    new a().d(localStringBuffer.toString());
  }

  class a extends m
  {
    private String eM = null;

    a()
    {
      this.c7 = new ArrayList();
    }

    public void au()
    {
      this.dg = 1;
      this.c5 = com.baidu.location.b.k.Z();
      String str1 = com.baidu.location.b.d.U().S();
      if ((c8 == com.baidu.location.b.g.for) || (c8 == com.baidu.location.b.g.o))
        this.c5 = ("http://" + str1 + "/sdk.php");
      String str2 = Jni.H(this.eM);
      this.eM = null;
      this.c7.add(new BasicNameValuePair("bloc", str2));
    }

    public void d(String paramString)
    {
      this.eM = paramString;
      ao();
    }

    public void jdMethod_int(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.c6 != null));
      label178: 
      while (true)
      {
        try
        {
          BDLocation localBDLocation2 = new BDLocation(EntityUtils.toString(this.c6, "utf-8"));
          j.jdMethod_if(j.this, localBDLocation2.getLocationDescribe());
          if (this.c7 == null)
            continue;
          this.c7.clear();
          return;
        }
        catch (Exception localException)
        {
          j.jdMethod_if(j.this, null);
          continue;
        }
        boolean bool = com.baidu.location.b.k.bX;
        com.baidu.location.b.k.bX = true;
        BDLocation localBDLocation1;
        if ((com.baidu.location.c.d.jdMethod_try().jdMethod_long()) && (com.baidu.location.c.d.jdMethod_try().e()))
        {
          localBDLocation1 = com.baidu.location.c.d.jdMethod_try().jdMethod_if(com.baidu.location.h.c.a().cM(), l.a().c6(), null, d.c.if, d.b.a);
          if ((localBDLocation1 == null) || (localBDLocation1.getLocType() == 67))
            j.jdMethod_if(j.this, null);
        }
        while (true)
        {
          if (bool)
            break label178;
          com.baidu.location.b.k.bX = false;
          break;
          j.jdMethod_if(j.this, localBDLocation1.getLocationDescribe());
          continue;
          j.jdMethod_if(j.this, null);
        }
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.e.j
 * JD-Core Version:    0.6.0
 */