package org.android.agoo;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import org.android.agoo.a.b;

public abstract interface d
{
  public abstract IBinder bind(Intent paramIntent);

  public abstract void create(Context paramContext, b paramb);

  public abstract void destroy(Context paramContext);

  public abstract int startCommand(Intent paramIntent, int paramInt1, int paramInt2);

  public abstract boolean unbind(Intent paramIntent);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.d
 * JD-Core Version:    0.6.0
 */