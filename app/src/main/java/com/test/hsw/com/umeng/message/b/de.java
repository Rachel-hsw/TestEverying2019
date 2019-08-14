package com.umeng.message.b;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.b.a.a;
import com.umeng.message.PushAgent;
import java.lang.reflect.Field;

public class de
{
  private static final String a = de.class.getName();
  private static de b;
  private static Class e = null;
  private static Class f = null;
  private static Class g = null;
  private static Class h = null;
  private static Class i = null;
  private static Class j = null;
  private static Class k = null;
  private static Class l = null;
  private Context c;
  private String d;

  private de(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    a.c(a, "packageName=" + this.c.getPackageName());
    try
    {
      if (!TextUtils.isEmpty(PushAgent.getInstance(this.c).getResourcePackageName()))
      {
        localObject8 = PushAgent.getInstance(this.c).getResourcePackageName();
        f = Class.forName(localObject8 + ".R$drawable");
      }
    }
    catch (ClassNotFoundException localClassNotFoundException7)
    {
      try
      {
        label94: if (!TextUtils.isEmpty(PushAgent.getInstance(this.c).getResourcePackageName()))
        {
          localObject7 = PushAgent.getInstance(this.c).getResourcePackageName();
          label122: g = Class.forName(localObject7 + ".R$layout");
        }
      }
      catch (ClassNotFoundException localClassNotFoundException7)
      {
        try
        {
          label148: if (!TextUtils.isEmpty(PushAgent.getInstance(this.c).getResourcePackageName()))
          {
            localObject6 = PushAgent.getInstance(this.c).getResourcePackageName();
            label176: e = Class.forName(localObject6 + ".R$id");
          }
        }
        catch (ClassNotFoundException localClassNotFoundException7)
        {
          try
          {
            label202: if (!TextUtils.isEmpty(PushAgent.getInstance(this.c).getResourcePackageName()))
            {
              localObject5 = PushAgent.getInstance(this.c).getResourcePackageName();
              label230: h = Class.forName(localObject5 + ".R$anim");
            }
          }
          catch (ClassNotFoundException localClassNotFoundException7)
          {
            try
            {
              label256: if (!TextUtils.isEmpty(PushAgent.getInstance(this.c).getResourcePackageName()))
              {
                localObject4 = PushAgent.getInstance(this.c).getResourcePackageName();
                label284: i = Class.forName(localObject4 + ".R$style");
              }
            }
            catch (ClassNotFoundException localClassNotFoundException7)
            {
              try
              {
                label310: if (!TextUtils.isEmpty(PushAgent.getInstance(this.c).getResourcePackageName()))
                {
                  localObject3 = PushAgent.getInstance(this.c).getResourcePackageName();
                  label338: j = Class.forName(localObject3 + ".R$string");
                }
              }
              catch (ClassNotFoundException localClassNotFoundException7)
              {
                try
                {
                  label364: if (!TextUtils.isEmpty(PushAgent.getInstance(this.c).getResourcePackageName()))
                  {
                    localObject2 = PushAgent.getInstance(this.c).getResourcePackageName();
                    k = Class.forName(localObject2 + ".R$array");
                  }
                }
                catch (ClassNotFoundException localClassNotFoundException7)
                {
                  try
                  {
                    Object localObject8;
                    Object localObject7;
                    Object localObject6;
                    Object localObject5;
                    Object localObject4;
                    Object localObject3;
                    Object localObject2;
                    label392: label418: if (!TextUtils.isEmpty(PushAgent.getInstance(this.c).getResourcePackageName()));
                    String str1;
                    for (Object localObject1 = PushAgent.getInstance(this.c).getResourcePackageName(); ; localObject1 = str1)
                    {
                      l = Class.forName(localObject1 + ".R$raw");
                      return;
                      String str8 = this.c.getPackageName();
                      localObject8 = str8;
                      break;
                      localClassNotFoundException1 = localClassNotFoundException1;
                      a.b(a, localClassNotFoundException1.getMessage());
                      break label94;
                      String str7 = this.c.getPackageName();
                      localObject7 = str7;
                      break label122;
                      localClassNotFoundException2 = localClassNotFoundException2;
                      a.b(a, localClassNotFoundException2.getMessage());
                      break label148;
                      String str6 = this.c.getPackageName();
                      localObject6 = str6;
                      break label176;
                      localClassNotFoundException3 = localClassNotFoundException3;
                      a.b(a, localClassNotFoundException3.getMessage());
                      break label202;
                      String str5 = this.c.getPackageName();
                      localObject5 = str5;
                      break label230;
                      localClassNotFoundException4 = localClassNotFoundException4;
                      a.b(a, localClassNotFoundException4.getMessage());
                      break label256;
                      String str4 = this.c.getPackageName();
                      localObject4 = str4;
                      break label284;
                      localClassNotFoundException5 = localClassNotFoundException5;
                      a.b(a, localClassNotFoundException5.getMessage());
                      break label310;
                      String str3 = this.c.getPackageName();
                      localObject3 = str3;
                      break label338;
                      localClassNotFoundException6 = localClassNotFoundException6;
                      a.b(a, localClassNotFoundException6.getMessage());
                      break label364;
                      String str2 = this.c.getPackageName();
                      localObject2 = str2;
                      break label392;
                      localClassNotFoundException7 = localClassNotFoundException7;
                      a.b(a, localClassNotFoundException7.getMessage());
                      break label418;
                      str1 = this.c.getPackageName();
                    }
                  }
                  catch (ClassNotFoundException localClassNotFoundException8)
                  {
                    a.b(a, localClassNotFoundException8.getMessage());
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  private int a(Class<?> paramClass, String paramString)
  {
    if (paramClass == null)
    {
      a.b(a, "getRes(null," + paramString + ")");
      throw new IllegalArgumentException("ResClass is not initialized. Please make sure you have added neccessary resources. Also make sure you have " + this.c.getPackageName() + ".R$* configured in obfuscation. field=" + paramString);
    }
    try
    {
      int m = paramClass.getField(paramString).getInt(paramString);
      return m;
    }
    catch (Exception localException)
    {
      a.b(a, "getRes(" + paramClass.getName() + ", " + paramString + ")");
      a.b(a, "Error getting resource. Make sure you have copied all resources (res/) from SDK to your project. ");
      a.b(a, localException.getMessage());
    }
    return -1;
  }

  public static de a(Context paramContext)
  {
    if (b == null)
      b = new de(paramContext);
    return b;
  }

  public int a(String paramString)
  {
    return a(h, paramString);
  }

  public String a()
  {
    if (TextUtils.isEmpty(this.d))
      return this.c.getPackageName();
    return this.d;
  }

  public int b(String paramString)
  {
    return a(e, paramString);
  }

  public int c(String paramString)
  {
    return a(f, paramString);
  }

  public int d(String paramString)
  {
    return a(g, paramString);
  }

  public int e(String paramString)
  {
    return a(i, paramString);
  }

  public int f(String paramString)
  {
    return a(j, paramString);
  }

  public int g(String paramString)
  {
    return a(k, paramString);
  }

  public int h(String paramString)
  {
    return a(l, paramString);
  }

  public void i(String paramString)
  {
    this.d = paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.de
 * JD-Core Version:    0.6.0
 */