package com.umeng.message.b;

import android.content.Context;
import android.widget.Toast;

class ds
  implements Runnable
{
  ds(Context paramContext)
  {
  }

  public void run()
  {
    Toast.makeText(this.a, "Please add or correct UmengMessageCallbackHandlerService in AndroidManifest!", 1).show();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.ds
 * JD-Core Version:    0.6.0
 */