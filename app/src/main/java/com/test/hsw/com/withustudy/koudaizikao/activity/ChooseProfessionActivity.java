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
import android.widget.TextView;
import android.widget.Toast;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.entity.ChooseProToChooseSub;
import com.withustudy.koudaizikao.entity.Major;
import com.withustudy.koudaizikao.entity.Province;
import java.util.List;

public class ChooseProfessionActivity extends AbsBaseActivity
{
  public static final String FINISH_CHOOSE_PROFESSION_ACTIVITY = "finish_choose_profession_activity";
  private Button buttonBack;
  private Button buttonSave;
  private GridView gridProfession;
  private List<Major> listMajor;
  private a mBackListener;
  private b mBroadcastReceiver;
  private com.withustudy.koudaizikao.b.f mProfessionAdapter;
  private Major major;
  private String proId;
  private TextView textSuggestion;

  private void setMajorList()
  {
    this.mProfessionAdapter = new com.withustudy.koudaizikao.b.f(this.mContext, this.listMajor);
    int i;
    int j;
    if (!this.mSP.s().equals(""))
    {
      i = 0;
      j = 0;
      if (i >= this.listMajor.size())
        if (j == 0)
          this.mProfessionAdapter.a(0);
    }
    while (true)
    {
      this.gridProfession.setAdapter(this.mProfessionAdapter);
      this.gridProfession.setSelector(2131034189);
      this.major = new Major();
      if ((this.mSP.t().equals("")) || (!this.mSP.q().equals(this.proId)))
        break label225;
      this.major.setMajorId(this.mSP.s());
      this.major.setMajorName(this.mSP.t());
      this.major.setProvName(this.mSP.r());
      return;
      if (((Major)this.listMajor.get(i)).getMajorId().equals(this.mSP.s()))
      {
        this.mProfessionAdapter.a(i);
        j = 1;
      }
      i++;
      break;
      this.mProfessionAdapter.a(0);
    }
    label225: this.major = ((Major)this.mProfessionAdapter.getItem(0));
  }

  protected void bindData()
  {
    setMajorList();
  }

  protected void initData()
  {
    Bundle localBundle = getIntent().getExtras();
    this.proId = localBundle.getString("pro");
    this.listMajor = ((Province)localBundle.getSerializable("list")).getMajor();
    this.mBackListener = new a();
    this.mBroadcastReceiver = new b();
    IntentFilter localIntentFilter = new IntentFilter("finish_choose_profession_activity");
    registerReceiver(this.mBroadcastReceiver, localIntentFilter);
  }

  protected void initListener()
  {
    this.buttonBack.setOnClickListener(this.mBackListener);
    this.buttonSave.setOnClickListener(this.mBackListener);
    this.textSuggestion.setOnClickListener(this.mBackListener);
    this.gridProfession.setOnItemClickListener(this.mBackListener);
  }

  protected void initView()
  {
    this.buttonBack = ((Button)findViewById(2131296448));
    this.buttonSave = ((Button)findViewById(2131296450));
    this.textSuggestion = ((TextView)findViewById(2131296451));
    this.gridProfession = ((GridView)findViewById(2131296449));
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mBroadcastReceiver != null)
    {
      unregisterReceiver(this.mBroadcastReceiver);
      this.mBroadcastReceiver = null;
    }
  }

  protected void setContentView()
  {
    setContentView(2130903074);
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
      case 2131296449:
      default:
        return;
      case 2131296448:
        ChooseProfessionActivity.this.finish();
        return;
      case 2131296450:
        if (ChooseProfessionActivity.this.major == null)
        {
          Toast.makeText(ChooseProfessionActivity.this.mContext, "请先选择专业", 0).show();
          return;
        }
        ChooseProToChooseSub localChooseProToChooseSub = new ChooseProToChooseSub();
        localChooseProToChooseSub.setProId(ChooseProfessionActivity.this.proId);
        localChooseProToChooseSub.setProvName(ChooseProfessionActivity.this.major.getProvName());
        localChooseProToChooseSub.setMajorId(ChooseProfessionActivity.this.major.getMajorId());
        localChooseProToChooseSub.setMajorName(ChooseProfessionActivity.this.major.getMajorName());
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("Major", localChooseProToChooseSub);
        ChooseProfessionActivity.this.startNewActivity(ChooseSubjectActivity.class, false, localBundle);
        return;
      case 2131296451:
      }
      ChooseProfessionActivity.this.startNewActivity(SuggestionActivity.class, false, null);
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      ChooseProfessionActivity.this.mProfessionAdapter.a(paramInt);
      ChooseProfessionActivity.this.mProfessionAdapter.notifyDataSetChanged();
      ChooseProfessionActivity.this.major = ((Major)ChooseProfessionActivity.this.mProfessionAdapter.getItem(paramInt));
    }
  }

  class b extends BroadcastReceiver
  {
    b()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (ChooseProfessionActivity.this != null)
        ChooseProfessionActivity.this.finish();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ChooseProfessionActivity
 * JD-Core Version:    0.6.0
 */