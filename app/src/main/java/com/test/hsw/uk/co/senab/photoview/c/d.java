package uk.co.senab.photoview.c;

import android.content.Context;
import android.os.Build.VERSION;

public abstract class d
{
  public static d a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 9)
      return new c(paramContext);
    if (Build.VERSION.SDK_INT < 14)
      return new a(paramContext);
    return new b(paramContext);
  }

  public abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);

  public abstract void a(boolean paramBoolean);

  public abstract boolean a();

  public abstract boolean b();

  public abstract int c();

  public abstract int d();
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     uk.co.senab.photoview.c.d
 * JD-Core Version:    0.6.0
 */