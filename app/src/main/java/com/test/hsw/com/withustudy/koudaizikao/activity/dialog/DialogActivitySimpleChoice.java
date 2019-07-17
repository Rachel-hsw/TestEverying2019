package com.withustudy.koudaizikao.activity.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.d.f;

public class DialogActivitySimpleChoice extends AbsBaseActivity
{
  public static final int a = 1;
  public static final int b;
  private LinearLayout c;
  private TextView d;
  private Button e;
  private Button f;
  private a g;
  private double h = 0.362D;
  private double i = 0.908D;
  private String j;

  protected void bindData()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)(this.mSP.y() * this.i), (int)(this.mSP.x() * this.h));
    this.c.setLayoutParams(localLayoutParams);
    this.d.setText(this.j);
  }

  protected void initData()
  {
    this.g = new a();
    this.j = getIntent().getExtras().getString("content");
  }

  protected void initListener()
  {
    this.e.setOnClickListener(this.g);
    this.f.setOnClickListener(this.g);
  }

  protected void initView()
  {
    this.c = ((LinearLayout)findViewById(2131296444));
    this.d = ((TextView)findViewById(2131296445));
    this.e = ((Button)findViewById(2131296446));
    this.f = ((Button)findViewById(2131296447));
  }

  protected void setContentView()
  {
    setContentView(2130903073);
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
      case 2131296446:
        DialogActivitySimpleChoice.this.setResult(1, null);
        DialogActivitySimpleChoice.this.finish(0, 0);
        return;
      case 2131296447:
      }
      DialogActivitySimpleChoice.this.setResult(0, null);
      DialogActivitySimpleChoice.this.finish(0, 0);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.dialog.DialogActivitySimpleChoice
 * JD-Core Version:    0.6.0
 */