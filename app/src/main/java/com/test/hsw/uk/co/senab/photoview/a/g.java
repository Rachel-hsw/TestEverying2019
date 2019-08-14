package uk.co.senab.photoview.a;

import android.content.Context;
import android.os.Build.VERSION;

public final class g
{
  public static e a(Context paramContext, f paramf)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject;
    if (i < 5)
      localObject = new a(paramContext);
    while (true)
    {
      ((e)localObject).a(paramf);
      return localObject;
      if (i < 8)
      {
        localObject = new b(paramContext);
        continue;
      }
      localObject = new c(paramContext);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     uk.co.senab.photoview.a.g
 * JD-Core Version:    0.6.0
 */