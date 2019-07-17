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
import java.util.Timer;

public class DialogActivitySimpleSucceed extends AbsBaseActivity
{
  private LinearLayout a;
  private TextView b;
  private Timer c;
  private a d;
  private final double e = 0.85D;
  private final double f = 0.273D;

  private void a()
  {
    this.c = new Timer();
    this.c.schedule(new b(this), 1000L);
  }

  protected void bindData()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)(0.85D * this.mSP.y()), (int)(0.273D * this.mSP.x()));
    this.a.setLayoutParams(localLayoutParams);
    String str = getIntent().getExtras().getString("content");
    this.b.setText(str);
    if (str.equals("删除成功"))
      a();
  }

  protected void initData()
  {
    this.d = new a();
  }

  protected void initListener()
  {
    this.a.setOnClickListener(this.d);
  }

  protected void initView()
  {
    this.a = ((LinearLayout)findViewById(2131296491));
    this.b = ((TextView)findViewById(2131296492));
  }

  protected void setContentView()
  {
    setContentView(2130903082);
  }

  class a
    implements View.OnClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      DialogActivitySimpleSucceed.this.finish(0, 0);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.dialog.DialogActivitySimpleSucceed
 * JD-Core Version:    0.6.0
 */