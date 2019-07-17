package com.android.volley;

public class s<T>
{
  public final T a;
  public final b.a b;
  public final x c;
  public boolean d = false;

  private s(x paramx)
  {
    this.a = null;
    this.b = null;
    this.c = paramx;
  }

  private s(T paramT, b.a parama)
  {
    this.a = paramT;
    this.b = parama;
    this.c = null;
  }

  public static <T> s<T> a(x paramx)
  {
    return new s(paramx);
  }

  public static <T> s<T> a(T paramT, b.a parama)
  {
    return new s(paramT, parama);
  }

  public boolean a()
  {
    return this.c == null;
  }

  public static abstract interface a
  {
    public abstract void a(x paramx);
  }

  public static abstract interface b<T>
  {
    public abstract void a(T paramT);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.s
 * JD-Core Version:    0.6.0
 */