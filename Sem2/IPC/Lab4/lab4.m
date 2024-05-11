% Kalman method
clc
clear variables
close all

num = 1.25;
den = conv([1, 9], [1, 14]);
Tm = 3;
Hf21 = tf(num, den, 'IOdelay', Tm);

timeconst1 = 9;
timeconst2 = 14;
T = (timeconst1 + timeconst2)/2;
Ts = 0.3; 

% discretizing the transfer function
[NUMk,DENk] = c2dm(num,den,Ts,'impulse');

K = 1/NUMk(2);
H21 = tf(K*NUMk,K*DENk,Ts,'InputDelay',Tm/Ts,'variable','z^-1'); % P/Q

P = H21.Numerator;
Q = H21.Denominator

zeros_Hf = zpk(K*NUMk);
% controller

Hr = tf(P, [1 -1 Q.*(-2)], Ts, 'InputDelay', Ts, 'variable', 'z^-1');
[numR, denR] = tfdata(Hr, 'v');

zpk(Hr)