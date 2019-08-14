package a.a.a.f;

import a.a.a.a;
import java.util.Random;

public abstract class e<D extends a<T, String>, T> extends d<D, T, String>
{
  public e(Class<D> paramClass)
  {
    super(paramClass);
  }

  protected String d()
  {
    int i = 1 + this.h.nextInt(30);
    StringBuilder localStringBuilder = new StringBuilder();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return localStringBuilder.toString();
      localStringBuilder.append((char)(97 + this.h.nextInt(25)));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.f.e
 * JD-Core Version:    0.6.0
 */