package com.umeng.socialize.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.ImageView;
import com.umeng.socialize.bean.p;

class v
  implements DialogInterface.OnClickListener
{
  v(ShareActivity paramShareActivity)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.setImageDrawable(null);
    this.a.a.setVisibility(8);
    if (ShareActivity.i(this.a) == p.g)
      ShareActivity.t(this.a);
    ShareActivity.u(this.a).setVisibility(8);
    ShareActivity.a(this.a, null);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.v
 * JD-Core Version:    0.6.0
 */