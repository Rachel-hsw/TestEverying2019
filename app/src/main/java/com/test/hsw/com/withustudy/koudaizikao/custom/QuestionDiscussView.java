package com.withustudy.koudaizikao.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.withustudy.koudaizikao.b.aa;
import java.util.List;

public class QuestionDiscussView extends LinearLayout
{
  private Context a;
  private ImageView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private Button g;
  private ImageView h;
  private AdaptiveListView i;
  private List<String> j;
  private aa k;
  private a l;

  public QuestionDiscussView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    a();
  }

  public QuestionDiscussView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }

  public QuestionDiscussView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a();
  }

  @TargetApi(21)
  public QuestionDiscussView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.a = paramContext;
    a();
  }

  private void a()
  {
    this.l = new a();
    View localView = LayoutInflater.from(this.a).inflate(2130903139, null);
    this.b = ((ImageView)localView.findViewById(2131296896));
    this.c = ((TextView)localView.findViewById(2131296897));
    this.d = ((TextView)localView.findViewById(2131296898));
    this.e = ((TextView)localView.findViewById(2131296899));
    this.f = ((TextView)localView.findViewById(2131296900));
    this.i = ((AdaptiveListView)localView.findViewById(2131296903));
    this.g = ((Button)localView.findViewById(2131296901));
    this.h = ((ImageView)localView.findViewById(2131296902));
    this.g.setOnClickListener(this.l);
    this.i.setOnItemClickListener(this.l);
    this.i.setSelector(2131034189);
    addView(localView);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(20, 0, 20, 0);
    localView.setLayoutParams(localLayoutParams);
  }

  public void a(aa paramaa, List<String> paramList)
  {
    this.k = paramaa;
    this.j = paramList;
    this.i.setAdapter(paramaa);
  }

  public void setDiscussButtonVisibility(int paramInt)
  {
    this.g.setVisibility(paramInt);
  }

  public void setFloorVisibility(int paramInt)
  {
    this.d.setVisibility(paramInt);
  }

  public void setImageAvatar(int paramInt)
  {
    this.b.setBackgroundResource(paramInt);
  }

  public void setImageAvatar(Bitmap paramBitmap)
  {
    this.b.setImageBitmap(paramBitmap);
  }

  public void setImageDividerVisibility(int paramInt)
  {
    this.h.setVisibility(paramInt);
  }

  public void setListVisibility(int paramInt)
  {
    this.i.setVisibility(paramInt);
  }

  public void setTextContent(String paramString)
  {
    this.e.setText(paramString);
  }

  public void setTextFloor(String paramString)
  {
    this.d.setText(paramString);
  }

  public void setTextTime(String paramString)
  {
    this.f.setText(paramString);
  }

  public void setTextUsername(String paramString)
  {
    this.c.setText(paramString);
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
      default:
        return;
      case 2131296901:
      }
      Toast.makeText(QuestionDiscussView.a(QuestionDiscussView.this), "评论", 0).show();
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      if (paramInt == -1 + QuestionDiscussView.b(QuestionDiscussView.this).getCount())
      {
        QuestionDiscussView.c(QuestionDiscussView.this).add("");
        QuestionDiscussView.c(QuestionDiscussView.this).add("");
        QuestionDiscussView.c(QuestionDiscussView.this).add("");
        QuestionDiscussView.b(QuestionDiscussView.this).notifyDataSetChanged();
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.QuestionDiscussView
 * JD-Core Version:    0.6.0
 */