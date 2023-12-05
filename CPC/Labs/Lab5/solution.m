clear variables; close all; clc;

data = load("L10.txt");
t = 0:0.01:1.84; % pas de 10ms

plot(t, data)

delta_output = 22.28 - 16.89
input = 70 - 55

Kf = delta_output/input

delta_output * 0.63 + 16
Tf = 7/100

Hf = tf(Kf, [Tf, 1])

T0 = Tf/3
H0 = tf(1, [T0, 1])

Hr = (1/Hf)*(H0/(1-H0))

pidstd(Hr)