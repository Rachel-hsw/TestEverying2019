package com.withustudy.koudaizikao.fragment;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;

class ab
  implements View.OnClickListener
{
  ab(VideoMineFragment.a parama, String paramString)
  {
  }

  public void onClick(View paramView)
  {
    ((ClipboardManager)VideoMineFragment.d(VideoMineFragment.a.a(this.a)).getSystemService("clipboard")).setText(this.b);
    VideoMineFragment.g(VideoMineFragment.a.a(this.a)).dismiss();
    VideoMineFragment.a.a(this.a).a(1.0F);
    VideoMineFragment.a(VideoMineFragment.a.a(this.a), null);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.ab
 * JD-Core Version:    0.6.0
 */