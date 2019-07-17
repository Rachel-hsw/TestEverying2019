package c.a;

import android.content.Context;
import android.content.SharedPreferences;

public class fc
{
  private static final String a = "umeng_general_config";

  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("umeng_general_config", 0);
  }

  public static SharedPreferences a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences(paramString, 0);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.fc
 * JD-Core Version:    0.6.0
 */