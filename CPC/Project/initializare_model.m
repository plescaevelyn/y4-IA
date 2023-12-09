clear all; clear variables; clc;
%% Date initiale
A = 332.5 % suprafata bazinului in cm^2
k = 0.033 % coeficienti model pompa
k1 = 0.624
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

ho = 16.23;
hss = 19.86;

qo = 28;
qss = 33.99;

u = uss - uo;
h = (hss - ho)/actuator_constant;
Kp = h/u

hTp = ho + 0.63*(hss - ho)
Tp = 196;

Hp1 = tf([Kp],[Tp, 1])
%% PI controller
To = Tp/4;
Ho1 = tf(1, [To, 1]);
Hr1 = zpk(minreal(1/Hp1*Ho1/(1 - Ho1)))
pidstd(Hr1)

k_compensare = ((hss - ho)/(qss - qo))/((hss - ho)/(uss - uo))
%% Electric model identification
% bucla interna
kp = (qss - qo)/(uss - uo) 
qTp = qo + 0.63 * (qss - qo)
Tp1 = 0.754;
% tr = 4; % timpul de raspuns egal cu 1s
To1 = 1;
Ti1 = Tp1;
Kr1 = Tp1/kp/To1;
%% Mechanical model identification
% bucla externa
ho = 16.16;
hss = 23.92;

Kp2 = (qss - qo)/(hss - ho)/actuator_constant;
hTp2 = ho + 0.63 * (hss - ho)
Tp2 = 437;

Hp2 = tf(Kp2, [Tp2, 1])
To2 = 100;
Kr2 = Tp2/Kp2/To2;
Ti2 = Tp2;