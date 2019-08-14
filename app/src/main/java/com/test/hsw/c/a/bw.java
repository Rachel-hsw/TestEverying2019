package c.a;

import android.os.AsyncTask;

public class bw extends bz
{
  private static final String a = bw.class.getName();

  public by.a a(bx parambx)
  {
    by localby = (by)a(parambx, by.class);
    if (localby == null)
      return by.a.b;
    return localby.a;
  }

  public void a(bx parambx, a parama)
  {
    try
    {
      new b(parambx, parama).execute(new Integer[0]);
      return;
    }
    catch (Exception localException)
    {
      do
        bu.b(a, "", localException);
      while (parama == null);
      parama.a(by.a.b);
    }
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(by.a parama);
  }

  private class b extends AsyncTask<Integer, Integer, by.a>
  {
    private bx b;
    private bw.a c;

    public b(bx parama, bw.a arg3)
    {
      this.b = parama;
      Object localObject;
      this.c = localObject;
    }

    protected by.a a(Integer[] paramArrayOfInteger)
    {
      return bw.this.a(this.b);
    }

    protected void a(by.a parama)
    {
      if (this.c != null)
        this.c.a(parama);
    }

    protected void onPreExecute()
    {
      if (this.c != null)
        this.c.a();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.bw
 * JD-Core Version:    0.6.0
 */