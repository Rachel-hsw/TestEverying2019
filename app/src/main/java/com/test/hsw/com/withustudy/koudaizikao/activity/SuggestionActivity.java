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
import com.withustudy.koudaizikao.entity.content.ResultStatus;
import com.withustudy.koudaizikao.entity.req.SuggestionUpload;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.util.Map;

public class SuggestionActivity extends AbsBaseActivity
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 10;
  private Button e;
  private EditText f;
  private Button g;
  private a h;
  private b i;

  protected void bindData()
  {
  }

  protected void initData()
  {
    this.h = new a();
    this.i = new b(this);
  }

  protected void initListener()
  {
    this.e.setOnClickListener(this.h);
    this.g.setOnClickListener(this.h);
  }

  protected void initView()
  {
    this.e = ((Button)findViewById(2131296711));
    this.f = ((EditText)findViewById(2131296714));
    this.g = ((Button)findViewById(2131296715));
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    this.mProTools.b();
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.mProTools.b();
    switch (paramInt)
    {
    default:
      return;
    case 10:
    }
    try
    {
      ResultStatus localResultStatus = (ResultStatus)c.a().fromJson(paramString1, ResultStatus.class);
      if ((localResultStatus != null) && (localResultStatus.getStatus().equals("NEWS_STATUS_OK")))
      {
        this.i.sendEmptyMessage(1);
        return;
      }
    }
    catch (Exception localException)
    {
      this.i.sendEmptyMessage(2);
      return;
    }
    this.i.sendEmptyMessage(3);
  }

  protected void setContentView()
  {
    setContentView(2130903113);
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
      case 2131296711:
        SuggestionActivity.this.finish(2130968588, 2130968592);
        return;
      case 2131296715:
      }
      if (SuggestionActivity.a(SuggestionActivity.this).getText().toString().equals(""))
      {
        Toast.makeText(SuggestionActivity.b(SuggestionActivity.this), "请说点什么吧", 0).show();
        return;
      }
      SuggestionUpload localSuggestionUpload = new SuggestionUpload();
      localSuggestionUpload.setClientType(n.a());
      localSuggestionUpload.setImei(n.d(SuggestionActivity.b(SuggestionActivity.this)));
      localSuggestionUpload.setNet(n.c(SuggestionActivity.b(SuggestionActivity.this)));
      localSuggestionUpload.setVersionName(SuggestionActivity.c(SuggestionActivity.this).p());
      localSuggestionUpload.setUid(SuggestionActivity.c(SuggestionActivity.this).i());
      localSuggestionUpload.setContent(SuggestionActivity.a(SuggestionActivity.this).getText().toString());
      SuggestionActivity.d(SuggestionActivity.this).a();
      c.b().c().a(SuggestionActivity.this, localSuggestionUpload, 10);
    }
  }

  private static class b extends m<SuggestionActivity>
  {
    public b(SuggestionActivity paramSuggestionActivity)
    {
      super();
    }

    protected void a(SuggestionActivity paramSuggestionActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
        Toast.makeText(paramSuggestionActivity, "感谢您的建议！您的满意是我们唯一的目标！", 0).show();
        paramSuggestionActivity.finish();
        return;
      case 2:
        Toast.makeText(paramSuggestionActivity, "服务器未响应，请稍后再试", 0).show();
        return;
      case 3:
      }
      Toast.makeText(paramSuggestionActivity, "服务器未能返回数据，请稍后再试", 0).show();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.SuggestionActivity
 * JD-Core Version:    0.6.0
 */