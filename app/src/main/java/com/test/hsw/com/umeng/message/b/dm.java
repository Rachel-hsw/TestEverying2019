package com.umeng.message.b;

import android.content.Context;
import android.widget.Toast;

class dm
  implements Runnable
{
  dm(Context paramContext)
  {
  }

  public void run()
  {
    Toast.makeText(this.a, "Please set umeng appkey!", 1).show();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.dm
 * JD-Core Version:    0.6.0
 */