package com.umeng.message.b;

import android.content.Context;
import android.widget.Toast;

class ef
  implements Runnable
{
  ef(Context paramContext)
  {
  }

  public void run()
  {
    Toast.makeText(this.a, "Please replace '【应用包名】.intent.action.START' with application's packageName for UmengService in AndroidManifest!", 1).show();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.ef
 * JD-Core Version:    0.6.0
 */