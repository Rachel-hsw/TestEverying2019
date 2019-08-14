package com.withustudy.koudaizikao.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.umeng.a.g;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.custom.a.a;

public class CodeActivity extends AbsBaseActivity
{
  private Button a;
  private Button b;
  private LinearLayout c;
  private a d;
  private a e;

  protected void bindData()
  {
  }

  protected void initData()
  {
    this.d = new a();
  }

  protected void initListener()
  {
    this.a.setOnClickListener(this.d);
    this.b.setOnClickListener(this.d);
  }

  protected void initView()
  {
    this.a = ((Button)findViewById(2131296461));
    this.b = ((Button)findViewById(2131296462));
    this.c = ((LinearLayout)findViewById(2131296463));
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.e != null)
    {
      this.e.c();
      this.e = null;
    }
  }

  protected void setContentView()
  {
    setContentView(2130903077);
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
      case 2131296461:
        CodeActivity.this.finish();
        return;
      case 2131296462:
      }
      g.b(CodeActivity.a(CodeActivity.this), "personal_share");
      CodeActivity.a(CodeActivity.this, new a(CodeActivity.this, CodeActivity.b(CodeActivity.this)));
      CodeActivity.c(CodeActivity.this).b();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.CodeActivity
 * JD-Core Version:    0.6.0
 */