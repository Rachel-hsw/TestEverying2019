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
import com.withustudy.koudaizikao.a.b.ab;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.LoginActivity;
import com.withustudy.koudaizikao.activity.MainActivity;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.AuthCodeBean;
import com.withustudy.koudaizikao.entity.RegistBean;
import com.withustudy.koudaizikao.entity.req.Regist;
import com.withustudy.koudaizikao.g.i;
import java.util.Map;

public class RegisterFragment extends AbsBaseFragment
{
  public static final int a = 1;
  public static final int b = 3;
  public static final int c = 4;
  public static final int d = 6;
  public static final int e = 60;
  public static final int f = 13;
  public static final int g = 14;
  public static final int h = 15;
  public static final int i = 16;
  public static final int j = 10;
  public static final int k = 11;
  private Button l;
  private EditText m;
  private EditText n;
  private EditText o;
  private EditText p;
  private Button q;
  private TextView r;
  private a s;
  private b t;
  private InputMethodManager u;
  private LoginActivity v;
  private boolean w = false;

  public RegisterFragment()
  {
  }

  public RegisterFragment(LoginActivity paramLoginActivity)
  {
    this.v = paramLoginActivity;
  }

  private void d()
  {
    String str = this.m.getText().toString().trim();
    if (com.withustudy.koudaizikao.g.n.i(str))
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
      this.B.a("正在获取验证码");
      c.b().j().a(this, new String[] { str, "NEW_USER" }, 10, this.y);
      return;
    }
    Toast.makeText(this.y, "手机号非法输入", 0).show();
  }

  private void e()
  {
    String str1 = this.m.getText().toString().trim();
    if (com.withustudy.koudaizikao.g.n.i(str1))
    {
      String str2 = this.n.getText().toString().trim();
      if ((str2 != null) && (!str2.equals("")))
      {
        if (!this.p.getText().toString().equals(""))
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
          Regist localRegist = new Regist();
          localRegist.setVersionName(this.E.p());
          localRegist.setClientType(com.withustudy.koudaizikao.g.n.a());
          localRegist.setImei(com.withustudy.koudaizikao.g.n.d(this.y));
          localRegist.setNet(com.withustudy.koudaizikao.g.n.c(this.y));
          localRegist.setAuthCode(str2);
          localRegist.setPhoneNumber(str1);
          localRegist.setAccountType("INNER_TYPE");
          localRegist.setPassWord(i.a(this.o.getText().toString().trim()));
          localRegist.setNickname(this.p.getText().toString().trim());
          localRegist.setRegisterChannel(com.withustudy.koudaizikao.d.a.e);
          this.B.a("正在注册");
          c.b().i().a(this, localRegist, 11);
          return;
        }
        Toast.makeText(this.y, "请输入一个昵称", 0).show();
        return;
      }
      Toast.makeText(this.y, "请输入验证码", 0).show();
      return;
    }
    Toast.makeText(this.y, "手机号非法输入", 0).show();
  }

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903259, null);
  }

  public void a()
  {
    this.s = new a();
    this.t = new b(this);
    this.u = ((InputMethodManager)this.y.getSystemService("input_method"));
  }

  public void a(View paramView)
  {
    this.l = ((Button)paramView.findViewById(2131297484));
    this.m = ((EditText)paramView.findViewById(2131297478));
    this.q = ((Button)paramView.findViewById(2131297479));
    this.n = ((EditText)paramView.findViewById(2131297480));
    this.o = ((EditText)paramView.findViewById(2131297481));
    this.p = ((EditText)paramView.findViewById(2131297482));
    this.r = ((TextView)paramView.findViewById(2131297483));
  }

  public void b()
  {
  }

  public void c()
  {
    this.q.setOnClickListener(this.s);
    this.r.setOnClickListener(this.s);
    this.l.setOnClickListener(this.s);
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    this.B.b();
    this.t.sendEmptyMessage(6);
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.B.b();
    switch (paramInt)
    {
    default:
    case 10:
    case 11:
    }
    label160: RegistBean localRegistBean;
    while (true)
    {
      return;
      AuthCodeBean localAuthCodeBean;
      try
      {
        localAuthCodeBean = (AuthCodeBean)c.a().fromJson(paramString1, AuthCodeBean.class);
        if (localAuthCodeBean == null)
          break label160;
        if (localAuthCodeBean.getAuthCodeState().equals("STATE_OK"))
        {
          new com.withustudy.koudaizikao.custom.l(this.q, -851960, -6908266).start();
          return;
        }
      }
      catch (Exception localException2)
      {
        this.t.sendEmptyMessage(14);
        return;
      }
      if (localAuthCodeBean.getAuthCodeState().equals("STATE_AUTHCODE_UNEXPIRED"))
      {
        this.t.sendEmptyMessage(15);
        return;
      }
      if (!localAuthCodeBean.getAuthCodeState().equals("STATE_USER_ALREADY_EXIST"))
        continue;
      this.t.sendEmptyMessage(16);
      return;
      this.t.sendEmptyMessage(13);
      return;
      try
      {
        localRegistBean = (RegistBean)c.a().fromJson(paramString1, RegistBean.class);
        if (localRegistBean == null)
          break label283;
        if (!localRegistBean.getState().equals("STATE_OK"))
          break;
        if (this.w)
          continue;
        this.w = true;
        this.t.sendMessage(this.t.obtainMessage(1, localRegistBean));
        return;
      }
      catch (Exception localException1)
      {
        this.t.sendEmptyMessage(14);
        return;
      }
    }
    if (localRegistBean.getState().equals("STATE_AUTHCODE_ERROR"))
    {
      this.t.sendEmptyMessage(3);
      return;
    }
    this.t.sendEmptyMessage(4);
    return;
    label283: this.t.sendEmptyMessage(13);
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
      case 2131297480:
      case 2131297481:
      case 2131297482:
      default:
        return;
      case 2131297484:
        RegisterFragment.g(RegisterFragment.this).sendEmptyMessageDelayed(60, 200L);
        RegisterFragment.h(RegisterFragment.this);
        return;
      case 2131297479:
        RegisterFragment.i(RegisterFragment.this);
        return;
      case 2131297483:
      }
      RegisterFragment.j(RegisterFragment.this).a(0);
    }
  }

  private static class b extends com.withustudy.koudaizikao.base.n<RegisterFragment>
  {
    public b(RegisterFragment paramRegisterFragment)
    {
      super();
    }

    protected void a(RegisterFragment paramRegisterFragment, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
      case 1:
      case 3:
      case 4:
      case 15:
      case 16:
      case 60:
      }
      while (true)
      {
        return;
        RegistBean localRegistBean = (RegistBean)paramMessage.obj;
        RegisterFragment.a(paramRegisterFragment).d(localRegistBean.getUid());
        RegisterFragment.a(paramRegisterFragment).i(RegisterFragment.b(paramRegisterFragment).getText().toString().trim());
        RegisterFragment.a(paramRegisterFragment).j(RegisterFragment.c(paramRegisterFragment).getText().toString().trim());
        RegisterFragment.a(paramRegisterFragment).r(RegisterFragment.d(paramRegisterFragment).getText().toString().trim());
        RegisterFragment.a(paramRegisterFragment, MainActivity.class, true, null);
        Toast.makeText(RegisterFragment.e(paramRegisterFragment), "注册成功", 0).show();
        return;
        Toast.makeText(RegisterFragment.e(paramRegisterFragment), "验证码错误", 0).show();
        return;
        Toast.makeText(RegisterFragment.e(paramRegisterFragment), "注册失败", 0).show();
        return;
        Toast.makeText(RegisterFragment.e(paramRegisterFragment), "验证码未过期", 0).show();
        return;
        Toast.makeText(RegisterFragment.e(paramRegisterFragment), "该手机已经注册！", 0).show();
        return;
        try
        {
          if (RegisterFragment.f(paramRegisterFragment) == null)
            continue;
          RegisterFragment.f(paramRegisterFragment).hideSoftInputFromWindow(((Activity)RegisterFragment.e(paramRegisterFragment)).getCurrentFocus().getWindowToken(), 2);
          return;
        }
        catch (Exception localException)
        {
        }
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.RegisterFragment
 * JD-Core Version:    0.6.0
 */