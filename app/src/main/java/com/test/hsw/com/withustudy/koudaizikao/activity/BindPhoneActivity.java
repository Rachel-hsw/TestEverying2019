package com.withustudy.koudaizikao.activity;

import android.content.Context;
import android.os.Message;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
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
import com.withustudy.koudaizikao.entity.RegistBean;
import com.withustudy.koudaizikao.entity.req.BindPhone;
import com.withustudy.koudaizikao.g.i;
import com.withustudy.koudaizikao.g.n;
import java.util.Map;

public class BindPhoneActivity extends AbsBaseActivity
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
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
  private Button p;
  private Button q;
  private b r;
  private a s;
  private InputMethodManager t;

  private void a()
  {
    String str = this.m.getText().toString().trim();
    if (n.i(str))
    {
      switch (n.b(this.mContext))
      {
      default:
        Toast.makeText(this.mContext, "当前没有网络", 0).show();
        return;
      case 1:
      case 2:
      case 3:
      }
      this.mProTools.a();
      c.b().j().a(this, new String[] { str, "BIND_USER" }, 10, this.mContext);
      return;
    }
    Toast.makeText(this.mContext, "手机号非法输入", 0).show();
  }

  private void b()
  {
    String str1 = this.m.getText().toString().trim();
    if (n.i(str1))
    {
      String str2 = this.n.getText().toString().trim();
      if ((str2 != null) && (!str2.equals("")))
      {
        String str3 = this.o.getText().toString().trim();
        if (!str3.equals(""))
        {
          switch (n.b(this.mContext))
          {
          default:
            Toast.makeText(this.mContext, "当前没有网络", 0).show();
            return;
          case 1:
          case 2:
          case 3:
          }
          BindPhone localBindPhone = new BindPhone();
          localBindPhone.setVersionName(this.mSP.p());
          localBindPhone.setClientType(n.a());
          localBindPhone.setImei(n.d(this.mContext));
          localBindPhone.setNet(n.c(this.mContext));
          localBindPhone.setAuthCode(str2);
          localBindPhone.setPhoneNumber(str1);
          localBindPhone.setAccountType("INNER_TYPE");
          localBindPhone.setPassWord(i.a(str3));
          localBindPhone.setUid(this.mSP.i());
          this.mProTools.a();
          c.b().as().a(this, localBindPhone, 11);
          return;
        }
        Toast.makeText(this.mContext, "请输入密码", 0).show();
        return;
      }
      Toast.makeText(this.mContext, "请输入验证码", 0).show();
      return;
    }
    Toast.makeText(this.mContext, "手机号非法输入", 0).show();
  }

  protected void bindData()
  {
  }

  public void finish()
  {
    setResult(1);
    super.finish();
  }

  public void finish(int paramInt1, int paramInt2)
  {
    setResult(1);
    super.finish(paramInt1, paramInt2);
  }

  protected void initData()
  {
    this.r = new b();
    this.s = new a(this);
    this.t = ((InputMethodManager)this.mContext.getSystemService("input_method"));
  }

  protected void initListener()
  {
    this.l.setOnClickListener(this.r);
    this.q.setOnClickListener(this.r);
    this.p.setOnClickListener(this.r);
  }

  protected void initView()
  {
    this.l = ((Button)findViewById(2131296420));
    this.q = ((Button)findViewById(2131296425));
    this.m = ((EditText)findViewById(2131296421));
    this.p = ((Button)findViewById(2131296422));
    this.n = ((EditText)findViewById(2131296423));
    this.o = ((EditText)findViewById(2131296424));
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
    super.onError(paramString1, paramString2, paramInt);
    this.mProTools.b();
    this.s.sendEmptyMessage(6);
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.mProTools.b();
    switch (paramInt)
    {
    default:
    case 10:
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
            new com.withustudy.koudaizikao.custom.l(this.p, -851960, -6908266).start();
            return;
          }
        }
        catch (Exception localException2)
        {
          this.s.sendEmptyMessage(14);
          return;
        }
        if (localAuthCodeBean.getAuthCodeState().equals("STATE_AUTHCODE_UNEXPIRED"))
        {
          this.s.sendEmptyMessage(15);
          return;
        }
        if (!localAuthCodeBean.getAuthCodeState().equals("STATE_USER_ALREADY_EXIST"))
          continue;
        this.s.sendEmptyMessage(16);
        return;
      }
      this.s.sendEmptyMessage(13);
      return;
    case 11:
    }
    RegistBean localRegistBean;
    try
    {
      localRegistBean = (RegistBean)c.a().fromJson(paramString1, RegistBean.class);
      if (localRegistBean == null)
        break label262;
      if (localRegistBean.getState().equals("STATE_OK"))
      {
        this.s.sendEmptyMessage(1);
        return;
      }
    }
    catch (Exception localException1)
    {
      this.s.sendEmptyMessage(14);
      return;
    }
    if (localRegistBean.getState().equals("STATE_AUTHCODE_ERROR"))
    {
      this.s.sendEmptyMessage(2);
      return;
    }
    this.s.sendEmptyMessage(3);
    return;
    label262: this.s.sendEmptyMessage(13);
  }

  protected void setContentView()
  {
    setContentView(2130903070);
  }

  private static class a extends m<BindPhoneActivity>
  {
    public a(BindPhoneActivity paramBindPhoneActivity)
    {
      super();
    }

    protected void a(BindPhoneActivity paramBindPhoneActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
      case 1:
      case 2:
      case 3:
      case 15:
      case 16:
      case 60:
      }
      while (true)
      {
        return;
        BindPhoneActivity.a(paramBindPhoneActivity).i(BindPhoneActivity.b(paramBindPhoneActivity).getText().toString().trim());
        BindPhoneActivity.a(paramBindPhoneActivity).j(BindPhoneActivity.c(paramBindPhoneActivity).getText().toString().trim());
        Toast.makeText(BindPhoneActivity.d(paramBindPhoneActivity), "绑定成功", 0).show();
        paramBindPhoneActivity.finish();
        return;
        Toast.makeText(BindPhoneActivity.d(paramBindPhoneActivity), "验证码错误", 0).show();
        return;
        Toast.makeText(BindPhoneActivity.d(paramBindPhoneActivity), "绑定失败", 0).show();
        return;
        Toast.makeText(BindPhoneActivity.d(paramBindPhoneActivity), "验证码未过期", 0).show();
        return;
        Toast.makeText(BindPhoneActivity.d(paramBindPhoneActivity), "该手机已经注册！", 0).show();
        return;
        try
        {
          if (BindPhoneActivity.e(paramBindPhoneActivity) == null)
            continue;
          BindPhoneActivity.e(paramBindPhoneActivity).hideSoftInputFromWindow(paramBindPhoneActivity.getCurrentFocus().getWindowToken(), 2);
          return;
        }
        catch (Exception localException)
        {
        }
      }
    }
  }

  class b
    implements View.OnClickListener
  {
    b()
    {
    }

    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      case 2131296421:
      case 2131296423:
      case 2131296424:
      default:
        return;
      case 2131296420:
        BindPhoneActivity.this.finish();
        return;
      case 2131296425:
        BindPhoneActivity.f(BindPhoneActivity.this).sendEmptyMessageDelayed(60, 200L);
        BindPhoneActivity.g(BindPhoneActivity.this);
        return;
      case 2131296422:
      }
      BindPhoneActivity.h(BindPhoneActivity.this);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.BindPhoneActivity
 * JD-Core Version:    0.6.0
 */