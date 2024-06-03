clear all; clear variables; clc; close all;

Kf3 = 4.25;
Hf3 = tf(Kf3, conv(conv([0.3 1], [22.5 1]), [40 1]));

[y, t] = step(Hf3);
%% Metoda tangentei
y_st = 4.24;
y_0 = 0;

m_st = 1;
m_0 = 0;

k = (y_st - y_0) / (m_st - m_0);
T_tm = 66.4;
T_m_tm = 17.2;

T_esantion = 15;

H_tm = tf(k, [T_tm, 1], 'IODelay', T_m_tm);
%% Metoda Cohen-Coon
y28 = 33.8;
y632 = 66.8;

T_cc = 1.5 * (y632 - y28);
T_m_cc = 1.5 * (y28 - 1/3 * y632);
alpha = T_cc / T_m_cc;
T_esantion = 20;

H_cc = tf(k, [T_cc, 1], 'IOdelay', T_m_cc);

figure,
step(Hf3);
step(H_tm, 'r');
step(H_cc, 'g')
legend("Initial step response","Tangent method", "Cohen-Coon")
%% Reglare prin metoda Ziegler-Nichols
% Regulator P
K_R_ZN_P = T_tm/T_m_tm/k;

% Regulator PI
K_R_ZN_PI = 0.9 * T_tm/T_m_tm/k;
T_ZN_I = 3.3 * T_m_tm;
H_ZN_PI = tf(K_R_ZN_PI * [T_ZN_I, 1], [T_ZN_I, 0]);

% Regulator PID (q = 1)
K_R_ZN_PID = 1.2 * T_tm/T_m_tm/k;
T_ZN_I = 2 * T_m_tm;
T_ZN_D = 0.5 * T_m_tm;
T_ZN_F = 0.1 * T_ZN_D;

H_ZN_PID = tf(conv(K_R_ZN_PID * [T_ZN_I, 1], [T_ZN_D 1]), conv([T_ZN_I, 0], [T_ZN_D, 1]));
%% Reglare prin metoda Chien-Hrones-Reswich
% Regulator P
K_R_CHR_P = 0.3 * T_tm/T_m_tm/k;

% Regulator PI
K_R_CHR_PI = 0.35 * T_tm/T_m_tm/k;
T_CHR_I = 1.2 * T_m_tm;
H_CHR_PI = tf(K_R_CHR_PI * [T_CHR_I, 1], [T_CHR_I, 0]);

% Regulator PID (q = 1)
K_R_CHR_PID = 0.6 * T_tm/T_m_tm/k;
T_CHR_I = T_m_tm;
T_CHR_D = 0.5 * T_m_tm;
T_CHR_F = 0.1 * T_CHR_D;

H_CHR_PID = tf(conv(K_R_CHR_PID * [T_CHR_I, 1], [T_CHR_D 1]), conv([T_CHR_I, 0], [T_CHR_D, 1]));
%% Reglare prin metoda Oppelt
% Regulator P
K_R_OPP_P = T_tm/T_m_tm/k;

% Regulator PI
K_R_OPP_PI = 0.8 * T_tm/T_m_tm/k;
T_OPP_I = 3.3 * T_m_tm;
H_OPP_PI = tf(K_R_OPP_PI * [T_OPP_I, 1], [T_OPP_I, 0]);

% Regulator PID (q = 1)
K_R_OPP_PID = 1.2 * T_tm/T_m_tm/k;
T_OPP_I = 2.2 * T_m_tm;
T_OPP_D = 0.42 * T_m_tm;
T_OPP_F = 0.1 * T_OPP_D;

H_OPP_PID = tf(conv(K_R_OPP_PID * [T_OPP_I, 1], [T_OPP_D 1]), conv([T_OPP_I, 0], [T_OPP_D, 1]));
%% Plotting results for P controller
figure;
title("P controller");
hold on;
annotate_performance(H_tm * K_R_ZN_P, 'b');
annotate_performance(H_tm * K_R_CHR_P, 'r');
annotate_performance(H_tm * K_R_OPP_P, 'g');
legend("Ziegler-Nichols", "Chien-Hrones-Reswick", "Oppelt");
hold off;
%% Plotting results for PI controller
figure;
title("PI controller");
hold on;
annotate_performance(feedback(H_tm * H_ZN_PI, 1), 'b');
annotate_performance(feedback(H_tm * H_CHR_PI, 1), 'r');
annotate_performance(feedback(H_tm * H_OPP_PI, 1), 'g');
legend("Ziegler-Nichols", "Chien-Hrones-Reswick", "Oppelt");
hold off;
%% Plotting results for PID controller
figure;
title("PID controller");
hold on;
annotate_performance(feedback(H_tm * H_ZN_PID, 1), 'b');
annotate_performance(feedback(H_tm * H_CHR_PID, 1), 'r');
annotate_performance(feedback(H_tm * H_OPP_PID, 1), 'g');
legend("Ziegler-Nichols", "Chien-Hrones-Reswick", "Oppelt");
hold off;