package com.umeng.message.b;

import com.squareup.wire.ProtoEnum;
import java.util.Comparator;

final class au
  implements Comparator<ProtoEnum>
{
  public int a(ProtoEnum paramProtoEnum1, ProtoEnum paramProtoEnum2)
  {
    return paramProtoEnum1.getValue() - paramProtoEnum2.getValue();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.au
 * JD-Core Version:    0.6.0
 */