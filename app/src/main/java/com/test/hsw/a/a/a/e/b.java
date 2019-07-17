package a.a.a.e;

import android.os.Process;
import android.util.SparseArray;
import java.lang.ref.WeakReference;

abstract class b<T, Q extends a<T>>
{
  final String a;
  final a.a.a.a<T, ?> b;
  final String[] c;
  final SparseArray<WeakReference<Q>> d;

  b(a.a.a.a<T, ?> parama, String paramString, String[] paramArrayOfString)
  {
    this.b = parama;
    this.a = paramString;
    this.c = paramArrayOfString;
    this.d = new SparseArray();
  }

  Q a()
  {
    int i = Process.myTid();
    while (true)
    {
      synchronized (this.d)
      {
        WeakReference localWeakReference = (WeakReference)this.d.get(i);
        if (localWeakReference != null)
        {
          locala = (a)localWeakReference.get();
          if (locala != null)
            continue;
          c();
          locala = b();
          this.d.put(i, new WeakReference(locala));
          return locala;
          System.arraycopy(this.c, 0, locala.d, 0, this.c.length);
        }
      }
      a locala = null;
    }
  }

  Q a(Q paramQ)
  {
    if (Thread.currentThread() == paramQ.e)
    {
      System.arraycopy(this.c, 0, paramQ.d, 0, this.c.length);
      return paramQ;
    }
    return a();
  }

  protected abstract Q b();

  void c()
  {
    while (true)
    {
      int i;
      synchronized (this.d)
      {
        i = -1 + this.d.size();
        if (i < 0)
          return;
        if (((WeakReference)this.d.valueAt(i)).get() == null)
          this.d.remove(this.d.keyAt(i));
      }
      i--;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.e.b
 * JD-Core Version:    0.6.0
 */