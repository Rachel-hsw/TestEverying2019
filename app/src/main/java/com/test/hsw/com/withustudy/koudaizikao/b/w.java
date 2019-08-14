package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.http.e;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Post;
import com.withustudy.koudaizikao.entity.PostReply;
import java.util.List;

public class w extends BaseAdapter
{
  private static final int f = 0;
  private static final int g = 1;
  private Context a;
  private List<PostReply> b;
  private Post c;
  private a d;
  private Handler e;

  public w(Context paramContext, Post paramPost, List<PostReply> paramList, Handler paramHandler)
  {
    this.a = paramContext;
    this.c = paramPost;
    this.b = paramList;
    this.e = paramHandler;
    this.d = new a();
  }

  private void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    paramImageView.setImageResource(2131034185);
    e.a(this.a).a(((String)this.c.getPost_files().get(paramInt1)).split(";")[0], paramImageView);
    paramImageView.setVisibility(0);
    paramImageView.setOnClickListener(new x(this, paramInt1));
  }

  private void a(TableLayout paramTableLayout, LinearLayout[] paramArrayOfLinearLayout, int paramInt1, int paramInt2)
  {
    paramTableLayout.setVisibility(0);
    int i = f.a(this.a).y() - (int)(paramInt2 * f.a(this.a).z() / 160.0F);
    LinearLayout.LayoutParams localLayoutParams;
    if (paramInt1 <= 3)
    {
      paramArrayOfLinearLayout[0].setVisibility(0);
      paramArrayOfLinearLayout[1].setVisibility(8);
      paramArrayOfLinearLayout[2].setVisibility(8);
      localLayoutParams = new LinearLayout.LayoutParams(i, 30 + i / 3);
    }
    while (true)
    {
      localLayoutParams.setMargins((int)(paramInt2 / 2 * f.a(this.a).z() / 160.0F), 0, (int)(paramInt2 / 2 * f.a(this.a).z() / 160.0F), 0);
      paramTableLayout.setLayoutParams(localLayoutParams);
      return;
      if ((paramInt1 > 3) && (paramInt1 <= 6))
      {
        paramArrayOfLinearLayout[0].setVisibility(0);
        paramArrayOfLinearLayout[1].setVisibility(0);
        paramArrayOfLinearLayout[2].setVisibility(8);
        localLayoutParams = new LinearLayout.LayoutParams(i, 30 + 2 * (i / 3));
        continue;
      }
      paramArrayOfLinearLayout[0].setVisibility(0);
      paramArrayOfLinearLayout[1].setVisibility(0);
      paramArrayOfLinearLayout[2].setVisibility(0);
      localLayoutParams = new LinearLayout.LayoutParams(i, i + 35);
    }
  }

  private void b(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    paramImageView.setImageResource(2131034185);
    e.a(this.a).a(((String)((PostReply)this.b.get(paramInt2)).getPost_files().get(paramInt1)).split(";")[0], paramImageView);
    paramImageView.setVisibility(0);
    paramImageView.setOnClickListener(new y(this, paramInt1, paramInt2));
  }

  private void b(TableLayout paramTableLayout, LinearLayout[] paramArrayOfLinearLayout, int paramInt1, int paramInt2)
  {
    paramTableLayout.setVisibility(0);
    int i = f.a(this.a).y() - (int)(paramInt2 * f.a(this.a).z() / 160.0F);
    LinearLayout.LayoutParams localLayoutParams;
    if (paramInt1 <= 3)
    {
      paramArrayOfLinearLayout[0].setVisibility(0);
      paramArrayOfLinearLayout[1].setVisibility(8);
      paramArrayOfLinearLayout[2].setVisibility(8);
      localLayoutParams = new LinearLayout.LayoutParams(i, 30 + i / 3);
    }
    while (true)
    {
      paramTableLayout.setLayoutParams(localLayoutParams);
      return;
      if ((paramInt1 > 3) && (paramInt1 <= 6))
      {
        paramArrayOfLinearLayout[0].setVisibility(0);
        paramArrayOfLinearLayout[1].setVisibility(0);
        paramArrayOfLinearLayout[2].setVisibility(8);
        localLayoutParams = new LinearLayout.LayoutParams(i, 30 + 2 * (i / 3));
        continue;
      }
      paramArrayOfLinearLayout[0].setVisibility(0);
      paramArrayOfLinearLayout[1].setVisibility(0);
      paramArrayOfLinearLayout[2].setVisibility(0);
      localLayoutParams = new LinearLayout.LayoutParams(i, i + 35);
    }
  }

  public Post a()
  {
    return this.c;
  }

  public void a(Post paramPost)
  {
    this.c = paramPost;
  }

  public int getCount()
  {
    return 1 + this.b.size();
  }

  public Object getItem(int paramInt)
  {
    if (paramInt != 0)
      return this.b.get(paramInt);
    return this.c;
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0)
      return 0;
    return 1;
  }

  // ERROR //
  public View getView(int paramInt, View paramView, android.view.ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: iload_1
    //   5: invokevirtual 151	com/withustudy/koudaizikao/b/w:getItemViewType	(I)I
    //   8: istore 5
    //   10: aconst_null
    //   11: astore 6
    //   13: aload_2
    //   14: ifnonnull +877 -> 891
    //   17: iload 5
    //   19: tableswitch	default:+21 -> 40, 0:+59->78, 1:+467->486
    //   41: astore 7
    //   43: aload_2
    //   44: aload_0
    //   45: getfield 40	com/withustudy/koudaizikao/b/w:d	Lcom/withustudy/koudaizikao/b/w$a;
    //   48: invokevirtual 154	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   51: iload 5
    //   53: tableswitch	default:+23 -> 76, 0:+902->955, 1:+1370->1423
    //   77: areturn
    //   78: new 156	com/withustudy/koudaizikao/b/w$b
    //   81: dup
    //   82: aload_0
    //   83: invokespecial 157	com/withustudy/koudaizikao/b/w$b:<init>	(Lcom/withustudy/koudaizikao/b/w;)V
    //   86: astore 13
    //   88: aload_0
    //   89: getfield 27	com/withustudy/koudaizikao/b/w:a	Landroid/content/Context;
    //   92: invokestatic 163	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   95: ldc 164
    //   97: aconst_null
    //   98: invokevirtual 168	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   101: astore_2
    //   102: aload 13
    //   104: aload_2
    //   105: ldc 169
    //   107: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   110: checkcast 45	android/widget/ImageView
    //   113: putfield 176	com/withustudy/koudaizikao/b/w$b:a	Landroid/widget/ImageView;
    //   116: aload 13
    //   118: aload_2
    //   119: ldc 177
    //   121: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   124: checkcast 179	android/widget/TextView
    //   127: putfield 182	com/withustudy/koudaizikao/b/w$b:b	Landroid/widget/TextView;
    //   130: aload 13
    //   132: aload_2
    //   133: ldc 183
    //   135: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   138: checkcast 179	android/widget/TextView
    //   141: putfield 185	com/withustudy/koudaizikao/b/w$b:c	Landroid/widget/TextView;
    //   144: aload 13
    //   146: aload_2
    //   147: ldc 186
    //   149: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   152: checkcast 179	android/widget/TextView
    //   155: putfield 188	com/withustudy/koudaizikao/b/w$b:e	Landroid/widget/TextView;
    //   158: aload 13
    //   160: aload_2
    //   161: ldc 189
    //   163: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   166: checkcast 179	android/widget/TextView
    //   169: putfield 191	com/withustudy/koudaizikao/b/w$b:d	Landroid/widget/TextView;
    //   172: aload 13
    //   174: aload_2
    //   175: ldc 192
    //   177: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   180: checkcast 179	android/widget/TextView
    //   183: putfield 194	com/withustudy/koudaizikao/b/w$b:f	Landroid/widget/TextView;
    //   186: aload 13
    //   188: aload_2
    //   189: ldc 195
    //   191: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   194: checkcast 92	android/widget/TableLayout
    //   197: putfield 198	com/withustudy/koudaizikao/b/w$b:g	Landroid/widget/TableLayout;
    //   200: aload 13
    //   202: iconst_3
    //   203: anewarray 109	android/widget/LinearLayout
    //   206: putfield 202	com/withustudy/koudaizikao/b/w$b:h	[Landroid/widget/LinearLayout;
    //   209: aload 13
    //   211: getfield 202	com/withustudy/koudaizikao/b/w$b:h	[Landroid/widget/LinearLayout;
    //   214: iconst_0
    //   215: aload_2
    //   216: ldc 203
    //   218: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   221: checkcast 109	android/widget/LinearLayout
    //   224: aastore
    //   225: aload 13
    //   227: getfield 202	com/withustudy/koudaizikao/b/w$b:h	[Landroid/widget/LinearLayout;
    //   230: iconst_1
    //   231: aload_2
    //   232: ldc 204
    //   234: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   237: checkcast 109	android/widget/LinearLayout
    //   240: aastore
    //   241: aload 13
    //   243: getfield 202	com/withustudy/koudaizikao/b/w$b:h	[Landroid/widget/LinearLayout;
    //   246: iconst_2
    //   247: aload_2
    //   248: ldc 205
    //   250: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   253: checkcast 109	android/widget/LinearLayout
    //   256: aastore
    //   257: aload 13
    //   259: bipush 9
    //   261: anewarray 45	android/widget/ImageView
    //   264: putfield 209	com/withustudy/koudaizikao/b/w$b:i	[Landroid/widget/ImageView;
    //   267: aload 13
    //   269: getfield 209	com/withustudy/koudaizikao/b/w$b:i	[Landroid/widget/ImageView;
    //   272: iconst_0
    //   273: aload_2
    //   274: ldc 210
    //   276: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   279: checkcast 45	android/widget/ImageView
    //   282: aastore
    //   283: aload 13
    //   285: getfield 209	com/withustudy/koudaizikao/b/w$b:i	[Landroid/widget/ImageView;
    //   288: iconst_1
    //   289: aload_2
    //   290: ldc 211
    //   292: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   295: checkcast 45	android/widget/ImageView
    //   298: aastore
    //   299: aload 13
    //   301: getfield 209	com/withustudy/koudaizikao/b/w$b:i	[Landroid/widget/ImageView;
    //   304: iconst_2
    //   305: aload_2
    //   306: ldc 212
    //   308: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   311: checkcast 45	android/widget/ImageView
    //   314: aastore
    //   315: aload 13
    //   317: getfield 209	com/withustudy/koudaizikao/b/w$b:i	[Landroid/widget/ImageView;
    //   320: iconst_3
    //   321: aload_2
    //   322: ldc 213
    //   324: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   327: checkcast 45	android/widget/ImageView
    //   330: aastore
    //   331: aload 13
    //   333: getfield 209	com/withustudy/koudaizikao/b/w$b:i	[Landroid/widget/ImageView;
    //   336: iconst_4
    //   337: aload_2
    //   338: ldc 214
    //   340: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   343: checkcast 45	android/widget/ImageView
    //   346: aastore
    //   347: aload 13
    //   349: getfield 209	com/withustudy/koudaizikao/b/w$b:i	[Landroid/widget/ImageView;
    //   352: iconst_5
    //   353: aload_2
    //   354: ldc 215
    //   356: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   359: checkcast 45	android/widget/ImageView
    //   362: aastore
    //   363: aload 13
    //   365: getfield 209	com/withustudy/koudaizikao/b/w$b:i	[Landroid/widget/ImageView;
    //   368: bipush 6
    //   370: aload_2
    //   371: ldc 216
    //   373: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   376: checkcast 45	android/widget/ImageView
    //   379: aastore
    //   380: aload 13
    //   382: getfield 209	com/withustudy/koudaizikao/b/w$b:i	[Landroid/widget/ImageView;
    //   385: bipush 7
    //   387: aload_2
    //   388: ldc 217
    //   390: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   393: checkcast 45	android/widget/ImageView
    //   396: aastore
    //   397: aload 13
    //   399: getfield 209	com/withustudy/koudaizikao/b/w$b:i	[Landroid/widget/ImageView;
    //   402: bipush 8
    //   404: aload_2
    //   405: ldc 218
    //   407: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   410: checkcast 45	android/widget/ImageView
    //   413: aastore
    //   414: aload 13
    //   416: aload_2
    //   417: ldc 219
    //   419: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   422: checkcast 179	android/widget/TextView
    //   425: putfield 222	com/withustudy/koudaizikao/b/w$b:j	Landroid/widget/TextView;
    //   428: aload 13
    //   430: aload_2
    //   431: ldc 223
    //   433: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   436: checkcast 179	android/widget/TextView
    //   439: putfield 226	com/withustudy/koudaizikao/b/w$b:k	Landroid/widget/TextView;
    //   442: aload 13
    //   444: aload_2
    //   445: ldc 227
    //   447: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   450: checkcast 179	android/widget/TextView
    //   453: putfield 230	com/withustudy/koudaizikao/b/w$b:l	Landroid/widget/TextView;
    //   456: aload 13
    //   458: aload_2
    //   459: ldc 231
    //   461: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   464: checkcast 179	android/widget/TextView
    //   467: putfield 234	com/withustudy/koudaizikao/b/w$b:m	Landroid/widget/TextView;
    //   470: aload_2
    //   471: aload 13
    //   473: invokevirtual 238	android/view/View:setTag	(Ljava/lang/Object;)V
    //   476: aload 13
    //   478: astore 7
    //   480: aconst_null
    //   481: astore 6
    //   483: goto -440 -> 43
    //   486: new 240	com/withustudy/koudaizikao/b/w$c
    //   489: dup
    //   490: aload_0
    //   491: invokespecial 241	com/withustudy/koudaizikao/b/w$c:<init>	(Lcom/withustudy/koudaizikao/b/w;)V
    //   494: astore 6
    //   496: aload_0
    //   497: getfield 27	com/withustudy/koudaizikao/b/w:a	Landroid/content/Context;
    //   500: invokestatic 163	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   503: ldc 242
    //   505: aconst_null
    //   506: invokevirtual 168	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   509: astore_2
    //   510: aload 6
    //   512: aload_2
    //   513: ldc 243
    //   515: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   518: checkcast 45	android/widget/ImageView
    //   521: putfield 244	com/withustudy/koudaizikao/b/w$c:a	Landroid/widget/ImageView;
    //   524: aload 6
    //   526: aload_2
    //   527: ldc 245
    //   529: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   532: checkcast 179	android/widget/TextView
    //   535: putfield 246	com/withustudy/koudaizikao/b/w$c:b	Landroid/widget/TextView;
    //   538: aload 6
    //   540: aload_2
    //   541: ldc 247
    //   543: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   546: checkcast 179	android/widget/TextView
    //   549: putfield 248	com/withustudy/koudaizikao/b/w$c:c	Landroid/widget/TextView;
    //   552: aload 6
    //   554: aload_2
    //   555: ldc 249
    //   557: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   560: checkcast 179	android/widget/TextView
    //   563: putfield 250	com/withustudy/koudaizikao/b/w$c:d	Landroid/widget/TextView;
    //   566: aload 6
    //   568: aload_2
    //   569: ldc 251
    //   571: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   574: checkcast 179	android/widget/TextView
    //   577: putfield 252	com/withustudy/koudaizikao/b/w$c:e	Landroid/widget/TextView;
    //   580: aload 6
    //   582: aload_2
    //   583: ldc 253
    //   585: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   588: checkcast 179	android/widget/TextView
    //   591: putfield 254	com/withustudy/koudaizikao/b/w$c:f	Landroid/widget/TextView;
    //   594: aload 6
    //   596: aload_2
    //   597: ldc 255
    //   599: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   602: checkcast 92	android/widget/TableLayout
    //   605: putfield 256	com/withustudy/koudaizikao/b/w$c:g	Landroid/widget/TableLayout;
    //   608: aload 6
    //   610: iconst_3
    //   611: anewarray 109	android/widget/LinearLayout
    //   614: putfield 257	com/withustudy/koudaizikao/b/w$c:h	[Landroid/widget/LinearLayout;
    //   617: aload 6
    //   619: getfield 257	com/withustudy/koudaizikao/b/w$c:h	[Landroid/widget/LinearLayout;
    //   622: iconst_0
    //   623: aload_2
    //   624: ldc_w 258
    //   627: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   630: checkcast 109	android/widget/LinearLayout
    //   633: aastore
    //   634: aload 6
    //   636: getfield 257	com/withustudy/koudaizikao/b/w$c:h	[Landroid/widget/LinearLayout;
    //   639: iconst_1
    //   640: aload_2
    //   641: ldc_w 259
    //   644: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   647: checkcast 109	android/widget/LinearLayout
    //   650: aastore
    //   651: aload 6
    //   653: getfield 257	com/withustudy/koudaizikao/b/w$c:h	[Landroid/widget/LinearLayout;
    //   656: iconst_2
    //   657: aload_2
    //   658: ldc_w 260
    //   661: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   664: checkcast 109	android/widget/LinearLayout
    //   667: aastore
    //   668: aload 6
    //   670: bipush 9
    //   672: anewarray 45	android/widget/ImageView
    //   675: putfield 261	com/withustudy/koudaizikao/b/w$c:i	[Landroid/widget/ImageView;
    //   678: aload 6
    //   680: getfield 261	com/withustudy/koudaizikao/b/w$c:i	[Landroid/widget/ImageView;
    //   683: iconst_0
    //   684: aload_2
    //   685: ldc_w 262
    //   688: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   691: checkcast 45	android/widget/ImageView
    //   694: aastore
    //   695: aload 6
    //   697: getfield 261	com/withustudy/koudaizikao/b/w$c:i	[Landroid/widget/ImageView;
    //   700: iconst_1
    //   701: aload_2
    //   702: ldc_w 263
    //   705: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   708: checkcast 45	android/widget/ImageView
    //   711: aastore
    //   712: aload 6
    //   714: getfield 261	com/withustudy/koudaizikao/b/w$c:i	[Landroid/widget/ImageView;
    //   717: iconst_2
    //   718: aload_2
    //   719: ldc_w 264
    //   722: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   725: checkcast 45	android/widget/ImageView
    //   728: aastore
    //   729: aload 6
    //   731: getfield 261	com/withustudy/koudaizikao/b/w$c:i	[Landroid/widget/ImageView;
    //   734: iconst_3
    //   735: aload_2
    //   736: ldc_w 265
    //   739: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   742: checkcast 45	android/widget/ImageView
    //   745: aastore
    //   746: aload 6
    //   748: getfield 261	com/withustudy/koudaizikao/b/w$c:i	[Landroid/widget/ImageView;
    //   751: iconst_4
    //   752: aload_2
    //   753: ldc_w 266
    //   756: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   759: checkcast 45	android/widget/ImageView
    //   762: aastore
    //   763: aload 6
    //   765: getfield 261	com/withustudy/koudaizikao/b/w$c:i	[Landroid/widget/ImageView;
    //   768: iconst_5
    //   769: aload_2
    //   770: ldc_w 267
    //   773: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   776: checkcast 45	android/widget/ImageView
    //   779: aastore
    //   780: aload 6
    //   782: getfield 261	com/withustudy/koudaizikao/b/w$c:i	[Landroid/widget/ImageView;
    //   785: bipush 6
    //   787: aload_2
    //   788: ldc_w 268
    //   791: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   794: checkcast 45	android/widget/ImageView
    //   797: aastore
    //   798: aload 6
    //   800: getfield 261	com/withustudy/koudaizikao/b/w$c:i	[Landroid/widget/ImageView;
    //   803: bipush 7
    //   805: aload_2
    //   806: ldc_w 269
    //   809: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   812: checkcast 45	android/widget/ImageView
    //   815: aastore
    //   816: aload 6
    //   818: getfield 261	com/withustudy/koudaizikao/b/w$c:i	[Landroid/widget/ImageView;
    //   821: bipush 8
    //   823: aload_2
    //   824: ldc_w 270
    //   827: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   830: checkcast 45	android/widget/ImageView
    //   833: aastore
    //   834: aload 6
    //   836: aload_2
    //   837: ldc_w 271
    //   840: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   843: checkcast 179	android/widget/TextView
    //   846: putfield 272	com/withustudy/koudaizikao/b/w$c:j	Landroid/widget/TextView;
    //   849: aload 6
    //   851: aload_2
    //   852: ldc_w 273
    //   855: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   858: checkcast 179	android/widget/TextView
    //   861: putfield 274	com/withustudy/koudaizikao/b/w$c:k	Landroid/widget/TextView;
    //   864: aload 6
    //   866: aload_2
    //   867: ldc_w 275
    //   870: invokevirtual 173	android/view/View:findViewById	(I)Landroid/view/View;
    //   873: checkcast 277	android/widget/Button
    //   876: putfield 280	com/withustudy/koudaizikao/b/w$c:l	Landroid/widget/Button;
    //   879: aload_2
    //   880: aload 6
    //   882: invokevirtual 238	android/view/View:setTag	(Ljava/lang/Object;)V
    //   885: aconst_null
    //   886: astore 7
    //   888: goto -845 -> 43
    //   891: iload 5
    //   893: tableswitch	default:+23 -> 916, 0:+32->925, 1:+47->940
    //   917: astore 7
    //   919: aconst_null
    //   920: astore 6
    //   922: goto -879 -> 43
    //   925: aload_2
    //   926: invokevirtual 284	android/view/View:getTag	()Ljava/lang/Object;
    //   929: checkcast 156	com/withustudy/koudaizikao/b/w$b
    //   932: astore 7
    //   934: aconst_null
    //   935: astore 6
    //   937: goto -894 -> 43
    //   940: aload_2
    //   941: invokevirtual 284	android/view/View:getTag	()Ljava/lang/Object;
    //   944: checkcast 240	com/withustudy/koudaizikao/b/w$c
    //   947: astore 6
    //   949: aconst_null
    //   950: astore 7
    //   952: goto -909 -> 43
    //   955: aload_0
    //   956: getfield 29	com/withustudy/koudaizikao/b/w:c	Lcom/withustudy/koudaizikao/entity/Post;
    //   959: ifnull -883 -> 76
    //   962: aload_0
    //   963: getfield 29	com/withustudy/koudaizikao/b/w:c	Lcom/withustudy/koudaizikao/entity/Post;
    //   966: invokevirtual 288	com/withustudy/koudaizikao/entity/Post:getUser_headimg	()Ljava/lang/String;
    //   969: ifnull +287 -> 1256
    //   972: aload_0
    //   973: getfield 29	com/withustudy/koudaizikao/b/w:c	Lcom/withustudy/koudaizikao/entity/Post;
    //   976: invokevirtual 288	com/withustudy/koudaizikao/entity/Post:getUser_headimg	()Ljava/lang/String;
    //   979: ldc_w 290
    //   982: invokevirtual 294	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   985: ifne +271 -> 1256
    //   988: aload_0
    //   989: getfield 27	com/withustudy/koudaizikao/b/w:a	Landroid/content/Context;
    //   992: invokestatic 54	com/android/http/e:a	(Landroid/content/Context;)Lcom/android/http/e;
    //   995: aload_0
    //   996: getfield 29	com/withustudy/koudaizikao/b/w:c	Lcom/withustudy/koudaizikao/entity/Post;
    //   999: invokevirtual 288	com/withustudy/koudaizikao/entity/Post:getUser_headimg	()Ljava/lang/String;
    //   1002: aload 7
    //   1004: getfield 176	com/withustudy/koudaizikao/b/w$b:a	Landroid/widget/ImageView;
    //   1007: sipush 1000
    //   1010: invokevirtual 297	com/android/http/e:a	(Ljava/lang/String;Landroid/widget/ImageView;I)V
    //   1013: aload 7
    //   1015: getfield 182	com/withustudy/koudaizikao/b/w$b:b	Landroid/widget/TextView;
    //   1018: aload_0
    //   1019: getfield 29	com/withustudy/koudaizikao/b/w:c	Lcom/withustudy/koudaizikao/entity/Post;
    //   1022: invokevirtual 300	com/withustudy/koudaizikao/entity/Post:getUser_name	()Ljava/lang/String;
    //   1025: invokevirtual 304	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1028: aload 7
    //   1030: getfield 185	com/withustudy/koudaizikao/b/w$b:c	Landroid/widget/TextView;
    //   1033: aload_0
    //   1034: getfield 27	com/withustudy/koudaizikao/b/w:a	Landroid/content/Context;
    //   1037: aload_0
    //   1038: getfield 29	com/withustudy/koudaizikao/b/w:c	Lcom/withustudy/koudaizikao/entity/Post;
    //   1041: invokevirtual 308	com/withustudy/koudaizikao/entity/Post:getTopic_time	()J
    //   1044: invokestatic 313	com/withustudy/koudaizikao/g/b:b	(Landroid/content/Context;J)Ljava/lang/String;
    //   1047: invokevirtual 304	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1050: aload 7
    //   1052: getfield 191	com/withustudy/koudaizikao/b/w$b:d	Landroid/widget/TextView;
    //   1055: aload_0
    //   1056: getfield 27	com/withustudy/koudaizikao/b/w:a	Landroid/content/Context;
    //   1059: invokevirtual 319	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1062: ldc_w 320
    //   1065: invokevirtual 326	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1068: invokevirtual 304	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1071: aload 7
    //   1073: getfield 188	com/withustudy/koudaizikao/b/w$b:e	Landroid/widget/TextView;
    //   1076: aload_0
    //   1077: getfield 29	com/withustudy/koudaizikao/b/w:c	Lcom/withustudy/koudaizikao/entity/Post;
    //   1080: invokevirtual 329	com/withustudy/koudaizikao/entity/Post:getTopic_title	()Ljava/lang/String;
    //   1083: invokevirtual 304	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1086: aload 7
    //   1088: getfield 194	com/withustudy/koudaizikao/b/w$b:f	Landroid/widget/TextView;
    //   1091: aload_0
    //   1092: getfield 29	com/withustudy/koudaizikao/b/w:c	Lcom/withustudy/koudaizikao/entity/Post;
    //   1095: invokevirtual 332	com/withustudy/koudaizikao/entity/Post:getTopic_sub_desc	()Ljava/lang/String;
    //   1098: invokevirtual 304	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1101: aload_0
    //   1102: getfield 29	com/withustudy/koudaizikao/b/w:c	Lcom/withustudy/koudaizikao/entity/Post;
    //   1105: invokevirtual 335	com/withustudy/koudaizikao/entity/Post:getPost_img_count	()I
    //   1108: ifeq +234 -> 1342
    //   1111: aload_0
    //   1112: aload 7
    //   1114: getfield 198	com/withustudy/koudaizikao/b/w$b:g	Landroid/widget/TableLayout;
    //   1117: aload 7
    //   1119: getfield 202	com/withustudy/koudaizikao/b/w$b:h	[Landroid/widget/LinearLayout;
    //   1122: aload_0
    //   1123: getfield 29	com/withustudy/koudaizikao/b/w:c	Lcom/withustudy/koudaizikao/entity/Post;
    //   1126: invokevirtual 335	com/withustudy/koudaizikao/entity/Post:getPost_img_count	()I
    //   1129: bipush 24
    //   1131: invokespecial 337	com/withustudy/koudaizikao/b/w:a	(Landroid/widget/TableLayout;[Landroid/widget/LinearLayout;II)V
    //   1134: iconst_0
    //   1135: istore 12
    //   1137: goto +957 -> 2094
    //   1140: aload 7
    //   1142: getfield 222	com/withustudy/koudaizikao/b/w$b:j	Landroid/widget/TextView;
    //   1145: aload_0
    //   1146: getfield 29	com/withustudy/koudaizikao/b/w:c	Lcom/withustudy/koudaizikao/entity/Post;
    //   1149: invokevirtual 340	com/withustudy/koudaizikao/entity/Post:getPost_area	()Ljava/lang/String;
    //   1152: invokevirtual 304	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1155: aload 7
    //   1157: getfield 230	com/withustudy/koudaizikao/b/w$b:l	Landroid/widget/TextView;
    //   1160: aload_0
    //   1161: getfield 29	com/withustudy/koudaizikao/b/w:c	Lcom/withustudy/koudaizikao/entity/Post;
    //   1164: invokevirtual 343	com/withustudy/koudaizikao/entity/Post:getTopic_praise	()I
    //   1167: invokestatic 346	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1170: invokevirtual 304	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1173: aload 7
    //   1175: getfield 234	com/withustudy/koudaizikao/b/w$b:m	Landroid/widget/TextView;
    //   1178: aload_0
    //   1179: getfield 29	com/withustudy/koudaizikao/b/w:c	Lcom/withustudy/koudaizikao/entity/Post;
    //   1182: invokevirtual 349	com/withustudy/koudaizikao/entity/Post:getTopic_replies	()I
    //   1185: invokestatic 346	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1188: invokevirtual 304	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1191: aload_0
    //   1192: getfield 27	com/withustudy/koudaizikao/b/w:a	Landroid/content/Context;
    //   1195: invokestatic 98	com/withustudy/koudaizikao/d/f:a	(Landroid/content/Context;)Lcom/withustudy/koudaizikao/d/f;
    //   1198: invokevirtual 351	com/withustudy/koudaizikao/d/f:i	()Ljava/lang/String;
    //   1201: ldc_w 290
    //   1204: invokevirtual 294	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1207: ifne +203 -> 1410
    //   1210: aload_0
    //   1211: getfield 27	com/withustudy/koudaizikao/b/w:a	Landroid/content/Context;
    //   1214: invokestatic 98	com/withustudy/koudaizikao/d/f:a	(Landroid/content/Context;)Lcom/withustudy/koudaizikao/d/f;
    //   1217: invokevirtual 351	com/withustudy/koudaizikao/d/f:i	()Ljava/lang/String;
    //   1220: aload_0
    //   1221: getfield 29	com/withustudy/koudaizikao/b/w:c	Lcom/withustudy/koudaizikao/entity/Post;
    //   1224: invokevirtual 354	com/withustudy/koudaizikao/entity/Post:getUserid	()Ljava/lang/String;
    //   1227: invokevirtual 294	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1230: ifeq +167 -> 1397
    //   1233: aload 7
    //   1235: getfield 226	com/withustudy/koudaizikao/b/w$b:k	Landroid/widget/TextView;
    //   1238: iconst_0
    //   1239: invokevirtual 355	android/widget/TextView:setVisibility	(I)V
    //   1242: aload 7
    //   1244: getfield 226	com/withustudy/koudaizikao/b/w$b:k	Landroid/widget/TextView;
    //   1247: aload_0
    //   1248: getfield 40	com/withustudy/koudaizikao/b/w:d	Lcom/withustudy/koudaizikao/b/w$a;
    //   1251: invokevirtual 356	android/widget/TextView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1254: aload_2
    //   1255: areturn
    //   1256: aload 7
    //   1258: getfield 176	com/withustudy/koudaizikao/b/w$b:a	Landroid/widget/ImageView;
    //   1261: ldc_w 357
    //   1264: invokevirtual 49	android/widget/ImageView:setImageResource	(I)V
    //   1267: goto -254 -> 1013
    //   1270: iload 12
    //   1272: aload_0
    //   1273: getfield 29	com/withustudy/koudaizikao/b/w:c	Lcom/withustudy/koudaizikao/entity/Post;
    //   1276: invokevirtual 335	com/withustudy/koudaizikao/entity/Post:getPost_img_count	()I
    //   1279: if_icmpge +21 -> 1300
    //   1282: aload_0
    //   1283: aload 7
    //   1285: getfield 209	com/withustudy/koudaizikao/b/w$b:i	[Landroid/widget/ImageView;
    //   1288: iload 12
    //   1290: aaload
    //   1291: iload 12
    //   1293: iload_1
    //   1294: invokespecial 359	com/withustudy/koudaizikao/b/w:a	(Landroid/widget/ImageView;II)V
    //   1297: goto +811 -> 2108
    //   1300: aload_0
    //   1301: getfield 29	com/withustudy/koudaizikao/b/w:c	Lcom/withustudy/koudaizikao/entity/Post;
    //   1304: invokevirtual 335	com/withustudy/koudaizikao/entity/Post:getPost_img_count	()I
    //   1307: iconst_2
    //   1308: if_icmpne +19 -> 1327
    //   1311: aload 7
    //   1313: getfield 209	com/withustudy/koudaizikao/b/w$b:i	[Landroid/widget/ImageView;
    //   1316: iload 12
    //   1318: aaload
    //   1319: bipush 8
    //   1321: invokevirtual 80	android/widget/ImageView:setVisibility	(I)V
    //   1324: goto +784 -> 2108
    //   1327: aload 7
    //   1329: getfield 209	com/withustudy/koudaizikao/b/w$b:i	[Landroid/widget/ImageView;
    //   1332: iload 12
    //   1334: aaload
    //   1335: iconst_4
    //   1336: invokevirtual 80	android/widget/ImageView:setVisibility	(I)V
    //   1339: goto +769 -> 2108
    //   1342: aload 7
    //   1344: getfield 198	com/withustudy/koudaizikao/b/w$b:g	Landroid/widget/TableLayout;
    //   1347: bipush 8
    //   1349: invokevirtual 93	android/widget/TableLayout:setVisibility	(I)V
    //   1352: iload 4
    //   1354: bipush 9
    //   1356: if_icmpge -216 -> 1140
    //   1359: iload 4
    //   1361: iconst_3
    //   1362: if_icmpge +16 -> 1378
    //   1365: aload 7
    //   1367: getfield 202	com/withustudy/koudaizikao/b/w$b:h	[Landroid/widget/LinearLayout;
    //   1370: iload 4
    //   1372: aaload
    //   1373: bipush 8
    //   1375: invokevirtual 110	android/widget/LinearLayout:setVisibility	(I)V
    //   1378: aload 7
    //   1380: getfield 209	com/withustudy/koudaizikao/b/w$b:i	[Landroid/widget/ImageView;
    //   1383: iload 4
    //   1385: aaload
    //   1386: bipush 8
    //   1388: invokevirtual 80	android/widget/ImageView:setVisibility	(I)V
    //   1391: iinc 4 1
    //   1394: goto -42 -> 1352
    //   1397: aload 7
    //   1399: getfield 226	com/withustudy/koudaizikao/b/w$b:k	Landroid/widget/TextView;
    //   1402: bipush 8
    //   1404: invokevirtual 355	android/widget/TextView:setVisibility	(I)V
    //   1407: goto -165 -> 1242
    //   1410: aload 7
    //   1412: getfield 226	com/withustudy/koudaizikao/b/w$b:k	Landroid/widget/TextView;
    //   1415: bipush 8
    //   1417: invokevirtual 355	android/widget/TextView:setVisibility	(I)V
    //   1420: goto -178 -> 1242
    //   1423: aload 6
    //   1425: getfield 244	com/withustudy/koudaizikao/b/w$c:a	Landroid/widget/ImageView;
    //   1428: iload_1
    //   1429: iconst_1
    //   1430: isub
    //   1431: invokestatic 364	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1434: invokevirtual 365	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   1437: aload_0
    //   1438: getfield 31	com/withustudy/koudaizikao/b/w:b	Ljava/util/List;
    //   1441: iload_1
    //   1442: iconst_1
    //   1443: isub
    //   1444: invokeinterface 66 2 0
    //   1449: checkcast 126	com/withustudy/koudaizikao/entity/PostReply
    //   1452: invokevirtual 366	com/withustudy/koudaizikao/entity/PostReply:getUser_headimg	()Ljava/lang/String;
    //   1455: ifnull +434 -> 1889
    //   1458: aload_0
    //   1459: getfield 31	com/withustudy/koudaizikao/b/w:b	Ljava/util/List;
    //   1462: iload_1
    //   1463: iconst_1
    //   1464: isub
    //   1465: invokeinterface 66 2 0
    //   1470: checkcast 126	com/withustudy/koudaizikao/entity/PostReply
    //   1473: invokevirtual 366	com/withustudy/koudaizikao/entity/PostReply:getUser_headimg	()Ljava/lang/String;
    //   1476: ldc_w 290
    //   1479: invokevirtual 294	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1482: ifne +407 -> 1889
    //   1485: aload_0
    //   1486: getfield 27	com/withustudy/koudaizikao/b/w:a	Landroid/content/Context;
    //   1489: invokestatic 54	com/android/http/e:a	(Landroid/content/Context;)Lcom/android/http/e;
    //   1492: aload_0
    //   1493: getfield 31	com/withustudy/koudaizikao/b/w:b	Ljava/util/List;
    //   1496: iload_1
    //   1497: iconst_1
    //   1498: isub
    //   1499: invokeinterface 66 2 0
    //   1504: checkcast 126	com/withustudy/koudaizikao/entity/PostReply
    //   1507: invokevirtual 366	com/withustudy/koudaizikao/entity/PostReply:getUser_headimg	()Ljava/lang/String;
    //   1510: aload 6
    //   1512: getfield 244	com/withustudy/koudaizikao/b/w$c:a	Landroid/widget/ImageView;
    //   1515: iload_1
    //   1516: iconst_1
    //   1517: isub
    //   1518: invokevirtual 368	com/android/http/e:c	(Ljava/lang/String;Landroid/widget/ImageView;I)V
    //   1521: aload_0
    //   1522: getfield 31	com/withustudy/koudaizikao/b/w:b	Ljava/util/List;
    //   1525: iload_1
    //   1526: iconst_1
    //   1527: isub
    //   1528: invokeinterface 66 2 0
    //   1533: checkcast 126	com/withustudy/koudaizikao/entity/PostReply
    //   1536: invokevirtual 369	com/withustudy/koudaizikao/entity/PostReply:getUserid	()Ljava/lang/String;
    //   1539: aload_0
    //   1540: getfield 29	com/withustudy/koudaizikao/b/w:c	Lcom/withustudy/koudaizikao/entity/Post;
    //   1543: invokevirtual 354	com/withustudy/koudaizikao/entity/Post:getUserid	()Ljava/lang/String;
    //   1546: invokevirtual 294	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1549: ifeq +354 -> 1903
    //   1552: aload 6
    //   1554: getfield 246	com/withustudy/koudaizikao/b/w$c:b	Landroid/widget/TextView;
    //   1557: iconst_0
    //   1558: invokevirtual 355	android/widget/TextView:setVisibility	(I)V
    //   1561: aload 6
    //   1563: getfield 248	com/withustudy/koudaizikao/b/w$c:c	Landroid/widget/TextView;
    //   1566: aload_0
    //   1567: getfield 31	com/withustudy/koudaizikao/b/w:b	Ljava/util/List;
    //   1570: iload_1
    //   1571: iconst_1
    //   1572: isub
    //   1573: invokeinterface 66 2 0
    //   1578: checkcast 126	com/withustudy/koudaizikao/entity/PostReply
    //   1581: invokevirtual 370	com/withustudy/koudaizikao/entity/PostReply:getUser_name	()Ljava/lang/String;
    //   1584: invokevirtual 304	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1587: aload 6
    //   1589: getfield 250	com/withustudy/koudaizikao/b/w$c:d	Landroid/widget/TextView;
    //   1592: aload_0
    //   1593: getfield 27	com/withustudy/koudaizikao/b/w:a	Landroid/content/Context;
    //   1596: aload_0
    //   1597: getfield 31	com/withustudy/koudaizikao/b/w:b	Ljava/util/List;
    //   1600: iload_1
    //   1601: iconst_1
    //   1602: isub
    //   1603: invokeinterface 66 2 0
    //   1608: checkcast 126	com/withustudy/koudaizikao/entity/PostReply
    //   1611: invokevirtual 373	com/withustudy/koudaizikao/entity/PostReply:getPost_time	()J
    //   1614: invokestatic 313	com/withustudy/koudaizikao/g/b:b	(Landroid/content/Context;J)Ljava/lang/String;
    //   1617: invokevirtual 304	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1620: aload 6
    //   1622: getfield 252	com/withustudy/koudaizikao/b/w$c:e	Landroid/widget/TextView;
    //   1625: new 375	java/lang/StringBuilder
    //   1628: dup
    //   1629: iload_1
    //   1630: invokestatic 346	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1633: invokespecial 378	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1636: ldc_w 380
    //   1639: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1642: invokevirtual 387	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1645: invokevirtual 304	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1648: aload 6
    //   1650: getfield 254	com/withustudy/koudaizikao/b/w$c:f	Landroid/widget/TextView;
    //   1653: aload_0
    //   1654: getfield 31	com/withustudy/koudaizikao/b/w:b	Ljava/util/List;
    //   1657: iload_1
    //   1658: iconst_1
    //   1659: isub
    //   1660: invokeinterface 66 2 0
    //   1665: checkcast 126	com/withustudy/koudaizikao/entity/PostReply
    //   1668: invokevirtual 390	com/withustudy/koudaizikao/entity/PostReply:getPost_text	()Ljava/lang/String;
    //   1671: invokevirtual 304	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1674: aload_0
    //   1675: getfield 31	com/withustudy/koudaizikao/b/w:b	Ljava/util/List;
    //   1678: iload_1
    //   1679: iconst_1
    //   1680: isub
    //   1681: invokeinterface 66 2 0
    //   1686: checkcast 126	com/withustudy/koudaizikao/entity/PostReply
    //   1689: invokevirtual 391	com/withustudy/koudaizikao/entity/PostReply:getPost_img_count	()I
    //   1692: ifeq +320 -> 2012
    //   1695: aload_0
    //   1696: aload 6
    //   1698: getfield 256	com/withustudy/koudaizikao/b/w$c:g	Landroid/widget/TableLayout;
    //   1701: aload 6
    //   1703: getfield 257	com/withustudy/koudaizikao/b/w$c:h	[Landroid/widget/LinearLayout;
    //   1706: aload_0
    //   1707: getfield 31	com/withustudy/koudaizikao/b/w:b	Ljava/util/List;
    //   1710: iload_1
    //   1711: iconst_1
    //   1712: isub
    //   1713: invokeinterface 66 2 0
    //   1718: checkcast 126	com/withustudy/koudaizikao/entity/PostReply
    //   1721: invokevirtual 391	com/withustudy/koudaizikao/entity/PostReply:getPost_img_count	()I
    //   1724: bipush 80
    //   1726: invokespecial 393	com/withustudy/koudaizikao/b/w:b	(Landroid/widget/TableLayout;[Landroid/widget/LinearLayout;II)V
    //   1729: iconst_0
    //   1730: istore 10
    //   1732: goto +382 -> 2114
    //   1735: aload_0
    //   1736: getfield 31	com/withustudy/koudaizikao/b/w:b	Ljava/util/List;
    //   1739: iload_1
    //   1740: iconst_1
    //   1741: isub
    //   1742: invokeinterface 66 2 0
    //   1747: checkcast 126	com/withustudy/koudaizikao/entity/PostReply
    //   1750: invokevirtual 396	com/withustudy/koudaizikao/entity/PostReply:getReply_type	()I
    //   1753: iconst_1
    //   1754: if_icmpne +316 -> 2070
    //   1757: aload 6
    //   1759: getfield 272	com/withustudy/koudaizikao/b/w$c:j	Landroid/widget/TextView;
    //   1762: iconst_0
    //   1763: invokevirtual 355	android/widget/TextView:setVisibility	(I)V
    //   1766: aload 6
    //   1768: getfield 272	com/withustudy/koudaizikao/b/w$c:j	Landroid/widget/TextView;
    //   1771: new 375	java/lang/StringBuilder
    //   1774: dup
    //   1775: ldc_w 398
    //   1778: invokespecial 378	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1781: aload_0
    //   1782: getfield 31	com/withustudy/koudaizikao/b/w:b	Ljava/util/List;
    //   1785: iload_1
    //   1786: iconst_1
    //   1787: isub
    //   1788: invokeinterface 66 2 0
    //   1793: checkcast 126	com/withustudy/koudaizikao/entity/PostReply
    //   1796: invokevirtual 401	com/withustudy/koudaizikao/entity/PostReply:getReply_username	()Ljava/lang/String;
    //   1799: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1802: ldc_w 403
    //   1805: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1808: aload_0
    //   1809: getfield 31	com/withustudy/koudaizikao/b/w:b	Ljava/util/List;
    //   1812: iload_1
    //   1813: iconst_1
    //   1814: isub
    //   1815: invokeinterface 66 2 0
    //   1820: checkcast 126	com/withustudy/koudaizikao/entity/PostReply
    //   1823: invokevirtual 406	com/withustudy/koudaizikao/entity/PostReply:getReply_content	()Ljava/lang/String;
    //   1826: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1829: invokevirtual 387	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1832: invokevirtual 304	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1835: aload 6
    //   1837: getfield 280	com/withustudy/koudaizikao/b/w$c:l	Landroid/widget/Button;
    //   1840: iload_1
    //   1841: iconst_1
    //   1842: isub
    //   1843: invokestatic 364	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1846: invokevirtual 407	android/widget/Button:setTag	(Ljava/lang/Object;)V
    //   1849: aload 6
    //   1851: getfield 280	com/withustudy/koudaizikao/b/w$c:l	Landroid/widget/Button;
    //   1854: aload_0
    //   1855: getfield 40	com/withustudy/koudaizikao/b/w:d	Lcom/withustudy/koudaizikao/b/w$a;
    //   1858: invokevirtual 408	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1861: aload 6
    //   1863: getfield 274	com/withustudy/koudaizikao/b/w$c:k	Landroid/widget/TextView;
    //   1866: aload_0
    //   1867: getfield 31	com/withustudy/koudaizikao/b/w:b	Ljava/util/List;
    //   1870: iload_1
    //   1871: iconst_1
    //   1872: isub
    //   1873: invokeinterface 66 2 0
    //   1878: checkcast 126	com/withustudy/koudaizikao/entity/PostReply
    //   1881: invokevirtual 409	com/withustudy/koudaizikao/entity/PostReply:getPost_area	()Ljava/lang/String;
    //   1884: invokevirtual 304	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   1887: aload_2
    //   1888: areturn
    //   1889: aload 6
    //   1891: getfield 244	com/withustudy/koudaizikao/b/w$c:a	Landroid/widget/ImageView;
    //   1894: ldc_w 357
    //   1897: invokevirtual 49	android/widget/ImageView:setImageResource	(I)V
    //   1900: goto -379 -> 1521
    //   1903: aload 6
    //   1905: getfield 246	com/withustudy/koudaizikao/b/w$c:b	Landroid/widget/TextView;
    //   1908: bipush 8
    //   1910: invokevirtual 355	android/widget/TextView:setVisibility	(I)V
    //   1913: goto -352 -> 1561
    //   1916: iload 10
    //   1918: aload_0
    //   1919: getfield 31	com/withustudy/koudaizikao/b/w:b	Ljava/util/List;
    //   1922: iload_1
    //   1923: iconst_1
    //   1924: isub
    //   1925: invokeinterface 66 2 0
    //   1930: checkcast 126	com/withustudy/koudaizikao/entity/PostReply
    //   1933: invokevirtual 391	com/withustudy/koudaizikao/entity/PostReply:getPost_img_count	()I
    //   1936: if_icmpge +23 -> 1959
    //   1939: aload_0
    //   1940: aload 6
    //   1942: getfield 261	com/withustudy/koudaizikao/b/w$c:i	[Landroid/widget/ImageView;
    //   1945: iload 10
    //   1947: aaload
    //   1948: iload 10
    //   1950: iload_1
    //   1951: iconst_1
    //   1952: isub
    //   1953: invokespecial 411	com/withustudy/koudaizikao/b/w:b	(Landroid/widget/ImageView;II)V
    //   1956: goto +172 -> 2128
    //   1959: aload_0
    //   1960: getfield 31	com/withustudy/koudaizikao/b/w:b	Ljava/util/List;
    //   1963: iload_1
    //   1964: iconst_1
    //   1965: isub
    //   1966: invokeinterface 66 2 0
    //   1971: checkcast 126	com/withustudy/koudaizikao/entity/PostReply
    //   1974: invokevirtual 391	com/withustudy/koudaizikao/entity/PostReply:getPost_img_count	()I
    //   1977: iconst_2
    //   1978: if_icmpne +19 -> 1997
    //   1981: aload 6
    //   1983: getfield 261	com/withustudy/koudaizikao/b/w$c:i	[Landroid/widget/ImageView;
    //   1986: iload 10
    //   1988: aaload
    //   1989: bipush 8
    //   1991: invokevirtual 80	android/widget/ImageView:setVisibility	(I)V
    //   1994: goto +134 -> 2128
    //   1997: aload 6
    //   1999: getfield 261	com/withustudy/koudaizikao/b/w$c:i	[Landroid/widget/ImageView;
    //   2002: iload 10
    //   2004: aaload
    //   2005: iconst_4
    //   2006: invokevirtual 80	android/widget/ImageView:setVisibility	(I)V
    //   2009: goto +119 -> 2128
    //   2012: aload 6
    //   2014: getfield 256	com/withustudy/koudaizikao/b/w$c:g	Landroid/widget/TableLayout;
    //   2017: bipush 8
    //   2019: invokevirtual 93	android/widget/TableLayout:setVisibility	(I)V
    //   2022: iconst_0
    //   2023: istore 9
    //   2025: iload 9
    //   2027: bipush 9
    //   2029: if_icmpge -294 -> 1735
    //   2032: iload 9
    //   2034: iconst_3
    //   2035: if_icmpge +16 -> 2051
    //   2038: aload 6
    //   2040: getfield 257	com/withustudy/koudaizikao/b/w$c:h	[Landroid/widget/LinearLayout;
    //   2043: iload 9
    //   2045: aaload
    //   2046: bipush 8
    //   2048: invokevirtual 110	android/widget/LinearLayout:setVisibility	(I)V
    //   2051: aload 6
    //   2053: getfield 261	com/withustudy/koudaizikao/b/w$c:i	[Landroid/widget/ImageView;
    //   2056: iload 9
    //   2058: aaload
    //   2059: bipush 8
    //   2061: invokevirtual 80	android/widget/ImageView:setVisibility	(I)V
    //   2064: iinc 9 1
    //   2067: goto -42 -> 2025
    //   2070: aload 6
    //   2072: getfield 272	com/withustudy/koudaizikao/b/w$c:j	Landroid/widget/TextView;
    //   2075: bipush 8
    //   2077: invokevirtual 355	android/widget/TextView:setVisibility	(I)V
    //   2080: aload 6
    //   2082: getfield 272	com/withustudy/koudaizikao/b/w$c:j	Landroid/widget/TextView;
    //   2085: ldc_w 290
    //   2088: invokevirtual 304	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2091: goto -256 -> 1835
    //   2094: iload 12
    //   2096: bipush 9
    //   2098: if_icmplt -828 -> 1270
    //   2101: goto -961 -> 1140
    //   2104: astore 11
    //   2106: aload_2
    //   2107: areturn
    //   2108: iinc 12 1
    //   2111: goto -17 -> 2094
    //   2114: iload 10
    //   2116: bipush 9
    //   2118: if_icmplt -202 -> 1916
    //   2121: goto -386 -> 1735
    //   2124: astore 8
    //   2126: aload_2
    //   2127: areturn
    //   2128: iinc 10 1
    //   2131: goto -17 -> 2114
    //
    // Exception table:
    //   from	to	target	type
    //   955	1013	2104	java/lang/Exception
    //   1013	1134	2104	java/lang/Exception
    //   1140	1242	2104	java/lang/Exception
    //   1242	1254	2104	java/lang/Exception
    //   1256	1267	2104	java/lang/Exception
    //   1270	1297	2104	java/lang/Exception
    //   1300	1324	2104	java/lang/Exception
    //   1327	1339	2104	java/lang/Exception
    //   1342	1352	2104	java/lang/Exception
    //   1365	1378	2104	java/lang/Exception
    //   1378	1391	2104	java/lang/Exception
    //   1397	1407	2104	java/lang/Exception
    //   1410	1420	2104	java/lang/Exception
    //   1423	1521	2124	java/lang/Exception
    //   1521	1561	2124	java/lang/Exception
    //   1561	1729	2124	java/lang/Exception
    //   1735	1835	2124	java/lang/Exception
    //   1835	1887	2124	java/lang/Exception
    //   1889	1900	2124	java/lang/Exception
    //   1903	1913	2124	java/lang/Exception
    //   1916	1956	2124	java/lang/Exception
    //   1959	1994	2124	java/lang/Exception
    //   1997	2009	2124	java/lang/Exception
    //   2012	2022	2124	java/lang/Exception
    //   2038	2051	2124	java/lang/Exception
    //   2051	2064	2124	java/lang/Exception
    //   2070	2091	2124	java/lang/Exception
  }

  public int getViewTypeCount()
  {
    return 2;
  }

  class a
    implements View.OnClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      if (paramView.getId() == 2131297217)
      {
        if (!f.a(w.a(w.this)).i().equals(""))
        {
          w.b(w.this).sendEmptyMessage(8);
          return;
        }
        Toast.makeText(w.a(w.this), "请先登录", 0).show();
        return;
      }
      if (paramView.getId() == 2131297241)
      {
        if (!f.a(w.a(w.this)).i().equals(""))
        {
          Message localMessage = w.b(w.this).obtainMessage(4, (Integer)paramView.getTag());
          w.b(w.this).sendMessage(localMessage);
          return;
        }
        Toast.makeText(w.a(w.this), "请先登录", 0).show();
        return;
      }
      w.b(w.this).sendEmptyMessage(3);
    }
  }

  class b
  {
    public ImageView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TableLayout g;
    public LinearLayout[] h;
    public ImageView[] i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;

    b()
    {
    }
  }

  class c
  {
    public ImageView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TableLayout g;
    public LinearLayout[] h;
    public ImageView[] i;
    public TextView j;
    public TextView k;
    public Button l;

    c()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.w
 * JD-Core Version:    0.6.0
 */