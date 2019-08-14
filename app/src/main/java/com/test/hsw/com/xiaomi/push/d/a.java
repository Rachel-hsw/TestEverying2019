package com.xiaomi.push.d;

public enum a
{
  private final int ac;

  static
  {
    A = new a("CONN_XMPP_ERR", 26, 20399);
    B = new a("CONN_BOSH_UNKNOWNHOST", 27, 20407);
    C = new a("CONN_BOSH_ERR", 28, 20499);
    D = new a("BIND_SUCCESS", 29, 30000);
    E = new a("BIND_TCP_READ_TIMEOUT_DEPRECTED", 30, 30101);
    F = new a("BIND_TCP_CONNRESET_DEPRECTED", 31, 30102);
    G = new a("BIND_TCP_BROKEN_PIPE_DEPRECTED", 32, 30103);
    H = new a("BIND_TCP_READ_TIMEOUT", 33, 30108);
    I = new a("BIND_TCP_CONNRESET", 34, 30109);
    J = new a("BIND_TCP_BROKEN_PIPE", 35, 30110);
    K = new a("BIND_TCP_ERR", 36, 30199);
    L = new a("BIND_XMPP_ERR", 37, 30399);
    M = new a("BIND_BOSH_ITEM_NOT_FOUND", 38, 30401);
    N = new a("BIND_BOSH_ERR", 39, 30499);
    O = new a("BIND_TIMEOUT", 40, 30501);
    P = new a("BIND_INVALID_SIG", 41, 30502);
    Q = new a("CHANNEL_TCP_READTIMEOUT_DEPRECTED", 42, 40101);
    R = new a("CHANNEL_TCP_CONNRESET_DEPRECTED", 43, 40102);
    S = new a("CHANNEL_TCP_BROKEN_PIPE_DEPRECTED", 44, 40103);
    T = new a("CHANNEL_TCP_READTIMEOUT", 45, 40108);
    U = new a("CHANNEL_TCP_CONNRESET", 46, 40109);
    V = new a("CHANNEL_TCP_BROKEN_PIPE", 47, 40110);
    W = new a("CHANNEL_TCP_ERR", 48, 40199);
    X = new a("CHANNEL_XMPPEXCEPTION", 49, 40399);
    Y = new a("CHANNEL_BOSH_ITEMNOTFIND", 50, 40401);
    Z = new a("CHANNEL_BOSH_EXCEPTION", 51, 40499);
    aa = new a("CHANNEL_TIMER_DELAYED", 52, 50001);
    ab = new a("CHANNEL_STATS_COUNTER", 53, 8000);
    a[] arrayOfa = new a[54];
    arrayOfa[0] = a;
    arrayOfa[1] = b;
    arrayOfa[2] = c;
    arrayOfa[3] = d;
    arrayOfa[4] = e;
    arrayOfa[5] = f;
    arrayOfa[6] = g;
    arrayOfa[7] = h;
    arrayOfa[8] = i;
    arrayOfa[9] = j;
    arrayOfa[10] = k;
    arrayOfa[11] = l;
    arrayOfa[12] = m;
    arrayOfa[13] = n;
    arrayOfa[14] = o;
    arrayOfa[15] = p;
    arrayOfa[16] = q;
    arrayOfa[17] = r;
    arrayOfa[18] = s;
    arrayOfa[19] = t;
    arrayOfa[20] = u;
    arrayOfa[21] = v;
    arrayOfa[22] = w;
    arrayOfa[23] = x;
    arrayOfa[24] = y;
    arrayOfa[25] = z;
    arrayOfa[26] = A;
    arrayOfa[27] = B;
    arrayOfa[28] = C;
    arrayOfa[29] = D;
    arrayOfa[30] = E;
    arrayOfa[31] = F;
    arrayOfa[32] = G;
    arrayOfa[33] = H;
    arrayOfa[34] = I;
    arrayOfa[35] = J;
    arrayOfa[36] = K;
    arrayOfa[37] = L;
    arrayOfa[38] = M;
    arrayOfa[39] = N;
    arrayOfa[40] = O;
    arrayOfa[41] = P;
    arrayOfa[42] = Q;
    arrayOfa[43] = R;
    arrayOfa[44] = S;
    arrayOfa[45] = T;
    arrayOfa[46] = U;
    arrayOfa[47] = V;
    arrayOfa[48] = W;
    arrayOfa[49] = X;
    arrayOfa[50] = Y;
    arrayOfa[51] = Z;
    arrayOfa[52] = aa;
    arrayOfa[53] = ab;
    ad = arrayOfa;
  }

  private a(int paramInt)
  {
    this.ac = paramInt;
  }

  public static a a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
      return a;
    case 2:
      return b;
    case 3:
      return c;
    case 4:
      return d;
    case 5:
      return e;
    case 6:
      return f;
    case 7:
      return g;
    case 10000:
      return h;
    case 10101:
      return i;
    case 10102:
      return j;
    case 10103:
      return k;
    case 10104:
      return l;
    case 10105:
      return m;
    case 10106:
      return n;
    case 10107:
      return o;
    case 10199:
      return p;
    case 10999:
      return q;
    case 20000:
      return r;
    case 20101:
      return s;
    case 20102:
      return t;
    case 20103:
      return u;
    case 20104:
      return v;
    case 20105:
      return w;
    case 20106:
      return x;
    case 20107:
      return y;
    case 20199:
      return z;
    case 20399:
      return A;
    case 20407:
      return B;
    case 20499:
      return C;
    case 30000:
      return D;
    case 30101:
      return E;
    case 30102:
      return F;
    case 30103:
      return G;
    case 30108:
      return H;
    case 30109:
      return I;
    case 30110:
      return J;
    case 30199:
      return K;
    case 30399:
      return L;
    case 30401:
      return M;
    case 30499:
      return N;
    case 30501:
      return O;
    case 30502:
      return P;
    case 40101:
      return Q;
    case 40102:
      return R;
    case 40103:
      return S;
    case 40108:
      return T;
    case 40109:
      return U;
    case 40110:
      return V;
    case 40199:
      return W;
    case 40399:
      return X;
    case 40401:
      return Y;
    case 40499:
      return Z;
    case 50001:
      return aa;
    case 8000:
    }
    return ab;
  }

  public int a()
  {
    return this.ac;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.d.a
 * JD-Core Version:    0.6.0
 */