package com.gensee.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.gensee.chat.gif.SpanResource;
import java.util.Map;
import java.util.Set;

public abstract class AbsGridViewAvatarAdapter extends BaseAdapter
{
  public static final int COUNT_PER_PAGER = 18;
  private Map<String, Drawable> browMap;
  private Object[] res1;
  private Object[] resIds;
  private SelectAvatarInterface selectAvatarInterface;

  public AbsGridViewAvatarAdapter(Context paramContext, SelectAvatarInterface paramSelectAvatarInterface, int paramInt1, int paramInt2)
  {
    this.browMap = SpanResource.getBrowMap(paramContext);
    this.res1 = this.browMap.keySet().toArray();
    int k;
    if ((paramInt2 >= 1) && (paramInt2 < 18))
    {
      this.resIds = new Object[paramInt2];
      k = paramInt1;
      if (k < paramInt1 + paramInt2);
    }
    while (true)
    {
      this.selectAvatarInterface = paramSelectAvatarInterface;
      return;
      this.resIds[i] = this.res1[k];
      k++;
      i++;
      break;
      this.resIds = new Object[18];
      int j = paramInt1;
      while (j < paramInt1 + 18)
      {
        this.resIds[i] = this.res1[j];
        j++;
        i++;
      }
    }
  }

  protected abstract int getChatGvItemLyId();

  public int getCount()
  {
    return this.resIds.length;
  }

  protected abstract AbsGridViewHolder getGridViewHolder(View paramView);

  public Object getItem(int paramInt)
  {
    return this.resIds[paramInt];
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AbsGridViewHolder localAbsGridViewHolder2;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(getChatGvItemLyId(), null);
      localAbsGridViewHolder2 = getGridViewHolder(paramView);
      paramView.setTag(localAbsGridViewHolder2);
    }
    for (AbsGridViewHolder localAbsGridViewHolder1 = localAbsGridViewHolder2; ; localAbsGridViewHolder1 = (AbsGridViewHolder)paramView.getTag())
    {
      localAbsGridViewHolder1.init((String)getItem(paramInt), (Drawable)this.browMap.get(getItem(paramInt)), paramView);
      return paramView;
    }
  }

  protected abstract class AbsGridViewHolder
  {
    private ImageView ivAvatar;

    public AbsGridViewHolder(View arg2)
    {
      Object localObject;
      this.ivAvatar = ((ImageView)localObject.findViewById(getChatExpressionIvId()));
    }

    protected abstract int getChatExpressionIvId();

    public void init(String paramString, Drawable paramDrawable, View paramView)
    {
      this.ivAvatar.setBackgroundDrawable(paramDrawable);
      paramView.setOnClickListener(new AbsGridViewAvatarAdapter.AbsGridViewHolder.1(this, paramString, paramDrawable));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.adapter.AbsGridViewAvatarAdapter
 * JD-Core Version:    0.6.0
 */