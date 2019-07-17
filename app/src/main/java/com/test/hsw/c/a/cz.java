package c.a;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class cz
  implements Serializable
{
  private static Map<Class<? extends cl>, Map<? extends ct, cz>> d = new HashMap();
  public final String a;
  public final byte b;
  public final da c;

  public cz(String paramString, byte paramByte, da paramda)
  {
    this.a = paramString;
    this.b = paramByte;
    this.c = paramda;
  }

  public static Map<? extends ct, cz> a(Class<? extends cl> paramClass)
  {
    if (!d.containsKey(paramClass));
    try
    {
      paramClass.newInstance();
      return (Map)d.get(paramClass);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException("InstantiationException for TBase class: " + paramClass.getName() + ", message: " + localInstantiationException.getMessage());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
    throw new RuntimeException("IllegalAccessException for TBase class: " + paramClass.getName() + ", message: " + localIllegalAccessException.getMessage());
  }

  public static void a(Class<? extends cl> paramClass, Map<? extends ct, cz> paramMap)
  {
    d.put(paramClass, paramMap);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.cz
 * JD-Core Version:    0.6.0
 */