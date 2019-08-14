package com.squareup.a.a;

public abstract class i
  implements Runnable
{
  private final String a;

  public i(String paramString, Object[] paramArrayOfObject)
  {
    this.a = String.format(paramString, paramArrayOfObject);
  }

  protected abstract void e();

  public final void run()
  {
    String str = Thread.currentThread().getName();
    Thread.currentThread().setName(this.a);
    try
    {
      e();
      return;
    }
    finally
    {
      Thread.currentThread().setName(str);
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.i
 * JD-Core Version:    0.6.0
 */