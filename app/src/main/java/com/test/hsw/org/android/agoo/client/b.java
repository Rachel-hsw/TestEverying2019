package org.android.agoo.client;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

public class b
{
  public static final String AGOO_COMMAND_SOMANAGER = "so_manager";
  private static final String a = "register";
  private static final String b = "unregister";

  protected static void a(Context paramContext, String paramString)
  {
    if (paramContext != null);
    try
    {
      org.android.a.d(paramContext, paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  protected static final void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    a(paramContext, paramString1, paramString2, paramString3, true);
  }

  protected static final void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (paramContext != null);
    try
    {
      if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString1)))
      {
        if (TextUtils.isEmpty(paramString2))
          org.android.a.a(paramContext, true);
        org.android.a.a(paramContext, paramString1, paramString2, paramString3);
        Intent localIntent = org.android.agoo.b.a.a(paramContext, "register");
        if (localIntent != null)
          paramContext.sendBroadcast(localIntent);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  protected static final void a(Context paramContext, i parami)
  {
    if (paramContext != null);
    try
    {
      org.android.a.c(paramContext, parami.a());
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  protected static final void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4)
  {
    org.android.a.a(paramContext, paramBoolean1, paramBoolean2, paramBoolean3, paramLong, paramBoolean4);
  }

  @Deprecated
  public static final void checkDevice(Context paramContext)
  {
  }

  public static final org.android.agoo.b getMtopService(Context paramContext)
  {
    if (paramContext != null);
    while (true)
    {
      try
      {
        localb = (org.android.agoo.b)org.android.agoo.d.a.a(paramContext, "org.android.agoo.impl.MtopService");
        return localb;
      }
      catch (Throwable localThrowable)
      {
        return null;
      }
      org.android.agoo.b localb = null;
    }
  }

  public static final String getRegistrationId(Context paramContext)
  {
    Object localObject = null;
    if (paramContext != null);
    try
    {
      String str = org.android.a.g(paramContext);
      localObject = str;
      return localObject;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static final boolean isRegistered(Context paramContext)
  {
    int i = 0;
    if (paramContext != null);
    try
    {
      boolean bool = TextUtils.isEmpty(org.android.a.g(paramContext));
      i = 0;
      if (!bool)
        i = 1;
      return i;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  public static final void pingMessage(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null);
    try
    {
      org.android.a.d(paramContext, paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void sendAsynMtop(Context paramContext, f paramf)
  {
    try
    {
      org.android.agoo.b localb = getMtopService(paramContext);
      if (localb != null)
        localb.sendMtop(paramContext, paramf);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void sendAsynMtop(Context paramContext, f paramf, g paramg)
  {
    if (paramContext != null);
    try
    {
      org.android.agoo.b localb = getMtopService(paramContext);
      if (localb != null)
        localb.sendMtop(paramContext, paramf, paramg);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void sendSoTimeout(Context paramContext, int paramInt)
  {
    if (paramContext != null);
    try
    {
      Intent localIntent = org.android.agoo.b.a.a(paramContext, "so_manager");
      if (localIntent != null)
      {
        localIntent.putExtra("soTimeout", paramInt);
        paramContext.sendBroadcast(localIntent);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void sendSynMtop(Context paramContext, f paramf)
  {
    try
    {
      org.android.agoo.b localb = getMtopService(paramContext);
      if (localb != null)
        localb.getV3(paramContext, paramf);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void setAgooMode(Context paramContext, e parame)
  {
    if (paramContext != null);
    try
    {
      org.android.a.b(paramContext, parame.a());
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void setAutoUpdate(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null);
    try
    {
      org.android.a.c(paramContext, paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void setDebug(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext != null);
    try
    {
      org.android.a.a(paramContext, paramBoolean1, paramBoolean2);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void setServiceProtect(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null);
    try
    {
      org.android.a.e(paramContext, paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void unregister(Context paramContext)
  {
    if (paramContext != null);
    try
    {
      Intent localIntent = org.android.agoo.b.a.a(paramContext, "unregister");
      if (localIntent != null)
        paramContext.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.client.b
 * JD-Core Version:    0.6.0
 */