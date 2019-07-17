package com.umeng.socialize.view;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.umeng.socialize.utils.m;

class l
  implements View.OnClickListener
{
  l(ShareActivity paramShareActivity)
  {
  }

  public void onClick(View paramView)
  {
    if ((ShareActivity.b(this.a)) && (ShareActivity.c(this.a) != null))
    {
      if (!ShareActivity.d(this.a))
        ShareActivity.a(this.a, ShareActivity.c(this.a), "init");
      ShareActivity.a(this.a, ShareActivity.c(this.a), "onShow");
      ShareActivity.c(this.a).setVisibility(0);
    }
    do
      return;
    while ((ShareActivity.e(this.a) == null) || (ShareActivity.e(this.a).isShowing()));
    ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(ShareActivity.f(this.a).getWindowToken(), 0);
    m.b(ShareActivity.e(this.a));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.l
 * JD-Core Version:    0.6.0
 */