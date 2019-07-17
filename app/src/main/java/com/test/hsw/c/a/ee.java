package c.a;

import android.content.Context;
import android.telephony.TelephonyManager;

public class ee extends a
{
  private static final String a = "imei";
  private Context b;

  public ee(Context paramContext)
  {
    super("imei");
    this.b = paramContext;
  }

  public String f()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)this.b.getSystemService("phone");
    if (localTelephonyManager == null);
    try
    {
      if (bt.a(this.b, "android.permission.READ_PHONE_STATE"))
      {
        String str = localTelephonyManager.getDeviceId();
        return str;
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.ee
 * JD-Core Version:    0.6.0
 */