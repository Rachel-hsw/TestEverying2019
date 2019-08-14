package org.android.agoo.e.a;

import android.content.Context;
import android.text.TextUtils;
import com.ta.utdid2.device.UTDevice;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTTracker;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;
import com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;

public final class c
  implements org.android.agoo.e.a
{
  public static String a(Object paramObject)
  {
    if (paramObject != null)
    {
      if ((paramObject instanceof String))
        return ((String)paramObject).toString();
      if ((paramObject instanceof Integer))
        return "" + ((Integer)paramObject).intValue();
      if ((paramObject instanceof Long))
        return "" + ((Long)paramObject).longValue();
      if ((paramObject instanceof Double))
        return "" + ((Double)paramObject).doubleValue();
      if ((paramObject instanceof Float))
        return "" + ((Float)paramObject).floatValue();
      if ((paramObject instanceof Short))
        return "" + ((Short)paramObject).shortValue();
      if ((paramObject instanceof Byte))
        return "" + ((Byte)paramObject).byteValue();
      if ((paramObject instanceof Boolean))
        return ((Boolean)paramObject).toString();
      if ((paramObject instanceof Character))
        return ((Character)paramObject).toString();
      return paramObject.toString();
    }
    return "";
  }

  private String a(String[] paramArrayOfString)
  {
    int i = 0;
    if ((paramArrayOfString != null) && (paramArrayOfString.length == 0))
      return null;
    StringBuffer localStringBuffer = new StringBuffer();
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int j = 0;
      while (i < paramArrayOfString.length)
      {
        if (!TextUtils.isEmpty(paramArrayOfString[i]))
        {
          if (j != 0)
            localStringBuffer.append(",");
          localStringBuffer.append(paramArrayOfString[i]);
          j = 1;
        }
        i++;
      }
    }
    return localStringBuffer.toString();
  }

  public final void a(int paramInt, Object paramObject)
  {
    try
    {
      UTOriginalCustomHitBuilder localUTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder("Agoo", paramInt, a(paramObject), null, null, null);
      UTAnalytics.getInstance().getTracker("agoo").send(localUTOriginalCustomHitBuilder.build());
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final void a(int paramInt, Object paramObject1, Object paramObject2)
  {
    try
    {
      UTOriginalCustomHitBuilder localUTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder("Agoo", paramInt, a(paramObject1), a(paramObject2), null, null);
      UTAnalytics.getInstance().getTracker("agoo").send(localUTOriginalCustomHitBuilder.build());
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final void a(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    try
    {
      UTOriginalCustomHitBuilder localUTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder("Agoo", paramInt, a(paramObject1), a(paramObject2), a(paramObject3), null);
      UTAnalytics.getInstance().getTracker("agoo").send(localUTOriginalCustomHitBuilder.build());
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final void a(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, String[] paramArrayOfString)
  {
    try
    {
      UTOriginalCustomHitBuilder localUTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder("Agoo", paramInt, a(paramObject1), a(paramObject2), a(paramObject3), null);
      localUTOriginalCustomHitBuilder.setProperty("_field_args", a(paramArrayOfString));
      UTAnalytics.getInstance().getTracker("agoo").send(localUTOriginalCustomHitBuilder.build());
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final void a(Context paramContext)
  {
  }

  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      UTAnalytics.getInstance().setContext(paramContext);
      UTAnalytics.getInstance().setChannel(paramString3);
      UTAnalytics.getInstance().turnOffCrashHandler();
      if (TextUtils.isEmpty(paramString2))
        paramString2 = "test";
      if (org.android.a.n(paramContext))
      {
        UTAnalytics.getInstance().setRequestAuthentication(new UTSecuritySDKRequestAuthentication(paramString1));
        return;
      }
      UTAnalytics.getInstance().setRequestAuthentication(new UTBaseRequestAuthentication(paramString1, paramString2));
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final void a(Throwable paramThrowable)
  {
  }

  public final String b(Context paramContext)
  {
    try
    {
      String str = UTDevice.getUtdid(paramContext);
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.e.a.c
 * JD-Core Version:    0.6.0
 */