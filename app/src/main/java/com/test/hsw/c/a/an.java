package c.a;

import android.content.Context;
import android.provider.Settings.Secure;

public class an extends a
{
  private static final String a = "android_id";
  private Context b;

  public an(Context paramContext)
  {
    super("android_id");
    this.b = paramContext;
  }

  public String f()
  {
    try
    {
      String str = Settings.Secure.getString(this.b.getContentResolver(), "android_id");
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.an
 * JD-Core Version:    0.6.0
 */