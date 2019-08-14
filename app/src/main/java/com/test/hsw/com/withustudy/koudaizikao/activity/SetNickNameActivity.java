package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.os.Bundle;
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
import com.withustudy.koudaizikao.entity.req.ChangePersonalInfo;
import com.withustudy.koudaizikao.entity.req.UserBaseInfo;
import com.withustudy.koudaizikao.fragment.PersonalFragment;
import com.withustudy.koudaizikao.fragment.PersonalFragment.b;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.util.Map;

public class SetNickNameActivity extends AbsBaseActivity
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 1;
  private Button g;
  private Button h;
  private EditText i;
  private a j;
  private b k;

  protected void bindData()
  {
    Bundle localBundle = getIntent().getExtras();
    if ((localBundle != null) && (localBundle.getString("nickname") != null) && (!localBundle.getString("nickname").equals("")))
      this.i.setText(localBundle.getString("nickname"));
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
    this.j = new a();
    this.k = new b(this);
  }

  protected void initListener()
  {
    this.g.setOnClickListener(this.j);
    this.h.setOnClickListener(this.j);
  }

  protected void initView()
  {
    this.g = ((Button)findViewById(2131296681));
    this.h = ((Button)findViewById(2131296682));
    this.i = ((EditText)findViewById(2131296683));
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    this.k.sendEmptyMessage(5);
    this.k.sendEmptyMessage(4);
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.k.sendEmptyMessage(5);
    switch (paramInt)
    {
    default:
    case 1:
    }
    do
      return;
    while (paramString1 == null);
    try
    {
      ResultState localResultState = (ResultState)c.a().fromJson(paramString1, ResultState.class);
      if ((localResultState != null) && (localResultState.getState().equals("STATE_OK")))
      {
        this.k.sendEmptyMessage(1);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.k.sendEmptyMessage(3);
      return;
    }
    this.k.sendEmptyMessage(2);
  }

  protected void setContentView()
  {
    setContentView(2130903105);
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
      case 2131296681:
        SetNickNameActivity.this.finish();
        return;
      case 2131296682:
      }
      if (SetNickNameActivity.b(SetNickNameActivity.this).getText().toString().equals(""))
      {
        Toast.makeText(SetNickNameActivity.c(SetNickNameActivity.this), "昵称不能为空", 0).show();
        return;
      }
      SetNickNameActivity.a(SetNickNameActivity.this).a();
      ChangePersonalInfo localChangePersonalInfo = new ChangePersonalInfo();
      localChangePersonalInfo.setVersionName(SetNickNameActivity.d(SetNickNameActivity.this).p());
      localChangePersonalInfo.setClientType(n.a());
      localChangePersonalInfo.setImei(n.d(SetNickNameActivity.c(SetNickNameActivity.this)));
      localChangePersonalInfo.setNet(n.c(SetNickNameActivity.c(SetNickNameActivity.this)));
      localChangePersonalInfo.setUid(SetNickNameActivity.d(SetNickNameActivity.this).i());
      UserBaseInfo localUserBaseInfo = new UserBaseInfo();
      localUserBaseInfo.setNickname(SetNickNameActivity.b(SetNickNameActivity.this).getText().toString());
      localChangePersonalInfo.setUserBasicInfo(localUserBaseInfo);
      c.b().e().a(SetNickNameActivity.this, localChangePersonalInfo, 1);
    }
  }

  private static class b extends m<SetNickNameActivity>
  {
    public b(SetNickNameActivity paramSetNickNameActivity)
    {
      super();
    }

    protected void a(SetNickNameActivity paramSetNickNameActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
        PersonalFragment.b.sendEmptyMessage(4);
        paramSetNickNameActivity.finish();
        return;
      case 2:
        Toast.makeText(paramSetNickNameActivity, "服务器未能返回数据，请稍后再试", 0).show();
        return;
      case 3:
        Toast.makeText(paramSetNickNameActivity, "服务器未响应，请稍后再试", 0).show();
        return;
      case 4:
        Toast.makeText(paramSetNickNameActivity, "服务器未响应，请稍后再试", 0).show();
        return;
      case 5:
      }
      SetNickNameActivity.a(paramSetNickNameActivity).b();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.SetNickNameActivity
 * JD-Core Version:    0.6.0
 */