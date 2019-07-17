package c.a;

import com.umeng.a.a;

public class es
  implements Thread.UncaughtExceptionHandler
{
  private Thread.UncaughtExceptionHandler a;
  private fa b;

  public es()
  {
    if (Thread.getDefaultUncaughtExceptionHandler() == this)
      return;
    this.a = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
  }

  private void a(Throwable paramThrowable)
  {
    if (a.k)
    {
      this.b.a(paramThrowable);
      return;
    }
    this.b.a(null);
  }

  public void a(fa paramfa)
  {
    this.b = paramfa;
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    a(paramThrowable);
    if ((this.a != null) && (this.a != Thread.getDefaultUncaughtExceptionHandler()))
      this.a.uncaughtException(paramThread, paramThrowable);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.es
 * JD-Core Version:    0.6.0
 */