package a.a.a;

import android.database.SQLException;

public class d extends SQLException
{
  private static final long a = -5877937327907457779L;

  public d()
  {
  }

  public d(String paramString)
  {
    super(paramString);
  }

  public d(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    a(paramThrowable);
  }

  public d(Throwable paramThrowable)
  {
    a(paramThrowable);
  }

  protected void a(Throwable paramThrowable)
  {
    try
    {
      initCause(paramThrowable);
      return;
    }
    catch (Throwable localThrowable)
    {
      e.e("Could not set initial cause", localThrowable);
      e.e("Initial cause is:", paramThrowable);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.d
 * JD-Core Version:    0.6.0
 */