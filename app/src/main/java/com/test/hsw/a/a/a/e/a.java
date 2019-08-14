package a.a.a.e;

import a.a.a.d;
import a.a.a.g;

abstract class a<T>
{
  protected final a.a.a.a<T, ?> a;
  protected final g<T> b;
  protected final String c;
  protected final String[] d;
  protected final Thread e;

  protected a(a.a.a.a<T, ?> parama, String paramString, String[] paramArrayOfString)
  {
    this.a = parama;
    this.b = new g(parama);
    this.c = paramString;
    this.d = paramArrayOfString;
    this.e = Thread.currentThread();
  }

  protected static String[] a(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    String[] arrayOfString = new String[i];
    int j = 0;
    if (j >= i)
      return arrayOfString;
    Object localObject = paramArrayOfObject[j];
    if (localObject != null)
      arrayOfString[j] = localObject.toString();
    while (true)
    {
      j++;
      break;
      arrayOfString[j] = null;
    }
  }

  protected void a()
  {
    if (Thread.currentThread() != this.e)
      throw new d("Method may be called only in owner thread, use forCurrentThread to get an instance for this thread");
  }

  public void a(int paramInt, Object paramObject)
  {
    a();
    if (paramObject != null)
    {
      this.d[paramInt] = paramObject.toString();
      return;
    }
    this.d[paramInt] = null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.e.a
 * JD-Core Version:    0.6.0
 */