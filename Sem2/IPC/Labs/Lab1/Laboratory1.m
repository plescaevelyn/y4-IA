clc; clear variables; close all
%% First dataset
t = [0, 0.2000, 0.4000, 0.6000, 0.8000, 1.0000, 1.2000, 1.4000, 1.6000, 1.8000, 2.0000, 2.2000, 2.4000, 2.6000, 2.8000, 3.0000, 3.2000, 3.4000, 3.6000, 3.8000, 4.0000, 4.2000, 4.4000, 4.6000, 4.8000, 5.0000];
y = [0, 0.5652, 1.0365, 1.4294, 1.7570, 2.0302, 2.2579, 2.4478, 2.6061, 2.7381, 2.8481, 2.9399, 3.0163, 3.0801, 3.1333, 3.1776, 3.2146, 3.2454, 3.2711, 3.2926, 3.3104, 3.3253, 3.3377, 3.3481, 3.3567, 3.3639];

figure,
plot(t, y)
hold on

% tangent method
T = 1;

y_0 = y(1); 
y_st = y(end);

m_st = 1; % deoarece semnalul de intrare este de tip treapta
m_0 = 0;

k = (y_st - y_0) / (m_st - m_0);

H = tf(k, [T, 1]);

line([0, m_st], [0, y_st])
line([0, 5], [y_st, y_st], 'LineStyle', '--')
line([m_st, m_st], [0, y_st], 'LineStyle', '--')
hold on

step(H, t, 'r')
hold off
title("First dataset");
%% Second dataset
clear all

t = [0, 0.2000, 0.4000, 0.6000, 0.8000, 1.0000, 1.2000, 1.4000, 1.6000, 1.8000, 2.0000, 2.2000, 2.4000, 2.6000, 2.8000, 3.0000, 3.2000, 3.4000, 3.6000, 3.8000, 4.0000, 4.2000, 4.4000, 4.6000, 4.8000, 5.0000];
y = [0, 0, 0, 0.5262, 1.0291, 1.4232, 1.7320, 1.9740, 2.1636, 2.3121, 2.4285, 2.5198, 2.5912, 2.6472, 2.6911, 2.7255, 2.7525, 2.7736, 2.7901, 2.8031, 2.8132, 2.8212, 2.8274, 2.8323, 2.8361, 2.8391];

figure,
plot(t, y)
hold on

% tangent method
y_0 = y(1); 
y_st = y(end);

m_st = 1; % deoarece semnalul de intrare este de tip treapta
m_0 = 0;

k = (y_st - y_0) / (m_st - m_0)

t_m = 0.4;
T_total = 1.134;
T = T_total - t_m

H = tf(k, [T, 1], 'IOdelay', t_m)
line([0.4, m_st], [0, y_st]);
line([0, 5], [y_st, y_st], 'LineStyle', '--')
line([m_st, m_st], [0, y_st], 'LineStyle', '--')
hold on

step(H, t, 'r')
hold off
title("Second dataset");
%% Third dataset 
clear all;

t = [0, 0.2000, 0.4000, 0.6000, 0.8000, 1.0000, 1.2000, 1.4000, 1.6000, 1.8000, 2.0000, 2.2000, 2.4000, 2.6000, 2.8000, 3.0000, 3.2000, 3.4000, 3.6000, 3.8000, 4.0000, 4.2000, 4.4000, 4.6000, 4.8000, 5.0000];
y = [0, 0.3196, 1.0179, 1.8455, 2.6711, 3.4310, 4.0994, 4.6710, 5.1508, 5.5485, 5.8750, 6.1413, 6.3576, 6.5326, 6.6739, 6.7876, 6.8791, 6.9527, 7.0117, 7.0590, 7.0970, 7.1274, 7.1518, 7.1714, 7.1870, 7.1996];

figure,
plot(t, y);
hold on

% Tangent method
y_0 = y(1); 
y_st = y(end);

m_st = 1; % deoarece semnalul de intrare este de tip treapta
m_0 = 0;

k = (y_st - y_0) / (m_st - m_0)

t_m = 0.2
T1 = 2.17;
t2 = 1.89;
T = t2 - t_m

H = tf(k, [T, 1], 'IOdelay', t_m)

line([0.2, m_st], [0, y_st])
line([0, 5], [y_st, y_st], 'LineStyle', '--')
line([m_st, m_st], [0, y_st], 'LineStyle', '--')
hold on

step(H, t, 'r')
hold on
% Cohen-Coon method
y28 = 0.28*y(end)
y632 = 0.632*y(end)

t28 = 0.64
t632 = 1.35

T = 1.5 * (t632 - t28);
t_m = 1.5 * (t28 - t632 / 3)
alfa = T/t_m

H = tf(k, [T 1], 'IOdelay', t_m)

step(H, t, 'g')
hold off
title("Third dataset");