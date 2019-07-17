package com.koudai.test;

import a.a.a.e.k;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.test.FlowLayout;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.QuestionDetailActivity;
import com.withustudy.koudaizikao.activity.QuestionMoreComentActivity;
import com.withustudy.koudaizikao.b.i.b;
import com.withustudy.koudaizikao.custom.MyListView;
import com.withustudy.koudaizikao.custom.MyScrollView;
import com.withustudy.koudaizikao.entity.BrushExcerciseBean;
import com.withustudy.koudaizikao.entity.Comments;
import com.withustudy.koudaizikao.entity.ErrorRate;
import com.withustudy.koudaizikao.entity.Exercises;
import com.withustudy.koudaizikao.entity.Explain;
import com.withustudy.koudaizikao.entity.Kpoint;
import com.withustudy.koudaizikao.entity.KpointDetail;
import com.withustudy.koudaizikao.entity.MyErrorRate;
import com.withustudy.koudaizikao.entity.Options;
import com.withustudy.koudaizikao.entity.PublishCommentBean;
import com.withustudy.koudaizikao.entity.Stem;
import com.withustudy.koudaizikao.entity.req.Comment;
import com.withustudy.koudaizikao.entity.req.ReqComment;
import com.withustudy.koudaizikao.entity.req.Subjects;
import com.withustudy.koudaizikao.entity.req.UserInfo;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import koudai.db.UserAnsDao;
import koudai.db.UserAnsDao.Properties;

public class BrushExcerciseDetailFragment extends BrushFragment
{
  public static final int a = 7;
  private static final int au = 4;
  private static final int av = 10;
  private static final int aw = 9;
  private static final int ax = 6;
  private static final int ay = 5;
  private static final int az = 8;
  public static final int b = 11;
  private int F = 0;
  private Exercises G;
  private BroadcastReceiver H;
  private LocalBroadcastManager I;
  private BrushExcerciseDetailActivity J;
  private String K;
  private Integer L = Integer.valueOf(-1);
  private FlowLayout M;
  private LinearLayout N;
  private Activity O;
  private ImageButton P;
  private EditText Q;
  private EditText R;
  private EditText S;
  private EditText T;
  private EditText U;
  private EditText V;
  private EditText W;
  private TextView X;
  private TextView Y;
  private TextView Z;
  private View aA;
  private TextView aB;
  private EditText[] aC;
  private ImageView[] aD;
  private ImageView[] aE;
  private LinearLayout aF;
  private LinearLayout aG;
  private PublishCommentBean aH;
  private BrushExcerciseBean aI;
  private List<Comment> aJ;
  private boolean aK = false;
  private com.withustudy.koudaizikao.b.i aL;
  private boolean aM = true;
  private i.b aN;
  private Handler aO = new d(this);
  private boolean aP = false;
  private TextView aQ;
  private TextView aR;
  private TextView aS;
  private TextView aT;
  private TextView aU;
  private TextView aV;
  private ImageView aW;
  private TextView aX;
  private TextView aY;
  private Button aZ;
  private MyScrollView aa;
  private TextView ab;
  private TextView ac;
  private LinearLayout ad;
  private TextView ae;
  private TextView af;
  private LinearLayout ag;
  private LinearLayout ah;
  private LinearLayout ai;
  private Button aj;
  private LinearLayout ak;
  private LinearLayout al;
  private LinearLayout am;
  private MyListView an;
  private List<String> ao;
  private double ap = 0.0D;
  private InputMethodManager aq;
  private HashMap<Integer, String> ar;
  private boolean as = false;
  private String at;
  private Button ba;
  private ImageButton bb;
  private EditText bc;
  private LinearLayout bd;
  private TextView be;
  private TextView bf;
  private LinearLayout bg;
  private ImageView bh;
  private TextView bi;
  private FlowLayout bj;
  private FlowLayout bk;
  private ImageView bl;
  private ImageView bm;
  private ImageView bn;
  private ImageView bo;
  private ImageView bp;
  private LinearLayout bq;
  private ImageView br;
  private RelativeLayout bs;

  private boolean A()
  {
    switch (this.L.intValue())
    {
    default:
      return true & this.W.isEnabled();
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
      return true & z();
    case 5:
    }
    return true & B();
  }

  private boolean B()
  {
    boolean bool = true;
    if (this.Q != null)
      bool &= this.Q.isEnabled();
    if (this.R != null)
      bool &= this.R.isEnabled();
    if (this.S != null)
      bool &= this.S.isEnabled();
    if (this.T != null)
      bool &= this.T.isEnabled();
    if (this.U != null)
      bool &= this.U.isEnabled();
    if (this.V != null)
      bool &= this.V.isEnabled();
    return bool;
  }

  private void C()
  {
    if (this.l != null)
      this.l.setBackgroundResource(2130837507);
    if (this.m != null)
      this.m.setBackgroundResource(2130837578);
    if (this.n != null)
      this.n.setBackgroundResource(2130837711);
    if (this.o != null)
      this.o.setBackgroundResource(2130837749);
    if (this.p != null)
      this.p.setBackgroundResource(2130837779);
    if (this.q != null)
      this.q.setBackgroundResource(2130837817);
  }

  private void D()
  {
    if (this.r != null)
      a(this.r, false);
    if (this.s != null)
      a(this.s, false);
    if (this.t != null)
      a(this.t, false);
    if (this.u != null)
      a(this.u, false);
    if (this.v != null)
      a(this.v, false);
    if (this.w != null)
      a(this.w, false);
  }

  private void E()
  {
    for (int i = 0; ; i++)
    {
      if (i >= this.ar.size())
        return;
      this.ar.put(Integer.valueOf(i), "");
    }
  }

  private void F()
  {
    this.bs = ((RelativeLayout)this.e.findViewById(2131297057));
    this.br = ((ImageView)this.e.findViewById(2131297055));
    this.bl = ((ImageView)this.e.findViewById(2131297067));
    this.bm = ((ImageView)this.e.findViewById(2131297068));
    this.bn = ((ImageView)this.e.findViewById(2131297069));
    this.bo = ((ImageView)this.e.findViewById(2131297070));
    this.bp = ((ImageView)this.e.findViewById(2131297071));
    this.bj = ((FlowLayout)this.e.findViewById(2131297052));
    this.bj.setOption(true);
    this.bk = ((FlowLayout)this.e.findViewById(2131297060));
    this.bk.setOption(true);
    this.aX = ((TextView)this.e.findViewById(2131297051));
    this.bi = ((TextView)this.e.findViewById(2131297056));
    this.bh = ((ImageView)this.e.findViewById(2131297050));
    this.bf = ((TextView)this.e.findViewById(2131297066));
    this.bg = ((LinearLayout)this.e.findViewById(2131297062));
    this.bq = ((LinearLayout)this.e.findViewById(2131297053));
    this.be = ((TextView)this.e.findViewById(2131297065));
    this.aQ = ((TextView)this.e.findViewById(2131297047));
    this.aW = ((ImageView)this.e.findViewById(2131297048));
    this.aY = ((TextView)this.e.findViewById(2131297054));
    this.aS = ((TextView)this.e.findViewById(2131297058));
    this.aT = ((TextView)this.e.findViewById(2131297059));
    this.aU = ((TextView)this.e.findViewById(2131297061));
    this.aV = ((TextView)this.e.findViewById(2131297072));
    this.aZ = ((Button)this.e.findViewById(2131297074));
    this.aZ.setOnClickListener(this);
    this.bb = ((ImageButton)this.e.findViewById(2131297075));
    this.bc = ((EditText)this.e.findViewById(2131296934));
    this.ba = ((Button)this.e.findViewById(2131297076));
    this.ba.setOnClickListener(this);
    this.bd = ((LinearLayout)this.e.findViewById(2131297044));
    this.ak.setVisibility(0);
    this.aj.setVisibility(8);
    this.ag.setVisibility(0);
    this.ah.setVisibility(0);
  }

  private void G()
  {
    try
    {
      List localList;
      int i;
      int j;
      if (this.aC[0].isEnabled())
      {
        if ((this.aG != null) && (this.aG.getChildCount() > 0))
          this.aG.removeAllViews();
        localList = this.G.getCorrectAnswer();
        if ((localList != null) && (localList.size() > 0))
        {
          i = localList.size();
          new int[] { 2130838091, 2130838093, 2130838095, 2130838097, 2130838099, 2130838101, 2130838103, 2130838105, 2130838107, 2130838084, 2130838086, 2130838088, 2130838090 };
          this.aB.setVisibility(0);
          j = 0;
        }
        else
        {
          this.aj.setVisibility(8);
          v();
          return;
        }
      }
      label438: 
      while (true)
      {
        String str1 = (String)localList.get(j);
        String str2 = this.aC[j].getText().toString().trim();
        if ((this.aC != null) && (this.aC.length > 0))
        {
          if ((str2 == null) || (str2.equals("")))
          {
            this.aC[j].setTextColor(getResources().getColor(2131034206));
            this.aD[j].setBackgroundResource(2130837810);
            this.aD[j].setVisibility(0);
            a(j, str1);
          }
          while (true)
          {
            this.aC[j].setEnabled(false);
            break;
            if (str1.equals(str2))
            {
              this.aC[j].setTextColor(getResources().getColor(2131034205));
              this.aD[j].setBackgroundResource(2130838001);
              this.aD[j].setVisibility(0);
              continue;
            }
            this.aC[j].setTextColor(getResources().getColor(2131034206));
            this.aD[j].setBackgroundResource(2130837810);
            this.aD[j].setVisibility(0);
            a(j, str1);
          }
        }
        while (true)
        {
          if (j < i)
            break label438;
          break;
          return;
          j++;
        }
      }
    }
    catch (Exception localException)
    {
    }
  }

  private void H()
  {
    int i = 0;
    try
    {
      List localList = this.G.getCorrectAnswer();
      int j = localList.size();
      new int[] { 2130838091, 2130838093, 2130838095, 2130838097, 2130838099, 2130838101, 2130838103, 2130838105, 2130838107, 2130838084, 2130838086, 2130838088, 2130838090 };
      this.aB.setVisibility(0);
      int k = 0;
      int m = 0;
      int n;
      if (k >= j)
      {
        a(localList, j, m);
        if (this.aK)
        {
          n = 0;
          if (n >= j)
            this.ap = (this.G.getScore() * (1.0D * i / j));
        }
        else
        {
          this.aP = true;
          this.J.e.put(Integer.valueOf(this.F), Boolean.valueOf(true));
          this.J.d.put(Integer.valueOf(this.F), this.as);
          this.aj.setVisibility(8);
          this.J.a(this.G, this.ar, this.as, true, this.ap, this.G.getScore());
          v();
          return;
        }
      }
      else
      {
        String str3 = (String)localList.get(k);
        String str4 = this.aC[k].getText().toString().trim();
        int i2;
        if ((str4 == null) || (str4.equals("")))
        {
          this.ar.put(Integer.valueOf(k), "##");
          this.aC[k].setTextColor(getResources().getColor(2131034206));
          this.aD[k].setBackgroundResource(2130837810);
          this.aD[k].setVisibility(0);
          a(k, str3);
          i2 = m;
        }
        while (true)
        {
          this.aC[k].setEnabled(false);
          k++;
          m = i2;
          break;
          if (str3.equals(str4))
          {
            this.ar.put(Integer.valueOf(k), str4);
            i2 = m + 1;
            this.aC[k].setTextColor(getResources().getColor(2131034205));
            this.aD[k].setBackgroundResource(2130838001);
            this.aD[k].setVisibility(0);
            continue;
          }
          int i3 = m + 1;
          this.ar.put(Integer.valueOf(k), str4);
          this.aC[k].setTextColor(getResources().getColor(2131034206));
          this.aD[k].setBackgroundResource(2130837810);
          this.aD[k].setVisibility(0);
          a(k, str3);
          i2 = i3;
        }
      }
      String str1 = (String)localList.get(n);
      String str2 = this.aC[n].getText().toString().trim();
      if ((str2 != null) && (!str2.equals("")))
      {
        boolean bool = str1.equals(str2);
        if (!bool);
      }
      for (int i1 = i + 1; ; i1 = i)
      {
        n++;
        i = i1;
        break;
      }
    }
    catch (Exception localException)
    {
    }
  }

  public static BrushExcerciseDetailFragment a(int paramInt)
  {
    return new BrushExcerciseDetailFragment();
  }

  private void a(int paramInt, String paramString)
  {
    try
    {
      if (this.aC[paramInt].isEnabled())
      {
        this.aF.setVisibility(0);
        int[] arrayOfInt = { 2130838091, 2130838093, 2130838095, 2130838097, 2130838099, 2130838101, 2130838103, 2130838105, 2130838107, 2130838084, 2130838086, 2130838088, 2130838090 };
        FlowLayout localFlowLayout = (FlowLayout)View.inflate(getActivity(), 2130903275, null);
        localFlowLayout.setOption(true);
        ImageView localImageView = (ImageView)View.inflate(getActivity(), 2130903278, null);
        localImageView.setBackgroundResource(arrayOfInt[paramInt]);
        localFlowLayout.addView(localImageView);
        Iterator localIterator = a(paramString, true, this.K).iterator();
        while (true)
        {
          if (!localIterator.hasNext())
          {
            this.aG.addView(localFlowLayout);
            this.aG.setVisibility(0);
            return;
          }
          View localView = (View)localIterator.next();
          if ((localView instanceof TextView))
          {
            TextView localTextView = (TextView)localView;
            localTextView.setTextColor(getResources().getColor(2131034205));
            localFlowLayout.addView(localTextView);
            continue;
          }
          localFlowLayout.addView(localView);
        }
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
      b(paramInt, paramBoolean);
    Boolean localBoolean;
    do
    {
      return;
      localBoolean = (Boolean)this.J.e.get(Integer.valueOf(this.F));
    }
    while ((localBoolean != null) && (localBoolean.booleanValue()));
    b(paramInt, paramBoolean);
  }

  private void a(FlowLayout paramFlowLayout, int paramInt)
  {
    int j;
    if (paramFlowLayout != null)
    {
      int i = paramFlowLayout.getChildCount();
      j = 0;
      if (j < i);
    }
    else
    {
      switch (paramInt)
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                View localView = paramFlowLayout.getChildAt(j);
                if ((localView instanceof TextView))
                  ((TextView)localView).setTextColor(getResources().getColor(2131034225));
                while (true)
                {
                  j++;
                  break;
                  if (!(localView instanceof ImageView))
                    continue;
                  localView.setVisibility(8);
                }
              }
              while (this.l == null);
              this.l.setBackgroundResource(2130837507);
              return;
            }
            while (this.m == null);
            this.m.setBackgroundResource(2130837578);
            return;
          }
          while (this.n == null);
          this.n.setBackgroundResource(2130837711);
          return;
        }
        while (this.o == null);
        this.o.setBackgroundResource(2130837749);
        return;
      }
      while (this.p == null);
      this.p.setBackgroundResource(2130837779);
      return;
    }
    while (this.q == null);
    this.q.setBackgroundResource(2130837817);
  }

  private void a(FlowLayout paramFlowLayout, boolean paramBoolean)
  {
    int j;
    if (paramFlowLayout != null)
    {
      int i = paramFlowLayout.getChildCount();
      j = 0;
      if (j < i);
    }
    else
    {
      return;
    }
    View localView = paramFlowLayout.getChildAt(j);
    TextView localTextView;
    if ((localView instanceof TextView))
    {
      localTextView = (TextView)localView;
      if (!paramBoolean)
        break label67;
      localTextView.setTextColor(getResources().getColor(2131034224));
    }
    while (true)
    {
      j++;
      break;
      label67: localTextView.setTextColor(getResources().getColor(2131034225));
    }
  }

  private void a(Exercises paramExercises)
  {
    List localList;
    if (paramExercises != null)
    {
      Comments localComments = paramExercises.getComments();
      if (localComments == null)
        break label89;
      localList = localComments.getComment();
      if ((localList == null) || (localList.size() <= 0))
        break label83;
      if (this.aJ != null)
        break label71;
      this.aJ = new ArrayList();
    }
    while (true)
    {
      this.aJ.addAll(localList);
      this.aO.sendEmptyMessage(10);
      return;
      label71: this.aJ.clear();
    }
    label83: this.aM = false;
    return;
    label89: this.aM = false;
  }

  private void a(List<String> paramList, int paramInt1, int paramInt2)
  {
    if (paramInt2 == paramInt1)
    {
      for (int i = 0; ; i++)
      {
        if (i >= paramInt1)
          return;
        String str1 = (String)paramList.get(i);
        String str2 = this.aC[i].getText().toString().trim();
        if ((str2 == null) || (str2.equals("")))
        {
          this.as = false;
          return;
        }
        if (!str1.equals(str2))
          break;
        this.as = true;
      }
      this.as = false;
      return;
    }
    this.as = false;
  }

  private void a(boolean paramBoolean)
  {
    if (this.J.a)
    {
      this.J.b.setText("试题");
      com.withustudy.koudaizikao.g.h.a("curIndex=" + this.F);
      b(paramBoolean);
      return;
    }
    this.J.b.setText("讲解");
    c(paramBoolean);
  }

  private void b(int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return;
      try
      {
        if (this.l == null)
          continue;
        this.l.setBackgroundResource(2130837504);
        a(this.r, true);
        this.ar.put(Integer.valueOf(paramInt), "A");
        return;
        if (this.m == null)
          continue;
        this.m.setBackgroundResource(2130837575);
        a(this.s, true);
        this.ar.put(Integer.valueOf(paramInt), "B");
        return;
        if (this.n == null)
          continue;
        this.n.setBackgroundResource(2130837708);
        a(this.t, true);
        this.ar.put(Integer.valueOf(paramInt), "C");
        return;
        if (this.o == null)
          continue;
        this.o.setBackgroundResource(2130837747);
        a(this.u, true);
        this.ar.put(Integer.valueOf(paramInt), "D");
        return;
        if (this.p == null)
          continue;
        this.p.setBackgroundResource(2130837777);
        a(this.v, true);
        this.ar.put(Integer.valueOf(paramInt), "E");
        return;
        if (this.q == null)
          continue;
        this.q.setBackgroundResource(2130837815);
        a(this.w, true);
        this.ar.put(Integer.valueOf(paramInt), "F");
        return;
      }
      catch (Exception localException)
      {
      }
    }
  }

  private void b(int paramInt, boolean paramBoolean)
  {
    try
    {
      if ((this.L.intValue() == 2) || (this.L.intValue() == 1) || (this.L.intValue() == 3))
      {
        c(paramInt, paramBoolean);
        if (s())
          this.aj.setEnabled(true);
        while (true)
        {
          Boolean localBoolean1 = (Boolean)this.J.e.get(Integer.valueOf(this.F));
          if ((localBoolean1 == null) || (!localBoolean1.booleanValue()))
            break;
          t();
          u();
          e();
          v();
          this.aj.setVisibility(8);
          return;
          this.aj.setEnabled(false);
        }
        this.aP = false;
        this.J.e.put(Integer.valueOf(this.F), Boolean.valueOf(this.aP));
        this.as = false;
        this.ap = 0.0D;
        this.J.a(this.G, this.ar, this.as, false, this.ap, this.G.getScore());
        com.withustudy.koudaizikao.g.h.a("插入currentInx=" + this.F);
        return;
      }
      if ((this.L.intValue() == 0) || (this.L.intValue() == 4))
      {
        b(paramInt);
        Boolean localBoolean2 = (Boolean)this.J.e.get(Integer.valueOf(this.F));
        if ((localBoolean2 != null) && (localBoolean2.booleanValue()))
        {
          t();
          u();
          v();
          e();
          return;
        }
        com.withustudy.koudaizikao.g.h.a("插入currentInx=" + this.F);
        this.aP = true;
        this.J.e.put(Integer.valueOf(this.F), Boolean.valueOf(true));
        t();
        c(u());
        this.J.d.put(Integer.valueOf(this.F), this.as);
        v();
        e();
        if (this.as);
        for (this.ap = this.G.getScore(); ; this.ap = 0.0D)
        {
          this.J.a(this.G, this.ar, this.as, true, this.ap, this.G.getScore());
          if (!this.as)
            break;
          this.aO.sendEmptyMessageDelayed(11, 500L);
          return;
        }
        com.withustudy.koudaizikao.g.h.a(getActivity(), "做错了，留在本页面!");
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void b(FlowLayout paramFlowLayout, boolean paramBoolean)
  {
    c(paramFlowLayout, paramBoolean);
    ImageView localImageView;
    if (z())
    {
      localImageView = new ImageView(getActivity());
      if (!paramBoolean)
        break label42;
      localImageView.setBackgroundResource(2130838001);
    }
    while (true)
    {
      paramFlowLayout.addView(localImageView);
      return;
      label42: localImageView.setBackgroundResource(2130837810);
    }
  }

  private void b(boolean paramBoolean)
  {
    if (!paramBoolean);
    try
    {
      Boolean localBoolean = (Boolean)this.J.e.get(Integer.valueOf(this.F));
      if ((localBoolean != null) && (localBoolean.booleanValue()))
        return;
      n();
      Set localSet = this.ar.keySet();
      Iterator localIterator;
      int i;
      if ((localSet != null) && (localSet.size() > 0))
        switch (this.L.intValue())
        {
        default:
          String str2 = (String)this.ar.get(Integer.valueOf(0));
          this.W.setText(str2);
          this.aj.setVisibility(8);
          this.W.setEnabled(false);
          v();
          return;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
          localIterator = localSet.iterator();
          i = 1;
        case 5:
        }
      while (true)
        if (!localIterator.hasNext())
        {
          if (i == 0)
            break;
          t();
          v();
          return;
        }
        else
        {
          Integer localInteger = (Integer)localIterator.next();
          String str1 = (String)this.ar.get(localInteger);
          if ((str1 == null) || (str1.equals("")))
            continue;
          d(localInteger.intValue(), true);
          i = 0;
          continue;
          l();
          G();
          m();
          return;
          switch (this.L.intValue())
          {
          default:
            this.aj.setVisibility(8);
            this.W.setEnabled(false);
            v();
            return;
          case 0:
          case 1:
          case 2:
          case 3:
          case 4:
            t();
            v();
            e();
            return;
          case 5:
          }
          G();
          m();
        }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void c(int paramInt, boolean paramBoolean)
  {
    try
    {
      Boolean localBoolean = Boolean.valueOf(f(paramInt));
      switch (paramInt)
      {
      case 0:
        if ((localBoolean == null) || (!localBoolean.booleanValue()))
        {
          if (this.l == null)
            break;
          this.l.setBackgroundResource(2130837504);
          a(this.r, true);
          this.ar.put(Integer.valueOf(paramInt), "A");
          return;
        }
        else if (paramBoolean)
        {
          if (this.l == null)
            break;
          this.l.setBackgroundResource(2130837504);
          a(this.r, true);
          this.ar.put(Integer.valueOf(paramInt), "A");
          return;
        }
        else
        {
          if (this.l == null)
            break;
          this.l.setBackgroundResource(2130837507);
          a(this.r, false);
          this.ar.put(Integer.valueOf(paramInt), "");
          return;
        }
      case 1:
        if ((localBoolean == null) || (!localBoolean.booleanValue()))
        {
          if (this.m == null)
            break;
          this.m.setBackgroundResource(2130837575);
          a(this.s, true);
          this.ar.put(Integer.valueOf(paramInt), "B");
          return;
        }
        else if (paramBoolean)
        {
          if (this.m == null)
            break;
          this.m.setBackgroundResource(2130837575);
          a(this.s, true);
          this.ar.put(Integer.valueOf(paramInt), "B");
          return;
        }
        else
        {
          if (this.m == null)
            break;
          this.m.setBackgroundResource(2130837578);
          a(this.s, false);
          this.ar.put(Integer.valueOf(paramInt), "");
          return;
        }
      case 2:
        if ((localBoolean == null) || (!localBoolean.booleanValue()))
        {
          if (this.n == null)
            break;
          this.n.setBackgroundResource(2130837708);
          a(this.t, true);
          this.ar.put(Integer.valueOf(paramInt), "C");
          return;
        }
        else if (paramBoolean)
        {
          if (this.n == null)
            break;
          this.n.setBackgroundResource(2130837708);
          a(this.t, true);
          this.ar.put(Integer.valueOf(paramInt), "C");
          return;
        }
        else
        {
          if (this.n == null)
            break;
          this.n.setBackgroundResource(2130837711);
          a(this.t, false);
          this.ar.put(Integer.valueOf(paramInt), "");
          return;
        }
      case 3:
        if ((localBoolean == null) || (!localBoolean.booleanValue()))
        {
          if (this.o == null)
            break;
          this.o.setBackgroundResource(2130837747);
          a(this.u, true);
          this.ar.put(Integer.valueOf(paramInt), "D");
          return;
        }
        else if (paramBoolean)
        {
          if (this.o == null)
            break;
          this.o.setBackgroundResource(2130837747);
          a(this.u, true);
          this.ar.put(Integer.valueOf(paramInt), "D");
          return;
        }
        else
        {
          if (this.o == null)
            break;
          this.o.setBackgroundResource(2130837749);
          a(this.u, false);
          this.ar.put(Integer.valueOf(paramInt), "");
          return;
        }
      case 4:
        if ((localBoolean == null) || (!localBoolean.booleanValue()))
        {
          if (this.p == null)
            break;
          this.p.setBackgroundResource(2130837777);
          a(this.v, true);
          this.ar.put(Integer.valueOf(paramInt), "E");
          return;
        }
        else if (paramBoolean)
        {
          if (this.p == null)
            break;
          this.p.setBackgroundResource(2130837777);
          a(this.v, true);
          this.ar.put(Integer.valueOf(paramInt), "E");
          return;
        }
        else
        {
          if (this.p == null)
            break;
          this.p.setBackgroundResource(2130837779);
          a(this.v, false);
          this.ar.put(Integer.valueOf(paramInt), "");
          return;
        }
      case 5:
        if ((localBoolean == null) || (!localBoolean.booleanValue()))
        {
          if (this.q == null)
            break;
          this.q.setBackgroundResource(2130837815);
          a(this.w, true);
          this.ar.put(Integer.valueOf(paramInt), "F");
          return;
        }
        else if (paramBoolean)
        {
          if (this.q == null)
            break;
          this.q.setBackgroundResource(2130837815);
          a(this.w, true);
          this.ar.put(Integer.valueOf(paramInt), "F");
          return;
        }
        else
        {
          if (this.q == null)
            break;
          this.q.setBackgroundResource(2130837817);
          a(this.w, false);
          this.ar.put(Integer.valueOf(paramInt), "");
        }
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void c(FlowLayout paramFlowLayout, boolean paramBoolean)
  {
    int j;
    if (paramFlowLayout != null)
    {
      int i = paramFlowLayout.getChildCount();
      j = 0;
      if (j < i);
    }
    else
    {
      return;
    }
    View localView = paramFlowLayout.getChildAt(j);
    TextView localTextView;
    if ((localView instanceof TextView))
    {
      localTextView = (TextView)localView;
      if (!paramBoolean)
        break label67;
      localTextView.setTextColor(getResources().getColor(2131034224));
    }
    while (true)
    {
      j++;
      break;
      label67: localTextView.setTextColor(getResources().getColor(2131034204));
    }
  }

  private void c(boolean paramBoolean)
  {
    if (!paramBoolean);
    try
    {
      Boolean localBoolean4 = (Boolean)this.J.e.get(Integer.valueOf(this.F));
      if ((localBoolean4 != null) && (localBoolean4.booleanValue()))
        return;
      i();
      n();
      Set localSet = this.ar.keySet();
      if ((localSet != null) && (localSet.size() > 0));
      Iterator localIterator;
      switch (this.L.intValue())
      {
      default:
        String str2 = (String)this.ar.get(Integer.valueOf(0));
        this.W.setText(str2);
        Boolean localBoolean3 = (Boolean)this.J.e.get(Integer.valueOf(this.F));
        if ((localBoolean3 == null) || (!localBoolean3.booleanValue()))
          break;
        this.aj.setVisibility(8);
        this.W.setEnabled(false);
        v();
        return;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
        localIterator = localSet.iterator();
      case 5:
        while (localIterator.hasNext())
        {
          Integer localInteger = (Integer)localIterator.next();
          String str1 = (String)this.ar.get(localInteger);
          if ((str1 == null) || (str1.equals("")))
            continue;
          a(localInteger.intValue(), true);
          continue;
          l();
          Boolean localBoolean2 = (Boolean)this.J.e.get(Integer.valueOf(this.F));
          if ((localBoolean2 == null) || (!localBoolean2.booleanValue()))
            break;
          H();
          m();
          return;
          switch (this.L.intValue())
          {
          default:
            Boolean localBoolean1 = (Boolean)this.J.e.get(Integer.valueOf(this.F));
            if ((localBoolean1 != null) && (localBoolean1.booleanValue()))
            {
              this.aj.setVisibility(8);
              this.W.setEnabled(false);
              v();
            }
          case 0:
          case 1:
          case 2:
          case 3:
          case 4:
          case 5:
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private boolean c(int paramInt)
  {
    Iterator localIterator;
    if (paramInt == this.ao.size())
    {
      localIterator = this.ar.keySet().iterator();
      if (localIterator.hasNext());
    }
    while (true)
    {
      return this.as;
      Integer localInteger = (Integer)localIterator.next();
      String str = (String)this.ar.get(localInteger);
      if ((str == null) || (str.equals("")))
        break;
      if (this.ao.contains(str))
      {
        this.as = true;
        break;
      }
      this.as = false;
      continue;
      this.as = false;
    }
  }

  private void d(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 0:
      this.l.setBackgroundResource(2130837505);
      b(this.r, false);
      return;
    case 1:
      this.m.setBackgroundResource(2130837576);
      b(this.s, false);
      return;
    case 2:
      this.n.setBackgroundResource(2130837709);
      b(this.t, false);
      return;
    case 3:
      this.o.setBackgroundResource(2130837748);
      b(this.u, false);
      return;
    case 4:
      this.p.setBackgroundResource(2130837778);
      b(this.v, false);
      return;
    case 5:
    }
    this.q.setBackgroundResource(2130837816);
    b(this.w, false);
  }

  private void d(int paramInt, boolean paramBoolean)
  {
    try
    {
      if ((this.L.intValue() == 2) || (this.L.intValue() == 1) || (this.L.intValue() == 3))
      {
        c(paramInt, paramBoolean);
        t();
        u();
        e();
        this.aj.setVisibility(8);
        v();
        return;
      }
      if ((this.L.intValue() == 0) || (this.L.intValue() == 4))
      {
        b(paramInt);
        t();
        u();
        e();
        v();
        return;
      }
    }
    catch (Exception localException)
    {
    }
  }

  private void d(boolean paramBoolean)
  {
    Iterator localIterator1 = this.ao.iterator();
    Iterator localIterator2;
    int i;
    if (!localIterator1.hasNext())
    {
      localIterator2 = this.ar.keySet().iterator();
      i = 0;
    }
    while (true)
    {
      if (!localIterator2.hasNext())
      {
        c(i);
        v();
        e();
        if (!paramBoolean)
        {
          if (!this.as)
            break label309;
          this.aO.sendEmptyMessageDelayed(11, 400L);
        }
        return;
        String str1 = (String)localIterator1.next();
        if ((str1 == null) || (str1.equals("")) || (str1.equals("ⅹ")) || (str1.equals("√")))
          break;
        if (str1.equals("A"))
        {
          e(0);
          break;
        }
        if (str1.equals("B"))
        {
          e(1);
          break;
        }
        if (str1.equals("C"))
        {
          e(2);
          break;
        }
        if (str1.equals("D"))
        {
          e(3);
          break;
        }
        if (str1.equals("E"))
        {
          e(4);
          break;
        }
        if (!str1.equals("F"))
          break;
        e(5);
        break;
      }
      Integer localInteger = (Integer)localIterator2.next();
      String str2 = (String)this.ar.get(localInteger);
      if ((str2 == null) || (str2.equals("")))
        continue;
      i++;
      if (this.ao.contains(str2))
        continue;
      d(localInteger.intValue());
    }
    label309: com.withustudy.koudaizikao.g.h.a("错误留在当页");
  }

  private void e(int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (this.l == null)
                  continue;
                this.l.setBackgroundResource(2130837504);
              }
              while (this.r == null);
              b(this.r, true);
              return;
              if (this.m == null)
                continue;
              this.m.setBackgroundResource(2130837575);
            }
            while (this.s == null);
            b(this.s, true);
            return;
            if (this.n == null)
              continue;
            this.n.setBackgroundResource(2130837708);
          }
          while (this.t == null);
          b(this.t, true);
          return;
          if (this.o == null)
            continue;
          this.o.setBackgroundResource(2130837747);
        }
        while (this.u == null);
        b(this.u, true);
        return;
        if (this.p == null)
          continue;
        this.p.setBackgroundResource(2130837777);
      }
      while (this.v == null);
      b(this.v, true);
      return;
      if (this.q == null)
        continue;
      this.q.setBackgroundResource(2130837815);
    }
    while (this.w == null);
    b(this.w, true);
  }

  private boolean f(int paramInt)
  {
    String str = (String)this.ar.get(Integer.valueOf(paramInt));
    if ((str == null) || (str.equals("")))
      return false;
    if (str.equals("A"))
      return true;
    if (str.equals("B"))
      return true;
    if (str.equals("C"))
      return true;
    if (str.equals("D"))
      return true;
    if (str.equals("E"))
      return true;
    return str.equals("F");
  }

  private void h()
  {
    try
    {
      this.aA = View.inflate(getActivity(), 2130903277, null);
      this.al.addView(this.aA);
      this.al.setVisibility(0);
      this.aB = ((TextView)this.aA.findViewById(2131297548));
      this.aB.setVisibility(8);
      this.aF = ((LinearLayout)this.aA.findViewById(2131297550));
      this.aF.setVisibility(8);
      this.aG = ((LinearLayout)this.aA.findViewById(2131297552));
      this.aG.setVisibility(8);
      int[] arrayOfInt = { 2130838091, 2130838093, 2130838095, 2130838097, 2130838099, 2130838101, 2130838103, 2130838105, 2130838107, 2130838084, 2130838086, 2130838088, 2130838090 };
      LinearLayout localLinearLayout = (LinearLayout)this.aA.findViewById(2131297549);
      localLinearLayout.setVisibility(0);
      this.aC = new EditText[2 * this.c];
      this.aE = new ImageView[2 * this.c];
      this.aD = new ImageView[2 * this.c];
      int i = 0;
      if (i >= this.c);
      for (int j = 0; ; j++)
      {
        if (j >= this.aC.length)
        {
          return;
          View localView = View.inflate(getActivity(), 2130903276, null);
          this.aC[i] = ((EditText)localView.findViewById(2131297544));
          this.aD[i] = ((ImageView)localView.findViewById(2131297545));
          this.aE[i] = ((ImageView)localView.findViewById(2131297546));
          Drawable localDrawable = getResources().getDrawable(arrayOfInt[i]);
          this.aC[i].setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
          localLinearLayout.addView(localView);
          i++;
          break;
        }
        EditText localEditText = this.aC[j];
        if (localEditText == null)
          continue;
        localEditText.addTextChangedListener(new a(j));
      }
    }
    catch (Exception localException)
    {
    }
  }

  private void i()
  {
    if (this.ah.getVisibility() == 0);
    for (int i = 1; ; i = 0)
    {
      if (i != 0)
      {
        this.ag.setVisibility(8);
        this.ak.setVisibility(8);
        this.ah.setVisibility(8);
      }
      switch (this.L.intValue())
      {
      default:
        this.W.setEnabled(true);
        this.W.setText("");
        this.aj.setVisibility(0);
        return;
      case 0:
      case 4:
      case 1:
      case 2:
      case 3:
      case 5:
      }
    }
    k();
    d();
    return;
    d();
    k();
    this.aj.setVisibility(0);
    return;
    j();
  }

  private void j()
  {
    try
    {
      Set localSet = this.ar.keySet();
      int[] arrayOfInt = { 2130838091, 2130838093, 2130838095, 2130838097, 2130838099, 2130838101, 2130838103, 2130838105, 2130838107, 2130838084, 2130838086, 2130838088, 2130838090 };
      List localList = this.G.getCorrectAnswer();
      int i;
      int j;
      if (localList != null)
      {
        i = localList.size();
        if ((this.aC != null) && (this.aC.length > 0))
        {
          j = 0;
          break label472;
        }
      }
      while (true)
      {
        Iterator localIterator = localSet.iterator();
        if (!localIterator.hasNext())
        {
          this.aB.setVisibility(8);
          this.aF.setVisibility(8);
          this.aj.setVisibility(0);
          if ((this.aG == null) || (this.aG.getChildCount() <= 0))
            break;
          this.aG.removeAllViews();
          return;
        }
        label472: 
        do
        {
          Drawable localDrawable2 = getResources().getDrawable(arrayOfInt[j]);
          this.aC[j].setCompoundDrawablesWithIntrinsicBounds(localDrawable2, null, null, null);
          this.aD[j].setVisibility(8);
          this.aC[j].setEnabled(true);
          j++;
          continue;
          Integer localInteger = (Integer)localIterator.next();
          String str = (String)this.ar.get(localInteger);
          if ((str == null) || (str.equals("")) || (str.equals("##")))
          {
            this.aC[localInteger.intValue()].setEnabled(true);
            this.aC[localInteger.intValue()].setText("");
          }
          while (true)
          {
            Drawable localDrawable1 = getResources().getDrawable(arrayOfInt[localInteger.intValue()]);
            this.aC[localInteger.intValue()].setCompoundDrawablesWithIntrinsicBounds(localDrawable1, null, null, null);
            this.aE[localInteger.intValue()].setVisibility(0);
            this.aD[localInteger.intValue()].setVisibility(8);
            this.aC[localInteger.intValue()].setTextColor(getResources().getColor(2131034195));
            break;
            this.aC[localInteger.intValue()].setEnabled(true);
            this.aC[localInteger.intValue()].setText(str);
          }
        }
        while (j < i);
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void k()
  {
    a(this.r, 0);
    a(this.s, 1);
    a(this.t, 2);
    a(this.u, 3);
    a(this.v, 4);
    a(this.w, 5);
  }

  private void l()
  {
    if ((this.aC != null) && (this.aC.length > 0));
    for (int i = 0; ; i++)
    {
      if (i >= this.aC.length)
        return;
      try
      {
        String str = (String)this.ar.get(Integer.valueOf(i));
        if ((str == null) || (str.equals("##")) || (str.equals("")))
          continue;
        this.aC[i].setText(str);
      }
      catch (Exception localException)
      {
      }
    }
  }

  private void m()
  {
    if ((this.aC != null) && (this.aC.length > 0));
    for (int i = 0; ; i++)
    {
      if (i >= this.aC.length)
        return;
      if (this.aC[i] == null)
        continue;
      this.aC[i].setEnabled(false);
    }
  }

  private void n()
  {
    a.a.a.e.i locali = com.withustudy.koudaizikao.e.a.a(getActivity()).a().k();
    String str1 = this.G.getExerciseId();
    KpointDetail localKpointDetail = this.G.getKpointDetail();
    String str2 = "";
    if (localKpointDetail != null)
    {
      Kpoint localKpoint = localKpointDetail.getKpoint();
      if (localKpoint != null)
        str2 = localKpoint.getId();
    }
    String str3 = str2 + str1;
    List localList = locali.a(UserAnsDao.Properties.c.a(str3), new k[0]).d();
    h localh1;
    String[] arrayOfString;
    if ((localList != null) && (localList.size() > 0))
    {
      koudai.db.h localh = (koudai.db.h)localList.get(0);
      String str4 = localh.i();
      this.as = localh.e().booleanValue();
      if ((str4 != null) && (!str4.equals("")))
      {
        localh1 = new h(this);
        arrayOfString = str4.split("%%%%");
      }
    }
    for (int i = 0; ; i++)
    {
      if (i >= arrayOfString.length)
        return;
      String str5 = arrayOfString[i];
      try
      {
        Integer localInteger = (Integer)localh1.get(str5);
        if (localInteger == null)
        {
          this.ar.put(Integer.valueOf(0), str5);
          continue;
        }
        this.ar.put(localInteger, str5);
      }
      catch (Exception localException)
      {
        this.ar.put(Integer.valueOf(0), str5);
      }
      com.withustudy.koudaizikao.g.h.a(getActivity(), "数据库存储的为null或者空串");
      return;
      com.withustudy.koudaizikao.g.h.a(getActivity(), "用户做了数据库没有数据");
      return;
    }
  }

  private void o()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("exerciseId", this.G.getExerciseId());
    localBundle.putString("subjectId", this.at);
    a(QuestionMoreComentActivity.class, 2130968591, 2130968589, false, localBundle);
  }

  private void p()
  {
    String str1 = this.bc.getText().toString().trim();
    if (str1.equals(""))
    {
      Toast.makeText(getActivity(), "内容不能为空", 0).show();
      return;
    }
    ReqComment localReqComment = new ReqComment();
    localReqComment.setClientType(n.a());
    localReqComment.setImei(n.d(this.d));
    localReqComment.setNet(n.c(this.d));
    localReqComment.setVersionName(this.E.p());
    localReqComment.setExerciseId(this.G.getExerciseId());
    Comment localComment1 = new Comment();
    if (this.aN != null)
    {
      int i = this.aN.b;
      Comment localComment2 = this.aN.c;
      Html.fromHtml("今日刷题" + n.a("", "#D6D6D6"));
      localComment1.setReplyFloorContent("回复" + (i + 1) + "楼" + localComment2.getLocation() + "学员: " + localComment2.getContent());
      this.aN = null;
    }
    String str2 = this.E.k();
    localComment1.setCommentTime(System.currentTimeMillis());
    localComment1.setContent(str1);
    localComment1.setLocation(str2);
    UserInfo localUserInfo = new UserInfo();
    localUserInfo.setUid(this.E.i());
    Subjects localSubjects = new Subjects();
    localSubjects.setId(this.at);
    localSubjects.setName("");
    localUserInfo.getSubjects().add(localSubjects);
    localComment1.setUserInfo(localUserInfo);
    localReqComment.setComment(localComment1);
    this.B.a();
    c.b().V().a(this, localReqComment, 4);
  }

  private void q()
  {
    if (!this.aK)
      d();
    switch (this.L.intValue())
    {
    default:
      this.aP = true;
      this.J.e.put(Integer.valueOf(this.F), Boolean.valueOf(this.aP));
      this.W.setEnabled(false);
      this.as = true;
      this.ap = this.G.getScore();
      this.W.getText().toString().trim();
      this.J.d.put(Integer.valueOf(this.F), this.as);
      com.withustudy.koudaizikao.g.h.a("插入currentInx=" + this.F);
      this.J.a(this.G, this.ar, this.as, true, this.ap, this.G.getScore());
      v();
    case 0:
    case 4:
      return;
    case 1:
    case 2:
    case 3:
      this.aP = true;
      this.J.e.put(Integer.valueOf(this.F), Boolean.valueOf(true));
      com.withustudy.koudaizikao.g.h.a("插入currentInx=" + this.F);
      t();
      c(u());
      if (this.as);
      for (this.ap = this.G.getScore(); ; this.ap = 0.0D)
      {
        this.J.d.put(Integer.valueOf(this.F), this.as);
        this.J.a(this.G, this.ar, this.as, true, this.ap, this.G.getScore());
        this.aj.setVisibility(8);
        v();
        e();
        if (!this.as)
          break;
        this.aO.sendEmptyMessageDelayed(11, 500L);
        return;
      }
      com.withustudy.koudaizikao.g.h.a(getActivity(), "做错啦,留在本页!");
      return;
    case 5:
    }
    com.withustudy.koudaizikao.g.h.a("插入currentInx=" + this.F);
    H();
    m();
    this.J.d.put(Integer.valueOf(this.F), this.as);
    if (this.as)
    {
      this.aO.sendEmptyMessageDelayed(11, 500L);
      return;
    }
    com.withustudy.koudaizikao.g.h.a(getActivity(), "做错啦,留在本页!");
  }

  private void r()
  {
    Iterator localIterator = this.ar.keySet().iterator();
    for (int i = 0; ; i++)
    {
      String str;
      do
      {
        if (!localIterator.hasNext())
        {
          c(i);
          return;
        }
        Integer localInteger = (Integer)localIterator.next();
        str = (String)this.ar.get(localInteger);
      }
      while ((str == null) || (str.equals("")));
    }
  }

  private boolean s()
  {
    Iterator localIterator = this.ar.keySet().iterator();
    String str;
    do
    {
      if (!localIterator.hasNext())
        return false;
      Integer localInteger = (Integer)localIterator.next();
      str = (String)this.ar.get(localInteger);
    }
    while ((str == null) || (str.equals("")));
    return true;
  }

  private void t()
  {
    Iterator localIterator = this.ao.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      String str = (String)localIterator.next();
      if ((str == null) || (str.equals("")) || (str.equals("ⅹ")) || (str.equals("√")))
        continue;
      if (str.equals("A"))
      {
        e(0);
        continue;
      }
      if (str.equals("B"))
      {
        e(1);
        continue;
      }
      if (str.equals("C"))
      {
        e(2);
        continue;
      }
      if (str.equals("D"))
      {
        e(3);
        continue;
      }
      if (str.equals("E"))
      {
        e(4);
        continue;
      }
      if (!str.equals("F"))
        continue;
      e(5);
    }
  }

  private int u()
  {
    Iterator localIterator = this.ar.keySet().iterator();
    int i = 0;
    while (true)
    {
      if (!localIterator.hasNext())
        return i;
      Integer localInteger = (Integer)localIterator.next();
      String str = (String)this.ar.get(localInteger);
      if ((str == null) || (str.equals("")))
        continue;
      i++;
      if (this.ao.contains(str))
        continue;
      d(localInteger.intValue());
    }
  }

  private void v()
  {
    F();
    x();
    w();
  }

  private void w()
  {
    this.bb.setOnClickListener(this);
    this.ba.setOnClickListener(this);
    this.aZ.setOnClickListener(this);
  }

  private void x()
  {
    try
    {
      MyErrorRate localMyErrorRate;
      int i;
      if (this.as)
        switch (this.L.intValue())
        {
        default:
          localMyErrorRate = this.G.getMyErrorRate();
          if (localMyErrorRate == null)
            break;
          i = localMyErrorRate.getErrorNum();
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12:
        case 13:
        case 14:
        case 15:
        case 16:
        case 17:
        case 18:
        case 19:
        case 20:
        }
      for (int j = localMyErrorRate.getTotalNum(); ; j = 0)
      {
        String str1;
        label173: int k;
        int m;
        if (this.as)
        {
          str1 = i + "/" + (j + 1);
          ErrorRate localErrorRate = this.G.getErrorRate();
          if (localErrorRate == null)
            break label1398;
          k = localErrorRate.getErrorNum();
          m = localErrorRate.getTotalNum();
        }
        while (true)
        {
          double d1;
          label221: Iterator localIterator3;
          label437: label485: Iterator localIterator2;
          label556: label626: label636: String str6;
          if (this.as)
          {
            d1 = 1.0D * k / (m + 1);
            com.withustudy.koudaizikao.g.h.a("tempErrRate-----" + d1);
            com.withustudy.koudaizikao.g.h.a("tempMyErrRate-----" + str1);
            double d2 = d1 * 100.0D;
            String str2 = new DecimalFormat("0.0").format(d2);
            this.be.setText(str2 + "%");
            this.bf.setText(str1);
            KpointDetail localKpointDetail = this.G.getKpointDetail();
            this.aU.setVisibility(8);
            if (localKpointDetail == null)
              break label1165;
            String str3 = localKpointDetail.getExplainText();
            if ((this.bk == null) || (this.bk.getChildCount() <= 0))
            {
              List localList1 = a("  " + str3, this.K);
              if ((localList1 != null) && (localList1.size() > 0))
              {
                localIterator3 = localList1.iterator();
                if (localIterator3.hasNext())
                  break label952;
                this.bk.setVisibility(0);
              }
            }
            String str4 = localKpointDetail.getGraspRequire();
            if (str4 == null)
              break label976;
            this.aT.setText(str4);
            this.aT.setVisibility(8);
            Kpoint localKpoint = localKpointDetail.getKpoint();
            if (localKpoint != null)
            {
              String str5 = localKpoint.getName();
              this.aS.setText(str5);
            }
            switch ((int)localKpointDetail.getGraspLevel())
            {
            default:
              Explain localExplain = this.G.getExplain();
              if (localExplain != null)
              {
                List localList2 = localExplain.getFigure();
                if ((this.bq == null) || (this.bq.getChildCount() <= 0))
                {
                  if ((localList2 == null) || (localList2.size() <= 0))
                    break label1270;
                  this.bq.setVisibility(0);
                  localIterator2 = localList2.iterator();
                  if (localIterator2.hasNext())
                    break;
                }
                else
                {
                  str6 = localExplain.getText();
                  if ((this.bj == null) || (this.bj.getChildCount() <= 0))
                  {
                    if ((str6 != null) && (!str6.equals("")))
                      break label1282;
                    this.bj.setVisibility(8);
                    this.aX.setVisibility(8);
                    this.bh.setVisibility(8);
                  }
                  label703: this.aY.setVisibility(8);
                  this.bg.setVisibility(8);
                }
              }
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            }
          }
          while (true)
          {
            Message localMessage = this.aO.obtainMessage();
            localMessage.what = 9;
            localMessage.obj = this.G;
            this.aO.sendMessage(localMessage);
            y();
            return;
            this.aQ.setText("恭喜你~答对啦");
            this.aW.setBackgroundResource(2130837989);
            break;
            this.aQ.setText("其实吧~这道题是酱紫滴");
            this.aW.setBackgroundResource(2130837883);
            break;
            HashMap localHashMap = this.J.e;
            if ((localHashMap == null) || (localHashMap.get(Integer.valueOf(this.F)) == null))
            {
              this.aQ.setText("其实吧~这道题是酱紫滴");
              this.aW.setBackgroundResource(2130837883);
            }
            while (true)
            {
              com.withustudy.koudaizikao.g.h.a("isHaveDone ?=" + localHashMap);
              break;
              this.aQ.setText(" 呜呜呜~答错了!");
              this.aW.setBackgroundResource(2130837751);
            }
            str1 = i + 1 + "/" + (j + 1);
            break label173;
            d1 = (1.0D + 1.0D * k) / (m + 1);
            break label221;
            label952: View localView2 = (View)localIterator3.next();
            this.bk.addView(localView2);
            break label437;
            label976: this.aT.setVisibility(0);
            break label485;
            this.bl.setBackgroundResource(2130837506);
            break label556;
            this.bl.setBackgroundResource(2130837710);
            break label556;
            this.bl.setBackgroundResource(2130837710);
            this.bm.setBackgroundResource(2130837710);
            break label556;
            this.bl.setBackgroundResource(2130837710);
            this.bm.setBackgroundResource(2130837710);
            this.bn.setBackgroundResource(2130837710);
            break label556;
            this.bl.setBackgroundResource(2130837710);
            this.bm.setBackgroundResource(2130837710);
            this.bn.setBackgroundResource(2130837710);
            this.bo.setBackgroundResource(2130837710);
            break label556;
            this.bl.setBackgroundResource(2130837710);
            this.bm.setBackgroundResource(2130837710);
            this.bn.setBackgroundResource(2130837710);
            this.bo.setBackgroundResource(2130837710);
            this.bp.setBackgroundResource(2130837710);
            break label556;
            label1165: this.bs.setVisibility(8);
            this.bi.setVisibility(8);
            this.bk.setVisibility(8);
            this.br.setVisibility(8);
            break label556;
            String str7 = (String)localIterator2.next();
            ImageView localImageView = (ImageView)View.inflate(getActivity(), 2130903182, null);
            this.bq.addView(localImageView);
            this.D.a(str7, localImageView);
            localImageView.setOnClickListener(new i(this, str7));
            break label626;
            label1270: this.bq.setVisibility(8);
            break label636;
            label1282: List localList3 = a("  " + str6, this.K);
            if ((localList3 == null) || (localList3.size() <= 0))
              break label703;
            Iterator localIterator1 = localList3.iterator();
            while (localIterator1.hasNext())
            {
              View localView1 = (View)localIterator1.next();
              this.bj.addView(localView1);
            }
            break label703;
            this.aY.setVisibility(8);
            this.aX.setVisibility(8);
            this.bh.setVisibility(8);
          }
          label1398: m = 0;
          k = 0;
        }
        i = 0;
      }
    }
    catch (Exception localException)
    {
    }
  }

  private void y()
  {
    switch (((QuestionDetailActivity)getActivity()).r)
    {
    default:
      return;
    case 100:
    case 101:
    }
    this.ab.setVisibility(8);
    this.ac.setVisibility(8);
    this.ad.setVisibility(8);
    this.am.setVisibility(8);
  }

  private boolean z()
  {
    boolean bool = true;
    if (this.f != null)
      bool &= this.f.isEnabled();
    if (this.g != null)
      bool &= this.g.isEnabled();
    if (this.h != null)
      bool &= this.h.isEnabled();
    if (this.i != null)
      bool &= this.i.isEnabled();
    if (this.j != null)
      bool &= this.j.isEnabled();
    if (this.k != null)
      bool &= this.k.isEnabled();
    return bool;
  }

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    this.e = paramLayoutInflater.inflate(2130903164, null);
    return this.e;
  }

  public void a()
  {
    try
    {
      if (this.G != null)
      {
        this.aq = ((InputMethodManager)getActivity().getSystemService("input_method"));
        this.at = this.J.c;
        this.aK = this.J.g;
        label155: Iterator localIterator;
        if (this.E.f())
        {
          this.P.setVisibility(0);
          this.E.c(false);
          KpointDetail localKpointDetail = this.G.getKpointDetail();
          if (localKpointDetail == null)
            break label430;
          Kpoint localKpoint = localKpointDetail.getKpoint();
          if (localKpoint != null)
          {
            String str1 = localKpoint.getSn();
            String str2 = localKpoint.getName();
            if ((str1 != null) && (!str1.equals("")))
              this.ab.setText(str1);
            if ((str2 != null) && (!str2.equals("")))
              this.ac.setText(str2);
          }
          String str3 = this.G.getExerciseNo();
          int i = this.G.getTotalNum();
          this.af.setText(str3 + "题/" + i + "题");
          this.ae.setText(this.K);
          List localList = this.G.getLabels();
          if ((localList != null) && (localList.size() > 0))
          {
            localIterator = localList.iterator();
            label256: if (localIterator.hasNext())
              break label442;
          }
          this.ao = this.G.getCorrectAnswer();
          this.ar = new HashMap();
          if (!this.aK)
            break label628;
          this.ab.setVisibility(8);
          this.ac.setVisibility(8);
          com.withustudy.koudaizikao.g.h.a("currentIndex-----" + this.F);
          this.ad.setVisibility(8);
          this.am.setVisibility(8);
          switch (this.L.intValue())
          {
          default:
            this.W.setVisibility(0);
          case 0:
          case 1:
          case 2:
          case 3:
          case 4:
          case 5:
          }
        }
        while (true)
        {
          this.aj.setVisibility(8);
          return;
          this.P.setVisibility(8);
          break;
          label430: this.ai.setVisibility(8);
          break label155;
          label442: String str4 = (String)localIterator.next();
          if (str4.contains("真题"))
          {
            this.X.setText(str4);
            this.X.setBackgroundResource(2130838231);
            this.X.setVisibility(0);
            break label256;
          }
          if (str4.contains("模拟"))
          {
            this.Y.setText("模拟");
            this.Y.setBackgroundResource(2130837936);
            this.Y.setVisibility(0);
            break label256;
          }
          if (str4.contains("练习"))
          {
            this.Z.setText("练习");
            this.Z.setBackgroundResource(2130837900);
            this.Z.setVisibility(0);
            break label256;
          }
          if (!str4.contains("预测"))
            break label256;
          this.Y.setText("预测");
          this.Y.setBackgroundResource(2130838225);
          this.Y.setVisibility(0);
          break label256;
          h();
        }
        label628: if ((this.G != null) && (this.L != null))
        {
          switch (this.L.intValue())
          {
          default:
            this.aj.setVisibility(0);
            this.W.setVisibility(0);
            return;
          case 0:
            this.aj.setVisibility(8);
            return;
          case 1:
            this.aj.setEnabled(false);
            this.aj.setVisibility(0);
            return;
          case 2:
            this.aj.setEnabled(false);
            this.aj.setVisibility(0);
            return;
          case 3:
            this.aj.setEnabled(false);
            this.aj.setVisibility(0);
            return;
          case 4:
            this.aj.setVisibility(8);
            return;
          case 5:
          }
          this.al.setVisibility(0);
          h();
          this.aj.setVisibility(0);
        }
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void a(View paramView)
  {
    while (true)
    {
      int j;
      try
      {
        Bundle localBundle = getArguments();
        if (localBundle == null)
          continue;
        Serializable localSerializable = localBundle.getSerializable("exercises");
        if ((localSerializable == null) || (!(localSerializable instanceof Exercises)))
          continue;
        this.G = ((Exercises)localSerializable);
        this.F = localBundle.getInt("position");
        if (this.G == null)
          continue;
        this.K = this.G.getCategory();
        String str;
        try
        {
          this.L = ((Integer)com.withustudy.koudaizikao.d.a.d.get(this.K));
          if (this.L != null)
            continue;
          this.L = Integer.valueOf(20);
          this.P = ((ImageButton)this.e.findViewById(2131297077));
          this.W = ((EditText)paramView.findViewById(2131297023));
          this.M = ((FlowLayout)this.e.findViewById(2131297021));
          this.N = ((LinearLayout)this.e.findViewById(2131297022));
          if (this.G == null)
            continue;
          Stem localStem = this.G.getStem();
          if (localStem == null)
            continue;
          if ((localStem.getText() == null) || (localStem.getText().equals("")))
            continue;
          List localList4 = a(this.G.getStem().getText(), false, this.K);
          this.M.setOption(false);
          localIterator2 = localList4.iterator();
          if (localIterator2.hasNext())
            continue;
          a(this.N, localStem);
          f();
          List localList1 = this.G.getOptions();
          if ((localList1 == null) || (localList1.size() <= 0))
            continue;
          int k = localList1.size();
          Options localOptions = (Options)localList1.get(0);
          if ((localOptions.getContent() == null) || (localOptions.getContent().equals("")))
            continue;
          switch (k)
          {
          default:
            localList2 = this.G.getOptions();
            if (localList2 == null)
              continue;
            int i = localList2.size();
            j = 0;
            if ((i > 0) && (j < localList2.size()))
              continue;
            this.Y = ((TextView)paramView.findViewById(2131297019));
            this.X = ((TextView)paramView.findViewById(2131297018));
            this.Z = ((TextView)paramView.findViewById(2131297020));
            this.aa = ((MyScrollView)paramView.findViewById(2131296258));
            this.W = ((EditText)paramView.findViewById(2131297023));
            this.ab = ((TextView)paramView.findViewById(2131297012));
            this.ac = ((TextView)paramView.findViewById(2131297013));
            this.ad = ((LinearLayout)paramView.findViewById(2131297017));
            this.ae = ((TextView)paramView.findViewById(2131297014));
            this.af = ((TextView)paramView.findViewById(2131297015));
            this.ag = ((LinearLayout)paramView.findViewById(2131297049));
            this.ah = ((LinearLayout)paramView.findViewById(2131296933));
            this.ai = ((LinearLayout)paramView.findViewById(2131297011));
            this.aj = ((Button)paramView.findViewById(2131297045));
            this.aj.setOnClickListener(this);
            this.ak = ((LinearLayout)paramView.findViewById(2131297046));
            this.al = ((LinearLayout)paramView.findViewById(2131297025));
            this.am = ((LinearLayout)paramView.findViewById(2131297016));
            this.ak.setVisibility(8);
            this.an = ((MyListView)paramView.findViewById(2131297073));
            return;
          case 1:
          case 2:
          case 3:
          case 4:
          case 5:
          case 6:
          }
        }
        catch (Exception localException2)
        {
          Iterator localIterator2;
          List localList2;
          this.L = Integer.valueOf(20);
          continue;
          View localView2 = (View)localIterator2.next();
          this.M.addView(localView2);
          continue;
          this.f.setVisibility(0);
          continue;
          this.f.setVisibility(0);
          this.g.setVisibility(0);
          continue;
          this.f.setVisibility(0);
          this.g.setVisibility(0);
          this.h.setVisibility(0);
          continue;
          this.f.setVisibility(0);
          this.g.setVisibility(0);
          this.h.setVisibility(0);
          this.i.setVisibility(0);
          continue;
          this.f.setVisibility(0);
          this.g.setVisibility(0);
          this.h.setVisibility(0);
          this.i.setVisibility(0);
          this.j.setVisibility(0);
          continue;
          this.f.setVisibility(0);
          this.g.setVisibility(0);
          this.h.setVisibility(0);
          this.i.setVisibility(0);
          this.j.setVisibility(0);
          this.k.setVisibility(0);
          continue;
          str = ((Options)localList2.get(j)).getContent();
          if (str == null)
            break label1187;
        }
        if (!str.equals(""))
        {
          List localList3 = a(str, true, this.K);
          com.withustudy.koudaizikao.g.h.a("questionDetailFragment optionViews size=" + localList3.size());
          Iterator localIterator1 = localList3.iterator();
          if (localIterator1.hasNext())
          {
            View localView1 = (View)localIterator1.next();
            switch (j)
            {
            case 0:
              this.r.setOption(true);
              this.r.addView(localView1);
              break;
            case 1:
              this.s.setOption(true);
              this.s.addView(localView1);
              break;
            case 2:
              this.t.setOption(true);
              this.t.addView(localView1);
              break;
            case 3:
              this.u.setOption(true);
              this.u.addView(localView1);
              break;
            case 4:
              this.v.setOption(true);
              this.v.addView(localView1);
              break;
            case 5:
              this.w.setOption(true);
              this.w.addView(localView1);
              continue;
              return;
            }
          }
        }
      }
      catch (Exception localException1)
      {
        return;
      }
      label1187: j++;
      continue;
    }
  }

  public void b()
  {
  }

  public void c()
  {
    try
    {
      this.P.setOnTouchListener(new e(this));
      this.W.addTextChangedListener(new f(this));
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void d()
  {
    if (this.f != null)
      this.f.setEnabled(true);
    if (this.g != null)
      this.g.setEnabled(true);
    if (this.h != null)
      this.h.setEnabled(true);
    if (this.i != null)
      this.i.setEnabled(true);
    if (this.j != null)
      this.j.setEnabled(true);
    if (this.k != null)
      this.k.setEnabled(true);
  }

  public void e()
  {
    if (this.f != null)
      this.f.setEnabled(false);
    if (this.g != null)
      this.g.setEnabled(false);
    if (this.h != null)
      this.h.setEnabled(false);
    if (this.i != null)
      this.i.setEnabled(false);
    if (this.j != null)
      this.j.setEnabled(false);
    if (this.k != null)
      this.k.setEnabled(false);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.I = LocalBroadcastManager.getInstance(getActivity());
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.refresh");
    this.H = new g(this);
    this.I.registerReceiver(this.H, localIntentFilter);
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.J = ((BrushExcerciseDetailActivity)paramActivity);
  }

  public void onClick(View paramView)
  {
    super.onClick(paramView);
    try
    {
      switch (paramView.getId())
      {
      case 2131297077:
        this.E.c(false);
        this.P.setVisibility(8);
        return;
      case 2131297026:
        a(0, false);
        return;
      case 2131297029:
        a(1, false);
        return;
      case 2131297032:
        a(2, false);
        return;
      case 2131297035:
        a(3, false);
        return;
      case 2131297038:
        a(4, false);
        return;
      case 2131297041:
        a(5, false);
        return;
      case 2131297076:
        p();
        return;
      case 2131297074:
        o();
        return;
      case 2131297045:
        q();
      case 2131297075:
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.I.unregisterReceiver(this.H);
    this.H = null;
    this.I = null;
  }

  public void onResume()
  {
    super.onResume();
    try
    {
      a(true);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.B.b();
    Gson localGson;
    if (paramString1 != null)
    {
      localGson = c.a();
      switch (paramInt)
      {
      default:
      case 4:
      case 10:
      }
    }
    while (true)
    {
      return;
      this.aH = ((PublishCommentBean)localGson.fromJson(paramString1, PublishCommentBean.class));
      if (this.aH != null)
      {
        if ("OK".equals(this.aH.getStatus()))
        {
          this.aO.sendEmptyMessageDelayed(6, 400L);
          return;
        }
        this.aO.sendEmptyMessageDelayed(8, 400L);
        return;
      }
      com.withustudy.koudaizikao.g.h.a("发布评论解析异常");
      return;
      try
      {
        this.aI = ((BrushExcerciseBean)localGson.fromJson(paramString1, BrushExcerciseBean.class));
        if (this.aI == null)
          break;
        List localList = this.aI.getExercises();
        if ((localList == null) || (localList.size() <= 0))
          continue;
        Exercises localExercises = (Exercises)localList.get(0);
        this.J.f.set(this.F, localExercises);
        this.G = localExercises;
        Message localMessage = this.aO.obtainMessage();
        localMessage.what = 9;
        localMessage.obj = localExercises;
        this.aO.sendMessage(localMessage);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        com.withustudy.koudaizikao.g.h.a("刷题主界面数据实体解析异常:" + localException.getMessage());
        return;
      }
    }
    com.withustudy.koudaizikao.g.h.a("刷题主界面数据解析实体bean为null");
  }

  private class a
    implements TextWatcher
  {
    private int b;

    public a(int arg2)
    {
      int i;
      this.b = i;
    }

    public void afterTextChanged(Editable paramEditable)
    {
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      String str1 = paramCharSequence.toString();
      if ((str1 == null) || (str1.equals("")))
        BrushExcerciseDetailFragment.p(BrushExcerciseDetailFragment.this).put(Integer.valueOf(this.b), "");
      List localList;
      int j;
      int k;
      label121: int i3;
      label131: label138: int n;
      int i1;
      label300: int m;
      while (true)
      {
        if (!BrushExcerciseDetailFragment.q(BrushExcerciseDetailFragment.this))
          break label629;
        localList = BrushExcerciseDetailFragment.e(BrushExcerciseDetailFragment.this).getCorrectAnswer();
        int i = localList.size();
        j = 0;
        k = paramInt3;
        if (j >= i)
        {
          if (k > 0)
          {
            BrushExcerciseDetailFragment.l(BrushExcerciseDetailFragment.this).e.put(Integer.valueOf(BrushExcerciseDetailFragment.s(BrushExcerciseDetailFragment.this)), Boolean.valueOf(true));
            if (k != i)
              break label540;
            i3 = 0;
            if (i3 < i)
              break label442;
            n = 0;
            i1 = 0;
            if (n < i)
              break label551;
            double d = BrushExcerciseDetailFragment.e(BrushExcerciseDetailFragment.this).getScore();
            BrushExcerciseDetailFragment.a(BrushExcerciseDetailFragment.this, d * (1.0D * i1 / i));
            BrushExcerciseDetailFragment.l(BrushExcerciseDetailFragment.this).d.put(Integer.valueOf(BrushExcerciseDetailFragment.s(BrushExcerciseDetailFragment.this)), BrushExcerciseDetailFragment.t(BrushExcerciseDetailFragment.this));
            BrushExcerciseDetailFragment.l(BrushExcerciseDetailFragment.this).a(BrushExcerciseDetailFragment.e(BrushExcerciseDetailFragment.this), BrushExcerciseDetailFragment.p(BrushExcerciseDetailFragment.this), BrushExcerciseDetailFragment.t(BrushExcerciseDetailFragment.this), true, BrushExcerciseDetailFragment.u(BrushExcerciseDetailFragment.this), BrushExcerciseDetailFragment.e(BrushExcerciseDetailFragment.this).getScore());
            com.withustudy.koudaizikao.g.h.a("插入currentInx=" + BrushExcerciseDetailFragment.s(BrushExcerciseDetailFragment.this));
            return;
            BrushExcerciseDetailFragment.p(BrushExcerciseDetailFragment.this).put(Integer.valueOf(this.b), str1);
            continue;
          }
        }
        else
        {
          String str2 = (String)localList.get(j);
          String str3 = BrushExcerciseDetailFragment.r(BrushExcerciseDetailFragment.this)[j].getText().toString().trim();
          if ((str3 == null) || (str3.equals("")))
            break label734;
          if (!str2.equals(str3))
            break;
          m = k + 1;
        }
      }
      while (true)
      {
        j++;
        k = m;
        break;
        m = k + 1;
        continue;
        BrushExcerciseDetailFragment.l(BrushExcerciseDetailFragment.this).e.put(Integer.valueOf(BrushExcerciseDetailFragment.s(BrushExcerciseDetailFragment.this)), Boolean.valueOf(false));
        break label121;
        label442: String str6 = (String)localList.get(i3);
        String str7 = BrushExcerciseDetailFragment.r(BrushExcerciseDetailFragment.this)[i3].getText().toString().trim();
        if ((str7 == null) || (str7.equals("")))
        {
          BrushExcerciseDetailFragment.b(BrushExcerciseDetailFragment.this, false);
          break label138;
        }
        if (str6.equals(str7))
        {
          BrushExcerciseDetailFragment.b(BrushExcerciseDetailFragment.this, true);
          i3++;
          break label131;
        }
        BrushExcerciseDetailFragment.b(BrushExcerciseDetailFragment.this, false);
        break label138;
        label540: BrushExcerciseDetailFragment.b(BrushExcerciseDetailFragment.this, false);
        break label138;
        label551: String str4 = (String)localList.get(n);
        String str5 = BrushExcerciseDetailFragment.r(BrushExcerciseDetailFragment.this)[n].getText().toString().trim();
        if ((str5 != null) && (!str5.equals("")) && (str4.equals(str5)));
        for (int i2 = i1 + 1; ; i2 = i1)
        {
          n++;
          i1 = i2;
          break;
          label629: boolean bool = BrushExcerciseDetailFragment.l(BrushExcerciseDetailFragment.this).a;
          if ((str1 == null) || (str1.equals("")) || (bool))
            break label300;
          BrushExcerciseDetailFragment.b(BrushExcerciseDetailFragment.this, false);
          BrushExcerciseDetailFragment.a(BrushExcerciseDetailFragment.this, 0.0D);
          BrushExcerciseDetailFragment.l(BrushExcerciseDetailFragment.this).a(BrushExcerciseDetailFragment.e(BrushExcerciseDetailFragment.this), BrushExcerciseDetailFragment.p(BrushExcerciseDetailFragment.this), BrushExcerciseDetailFragment.t(BrushExcerciseDetailFragment.this), false, BrushExcerciseDetailFragment.u(BrushExcerciseDetailFragment.this), BrushExcerciseDetailFragment.e(BrushExcerciseDetailFragment.this).getScore());
          return;
        }
        label734: m = k;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.koudai.test.BrushExcerciseDetailFragment
 * JD-Core Version:    0.6.0
 */