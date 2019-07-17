package com.umeng.message.b;

import android.content.Context;
import android.widget.Toast;

class dx
  implements Runnable
{
  dx(Context paramContext)
  {
  }

  public void run()
  {
    Toast.makeText(this.a, "Please replace '【应用包名】.intent.action.COMMAND' with application's packageName for RegistrationReceiver in AndroidManifest!", 1).show();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.dx
 * JD-Core Version:    0.6.0
 */