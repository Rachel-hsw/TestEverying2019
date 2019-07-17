package com.withustudy.koudaizikao.activity.dialog;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.android.http.r;
import com.umeng.a.g;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.entity.Version;
import java.io.File;
import java.util.List;

public class DialogActivityUpdateNew extends AbsBaseActivity
{
  public static final int a = 1;
  public static final int b = 2;
  private LinearLayout c;
  private LinearLayout d;
  private LinearLayout e;
  private TextView f;
  private ProgressBar g;
  private Button h;
  private Button i;
  private FrameLayout.LayoutParams j;
  private LinearLayout.LayoutParams k;
  private b l;
  private a m;
  private Version n;
  private List<String> o;
  private File p;

  private void a()
  {
    this.d.removeAllViews();
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= this.o.size())
        return;
      TextView localTextView = new TextView(this.mContext);
      localTextView.setLayoutParams(this.k);
      localTextView.setText((CharSequence)this.o.get(i1));
      localTextView.setTextColor(Color.parseColor("#666666"));
      localTextView.setTextSize(2, 15.0F);
      this.d.addView(localTextView);
    }
  }

  private void a(int paramInt)
  {
    this.g.setVisibility(paramInt);
    this.e.setVisibility(paramInt);
  }

  protected void bindData()
  {
    this.c.setLayoutParams(this.j);
    a();
  }

  public void finish()
  {
    super.finish();
    if (r.a)
      Toast.makeText(this.mContext, "已转为后台下载，完成后会提示您安装", 0).show();
  }

  public void finish(int paramInt1, int paramInt2)
  {
    super.finish(paramInt1, paramInt2);
    if (r.a)
      Toast.makeText(this.mContext, "已转为后台下载，完成后会提示您安装", 0).show();
  }

  protected void initData()
  {
    this.l = new b();
    this.m = new a();
    this.j = new FrameLayout.LayoutParams((int)(0.89D * this.mSP.y()), (int)(0.49D * this.mSP.x()));
    this.k = new LinearLayout.LayoutParams(-1, -2);
    this.k.setMargins((int)(0.083D * this.mSP.y()), 10, 0, 0);
    this.n = ((Version)getIntent().getExtras().getSerializable("update"));
    this.o = this.n.getUpdateInfo();
  }

  protected void initListener()
  {
    this.i.setOnClickListener(this.m);
    this.h.setOnClickListener(this.m);
  }

  protected void initView()
  {
    this.c = ((LinearLayout)findViewById(2131296716));
    this.d = ((LinearLayout)findViewById(2131296717));
    this.e = ((LinearLayout)findViewById(2131296718));
    this.f = ((TextView)findViewById(2131296719));
    this.g = ((ProgressBar)findViewById(2131296720));
    this.i = ((Button)findViewById(2131296722));
    this.h = ((Button)findViewById(2131296721));
  }

  protected void setContentView()
  {
    setContentView(2130903114);
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
      case 2131296722:
        g.b(DialogActivityUpdateNew.b(DialogActivityUpdateNew.this), "personal_update");
        if (r.a)
        {
          Toast.makeText(DialogActivityUpdateNew.this, "正在下载安装包，请耐心等待", 0).show();
          return;
        }
        DialogActivityUpdateNew.a(DialogActivityUpdateNew.this, DialogActivityUpdateNew.e(DialogActivityUpdateNew.this).a("koudaizikao.apk"));
        new r(DialogActivityUpdateNew.f(DialogActivityUpdateNew.this), DialogActivityUpdateNew.a(DialogActivityUpdateNew.this)).start();
        DialogActivityUpdateNew.a(DialogActivityUpdateNew.this, 0);
        return;
      case 2131296721:
      }
      DialogActivityUpdateNew.this.finish(0, 0);
    }
  }

  class b extends Handler
  {
    b()
    {
    }

    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      default:
      case 1:
        do
          return;
        while (!DialogActivityUpdateNew.a(DialogActivityUpdateNew.this).exists());
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setDataAndType(Uri.parse("file://" + DialogActivityUpdateNew.a(DialogActivityUpdateNew.this).toString()), "application/vnd.android.package-archive");
        DialogActivityUpdateNew.b(DialogActivityUpdateNew.this).startActivity(localIntent);
        DialogActivityUpdateNew.a(DialogActivityUpdateNew.this, 8);
        DialogActivityUpdateNew.this.finish(0, 0);
        return;
      case 2:
      }
      int i = (int)(100.0D * (r.c / r.b));
      DialogActivityUpdateNew.c(DialogActivityUpdateNew.this).setProgress(i);
      DialogActivityUpdateNew.d(DialogActivityUpdateNew.this).setText(i + "%");
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.dialog.DialogActivityUpdateNew
 * JD-Core Version:    0.6.0
 */