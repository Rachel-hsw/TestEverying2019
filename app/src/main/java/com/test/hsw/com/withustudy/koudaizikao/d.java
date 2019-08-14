package com.withustudy.koudaizikao;

import android.content.Context;
import android.widget.Toast;
import com.umeng.message.UTrack;
import com.umeng.message.a.a;

class d
  implements Runnable
{
  d(c paramc, a parama, Context paramContext)
  {
  }

  public void run()
  {
    UTrack.getInstance(c.a(this.a).getApplicationContext()).trackMsgClick(this.b);
    Toast.makeText(this.c, this.b.u, 1).show();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.d
 * JD-Core Version:    0.6.0
 */