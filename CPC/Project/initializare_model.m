clear all; clear variables; clc;
%% Date initiale
A = 332.5 % suprafata bazinului in cm^2
k =0.033 % coeficienti model pompa
k1 = 0.654
k2 = -0.015
k3 = -0.0006
k11 = k2^2 + 4*(k - k3)*k1;
k12 = 8*(k - k3);
k13 = 2*(k - k3);
keta = 8e-5;
C = 9 % coeficient de curgere

Rm = 3 % omega
Pv = 2
ro = 1000
g = 10
 
C = 6.95
%% Identificare model
uo = 5.3;
uss = uo + 0.5;
actuator_constant = 3;

ho = 17.38;
hss = 20.86;

u = uss - uo;
h = (hss - ho)/actuator_constant;
Kp = h/u

hTp = ho + 0.63*(hss - ho)
Tp = 225;

Hp = tf([Kp],[Tp, 1])
%% PI controller
To = Tp/4;
Ho = tf(1, [To, 1]);
Hr = zpk(minreal(Ho/Hp/(1 - Ho)))
pidstd(Hr)
%% Electric model identification
qo = 37.63;
qss = 41.14;

q = qss - qo