package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.umeng.a.g;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.d.f;

public class AboutActivity extends AbsBaseActivity
{
  private Button a;
  private TextView b;
  private TextView c;
  private LinearLayout d;
  private LinearLayout e;
  private LinearLayout f;
  private a g;

  protected void bindData()
  {
    this.b.setText("口袋自考 (" + this.mSP.p() + ")");
  }

  protected void initData()
  {
    this.g = new a();
  }

  protected void initListener()
  {
    this.a.setOnClickListener(this.g);
    this.d.setOnClickListener(this.g);
    this.c.setOnClickListener(this.g);
    this.e.setOnClickListener(this.g);
    this.f.setOnClickListener(this.g);
  }

  protected void initView()
  {
    this.a = ((Button)findViewById(2131296369));
    this.b = ((TextView)findViewById(2131296370));
    this.d = ((LinearLayout)findViewById(2131296371));
    this.e = ((LinearLayout)findViewById(2131296372));
    this.f = ((LinearLayout)findViewById(2131296373));
    this.c = ((TextView)findViewById(2131296376));
  }

  protected void setContentView()
  {
    setContentView(2130903065);
  }

  class a
    implements View.OnClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      try
      {
        switch (paramView.getId())
        {
        case 2131296369:
          AboutActivity.this.finish();
          return;
        case 2131296371:
          g.b(AboutActivity.a(AboutActivity.this), "personal_er");
          AboutActivity.this.startNewActivity(CodeActivity.class, false, null);
          return;
        case 2131296372:
          g.b(AboutActivity.a(AboutActivity.this), "personal_weibo");
          Intent localIntent = new Intent();
          localIntent.setAction("android.intent.action.VIEW");
          localIntent.setData(Uri.parse("http://weibo.cn/kdzikao"));
          AboutActivity.this.startActivity(localIntent);
        case 2131296370:
        case 2131296373:
        case 2131296374:
        case 2131296375:
        case 2131296376:
        }
        return;
      }
      catch (Exception localException)
      {
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.AboutActivity
 * JD-Core Version:    0.6.0
 */