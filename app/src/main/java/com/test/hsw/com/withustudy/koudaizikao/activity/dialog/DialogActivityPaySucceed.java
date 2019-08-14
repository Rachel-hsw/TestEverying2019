package com.withustudy.koudaizikao.activity.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.d.f;

public class DialogActivityPaySucceed extends AbsBaseActivity
{
  private LinearLayout a;
  private Button b;
  private Button c;
  private a d;
  private String e;
  private double f = 0.423D;
  private double g = 0.908D;

  protected void bindData()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)(this.mSP.y() * this.g), (int)(this.mSP.x() * this.f));
    this.a.setLayoutParams(localLayoutParams);
    this.b.setText(this.e);
  }

  protected void initData()
  {
    try
    {
      this.d = new a();
      this.e = getIntent().getExtras().getString("content");
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void initListener()
  {
    this.c.setOnClickListener(this.d);
    this.b.setOnClickListener(this.d);
  }

  protected void initView()
  {
    this.a = ((LinearLayout)findViewById(2131296485));
    this.c = ((Button)findViewById(2131296486));
    this.b = ((Button)findViewById(2131296487));
  }

  protected void setContentView()
  {
    setContentView(2130903080);
  }

  class a
    implements View.OnClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      default:
        return;
      case 2131296486:
        DialogActivityPaySucceed.this.setResult(0);
        DialogActivityPaySucceed.this.finish(0, 0);
        return;
      case 2131296487:
      }
      DialogActivityPaySucceed.this.setResult(1);
      DialogActivityPaySucceed.this.finish(0, 0);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.dialog.DialogActivityPaySucceed
 * JD-Core Version:    0.6.0
 */