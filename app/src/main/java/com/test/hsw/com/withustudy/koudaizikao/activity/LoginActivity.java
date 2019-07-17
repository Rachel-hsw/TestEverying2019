package com.withustudy.koudaizikao.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.umeng.a.g;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.sso.v;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.base.m;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.LoginBean;
import com.withustudy.koudaizikao.entity.req.Login;
import com.withustudy.koudaizikao.entity.req.LoginThird;
import com.withustudy.koudaizikao.fragment.LoginFragment;
import com.withustudy.koudaizikao.fragment.RegisterFragment;
import com.withustudy.koudaizikao.g.i;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.util.Map;

public class LoginActivity extends AbsBaseActivity
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 8;
  public static final int h = 9;
  private TextView i;
  private ImageButton j;
  private ImageButton k;
  private ImageButton l;
  private ScrollView m;
  private LoginFragment n;
  private RegisterFragment o;
  private InputMethodManager p;
  private String q = "";
  private String r = "";
  private String s = "";
  private String t = "";
  private b u;
  private a v;
  private boolean w = false;

  private void a()
  {
    try
    {
      if (!this.mSP.i().equals(""))
      {
        if ((!this.mSP.m().equals("")) && (!this.mSP.n().equals("")))
        {
          this.mProTools.a("正在登录");
          Login localLogin = new Login();
          localLogin.setClientType(n.a());
          localLogin.setImei(n.d(this.mContext));
          localLogin.setNet(n.c(this.mContext));
          localLogin.setVersionName(this.mSP.p());
          localLogin.setPhoneNumber(this.mSP.m());
          localLogin.setPassWord(i.a(this.mSP.n()));
          localLogin.setAccountType("INNER_TYPE");
          c.b().d().a(this, localLogin, 9);
          return;
        }
        if ((!this.mSP.A().equals("")) && (!this.mSP.B().equals("")))
        {
          this.mProTools.a("正在登录");
          LoginThird localLoginThird = new LoginThird();
          localLoginThird.setVersionName(this.mSP.p());
          localLoginThird.setClientType(n.a());
          localLoginThird.setImei(n.d(this.mContext));
          localLoginThird.setNet(n.c(this.mContext));
          localLoginThird.setAccountType(this.mSP.B());
          localLoginThird.setThirdPartyToken(this.mSP.A());
          localLoginThird.setNickname(this.mSP.v());
          localLoginThird.setProfileUrl(this.mSP.u());
          c.b().d().a(this, localLoginThird, 9);
          return;
        }
      }
    }
    catch (Exception localException)
    {
    }
  }

  private void a(p paramp)
  {
    try
    {
      this.mController.a(this, paramp, new al(this));
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void b(p paramp)
  {
    try
    {
      this.mController.a(this, paramp, new am(this));
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void a(int paramInt)
  {
    FragmentTransaction localFragmentTransaction = this.mFragmentManager.beginTransaction();
    if (paramInt == 0)
    {
      this.i.setText("登录");
      localFragmentTransaction.replace(2131296567, this.n).commit();
      return;
    }
    this.i.setText("新用户注册");
    localFragmentTransaction.replace(2131296567, this.o).commit();
  }

  protected void bindData()
  {
    try
    {
      String str = getIntent().getStringExtra("flag");
      if (str.equals("0"))
        a(0);
      if (str.equals("1"))
        a(1);
      a();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void initData()
  {
    try
    {
      this.u = new b(this);
      this.v = new a();
      this.n = new LoginFragment(this);
      this.o = new RegisterFragment(this);
      this.p = ((InputMethodManager)this.mContext.getSystemService("input_method"));
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void initListener()
  {
    try
    {
      this.l.setOnClickListener(this.v);
      this.j.setOnClickListener(this.v);
      this.k.setOnClickListener(this.v);
      this.m.setOnTouchListener(this.v);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void initView()
  {
    this.i = ((TextView)findViewById(2131296401));
    this.j = ((ImageButton)findViewById(2131296570));
    this.k = ((ImageButton)findViewById(2131296569));
    this.l = ((ImageButton)findViewById(2131296568));
    this.m = ((ScrollView)findViewById(2131296566));
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    try
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      v localv = ax.b().a(paramInt1);
      if (localv != null)
        localv.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.mProTools.b();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      super.onError(paramString1, paramString2, paramInt);
      this.u.sendEmptyMessage(6);
      this.u.sendEmptyMessage(2);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.u.sendEmptyMessage(6);
    if (paramString1 != null);
    switch (paramInt)
    {
    default:
    case 8:
      while (true)
      {
        return;
        try
        {
          LoginBean localLoginBean2 = (LoginBean)c.a().fromJson(paramString1, LoginBean.class);
          if ((localLoginBean2 == null) || (!localLoginBean2.getState().equals("STATE_OK")))
            break;
          if (this.w)
            continue;
          this.w = true;
          this.u.sendMessage(this.u.obtainMessage(3, localLoginBean2));
          return;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          this.u.sendEmptyMessage(2);
          return;
        }
      }
      this.u.sendEmptyMessage(2);
      return;
    case 9:
    }
    try
    {
      LoginBean localLoginBean1 = (LoginBean)c.a().fromJson(paramString1, LoginBean.class);
      if ((localLoginBean1 != null) && (localLoginBean1.getState().equals("STATE_OK")))
      {
        this.u.sendEmptyMessage(4);
        return;
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      this.u.sendEmptyMessage(2);
      return;
    }
    this.u.sendEmptyMessage(2);
  }

  protected void setContentView()
  {
    setContentView(2130903091);
  }

  class a
    implements View.OnClickListener, View.OnTouchListener
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
        case 2131296568:
          g.b(LoginActivity.g(LoginActivity.this), "third_weibo");
          LoginActivity.h(LoginActivity.this).a("正在登录");
          LoginActivity.a(LoginActivity.this, "WEIBO_TYPE");
          LoginActivity.a(LoginActivity.this, p.e);
          return;
        case 2131296570:
          g.b(LoginActivity.g(LoginActivity.this), "third_weixin");
          LoginActivity.h(LoginActivity.this).a("正在登录");
          LoginActivity.a(LoginActivity.this, "WEIXIN_TYPE");
          LoginActivity.a(LoginActivity.this, p.i);
          return;
        case 2131296569:
          g.b(LoginActivity.g(LoginActivity.this), "third_qq");
          LoginActivity.h(LoginActivity.this).a("正在登录");
          LoginActivity.a(LoginActivity.this, "QQ_TYPE");
          LoginActivity.a(LoginActivity.this, p.g);
        }
        return;
      }
      catch (Exception localException)
      {
      }
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      LoginActivity.i(LoginActivity.this).sendEmptyMessage(1);
      return false;
    }
  }

  private static class b extends m<LoginActivity>
  {
    public b(LoginActivity paramLoginActivity)
    {
      super();
    }

    protected void a(LoginActivity paramLoginActivity, Message paramMessage)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 2:
          Toast.makeText(paramLoginActivity, "服务器未响应，请稍后再试", 0).show();
          return;
        case 3:
          LoginBean localLoginBean = (LoginBean)paramMessage.obj;
          if ("STATE_OK".equals(localLoginBean.getState()))
          {
            LoginActivity.a(paramLoginActivity).d(localLoginBean.getUid());
            LoginActivity.a(paramLoginActivity).s(LoginActivity.b(paramLoginActivity));
            LoginActivity.a(paramLoginActivity).t(LoginActivity.c(paramLoginActivity));
            LoginActivity.a(paramLoginActivity).r(LoginActivity.d(paramLoginActivity));
            LoginActivity.a(paramLoginActivity).q(LoginActivity.e(paramLoginActivity));
            paramLoginActivity.startNewActivity(MainActivity.class, true, null);
            return;
          }
        case 4:
          paramLoginActivity.startNewActivity(MainActivity.class, true, null);
          return;
        case 1:
          try
          {
            LoginActivity.f(paramLoginActivity).hideSoftInputFromWindow(paramLoginActivity.getCurrentFocus().getWindowToken(), 2);
            return;
          }
          catch (Exception localException2)
          {
            return;
          }
        case 5:
          Toast.makeText(LoginActivity.g(paramLoginActivity), (String)paramMessage.obj, 0).show();
          return;
        case 6:
          LoginActivity.h(paramLoginActivity).b();
        }
        return;
      }
      catch (Exception localException1)
      {
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.LoginActivity
 * JD-Core Version:    0.6.0
 */