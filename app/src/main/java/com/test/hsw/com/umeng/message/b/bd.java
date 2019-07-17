package com.umeng.message.b;

import android.content.Intent;
import android.os.Message;

class bd
  implements Runnable
{
  bd(bc parambc, Intent paramIntent)
  {
  }

  public void run()
  {
    if (bb.a(this.b.a) != null)
    {
      Message localMessage = bb.a(this.b.a).obtainMessage();
      if ((localMessage != null) && (bb.a(this.b.a) != null))
      {
        localMessage.obj = this.a;
        bb.a(this.b.a).sendMessage(localMessage);
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.bd
 * JD-Core Version:    0.6.0
 */