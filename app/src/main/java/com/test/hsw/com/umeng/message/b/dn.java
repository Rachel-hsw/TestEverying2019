package com.umeng.message.b;

import android.content.Context;
import android.widget.Toast;

class dn
  implements Runnable
{
  dn(Context paramContext)
  {
  }

  public void run()
  {
    Toast.makeText(this.a, "Please add or correct UmengMessageIntentReceiverService in AndroidManifest!", 1).show();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.dn
 * JD-Core Version:    0.6.0
 */