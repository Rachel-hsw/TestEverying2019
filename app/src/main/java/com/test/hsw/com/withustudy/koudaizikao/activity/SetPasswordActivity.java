package com.withustudy.koudaizikao.activity;

import android.os.Message;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.base.m;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.content.ResultState;
import com.withustudy.koudaizikao.entity.req.Login;
import com.withustudy.koudaizikao.entity.req.UpdatePassword;
import com.withustudy.koudaizikao.g.i;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.util.Map;

public class SetPasswordActivity extends AbsBaseActivity
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 10;
  public static final int h = 11;
  private EditText i;
  private EditText j;
  private EditText k;
  private Button l;
  private Button m;
  private b n;
  private a o;

  private boolean a()
  {
    if (this.i.getText().toString().equals(""))
    {
      Toast.makeText(this.mContext, "请输入原密码", 0).show();
      return false;
    }
    if (this.j.getText().toString().equals(""))
    {
      Toast.makeText(this.mContext, "请输入新密码", 0).show();
      return false;
    }
    if (this.k.getText().toString().equals(""))
    {
      Toast.makeText(this.mContext, "请再次输入新密码", 0).show();
      return false;
    }
    if (!this.k.getText().toString().equals(this.j.getText().toString()))
    {
      Toast.makeText(this.mContext, "密码不一致，请重新输入", 0).show();
      return false;
    }
    if (this.i.getText().toString().equals(this.j.getText().toString()))
    {
      Toast.makeText(this.mContext, "新密码不能和旧密码相同，请重新输入", 0).show();
      return false;
    }
    return true;
  }

  protected void bindData()
  {
  }

  protected void initData()
  {
    this.n = new b(this);
    this.o = new a();
  }

  protected void initListener()
  {
    this.l.setOnClickListener(this.o);
    this.m.setOnClickListener(this.o);
  }

  protected void initView()
  {
    this.l = ((Button)findViewById(2131296684));
    this.m = ((Button)findViewById(2131296688));
    this.i = ((EditText)findViewById(2131296685));
    this.j = ((EditText)findViewById(2131296686));
    this.k = ((EditText)findViewById(2131296687));
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    this.mProTools.b();
    Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    switch (paramInt)
    {
    default:
    case 10:
    case 11:
    }
    label120: 
    do
    {
      do
        return;
      while (paramString1 == null);
      try
      {
        ResultState localResultState2 = (ResultState)c.a().fromJson(paramString1, ResultState.class);
        if (localResultState2 == null)
          break label120;
        if (localResultState2.getState().equals("STATE_OK"))
        {
          this.n.sendEmptyMessage(1);
          return;
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        this.n.sendEmptyMessage(6);
        Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
        return;
      }
      this.n.sendEmptyMessage(2);
      return;
      this.n.sendEmptyMessage(3);
      return;
      this.n.sendEmptyMessage(6);
    }
    while (paramString1 == null);
    try
    {
      ResultState localResultState1 = (ResultState)c.a().fromJson(paramString1, ResultState.class);
      if ((localResultState1 != null) && (localResultState1.getState().equals("STATE_OK")))
      {
        this.n.sendEmptyMessage(4);
        return;
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      this.n.sendEmptyMessage(5);
      return;
    }
    this.n.sendEmptyMessage(5);
  }

  protected void setContentView()
  {
    setContentView(2130903106);
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
      case 2131296684:
      case 2131296688:
      }
      do
      {
        return;
        SetPasswordActivity.this.finish();
        return;
      }
      while (!SetPasswordActivity.e(SetPasswordActivity.this));
      SetPasswordActivity.d(SetPasswordActivity.this).a(true);
      Login localLogin = new Login();
      localLogin.setVersionName(SetPasswordActivity.a(SetPasswordActivity.this).p());
      localLogin.setClientType(n.a());
      localLogin.setImei(n.d(SetPasswordActivity.f(SetPasswordActivity.this)));
      localLogin.setNet(n.c(SetPasswordActivity.f(SetPasswordActivity.this)));
      localLogin.setPhoneNumber(SetPasswordActivity.a(SetPasswordActivity.this).m());
      localLogin.setPassWord(i.a(SetPasswordActivity.b(SetPasswordActivity.this).getText().toString()));
      localLogin.setAccountType("INNER_TYPE");
      c.b().d().a(SetPasswordActivity.this, localLogin, 10);
    }
  }

  private static class b extends m<SetPasswordActivity>
  {
    public b(SetPasswordActivity paramSetPasswordActivity)
    {
      super();
    }

    protected void a(SetPasswordActivity paramSetPasswordActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
        UpdatePassword localUpdatePassword = new UpdatePassword();
        localUpdatePassword.setVersionName(SetPasswordActivity.a(paramSetPasswordActivity).p());
        localUpdatePassword.setClientType(n.a());
        localUpdatePassword.setImei(n.d(paramSetPasswordActivity));
        localUpdatePassword.setNet(n.c(paramSetPasswordActivity));
        localUpdatePassword.setUid(SetPasswordActivity.a(paramSetPasswordActivity).i());
        localUpdatePassword.setOldPassWord(i.a(SetPasswordActivity.b(paramSetPasswordActivity).getText().toString()));
        localUpdatePassword.setNewPassWord(i.a(SetPasswordActivity.c(paramSetPasswordActivity).getText().toString()));
        c.b().aj().a(paramSetPasswordActivity, localUpdatePassword, 11);
        return;
      case 2:
        SetPasswordActivity.d(paramSetPasswordActivity).b();
        Toast.makeText(paramSetPasswordActivity, "原密码不正确", 0).show();
        return;
      case 3:
        SetPasswordActivity.d(paramSetPasswordActivity).b();
        Toast.makeText(paramSetPasswordActivity, "服务器未能返回数据，请稍后再试", 0).show();
        return;
      case 4:
        paramSetPasswordActivity.finish();
        return;
      case 5:
        Toast.makeText(paramSetPasswordActivity, "服务器未能返回数据，请稍后再试", 0).show();
        return;
      case 6:
      }
      SetPasswordActivity.d(paramSetPasswordActivity).b();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.SetPasswordActivity
 * JD-Core Version:    0.6.0
 */