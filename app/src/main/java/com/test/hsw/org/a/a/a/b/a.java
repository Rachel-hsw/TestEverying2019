package org.a.a.a.b;

import java.util.concurrent.atomic.AtomicReference;

public abstract class a<T>
  implements g<T>
{
  private final AtomicReference<T> a = new AtomicReference();

  public T a()
    throws f
  {
    Object localObject = this.a.get();
    if (localObject == null)
    {
      localObject = b();
      if (!this.a.compareAndSet(null, localObject))
        localObject = this.a.get();
    }
    return localObject;
  }

  protected abstract T b()
    throws f;
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.b.a
 * JD-Core Version:    0.6.0
 */