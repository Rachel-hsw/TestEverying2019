package com.withustudy.koudaizikao.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.custom.LoadingView;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Province;
import com.withustudy.koudaizikao.entity.content.ProvMajorsContent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChooseProvinceActivity extends AbsBaseActivity
{
  public static final int a = 10;
  public static final String b = "finish_choose_province_activity";
  private Button c;
  private Button d;
  private TextView e;
  private LoadingView f;
  private LinearLayout g;
  private GridView h;
  private com.withustudy.koudaizikao.b.g i;
  private List<Province> j;
  private String k;
  private a l;
  private b m;

  protected void bindData()
  {
    a locala = com.withustudy.koudaizikao.a.c.b().K();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.mSP.i();
    locala.a(this, arrayOfString, 10, this.mContext);
  }

  protected void initData()
  {
    this.l = new a();
    this.j = new ArrayList();
    this.m = new b();
    IntentFilter localIntentFilter = new IntentFilter("finish_choose_province_activity");
    registerReceiver(this.m, localIntentFilter);
  }

  protected void initListener()
  {
    this.c.setOnClickListener(this.l);
    this.h.setOnItemClickListener(this.l);
    this.d.setOnClickListener(this.l);
    this.e.setOnClickListener(this.l);
  }

  protected void initView()
  {
    this.c = ((Button)findViewById(2131296452));
    this.d = ((Button)findViewById(2131296455));
    this.e = ((TextView)findViewById(2131296456));
    this.f = ((LoadingView)findViewById(2131296457));
    this.g = ((LinearLayout)findViewById(2131296453));
    this.h = ((GridView)findViewById(2131296454));
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.m != null)
    {
      unregisterReceiver(this.m);
      this.m = null;
    }
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    this.f.setVisibility(8);
    this.g.setVisibility(0);
    Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    switch (paramInt)
    {
    default:
    case 10:
    }
    do
      return;
    while (paramString1 == null);
    while (true)
    {
      ProvMajorsContent localProvMajorsContent;
      int n;
      try
      {
        localProvMajorsContent = (ProvMajorsContent)com.withustudy.koudaizikao.a.c.a().fromJson(paramString1, ProvMajorsContent.class);
        if (localProvMajorsContent == null)
          break label354;
        this.f.setVisibility(8);
        this.g.setVisibility(0);
        this.j.clear();
        this.j.addAll(localProvMajorsContent.getProvMajors());
        if (this.mSP.q().equals(""))
          break label311;
        n = 0;
        i1 = 0;
        if (n >= localProvMajorsContent.getProvMajors().size())
        {
          if (i1 != 0)
            continue;
          this.i = new com.withustudy.koudaizikao.b.g(this.mContext, this.j, 0);
          this.k = ((Province)this.j.get(0)).getProvId();
          this.h.setAdapter(this.i);
          this.h.setSelector(2131034189);
          com.withustudy.koudaizikao.g.c.a(getApplicationContext());
          com.withustudy.koudaizikao.g.c.a(getApplicationContext(), localProvMajorsContent);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
        return;
      }
      int i2;
      if (((Province)localProvMajorsContent.getProvMajors().get(n)).getProvId().equals(this.mSP.q()))
      {
        this.i = new com.withustudy.koudaizikao.b.g(this.mContext, this.j, n);
        this.k = ((Province)this.j.get(n)).getProvId();
        i2 = 1;
        break label372;
        label311: this.i = new com.withustudy.koudaizikao.b.g(this.mContext, this.j, 0);
        this.k = ((Province)this.j.get(0)).getProvId();
        continue;
        label354: Toast.makeText(this.mContext, "服务器未能返回数据，请稍后再试", 0).show();
        return;
      }
      else
      {
        i2 = i1;
      }
      label372: n++;
      int i1 = i2;
    }
  }

  protected void setContentView()
  {
    setContentView(2130903075);
  }

  class a
    implements View.OnClickListener, AdapterView.OnItemClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      case 2131296453:
      case 2131296454:
      default:
        return;
      case 2131296452:
        ChooseProvinceActivity.this.finish();
        return;
      case 2131296455:
        if ((ChooseProvinceActivity.a(ChooseProvinceActivity.this) == null) || (ChooseProvinceActivity.a(ChooseProvinceActivity.this).equals("")))
        {
          Toast.makeText(ChooseProvinceActivity.b(ChooseProvinceActivity.this), "请先选择省份", 0).show();
          return;
        }
        com.umeng.a.g.b(ChooseProvinceActivity.b(ChooseProvinceActivity.this), "personal_choose_subject");
        Bundle localBundle = new Bundle();
        localBundle.putString("pro", ChooseProvinceActivity.a(ChooseProvinceActivity.this));
        localBundle.putSerializable("list", (Serializable)ChooseProvinceActivity.c(ChooseProvinceActivity.this).get(ChooseProvinceActivity.d(ChooseProvinceActivity.this).a()));
        ChooseProvinceActivity.this.startNewActivity(ChooseProfessionActivity.class, false, localBundle);
        return;
      case 2131296456:
      }
      ChooseProvinceActivity.this.startNewActivity(SuggestionActivity.class, false, null);
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      ChooseProvinceActivity.d(ChooseProvinceActivity.this).a(paramInt);
      ChooseProvinceActivity.d(ChooseProvinceActivity.this).notifyDataSetChanged();
      ChooseProvinceActivity.a(ChooseProvinceActivity.this, ((Province)ChooseProvinceActivity.c(ChooseProvinceActivity.this).get(paramInt)).getProvId());
    }
  }

  class b extends BroadcastReceiver
  {
    b()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (ChooseProvinceActivity.this != null)
        ChooseProvinceActivity.this.finish();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ChooseProvinceActivity
 * JD-Core Version:    0.6.0
 */