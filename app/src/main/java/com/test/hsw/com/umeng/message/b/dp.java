package com.umeng.message.b;

import android.content.Context;
import android.widget.Toast;

class dp
  implements Runnable
{
  dp(Context paramContext)
  {
  }

  public void run()
  {
    Toast.makeText(this.a, "Please set umeng appsecret!", 1).show();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.dp
 * JD-Core Version:    0.6.0
 */