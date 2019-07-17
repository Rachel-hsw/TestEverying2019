package com.umeng.socialize.view;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.umeng.socialize.common.b;
import com.umeng.socialize.utils.c;
import com.umeng.socialize.utils.m;

class p
  implements View.OnClickListener
{
  p(ShareActivity paramShareActivity)
  {
  }

  public void onClick(View paramView)
  {
    if (!c.f(this.a))
    {
      String str2 = b.a(this.a, "umeng_socialize_network_break_alert");
      Toast.makeText(this.a, str2, 1).show();
      return;
    }
    String str1 = ShareActivity.f(this.a).getText().toString();
    if ((TextUtils.isEmpty(str1.trim())) && (ShareActivity.n(this.a) == null))
    {
      Toast.makeText(this.a, "输入内容为空...", 0).show();
      return;
    }
    if (m.c(str1) > 140)
    {
      Toast.makeText(this.a, "输入内容超过140个字.", 0).show();
      return;
    }
    if (ShareActivity.o(this.a))
    {
      Toast.makeText(ShareActivity.p(this.a), "超出最大字数限制....", 0).show();
      return;
    }
    if (ShareActivity.i(this.a) == com.umeng.socialize.bean.p.g)
      ShareActivity.q(this.a);
    while (true)
    {
      this.a.finish();
      return;
      ShareActivity.r(this.a);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.p
 * JD-Core Version:    0.6.0
 */