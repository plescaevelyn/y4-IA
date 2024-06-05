%% Dahlin method
Hf11 = tf(4.3, conv([5, 1], [23, 1]),"iodelay", 2.5);

ts = 1/5 * 2.5;
[NUMd, DENd] = c2dm(Hf11.Numerator, Hf11.Denominator, ts);
Hf11d = tf(NUMd, DENd, ts,"iodelay", 5, "variable", "z^-1");

H0_imposed = tf(1, [14 1], "iodelay", 2.5);
[NUMd, DENd] = c2dm(H0_imposed.Numerator, H0_imposed.Denominator, ts);
H0_imposed_d = tf(NUMd, DENd, ts, "iodelay", 5, "variable", "z^-1");

H0_imposed_d_copy = H0_imposed_d;
H0_imposed_d_copy.IODelay = 0;

Hf11d_copy = Hf11d;
Hf11d_copy.IODelay = 0;

Hr_dahlin = 1/Hf11d_copy * H0_imposed_d_copy / (1 - H0_imposed_d);
Hr_dahlin = minreal(Hr_dahlin);
Hr_dahlin = zpk(Hr_dahlin);

H_elim = tf([1 0.960234075133174], 1, ts, 'variable', 'z^-1');
Hr_filter_dahlin = 1/1.9602 * minreal(H_elim * Hr_dahlin);

Hr_filter_dahlin = tf(Hr_filter_dahlin);
%% Kalman method
Hf21 = tf(1.25, conv([9 1],[14 1]), 'iodelay', 3);
ts = 0.5;

[NUMd, DENd] = c2dm(Hf21.Numerator, Hf21.Denominator, ts);
Hfd = tf(NUMd, DENd, ts,"iodelay", 6, "variable", "z^-1");

Hfd
suma = sum(NUMd);

K = 1 / suma;

NUMd_a = NUMd * K;
DENd_a = DENd * K;
Hfd_a = tf(NUMd_a, DENd_a, ts,"iodelay", 6, "variable", "z^-1");
[P, Q] = tfdata(Hfd_a);
P = P{:};
Q = Q{:};

NUMr = Q;
DENr = [1, 0, 0, 0, 0, 0, -P(1), -P(2), -P(3)];

Hr_kalman = tf(NUMr, DENr, ts, "variable", "z^-1");

zpk(Hr_kalman)

H_elim = tf([1 0.757182463525915], 1, ts, 'variable', 'z^-1');
Hr_filter_kalman = 1/1.7571 * minreal(H_elim * Hr_kalman);

Hr_filter_kalman = tf(Hr_filter_kalman);

zpk(Hr_filter_kalman)
