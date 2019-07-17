package com.withustudy.koudaizikao.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.withustudy.koudaizikao.entity.VideoCourse;
import com.withustudy.koudaizikao.g.h;

class ak
  implements View.OnClickListener
{
  ak(ah paramah, VideoCourse paramVideoCourse)
  {
  }

  public void onClick(View paramView)
  {
    h.a(ah.b(this.a), "QQ服务");
    if (ah.d(this.a) != null)
      ah.d(this.a).a(this.b);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.ak
 * JD-Core Version:    0.6.0
 */