package org.android.agoo.client;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class BaseBroadcastReceiver extends BroadcastReceiver
{
  protected abstract String a(Context paramContext);

  protected void a(Context paramContext, Intent paramIntent)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      a(paramContext, paramIntent);
      BaseIntentService.a(paramContext, paramIntent, a(paramContext));
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.client.BaseBroadcastReceiver
 * JD-Core Version:    0.6.0
 */