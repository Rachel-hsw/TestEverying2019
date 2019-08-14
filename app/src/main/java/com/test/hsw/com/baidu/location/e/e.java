package com.baidu.location.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class e
  implements com.baidu.location.b.f
{
  private static e gs = null;
  private int gr = -1;
  private String gt = null;
  private a gu = null;
  private boolean gv = false;

  public static e bv()
  {
    monitorenter;
    try
    {
      if (gs == null)
        gs = new e();
      e locale = gs;
      return locale;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean bt()
  {
    return this.gv;
  }

  public String bu()
  {
    return this.gt;
  }

  public int bw()
  {
    return this.gr;
  }

  public void bx()
  {
    this.gu = new a();
    com.baidu.location.f.getServiceContext().registerReceiver(this.gu, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
  }

  public void by()
  {
    if (this.gu != null);
    try
    {
      com.baidu.location.f.getServiceContext().unregisterReceiver(this.gu);
      label17: this.gu = null;
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }

  public class a extends BroadcastReceiver
  {
    public a()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      String str = paramIntent.getAction();
      int i;
      int j;
      try
      {
        if (!str.equals("android.intent.action.BATTERY_CHANGED"))
          return;
        e.jdMethod_if(e.this, false);
        i = paramIntent.getIntExtra("status", 0);
        j = paramIntent.getIntExtra("plugged", 0);
        int k = paramIntent.getIntExtra("level", -1);
        int m = paramIntent.getIntExtra("scale", -1);
        if ((k > 0) && (m > 0))
        {
          e.jdMethod_if(e.this, k * 100 / m);
          break label190;
          e.jdMethod_if(e.this, null);
          break label220;
        }
        e.jdMethod_if(e.this, -1);
      }
      catch (Exception localException)
      {
        e.jdMethod_if(e.this, null);
        return;
      }
      e.jdMethod_if(e.this, "4");
      break label220;
      e.jdMethod_if(e.this, "3");
      break label220;
      e.jdMethod_if(e.this, "6");
      e.jdMethod_if(e.this, true);
      return;
      e.jdMethod_if(e.this, "5");
      e.jdMethod_if(e.this, true);
      return;
      label190: switch (i)
      {
      default:
      case 2:
      case 3:
      case 4:
      }
      label220: switch (j)
      {
      case 1:
      case 2:
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.e.e
 * JD-Core Version:    0.6.0
 */