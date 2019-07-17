package b;

import java.io.IOException;

class c
  implements ab
{
  c(a parama, ab paramab)
  {
  }

  public ac a()
  {
    return this.b;
  }

  public long b(e parame, long paramLong)
    throws IOException
  {
    this.b.c();
    try
    {
      long l = this.a.b(parame, paramLong);
      this.b.a(true);
      return l;
    }
    catch (IOException localIOException)
    {
      throw this.b.a(localIOException);
    }
    finally
    {
      this.b.a(false);
    }
    throw localObject;
  }

  public void close()
    throws IOException
  {
    try
    {
      this.a.close();
      this.b.a(true);
      return;
    }
    catch (IOException localIOException)
    {
      throw this.b.a(localIOException);
    }
    finally
    {
      this.b.a(false);
    }
    throw localObject;
  }

  public String toString()
  {
    return "AsyncTimeout.source(" + this.a + ")";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     b.c
 * JD-Core Version:    0.6.0
 */