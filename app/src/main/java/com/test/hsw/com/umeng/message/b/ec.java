package com.umeng.message.b;

import android.content.Context;
import android.widget.Toast;

class ec
  implements Runnable
{
  ec(Context paramContext)
  {
  }

  public void run()
  {
    Toast.makeText(this.a, "Please add or correct RegistrationReceiver in AndroidManifest!", 1).show();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.ec
 * JD-Core Version:    0.6.0
 */