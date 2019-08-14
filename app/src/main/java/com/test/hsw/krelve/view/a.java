package krelve.view;

import android.os.Handler;
import android.support.v4.view.ViewPager;

class a
  implements Runnable
{
  a(Kanner paramKanner)
  {
  }

  public void run()
  {
    if (Kanner.a(this.a))
    {
      Kanner.a(this.a, 1 + Kanner.b(this.a) % (1 + Kanner.c(this.a)));
      if (Kanner.b(this.a) == 1)
      {
        Kanner.d(this.a).setCurrentItem(Kanner.b(this.a), false);
        Kanner.e(this.a).post(Kanner.f(this.a));
        return;
      }
      Kanner.d(this.a).setCurrentItem(Kanner.b(this.a));
      Kanner.e(this.a).postDelayed(Kanner.f(this.a), 3000L);
      return;
    }
    Kanner.e(this.a).postDelayed(Kanner.f(this.a), 5000L);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     krelve.view.a
 * JD-Core Version:    0.6.0
 */