package c.a;

import android.os.Build;
import android.os.Build.VERSION;

public class eh extends a
{
  private static final String a = "serial";

  public eh()
  {
    super("serial");
  }

  public String f()
  {
    if (Build.VERSION.SDK_INT >= 9)
      return Build.SERIAL;
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.eh
 * JD-Core Version:    0.6.0
 */