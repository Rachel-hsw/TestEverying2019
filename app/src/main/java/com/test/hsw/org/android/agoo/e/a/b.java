package org.android.agoo.e.a;

import android.content.Context;
import com.ta.utdid2.device.UTDevice;
import org.android.agoo.e.a;

public final class b
  implements a
{
  public final void a(int paramInt, Object paramObject)
  {
  }

  public final void a(int paramInt, Object paramObject1, Object paramObject2)
  {
  }

  public final void a(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3)
  {
  }

  public final void a(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, String[] paramArrayOfString)
  {
  }

  public final void a(Context paramContext)
  {
  }

  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
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
 * Qualified Name:     org.android.agoo.e.a.b
 * JD-Core Version:    0.6.0
 */