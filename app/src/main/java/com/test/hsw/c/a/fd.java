package c.a;

import android.content.Context;
import com.umeng.a.a;
import com.umeng.a.w;
import com.umeng.a.w.a;

public class fd
{
  private static final int a = 1;
  private static final int b = 2;
  private static final int c = 3;
  private dg d;
  private ef e;
  private final int f = 1;
  private Context g;
  private b h;
  private ey i;
  private bn j;
  private boolean k = false;
  private boolean l;

  public fd(Context paramContext, b paramb)
  {
    this.d = dg.a(paramContext);
    this.e = ef.a(paramContext);
    this.g = paramContext;
    this.h = paramb;
    this.i = new ey(paramContext);
    this.i.a(this.h);
  }

  private int a(byte[] paramArrayOfByte)
  {
    bg localbg = new bg();
    cp localcp = new cp(new df.a());
    try
    {
      localcp.a(localbg, paramArrayOfByte);
      if (localbg.a == 1)
      {
        this.e.b(localbg.j());
        this.e.c();
      }
      bu.a("MobclickAgent", "send log:" + localbg.f());
      if (localbg.a == 1)
        return 2;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
    return 3;
  }

  private void b()
  {
    w.a(this.g).i().a(new fe(this));
  }

  private byte[] b(bn parambn)
  {
    if (parambn == null)
      return null;
    try
    {
      byte[] arrayOfByte = new cv().a(parambn);
      if (bu.a)
        bu.c("MobclickAgent", parambn.toString());
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      bu.b("MobclickAgent", "Fail to serialize log ...", localException);
    }
    return null;
  }

  private void c()
  {
    this.d.a();
    bn localbn = this.j;
    localbn.a(this.d.b());
    byte[] arrayOfByte1 = b(localbn);
    if (arrayOfByte1 == null)
    {
      bu.e("MobclickAgent", "message is null");
      return;
    }
    cd localcd;
    label66: byte[] arrayOfByte2;
    byte[] arrayOfByte3;
    if (!this.k)
    {
      localcd = cd.a(this.g, a.a(this.g), arrayOfByte1);
      arrayOfByte2 = localcd.c();
      w.a(this.g).g();
      arrayOfByte3 = this.i.a(arrayOfByte2);
      if (arrayOfByte3 != null)
        break label180;
    }
    label180: for (int m = 1; ; m = a(arrayOfByte3))
      switch (m)
      {
      default:
        return;
      case 1:
        if (!this.l)
          w.a(this.g).b(arrayOfByte2);
        bu.b("MobclickAgent", "connection error");
        return;
        localcd = cd.b(this.g, a.a(this.g), arrayOfByte1);
        break label66;
      case 2:
      case 3:
      }
    if (this.h.i())
      this.h.h();
    this.d.d();
    this.h.g();
    return;
    this.h.g();
  }

  public void a()
  {
    if (this.j != null)
    {
      c();
      return;
    }
    b();
  }

  public void a(bn parambn)
  {
    this.j = parambn;
  }

  public void a(fb paramfb)
  {
    this.e.a(paramfb);
  }

  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }

  public void b(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.fd
 * JD-Core Version:    0.6.0
 */