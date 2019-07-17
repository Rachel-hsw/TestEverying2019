package com.umeng.socialize.view;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.umeng.socialize.common.b.a;
import com.umeng.socialize.view.abs.SocialPopupDialog.a;

class b extends SocialPopupDialog.a
{
  b(a parama, Context paramContext1, Context paramContext2)
  {
    super(paramContext1);
  }

  public void a(View paramView)
  {
    paramView.findViewById(com.umeng.socialize.common.b.a(this.a, b.a.b, "umeng_socialize_title_bar_leftBt")).setOnClickListener(new c(this));
    paramView.findViewById(com.umeng.socialize.common.b.a(this.a, b.a.b, "umeng_socialize_title_bar_rightBt")).setVisibility(8);
    ((Button)paramView.findViewById(com.umeng.socialize.common.b.a(this.a, b.a.b, "umeng_socialize_title_bar_leftBt"))).setBackgroundResource(com.umeng.socialize.common.b.a(this.a, b.a.c, "umeng_socialize_action_back"));
    ((TextView)paramView.findViewById(com.umeng.socialize.common.b.a(this.a, b.a.b, "umeng_socialize_title_bar_middleTv"))).setText(com.umeng.socialize.common.b.a(this.a, b.a.e, "umeng_socialize_login"));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.b
 * JD-Core Version:    0.6.0
 */