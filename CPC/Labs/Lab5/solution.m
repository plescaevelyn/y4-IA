clear variables; close all; clc;

data = load("L10.txt");
t = 1:length(data); % pas de 10ms

plot(t, data)

delta_output = 22.28 - 16.89
input = 7 - 5.5

Kf = delta_output/input

delta_output * 0.63 + 16
Tf = 7

Hf = tf(Kf, [Tf, 1])

T0 = Tf/3
H0 = tf(1, [T0, 1])

Hr = (1/Hf)*(H0/(1-H0))

pidstd(Hr)