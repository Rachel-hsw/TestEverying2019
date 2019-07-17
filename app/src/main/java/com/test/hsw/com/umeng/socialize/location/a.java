package com.umeng.socialize.location;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.text.TextUtils;
import com.umeng.socialize.utils.i;

public class a
  implements SocializeLocationProvider
{
  private static final String a = a.class.getName();
  private Location b;
  private Context c;
  private d d;
  private c e = null;
  private String f;

  private void a(Context paramContext, int paramInt)
  {
    Criteria localCriteria = new Criteria();
    localCriteria.setAccuracy(paramInt);
    String str = this.d.a(localCriteria, true);
    if (str != null)
      this.f = str;
    i.c(a, "Get location from " + this.f);
    try
    {
      if (!TextUtils.isEmpty(this.f))
      {
        Location localLocation = this.d.a(this.f);
        if (localLocation != null)
        {
          this.b = localLocation;
          return;
        }
        if ((this.d.b(this.f)) && (this.e != null) && ((paramContext instanceof Activity)))
        {
          this.d.a((Activity)paramContext, this.f, 1L, 0.0F, this.e);
          return;
        }
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
    }
  }

  public void a()
  {
    if ((this.d != null) && (this.e != null))
      this.d.a(this.e);
  }

  public void a(Context paramContext)
  {
    this.c = paramContext;
    this.e = new c();
    b();
  }

  protected void a(Location paramLocation)
  {
    this.b = paramLocation;
  }

  public void a(d paramd)
  {
    this.d = paramd;
  }

  public void a(String paramString)
  {
    this.f = paramString;
  }

  public Location b()
  {
    if (this.b == null)
    {
      if (!com.umeng.socialize.utils.c.a(this.c, "android.permission.ACCESS_FINE_LOCATION"))
        break label33;
      a(this.c, 1);
    }
    while (true)
    {
      return this.b;
      label33: if (!com.umeng.socialize.utils.c.a(this.c, "android.permission.ACCESS_COARSE_LOCATION"))
        continue;
      a(this.c, 2);
    }
  }

  protected d c()
  {
    return this.d;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.location.a
 * JD-Core Version:    0.6.0
 */