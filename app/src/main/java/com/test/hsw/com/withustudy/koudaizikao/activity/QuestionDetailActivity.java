package com.withustudy.koudaizikao.activity;

import a.a.a.e.k;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.umeng.a.g;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.custom.AdaptiveGridView;
import com.withustudy.koudaizikao.custom.j;
import com.withustudy.koudaizikao.custom.j.a;
import com.withustudy.koudaizikao.d.a.b;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.BrushExcerciseBean;
import com.withustudy.koudaizikao.entity.ErrorExercise;
import com.withustudy.koudaizikao.entity.Exercises;
import com.withustudy.koudaizikao.entity.Kpoint;
import com.withustudy.koudaizikao.entity.KpointDetail;
import com.withustudy.koudaizikao.entity.ReqOldExam;
import com.withustudy.koudaizikao.entity.Stem;
import com.withustudy.koudaizikao.entity.UrlShortBean;
import com.withustudy.koudaizikao.entity.req.BeginSection;
import com.withustudy.koudaizikao.entity.req.ExamDate;
import com.withustudy.koudaizikao.entity.req.ExerciseIdList;
import com.withustudy.koudaizikao.entity.req.FavoriteExercise;
import com.withustudy.koudaizikao.entity.req.IntellBrush;
import com.withustudy.koudaizikao.entity.req.KpointExcercise;
import com.withustudy.koudaizikao.entity.req.ReqBrushChapterGoNext;
import com.withustudy.koudaizikao.entity.req.ReqBrushLast;
import com.withustudy.koudaizikao.entity.req.ReqChapterBrush;
import com.withustudy.koudaizikao.entity.req.ReqDeleFavor;
import com.withustudy.koudaizikao.entity.req.ReqFavoriteExercise;
import com.withustudy.koudaizikao.entity.req.ReqSimuExcerciseId;
import com.withustudy.koudaizikao.entity.req.UserSubject;
import com.withustudy.koudaizikao.entity.req.push.UserAnswers;
import com.withustudy.koudaizikao.fragment.QuestionDetailFragment;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import koudai.db.UserAnsDao;
import koudai.db.UserAnsDao.Properties;

public class QuestionDetailActivity extends AbsBaseActivity
  implements View.OnClickListener, j.a
{
  private static final int S = 0;
  private static final int T = 1;
  private static final int U = 2;
  private static final int V = 3;
  private static final int W = 4;
  private static final int X = 5;
  private static final int Y = 8;
  private static final int Z = 9;
  private static final int aa = 6;
  private static final int ab = 7;
  private static final int ac = 10;
  private static final int ad = 101;
  private static final int ae = 102;
  private static final int bo = 7200;
  private List<Exercises> A = new ArrayList();
  private List<QuestionDetailFragment> B = new ArrayList();
  private boolean C = true;
  private LinearLayout D;
  private LinearLayout E;
  private LinearLayout F;
  private LinearLayout G;
  private RelativeLayout H;
  private RelativeLayout I;
  private LinearLayout J;
  private LinearLayout K;
  private LinearLayout L;
  private LinearLayout M;
  private LinearLayout N;
  private ImageView O;
  private ImageView P;
  private ImageView Q;
  private String R = "";
  public HashMap<Integer, String> a = new HashMap();
  private com.withustudy.koudaizikao.custom.a.a aA;
  private Handler aB = new aq(this);
  private String aC = "00";
  private String aD = "120";
  private String aE = "00";
  private boolean aF = false;
  private ImageView aG;
  private boolean aH = true;
  private boolean aI = false;
  private List<QuestionDetailFragment> aJ;
  private List<Exercises> aK;
  private double aL;
  private com.withustudy.koudaizikao.e.a aM;
  private int aN = 0;
  private int aO = 0;
  private PopupWindow aP;
  private Button aQ;
  private Button aR;
  private Button aS;
  private RelativeLayout aT;
  private TextView aU;
  private TextView aV;
  private TextView aW;
  private PopupWindow aX;
  private ImageButton aY;
  private Button aZ;
  private TextView af;
  private TextView ag;
  private com.withustudy.koudaizikao.custom.h ah;
  private Bundle ai;
  private String aj;
  private String ak;
  private String al;
  private ImageView am;
  private long an;
  private long ao;
  private boolean ap;
  private ExerciseIdList aq;
  private int ar = 0;
  private List<String> as;
  private int at = 0;
  private UrlShortBean au;
  private boolean av = false;
  private boolean aw;
  private int ax;
  private HashMap<Integer, Boolean> ay = new HashMap();
  private boolean az = false;
  public int b;
  private Button ba;
  private List<Boolean> bb;
  private LinearLayout bc;
  private TextView bd;
  private TextView be;
  private b bf;
  private TextView bg;
  private TextView bh;
  private LinearLayout bi;
  private LinearLayout bj;
  private LinearLayout bk;
  private TextView bl;
  private TextView bm;
  private TextView bn;
  private int bp = 7200;
  private boolean bq = true;
  private int br;
  private boolean bs = false;
  private HashMap<String, Integer> bt = null;
  public String c;
  public boolean d = false;
  public int e = 0;
  public UserSubject f;
  public boolean g = false;
  ArrayList<ErrorExercise> h;
  public HashMap<Integer, Boolean> i = new HashMap();
  public HashMap<Integer, Boolean> j = new HashMap();
  public HashMap<Integer, UserAnswers> k;
  public HashMap<Integer, UserAnswers> l = new HashMap();
  public HashMap<Integer, Boolean> m;
  public HashMap<Integer, String> n = new HashMap();
  ExerciseIdList o;
  public boolean p = false;
  public TextView q;
  public int r;
  List<QuestionDetailFragment> s;
  List<Exercises> t;
  public String u;
  Handler v = new Handler();
  Runnable w = new au(this);
  private ViewPager x;
  private j y;
  private BrushExcerciseBean z;

  private String a(HashMap<Integer, String> paramHashMap)
  {
    Iterator localIterator = paramHashMap.keySet().iterator();
    String str2;
    for (String str1 = ""; ; str1 = str1 + str2 + "%%%%")
      do
      {
        if (!localIterator.hasNext())
          return str1;
        str2 = (String)paramHashMap.get((Integer)localIterator.next());
      }
      while ((str2 == null) || (str2.equals("")));
  }

  private String a(List<String> paramList)
  {
    Object localObject1 = "";
    Iterator localIterator;
    if ((paramList != null) && (paramList.size() > 0))
      localIterator = paramList.iterator();
    String str;
    for (Object localObject2 = localObject1; ; localObject2 = localObject2 + str + "%%%%")
    {
      if (!localIterator.hasNext())
      {
        localObject1 = localObject2;
        return localObject1;
      }
      str = (String)localIterator.next();
    }
  }

  private void a(LinearLayout paramLinearLayout)
  {
    switch (this.r)
    {
    default:
      a(this.A, paramLinearLayout);
      return;
    case 100:
      a(this.aK, paramLinearLayout);
      return;
    case 101:
    }
    a(this.aK, paramLinearLayout);
  }

  private void a(String paramString, double paramDouble)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.koudai.pushAnsers");
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("excerciseBrushId", this.u);
    localBundle.putString("type", paramString);
    localBundle.putString("subjectId", this.c);
    localBundle.putLong("mockTime", ()paramDouble);
    localIntent.putExtras(localBundle);
    sendBroadcast(localIntent);
  }

  private void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.koudai.collect");
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("excerciseId", paramString1);
    localBundle.putString("type", paramString2);
    localIntent.putExtras(localBundle);
    sendBroadcast(localIntent);
  }

  private void a(List<Exercises> paramList, LinearLayout paramLinearLayout)
  {
    HashMap localHashMap1;
    HashMap localHashMap2;
    Iterator localIterator;
    int i1;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localHashMap1 = new HashMap();
      localHashMap2 = new HashMap();
      localIterator = paramList.iterator();
      i1 = -1;
    }
    int i4;
    int i5;
    while (true)
    {
      if (!localIterator.hasNext())
      {
        com.withustudy.koudaizikao.g.h.a(localHashMap1);
        int i3 = localHashMap2.size();
        i4 = 0;
        i5 = 0;
        if (i4 < i3)
          break;
        return;
      }
      Exercises localExercises = (Exercises)localIterator.next();
      if (localExercises == null)
        continue;
      String str1 = localExercises.getExerciseId();
      String str2 = localExercises.getCategory();
      List localList1 = (List)localHashMap1.get(str2);
      if ((localList1 == null) || (localList1.size() == 0))
      {
        int i2 = i1 + 1;
        localHashMap2.put(Integer.valueOf(i2), str2);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(str1);
        localHashMap1.put(str2, localArrayList);
        i1 = i2;
        continue;
      }
      localList1.add(str1);
    }
    String str3 = (String)localHashMap2.get(Integer.valueOf(i4));
    List localList2 = (List)localHashMap1.get(str3);
    int i7;
    if ((localList2 != null) && (localList2.size() > 0))
    {
      i7 = localList2.size();
      View localView = View.inflate(getApplicationContext(), 2130903255, null);
      ((TextView)localView.findViewById(2131297473)).setText(str3);
      ((AdaptiveGridView)localView.findViewById(2131297474)).setAdapter(new a(localList2, i5));
      paramLinearLayout.addView(localView);
    }
    for (int i6 = i5 + i7; ; i6 = i5)
    {
      i4++;
      i5 = i6;
      break;
    }
  }

  private void c(int paramInt)
  {
    this.aI = true;
    this.aw = true;
    this.B.clear();
    this.B.addAll(this.aJ);
    this.y.notifyDataSetChanged();
    this.A.clear();
    this.A.addAll(this.aK);
    if (this.aw)
    {
      QuestionDetailFragment localQuestionDetailFragment = new QuestionDetailFragment();
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("exercises", null);
      localQuestionDetailFragment.setArguments(localBundle);
      this.B.add(localQuestionDetailFragment);
      this.A.add(null);
    }
    this.y.notifyDataSetChanged();
    this.x.setCurrentItem(0);
    this.aH = false;
    Message localMessage = this.aB.obtainMessage();
    localMessage.obj = Integer.valueOf(paramInt);
    localMessage.what = 22;
    this.aB.sendMessage(localMessage);
  }

  private void d()
  {
    double d1;
    if ((this.r != 100) && (this.r != 101))
    {
      this.aL = e();
      d1 = Math.ceil(1.0D * this.br / 60.0D);
    }
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    Iterator localIterator;
    label110: int i1;
    switch (this.e)
    {
    default:
      a(a.b.c, d1);
      g();
      f();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localIterator = this.a.keySet().iterator();
      if (localIterator.hasNext())
        break;
      if ((this.aL >= 0.0D) && (this.aL < 60.0D))
        i1 = 0;
    case 16:
    }
    while (true)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("subjectId", this.c);
      localBundle.putInt("resultCode", this.r);
      localBundle.putInt("errorCount", localArrayList2.size());
      localBundle.putInt("rightCount", localArrayList1.size());
      localBundle.putInt("userLevel", i1);
      localBundle.putString("subjectName", this.al);
      localBundle.putDouble("statisticsSocre", this.aL);
      localBundle.putInt("FromPage", 3);
      localBundle.putString("level", this.ak);
      localBundle.putInt("time", this.br);
      localBundle.putString("formateSecond", com.withustudy.koudaizikao.g.b.a(0, this.br));
      localBundle.putInt("doneCount", this.aN);
      localBundle.putSerializable("currRight", this.a);
      localBundle.putInt("count", this.aq.getExerciseId().size());
      Intent localIntent = new Intent(getApplicationContext(), ActivitySimuResult.class);
      localBundle.putInt("FromPage", this.e);
      localBundle.putSerializable("exerciseIdList", this.aq);
      localBundle.putSerializable("currRight", this.a);
      localBundle.putSerializable("brushExcerciseBean", this.z);
      localBundle.putSerializable("isHaveDone", this.j);
      localIntent.putExtras(localBundle);
      startActivityForResult(localIntent, 100);
      return;
      a(a.b.d, d1);
      break;
      Integer localInteger = (Integer)localIterator.next();
      String str = (String)this.a.get(localInteger);
      if ((str == null) || (str.equals("")))
      {
        localArrayList2.add(localInteger);
        break label110;
      }
      if ("true".equals(str))
      {
        localArrayList1.add(localInteger);
        break label110;
      }
      localArrayList2.add(localInteger);
      break label110;
      if ((this.aL >= 60.0D) && (this.aL <= 70.0D))
      {
        i1 = 1;
        continue;
      }
      i1 = 2;
    }
  }

  private double e()
  {
    this.aM = com.withustudy.koudaizikao.e.a.a(this.mContext);
    List localList = this.aM.a().k().a(UserAnsDao.Properties.g.a(this.u), new k[0]).d();
    Iterator localIterator = localList.iterator();
    double d1 = 0.0D;
    while (true)
    {
      if (!localIterator.hasNext())
      {
        com.withustudy.koudaizikao.g.h.a("statisticsSocre 统计分数题目数::" + localList.size());
        return d1;
      }
      koudai.db.h localh = (koudai.db.h)localIterator.next();
      Double localDouble = localh.f();
      Boolean localBoolean = localh.d();
      if ((localBoolean != null) && (localBoolean.booleanValue()))
        this.aN = (1 + this.aN);
      d1 += localDouble.doubleValue();
    }
  }

  private void f()
  {
    if (this.aX != null)
    {
      this.aX.dismiss();
      this.aX = null;
    }
  }

  private void g()
  {
    if (this.aP != null)
    {
      this.aP.dismiss();
      this.aP = null;
    }
    a(1.0F);
  }

  private void h()
  {
    int i1 = 0;
    try
    {
      if (this.aq != null)
      {
        List localList = this.aq.getExerciseId();
        if ((localList != null) && (localList.size() > 0))
        {
          if (this.aP != null)
          {
            this.aP.dismiss();
            this.aP = null;
          }
          View localView = getLayoutInflater().inflate(2130903271, null);
          this.aQ = ((Button)localView.findViewById(2131297540));
          this.aT = ((RelativeLayout)localView.findViewById(2131297535));
          this.aR = ((Button)localView.findViewById(2131297541));
          this.aS = ((Button)localView.findViewById(2131296842));
          this.aU = ((TextView)localView.findViewById(2131297539));
          this.aV = ((TextView)localView.findViewById(2131297538));
          this.aW = ((TextView)localView.findViewById(2131297537));
          this.aQ.setOnClickListener(this);
          this.aR.setOnClickListener(this);
          this.aS.setOnClickListener(this);
          this.aT.setOnClickListener(this);
          Iterator localIterator = this.j.keySet().iterator();
          if (!localIterator.hasNext())
          {
            int i2 = this.aq.getExerciseId().size();
            this.aW.setText(i1);
            this.aV.setText(i2 - i1);
            if (!this.bs)
              break label486;
            this.aR.setText("交卷");
            this.aR.setBackgroundResource(2130837608);
            this.aS.setText("退出");
            this.aS.setBackgroundResource(2130837623);
          }
          while (true)
          {
            String str = com.withustudy.koudaizikao.g.b.b(0, this.br);
            this.aU.setText(str);
            localView.setFocusable(true);
            localView.setFocusableInTouchMode(true);
            this.aP = new PopupWindow(localView, this.mSP.y(), n.a(this, 600.0F));
            this.aP.setAnimationStyle(2131231021);
            this.aP.setFocusable(true);
            localView.setOnKeyListener(new aw(this));
            this.aP.showAtLocation(this.x, 80, 0, 0);
            a(0.5F);
            return;
            Integer localInteger = (Integer)localIterator.next();
            Boolean localBoolean = (Boolean)this.j.get(localInteger);
            if ((localBoolean == null) || (!localBoolean.booleanValue()))
              break;
            i1++;
            break;
            label486: this.aR.setText("答题卡");
            this.aR.setBackgroundResource(2130837612);
            this.aS.setText("果断交卷");
            this.aS.setBackgroundResource(2130837607);
          }
        }
      }
    }
    catch (Exception localException)
    {
    }
  }

  private void i()
  {
    int i1 = 0;
    try
    {
      if (this.aX != null)
      {
        this.aX.dismiss();
        this.aX = null;
      }
      View localView = getLayoutInflater().inflate(2130903270, null);
      this.aY = ((ImageButton)localView.findViewById(2131297524));
      this.bl = ((TextView)localView.findViewById(2131297527));
      this.bn = ((TextView)localView.findViewById(2131297525));
      this.bm = ((TextView)localView.findViewById(2131297529));
      this.bk = ((LinearLayout)localView.findViewById(2131297532));
      this.bc = ((LinearLayout)localView.findViewById(2131297523));
      this.bi = ((LinearLayout)localView.findViewById(2131296645));
      this.bj = ((LinearLayout)localView.findViewById(2131296647));
      this.aZ = ((Button)localView.findViewById(2131297533));
      this.ba = ((Button)localView.findViewById(2131297534));
      this.be = ((TextView)localView.findViewById(2131297530));
      this.bd = ((TextView)localView.findViewById(2131296651));
      this.bg = ((TextView)localView.findViewById(2131297526));
      this.bh = ((TextView)localView.findViewById(2131297528));
      String str1 = com.withustudy.koudaizikao.g.b.b(1, this.bp);
      this.bd.setText(str1);
      a((LinearLayout)localView.findViewById(2131297531));
      int i2;
      int i3;
      int i4;
      int i5;
      if (this.aI)
      {
        i2 = this.aq.getExerciseId().size();
        i3 = 0;
        i4 = 0;
        i5 = 0;
      }
      while (true)
      {
        Iterator localIterator2;
        if (i3 >= i2)
          localIterator2 = this.j.keySet().iterator();
        while (true)
          if (!localIterator2.hasNext())
          {
            String str3 = com.withustudy.koudaizikao.g.b.b(0, this.br);
            this.bd.setText("耗时:" + str3);
            this.bn.setText("正确");
            this.bg.setText(i1);
            this.bl.setText("错误");
            this.bh.setText(i4);
            this.bh.setTextColor(getResources().getColor(2131034193));
            this.bm.setText("未答");
            this.be.setText(i5);
            this.aZ.setText("只看错题");
            this.ba.setText("从头浏览");
            this.bi.setVisibility(8);
            this.bj.setVisibility(8);
            this.P.setBackgroundResource(2130837755);
            this.bc.setVisibility(8);
            this.aB.sendEmptyMessage(3);
            this.aY.setOnClickListener(this);
            this.bc.setOnClickListener(this);
            this.aZ.setOnClickListener(this);
            this.ba.setOnClickListener(this);
            localView.setFocusable(true);
            localView.setFocusableInTouchMode(true);
            this.aX = new PopupWindow(localView, this.mSP.y(), this.K.getHeight());
            this.aX.setAnimationStyle(2131231022);
            this.aX.setFocusable(true);
            localView.setOnKeyListener(new ax(this));
            if ((this.aX == null) || (this.x == null))
              break label1072;
            this.aX.showAtLocation(this.x, 80, 0, 0);
            return;
            String str4 = (String)this.a.get(Integer.valueOf(i3));
            if (str4 == null)
            {
              int i10 = i5 + 1;
              int i11 = i1;
              i9 = i4;
              i7 = i10;
              i8 = i11;
              break label1073;
            }
            if (str4.equals("false"))
            {
              int i6 = i4 + 1;
              i7 = i5;
              i8 = i1;
              i9 = i6;
              break label1073;
            }
            if (!str4.equals("true"))
              break;
            i8 = i1 + 1;
            i9 = i4;
            i7 = i5;
            break label1073;
          }
          else
          {
            Integer localInteger2 = (Integer)localIterator2.next();
            Boolean localBoolean2 = (Boolean)this.j.get(localInteger2);
            if (localBoolean2 == null)
              continue;
            localBoolean2.booleanValue();
            continue;
            this.bl.setText("未答");
            this.bm.setText("耗时");
            this.aZ.setText("继续答题");
            this.ba.setText("果断交卷");
            this.ba.setBackgroundResource(2130837607);
            String str2 = com.withustudy.koudaizikao.g.b.b(0, this.br);
            this.be.setText(str2);
            com.withustudy.koudaizikao.g.h.a("simuCount=" + this.at);
            Iterator localIterator1 = this.j.keySet().iterator();
            while (true)
            {
              if (!localIterator1.hasNext())
              {
                this.bg.setText(i1);
                this.bh.setText(this.aq.getExerciseId().size() - i1);
                this.bj.setVisibility(8);
                this.bi.setVisibility(8);
                this.bc.setVisibility(8);
                break;
              }
              Integer localInteger1 = (Integer)localIterator1.next();
              Boolean localBoolean1 = (Boolean)this.j.get(localInteger1);
              if (localBoolean1 == null)
                continue;
              boolean bool = localBoolean1.booleanValue();
              if (!bool)
                continue;
              i1++;
            }
          }
        int i8 = i1;
        int i9 = i4;
        int i7 = i5;
        break label1073;
        label1072: return;
        label1073: i3++;
        i5 = i7;
        i4 = i9;
        i1 = i8;
      }
    }
    catch (Exception localException)
    {
    }
  }

  private void j()
  {
    try
    {
      if ((this.B != null) && (this.B.size() > 0))
      {
        ((QuestionDetailFragment)this.B.get(this.b)).b((Exercises)this.A.get(this.b), this.b);
        int i1 = -1 + this.b;
        int i2 = 1 + this.b;
        if ((i1 >= 0) && (this.B.size() > i1))
          ((QuestionDetailFragment)this.B.get(i1)).b((Exercises)this.A.get(i1), i1);
        if ((i2 >= 0) && (i2 < this.B.size()))
          ((QuestionDetailFragment)this.B.get(i2)).b((Exercises)this.A.get(i2), i2);
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void k()
  {
    if (this.aH)
    {
      int i1 = Integer.parseInt(this.aC);
      int i2 = Integer.parseInt(this.aD);
      int i3 = Integer.parseInt(this.aE);
      this.ah = new com.withustudy.koudaizikao.custom.h(this.ag, 1000 * (i3 + 60 * (i2 + i1 * 60)), 1000);
      this.ah.start();
    }
  }

  private void l()
  {
    String str = com.withustudy.koudaizikao.g.b.b(1, this.bp);
    this.ag.setText(str);
  }

  private void m()
  {
    this.br = (7200 - this.bp);
    com.withustudy.koudaizikao.g.b.b(0, this.br);
  }

  private void n()
  {
    switch (this.r)
    {
    default:
    case 0:
    }
    do
      return;
    while (this.bq);
    this.bq = true;
    this.v.postDelayed(this.w, 1000L);
  }

  private void o()
  {
    this.bq = false;
    this.bs = true;
    h();
  }

  private void p()
  {
    while (true)
    {
      int i2;
      try
      {
        this.r = 101;
        this.B.clear();
        this.s = new ArrayList();
        this.t = new ArrayList();
        int i1 = this.aJ.size();
        HashMap localHashMap = this.a;
        i2 = 0;
        if (i2 < i1)
          continue;
        this.aw = true;
        if (!this.aw)
          continue;
        QuestionDetailFragment localQuestionDetailFragment1 = new QuestionDetailFragment();
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("exercises", null);
        localQuestionDetailFragment1.setArguments(localBundle);
        this.s.add(localQuestionDetailFragment1);
        this.t.add(null);
        this.B.addAll(this.s);
        this.y.notifyDataSetChanged();
        this.A.clear();
        this.A.addAll(this.t);
        com.withustudy.koudaizikao.g.h.a(this.y);
        this.aB.sendEmptyMessage(6);
        return;
        String str = (String)localHashMap.get(Integer.valueOf(i2));
        QuestionDetailFragment localQuestionDetailFragment2 = (QuestionDetailFragment)this.aJ.get(i2);
        Exercises localExercises = (Exercises)this.aK.get(i2);
        if ((str != null) && (!str.equals("")))
          continue;
        this.s.add(localQuestionDetailFragment2);
        this.t.add(localExercises);
        break label320;
        if (!str.equals("true"))
        {
          this.s.add(localQuestionDetailFragment2);
          this.t.add(localExercises);
        }
      }
      catch (Exception localException)
      {
        return;
      }
      label320: i2++;
    }
  }

  private void q()
  {
    Iterator localIterator;
    int i1;
    if (this.bt == null)
    {
      this.bt = new HashMap();
      if ((this.A != null) && (this.A.size() > 0))
      {
        localIterator = this.A.iterator();
        i1 = 0;
      }
    }
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Exercises localExercises = (Exercises)localIterator.next();
      if (localExercises == null)
        continue;
      this.bt.put(localExercises.getExerciseId(), Integer.valueOf(i1));
      i1++;
    }
  }

  protected void a()
  {
  }

  public void a(float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    getWindow().setAttributes(localLayoutParams);
  }

  public void a(int paramInt)
  {
    if (paramInt >= 0)
      try
      {
        if (paramInt > this.B.size())
          return;
        ((QuestionDetailFragment)this.B.get(paramInt)).b((Exercises)this.A.get(paramInt), paramInt);
        return;
      }
      catch (Exception localException)
      {
      }
  }

  public void a(Exercises paramExercises, HashMap<Integer, String> paramHashMap, boolean paramBoolean, double paramDouble1, double paramDouble2)
  {
    com.withustudy.koudaizikao.g.h.a("------------------insertToDb--------------------------------------");
    com.withustudy.koudaizikao.g.h.a("insertToDb 批次=" + this.u);
    Iterator localIterator = paramHashMap.keySet().iterator();
    UserAnsDao localUserAnsDao;
    String str1;
    String str4;
    while (true)
    {
      if (!localIterator.hasNext())
      {
        localUserAnsDao = com.withustudy.koudaizikao.e.a.a(this).a();
        a.a.a.e.i locali = localUserAnsDao.k();
        str1 = paramExercises.getExerciseId();
        KpointDetail localKpointDetail1 = paramExercises.getKpointDetail();
        String str2 = "";
        if (localKpointDetail1 != null)
        {
          Kpoint localKpoint2 = localKpointDetail1.getKpoint();
          if (localKpoint2 != null)
            str2 = localKpoint2.getId();
        }
        String str3 = str2 + str1;
        List localList = locali.a(UserAnsDao.Properties.c.a(str3), new k[0]).d();
        str4 = a(paramHashMap);
        if ((localList == null) || (localList.size() <= 0))
          break;
        koudai.db.h localh2 = (koudai.db.h)localList.get(0);
        String str7 = localh2.g();
        com.withustudy.koudaizikao.g.h.a("insertToDb 数据库的brushId=" + str7);
        localh2.d(str4);
        localh2.b(Boolean.valueOf(paramBoolean));
        localh2.a(Double.valueOf(paramDouble1));
        localh2.a(Boolean.valueOf(true));
        localh2.b(this.u);
        localh2.b(Long.valueOf(System.currentTimeMillis()));
        localUserAnsDao.i(localh2);
        return;
      }
      Integer localInteger = (Integer)localIterator.next();
      com.withustudy.koudaizikao.g.h.a("insertToDb opEdit.get(" + localInteger + ")=" + (String)paramHashMap.get(localInteger));
    }
    koudai.db.h localh1 = new koudai.db.h();
    localh1.b(Long.valueOf(System.currentTimeMillis()));
    localh1.c(a(paramExercises.getCorrectAnswer()));
    KpointDetail localKpointDetail2 = paramExercises.getKpointDetail();
    String str5 = "";
    if (localKpointDetail2 != null)
    {
      Kpoint localKpoint1 = localKpointDetail2.getKpoint();
      if (localKpoint1 != null)
      {
        str5 = localKpoint1.getId();
        localh1.f(str5);
      }
    }
    String str6 = str5 + str1;
    com.withustudy.koudaizikao.g.h.a("存入的数据excerId_kpointId", str6);
    localh1.a(str6);
    localh1.a(Double.valueOf(paramDouble1));
    localh1.b(Boolean.valueOf(paramBoolean));
    localh1.e(str1);
    localh1.a(Boolean.valueOf(true));
    localh1.g(this.c);
    localh1.d(str4);
    localh1.b(this.u);
    localUserAnsDao.c(localh1);
  }

  public void b()
  {
    if (1 + this.b <= -1 + this.A.size())
    {
      this.x.setCurrentItem(1 + this.b, true);
      return;
    }
    Toast.makeText(getApplicationContext(), "已经是最后一题", 0).show();
  }

  protected void b(int paramInt)
  {
    this.b = paramInt;
    ((QuestionDetailFragment)this.B.get(paramInt)).a((Exercises)this.A.get(paramInt), paramInt);
    Boolean localBoolean = (Boolean)this.ay.get(Integer.valueOf(paramInt));
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      this.am.setImageResource(2130837688);
      if (paramInt != -1 + this.B.size());
    }
    switch (this.e)
    {
    case 1:
    case 3:
    case 888:
    default:
    case 10:
      do
      {
        return;
        this.am.setImageResource(2130837677);
        break;
      }
      while ((this.h == null) || (this.h.size() <= 0));
      label263: label281: int i1;
      if (this.o == null)
      {
        this.o = new ExerciseIdList();
        this.o.setVersionName(this.mSP.p());
        this.o.setClientType(n.a());
        this.o.setImei(n.d(this.mContext));
        this.o.setNet(n.c(this.mContext));
        this.o.setExerciseId(new ArrayList());
        if (this.as != null)
          break label407;
        this.as = new ArrayList();
        i1 = this.h.size();
        com.withustudy.koudaizikao.g.h.a("总共size=" + i1);
      }
      for (int i2 = 0; ; i2++)
      {
        if (i2 >= 8);
        label407: 
        do
        {
          if (this.as.size() <= 0)
            break;
          this.ar = (8 + this.ar);
          this.o.setExerciseId(this.as);
          this.o.setUserSubject(this.f);
          this.o.setBrushType(a.b.f);
          c.b().U().a(this, this.o, 0);
          return;
          this.o.getExerciseId().clear();
          break label263;
          this.as.clear();
          break label281;
        }
        while (i2 + this.ar > i1 - 1);
        String str = ((ErrorExercise)this.h.get(i2)).getExerciseId();
        this.as.add(str);
      }
    case 9:
    case 12:
    }
    ReqBrushChapterGoNext localReqBrushChapterGoNext = new ReqBrushChapterGoNext();
    localReqBrushChapterGoNext.setVersionName(this.mSP.p());
    localReqBrushChapterGoNext.setClientType(n.a());
    localReqBrushChapterGoNext.setImei(n.d(this.mContext));
    localReqBrushChapterGoNext.setNet(n.c(this.mContext));
    localReqBrushChapterGoNext.setGetNextFlag(true);
    localReqBrushChapterGoNext.setUserSubject(this.f);
    c.b().l().a(this, localReqBrushChapterGoNext, 0);
  }

  protected void bindData()
  {
  }

  protected void c()
  {
    m();
  }

  protected void initData()
  {
    this.mProTools.a();
    this.u = (this.c + System.currentTimeMillis());
    switch (this.e)
    {
    default:
    case 15:
    case 17:
    case 10:
      do
      {
        return;
        this.p = true;
        this.o = new ExerciseIdList();
        this.o.setVersionName(this.mSP.p());
        this.o.setClientType(n.a());
        this.o.setImei(n.d(this.mContext));
        this.o.setNet(n.c(this.mContext));
        this.as = new ArrayList();
        FavoriteExercise localFavoriteExercise = (FavoriteExercise)this.ai.getSerializable("favoriteExercise");
        this.as.add(localFavoriteExercise.getExerciseId());
        this.o.setExerciseId(this.as);
        this.o.setUserSubject(this.f);
        this.o.setBrushType(a.b.e);
        c.b().U().a(this, this.o, 0);
        this.am.setImageResource(2130837677);
        this.ay.put(Integer.valueOf(this.b), Boolean.valueOf(true));
        return;
        if (this.p);
        for (boolean bool = false; ; bool = true)
        {
          this.p = bool;
          this.aB.sendEmptyMessage(0);
          return;
        }
        this.an = System.currentTimeMillis();
        this.p = false;
        this.h = ((ArrayList)this.ai.getSerializable("errorExercises"));
      }
      while ((this.h == null) || (this.h.size() <= 0));
      int i1;
      if (this.o == null)
      {
        this.o = new ExerciseIdList();
        this.o.setVersionName(this.mSP.p());
        this.o.setClientType(n.a());
        this.o.setImei(n.d(this.mContext));
        this.o.setNet(n.c(this.mContext));
        this.o.setExerciseId(new ArrayList());
        if (this.as != null)
          break label601;
        this.as = new ArrayList();
        i1 = this.h.size();
        com.withustudy.koudaizikao.g.h.a("总共size=" + i1);
      }
      for (int i2 = 0; ; i2++)
      {
        if (i2 >= 8);
        do
        {
          this.ar = (8 + this.ar);
          this.o.setExerciseId(this.as);
          this.o.setUserSubject(this.f);
          this.o.setBrushType(a.b.f);
          c.b().U().a(this, this.o, 0);
          return;
          this.o.getExerciseId().clear();
          break;
          this.as.clear();
          break label487;
        }
        while (i2 + this.ar > i1 - 1);
        String str4 = ((ErrorExercise)this.h.get(i2)).getExerciseId();
        this.as.add(str4);
      }
    case 1:
      this.H.setVisibility(0);
      KpointExcercise localKpointExcercise = new KpointExcercise();
      localKpointExcercise.setVersionName(this.mSP.p());
      localKpointExcercise.setClientType(n.a());
      localKpointExcercise.setImei(n.d(this.mContext));
      localKpointExcercise.setNet(n.c(this.mContext));
      localKpointExcercise.setUserSubject(this.f);
      localKpointExcercise.setKpointId(this.aj);
      c.b().R().a(this, localKpointExcercise, 0);
      return;
    case 888:
      this.H.setVisibility(0);
      IntellBrush localIntellBrush = new IntellBrush();
      localIntellBrush.setVersionName(this.mSP.p());
      localIntellBrush.setClientType(n.a());
      localIntellBrush.setImei(n.d(this.mContext));
      localIntellBrush.setNet(n.c(this.mContext));
      localIntellBrush.setUserSubject(this.f);
      c.b().v().a(this, localIntellBrush, 0);
      return;
    case 12:
      this.H.setVisibility(0);
      ReqBrushLast localReqBrushLast = new ReqBrushLast();
      localReqBrushLast.setVersionName(this.mSP.p());
      localReqBrushLast.setClientType(n.a());
      localReqBrushLast.setImei(n.d(this.mContext));
      localReqBrushLast.setNet(n.c(this.mContext));
      localReqBrushLast.setContinueLastFlag(true);
      localReqBrushLast.setUserSubject(this.f);
      this.mProTools.a();
      c.b().l().a(this, localReqBrushLast, 0);
      return;
    case 9:
      this.H.setVisibility(0);
      String str1 = this.ai.getString("section_id");
      String str2 = this.ai.getString("section_name");
      String str3 = this.ai.getString("section_sn");
      ReqChapterBrush localReqChapterBrush = new ReqChapterBrush();
      localReqChapterBrush.setVersionName(this.mSP.p());
      localReqChapterBrush.setClientType(n.a());
      localReqChapterBrush.setImei(n.d(this.mContext));
      localReqChapterBrush.setNet(n.c(this.mContext));
      BeginSection localBeginSection = new BeginSection();
      localBeginSection.setId(str1);
      localBeginSection.setName(str2);
      localBeginSection.setSn(str3);
      localReqChapterBrush.setBeginSection(localBeginSection);
      localReqChapterBrush.setUserSubject(this.f);
      c.b().l().a(this, localReqChapterBrush, 0);
      return;
    case 3:
      label487: this.an = System.currentTimeMillis();
      label601: this.I.setVisibility(0);
      ReqSimuExcerciseId localReqSimuExcerciseId = new ReqSimuExcerciseId();
      localReqSimuExcerciseId.setVersionName(this.mSP.p());
      localReqSimuExcerciseId.setClientType(n.a());
      localReqSimuExcerciseId.setImei(n.d(this.mContext));
      localReqSimuExcerciseId.setNet(n.c(this.mContext));
      localReqSimuExcerciseId.setLevel(this.ak);
      UserSubject localUserSubject2 = new UserSubject();
      localUserSubject2.setUid(this.mSP.i());
      localUserSubject2.setSubjectId(this.c);
      localReqSimuExcerciseId.setUserSubject(localUserSubject2);
      c.b().T().a(this, localReqSimuExcerciseId, 4);
      return;
    case 16:
    }
    this.an = System.currentTimeMillis();
    this.I.setVisibility(0);
    ReqOldExam localReqOldExam = new ReqOldExam();
    UserSubject localUserSubject1 = new UserSubject();
    localUserSubject1.setUid(this.mSP.i());
    localUserSubject1.setSubjectId(this.c);
    localReqOldExam.setUserSubject(localUserSubject1);
    try
    {
      localReqOldExam.setExamDate((ExamDate)this.ai.getSerializable("examDate"));
      label1293: c.b().ap().a(this, localReqOldExam, 4);
      return;
    }
    catch (Exception localException)
    {
      break label1293;
    }
  }

  protected void initListener()
  {
    switch (this.e)
    {
    default:
    case 1:
    case 9:
    case 10:
    case 12:
    case 15:
    case 17:
    case 888:
    case 3:
    case 16:
    }
    while (true)
    {
      this.x.setOnPageChangeListener(new av(this));
      return;
      this.D.setOnClickListener(this);
      this.E.setOnClickListener(this);
      this.F.setOnClickListener(this);
      this.G.setOnClickListener(this);
      continue;
      this.J.setOnClickListener(this);
      this.M.setOnClickListener(this);
      this.L.setOnClickListener(this);
      this.J.setOnClickListener(this);
    }
  }

  protected void initView()
  {
    try
    {
      this.ai = getIntent().getExtras();
      this.e = this.ai.getInt("FromPage");
      this.c = this.ai.getString("subjectId");
      this.R = this.mSP.i();
      this.f = new UserSubject();
      this.f.setUid(this.R);
      this.f.setSubjectId(this.c);
      this.al = this.ai.getString("subjectName");
      this.aj = this.ai.getString("kpointId");
      this.ak = this.ai.getString("level");
      label125: this.x = ((ViewPager)findViewById(2131296652));
      this.F = ((LinearLayout)findViewById(2131296641));
      this.am = ((ImageView)findViewById(2131296642));
      switch (this.e)
      {
      default:
        return;
      case 1:
      case 9:
      case 10:
      case 12:
      case 15:
      case 17:
      case 888:
        this.d = false;
        this.H = ((RelativeLayout)findViewById(2131296493));
        this.D = ((LinearLayout)findViewById(2131296636));
        this.af = ((TextView)findViewById(2131296637));
        this.af.setText(this.al);
        this.E = ((LinearLayout)findViewById(2131296638));
        this.q = ((TextView)findViewById(2131296639));
        this.G = ((LinearLayout)findViewById(2131296494));
        this.G = ((LinearLayout)findViewById(2131296494));
        this.H.setVisibility(0);
        return;
      case 3:
      case 16:
      }
      this.d = true;
      this.I = ((RelativeLayout)findViewById(2131296643));
      this.J = ((LinearLayout)findViewById(2131296644));
      this.L = ((LinearLayout)findViewById(2131296645));
      this.N = ((LinearLayout)findViewById(2131296649));
      this.O = ((ImageView)findViewById(2131296646));
      this.P = ((ImageView)findViewById(2131296648));
      this.Q = ((ImageView)findViewById(2131296650));
      this.K = ((LinearLayout)findViewById(2131296635));
      this.M = ((LinearLayout)findViewById(2131296647));
      this.ag = ((TextView)findViewById(2131296651));
      this.H = ((RelativeLayout)findViewById(2131296493));
      this.H.setVisibility(8);
      this.I.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      break label125;
    }
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.r = paramInt2;
    Iterator localIterator2;
    label54: Iterator localIterator1;
    if (paramInt2 != 102)
    {
      if (this.aJ == null)
      {
        com.withustudy.koudaizikao.g.h.a(this.A);
        this.aJ = new ArrayList();
        localIterator2 = this.B.iterator();
        if (localIterator2.hasNext())
          break label133;
      }
      if (this.aK == null)
      {
        this.aK = new ArrayList();
        localIterator1 = this.A.iterator();
      }
    }
    while (true)
    {
      if (!localIterator1.hasNext());
      switch (paramInt2)
      {
      default:
        return;
        label133: QuestionDetailFragment localQuestionDetailFragment = (QuestionDetailFragment)localIterator2.next();
        this.aJ.add(localQuestionDetailFragment);
        break label54;
        Exercises localExercises = (Exercises)localIterator1.next();
        this.aK.add(localExercises);
      case 102:
      case 100:
      case 101:
      }
    }
    finish(0, 0);
    return;
    this.aI = true;
    i();
    c(0);
    this.H = ((RelativeLayout)findViewById(2131296493));
    this.D = ((LinearLayout)findViewById(2131296636));
    this.E = ((LinearLayout)findViewById(2131296638));
    this.aG = ((ImageView)findViewById(2131296640));
    this.q = ((TextView)findViewById(2131296639));
    this.F = ((LinearLayout)findViewById(2131296641));
    this.G = ((LinearLayout)findViewById(2131296494));
    this.G = ((LinearLayout)findViewById(2131296494));
    this.D.setOnClickListener(this);
    this.E.setOnClickListener(this);
    this.F.setOnClickListener(this);
    this.G.setOnClickListener(this);
    this.H.setVisibility(0);
    this.I.setVisibility(8);
    this.q.setVisibility(8);
    this.aG.setVisibility(0);
    this.aG.setBackgroundResource(2130838067);
    return;
    this.aI = true;
    p();
    this.H = ((RelativeLayout)findViewById(2131296493));
    this.D = ((LinearLayout)findViewById(2131296636));
    this.E = ((LinearLayout)findViewById(2131296638));
    this.aG = ((ImageView)findViewById(2131296640));
    this.q = ((TextView)findViewById(2131296639));
    this.F = ((LinearLayout)findViewById(2131296641));
    this.G = ((LinearLayout)findViewById(2131296494));
    this.G = ((LinearLayout)findViewById(2131296494));
    this.D.setOnClickListener(this);
    this.E.setOnClickListener(this);
    this.F.setOnClickListener(this);
    this.G.setOnClickListener(this);
    this.H.setVisibility(0);
    this.I.setVisibility(8);
    this.q.setVisibility(8);
    this.aG.setVisibility(0);
    this.aG.setBackgroundResource(2130838067);
  }

  public void onBackPressed()
  {
    if (this.aF)
    {
      switch (this.e)
      {
      default:
        super.onBackPressed();
        return;
      case 3:
      case 16:
      }
      switch (this.r)
      {
      default:
        com.withustudy.koudaizikao.g.h.a("resultCode", "default");
        o();
        return;
      case 100:
        com.withustudy.koudaizikao.g.h.a("resultCode", Integer.valueOf(this.r));
        d();
        return;
      case 101:
      }
      com.withustudy.koudaizikao.g.h.a("resultCode", Integer.valueOf(this.r));
      d();
      return;
    }
    super.onBackPressed();
  }

  public void onClick(View paramView)
  {
    while (true)
    {
      try
      {
        switch (paramView.getId())
        {
        case 2131296636:
          onBackPressed();
          return;
        case 2131296641:
          if ((this.A == null) || (this.A.size() <= 0))
            continue;
          switch (this.e)
          {
          default:
            this.mProTools.a();
            Boolean localBoolean = (Boolean)this.ay.get(Integer.valueOf(this.b));
            if ((localBoolean == null) || (!localBoolean.booleanValue()))
              continue;
            ReqDeleFavor localReqDeleFavor = new ReqDeleFavor();
            localReqDeleFavor.setVersionName(this.mSP.p());
            localReqDeleFavor.setClientType(n.a());
            localReqDeleFavor.setImei(n.d(this.mContext));
            localReqDeleFavor.setNet(n.c(this.mContext));
            UserSubject localUserSubject = new UserSubject();
            localUserSubject.setUid(this.mSP.i());
            localUserSubject.setSubjectId(this.c);
            localReqDeleFavor.setUserSubject(localUserSubject);
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(((Exercises)this.A.get(this.b)).getExerciseId());
            localReqDeleFavor.setExerciseId(localArrayList);
            c.b().ao().a(this, localReqDeleFavor, 8);
            return;
          case 9:
          case 12:
            g.b(this.mContext, "brush_c_collect");
            break;
          case 888:
          }
          g.b(this.mContext, "brush_i_collect");
          continue;
          ReqFavoriteExercise localReqFavoriteExercise = new ReqFavoriteExercise();
          localReqFavoriteExercise.setVersionName(this.mSP.p());
          localReqFavoriteExercise.setClientType(n.a());
          localReqFavoriteExercise.setImei(n.d(this.mContext));
          localReqFavoriteExercise.setNet(n.c(this.mContext));
          localReqFavoriteExercise.setUserSubject(this.f);
          FavoriteExercise localFavoriteExercise = new FavoriteExercise();
          Exercises localExercises = (Exercises)this.A.get(this.b);
          localFavoriteExercise.setStemText(localExercises.getStem().getText());
          if (localExercises == null)
            continue;
          String str2 = localExercises.getCategory();
          localFavoriteExercise.setTime(System.currentTimeMillis());
          localFavoriteExercise.setCategory(str2);
          localFavoriteExercise.setExerciseId(localExercises.getExerciseId());
          KpointDetail localKpointDetail = localExercises.getKpointDetail();
          if (localKpointDetail == null)
            continue;
          localFavoriteExercise.setKpoint(localKpointDetail.getKpoint());
          localReqFavoriteExercise.setFavoriteExercise(localFavoriteExercise);
          c.b().ad().a(this, localReqFavoriteExercise, 5);
          return;
          com.withustudy.koudaizikao.g.h.a("知识点KpointDetail字段为null");
          break;
        case 2131296494:
          if ((this.A == null) || (this.A.size() <= 0))
            continue;
          switch (this.e)
          {
          default:
            String str1 = "?subjectid=" + this.c;
            com.withustudy.koudaizikao.a.a locala = c.b().at();
            String[] arrayOfString = new String[1];
            arrayOfString[0] = ("http://share.kdzikao.com/brush/share.page" + str1);
            locala.a(this, arrayOfString, 101, this);
            return;
          case 9:
          case 12:
            g.b(this.mContext, "brush_c_share");
            break;
          case 888:
          }
          g.b(this.mContext, "brush_i_share");
          break;
        case 2131296638:
          if ((this.A == null) || (this.A.size() <= 0))
            continue;
          if ((this.r != 100) && (this.r != 101))
            continue;
          i();
          return;
          switch (this.e)
          {
          default:
            boolean bool1 = this.p;
            bool2 = false;
            if (!bool1)
              break label1299;
            this.p = bool2;
            if (!this.p)
              continue;
            this.q.setText("试题");
            j();
            return;
          case 9:
          case 12:
            g.b(this.mContext, "brush_c_show_answer");
            break;
          case 888:
          }
          g.b(this.mContext, "brush_i_show_answer");
          continue;
          this.q.setText("讲解");
          break;
        case 2131296644:
          if (!this.aF)
            continue;
          o();
          return;
          finish();
          return;
        case 2131296645:
          this.bs = false;
          this.bq = false;
          this.aO = 0;
          h();
          return;
        case 2131296647:
          this.bq = false;
          if ((this.A == null) || (this.A.size() <= 0))
            continue;
          this.aO = 1;
          g.b(this.mContext, "test_answer_card");
          i();
          return;
        case 2131297523:
          if (this.aO != 0)
            continue;
          this.aX.dismiss();
          this.aX = null;
          this.aB.sendEmptyMessageDelayed(2, 100L);
          return;
          this.aX.dismiss();
          this.aX = null;
          a(1.0F);
          k();
          return;
        case 2131297535:
          g();
          n();
          return;
        case 2131297540:
          g.b(this.mContext, "test_continue");
          g();
          n();
          return;
        case 2131297541:
          if (!this.bs)
            continue;
          g.b(this.mContext, "test_submit_now");
          this.ao = System.currentTimeMillis();
          d();
          return;
          g.b(this.mContext, "test_show_paper");
          i();
          return;
        case 2131296842:
          if (!this.bs)
            continue;
          finish();
          return;
          g.b(this.mContext, "test_submit_now");
          this.ao = System.currentTimeMillis();
          d();
          return;
        case 2131297524:
          f();
          if (this.aO == 0)
            continue;
          n();
          return;
        case 2131297533:
          if (!this.aI)
            continue;
          p();
          this.aX.dismiss();
          return;
          n();
          this.aX.dismiss();
          this.aX = null;
          g();
          return;
        case 2131297534:
          if (!this.aI)
            continue;
          c(0);
          f();
          g.b(this.mContext, "test_answer_card_form_start");
          return;
          this.ao = System.currentTimeMillis();
          d();
        case 2131296836:
        case 2131296844:
        case 2131296845:
        case 2131296846:
        case 2131296847:
        }
        return;
      }
      catch (Exception localException)
      {
        return;
      }
      label1299: boolean bool2 = true;
    }
  }

  public void onDestroy()
  {
    try
    {
      super.onDestroy();
      if (this.aP != null)
      {
        this.aP.dismiss();
        this.aP = null;
      }
      if (this.aX != null)
      {
        this.aX.dismiss();
        this.aX = null;
      }
      if (this.aA != null)
      {
        this.aA.c();
        this.aA = null;
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void onRestart()
  {
    super.onRestart();
  }

  protected void onResume()
  {
    super.onResume();
  }

  public void onStop()
  {
    try
    {
      super.onStop();
      if (this.r != 100)
        if (this.r == 101)
          return;
      switch (this.e)
      {
      case 1:
        a(a.b.a, 0.0D);
        return;
      case 10:
        a(a.b.f, 0.0D);
        return;
      case 888:
        a(a.b.b, 0.0D);
        return;
      case 12:
        a(a.b.a, 0.0D);
        return;
      case 9:
        a(a.b.a, 0.0D);
      case 3:
      case 17:
        return;
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  // ERROR //
  public void onSuccess(String paramString1, java.util.Map<String, String> paramMap, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: aload_3
    //   4: iload 4
    //   6: invokespecial 1550	com/withustudy/koudaizikao/base/AbsBaseActivity:onSuccess	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V
    //   9: invokestatic 1552	com/withustudy/koudaizikao/g/h:a	()Z
    //   12: ifeq +11 -> 23
    //   15: aload_0
    //   16: getfield 777	com/withustudy/koudaizikao/activity/QuestionDetailActivity:mSP	Lcom/withustudy/koudaizikao/d/f;
    //   19: aload_1
    //   20: invokevirtual 1553	com/withustudy/koudaizikao/d/f:e	(Ljava/lang/String;)V
    //   23: aload_0
    //   24: getfield 197	com/withustudy/koudaizikao/activity/QuestionDetailActivity:C	Z
    //   27: ifeq +109 -> 136
    //   30: aload_0
    //   31: iconst_0
    //   32: putfield 197	com/withustudy/koudaizikao/activity/QuestionDetailActivity:C	Z
    //   35: aload_0
    //   36: getfield 199	com/withustudy/koudaizikao/activity/QuestionDetailActivity:d	Z
    //   39: ifeq +82 -> 121
    //   42: aload_0
    //   43: getfield 232	com/withustudy/koudaizikao/activity/QuestionDetailActivity:aB	Landroid/os/Handler;
    //   46: iconst_1
    //   47: ldc2_w 1554
    //   50: invokevirtual 1514	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   53: pop
    //   54: aload_1
    //   55: ifnull +65 -> 120
    //   58: new 1557	com/google/gson/Gson
    //   61: dup
    //   62: invokespecial 1558	com/google/gson/Gson:<init>	()V
    //   65: astore 5
    //   67: iload 4
    //   69: lookupswitch	default:+51->120, 0:+77->146, 4:+572->641, 5:+987->1056, 8:+1032->1101, 101:+1088->1157
    //   121: aload_0
    //   122: getfield 232	com/withustudy/koudaizikao/activity/QuestionDetailActivity:aB	Landroid/os/Handler;
    //   125: iconst_1
    //   126: ldc2_w 1559
    //   129: invokevirtual 1514	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   132: pop
    //   133: goto -79 -> 54
    //   136: aload_0
    //   137: getfield 925	com/withustudy/koudaizikao/activity/QuestionDetailActivity:mProTools	Lcom/withustudy/koudaizikao/g/l;
    //   140: invokevirtual 1562	com/withustudy/koudaizikao/g/l:b	()V
    //   143: goto -89 -> 54
    //   146: aload_0
    //   147: aload 5
    //   149: aload_1
    //   150: ldc_w 1564
    //   153: invokevirtual 1568	com/google/gson/Gson:fromJson	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   156: checkcast 1564	com/withustudy/koudaizikao/entity/BrushExcerciseBean
    //   159: putfield 290	com/withustudy/koudaizikao/activity/QuestionDetailActivity:z	Lcom/withustudy/koudaizikao/entity/BrushExcerciseBean;
    //   162: aload_0
    //   163: getfield 290	com/withustudy/koudaizikao/activity/QuestionDetailActivity:z	Lcom/withustudy/koudaizikao/entity/BrushExcerciseBean;
    //   166: ifnull +458 -> 624
    //   169: aload_0
    //   170: getfield 232	com/withustudy/koudaizikao/activity/QuestionDetailActivity:aB	Landroid/os/Handler;
    //   173: iconst_0
    //   174: invokevirtual 901	android/os/Handler:sendEmptyMessage	(I)Z
    //   177: pop
    //   178: aload_0
    //   179: getfield 201	com/withustudy/koudaizikao/activity/QuestionDetailActivity:e	I
    //   182: iconst_3
    //   183: if_icmpeq +335 -> 518
    //   186: aload_0
    //   187: getfield 201	com/withustudy/koudaizikao/activity/QuestionDetailActivity:e	I
    //   190: istore 32
    //   192: iconst_0
    //   193: istore 26
    //   195: iload 32
    //   197: bipush 16
    //   199: if_icmpeq +319 -> 518
    //   202: aload_0
    //   203: getfield 199	com/withustudy/koudaizikao/activity/QuestionDetailActivity:d	Z
    //   206: ifeq -86 -> 120
    //   209: iload 26
    //   211: ifeq -91 -> 120
    //   214: aload_0
    //   215: getfield 353	com/withustudy/koudaizikao/activity/QuestionDetailActivity:r	I
    //   218: ifne -98 -> 120
    //   221: aload_0
    //   222: getfield 221	com/withustudy/koudaizikao/activity/QuestionDetailActivity:av	Z
    //   225: ifeq -105 -> 120
    //   228: aload_0
    //   229: iconst_0
    //   230: putfield 221	com/withustudy/koudaizikao/activity/QuestionDetailActivity:av	Z
    //   233: aload_0
    //   234: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   237: ifnonnull +287 -> 524
    //   240: aload_0
    //   241: new 615	com/withustudy/koudaizikao/entity/req/ExerciseIdList
    //   244: dup
    //   245: invokespecial 1117	com/withustudy/koudaizikao/entity/req/ExerciseIdList:<init>	()V
    //   248: putfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   251: aload_0
    //   252: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   255: aload_0
    //   256: getfield 777	com/withustudy/koudaizikao/activity/QuestionDetailActivity:mSP	Lcom/withustudy/koudaizikao/d/f;
    //   259: invokevirtual 1119	com/withustudy/koudaizikao/d/f:p	()Ljava/lang/String;
    //   262: invokevirtual 1122	com/withustudy/koudaizikao/entity/req/ExerciseIdList:setVersionName	(Ljava/lang/String;)V
    //   265: aload_0
    //   266: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   269: invokestatic 1124	com/withustudy/koudaizikao/g/n:a	()Ljava/lang/String;
    //   272: invokevirtual 1127	com/withustudy/koudaizikao/entity/req/ExerciseIdList:setClientType	(Ljava/lang/String;)V
    //   275: aload_0
    //   276: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   279: aload_0
    //   280: getfield 643	com/withustudy/koudaizikao/activity/QuestionDetailActivity:mContext	Landroid/content/Context;
    //   283: invokestatic 1130	com/withustudy/koudaizikao/g/n:d	(Landroid/content/Context;)Ljava/lang/String;
    //   286: invokevirtual 1133	com/withustudy/koudaizikao/entity/req/ExerciseIdList:setImei	(Ljava/lang/String;)V
    //   289: aload_0
    //   290: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   293: aload_0
    //   294: getfield 643	com/withustudy/koudaizikao/activity/QuestionDetailActivity:mContext	Landroid/content/Context;
    //   297: invokestatic 1135	com/withustudy/koudaizikao/g/n:c	(Landroid/content/Context;)Ljava/lang/String;
    //   300: invokevirtual 1138	com/withustudy/koudaizikao/entity/req/ExerciseIdList:setNet	(Ljava/lang/String;)V
    //   303: aload_0
    //   304: getfield 1144	com/withustudy/koudaizikao/activity/QuestionDetailActivity:as	Ljava/util/List;
    //   307: ifnonnull +232 -> 539
    //   310: aload_0
    //   311: new 190	java/util/ArrayList
    //   314: dup
    //   315: invokespecial 191	java/util/ArrayList:<init>	()V
    //   318: putfield 1144	com/withustudy/koudaizikao/activity/QuestionDetailActivity:as	Ljava/util/List;
    //   321: aload_0
    //   322: getfield 613	com/withustudy/koudaizikao/activity/QuestionDetailActivity:aq	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   325: invokevirtual 618	com/withustudy/koudaizikao/entity/req/ExerciseIdList:getExerciseId	()Ljava/util/List;
    //   328: astore 27
    //   330: aload 27
    //   332: ifnull -212 -> 120
    //   335: aload 27
    //   337: invokeinterface 349 1 0
    //   342: ifle -222 -> 120
    //   345: aload_0
    //   346: getfield 217	com/withustudy/koudaizikao/activity/QuestionDetailActivity:ar	I
    //   349: istore 28
    //   351: iload 28
    //   353: aload 27
    //   355: invokeinterface 349 1 0
    //   360: if_icmplt +191 -> 551
    //   363: aload_0
    //   364: getfield 1144	com/withustudy/koudaizikao/activity/QuestionDetailActivity:as	Ljava/util/List;
    //   367: invokeinterface 349 1 0
    //   372: ifle -252 -> 120
    //   375: new 325	java/lang/StringBuilder
    //   378: dup
    //   379: ldc_w 1570
    //   382: invokespecial 332	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   385: aload_0
    //   386: getfield 1144	com/withustudy/koudaizikao/activity/QuestionDetailActivity:as	Ljava/util/List;
    //   389: invokeinterface 349 1 0
    //   394: invokevirtual 682	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: invokevirtual 342	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 432	com/withustudy/koudaizikao/g/h:a	(Ljava/lang/Object;)V
    //   403: aload_0
    //   404: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   407: aload_0
    //   408: getfield 1144	com/withustudy/koudaizikao/activity/QuestionDetailActivity:as	Ljava/util/List;
    //   411: invokevirtual 1142	com/withustudy/koudaizikao/entity/req/ExerciseIdList:setExerciseId	(Ljava/util/List;)V
    //   414: aload_0
    //   415: getfield 201	com/withustudy/koudaizikao/activity/QuestionDetailActivity:e	I
    //   418: bipush 16
    //   420: if_icmpne +177 -> 597
    //   423: new 1300	com/withustudy/koudaizikao/entity/req/UserSubject
    //   426: dup
    //   427: invokespecial 1301	com/withustudy/koudaizikao/entity/req/UserSubject:<init>	()V
    //   430: astore 29
    //   432: aload 29
    //   434: aload_0
    //   435: getfield 777	com/withustudy/koudaizikao/activity/QuestionDetailActivity:mSP	Lcom/withustudy/koudaizikao/d/f;
    //   438: invokevirtual 1303	com/withustudy/koudaizikao/d/f:i	()Ljava/lang/String;
    //   441: invokevirtual 1306	com/withustudy/koudaizikao/entity/req/UserSubject:setUid	(Ljava/lang/String;)V
    //   444: aload 29
    //   446: aload_0
    //   447: getfield 409	com/withustudy/koudaizikao/activity/QuestionDetailActivity:c	Ljava/lang/String;
    //   450: invokevirtual 1309	com/withustudy/koudaizikao/entity/req/UserSubject:setSubjectId	(Ljava/lang/String;)V
    //   453: aload_0
    //   454: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   457: aload 29
    //   459: invokevirtual 1152	com/withustudy/koudaizikao/entity/req/ExerciseIdList:setUserSubject	(Lcom/withustudy/koudaizikao/entity/req/UserSubject;)V
    //   462: aload_0
    //   463: getfield 201	com/withustudy/koudaizikao/activity/QuestionDetailActivity:e	I
    //   466: tableswitch	default:+18 -> 484, 16:+145->611
    //   485: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   488: getstatic 562	com/withustudy/koudaizikao/d/a$b:c	Ljava/lang/String;
    //   491: invokevirtual 1157	com/withustudy/koudaizikao/entity/req/ExerciseIdList:setBrushType	(Ljava/lang/String;)V
    //   494: invokestatic 1162	com/withustudy/koudaizikao/a/c:b	()Lcom/withustudy/koudaizikao/a/c;
    //   497: invokevirtual 1165	com/withustudy/koudaizikao/a/c:U	()Lcom/withustudy/koudaizikao/a/b;
    //   500: aload_0
    //   501: aload_0
    //   502: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   505: iconst_0
    //   506: invokevirtual 1170	com/withustudy/koudaizikao/a/b:a	(Lcom/android/http/n$a;Ljava/lang/Object;I)V
    //   509: return
    //   510: astore 23
    //   512: aload 23
    //   514: invokevirtual 1573	java/lang/Exception:printStackTrace	()V
    //   517: return
    //   518: iconst_1
    //   519: istore 26
    //   521: goto -319 -> 202
    //   524: aload_0
    //   525: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   528: invokevirtual 618	com/withustudy/koudaizikao/entity/req/ExerciseIdList:getExerciseId	()Ljava/util/List;
    //   531: invokeinterface 497 1 0
    //   536: goto -233 -> 303
    //   539: aload_0
    //   540: getfield 1144	com/withustudy/koudaizikao/activity/QuestionDetailActivity:as	Ljava/util/List;
    //   543: invokeinterface 497 1 0
    //   548: goto -227 -> 321
    //   551: aload 27
    //   553: iload 28
    //   555: invokeinterface 930 2 0
    //   560: checkcast 319	java/lang/String
    //   563: astore 30
    //   565: iload 28
    //   567: iconst_m1
    //   568: aload 27
    //   570: invokeinterface 349 1 0
    //   575: iadd
    //   576: if_icmpgt -213 -> 363
    //   579: aload_0
    //   580: getfield 1144	com/withustudy/koudaizikao/activity/QuestionDetailActivity:as	Ljava/util/List;
    //   583: aload 30
    //   585: invokeinterface 452 2 0
    //   590: pop
    //   591: iinc 28 1
    //   594: goto -243 -> 351
    //   597: aload_0
    //   598: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   601: aload_0
    //   602: getfield 1148	com/withustudy/koudaizikao/activity/QuestionDetailActivity:f	Lcom/withustudy/koudaizikao/entity/req/UserSubject;
    //   605: invokevirtual 1152	com/withustudy/koudaizikao/entity/req/ExerciseIdList:setUserSubject	(Lcom/withustudy/koudaizikao/entity/req/UserSubject;)V
    //   608: goto -146 -> 462
    //   611: aload_0
    //   612: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   615: getstatic 635	com/withustudy/koudaizikao/d/a$b:d	Ljava/lang/String;
    //   618: invokevirtual 1157	com/withustudy/koudaizikao/entity/req/ExerciseIdList:setBrushType	(Ljava/lang/String;)V
    //   621: goto -127 -> 494
    //   624: ldc_w 1575
    //   627: invokestatic 432	com/withustudy/koudaizikao/g/h:a	(Ljava/lang/Object;)V
    //   630: aload_0
    //   631: getfield 232	com/withustudy/koudaizikao/activity/QuestionDetailActivity:aB	Landroid/os/Handler;
    //   634: bipush 10
    //   636: invokevirtual 901	android/os/Handler:sendEmptyMessage	(I)Z
    //   639: pop
    //   640: return
    //   641: aload_0
    //   642: aload 5
    //   644: aload_1
    //   645: ldc_w 615
    //   648: invokevirtual 1568	com/google/gson/Gson:fromJson	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   651: checkcast 615	com/withustudy/koudaizikao/entity/req/ExerciseIdList
    //   654: putfield 613	com/withustudy/koudaizikao/activity/QuestionDetailActivity:aq	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   657: aload_0
    //   658: getfield 613	com/withustudy/koudaizikao/activity/QuestionDetailActivity:aq	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   661: ifnull +388 -> 1049
    //   664: aload_0
    //   665: getfield 613	com/withustudy/koudaizikao/activity/QuestionDetailActivity:aq	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   668: invokevirtual 618	com/withustudy/koudaizikao/entity/req/ExerciseIdList:getExerciseId	()Ljava/util/List;
    //   671: astore 16
    //   673: aload 16
    //   675: ifnull +363 -> 1038
    //   678: aload 16
    //   680: invokeinterface 349 1 0
    //   685: ifle +353 -> 1038
    //   688: new 325	java/lang/StringBuilder
    //   691: dup
    //   692: ldc_w 1577
    //   695: invokespecial 332	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   698: aload_0
    //   699: getfield 613	com/withustudy/koudaizikao/activity/QuestionDetailActivity:aq	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   702: invokevirtual 618	com/withustudy/koudaizikao/entity/req/ExerciseIdList:getExerciseId	()Ljava/util/List;
    //   705: invokeinterface 349 1 0
    //   710: invokevirtual 682	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   713: invokevirtual 342	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   716: invokestatic 432	com/withustudy/koudaizikao/g/h:a	(Ljava/lang/Object;)V
    //   719: aload_0
    //   720: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   723: ifnonnull +243 -> 966
    //   726: aload_0
    //   727: new 615	com/withustudy/koudaizikao/entity/req/ExerciseIdList
    //   730: dup
    //   731: invokespecial 1117	com/withustudy/koudaizikao/entity/req/ExerciseIdList:<init>	()V
    //   734: putfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   737: aload_0
    //   738: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   741: aload_0
    //   742: getfield 777	com/withustudy/koudaizikao/activity/QuestionDetailActivity:mSP	Lcom/withustudy/koudaizikao/d/f;
    //   745: invokevirtual 1119	com/withustudy/koudaizikao/d/f:p	()Ljava/lang/String;
    //   748: invokevirtual 1122	com/withustudy/koudaizikao/entity/req/ExerciseIdList:setVersionName	(Ljava/lang/String;)V
    //   751: aload_0
    //   752: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   755: invokestatic 1124	com/withustudy/koudaizikao/g/n:a	()Ljava/lang/String;
    //   758: invokevirtual 1127	com/withustudy/koudaizikao/entity/req/ExerciseIdList:setClientType	(Ljava/lang/String;)V
    //   761: aload_0
    //   762: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   765: aload_0
    //   766: getfield 643	com/withustudy/koudaizikao/activity/QuestionDetailActivity:mContext	Landroid/content/Context;
    //   769: invokestatic 1130	com/withustudy/koudaizikao/g/n:d	(Landroid/content/Context;)Ljava/lang/String;
    //   772: invokevirtual 1133	com/withustudy/koudaizikao/entity/req/ExerciseIdList:setImei	(Ljava/lang/String;)V
    //   775: aload_0
    //   776: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   779: aload_0
    //   780: getfield 643	com/withustudy/koudaizikao/activity/QuestionDetailActivity:mContext	Landroid/content/Context;
    //   783: invokestatic 1135	com/withustudy/koudaizikao/g/n:c	(Landroid/content/Context;)Ljava/lang/String;
    //   786: invokevirtual 1138	com/withustudy/koudaizikao/entity/req/ExerciseIdList:setNet	(Ljava/lang/String;)V
    //   789: aload_0
    //   790: getfield 1144	com/withustudy/koudaizikao/activity/QuestionDetailActivity:as	Ljava/util/List;
    //   793: ifnonnull +188 -> 981
    //   796: aload_0
    //   797: new 190	java/util/ArrayList
    //   800: dup
    //   801: invokespecial 191	java/util/ArrayList:<init>	()V
    //   804: putfield 1144	com/withustudy/koudaizikao/activity/QuestionDetailActivity:as	Ljava/util/List;
    //   807: aload_0
    //   808: getfield 613	com/withustudy/koudaizikao/activity/QuestionDetailActivity:aq	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   811: invokevirtual 618	com/withustudy/koudaizikao/entity/req/ExerciseIdList:getExerciseId	()Ljava/util/List;
    //   814: astore 18
    //   816: aload_0
    //   817: aload 18
    //   819: invokeinterface 349 1 0
    //   824: putfield 219	com/withustudy/koudaizikao/activity/QuestionDetailActivity:at	I
    //   827: aload 18
    //   829: ifnull -709 -> 120
    //   832: aload_0
    //   833: getfield 219	com/withustudy/koudaizikao/activity/QuestionDetailActivity:at	I
    //   836: istore 19
    //   838: iconst_0
    //   839: istore 20
    //   841: iload 19
    //   843: ifle -723 -> 120
    //   846: iload 20
    //   848: aload_0
    //   849: getfield 219	com/withustudy/koudaizikao/activity/QuestionDetailActivity:at	I
    //   852: if_icmplt +141 -> 993
    //   855: aload_0
    //   856: getfield 1144	com/withustudy/koudaizikao/activity/QuestionDetailActivity:as	Ljava/util/List;
    //   859: invokeinterface 349 1 0
    //   864: ifle -744 -> 120
    //   867: new 325	java/lang/StringBuilder
    //   870: dup
    //   871: ldc_w 1570
    //   874: invokespecial 332	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   877: aload_0
    //   878: getfield 1144	com/withustudy/koudaizikao/activity/QuestionDetailActivity:as	Ljava/util/List;
    //   881: invokeinterface 349 1 0
    //   886: invokevirtual 682	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   889: invokevirtual 342	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   892: invokestatic 432	com/withustudy/koudaizikao/g/h:a	(Ljava/lang/Object;)V
    //   895: aload_0
    //   896: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   899: aload_0
    //   900: getfield 1144	com/withustudy/koudaizikao/activity/QuestionDetailActivity:as	Ljava/util/List;
    //   903: invokevirtual 1142	com/withustudy/koudaizikao/entity/req/ExerciseIdList:setExerciseId	(Ljava/util/List;)V
    //   906: aload_0
    //   907: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   910: aload_0
    //   911: getfield 1148	com/withustudy/koudaizikao/activity/QuestionDetailActivity:f	Lcom/withustudy/koudaizikao/entity/req/UserSubject;
    //   914: invokevirtual 1152	com/withustudy/koudaizikao/entity/req/ExerciseIdList:setUserSubject	(Lcom/withustudy/koudaizikao/entity/req/UserSubject;)V
    //   917: aload_0
    //   918: getfield 201	com/withustudy/koudaizikao/activity/QuestionDetailActivity:e	I
    //   921: tableswitch	default:+19 -> 940, 16:+104->1025
    //   941: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   944: getstatic 562	com/withustudy/koudaizikao/d/a$b:c	Ljava/lang/String;
    //   947: invokevirtual 1157	com/withustudy/koudaizikao/entity/req/ExerciseIdList:setBrushType	(Ljava/lang/String;)V
    //   950: invokestatic 1162	com/withustudy/koudaizikao/a/c:b	()Lcom/withustudy/koudaizikao/a/c;
    //   953: invokevirtual 1165	com/withustudy/koudaizikao/a/c:U	()Lcom/withustudy/koudaizikao/a/b;
    //   956: aload_0
    //   957: aload_0
    //   958: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   961: iconst_0
    //   962: invokevirtual 1170	com/withustudy/koudaizikao/a/b:a	(Lcom/android/http/n$a;Ljava/lang/Object;I)V
    //   965: return
    //   966: aload_0
    //   967: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   970: invokevirtual 618	com/withustudy/koudaizikao/entity/req/ExerciseIdList:getExerciseId	()Ljava/util/List;
    //   973: invokeinterface 497 1 0
    //   978: goto -189 -> 789
    //   981: aload_0
    //   982: getfield 1144	com/withustudy/koudaizikao/activity/QuestionDetailActivity:as	Ljava/util/List;
    //   985: invokeinterface 497 1 0
    //   990: goto -183 -> 807
    //   993: aload 18
    //   995: iload 20
    //   997: invokeinterface 930 2 0
    //   1002: checkcast 319	java/lang/String
    //   1005: astore 21
    //   1007: aload_0
    //   1008: getfield 1144	com/withustudy/koudaizikao/activity/QuestionDetailActivity:as	Ljava/util/List;
    //   1011: aload 21
    //   1013: invokeinterface 452 2 0
    //   1018: pop
    //   1019: iinc 20 1
    //   1022: goto -176 -> 846
    //   1025: aload_0
    //   1026: getfield 1116	com/withustudy/koudaizikao/activity/QuestionDetailActivity:o	Lcom/withustudy/koudaizikao/entity/req/ExerciseIdList;
    //   1029: getstatic 635	com/withustudy/koudaizikao/d/a$b:d	Ljava/lang/String;
    //   1032: invokevirtual 1157	com/withustudy/koudaizikao/entity/req/ExerciseIdList:setBrushType	(Ljava/lang/String;)V
    //   1035: goto -85 -> 950
    //   1038: aload_0
    //   1039: getfield 232	com/withustudy/koudaizikao/activity/QuestionDetailActivity:aB	Landroid/os/Handler;
    //   1042: bipush 7
    //   1044: invokevirtual 901	android/os/Handler:sendEmptyMessage	(I)Z
    //   1047: pop
    //   1048: return
    //   1049: ldc_w 1579
    //   1052: invokestatic 432	com/withustudy/koudaizikao/g/h:a	(Ljava/lang/Object;)V
    //   1055: return
    //   1056: aload 5
    //   1058: aload_1
    //   1059: ldc_w 1581
    //   1062: invokevirtual 1568	com/google/gson/Gson:fromJson	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   1065: checkcast 1581	com/withustudy/koudaizikao/entity/RspCollectExcerBean
    //   1068: astore 12
    //   1070: aload 12
    //   1072: ifnull -952 -> 120
    //   1075: aload_0
    //   1076: getfield 232	com/withustudy/koudaizikao/activity/QuestionDetailActivity:aB	Landroid/os/Handler;
    //   1079: iconst_5
    //   1080: aload 12
    //   1082: invokevirtual 1584	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   1085: astore 13
    //   1087: aload_0
    //   1088: getfield 232	com/withustudy/koudaizikao/activity/QuestionDetailActivity:aB	Landroid/os/Handler;
    //   1091: aload 13
    //   1093: invokevirtual 541	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   1096: pop
    //   1097: return
    //   1098: astore 11
    //   1100: return
    //   1101: invokestatic 1587	com/withustudy/koudaizikao/a/c:a	()Lcom/google/gson/Gson;
    //   1104: aload_1
    //   1105: ldc_w 1589
    //   1108: invokevirtual 1568	com/google/gson/Gson:fromJson	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   1111: checkcast 1589	com/withustudy/koudaizikao/entity/OpreationState
    //   1114: astore 8
    //   1116: aload 8
    //   1118: ifnull -998 -> 120
    //   1121: aload 8
    //   1123: invokevirtual 1592	com/withustudy/koudaizikao/entity/OpreationState:getStatus	()Ljava/lang/String;
    //   1126: ldc_w 1594
    //   1129: invokevirtual 323	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1132: ifeq +14 -> 1146
    //   1135: aload_0
    //   1136: getfield 232	com/withustudy/koudaizikao/activity/QuestionDetailActivity:aB	Landroid/os/Handler;
    //   1139: bipush 8
    //   1141: invokevirtual 901	android/os/Handler:sendEmptyMessage	(I)Z
    //   1144: pop
    //   1145: return
    //   1146: aload_0
    //   1147: getfield 232	com/withustudy/koudaizikao/activity/QuestionDetailActivity:aB	Landroid/os/Handler;
    //   1150: bipush 9
    //   1152: invokevirtual 901	android/os/Handler:sendEmptyMessage	(I)Z
    //   1155: pop
    //   1156: return
    //   1157: aload_0
    //   1158: aload 5
    //   1160: aload_1
    //   1161: ldc_w 1596
    //   1164: invokevirtual 1568	com/google/gson/Gson:fromJson	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   1167: checkcast 1596	com/withustudy/koudaizikao/entity/UrlShortBean
    //   1170: putfield 969	com/withustudy/koudaizikao/activity/QuestionDetailActivity:au	Lcom/withustudy/koudaizikao/entity/UrlShortBean;
    //   1173: aload_0
    //   1174: getfield 969	com/withustudy/koudaizikao/activity/QuestionDetailActivity:au	Lcom/withustudy/koudaizikao/entity/UrlShortBean;
    //   1177: ifnull +14 -> 1191
    //   1180: aload_0
    //   1181: getfield 232	com/withustudy/koudaizikao/activity/QuestionDetailActivity:aB	Landroid/os/Handler;
    //   1184: bipush 101
    //   1186: invokevirtual 901	android/os/Handler:sendEmptyMessage	(I)Z
    //   1189: pop
    //   1190: return
    //   1191: ldc_w 1598
    //   1194: invokestatic 432	com/withustudy/koudaizikao/g/h:a	(Ljava/lang/Object;)V
    //   1197: return
    //   1198: astore 15
    //   1200: return
    //   1201: astore 7
    //   1203: return
    //
    // Exception table:
    //   from	to	target	type
    //   146	192	510	java/lang/Exception
    //   202	209	510	java/lang/Exception
    //   214	303	510	java/lang/Exception
    //   303	321	510	java/lang/Exception
    //   321	330	510	java/lang/Exception
    //   335	351	510	java/lang/Exception
    //   351	363	510	java/lang/Exception
    //   363	462	510	java/lang/Exception
    //   462	484	510	java/lang/Exception
    //   484	494	510	java/lang/Exception
    //   494	509	510	java/lang/Exception
    //   524	536	510	java/lang/Exception
    //   539	548	510	java/lang/Exception
    //   551	591	510	java/lang/Exception
    //   597	608	510	java/lang/Exception
    //   611	621	510	java/lang/Exception
    //   624	640	510	java/lang/Exception
    //   1056	1070	1098	java/lang/Exception
    //   1075	1097	1098	java/lang/Exception
    //   641	673	1198	java/lang/Exception
    //   678	789	1198	java/lang/Exception
    //   789	807	1198	java/lang/Exception
    //   807	827	1198	java/lang/Exception
    //   832	838	1198	java/lang/Exception
    //   846	940	1198	java/lang/Exception
    //   940	950	1198	java/lang/Exception
    //   950	965	1198	java/lang/Exception
    //   966	978	1198	java/lang/Exception
    //   981	990	1198	java/lang/Exception
    //   993	1019	1198	java/lang/Exception
    //   1025	1035	1198	java/lang/Exception
    //   1038	1048	1198	java/lang/Exception
    //   1049	1055	1198	java/lang/Exception
    //   1101	1116	1201	java/lang/Exception
    //   1121	1145	1201	java/lang/Exception
    //   1146	1156	1201	java/lang/Exception
  }

  protected void setContentView()
  {
    setContentView(2130903100);
  }

  private class a extends BaseAdapter
  {
    int a = 0;
    private List<String> c = new ArrayList();

    public a(int arg2)
    {
      Object localObject;
      this.c = localObject;
      int i;
      this.a = i;
    }

    public int getCount()
    {
      return this.c.size();
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
      a locala;
      if (paramView == null)
      {
        locala = new a();
        paramView = View.inflate(QuestionDetailActivity.this.getApplicationContext(), 2130903256, null);
        a.a(locala, (Button)paramView.findViewById(2131297475));
        a.a(locala, (ImageView)paramView.findViewById(2131297476));
        paramView.setTag(locala);
      }
      while (true)
      {
        a.a(locala).setOnClickListener(new ay(this, paramInt));
        String str1 = (String)this.c.get(paramInt);
        Integer localInteger = (Integer)QuestionDetailActivity.y(QuestionDetailActivity.this).get(str1);
        a.a(locala).setText(1 + localInteger.intValue());
        switch (QuestionDetailActivity.this.r)
        {
        default:
          a.b(locala).setVisibility(8);
          Boolean localBoolean = (Boolean)QuestionDetailActivity.this.j.get(Integer.valueOf(paramInt + this.a));
          if ((localBoolean != null) && (localBoolean.booleanValue()))
          {
            a.a(locala).setBackgroundResource(2130837614);
            a.a(locala).setTextColor(QuestionDetailActivity.this.getResources().getColor(2131034192));
            return paramView;
            locala = (a)paramView.getTag();
          }
          break;
        case 100:
          String str3 = (String)QuestionDetailActivity.this.a.get(Integer.valueOf(paramInt + this.a));
          if ((str3 != null) && (str3.equals("true")))
          {
            a.b(locala).setVisibility(8);
            a.a(locala).setBackgroundResource(2130837614);
            a.a(locala).setTextColor(QuestionDetailActivity.this.getResources().getColor(2131034192));
            return paramView;
          }
          a.a(locala).setBackgroundResource(2130837613);
          a.a(locala).setTextColor(QuestionDetailActivity.this.getResources().getColor(2131034193));
          return paramView;
        case 101:
          String str2 = (String)QuestionDetailActivity.this.a.get(Integer.valueOf(paramInt + this.a));
          if ((str2 != null) && (str2.equals("true")))
          {
            a.b(locala).setVisibility(8);
            a.a(locala).setBackgroundResource(2130837614);
            a.a(locala).setTextColor(QuestionDetailActivity.this.getResources().getColor(2131034192));
            return paramView;
          }
          a.a(locala).setBackgroundResource(2130837613);
          a.a(locala).setTextColor(QuestionDetailActivity.this.getResources().getColor(2131034193));
          return paramView;
        }
      }
      a.a(locala).setBackgroundResource(2130837615);
      a.a(locala).setTextColor(QuestionDetailActivity.this.getResources().getColor(2131034196));
      return paramView;
    }

    class a
    {
      private ImageView b;
      private Button c;

      a()
      {
      }
    }
  }

  private class b extends BaseAdapter
  {
    public b()
    {
    }

    public int getCount()
    {
      if (QuestionDetailActivity.this.r == 100)
      {
        QuestionDetailActivity.v(QuestionDetailActivity.this).size();
        return QuestionDetailActivity.v(QuestionDetailActivity.this).size();
      }
      if (QuestionDetailActivity.this.r == 101)
        return -1 + QuestionDetailActivity.this.s.size();
      return QuestionDetailActivity.w(QuestionDetailActivity.this).getExerciseId().size();
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
      QuestionDetailActivity.c localc1;
      if (paramView == null)
      {
        paramView = View.inflate(QuestionDetailActivity.this.getApplicationContext(), 2130903274, null);
        QuestionDetailActivity.c localc2 = new QuestionDetailActivity.c(QuestionDetailActivity.this);
        QuestionDetailActivity.c.a(localc2, (Button)paramView.findViewById(2131297542));
        QuestionDetailActivity.c.a(localc2, (ImageView)paramView.findViewById(2131297476));
        paramView.setTag(localc2);
        localc1 = localc2;
        QuestionDetailActivity.c.a(localc1).setOnClickListener(new az(this, paramInt));
        switch (QuestionDetailActivity.this.r)
        {
        default:
          if ((QuestionDetailActivity.d(QuestionDetailActivity.this) == null) || (QuestionDetailActivity.d(QuestionDetailActivity.this).size() <= 0))
            break;
          QuestionDetailActivity.c.a(localc1).setText(paramInt + 1);
          QuestionDetailActivity.c.b(localc1).setVisibility(8);
          Boolean localBoolean = (Boolean)QuestionDetailActivity.this.j.get(Integer.valueOf(paramInt));
          if ((localBoolean == null) || (!localBoolean.booleanValue()))
            break label475;
          QuestionDetailActivity.c.a(localc1).setBackgroundResource(2130837614);
          QuestionDetailActivity.c.a(localc1).setTextColor(QuestionDetailActivity.this.getResources().getColor(2131034192));
        case 100:
        case 101:
        }
      }
      do
      {
        return paramView;
        localc1 = (QuestionDetailActivity.c)paramView.getTag();
        break;
        String str = (String)QuestionDetailActivity.this.a.get(Integer.valueOf(paramInt));
        ((Exercises)QuestionDetailActivity.d(QuestionDetailActivity.this).get(paramInt));
        QuestionDetailActivity.c.a(localc1).setText(paramInt + 1);
        if ((str != null) && (str.equals("true")))
        {
          QuestionDetailActivity.c.b(localc1).setVisibility(8);
          QuestionDetailActivity.c.a(localc1).setBackgroundResource(2130837614);
          QuestionDetailActivity.c.a(localc1).setTextColor(QuestionDetailActivity.this.getResources().getColor(2131034192));
          return paramView;
        }
        QuestionDetailActivity.c.a(localc1).setBackgroundResource(2130837613);
        QuestionDetailActivity.c.a(localc1).setTextColor(QuestionDetailActivity.this.getResources().getColor(2131034193));
        return paramView;
      }
      while ((Exercises)QuestionDetailActivity.this.t.get(paramInt) == null);
      QuestionDetailActivity.c.a(localc1).setText(paramInt + 1);
      QuestionDetailActivity.c.a(localc1).setBackgroundResource(2130837613);
      QuestionDetailActivity.c.a(localc1).setTextColor(QuestionDetailActivity.this.getResources().getColor(2131034193));
      return paramView;
      label475: QuestionDetailActivity.c.a(localc1).setBackgroundResource(2130837615);
      QuestionDetailActivity.c.a(localc1).setTextColor(QuestionDetailActivity.this.getResources().getColor(2131034196));
      return paramView;
    }
  }

  class c
  {
    private ImageView b;
    private Button c;

    c()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.QuestionDetailActivity
 * JD-Core Version:    0.6.0
 */