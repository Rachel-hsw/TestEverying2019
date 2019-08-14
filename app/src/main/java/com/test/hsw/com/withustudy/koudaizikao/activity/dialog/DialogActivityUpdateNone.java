package com.withustudy.koudaizikao.activity.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.d.f;

public class DialogActivityUpdateNone extends AbsBaseActivity
{
  private LinearLayout a;
  private Button b;
  private a c;

  protected void bindData()
  {
  }

  protected void initData()
  {
    this.c = new a();
  }

  protected void initListener()
  {
    this.b.setOnClickListener(this.c);
  }

  protected void initView()
  {
    this.a = ((LinearLayout)findViewById(2131296723));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)(0.89D * this.mSP.y()), (int)(0.49D * this.mSP.x()));
    this.a.setLayoutParams(localLayoutParams);
    this.b = ((Button)findViewById(2131296724));
  }

  protected void setContentView()
  {
    setContentView(2130903115);
  }

  class a
    implements View.OnClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      DialogActivityUpdateNone.this.finish(0, 0);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.dialog.DialogActivityUpdateNone
 * JD-Core Version:    0.6.0
 */