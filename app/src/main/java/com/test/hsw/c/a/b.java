package c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.umeng.a.w;

public class b
  implements ew
{
  private static final String h = "successful_request";
  private static final String i = "failed_requests ";
  private static final String j = "last_request_spent_ms";
  private static final String k = "last_request_time";
  private static final String l = "first_activate_time";
  private static final String m = "last_req";
  public int a;
  public int b;
  public long c;
  private final int d = 3600000;
  private int e;
  private long f = 0L;
  private long g = 0L;
  private Context n;

  public b(Context paramContext)
  {
    b(paramContext);
  }

  public static t a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = fc.a(paramContext);
    t localt = new t();
    localt.c(localSharedPreferences.getInt("failed_requests ", 0));
    localt.d(localSharedPreferences.getInt("last_request_spent_ms", 0));
    localt.a(localSharedPreferences.getInt("successful_request", 0));
    return localt;
  }

  private void b(Context paramContext)
  {
    this.n = paramContext.getApplicationContext();
    SharedPreferences localSharedPreferences = fc.a(paramContext);
    this.a = localSharedPreferences.getInt("successful_request", 0);
    this.b = localSharedPreferences.getInt("failed_requests ", 0);
    this.e = localSharedPreferences.getInt("last_request_spent_ms", 0);
    this.c = localSharedPreferences.getLong("last_request_time", 0L);
    this.f = localSharedPreferences.getLong("last_req", 0L);
  }

  public int a()
  {
    if (this.e > 3600000)
      return 3600000;
    return this.e;
  }

  public boolean b()
  {
    int i1;
    if (this.c == 0L)
    {
      i1 = 1;
      if (w.a(this.n).h())
        break label41;
    }
    label41: for (int i2 = 1; ; i2 = 0)
    {
      if ((i1 == 0) || (i2 == 0))
        break label46;
      return true;
      i1 = 0;
      break;
    }
    label46: return false;
  }

  public void c()
  {
    this.a = (1 + this.a);
    this.c = this.f;
  }

  public void d()
  {
    this.b = (1 + this.b);
  }

  public void e()
  {
    this.f = System.currentTimeMillis();
  }

  public void f()
  {
    this.e = (int)(System.currentTimeMillis() - this.f);
  }

  public void g()
  {
    fc.a(this.n).edit().putInt("successful_request", this.a).putInt("failed_requests ", this.b).putInt("last_request_spent_ms", this.e).putLong("last_request_time", this.c).putLong("last_req", this.f).commit();
  }

  public void h()
  {
    fc.a(this.n).edit().putLong("first_activate_time", System.currentTimeMillis()).commit();
  }

  public boolean i()
  {
    if (this.g == 0L)
      this.g = fc.a(this.n).getLong("first_activate_time", 0L);
    return this.g == 0L;
  }

  public long j()
  {
    if (i())
      return System.currentTimeMillis();
    return this.g;
  }

  public long k()
  {
    return this.f;
  }

  public void l()
  {
    e();
  }

  public void m()
  {
    f();
  }

  public void n()
  {
    c();
  }

  public void o()
  {
    d();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.b
 * JD-Core Version:    0.6.0
 */