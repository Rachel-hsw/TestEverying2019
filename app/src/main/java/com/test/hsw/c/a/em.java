package c.a;

import android.content.Context;
import com.umeng.a.a.b;
import com.umeng.a.a.d;
import com.umeng.a.u;

public final class em
  implements eu
{
  private static em c;
  private eu a;
  private Context b;

  private em(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.a = new ek(this.b);
  }

  public static em a(Context paramContext)
  {
    monitorenter;
    try
    {
      if ((c == null) && (paramContext != null))
        c = new em(paramContext);
      em localem = c;
      return localem;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a()
  {
    u.b(new eo(this));
  }

  public void a(eu parameu)
  {
    this.a = parameu;
  }

  public void a(ev paramev)
  {
    u.b(new en(this, paramev));
  }

  public void a(b paramb)
  {
    if ((paramb != null) && (this.a != null))
      paramb.a((d)this.a);
  }

  public void b()
  {
    u.b(new ep(this));
  }

  public void b(ev paramev)
  {
    this.a.b(paramev);
  }

  public void c()
  {
    u.c(new eq(this));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.em
 * JD-Core Version:    0.6.0
 */