package com.withustudy.koudaizikao.activity.dialog;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.PayStatus;
import com.withustudy.koudaizikao.entity.VideoCourse;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.k;
import com.withustudy.koudaizikao.g.l;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class DialogActivityPay extends AbsBaseActivity
{
  private static final int q = 1;
  private LinearLayout a;
  private LinearLayout b;
  private LinearLayout c;
  private ImageView d;
  private ImageView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private Button i;
  private Button j;
  private a k;
  private VideoCourse l;
  private int m;
  private final int n = 1;
  private final int o = 2;
  private final double p = 0.908D;
  private Intent r;
  private LinearLayout s;
  private ImageView t;
  private TextView u;
  private String v;
  private Handler w = new a(this);
  private boolean x = false;

  private void a(int paramInt)
  {
    this.m = paramInt;
    if (this.m == 1)
    {
      this.d.setBackgroundResource(2130837727);
      this.e.setBackgroundResource(2130837728);
      return;
    }
    this.e.setBackgroundResource(2130837727);
    this.d.setBackgroundResource(2130837728);
  }

  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString2 != null) && (paramString2.length() != 0));
    for (String str = paramString1 + "\n" + paramString2; ; str = paramString1)
    {
      if ((paramString3 != null) && (paramString3.length() != 0))
        str = str + "\n" + paramString3;
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
      localBuilder.setMessage(str);
      localBuilder.setTitle("提示");
      localBuilder.setPositiveButton("OK", null);
      localBuilder.create().show();
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    float f1 = 100.0F * this.l.getPrice();
    float f2 = this.mSP.a();
    if (paramBoolean)
    {
      this.t.setBackgroundResource(2130837724);
      if (f2 >= f1)
      {
        this.h.setText("￥0");
        return;
      }
      float f3 = (f1 - f2) / 100.0F;
      this.h.setText("￥" + f3);
      return;
    }
    this.t.setBackgroundResource(2130838197);
    this.h.setText("￥" + this.l.getPrice());
  }

  protected void bindData()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)(0.908D * this.mSP.y()), -2);
    this.a.setLayoutParams(localLayoutParams);
    this.f.setText(this.l.getCourse_name());
    if (this.l.getCategory() == 0)
      this.g.setText(String.valueOf(this.l.getCourse_hour()) + "个课时");
    while (true)
    {
      this.h.setText("￥" + this.l.getPrice());
      a(1);
      float f1 = this.mSP.a();
      if (f1 == 0.0F)
        break;
      this.s.setVisibility(0);
      this.t.setBackgroundResource(2130838197);
      float f2 = this.l.getPrice();
      if (f1 >= f2 * 100.0F)
      {
        this.u.setText("使用奖学金" + f2 + "元");
        return;
        this.g.setText(String.valueOf(this.l.getVideo_num()) + "个视频");
        continue;
      }
      float f3 = f1 / 100.0F;
      this.u.setText("使用奖学金" + f3 + "元");
      return;
    }
    this.s.setVisibility(8);
  }

  protected void initData()
  {
    this.l = ((VideoCourse)getIntent().getExtras().getSerializable("class"));
    this.k = new a();
  }

  protected void initListener()
  {
    this.b.setOnClickListener(this.k);
    this.c.setOnClickListener(this.k);
    this.i.setOnClickListener(this.k);
    this.j.setOnClickListener(this.k);
    this.s.setOnClickListener(this.k);
  }

  protected void initView()
  {
    this.a = ((LinearLayout)findViewById(2131296472));
    this.s = ((LinearLayout)findViewById(2131296477));
    this.t = ((ImageView)findViewById(2131296478));
    this.u = ((TextView)findViewById(2131296479));
    this.b = ((LinearLayout)findViewById(2131296480));
    this.c = ((LinearLayout)findViewById(2131296482));
    this.e = ((ImageView)findViewById(2131296483));
    this.d = ((ImageView)findViewById(2131296481));
    this.f = ((TextView)findViewById(2131296474));
    this.g = ((TextView)findViewById(2131296475));
    this.h = ((TextView)findViewById(2131296476));
    this.i = ((Button)findViewById(2131296473));
    this.j = ((Button)findViewById(2131296484));
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      this.r = paramIntent;
      this.w.sendEmptyMessage(1);
    }
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    h.a("onSuccess    " + paramString1);
    this.mProTools.b();
    if (paramString1 != null);
    while (true)
    {
      PayStatus localPayStatus;
      float f2;
      try
      {
        localPayStatus = (PayStatus)c.a().fromJson(paramString1, PayStatus.class);
        h.a("onSuccess  ps  " + localPayStatus.toString());
        if (localPayStatus == null)
          break label413;
        h.a("onSuccess  ps != null  " + localPayStatus.toString());
        if ((localPayStatus != null) && ((localPayStatus instanceof PayStatus)))
        {
          h.a("ps instanceof PayStatus");
          String str = localPayStatus.getStatus();
          if ((str == null) || (!"success".equals(str)))
            continue;
          h.a("onSuccess  getStatus  " + localPayStatus.getStatus());
          if (!this.x)
            continue;
          f1 = 100.0F * this.l.getPrice();
          f2 = this.mSP.a();
          if (f2 < f1)
            break label452;
          h.a(getApplicationContext(), "使用奖学金成功c=" + f1);
          float f3 = f2 - f1;
          if (f3 > 0.0F)
            continue;
          f3 = 0.0F;
          h.a(getApplicationContext(), "使用奖学金成功y=" + f3);
          this.mSP.a(f3);
          Intent localIntent = new Intent("com.koudai.update_sco");
          localIntent.putExtra("isFresh", true);
          sendBroadcast(localIntent);
          setResult(1);
          finish(0, 0);
          return;
          h.a("onSuccess  status null ");
          this.v = paramString1;
          this.w.sendEmptyMessage(0);
          return;
        }
      }
      catch (Exception localException)
      {
        h.a("onSuccess  ps == Exception  " + localException.toString());
        return;
      }
      h.a("onSuccess  ps 不是PayStatus类型   " + localPayStatus.toString());
      this.v = paramString1;
      this.w.sendEmptyMessage(0);
      return;
      label413: h.a("onSuccess  ps == null  " + localPayStatus.toString());
      this.v = paramString1;
      this.w.sendEmptyMessage(0);
      return;
      label452: float f1 = f2;
    }
  }

  protected void setContentView()
  {
    setContentView(2130903079);
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
      case 2131296477:
        DialogActivityPay localDialogActivityPay5 = DialogActivityPay.this;
        boolean bool1 = DialogActivityPay.c(DialogActivityPay.this);
        boolean bool2 = false;
        if (bool1);
        while (true)
        {
          DialogActivityPay.a(localDialogActivityPay5, bool2);
          DialogActivityPay.this.a(DialogActivityPay.c(DialogActivityPay.this));
          return;
          bool2 = true;
        }
      case 2131296480:
        DialogActivityPay.a(DialogActivityPay.this, 1);
        return;
      case 2131296482:
        DialogActivityPay.a(DialogActivityPay.this, 2);
        return;
      case 2131296473:
        DialogActivityPay.this.setResult(0);
        DialogActivityPay.this.finish(0, 0);
        return;
      case 2131296484:
      }
      while (true)
      {
        float f6;
        float f3;
        try
        {
          if (DialogActivityPay.f(DialogActivityPay.this) != 1)
            continue;
          String str11 = k.b();
          try
          {
            String str20 = URLEncoder.encode(str11, "utf-8");
            str12 = str20;
            h.a("client_ip_encode =" + str12);
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException5)
          {
            try
            {
              String str19 = URLEncoder.encode(DialogActivityPay.d(DialogActivityPay.this).getCourse_name(), "utf-8");
              str13 = str19;
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException5)
            {
              try
              {
                String str18 = URLEncoder.encode(DialogActivityPay.d(DialogActivityPay.this).getIntro(), "utf-8");
                str14 = str18;
                f4 = 100.0F * DialogActivityPay.d(DialogActivityPay.this).getPrice();
                str15 = System.currentTimeMillis();
                str16 = DialogActivityPay.e(DialogActivityPay.this).i();
                str17 = DialogActivityPay.d(DialogActivityPay.this).getCourse_id();
                DialogActivityPay.g(DialogActivityPay.this).a(true);
                if (!DialogActivityPay.c(DialogActivityPay.this))
                  continue;
                f5 = 100.0F * DialogActivityPay.d(DialogActivityPay.this).getPrice();
                f6 = DialogActivityPay.e(DialogActivityPay.this).a();
                if (f6 < f5)
                  break label1231;
                h.a(DialogActivityPay.this.getApplicationContext(), "实际扣奖学金=" + f5);
                h.a("实际扣奖学金=" + f5);
                int j = (int)f5;
                com.withustudy.koudaizikao.a.a locala4 = c.b().ax();
                DialogActivityPay localDialogActivityPay4 = DialogActivityPay.this;
                String[] arrayOfString4 = new String[9];
                arrayOfString4[0] = str12;
                arrayOfString4[1] = str13;
                arrayOfString4[2] = str14;
                arrayOfString4[3] = "alipay";
                arrayOfString4[4] = f4;
                arrayOfString4[5] = str15;
                arrayOfString4[6] = str16;
                arrayOfString4[7] = str17;
                arrayOfString4[8] = j;
                locala4.a(localDialogActivityPay4, arrayOfString4, 0, DialogActivityPay.h(DialogActivityPay.this));
                return;
                localUnsupportedEncodingException4 = localUnsupportedEncodingException4;
                localUnsupportedEncodingException4.printStackTrace();
                str12 = "";
                continue;
                localUnsupportedEncodingException5 = localUnsupportedEncodingException5;
                localUnsupportedEncodingException5.printStackTrace();
                str13 = "";
                continue;
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException6)
              {
                String str12;
                String str13;
                float f4;
                String str15;
                String str16;
                String str17;
                localUnsupportedEncodingException6.printStackTrace();
                String str14 = "";
                continue;
                com.withustudy.koudaizikao.a.a locala3 = c.b().ax();
                DialogActivityPay localDialogActivityPay3 = DialogActivityPay.this;
                String[] arrayOfString3 = new String[8];
                arrayOfString3[0] = str12;
                arrayOfString3[1] = str13;
                arrayOfString3[2] = str14;
                arrayOfString3[3] = "alipay";
                arrayOfString3[4] = f4;
                arrayOfString3[5] = str15;
                arrayOfString3[6] = str16;
                arrayOfString3[7] = str17;
                locala3.a(localDialogActivityPay3, arrayOfString3, 0, DialogActivityPay.h(DialogActivityPay.this));
                return;
              }
            }
          }
          if (DialogActivityPay.f(DialogActivityPay.this) != 2)
            break;
          String str1 = k.b();
          try
          {
            String str10 = URLEncoder.encode(str1, "utf-8");
            str2 = str10;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException2)
          {
            try
            {
              String str9 = URLEncoder.encode(DialogActivityPay.d(DialogActivityPay.this).getCourse_name(), "utf-8");
              str3 = str9;
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException2)
            {
              try
              {
                String str8 = URLEncoder.encode(DialogActivityPay.d(DialogActivityPay.this).getIntro(), "utf-8");
                str4 = str8;
                f1 = 100.0F * DialogActivityPay.d(DialogActivityPay.this).getPrice();
                str5 = System.currentTimeMillis();
                str6 = DialogActivityPay.e(DialogActivityPay.this).i();
                str7 = DialogActivityPay.d(DialogActivityPay.this).getCourse_id();
                DialogActivityPay.g(DialogActivityPay.this).a(true);
                if (!DialogActivityPay.c(DialogActivityPay.this))
                  continue;
                f2 = 100.0F * DialogActivityPay.d(DialogActivityPay.this).getPrice();
                f3 = DialogActivityPay.e(DialogActivityPay.this).a();
                (int)(1.0D * f3 / 100.0D);
                if (f3 < f2)
                  break label1238;
                h.a(DialogActivityPay.this.getApplicationContext(), "实际扣奖学金=" + f2);
                int i = (int)f2;
                com.withustudy.koudaizikao.a.a locala2 = c.b().ax();
                DialogActivityPay localDialogActivityPay2 = DialogActivityPay.this;
                String[] arrayOfString2 = new String[9];
                arrayOfString2[0] = str2;
                arrayOfString2[1] = str3;
                arrayOfString2[2] = str4;
                arrayOfString2[3] = "wx";
                arrayOfString2[4] = f1;
                arrayOfString2[5] = str5;
                arrayOfString2[6] = str6;
                arrayOfString2[7] = str7;
                arrayOfString2[8] = i;
                locala2.a(localDialogActivityPay2, arrayOfString2, 0, DialogActivityPay.this);
                return;
                localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
                localUnsupportedEncodingException1.printStackTrace();
                str2 = "";
                continue;
                localUnsupportedEncodingException2 = localUnsupportedEncodingException2;
                localUnsupportedEncodingException2.printStackTrace();
                str3 = "";
                continue;
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException3)
              {
                String str2;
                String str3;
                float f1;
                String str5;
                String str6;
                String str7;
                localUnsupportedEncodingException3.printStackTrace();
                String str4 = "";
                continue;
                com.withustudy.koudaizikao.a.a locala1 = c.b().ax();
                DialogActivityPay localDialogActivityPay1 = DialogActivityPay.this;
                String[] arrayOfString1 = new String[8];
                arrayOfString1[0] = str2;
                arrayOfString1[1] = str3;
                arrayOfString1[2] = str4;
                arrayOfString1[3] = "wx";
                arrayOfString1[4] = f1;
                arrayOfString1[5] = str5;
                arrayOfString1[6] = str6;
                arrayOfString1[7] = str7;
                locala1.a(localDialogActivityPay1, arrayOfString1, 0, DialogActivityPay.this);
                return;
              }
            }
          }
        }
        catch (Exception localException)
        {
          return;
        }
        label1231: float f5 = f6;
        continue;
        label1238: float f2 = f3;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.dialog.DialogActivityPay
 * JD-Core Version:    0.6.0
 */