package com.withustudy.koudaizikao.fragment;

import android.widget.PopupWindow.OnDismissListener;
import com.withustudy.koudaizikao.g.h;

class ad
  implements PopupWindow.OnDismissListener
{
  ad(VideoMineFragment.a parama)
  {
  }

  public void onDismiss()
  {
    h.a(VideoMineFragment.d(VideoMineFragment.a.a(this.a)), "onDismiss");
    VideoMineFragment.a.a(this.a).a(1.0F);
    VideoMineFragment.a(VideoMineFragment.a.a(this.a), null);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.ad
 * JD-Core Version:    0.6.0
 */