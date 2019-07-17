package a.a.a.f;

import a.a.a.a;
import a.a.a.e;
import a.a.a.h;
import java.util.Random;

public abstract class c<D extends a<T, Long>, T> extends d<D, T, Long>
{
  public c(Class<D> paramClass)
  {
    super(paramClass);
  }

  protected Long d()
  {
    return Long.valueOf(this.h.nextLong());
  }

  public void e()
  {
    if (this.c.b())
    {
      Object localObject1 = a(null);
      if (localObject1 != null)
      {
        Object localObject2 = a(null);
        this.b.c(localObject1);
        this.b.c(localObject2);
        Long localLong1 = (Long)this.c.a(localObject1);
        assertNotNull(localLong1);
        Long localLong2 = (Long)this.c.a(localObject2);
        assertNotNull(localLong2);
        assertFalse(localLong1.equals(localLong2));
        assertNotNull(this.b.a(localLong1));
        assertNotNull(this.b.a(localLong2));
        return;
      }
      e.b("Skipping testAssignPk for " + this.a + " (createEntity returned null for null key)");
      return;
    }
    e.b("Skipping testAssignPk for not updateable " + this.a);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.f.c
 * JD-Core Version:    0.6.0
 */