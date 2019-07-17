package com.withustudy.koudaizikao.fragment;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.http.e;
import com.example.test.FlowLayout;
import com.google.gson.Gson;
import com.himamis.retex.renderer.android.LaTeXView;
import com.umeng.a.g;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.QuestionDetailActivity;
import com.withustudy.koudaizikao.activity.QuestionMoreComentActivity;
import com.withustudy.koudaizikao.b.i;
import com.withustudy.koudaizikao.b.i.b;
import com.withustudy.koudaizikao.base.SimpleAbsFragImpl;
import com.withustudy.koudaizikao.custom.MyListView;
import com.withustudy.koudaizikao.custom.MyScrollView;
import com.withustudy.koudaizikao.custom.MyScrollView.a;
import com.withustudy.koudaizikao.d.a;
import com.withustudy.koudaizikao.d.f;
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
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QuestionDetailFragment extends SimpleAbsFragImpl
  implements View.OnClickListener, MyScrollView.a
{
  public static final int a = 7;
  private static final int b = 4;
  private static final int c = 10;
  private static final int d = 9;
  private static final int e = 6;
  private static final int f = 5;
  private static final int g = 8;
  private FlowLayout F;
  private FlowLayout G;
  private FlowLayout H;
  private FlowLayout I;
  private FlowLayout J;
  private EditText K;
  private TextView L;
  private TextView M;
  private LinearLayout N;
  private TextView O;
  private TextView P;
  private LinearLayout Q;
  private LinearLayout R;
  private LinearLayout S;
  private LinearLayout T;
  private MyListView U;
  private LinearLayout V;
  private int W;
  private Button X;
  private int Y;
  private Exercises Z;
  private Handler aA = new p(this);
  private TextView aB;
  private TextView aC;
  private TextView aD;
  private TextView aE;
  private TextView aF;
  private TextView aG;
  private ImageView aH;
  private TextView aI;
  private TextView aJ;
  private Button aK;
  private Button aL;
  private ImageButton aM;
  private EditText aN;
  private LinearLayout aO;
  private TextView aP;
  private TextView aQ;
  private LinearLayout aR;
  private ImageView aS;
  private TextView aT;
  private FlowLayout aU;
  private FlowLayout aV;
  private ImageView aW;
  private ImageView aX;
  private ImageView aY;
  private ImageView aZ;
  private boolean aa;
  private QuestionDetailActivity ab;
  private List<String> ac;
  private HashMap<Integer, String> ad;
  private String ae;
  private int af = -1;
  private String ag;
  private boolean ah = false;
  private double ai = 0.0D;
  private MyScrollView aj;
  private TextView ak;
  private TextView al;
  private TextView am;
  private LinearLayout an;
  private ImageButton ao;
  private LinearLayout ap;
  private View aq;
  private TextView ar;
  private EditText[] as;
  private ImageView[] at;
  private LinearLayout au;
  private LinearLayout av;
  private boolean aw = false;
  private i ax;
  private boolean ay = true;
  private i.b az;
  private ImageView ba;
  private LinearLayout bb;
  private ImageView bc;
  private RelativeLayout bd;
  private EditText be;
  private EditText bf;
  private EditText bg;
  private EditText bh;
  private EditText bi;
  private EditText bj;
  private InputMethodManager bk;
  private PublishCommentBean bl;
  private BrushExcerciseBean bm;
  private List<Comment> bn;
  private View h;
  private FlowLayout i;
  private FlowLayout j;
  private LinearLayout k;
  private LinearLayout l;
  private LinearLayout m;
  private LinearLayout n;
  private LinearLayout o;
  private LinearLayout p;
  private ImageView q;
  private ImageView r;
  private ImageView s;
  private ImageView t;
  private ImageView u;
  private ImageView v;
  private FlowLayout w;

  private void A()
  {
    if (!this.aa);
    switch (this.af)
    {
    default:
      if (!this.K.isEnabled())
        break;
      this.ab.j.put(Integer.valueOf(this.Y), Boolean.valueOf(true));
      this.K.setEnabled(false);
      this.ah = true;
      this.ai = this.Z.getScore();
      this.ab.a.put(Integer.valueOf(this.Y), this.ah);
      h.a("插入currentInx=" + this.Y);
      this.ab.a(this.Z, this.ad, this.ah, this.ai, this.Z.getScore());
      w();
      u();
      c();
    case 0:
    case 4:
    case 1:
    case 2:
    case 3:
      do
        return;
      while (!x());
      this.aw = true;
      this.ab.j.put(Integer.valueOf(this.Y), Boolean.valueOf(true));
      h.a("插入currentInx=" + this.Y);
      r();
      this.ab.a(this.Z, this.ad, this.ah, this.ai, this.Z.getScore());
      return;
    case 5:
    }
    h.a("插入currentInx=" + this.Y);
    C();
    this.ab.a(this.Z, this.ad, this.ah, this.ai, this.Z.getScore());
  }

  private void B()
  {
    try
    {
      if ((this.av != null) && (this.av.getChildCount() > 0))
        this.av.removeAllViews();
      List localList = this.Z.getCorrectAnswer();
      int i1;
      int[] arrayOfInt;
      int i2;
      if (localList != null)
      {
        i1 = localList.size();
        arrayOfInt = new int[] { 2130838091, 2130838093, 2130838095, 2130838097, 2130838099, 2130838101, 2130838103, 2130838105, 2130838107, 2130838084, 2130838086, 2130838088, 2130838090 };
        this.ar.setVisibility(0);
        i2 = 0;
      }
      else
      {
        this.X.setVisibility(8);
        s();
        return;
      }
      label443: 
      while (true)
      {
        String str1 = (String)localList.get(i2);
        String str2 = this.as[i2].getText().toString().trim();
        if ((this.as != null) && (this.as.length > 0))
        {
          if ((str2 == null) || (str2.equals("")))
          {
            this.as[i2].setTextColor(getResources().getColor(2131034206));
            this.as[i2].setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(arrayOfInt[i2]), null, getResources().getDrawable(2130837810), null);
            i(i2);
          }
          while (true)
          {
            this.as[i2].setEnabled(false);
            break;
            if (str1.equals(str2))
            {
              this.as[i2].setTextColor(getResources().getColor(2131034205));
              this.as[i2].setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(arrayOfInt[i2]), null, getResources().getDrawable(2130838001), null);
              continue;
            }
            this.as[i2].setTextColor(getResources().getColor(2131034206));
            this.as[i2].setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(arrayOfInt[i2]), null, getResources().getDrawable(2130837810), null);
            i(i2);
          }
        }
        while (true)
        {
          if (i2 < i1)
            break label443;
          break;
          i2++;
        }
      }
    }
    catch (Exception localException)
    {
    }
  }

  private void C()
  {
    int i1 = 0;
    try
    {
      List localList = this.Z.getCorrectAnswer();
      int i2 = localList.size();
      int[] arrayOfInt = { 2130838091, 2130838093, 2130838095, 2130838097, 2130838099, 2130838101, 2130838103, 2130838105, 2130838107, 2130838084, 2130838086, 2130838088, 2130838090 };
      this.ar.setVisibility(0);
      int i3 = 0;
      int i4 = 0;
      while (true)
      {
        int i6;
        if (this.aa)
        {
          i6 = 0;
          if (i6 >= i2)
            this.ai = (this.Z.getScore() * (1.0D * i1 / i2));
        }
        else
        {
          this.ab.a.put(Integer.valueOf(this.Y), this.ah);
          this.X.setVisibility(8);
          this.aw = true;
          this.ab.j.put(Integer.valueOf(this.Y), Boolean.valueOf(true));
          s();
          return;
          label239: String str1 = (String)localList.get(i4);
          String str2 = this.as[i4].getText().toString().trim();
          int i5;
          if ((str2 == null) || (str2.equals("")))
          {
            this.as[i4].setTextColor(getResources().getColor(2131034206));
            this.as[i4].setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(arrayOfInt[i4]), null, getResources().getDrawable(2130837810), null);
            i(i4);
            i5 = i3;
          }
          while (true)
          {
            this.as[i4].setEnabled(false);
            i4++;
            i3 = i5;
            break;
            if (str1.equals(str2))
            {
              i5 = i3 + 1;
              this.as[i4].setTextColor(getResources().getColor(2131034205));
              this.as[i4].setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(arrayOfInt[i4]), null, getResources().getDrawable(2130838001), null);
              continue;
            }
            i5 = i3 + 1;
            this.as[i4].setTextColor(getResources().getColor(2131034206));
            this.as[i4].setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(arrayOfInt[i4]), null, getResources().getDrawable(2130837810), null);
            i(i4);
          }
        }
        int i8;
        do
        {
          String str5 = (String)localList.get(i8);
          String str6 = this.as[i8].getText().toString().trim();
          if ((str6 == null) || (str6.equals("")))
          {
            this.ah = false;
            break;
          }
          if (str5.equals(str6))
          {
            this.ah = true;
            i8++;
          }
          else
          {
            this.ah = false;
            break;
            do
            {
              this.ah = false;
              break;
              String str3 = (String)localList.get(i6);
              String str4 = this.as[i6].getText().toString().trim();
              if ((str4 != null) && (!str4.equals("")))
              {
                boolean bool = str3.equals(str4);
                if (!bool);
              }
              for (int i7 = i1 + 1; ; i7 = i1)
              {
                i6++;
                i1 = i7;
                break;
              }
              if (i4 < i2)
                break label239;
            }
            while (i3 != i2);
            i8 = 0;
          }
        }
        while (i8 < i2);
      }
    }
    catch (Exception localException)
    {
    }
  }

  private void D()
  {
    try
    {
      Set localSet = this.ad.keySet();
      int[] arrayOfInt = { 2130838091, 2130838093, 2130838095, 2130838097, 2130838099, 2130838101, 2130838103, 2130838105, 2130838107, 2130838084, 2130838086, 2130838088, 2130838090 };
      List localList = this.Z.getCorrectAnswer();
      int i1;
      int i2;
      if (localList != null)
      {
        i1 = localList.size();
        if ((this.as != null) && (this.as.length > 0))
        {
          i2 = 0;
          break label434;
        }
      }
      while (true)
      {
        Iterator localIterator = localSet.iterator();
        if (!localIterator.hasNext())
        {
          this.ar.setVisibility(8);
          this.au.setVisibility(8);
          this.X.setVisibility(0);
          if ((this.av == null) || (this.av.getChildCount() <= 0))
            break;
          this.av.removeAllViews();
          return;
        }
        label434: 
        do
        {
          Drawable localDrawable2 = getResources().getDrawable(arrayOfInt[i2]);
          this.as[i2].setCompoundDrawablesWithIntrinsicBounds(localDrawable2, null, null, null);
          this.as[i2].setEnabled(true);
          i2++;
          continue;
          Integer localInteger = (Integer)localIterator.next();
          String str = (String)this.ad.get(localInteger);
          if ((str == null) || (str.equals("")))
          {
            this.as[localInteger.intValue()].setEnabled(true);
            this.as[localInteger.intValue()].setText("");
          }
          while (true)
          {
            Drawable localDrawable1 = getResources().getDrawable(arrayOfInt[localInteger.intValue()]);
            this.as[localInteger.intValue()].setCompoundDrawablesWithIntrinsicBounds(localDrawable1, null, null, null);
            this.at[localInteger.intValue()].setVisibility(0);
            this.as[localInteger.intValue()].setTextColor(getResources().getColor(2131034195));
            break;
            this.as[localInteger.intValue()].setEnabled(true);
            this.as[localInteger.intValue()].setText(str);
          }
        }
        while (i2 < i1);
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void E()
  {
    a(this.w, 0);
    a(this.F, 1);
    a(this.G, 2);
    a(this.H, 3);
    a(this.I, 4);
    a(this.J, 5);
  }

  private void F()
  {
    String str1 = this.aN.getText().toString().trim();
    if (str1.equals(""))
    {
      Toast.makeText(getActivity(), "内容不能为空", 0).show();
      return;
    }
    ReqComment localReqComment = new ReqComment();
    localReqComment.setClientType(n.a());
    localReqComment.setImei(n.d(this.y));
    localReqComment.setNet(n.c(this.y));
    localReqComment.setVersionName(this.E.p());
    localReqComment.setExerciseId(this.Z.getExerciseId());
    Comment localComment1 = new Comment();
    if (this.az != null)
    {
      int i1 = this.az.b;
      Comment localComment2 = this.az.c;
      Html.fromHtml("今日刷题" + n.a("", "#D6D6D6"));
      localComment1.setReplyFloorContent("回复" + (i1 + 1) + "楼" + localComment2.getLocation() + "学员: " + localComment2.getContent());
      this.az = null;
    }
    String str2 = this.E.k();
    localComment1.setCommentTime(System.currentTimeMillis());
    localComment1.setContent(str1);
    localComment1.setLocation(str2);
    UserInfo localUserInfo = new UserInfo();
    localUserInfo.setUid(this.E.i());
    Subjects localSubjects = new Subjects();
    localSubjects.setId(this.ag);
    localSubjects.setName("");
    localUserInfo.getSubjects().add(localSubjects);
    localComment1.setUserInfo(localUserInfo);
    localReqComment.setComment(localComment1);
    this.B.a();
    c.b().V().a(this, localReqComment, 4);
  }

  private void G()
  {
  }

  private void H()
  {
    this.E.c(false);
    this.ao.setVisibility(8);
  }

  private List<String> a(String paramString)
  {
    int i1 = 0;
    ArrayList localArrayList = new ArrayList();
    int i2 = paramString.indexOf("[pic:", i1);
    Iterator localIterator;
    if (i2 == -1)
    {
      if (i1 + 1 < paramString.length())
        localArrayList.add(paramString.substring(i1 + 1, paramString.length()));
      localIterator = localArrayList.iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
      {
        return localArrayList;
        if (i1 + 1 < i2)
        {
          localArrayList.add(paramString.substring(i1, i2));
          i1 = i2;
        }
        int i3 = paramString.indexOf("]", i1);
        if ((i3 == -1) || (i1 + 1 >= i3))
          break;
        localArrayList.add(paramString.substring(i1 + 1, i3));
        i1 = i3 + 1;
        break;
      }
      String str = (String)localIterator.next();
      h.a("知识点 讲解公式 文字 图片 混排切割 " + str);
    }
  }

  private List<View> a(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList;
    String str1;
    int i1;
    TextView localTextView3;
    if ((paramString != null) && (!paramString.equals("")) && (paramString.length() > 0))
    {
      localArrayList = new ArrayList();
      this.W = 0;
      str1 = "";
      i1 = 0;
      if (i1 >= paramString.length())
        if (!str1.equals(""))
        {
          localTextView3 = new TextView(getActivity());
          if (!paramBoolean)
            break label984;
          localTextView3.setTextSize(2, 15.0F);
          localTextView3.setTextColor(getResources().getColor(2131034225));
        }
    }
    while (true)
    {
      localTextView3.setLineSpacing(0.0F, 1.3F);
      localTextView3.setText(str1);
      localArrayList.add(localTextView3);
      return localArrayList;
      String str2 = paramString.substring(i1, i1 + 1);
      if (str2.equals("$"))
      {
        TextView localTextView1 = new TextView(getActivity());
        if (paramBoolean)
        {
          localTextView1.setTextSize(2, 15.0F);
          localTextView1.setTextColor(getResources().getColor(2131034225));
        }
        while (true)
        {
          localTextView1.setLineSpacing(0.0F, 1.3F);
          localTextView1.setText(str1);
          localArrayList.add(localTextView1);
          str1 = "";
          i1 += 2;
          label227: i1++;
          break;
          localTextView1.setTextSize(2, 17.0F);
          localTextView1.setTextColor(getResources().getColor(2131034226));
        }
      }
      if (str2.equals("#"));
      try
      {
        LaTeXView localLaTeXView = new LaTeXView(getActivity());
        localLaTeXView.setLatexText(str1);
        localArrayList.add(localLaTeXView);
        label300: str1 = "";
        i1 += 2;
        break label227;
        if ((str2.equals("_")) && (this.ae.equals("填空")))
        {
          if ((i1 + 1 < paramString.length()) && (i1 + 2 < paramString.length()) && (i1 + 3 < paramString.length()) && (i1 + 4 <= paramString.length()))
          {
            String str3 = paramString.substring(i1 + 1, i1 + 2);
            String str4 = paramString.substring(i1 + 2, i1 + 3);
            String str5 = paramString.substring(i1 + 3, i1 + 4);
            if ((str3.equals("_")) && (str4.equals("_")) && (str5.equals("_")))
            {
              TextView localTextView2 = new TextView(getActivity());
              label495: ImageView localImageView;
              if (paramBoolean)
              {
                localTextView2.setTextSize(2, 15.0F);
                localTextView2.setTextColor(getResources().getColor(2131034225));
                localTextView2.setLineSpacing(0.0F, 1.3F);
                localTextView2.setText(str1);
                localArrayList.add(localTextView2);
                str1 = "";
                localImageView = new ImageView(getActivity());
                this.W = (1 + this.W);
                switch (this.W)
                {
                default:
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
                }
              }
              while (true)
              {
                localArrayList.add(localImageView);
                i1 += 3;
                break;
                localTextView2.setTextSize(2, 17.0F);
                localTextView2.setTextColor(getResources().getColor(2131034226));
                break label495;
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
                continue;
                localImageView.setBackgroundResource(2130838100);
                localImageView.setTag("tk6");
                continue;
                localImageView.setBackgroundResource(2130838102);
                localImageView.setTag("tk7");
                continue;
                localImageView.setBackgroundResource(2130838104);
                localImageView.setTag("tk8");
                continue;
                localImageView.setBackgroundResource(2130838106);
                localImageView.setTag("tk9");
                continue;
                localImageView.setBackgroundResource(2130838083);
                localImageView.setTag("tk10");
                continue;
                localImageView.setBackgroundResource(2130838085);
                localImageView.setTag("tk11");
                continue;
                localImageView.setBackgroundResource(2130838087);
                localImageView.setTag("tk12");
                continue;
                localImageView.setBackgroundResource(2130838089);
                localImageView.setTag("tk13");
              }
            }
            str1 = str1 + str2;
            break label227;
          }
          str1 = str1 + str2;
          break label227;
        }
        str1 = str1 + str2;
        break label227;
        label984: localTextView3.setTextSize(2, 17.0F);
        localTextView3.setTextColor(getResources().getColor(2131034226));
        continue;
        return null;
      }
      catch (Exception localException)
      {
        break label300;
      }
    }
  }

  private void a(FlowLayout paramFlowLayout, int paramInt)
  {
    int i2;
    if (paramFlowLayout != null)
    {
      int i1 = paramFlowLayout.getChildCount();
      i2 = 0;
      if (i2 < i1);
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
                View localView = paramFlowLayout.getChildAt(i2);
                if ((localView instanceof TextView))
                  ((TextView)localView).setTextColor(getResources().getColor(2131034225));
                while (true)
                {
                  i2++;
                  break;
                  if (!(localView instanceof ImageView))
                    continue;
                  localView.setVisibility(8);
                }
              }
              while (this.q == null);
              this.q.setBackgroundResource(2130837507);
              return;
            }
            while (this.r == null);
            this.r.setBackgroundResource(2130837578);
            return;
          }
          while (this.s == null);
          this.s.setBackgroundResource(2130837711);
          return;
        }
        while (this.t == null);
        this.t.setBackgroundResource(2130837749);
        return;
      }
      while (this.u == null);
      this.u.setBackgroundResource(2130837779);
      return;
    }
    while (this.v == null);
    this.v.setBackgroundResource(2130837817);
  }

  private void a(FlowLayout paramFlowLayout, boolean paramBoolean)
  {
    b(paramFlowLayout, paramBoolean);
    ImageView localImageView;
    if (x())
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
      if (this.bn != null)
        break label71;
      this.bn = new ArrayList();
    }
    while (true)
    {
      this.bn.addAll(localList);
      this.aA.sendEmptyMessage(10);
      return;
      label71: this.bn.clear();
    }
    label83: this.ay = false;
    return;
    label89: this.ay = false;
  }

  private void a(Stem paramStem)
  {
    List localList = paramStem.getFigure();
    Iterator localIterator;
    if ((localList != null) && (localList.size() > 0))
    {
      this.ap.setVisibility(0);
      localIterator = localList.iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      String str = (String)localIterator.next();
      ImageView localImageView = (ImageView)View.inflate(getActivity(), 2130903182, null);
      this.ap.addView(localImageView);
      this.D.a(str, localImageView);
      localImageView.setOnClickListener(new q(this, str));
    }
  }

  private void a(Integer paramInteger)
  {
    switch (paramInteger.intValue())
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
                if (this.w == null)
                  continue;
                b(this.w, true);
              }
              while (this.q == null);
              this.q.setBackgroundResource(2130837504);
              return;
              if (this.F == null)
                continue;
              b(this.F, true);
            }
            while (this.r == null);
            this.r.setBackgroundResource(2130837575);
            return;
            if (this.G == null)
              continue;
            b(this.G, true);
          }
          while (this.s == null);
          this.s.setBackgroundResource(2130837708);
          return;
          if (this.H == null)
            continue;
          b(this.H, true);
        }
        while (this.t == null);
        this.t.setBackgroundResource(2130837747);
        return;
        if (this.I == null)
          continue;
        b(this.I, true);
      }
      while (this.u == null);
      this.u.setBackgroundResource(2130837777);
      return;
      if (this.J == null)
        continue;
      b(this.J, true);
    }
    while (this.v == null);
    this.v.setBackgroundResource(2130837815);
  }

  private List<View> b(String paramString)
  {
    List localList = a(paramString);
    if ((localList != null) && (localList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localList.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          return localArrayList;
        String str1 = (String)localIterator.next();
        if (str1.contains("pic:"))
        {
          ImageView localImageView = (ImageView)View.inflate(getActivity(), 2130903182, null);
          localArrayList.add(localImageView);
          String str2 = str1.substring("pic:".length());
          localImageView.setOnClickListener(new u(this, str2));
          this.D.a(str2, localImageView);
          continue;
        }
        localArrayList.addAll(a(str1, true));
      }
    }
    return null;
  }

  private void b(FlowLayout paramFlowLayout, boolean paramBoolean)
  {
    int i2;
    if (paramFlowLayout != null)
    {
      int i1 = paramFlowLayout.getChildCount();
      i2 = 0;
      if (i2 < i1);
    }
    else
    {
      return;
    }
    View localView = paramFlowLayout.getChildAt(i2);
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
      i2++;
      break;
      label67: localTextView.setTextColor(getResources().getColor(2131034204));
    }
  }

  private void c(int paramInt)
  {
    if (this.aa)
      e(paramInt);
    do
      return;
    while (!l());
    e(paramInt);
  }

  private void c(FlowLayout paramFlowLayout, boolean paramBoolean)
  {
    int i2;
    if (paramFlowLayout != null)
    {
      int i1 = paramFlowLayout.getChildCount();
      i2 = 0;
      if (i2 < i1);
    }
    else
    {
      return;
    }
    View localView = paramFlowLayout.getChildAt(i2);
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
      i2++;
      break;
      label67: localTextView.setTextColor(getResources().getColor(2131034225));
    }
  }

  private boolean d(int paramInt)
  {
    String str = (String)this.ad.get(Integer.valueOf(paramInt));
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

  private void e(int paramInt)
  {
    Boolean localBoolean;
    if ((this.af == 2) || (this.af == 1) || (this.af == 3))
    {
      localBoolean = Boolean.valueOf(d(paramInt));
      switch (paramInt)
      {
      default:
        if (m())
        {
          this.X.setEnabled(true);
          label87: if (!this.aa)
            break;
          if (!m())
            break label733;
          this.ab.j.put(Integer.valueOf(this.Y), Boolean.valueOf(true));
          label123: n();
        }
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
    }
    label733: 
    do
    {
      return;
      if ((localBoolean == null) || (!localBoolean.booleanValue()))
      {
        if (this.q == null)
          break;
        this.q.setBackgroundResource(2130837504);
        c(this.w, true);
        this.ad.put(Integer.valueOf(paramInt), "A");
        break;
      }
      if (this.q == null)
        break;
      this.q.setBackgroundResource(2130837507);
      c(this.w, false);
      this.ad.put(Integer.valueOf(paramInt), "");
      break;
      if ((localBoolean == null) || (!localBoolean.booleanValue()))
      {
        if (this.r == null)
          break;
        this.r.setBackgroundResource(2130837575);
        c(this.F, true);
        this.ad.put(Integer.valueOf(paramInt), "B");
        break;
      }
      if (this.r == null)
        break;
      this.r.setBackgroundResource(2130837578);
      c(this.F, false);
      this.ad.put(Integer.valueOf(paramInt), "");
      break;
      if ((localBoolean == null) || (!localBoolean.booleanValue()))
      {
        if (this.s == null)
          break;
        this.s.setBackgroundResource(2130837708);
        c(this.G, true);
        this.ad.put(Integer.valueOf(paramInt), "C");
        break;
      }
      if (this.s == null)
        break;
      this.s.setBackgroundResource(2130837711);
      c(this.G, false);
      this.ad.put(Integer.valueOf(paramInt), "");
      break;
      if ((localBoolean == null) || (!localBoolean.booleanValue()))
      {
        if (this.t == null)
          break;
        this.t.setBackgroundResource(2130837747);
        c(this.H, true);
        this.ad.put(Integer.valueOf(paramInt), "D");
        break;
      }
      if (this.t == null)
        break;
      this.t.setBackgroundResource(2130837749);
      c(this.H, false);
      this.ad.put(Integer.valueOf(paramInt), "");
      break;
      if ((localBoolean == null) || (!localBoolean.booleanValue()))
      {
        if (this.u == null)
          break;
        this.u.setBackgroundResource(2130837777);
        c(this.I, true);
        this.ad.put(Integer.valueOf(paramInt), "E");
        break;
      }
      if (this.u == null)
        break;
      this.u.setBackgroundResource(2130837779);
      c(this.I, false);
      this.ad.put(Integer.valueOf(paramInt), "");
      break;
      if ((localBoolean == null) || (!localBoolean.booleanValue()))
      {
        if (this.v == null)
          break;
        this.v.setBackgroundResource(2130837815);
        c(this.J, true);
        this.ad.put(Integer.valueOf(paramInt), "F");
        break;
      }
      if (this.v == null)
        break;
      this.v.setBackgroundResource(2130837817);
      c(this.J, false);
      this.ad.put(Integer.valueOf(paramInt), "");
      break;
      this.X.setEnabled(false);
      break label87;
      this.ab.j.put(Integer.valueOf(this.Y), Boolean.valueOf(false));
      break label123;
    }
    while ((this.af != 0) && (this.af != 4));
    if (this.aa)
    {
      o();
      p();
      q();
    }
    label832: Iterator localIterator;
    switch (paramInt)
    {
    default:
      this.aw = true;
      this.ab.j.put(Integer.valueOf(this.Y), Boolean.valueOf(true));
      if (!this.aa)
        break;
      localIterator = this.ad.keySet().iterator();
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
      for (int i1 = 0; ; i1++)
      {
        String str;
        do
        {
          if (!localIterator.hasNext())
          {
            f(i1);
            this.ab.a.put(Integer.valueOf(this.Y), this.ah);
            h.a("插入currentInx=" + this.Y);
            this.ab.a(this.Z, this.ad, this.ah, this.ai, this.Z.getScore());
          }
          switch (this.ab.e)
          {
          default:
            this.aA.sendEmptyMessageDelayed(1, 400L);
            return;
            if (this.q == null)
              break label832;
            this.q.setBackgroundResource(2130837504);
            c(this.w, true);
            this.ad.put(Integer.valueOf(paramInt), "A");
            break label832;
            if (this.r == null)
              break label832;
            this.r.setBackgroundResource(2130837575);
            c(this.F, true);
            this.ad.put(Integer.valueOf(paramInt), "B");
            break label832;
            if (this.s == null)
              break label832;
            this.s.setBackgroundResource(2130837708);
            c(this.G, true);
            this.ad.put(Integer.valueOf(paramInt), "C");
            break label832;
            if (this.t == null)
              break label832;
            this.t.setBackgroundResource(2130837747);
            c(this.H, true);
            this.ad.put(Integer.valueOf(paramInt), "D");
            break label832;
            if (this.u == null)
              break label832;
            this.u.setBackgroundResource(2130837777);
            c(this.I, true);
            this.ad.put(Integer.valueOf(paramInt), "E");
            break label832;
            if (this.v == null)
              break label832;
            this.v.setBackgroundResource(2130837815);
            c(this.J, true);
            this.ad.put(Integer.valueOf(paramInt), "F");
            break label832;
            Integer localInteger = (Integer)localIterator.next();
            str = (String)this.ad.get(localInteger);
          case 3:
          case 16:
          }
        }
        while ((str == null) || (str.equals("")));
      }
      this.aA.sendEmptyMessageDelayed(1, 10L);
      return;
    }
    h.a("插入currentInx=" + this.Y);
    r();
    this.ab.a(this.Z, this.ad, this.ah, this.ai, this.Z.getScore());
  }

  private void f(int paramInt)
  {
    Iterator localIterator;
    if (paramInt == this.ac.size())
    {
      localIterator = this.ad.keySet().iterator();
      if (localIterator.hasNext());
    }
    while (true)
    {
      if (!this.ah)
        break label131;
      this.ai = this.Z.getScore();
      return;
      Integer localInteger = (Integer)localIterator.next();
      String str = (String)this.ad.get(localInteger);
      if ((str == null) || (str.equals("")))
        break;
      if (this.ac.contains(str))
      {
        this.ah = true;
        break;
      }
      this.ah = false;
      continue;
      this.ah = false;
    }
    label131: this.ai = 0.0D;
  }

  private void g(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 0:
      this.q.setBackgroundResource(2130837505);
      a(this.w, false);
      return;
    case 1:
      this.r.setBackgroundResource(2130837576);
      a(this.F, false);
      return;
    case 2:
      this.s.setBackgroundResource(2130837709);
      a(this.G, false);
      return;
    case 3:
      this.t.setBackgroundResource(2130837748);
      a(this.H, false);
      return;
    case 4:
      this.u.setBackgroundResource(2130837778);
      a(this.I, false);
      return;
    case 5:
    }
    this.v.setBackgroundResource(2130837816);
    a(this.J, false);
  }

  private void h(int paramInt)
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
                if (this.q == null)
                  continue;
                this.q.setBackgroundResource(2130837504);
              }
              while (this.w == null);
              a(this.w, true);
              return;
              if (this.r == null)
                continue;
              this.r.setBackgroundResource(2130837575);
            }
            while (this.F == null);
            a(this.F, true);
            return;
            if (this.s == null)
              continue;
            this.s.setBackgroundResource(2130837708);
          }
          while (this.G == null);
          a(this.G, true);
          return;
          if (this.t == null)
            continue;
          this.t.setBackgroundResource(2130837747);
        }
        while (this.H == null);
        a(this.H, true);
        return;
        if (this.u == null)
          continue;
        this.u.setBackgroundResource(2130837777);
      }
      while (this.I == null);
      a(this.I, true);
      return;
      if (this.v == null)
        continue;
      this.v.setBackgroundResource(2130837815);
    }
    while (this.J == null);
    a(this.J, true);
  }

  private void i()
  {
    this.ae = this.Z.getCategory();
    try
    {
      this.af = ((Integer)a.d.get(this.ae)).intValue();
      label31: this.i = ((FlowLayout)this.h.findViewById(2131297021));
      this.ap = ((LinearLayout)this.h.findViewById(2131297022));
      Iterator localIterator2;
      if (this.Z != null)
      {
        Stem localStem = this.Z.getStem();
        if (localStem != null)
        {
          if ((localStem.getText() != null) && (!localStem.getText().equals("")))
          {
            List localList4 = a(this.Z.getStem().getText(), false);
            this.i.setOption(false);
            localIterator2 = localList4.iterator();
            if (localIterator2.hasNext())
              break label405;
          }
          a(localStem);
        }
      }
      k();
      List localList1 = this.Z.getOptions();
      if ((localList1 != null) && (localList1.size() > 0))
      {
        int i3 = localList1.size();
        Options localOptions = (Options)localList1.get(0);
        if ((localOptions.getContent() != null) && (!localOptions.getContent().equals("")))
          switch (i3)
          {
          default:
          case 1:
          case 2:
          case 3:
          case 4:
          case 5:
          case 6:
          }
      }
      List localList2;
      int i2;
      while (true)
      {
        localList2 = this.Z.getOptions();
        if (localList2 != null)
        {
          int i1 = localList2.size();
          i2 = 0;
          if (i1 > 0)
            if (i2 < localList2.size())
              break label615;
        }
        switch (this.af)
        {
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
        return;
        label405: View localView2 = (View)localIterator2.next();
        this.i.addView(localView2);
        break;
        this.k.setVisibility(0);
        continue;
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        continue;
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        continue;
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        this.n.setVisibility(0);
        continue;
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        this.n.setVisibility(0);
        this.o.setVisibility(0);
        continue;
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        this.n.setVisibility(0);
        this.o.setVisibility(0);
        this.p.setVisibility(0);
      }
      label615: String str = ((Options)localList2.get(i2)).getContent();
      Iterator localIterator1;
      if ((str != null) && (!str.equals("")))
      {
        List localList3 = a(str, true);
        h.a("questionDetailFragment optionViews size=" + localList3.size());
        localIterator1 = localList3.iterator();
      }
      while (true)
      {
        if (!localIterator1.hasNext())
        {
          i2++;
          break;
        }
        View localView1 = (View)localIterator1.next();
        switch (i2)
        {
        default:
          break;
        case 0:
          this.w.setOption(true);
          this.w.addView(localView1);
          break;
        case 1:
          this.F.setOption(true);
          this.F.addView(localView1);
          break;
        case 2:
          this.G.setOption(true);
          this.G.addView(localView1);
          break;
        case 3:
          this.H.setOption(true);
          this.H.addView(localView1);
          break;
        case 4:
          this.I.setOption(true);
          this.I.addView(localView1);
          break;
        case 5:
          this.J.setOption(true);
          this.J.addView(localView1);
        }
      }
    }
    catch (Exception localException)
    {
      break label31;
    }
  }

  private void i(int paramInt)
  {
    try
    {
      this.au.setVisibility(0);
      List localList = this.Z.getCorrectAnswer();
      int[] arrayOfInt;
      int i1;
      if (localList != null)
      {
        arrayOfInt = new int[] { 2130838091, 2130838093, 2130838095, 2130838097, 2130838099, 2130838101, 2130838103, 2130838105, 2130838107, 2130838084, 2130838086, 2130838088, 2130838090 };
        if (localList != null)
          i1 = localList.size();
      }
      for (int i2 = 0; ; i2++)
      {
        if (i2 >= i1)
        {
          this.av.setVisibility(0);
          return;
        }
        if (i2 != paramInt)
          continue;
        FlowLayout localFlowLayout = (FlowLayout)View.inflate(getActivity(), 2130903275, null);
        localFlowLayout.setOption(true);
        ImageView localImageView = (ImageView)View.inflate(getActivity(), 2130903278, null);
        localImageView.setBackgroundResource(arrayOfInt[i2]);
        localFlowLayout.addView(localImageView);
        Iterator localIterator = a((String)localList.get(i2), true).iterator();
        while (true)
          if (!localIterator.hasNext())
          {
            this.av.addView(localFlowLayout);
          }
          else
          {
            View localView = (View)localIterator.next();
            if ((localView instanceof TextView))
            {
              TextView localTextView = (TextView)localView;
              localTextView.setTextColor(getResources().getColor(2131034205));
              localFlowLayout.addView(localTextView);
              continue;
            }
            localFlowLayout.addView(localView);
            continue;
            return;
          }
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
      this.aq = View.inflate(getActivity(), 2130903277, null);
      this.V.addView(this.aq);
      this.V.setVisibility(0);
      this.ar = ((TextView)this.aq.findViewById(2131297548));
      this.ar.setVisibility(8);
      this.au = ((LinearLayout)this.aq.findViewById(2131297550));
      this.au.setVisibility(8);
      this.av = ((LinearLayout)this.aq.findViewById(2131297552));
      this.av.setVisibility(8);
      int[] arrayOfInt = { 2130838091, 2130838093, 2130838095, 2130838097, 2130838099, 2130838101, 2130838103, 2130838105, 2130838107, 2130838084, 2130838086, 2130838088, 2130838090 };
      LinearLayout localLinearLayout = (LinearLayout)this.aq.findViewById(2131297549);
      localLinearLayout.setVisibility(0);
      this.as = new EditText[2 * this.W];
      this.at = new ImageView[2 * this.W];
      int i1 = 0;
      if (i1 >= this.W);
      for (int i2 = 0; ; i2++)
      {
        if (i2 >= this.as.length)
        {
          return;
          View localView = View.inflate(getActivity(), 2130903276, null);
          this.as[i1] = ((EditText)localView.findViewById(2131297544));
          this.at[i1] = ((ImageView)localView.findViewById(2131297546));
          Drawable localDrawable = getResources().getDrawable(arrayOfInt[i1]);
          this.as[i1].setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
          localLinearLayout.addView(localView);
          i1++;
          break;
        }
        EditText localEditText = this.as[i2];
        if (localEditText == null)
          continue;
        localEditText.addTextChangedListener(new a(i2));
      }
    }
    catch (Exception localException)
    {
    }
  }

  private void k()
  {
    this.k = ((LinearLayout)this.h.findViewById(2131297026));
    this.q = ((ImageView)this.h.findViewById(2131297027));
    this.w = ((FlowLayout)this.h.findViewById(2131297028));
    this.k.setOnClickListener(this);
    this.l = ((LinearLayout)this.h.findViewById(2131297029));
    this.r = ((ImageView)this.h.findViewById(2131297030));
    this.F = ((FlowLayout)this.h.findViewById(2131297031));
    this.l.setOnClickListener(this);
    this.m = ((LinearLayout)this.h.findViewById(2131297032));
    this.s = ((ImageView)this.h.findViewById(2131297033));
    this.G = ((FlowLayout)this.h.findViewById(2131297034));
    this.m.setOnClickListener(this);
    this.n = ((LinearLayout)this.h.findViewById(2131297035));
    this.t = ((ImageView)this.h.findViewById(2131297036));
    this.H = ((FlowLayout)this.h.findViewById(2131297037));
    this.n.setOnClickListener(this);
    this.o = ((LinearLayout)this.h.findViewById(2131297038));
    this.u = ((ImageView)this.h.findViewById(2131297039));
    this.I = ((FlowLayout)this.h.findViewById(2131297040));
    this.o.setOnClickListener(this);
    this.p = ((LinearLayout)this.h.findViewById(2131297041));
    this.v = ((ImageView)this.h.findViewById(2131297042));
    this.J = ((FlowLayout)this.h.findViewById(2131297043));
    this.p.setOnClickListener(this);
  }

  private boolean l()
  {
    switch (this.af)
    {
    default:
      return true & this.K.isEnabled();
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
      return true & x();
    case 5:
    }
    return true & y();
  }

  private boolean m()
  {
    Iterator localIterator = this.ad.keySet().iterator();
    String str;
    do
    {
      if (!localIterator.hasNext())
        return false;
      Integer localInteger = (Integer)localIterator.next();
      str = (String)this.ad.get(localInteger);
    }
    while ((str == null) || (str.equals("")));
    return true;
  }

  private void n()
  {
    Iterator localIterator = this.ad.keySet().iterator();
    for (int i1 = 0; ; i1++)
    {
      String str;
      do
      {
        if (!localIterator.hasNext())
        {
          f(i1);
          this.ab.a.put(Integer.valueOf(this.Y), this.ah);
          this.ab.a(this.Z, this.ad, this.ah, this.ai, this.Z.getScore());
          h.a("插入currentInx=" + this.Y);
          return;
        }
        Integer localInteger = (Integer)localIterator.next();
        str = (String)this.ad.get(localInteger);
      }
      while ((str == null) || (str.equals("")));
    }
  }

  private void o()
  {
    if (this.q != null)
      this.q.setBackgroundResource(2130837507);
    if (this.r != null)
      this.r.setBackgroundResource(2130837578);
    if (this.s != null)
      this.s.setBackgroundResource(2130837711);
    if (this.t != null)
      this.t.setBackgroundResource(2130837749);
    if (this.u != null)
      this.u.setBackgroundResource(2130837779);
    if (this.v != null)
      this.v.setBackgroundResource(2130837817);
  }

  private void p()
  {
    if (this.w != null)
      c(this.w, false);
    if (this.F != null)
      c(this.F, false);
    if (this.G != null)
      c(this.G, false);
    if (this.H != null)
      c(this.H, false);
    if (this.I != null)
      c(this.I, false);
    if (this.J != null)
      c(this.J, false);
  }

  private void q()
  {
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= this.ad.size())
        return;
      this.ad.put(Integer.valueOf(i1), "");
    }
  }

  private void r()
  {
    Iterator localIterator1 = this.ac.iterator();
    label10: Iterator localIterator2;
    int i1;
    if (!localIterator1.hasNext())
    {
      localIterator2 = this.ad.keySet().iterator();
      i1 = 0;
    }
    while (true)
    {
      if (!localIterator2.hasNext())
      {
        f(i1);
        this.ab.a.put(Integer.valueOf(this.Y), this.ah);
        s();
        d();
        if (!this.ah)
          break label380;
      }
      switch (this.ab.e)
      {
      default:
        this.aA.sendEmptyMessageDelayed(1, 400L);
        return;
        String str1 = (String)localIterator1.next();
        if ((str1 == null) || (str1.equals("")) || (str1.equals("ⅹ")) || (str1.equals("√")))
          break label10;
        if (str1.equals("A"))
        {
          h(0);
          break label10;
        }
        if (str1.equals("B"))
        {
          h(1);
          break label10;
        }
        if (str1.equals("C"))
        {
          h(2);
          break label10;
        }
        if (str1.equals("D"))
        {
          h(3);
          break label10;
        }
        if (str1.equals("E"))
        {
          h(4);
          break label10;
        }
        if (!str1.equals("F"))
          break label10;
        h(5);
        break label10;
        Integer localInteger = (Integer)localIterator2.next();
        String str2 = (String)this.ad.get(localInteger);
        if ((str2 == null) || (str2.equals("")))
          continue;
        i1++;
        if (this.ac.contains(str2))
          continue;
        g(localInteger.intValue());
      case 3:
      case 16:
      }
    }
    this.aA.sendEmptyMessageDelayed(1, 10L);
    return;
    label380: h.a("错误留在当页");
  }

  private void s()
  {
    w();
    u();
    t();
  }

  private void t()
  {
    this.aM.setOnClickListener(this);
    this.aL.setOnClickListener(this);
    this.aK.setOnClickListener(this);
  }

  private void u()
  {
    try
    {
      MyErrorRate localMyErrorRate;
      int i1;
      if (this.ah)
        switch (this.af)
        {
        default:
          localMyErrorRate = this.Z.getMyErrorRate();
          if (localMyErrorRate == null)
            break;
          i1 = localMyErrorRate.getErrorNum();
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
      for (int i2 = localMyErrorRate.getTotalNum(); ; i2 = 0)
      {
        String str1;
        label169: int i3;
        int i4;
        if (this.ah)
        {
          str1 = i1 + "/" + (i2 + 1);
          ErrorRate localErrorRate = this.Z.getErrorRate();
          if (localErrorRate == null)
            break label1386;
          i3 = localErrorRate.getErrorNum();
          i4 = localErrorRate.getTotalNum();
        }
        while (true)
        {
          double d1;
          label217: Iterator localIterator3;
          label429: label477: Iterator localIterator2;
          label548: label618: label628: String str6;
          if (this.ah)
          {
            d1 = 1.0D * i3 / (i4 + 1);
            h.a("tempErrRate-----" + d1);
            h.a("tempMyErrRate-----" + str1);
            double d2 = d1 * 100.0D;
            String str2 = new DecimalFormat("0.0").format(d2);
            this.aP.setText(str2 + "%");
            this.aQ.setText(str1);
            KpointDetail localKpointDetail = this.Z.getKpointDetail();
            this.aF.setVisibility(8);
            if (localKpointDetail == null)
              break label1157;
            String str3 = localKpointDetail.getExplainText();
            if ((this.aV == null) || (this.aV.getChildCount() <= 0))
            {
              List localList1 = b("  " + str3);
              if ((localList1 != null) && (localList1.size() > 0))
              {
                localIterator3 = localList1.iterator();
                if (localIterator3.hasNext())
                  break label944;
                this.aV.setVisibility(0);
              }
            }
            String str4 = localKpointDetail.getGraspRequire();
            if (str4 == null)
              break label968;
            this.aE.setText(str4);
            this.aE.setVisibility(8);
            Kpoint localKpoint = localKpointDetail.getKpoint();
            if (localKpoint != null)
            {
              String str5 = localKpoint.getName();
              this.aD.setText(str5);
            }
            switch ((int)localKpointDetail.getGraspLevel())
            {
            default:
              Explain localExplain = this.Z.getExplain();
              if (localExplain != null)
              {
                List localList2 = localExplain.getFigure();
                if ((this.bb == null) || (this.bb.getChildCount() <= 0))
                {
                  if ((localList2 == null) || (localList2.size() <= 0))
                    break label1262;
                  this.bb.setVisibility(0);
                  localIterator2 = localList2.iterator();
                  if (localIterator2.hasNext())
                    break;
                }
                else
                {
                  str6 = localExplain.getText();
                  if ((this.aU == null) || (this.aU.getChildCount() <= 0))
                  {
                    if ((str6 != null) && (!str6.equals("")))
                      break label1274;
                    this.aU.setVisibility(8);
                    this.aI.setVisibility(8);
                    this.aS.setVisibility(8);
                  }
                  label695: this.aJ.setVisibility(8);
                  this.aR.setVisibility(8);
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
            Message localMessage = this.aA.obtainMessage();
            localMessage.what = 9;
            localMessage.obj = this.Z;
            this.aA.sendMessage(localMessage);
            v();
            return;
            this.aB.setText("恭喜你~答对啦");
            this.aH.setBackgroundResource(2130837989);
            break;
            this.aB.setText("其实吧~这道题是酱紫滴");
            this.aH.setBackgroundResource(2130837883);
            break;
            HashMap localHashMap = this.ab.j;
            if ((localHashMap == null) || (localHashMap.get(Integer.valueOf(this.Y)) == null))
            {
              this.aB.setText("其实吧~这道题是酱紫滴");
              this.aH.setBackgroundResource(2130837883);
            }
            while (true)
            {
              h.a("isHaveDone ?=" + localHashMap);
              break;
              this.aB.setText(" 呜呜呜~答错了!");
              this.aH.setBackgroundResource(2130837751);
            }
            str1 = i1 + 1 + "/" + (i2 + 1);
            break label169;
            d1 = (1.0D + 1.0D * i3) / (i4 + 1);
            break label217;
            label944: View localView2 = (View)localIterator3.next();
            this.aV.addView(localView2);
            break label429;
            label968: this.aE.setVisibility(0);
            break label477;
            this.aW.setBackgroundResource(2130837506);
            break label548;
            this.aW.setBackgroundResource(2130837710);
            break label548;
            this.aW.setBackgroundResource(2130837710);
            this.aX.setBackgroundResource(2130837710);
            break label548;
            this.aW.setBackgroundResource(2130837710);
            this.aX.setBackgroundResource(2130837710);
            this.aY.setBackgroundResource(2130837710);
            break label548;
            this.aW.setBackgroundResource(2130837710);
            this.aX.setBackgroundResource(2130837710);
            this.aY.setBackgroundResource(2130837710);
            this.aZ.setBackgroundResource(2130837710);
            break label548;
            this.aW.setBackgroundResource(2130837710);
            this.aX.setBackgroundResource(2130837710);
            this.aY.setBackgroundResource(2130837710);
            this.aZ.setBackgroundResource(2130837710);
            this.ba.setBackgroundResource(2130837710);
            break label548;
            label1157: this.bd.setVisibility(8);
            this.aT.setVisibility(8);
            this.aV.setVisibility(8);
            this.bc.setVisibility(8);
            break label548;
            String str7 = (String)localIterator2.next();
            ImageView localImageView = (ImageView)View.inflate(getActivity(), 2130903182, null);
            this.bb.addView(localImageView);
            this.D.a(str7, localImageView);
            localImageView.setOnClickListener(new t(this, str7));
            break label618;
            label1262: this.bb.setVisibility(8);
            break label628;
            label1274: List localList3 = b("  " + str6);
            if ((localList3 == null) || (localList3.size() <= 0))
              break label695;
            Iterator localIterator1 = localList3.iterator();
            while (localIterator1.hasNext())
            {
              View localView1 = (View)localIterator1.next();
              this.aU.addView(localView1);
            }
            break label695;
            this.aJ.setVisibility(8);
            this.aI.setVisibility(8);
            this.aS.setVisibility(8);
          }
          label1386: i4 = 0;
          i3 = 0;
        }
        i1 = 0;
      }
    }
    catch (Exception localException)
    {
    }
  }

  private void v()
  {
    switch (((QuestionDetailActivity)getActivity()).r)
    {
    default:
      return;
    case 100:
    case 101:
    }
    this.L.setVisibility(8);
    this.M.setVisibility(8);
    this.N.setVisibility(8);
    this.an.setVisibility(8);
  }

  private void w()
  {
    this.bd = ((RelativeLayout)this.h.findViewById(2131297057));
    this.bc = ((ImageView)this.h.findViewById(2131297055));
    this.aW = ((ImageView)this.h.findViewById(2131297067));
    this.aX = ((ImageView)this.h.findViewById(2131297068));
    this.aY = ((ImageView)this.h.findViewById(2131297069));
    this.aZ = ((ImageView)this.h.findViewById(2131297070));
    this.ba = ((ImageView)this.h.findViewById(2131297071));
    this.aU = ((FlowLayout)this.h.findViewById(2131297052));
    this.aU.setOption(true);
    this.aV = ((FlowLayout)this.h.findViewById(2131297060));
    this.aV.setOption(true);
    this.aI = ((TextView)this.h.findViewById(2131297051));
    this.aT = ((TextView)this.h.findViewById(2131297056));
    this.aS = ((ImageView)this.h.findViewById(2131297050));
    this.aQ = ((TextView)this.h.findViewById(2131297066));
    this.aR = ((LinearLayout)this.h.findViewById(2131297062));
    this.bb = ((LinearLayout)this.h.findViewById(2131297053));
    this.aP = ((TextView)this.h.findViewById(2131297065));
    this.aB = ((TextView)this.h.findViewById(2131297047));
    this.aH = ((ImageView)this.h.findViewById(2131297048));
    this.aJ = ((TextView)this.h.findViewById(2131297054));
    this.aD = ((TextView)this.h.findViewById(2131297058));
    this.aE = ((TextView)this.h.findViewById(2131297059));
    this.aF = ((TextView)this.h.findViewById(2131297061));
    this.aG = ((TextView)this.h.findViewById(2131297072));
    this.aK = ((Button)this.h.findViewById(2131297074));
    this.aK.setOnClickListener(this);
    this.aM = ((ImageButton)this.h.findViewById(2131297075));
    this.aN = ((EditText)this.h.findViewById(2131296934));
    this.aL = ((Button)this.h.findViewById(2131297076));
    this.aL.setOnClickListener(this);
    this.aO = ((LinearLayout)this.h.findViewById(2131297044));
    this.T.setVisibility(0);
    this.X.setVisibility(8);
    this.Q.setVisibility(0);
    this.R.setVisibility(0);
  }

  private boolean x()
  {
    boolean bool = true;
    if (this.k != null)
      bool &= this.k.isEnabled();
    if (this.l != null)
      bool &= this.l.isEnabled();
    if (this.m != null)
      bool &= this.m.isEnabled();
    if (this.n != null)
      bool &= this.n.isEnabled();
    if (this.o != null)
      bool &= this.o.isEnabled();
    if (this.p != null)
      bool &= this.p.isEnabled();
    return bool;
  }

  private boolean y()
  {
    boolean bool = true;
    if (this.be != null)
      bool &= this.be.isEnabled();
    if (this.bf != null)
      bool &= this.bf.isEnabled();
    if (this.bg != null)
      bool &= this.bg.isEnabled();
    if (this.bh != null)
      bool &= this.bh.isEnabled();
    if (this.bi != null)
      bool &= this.bi.isEnabled();
    if (this.bj != null)
      bool &= this.bj.isEnabled();
    return bool;
  }

  private void z()
  {
    Iterator localIterator = this.ad.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Integer localInteger = (Integer)localIterator.next();
      String str = (String)this.ad.get(localInteger);
      if ((str == null) || (str.equals("")))
        continue;
      this.ab.j.put(Integer.valueOf(this.ab.b), Boolean.valueOf(true));
    }
  }

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    try
    {
      this.Z = ((Exercises)getArguments().getSerializable("exercises"));
      label17: if (this.Z == null)
        this.h = paramLayoutInflater.inflate(2130903147, null);
      while (true)
      {
        return this.h;
        this.h = paramLayoutInflater.inflate(2130903164, null);
        i();
      }
    }
    catch (Exception localException)
    {
      break label17;
    }
  }

  public void a()
  {
    label170: Iterator localIterator;
    if (this.Z != null)
    {
      this.bk = ((InputMethodManager)getActivity().getSystemService("input_method"));
      this.ab = ((QuestionDetailActivity)getActivity());
      this.ag = this.ab.c;
      this.aa = this.ab.d;
      if (!this.E.f())
        break label426;
      this.ao.setVisibility(0);
      this.E.c(false);
      KpointDetail localKpointDetail = this.Z.getKpointDetail();
      if (localKpointDetail == null)
        break label438;
      Kpoint localKpoint = localKpointDetail.getKpoint();
      if (localKpoint != null)
      {
        String str3 = localKpoint.getSn();
        String str4 = localKpoint.getName();
        if ((str3 != null) && (!str3.equals("")))
          this.L.setText(str3);
        if ((str4 != null) && (!str4.equals("")))
          this.M.setText(str4);
      }
      String str1 = this.Z.getExerciseNo();
      int i1 = this.Z.getTotalNum();
      this.P.setText(str1 + "题/" + i1 + "题");
      this.O.setText(this.ae);
      List localList = this.Z.getLabels();
      if ((localList != null) && (localList.size() > 0))
      {
        localIterator = localList.iterator();
        label267: if (localIterator.hasNext())
          break label450;
      }
      this.ac = this.Z.getCorrectAnswer();
      this.ad = new HashMap();
      if (!this.aa)
        break label636;
      this.L.setVisibility(8);
      this.M.setVisibility(8);
      h.a("currentIndex-----" + this.Y);
      this.N.setVisibility(8);
      this.an.setVisibility(8);
      switch (this.af)
      {
      default:
        this.K.setVisibility(0);
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
      this.X.setVisibility(8);
      return;
      label426: this.ao.setVisibility(8);
      break;
      label438: this.S.setVisibility(8);
      break label170;
      label450: String str2 = (String)localIterator.next();
      if (str2.contains("真题"))
      {
        this.ak.setText(str2);
        this.ak.setBackgroundResource(2130838231);
        this.ak.setVisibility(0);
        break label267;
      }
      if (str2.contains("模拟"))
      {
        this.al.setText("模拟");
        this.al.setBackgroundResource(2130837936);
        this.al.setVisibility(0);
        break label267;
      }
      if (str2.contains("练习"))
      {
        this.am.setText("练习");
        this.am.setBackgroundResource(2130837900);
        this.am.setVisibility(0);
        break label267;
      }
      if (!str2.contains("预测"))
        break label267;
      this.al.setText("预测");
      this.al.setBackgroundResource(2130838225);
      this.al.setVisibility(0);
      break label267;
      j();
    }
    label636: if (this.Z != null)
      switch (this.af)
      {
      default:
        this.X.setVisibility(0);
        this.K.setVisibility(0);
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
    while (this.ab.m == null)
    {
      this.ab.m = new HashMap();
      return;
      this.X.setVisibility(8);
      continue;
      this.X.setEnabled(false);
      this.X.setVisibility(0);
      continue;
      this.X.setEnabled(false);
      this.X.setVisibility(0);
      continue;
      this.X.setEnabled(false);
      this.X.setVisibility(0);
      continue;
      this.X.setVisibility(8);
      continue;
      this.V.setVisibility(0);
      j();
      this.X.setVisibility(0);
    }
  }

  public void a(int paramInt)
  {
    h.a("onScroll", Integer.valueOf(paramInt));
    if (paramInt > 30)
      this.aA.sendEmptyMessage(5);
  }

  public void a(View paramView)
  {
    if (this.Z != null)
    {
      this.al = ((TextView)paramView.findViewById(2131297019));
      this.ao = ((ImageButton)paramView.findViewById(2131297077));
      this.ao.setOnTouchListener(new r(this));
      this.ak = ((TextView)paramView.findViewById(2131297018));
      this.am = ((TextView)paramView.findViewById(2131297020));
      this.aj = ((MyScrollView)paramView.findViewById(2131296258));
      this.K = ((EditText)paramView.findViewById(2131297023));
      this.L = ((TextView)paramView.findViewById(2131297012));
      this.M = ((TextView)paramView.findViewById(2131297013));
      this.N = ((LinearLayout)paramView.findViewById(2131297017));
      this.O = ((TextView)paramView.findViewById(2131297014));
      this.P = ((TextView)paramView.findViewById(2131297015));
      this.Q = ((LinearLayout)paramView.findViewById(2131297049));
      this.R = ((LinearLayout)paramView.findViewById(2131296933));
      this.S = ((LinearLayout)paramView.findViewById(2131297011));
      this.X = ((Button)paramView.findViewById(2131297045));
      this.X.setOnClickListener(this);
      this.T = ((LinearLayout)paramView.findViewById(2131297046));
      this.V = ((LinearLayout)paramView.findViewById(2131297025));
      this.an = ((LinearLayout)paramView.findViewById(2131297016));
      this.T.setVisibility(8);
      this.U = ((MyListView)paramView.findViewById(2131297073));
    }
  }

  public void a(Exercises paramExercises, int paramInt)
  {
    if (paramExercises == null)
      return;
    this.Z = paramExercises;
    this.Y = paramInt;
  }

  public void b(int paramInt)
  {
    if (this.Z == null)
      return;
    Iterator localIterator;
    if (this.aa)
      localIterator = this.ad.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        h.a("right=?" + (String)this.ab.a.get(Integer.valueOf(paramInt)));
        h.a("currentindex=" + paramInt);
        h.a("activity.resBrush.size())==" + this.ab.l.size());
        h.a("activity.resBrush.size())==" + this.ab.l.size());
        return;
      }
      Integer localInteger = (Integer)localIterator.next();
      h.a("opEdit.get(" + localInteger + ")=" + (String)this.ad.get(localInteger));
    }
  }

  public void b(Exercises paramExercises, int paramInt)
  {
    if (paramExercises == null);
    while (true)
    {
      return;
      try
      {
        QuestionDetailActivity localQuestionDetailActivity = (QuestionDetailActivity)getActivity();
        this.aa = localQuestionDetailActivity.d;
        if (this.aa)
          continue;
        if (localQuestionDetailActivity.p)
          switch (this.af)
          {
          default:
            if ((this.K == null) || (!this.K.isEnabled()))
              continue;
            s();
            this.K.setEnabled(false);
            return;
          case 0:
          case 4:
            if (!x())
              continue;
            Iterator localIterator4 = this.ac.iterator();
            Iterator localIterator5;
            if (!localIterator4.hasNext())
              localIterator5 = this.ad.keySet().iterator();
            while (true)
            {
              if (!localIterator5.hasNext())
              {
                s();
                d();
                return;
                String str4 = (String)localIterator4.next();
                if ((str4 == null) || (str4.equals("")) || (str4.equals("ⅹ")) || (str4.equals("√")))
                  break;
                if (str4.equals("A"))
                {
                  h(0);
                  break;
                }
                if (str4.equals("B"))
                {
                  h(1);
                  break;
                }
                if (str4.equals("C"))
                {
                  h(2);
                  break;
                }
                if (str4.equals("D"))
                {
                  h(3);
                  break;
                }
                if (str4.equals("E"))
                {
                  h(4);
                  break;
                }
                if (!str4.equals("F"))
                  break;
                h(5);
                break;
              }
              Integer localInteger3 = (Integer)localIterator5.next();
              String str5 = (String)this.ad.get(localInteger3);
              if ((str5 == null) || (str5.equals("")) || (this.ac.contains(str5)))
                continue;
              g(localInteger3.intValue());
            }
          case 1:
          case 2:
          case 3:
            if (!x())
              continue;
            Iterator localIterator2 = this.ac.iterator();
            Iterator localIterator3;
            if (!localIterator2.hasNext())
              localIterator3 = this.ad.keySet().iterator();
            while (true)
            {
              if (!localIterator3.hasNext())
              {
                s();
                d();
                return;
                String str2 = (String)localIterator2.next();
                if ((str2 == null) || (str2.equals("")) || (str2.equals("ⅹ")) || (str2.equals("√")))
                  break;
                if (str2.equals("A"))
                {
                  h(0);
                  break;
                }
                if (str2.equals("B"))
                {
                  h(1);
                  break;
                }
                if (str2.equals("C"))
                {
                  h(2);
                  break;
                }
                if (str2.equals("D"))
                {
                  h(3);
                  break;
                }
                if (str2.equals("E"))
                {
                  h(4);
                  break;
                }
                if (!str2.equals("F"))
                  break;
                h(5);
                break;
              }
              Integer localInteger2 = (Integer)localIterator3.next();
              String str3 = (String)this.ad.get(localInteger2);
              if ((str3 == null) || (str3.equals("")) || (this.ac.contains(str3)))
                continue;
              g(localInteger2.intValue());
            }
          case 5:
            B();
            return;
          }
        Boolean localBoolean = (Boolean)localQuestionDetailActivity.j.get(Integer.valueOf(paramInt));
        if ((localBoolean != null) && (localBoolean.booleanValue()))
          continue;
        this.Q.setVisibility(8);
        this.T.setVisibility(8);
        this.R.setVisibility(8);
        switch (this.af)
        {
        default:
          this.K.setEnabled(true);
          this.X.setVisibility(0);
          return;
        case 0:
        case 4:
          e();
          E();
          this.X.setVisibility(8);
          return;
        case 1:
        case 2:
        case 3:
          e();
          E();
          Iterator localIterator1;
          if ((this.ad != null) && (this.ad.size() > 0))
            localIterator1 = this.ad.keySet().iterator();
          while (true)
          {
            if (!localIterator1.hasNext())
            {
              this.X.setVisibility(0);
              return;
            }
            Integer localInteger1 = (Integer)localIterator1.next();
            String str1 = (String)this.ad.get(localInteger1);
            if ((str1 == null) || (str1.equals("")))
              continue;
            a(localInteger1);
          }
        case 5:
        }
        D();
        return;
      }
      catch (Exception localException)
      {
      }
    }
  }

  public void c()
  {
    if (this.Z != null)
    {
      this.aj.setOnScrollListener(this);
      this.ao.setOnClickListener(this);
      this.K.addTextChangedListener(new s(this));
    }
  }

  public void d()
  {
    if (this.k != null)
      this.k.setEnabled(false);
    if (this.l != null)
      this.l.setEnabled(false);
    if (this.m != null)
      this.m.setEnabled(false);
    if (this.n != null)
      this.n.setEnabled(false);
    if (this.o != null)
      this.o.setEnabled(false);
    if (this.p != null)
      this.p.setEnabled(false);
  }

  public void e()
  {
    if (this.k != null)
      this.k.setEnabled(true);
    if (this.l != null)
      this.l.setEnabled(true);
    if (this.m != null)
      this.m.setEnabled(true);
    if (this.n != null)
      this.n.setEnabled(true);
    if (this.o != null)
      this.o.setEnabled(true);
    if (this.p != null)
      this.p.setEnabled(true);
  }

  public void f()
  {
    int i1 = 0;
    if (this.aa)
      switch (this.af)
      {
      default:
      case 0:
      case 4:
      case 5:
      case 1:
      case 2:
      case 3:
      }
    do
    {
      this.ab.j.put(Integer.valueOf(this.ab.b), Boolean.valueOf(true));
      do
      {
        do
          return;
        while (this.ad.size() <= 0);
        z();
        Iterator localIterator3 = this.ad.keySet().iterator();
        while (true)
        {
          if (!localIterator3.hasNext())
          {
            f(i1);
            return;
          }
          Integer localInteger2 = (Integer)localIterator3.next();
          String str3 = (String)this.ad.get(localInteger2);
          if ((str3 == null) || (str3.equals("")))
            continue;
          i1++;
        }
        switch (this.af)
        {
        case 0:
        case 4:
        case 5:
        default:
        case 1:
        case 2:
        case 3:
        }
      }
      while (!this.K.isEnabled());
      this.ab.j.put(Integer.valueOf(this.ab.b), Boolean.valueOf(true));
      this.K.setEnabled(false);
      s();
      return;
    }
    while ((!x()) || (this.ad.size() <= 0));
    z();
    Iterator localIterator1 = this.ac.iterator();
    Iterator localIterator2;
    int i2;
    if (!localIterator1.hasNext())
    {
      localIterator2 = this.ad.keySet().iterator();
      i2 = 0;
    }
    while (true)
    {
      if (!localIterator2.hasNext())
      {
        f(i2);
        s();
        d();
        return;
        String str1 = (String)localIterator1.next();
        if ((str1 == null) || (str1.equals("")) || (str1.equals("ⅹ")) || (str1.equals("√")))
          break;
        if (str1.equals("A"))
        {
          h(0);
          break;
        }
        if (str1.equals("B"))
        {
          h(1);
          break;
        }
        if (str1.equals("C"))
        {
          h(2);
          break;
        }
        if (str1.equals("D"))
        {
          h(3);
          break;
        }
        if (str1.equals("E"))
        {
          h(4);
          break;
        }
        if (!str1.equals("F"))
          break;
        h(5);
        break;
      }
      Integer localInteger1 = (Integer)localIterator2.next();
      String str2 = (String)this.ad.get(localInteger1);
      if ((str2 == null) || (str2.equals("")))
        continue;
      i2++;
      if (this.ac.contains(str2))
        continue;
      g(localInteger1.intValue());
    }
  }

  public void h()
  {
    if (this.Z == null);
    while (true)
    {
      return;
      h.a("pushAll");
      h.a("activity.resBrush.size()=" + this.ab.l.size());
      h.a("currentIndex=" + this.Y);
      h.a("right?=" + (String)this.ab.a.get(Integer.valueOf(this.Y)));
      Iterator localIterator = this.ad.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        h.a("opEdit.get(" + localInteger + ")" + (String)this.ad.get(localInteger));
      }
    }
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }

  public void onClick(View paramView)
  {
    try
    {
      switch (paramView.getId())
      {
      case 2131297077:
        H();
        return;
      case 2131297026:
        c(0);
        return;
      case 2131297029:
        c(1);
        return;
      case 2131297032:
        c(2);
        return;
      case 2131297035:
        c(3);
        return;
      case 2131297038:
        c(4);
        return;
      case 2131297041:
        c(5);
        return;
      case 2131297075:
        G();
        return;
      case 2131297076:
        switch (this.ab.e)
        {
        default:
        case 9:
        case 12:
        case 888:
        }
        while (true)
        {
          F();
          return;
          g.b(this.y, "brush_c_publish");
          continue;
          g.b(this.y, "brush_i_publish");
        }
      case 2131297074:
        switch (this.ab.e)
        {
        default:
        case 9:
        case 12:
        case 888:
        }
        while (true)
        {
          g.b(this.y, "brush_i_more_comment");
          g.b(this.y, "brush_c_more_comment");
          Bundle localBundle = new Bundle();
          localBundle.putString("exerciseId", this.Z.getExerciseId());
          localBundle.putString("subjectId", this.ag);
          a(QuestionMoreComentActivity.class, 2130968591, 2130968589, false, localBundle);
          return;
          g.b(this.y, "brush_c_more_comment");
          continue;
          g.b(this.y, "brush_i_more_comment");
        }
      case 2131297045:
        A();
      }
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
      case 9:
      default:
      case 4:
      case 10:
      }
    }
    while (true)
    {
      return;
      this.bl = ((PublishCommentBean)localGson.fromJson(paramString1, PublishCommentBean.class));
      if (this.bl != null)
      {
        if ("OK".equals(this.bl.getStatus()))
        {
          this.aA.sendEmptyMessageDelayed(6, 400L);
          return;
        }
        this.aA.sendEmptyMessageDelayed(8, 400L);
        return;
      }
      h.a("发布评论解析异常");
      return;
      try
      {
        this.bm = ((BrushExcerciseBean)localGson.fromJson(paramString1, BrushExcerciseBean.class));
        if (this.bm == null)
          break;
        List localList = this.bm.getExercises();
        if ((localList == null) || (localList.size() <= 0))
          continue;
        Exercises localExercises = (Exercises)localList.get(0);
        this.Z = localExercises;
        Message localMessage = this.aA.obtainMessage();
        localMessage.what = 9;
        localMessage.obj = localExercises;
        this.aA.sendMessage(localMessage);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        h.a("刷题主界面数据实体解析异常:" + localException.getMessage());
        return;
      }
    }
    h.a("刷题主界面数据解析实体bean为null");
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
      int i = 0;
      String str1 = paramCharSequence.toString();
      if ((str1 == null) || (str1.equals("")))
        QuestionDetailFragment.p(QuestionDetailFragment.this).put(Integer.valueOf(this.b), "");
      List localList;
      int k;
      int m;
      label124: int i3;
      label134: label141: int i1;
      int n;
      while (true)
      {
        if (QuestionDetailFragment.q(QuestionDetailFragment.this))
        {
          localList = QuestionDetailFragment.e(QuestionDetailFragment.this).getCorrectAnswer();
          int j = localList.size();
          k = 0;
          m = paramInt3;
          if (k >= j)
          {
            if (m <= 0)
              break label410;
            QuestionDetailFragment.l(QuestionDetailFragment.this).j.put(Integer.valueOf(QuestionDetailFragment.s(QuestionDetailFragment.this)), Boolean.valueOf(true));
            if (m != j)
              break label539;
            i3 = 0;
            if (i3 < j)
              break label441;
            i1 = 0;
            if (i < j)
              break label550;
            double d = QuestionDetailFragment.e(QuestionDetailFragment.this).getScore();
            QuestionDetailFragment.a(QuestionDetailFragment.this, d * (1.0D * i1 / j));
            QuestionDetailFragment.l(QuestionDetailFragment.this).a.put(Integer.valueOf(QuestionDetailFragment.s(QuestionDetailFragment.this)), QuestionDetailFragment.t(QuestionDetailFragment.this));
            QuestionDetailFragment.l(QuestionDetailFragment.this).a(QuestionDetailFragment.e(QuestionDetailFragment.this), QuestionDetailFragment.p(QuestionDetailFragment.this), QuestionDetailFragment.t(QuestionDetailFragment.this), QuestionDetailFragment.u(QuestionDetailFragment.this), QuestionDetailFragment.e(QuestionDetailFragment.this).getScore());
            h.a("插入currentInx=" + QuestionDetailFragment.s(QuestionDetailFragment.this));
          }
        }
        else
        {
          return;
          QuestionDetailFragment.p(QuestionDetailFragment.this).put(Integer.valueOf(this.b), str1);
          continue;
        }
        String str2 = (String)localList.get(k);
        String str3 = QuestionDetailFragment.r(QuestionDetailFragment.this)[k].getText().toString().trim();
        if ((str3 == null) || (str3.equals("")))
          break label635;
        if (!str2.equals(str3))
          break;
        n = m + 1;
      }
      while (true)
      {
        k++;
        m = n;
        break;
        n = m + 1;
        continue;
        label410: QuestionDetailFragment.l(QuestionDetailFragment.this).j.put(Integer.valueOf(QuestionDetailFragment.s(QuestionDetailFragment.this)), Boolean.valueOf(false));
        break label124;
        label441: String str6 = (String)localList.get(i3);
        String str7 = QuestionDetailFragment.r(QuestionDetailFragment.this)[i3].getText().toString().trim();
        if ((str7 == null) || (str7.equals("")))
        {
          QuestionDetailFragment.b(QuestionDetailFragment.this, false);
          break label141;
        }
        if (str6.equals(str7))
        {
          QuestionDetailFragment.b(QuestionDetailFragment.this, true);
          i3++;
          break label134;
        }
        QuestionDetailFragment.b(QuestionDetailFragment.this, false);
        break label141;
        label539: QuestionDetailFragment.b(QuestionDetailFragment.this, false);
        break label141;
        label550: String str4 = (String)localList.get(i);
        String str5 = QuestionDetailFragment.r(QuestionDetailFragment.this)[i].getText().toString().trim();
        if ((str5 != null) && (!str5.equals("")) && (str4.equals(str5)));
        for (int i2 = i1 + 1; ; i2 = i1)
        {
          i++;
          i1 = i2;
          break;
        }
        label635: n = m;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.QuestionDetailFragment
 * JD-Core Version:    0.6.0
 */