package org.a.a.a.b;

import java.util.concurrent.atomic.AtomicReference;

public abstract class b<T>
  implements g<T>
{
  private final AtomicReference<b<T>> a = new AtomicReference();
  private final AtomicReference<T> b = new AtomicReference();

  public final T a()
    throws f
  {
    Object localObject;
    while (true)
    {
      localObject = this.b.get();
      if (localObject != null)
        break;
      if (!this.a.compareAndSet(null, this))
        continue;
      this.b.set(b());
    }
    return localObject;
  }

  protected abstract T b()
    throws f;
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.b.b
 * JD-Core Version:    0.6.0
 */