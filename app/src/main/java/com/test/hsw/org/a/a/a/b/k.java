package org.a.a.a.b;

public abstract class k<T>
  implements g<T>
{
  private volatile T a;

  public T a()
    throws f
  {
    Object localObject1 = this.a;
    if (localObject1 == null)
    {
      monitorenter;
      try
      {
        Object localObject3 = this.a;
        if (localObject3 == null)
        {
          localObject3 = b();
          this.a = localObject3;
        }
        return localObject3;
      }
      finally
      {
        monitorexit;
      }
    }
    return localObject1;
  }

  protected abstract T b()
    throws f;
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.b.k
 * JD-Core Version:    0.6.0
 */