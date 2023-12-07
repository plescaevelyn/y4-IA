clear all; clear variables; clc;
%% Date initiale
A = 332.5 % suprafata bazinului in cm^2
k = 0.033 % coeficienti model pompa
k1 = 0.654
k2 = -0.015
k3 = -0.0006
k11 = k2^2 + 4*(k - k3)*k1;
k12 = 8*(k - k3);
k13 = 2*(k - k3);
keta = 8e-5;
C = 6.95 % coeficient de curgere
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
Tp = 240;

Hp1 = tf([Kp],[Tp, 1])
%% PI controller
To = Tp/4;
Ho1 = tf(1, [To, 1]);
Hr1 = zpk(minreal(1/Hp1*Ho1/(1 - Ho1)))
pidstd(Hr1)
%% Electric model identification
qss = 210
qo = 13
kp = (qss - qo)/(uss - uo)
Tp = 0.63 * hss
tr = 4; % timpul de raspuns egal cu 1s
To = tr/4;

Hp2 = tf(kp, [Tp, 1])
Ho2 = tf(1, [1, 1])
Hr2 = zpk(minreal(1/Hp2*Ho2/(1 - Ho2)))
pidstd(Hr2)

Hp = zpk(minreal(Hp1*Ho2/(Ho2+1)))
% pidstd(Hp)