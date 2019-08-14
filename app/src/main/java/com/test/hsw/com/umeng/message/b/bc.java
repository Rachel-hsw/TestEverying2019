package com.umeng.message.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

class bc extends BroadcastReceiver
{
  bc(bb parambb)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      Intent localIntent = new Intent();
      if (isOrderedBroadcast())
      {
        Bundle localBundle = getResultExtras(true);
        if (localBundle != null)
        {
          localIntent.putExtras(localBundle);
          setResultExtras(null);
        }
      }
      if (paramIntent.getExtras() != null)
        localIntent.putExtras(paramIntent.getExtras());
      String str = paramIntent.getPackage();
      if (!TextUtils.isEmpty(str))
        localIntent.setPackage(str);
      if (!TextUtils.isEmpty(paramIntent.getAction()))
        localIntent.setAction(paramIntent.getAction());
      cp.a(new bd(this, localIntent));
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.d("AbsMessage", "taskBroadcastReceiver onReceive error=" + localThrowable);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.bc
 * JD-Core Version:    0.6.0
 */