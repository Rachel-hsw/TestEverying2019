package com.withustudy.koudaizikao.activity.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.d.f;

public class DialogActivitySimple extends AbsBaseActivity
{
  private LinearLayout a;
  private TextView b;
  private TextView c;
  private double d = 0.21D;
  private double e = 0.908D;
  private a f;

  protected void bindData()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)(this.mSP.y() * this.e), (int)(this.mSP.x() * this.d));
    this.a.setLayoutParams(localLayoutParams);
    this.b.setText(getIntent().getExtras().getString("content"));
  }

  protected void initData()
  {
    this.f = new a();
  }

  protected void initListener()
  {
    this.c.setOnClickListener(this.f);
  }

  protected void initView()
  {
    this.a = ((LinearLayout)findViewById(2131296488));
    this.b = ((TextView)findViewById(2131296489));
    this.c = ((TextView)findViewById(2131296490));
  }

  protected void setContentView()
  {
    setContentView(2130903081);
  }

  class a
    implements View.OnClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      DialogActivitySimple.this.finish(0, 0);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.dialog.DialogActivitySimple
 * JD-Core Version:    0.6.0
 */