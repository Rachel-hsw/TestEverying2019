package com.umeng.socialize.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.umeng.socialize.bean.aw;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.utils.c;

class am
  implements View.OnClickListener
{
  am(al paramal, aw paramaw)
  {
  }

  public void onClick(View paramView)
  {
    this.b.b.dismiss();
    p localp = p.a(this.a.a);
    if ((!c.f(ak.a(this.b.b))) && (localp != p.c))
    {
      Toast.makeText(ak.a(this.b.b), "您的网络不可用,请检查网络连接...", 0).show();
      return;
    }
    al.a(this.b, this.a, localp);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.am
 * JD-Core Version:    0.6.0
 */