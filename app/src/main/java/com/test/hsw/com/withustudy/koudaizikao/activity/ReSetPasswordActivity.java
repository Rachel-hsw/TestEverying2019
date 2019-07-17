package com.withustudy.koudaizikao.activity;

import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.base.m;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.AuthCodeBean;
import com.withustudy.koudaizikao.entity.content.ResultState;
import com.withustudy.koudaizikao.entity.req.ForgetPassword;
import com.withustudy.koudaizikao.g.i;
import com.withustudy.koudaizikao.g.n;
import java.util.Map;

public class ReSetPasswordActivity extends AbsBaseActivity
{
  public static final int a = 1;
  public static final int b = 4;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 10;
  public static final int f = 11;
  private static final int o = 1;
  private static final int p = 2;
  private static final int q = 3;
  private static final int r = 4;
  private Button g;
  private EditText h;
  private Button i;
  private EditText j;
  private EditText k;
  private Button l;
  private a m;
  private b n;
  private Handler s = new bb(this);

  private boolean a()
  {
    if (this.h.getText().toString().equals(""))
    {
      Toast.makeText(this.mContext, "请输入手机号", 1).show();
      return false;
    }
    if (this.j.getText().toString().equals(""))
    {
      Toast.makeText(this.mContext, "请输入验证码", 1).show();
      return false;
    }
    if (this.k.getText().toString().equals(""))
    {
      Toast.makeText(this.mContext, "请输入新密码", 1).show();
      return false;
    }
    return true;
  }

  protected void bindData()
  {
  }

  protected void initData()
  {
    this.m = new a();
    this.n = new b(this);
  }

  protected void initListener()
  {
    this.g.setOnClickListener(this.m);
    this.i.setOnClickListener(this.m);
    this.l.setOnClickListener(this.m);
  }

  protected void initView()
  {
    this.g = ((Button)findViewById(2131296658));
    this.h = ((EditText)findViewById(2131296659));
    this.i = ((Button)findViewById(2131296660));
    this.j = ((EditText)findViewById(2131296661));
    this.k = ((EditText)findViewById(2131296662));
    this.l = ((Button)findViewById(2131296663));
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
      this.mProTools.b();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.mProTools.b();
    switch (paramInt)
    {
    default:
    case 10:
    case 11:
    }
    ResultState localResultState;
    do
    {
      do
      {
        while (true)
        {
          return;
          AuthCodeBean localAuthCodeBean;
          try
          {
            localAuthCodeBean = (AuthCodeBean)c.a().fromJson(paramString1, AuthCodeBean.class);
            if (localAuthCodeBean == null)
              break;
            if (localAuthCodeBean.getAuthCodeState().equals("STATE_OK"))
            {
              new com.withustudy.koudaizikao.custom.l(this.i, -851960, -6908266).start();
              return;
            }
          }
          catch (Exception localException2)
          {
            this.s.sendEmptyMessage(4);
            return;
          }
          if (localAuthCodeBean.getAuthCodeState().equals("STATE_AUTHCODE_UNEXPIRED"))
          {
            this.s.sendEmptyMessage(1);
            return;
          }
          if (!localAuthCodeBean.getAuthCodeState().equals("STATE_USER_ALREADY_EXIST"))
            continue;
          this.s.sendEmptyMessage(2);
          return;
        }
        this.s.sendEmptyMessage(3);
        return;
      }
      while (paramString1 == null);
      try
      {
        localResultState = (ResultState)c.a().fromJson(paramString1, ResultState.class);
        if ((localResultState == null) || (!localResultState.getState().equals("STATE_OK")))
          continue;
        this.n.sendEmptyMessage(1);
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        this.n.sendEmptyMessage(3);
        return;
      }
    }
    while ((localResultState != null) && (localResultState.getState().equals("STATE_AUTHCODE_ERROR")));
    this.n.sendEmptyMessage(2);
  }

  protected void setContentView()
  {
    setContentView(2130903102);
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
        case 2131296658:
          ReSetPasswordActivity.this.finish();
          return;
        case 2131296660:
          if (ReSetPasswordActivity.a(ReSetPasswordActivity.this).getText().toString().equals(""))
          {
            Toast.makeText(ReSetPasswordActivity.b(ReSetPasswordActivity.this), "请输入手机号", 0).show();
            return;
          }
          if (!n.i(ReSetPasswordActivity.a(ReSetPasswordActivity.this).getText().toString().trim()))
          {
            Toast.makeText(ReSetPasswordActivity.b(ReSetPasswordActivity.this), "请输入一个正确的手机号", 0).show();
            return;
          }
          switch (n.b(ReSetPasswordActivity.this.getApplicationContext()))
          {
          default:
            Toast.makeText(ReSetPasswordActivity.this.getApplicationContext(), "无法连接服务器，请检查网络设置", 0).show();
            return;
          case 1:
          case 2:
          case 3:
          }
          ReSetPasswordActivity.c(ReSetPasswordActivity.this).a(true);
          a locala = c.b().j();
          ReSetPasswordActivity localReSetPasswordActivity = ReSetPasswordActivity.this;
          String[] arrayOfString = new String[2];
          arrayOfString[0] = ReSetPasswordActivity.a(ReSetPasswordActivity.this).getText().toString();
          arrayOfString[1] = "FORGET_USER";
          locala.a(localReSetPasswordActivity, arrayOfString, 10, ReSetPasswordActivity.b(ReSetPasswordActivity.this));
          return;
        case 2131296663:
          if (!ReSetPasswordActivity.d(ReSetPasswordActivity.this))
            break;
          ForgetPassword localForgetPassword = new ForgetPassword();
          localForgetPassword.setVersionName(ReSetPasswordActivity.e(ReSetPasswordActivity.this).p());
          localForgetPassword.setClientType(n.a());
          localForgetPassword.setImei(n.d(ReSetPasswordActivity.b(ReSetPasswordActivity.this)));
          localForgetPassword.setNet(n.c(ReSetPasswordActivity.b(ReSetPasswordActivity.this)));
          localForgetPassword.setPhoneNumber(ReSetPasswordActivity.a(ReSetPasswordActivity.this).getText().toString());
          localForgetPassword.setAuthCode(ReSetPasswordActivity.f(ReSetPasswordActivity.this).getText().toString());
          localForgetPassword.setNewPassWord(i.a(ReSetPasswordActivity.g(ReSetPasswordActivity.this).getText().toString()));
          c.b().aj().a(ReSetPasswordActivity.this, localForgetPassword, 11);
          ReSetPasswordActivity.c(ReSetPasswordActivity.this).a();
        case 2131296659:
        case 2131296661:
        case 2131296662:
        }
        return;
      }
      catch (Exception localException)
      {
      }
    }
  }

  private static class b extends m<ReSetPasswordActivity>
  {
    public b(ReSetPasswordActivity paramReSetPasswordActivity)
    {
      super();
    }

    protected void a(ReSetPasswordActivity paramReSetPasswordActivity, Message paramMessage)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 1:
          paramReSetPasswordActivity.finish();
          return;
        case 2:
          Toast.makeText(paramReSetPasswordActivity, "服务器未能返回数据，请稍后再试", 0).show();
          return;
        case 3:
          Toast.makeText(paramReSetPasswordActivity, "服务器未响应，请稍后再试", 0).show();
          return;
        case 4:
          Toast.makeText(paramReSetPasswordActivity, "验证码错误", 0).show();
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
 * Qualified Name:     com.withustudy.koudaizikao.activity.ReSetPasswordActivity
 * JD-Core Version:    0.6.0
 */