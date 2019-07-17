package com.withustudy.koudaizikao.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.LoginActivity;
import com.withustudy.koudaizikao.activity.MainActivity;
import com.withustudy.koudaizikao.activity.ReSetPasswordActivity;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.LoginBean;
import com.withustudy.koudaizikao.entity.req.Login;
import com.withustudy.koudaizikao.g.i;
import com.withustudy.koudaizikao.g.l;
import java.util.Map;

public class LoginFragment extends AbsBaseFragment
{
  public static final int a = 2;
  public static final int b = 5;
  public static final int c = 6;
  public static final int d = 60;
  public static final int e = 13;
  public static final int f = 14;
  public static final int g;
  private TextView h;
  private TextView i;
  private Button j;
  private EditText k;
  private EditText l;
  private a m;
  private b n;
  private InputMethodManager o;
  private LoginActivity p;
  private boolean q = false;

  public LoginFragment()
  {
  }

  public LoginFragment(LoginActivity paramLoginActivity)
  {
    this.p = paramLoginActivity;
  }

  private void d()
  {
    try
    {
      String str1 = this.k.getText().toString().trim();
      String str2 = this.l.getText().toString().trim();
      if (com.withustudy.koudaizikao.g.n.i(str1))
      {
        if ((str2 != null) && (!str2.equals("")))
        {
          switch (com.withustudy.koudaizikao.g.n.b(this.y))
          {
          default:
            Toast.makeText(this.y, "当前没有网络", 0).show();
            return;
          case 1:
          case 2:
          case 3:
          }
          Login localLogin = new Login();
          localLogin.setVersionName(this.E.p());
          localLogin.setClientType(com.withustudy.koudaizikao.g.n.a());
          localLogin.setImei(com.withustudy.koudaizikao.g.n.d(this.y));
          localLogin.setNet(com.withustudy.koudaizikao.g.n.c(this.y));
          localLogin.setPhoneNumber(str1);
          localLogin.setPassWord(i.a(str2));
          localLogin.setAccountType("INNER_TYPE");
          this.B.a("正在登录");
          c.b().d().a(this, localLogin, 0);
          return;
        }
        Toast.makeText(this.y, "请输入密码", 0).show();
        return;
      }
      Toast.makeText(this.y, "手机号非法输入", 0).show();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903231, null);
  }

  public void a()
  {
    this.m = new a();
    this.n = new b(this);
    this.o = ((InputMethodManager)this.y.getSystemService("input_method"));
  }

  public void a(View paramView)
  {
    this.j = ((Button)paramView.findViewById(2131297416));
    this.k = ((EditText)paramView.findViewById(2131297412));
    this.l = ((EditText)paramView.findViewById(2131297413));
    this.h = ((TextView)paramView.findViewById(2131297414));
    this.i = ((TextView)paramView.findViewById(2131297415));
  }

  public void b()
  {
  }

  public void c()
  {
    this.j.setOnClickListener(this.m);
    this.h.setOnClickListener(this.m);
    this.i.setOnClickListener(this.m);
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      super.onError(paramString1, paramString2, paramInt);
      this.B.b();
      this.n.sendEmptyMessage(6);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.B.b();
    switch (paramInt)
    {
    default:
    case 0:
    }
    LoginBean localLoginBean;
    while (true)
    {
      return;
      try
      {
        localLoginBean = (LoginBean)c.a().fromJson(paramString1, LoginBean.class);
        if (localLoginBean == null)
          break label171;
        if (!localLoginBean.getState().equals("STATE_OK"))
          break;
        if (this.q)
          continue;
        this.q = true;
        this.n.sendMessage(this.n.obtainMessage(2, localLoginBean));
        return;
      }
      catch (Exception localException)
      {
        this.n.sendEmptyMessage(14);
        return;
      }
    }
    if (localLoginBean.getState().equals("STATE_USER_NOT_EXIST"))
    {
      this.n.sendMessage(this.n.obtainMessage(5, Integer.valueOf(1)));
      return;
    }
    this.n.sendMessage(this.n.obtainMessage(5, Integer.valueOf(2)));
    return;
    label171: this.n.sendEmptyMessage(13);
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
        case 2131297416:
          LoginFragment.f(LoginFragment.this).sendEmptyMessageDelayed(60, 200L);
          LoginFragment.g(LoginFragment.this);
          return;
        case 2131297414:
          LoginFragment.a(LoginFragment.this, ReSetPasswordActivity.class, false, null);
          return;
        case 2131297415:
          LoginFragment.h(LoginFragment.this).a(1);
        }
        return;
      }
      catch (Exception localException)
      {
      }
    }
  }

  private static class b extends com.withustudy.koudaizikao.base.n<LoginFragment>
  {
    public b(LoginFragment paramLoginFragment)
    {
      super();
    }

    protected void a(LoginFragment paramLoginFragment, Message paramMessage)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 2:
          LoginBean localLoginBean = (LoginBean)paramMessage.obj;
          LoginFragment.a(paramLoginFragment).d(localLoginBean.getUid());
          LoginFragment.a(paramLoginFragment).i(LoginFragment.b(paramLoginFragment).getText().toString().trim());
          LoginFragment.a(paramLoginFragment).j(LoginFragment.c(paramLoginFragment).getText().toString().trim());
          LoginFragment.a(paramLoginFragment, MainActivity.class, true, null);
          return;
        case 5:
          Toast.makeText(LoginFragment.d(paramLoginFragment), "用户名或密码错", 0).show();
          return;
        case 13:
          Toast.makeText(LoginFragment.d(paramLoginFragment), "服务器未能返回数据，请稍后再试", 0).show();
          return;
        case 14:
          Toast.makeText(LoginFragment.d(paramLoginFragment), "服务器未响应，请稍后再试", 0).show();
          return;
        case 60:
          try
          {
            if (LoginFragment.e(paramLoginFragment) != null)
            {
              LoginFragment.e(paramLoginFragment).hideSoftInputFromWindow(((Activity)LoginFragment.d(paramLoginFragment)).getCurrentFocus().getWindowToken(), 2);
              return;
            }
          }
          catch (Exception localException2)
          {
          }
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
 * Qualified Name:     com.withustudy.koudaizikao.fragment.LoginFragment
 * JD-Core Version:    0.6.0
 */