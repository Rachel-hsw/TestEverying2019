package com.withustudy.koudaizikao.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.example.test.FlowLayout;
import com.google.gson.Gson;
import com.himamis.retex.renderer.android.LaTeXView;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Kpoint;
import com.withustudy.koudaizikao.entity.OpreationState;
import com.withustudy.koudaizikao.entity.Subject;
import com.withustudy.koudaizikao.entity.SubjectFavoriteExercise;
import com.withustudy.koudaizikao.entity.SubjectFavoriteExerciseW;
import com.withustudy.koudaizikao.entity.req.FavoriteExercise;
import com.withustudy.koudaizikao.entity.req.GetCollectExcercises;
import com.withustudy.koudaizikao.entity.req.ReqDeleFavor;
import com.withustudy.koudaizikao.entity.req.UserSubject;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ActivityCollectSubject extends AbsBaseActivity
  implements View.OnClickListener
{
  private static final int action_delete_id = 6;
  private static final int action_delete_id_fail = 7;
  private static final int action_req_collect_list = 5;
  public static final int activity_collect = 15;
  private static final int delete_item = 2;
  private static final int no_data = 8;
  private static final int notify_delete = 3;
  private static final int refresh_data;
  private List<FavoriteExercise> cacheList = new ArrayList();
  private TextView collect2_tv_name;
  private CollectReceive collectReceive;
  private Button collect_btn_delete;
  private ImageButton collect_edit_switch;
  private LinearLayout collect_ll_back;
  private LinearLayout collect_ll_delete;
  private List<String> deList = new ArrayList();
  private List<String> deleteIds = new ArrayList();
  private Handler handler = new a(this);
  private boolean isEdit = false;
  private boolean isLoadFinsh = false;
  private HashMap<Integer, Boolean> itemEditState = new HashMap();
  private LinearLayout ll_no_data;
  private ListView mListView;
  private a myCollect1Adapter;
  private String rtexcerciseId;
  private SubjectFavoriteExerciseW sExerciseW;
  private SubjectFavoriteExercise sfe;
  private Subject subject;
  private String subjectId;
  private String subjectName;
  private int t;
  private List<FavoriteExercise> temp;
  private String type;

  private void deleFavorExcerByIds()
  {
    this.mProTools.a(true);
    Subject localSubject = this.sfe.getSubject();
    ReqDeleFavor localReqDeleFavor = new ReqDeleFavor();
    localReqDeleFavor.setVersionName(this.mSP.p());
    localReqDeleFavor.setClientType(n.a());
    localReqDeleFavor.setImei(n.d(this.mContext));
    localReqDeleFavor.setNet(n.c(this.mContext));
    UserSubject localUserSubject = new UserSubject();
    localUserSubject.setUid(this.mSP.i());
    localUserSubject.setSubjectId(localSubject.getId());
    localReqDeleFavor.setUserSubject(localUserSubject);
    localReqDeleFavor.setExerciseId(this.deleteIds);
    c.b().ao().a(this, localReqDeleFavor, 6);
  }

  private void deleteCheck()
  {
    int i;
    if (this.isEdit)
    {
      this.temp = new ArrayList();
      this.deleteIds.clear();
      if ((this.cacheList != null) && (this.cacheList.size() > 0))
      {
        i = 0;
        if (i < this.cacheList.size())
          break label66;
        deleFavorExcerByIds();
      }
    }
    return;
    label66: Boolean localBoolean = (Boolean)this.itemEditState.get(Integer.valueOf(i));
    FavoriteExercise localFavoriteExercise = (FavoriteExercise)this.cacheList.get(i);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
      this.temp.add(localFavoriteExercise);
    while (true)
    {
      i++;
      break;
      String str = localFavoriteExercise.getExerciseId();
      this.deleteIds.add(str);
    }
  }

  private void goBack()
  {
    if (this.isEdit)
    {
      boolean bool1 = this.isEdit;
      boolean bool2 = false;
      if (bool1);
      while (true)
      {
        this.isEdit = bool2;
        goEditUI();
        return;
        bool2 = true;
      }
    }
    finish(0, 0);
  }

  private void goEditUI()
  {
    if (this.isLoadFinsh)
    {
      if (this.isEdit)
      {
        this.collect_edit_switch.setVisibility(8);
        this.myCollect1Adapter.notifyDataSetChanged();
        this.collect_ll_delete.setVisibility(0);
      }
    }
    else
      return;
    this.collect_edit_switch.setVisibility(0);
    this.myCollect1Adapter.notifyDataSetChanged();
    this.collect_ll_delete.setVisibility(8);
  }

  private void initCollectReceive()
  {
    this.collectReceive = new CollectReceive();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.koudai.collect");
    registerReceiver(this.collectReceive, localIntentFilter);
  }

  private List<View> scaningString(String paramString, boolean paramBoolean)
  {
    int i = 0;
    if ((paramString != null) && (!paramString.equals("")) && (paramString.length() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      this.t = 0;
      String str1 = "";
      if (i >= paramString.length())
      {
        if (!str1.equals(""))
        {
          TextView localTextView3 = new TextView(this);
          localTextView3.setText(str1);
          localTextView3.setTextColor(getResources().getColor(2131034207));
          localArrayList.add(localTextView3);
        }
        return localArrayList;
      }
      String str2 = paramString.substring(i, i + 1);
      if (str2.equals("$"))
      {
        TextView localTextView1 = new TextView(this);
        localTextView1.setTextColor(getResources().getColor(2131034207));
        localTextView1.setText(str1);
        localArrayList.add(localTextView1);
        str1 = "";
        i += 2;
      }
      while (true)
      {
        i++;
        break;
        if (str2.equals("#"))
        {
          LaTeXView localLaTeXView = new LaTeXView(this);
          localLaTeXView.setLatexText(str1);
          localArrayList.add(localLaTeXView);
          str1 = "";
          i += 2;
          continue;
        }
        if (str2.equals("_"))
        {
          if ((i + 1 < paramString.length()) && (i + 2 < paramString.length()) && (i + 3 < paramString.length()) && (i + 4 < paramString.length()))
          {
            String str3 = paramString.substring(i + 1, i + 2);
            String str4 = paramString.substring(i + 2, i + 3);
            String str5 = paramString.substring(i + 3, i + 4);
            if ((str3.equals("_")) && (str4.equals("_")) && (str5.equals("_")))
            {
              TextView localTextView2 = new TextView(this);
              localTextView2.setText(str1);
              localTextView2.setTextColor(getResources().getColor(2131034207));
              localArrayList.add(localTextView2);
              str1 = "";
              ImageView localImageView = new ImageView(this);
              this.t = (1 + this.t);
              switch (this.t)
              {
              default:
              case 1:
              case 2:
              case 3:
              case 4:
              case 5:
              }
              while (true)
              {
                localArrayList.add(localImageView);
                i += 4;
                break;
                localImageView.setBackgroundResource(2130838082);
                localImageView.setTag("tk1");
                continue;
                localImageView.setBackgroundResource(2130838092);
                localImageView.setTag("tk2");
                continue;
                localImageView.setBackgroundResource(2130838094);
                localImageView.setTag("tk3");
                continue;
                localImageView.setBackgroundResource(2130838096);
                localImageView.setTag("tk4");
                continue;
                localImageView.setBackgroundResource(2130838098);
                localImageView.setTag("tk5");
              }
            }
            str1 = str1 + str2 + str3 + str4 + str5;
            i += 3;
            continue;
          }
          str1 = str1 + str2;
          continue;
        }
        str1 = str1 + str2;
      }
    }
    return null;
  }

  protected void bindData()
  {
  }

  protected void initData()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      Bundle localBundle = localIntent.getExtras();
      if (localBundle != null)
      {
        this.subjectId = localBundle.getString("subjectId");
        this.subjectName = localBundle.getString("subjectName");
        String str = this.subjectName.replace("（", "(").replace("）", ")");
        this.collect2_tv_name.setText(str);
        this.subject = new Subject();
        this.subject.setId(this.subjectId);
        this.subject.setName(this.subjectName);
      }
    }
    GetCollectExcercises localGetCollectExcercises = new GetCollectExcercises();
    localGetCollectExcercises.setClientType(n.a());
    localGetCollectExcercises.setImei(n.d(this.mContext));
    localGetCollectExcercises.setNet(n.c(this.mContext));
    localGetCollectExcercises.setVersionName(this.mSP.p());
    localGetCollectExcercises.setUid(this.mSP.i());
    localGetCollectExcercises.setSubjectId(this.subjectId);
    this.mProTools.a(true);
    c.b().ae().a(this, localGetCollectExcercises, 5);
    initCollectReceive();
  }

  protected void initListener()
  {
    this.collect_ll_back.setOnClickListener(this);
    this.collect_ll_delete.setOnClickListener(this);
    this.collect_edit_switch.setOnClickListener(this);
    this.collect_btn_delete.setOnClickListener(this);
    this.mListView.setOnItemClickListener(new b(this));
  }

  protected void initView()
  {
    this.collect_edit_switch = ((ImageButton)findViewById(2131296467));
    this.ll_no_data = ((LinearLayout)findViewById(2131296469));
    this.collect2_tv_name = ((TextView)findViewById(2131296466));
    this.mListView = ((ListView)findViewById(2131296468));
    this.collect_ll_delete = ((LinearLayout)findViewById(2131296470));
    this.collect_btn_delete = ((Button)findViewById(2131296471));
    this.collect_ll_back = ((LinearLayout)findViewById(2131296465));
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131296467:
      if (this.isEdit);
      for (boolean bool = false; ; bool = true)
      {
        this.isEdit = bool;
        goEditUI();
        return;
      }
    case 2131296471:
      deleteCheck();
      return;
    case 2131296465:
    }
    goBack();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.collectReceive != null)
      {
        unregisterReceiver(this.collectReceive);
        this.collectReceive = null;
      }
      this.mProTools.b();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void onStart()
  {
    super.onStart();
    if (this.sfe != null)
      this.handler.sendEmptyMessage(3);
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.mProTools.b();
    if (paramString1 != null);
    try
    {
      Gson localGson = c.a();
      switch (paramInt)
      {
      case 6:
        OpreationState localOpreationState = (OpreationState)localGson.fromJson(paramString1, OpreationState.class);
        if (localOpreationState == null)
          break;
        if (localOpreationState.getStatus().equals("OK"))
        {
          this.handler.sendEmptyMessage(2);
          return;
        }
        this.handler.sendEmptyMessage(7);
        return;
      case 5:
        this.sExerciseW = ((SubjectFavoriteExerciseW)localGson.fromJson(paramString1, SubjectFavoriteExerciseW.class));
        if (this.sExerciseW != null)
        {
          List localList = this.sExerciseW.getSubjectFavoriteExercise();
          if ((localList != null) && (localList.size() > 0))
          {
            this.sfe = ((SubjectFavoriteExercise)localList.get(0));
            if (this.sfe == null)
              break;
            this.handler.sendEmptyMessage(0);
            return;
          }
          else
          {
            this.handler.sendEmptyMessage(8);
            return;
          }
        }
        else
        {
          h.a("收藏主界面数据解析实体bean为null");
        }
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void setContentView()
  {
    setContentView(2130903078);
  }

  public class CollectReceive extends BroadcastReceiver
  {
    public CollectReceive()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      Bundle localBundle = paramIntent.getExtras();
      ActivityCollectSubject.this.rtexcerciseId = ((String)localBundle.getSerializable("excerciseId"));
      ActivityCollectSubject.this.type = localBundle.getString("type");
      if (!"0".equals(ActivityCollectSubject.this.type))
        ActivityCollectSubject.this.deList.add(ActivityCollectSubject.this.rtexcerciseId);
      h.a("CollectReceive excerciseId  " + ActivityCollectSubject.this.rtexcerciseId + "   type  " + ActivityCollectSubject.this.type);
    }
  }

  class a extends BaseAdapter
  {
    public a()
    {
    }

    public int getCount()
    {
      return ActivityCollectSubject.this.cacheList.size();
    }

    public Object getItem(int paramInt)
    {
      return null;
    }

    public long getItemId(int paramInt)
    {
      return 0L;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      a locala1;
      long l;
      Boolean localBoolean;
      label308: Iterator localIterator;
      if (paramView == null)
      {
        paramView = View.inflate(ActivityCollectSubject.this.getApplicationContext(), 2130903131, null);
        a locala2 = new a();
        a.a(locala2, (FlowLayout)paramView.findViewById(2131296872));
        a.a(locala2, (TextView)paramView.findViewById(2131296867));
        a.b(locala2, (TextView)paramView.findViewById(2131296865));
        a.a(locala2, (ImageView)paramView.findViewById(2131296866));
        a.c(locala2, (TextView)paramView.findViewById(2131296869));
        a.d(locala2, (TextView)paramView.findViewById(2131296868));
        a.e(locala2, (TextView)paramView.findViewById(2131296870));
        paramView.setTag(locala2);
        locala1 = locala2;
        FavoriteExercise localFavoriteExercise = (FavoriteExercise)ActivityCollectSubject.this.cacheList.get(paramInt);
        String str1 = ActivityCollectSubject.this.subject.getName();
        a.a(locala1).setText(str1);
        if (localFavoriteExercise != null)
        {
          Kpoint localKpoint = localFavoriteExercise.getKpoint();
          if (localKpoint != null)
          {
            String str5 = localKpoint.getName();
            String str6 = localKpoint.getSn();
            a.a(locala1).setText(str5 + "  " + str6);
          }
          l = localFavoriteExercise.getTime();
          localBoolean = (Boolean)ActivityCollectSubject.this.itemEditState.get(Integer.valueOf(paramInt));
          if (!ActivityCollectSubject.this.isEdit)
            break label512;
          a.b(locala1).setVisibility(0);
          if ((localBoolean != null) && (localBoolean.booleanValue()))
            break label499;
          a.b(locala1).setBackgroundResource(2130838198);
          String str4 = com.withustudy.koudaizikao.g.b.a(l);
          a.c(locala1).setText(str4);
          a.d(locala1).setText(str4);
          a.d(locala1).setVisibility(0);
          a.c(locala1).setVisibility(8);
          a.e(locala1).setText(localFavoriteExercise.getCategory());
          if ((a.f(locala1) != null) && (a.f(locala1).getChildCount() > 0))
          {
            a.f(locala1).removeAllViews();
            a.f(locala1).setOption(true);
          }
          String str3 = localFavoriteExercise.getStemText();
          h.a("scanString===-----------------" + str3);
          List localList = ActivityCollectSubject.this.scaningString(str3, false);
          if ((localList == null) || (localList.size() <= 0))
            break label632;
          localIterator = localList.iterator();
        }
      }
      while (true)
      {
        if (!localIterator.hasNext())
        {
          a.f(locala1).setVisibility(0);
          return paramView;
          locala1 = (a)paramView.getTag();
          break;
          label499: a.b(locala1).setBackgroundResource(2130837807);
          break label308;
          label512: if ((localBoolean == null) || (!localBoolean.booleanValue()))
            a.b(locala1).setBackgroundResource(2130838198);
          while (true)
          {
            a.b(locala1).setVisibility(8);
            String str2 = com.withustudy.koudaizikao.g.b.a(l);
            a.d(locala1).setText(str2);
            a.c(locala1).setText(str2);
            a.d(locala1).setVisibility(0);
            a.c(locala1).setVisibility(8);
            break;
            a.b(locala1).setBackgroundResource(2130837807);
          }
        }
        View localView = (View)localIterator.next();
        a.f(locala1).addView(localView);
      }
      label632: a.f(locala1).setVisibility(8);
      return paramView;
    }

    class a
    {
      private FlowLayout b;
      private TextView c;
      private ImageView d;
      private TextView e;
      private TextView f;
      private TextView g;
      private TextView h;

      a()
      {
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ActivityCollectSubject
 * JD-Core Version:    0.6.0
 */