pi = 3.141592;

n = 2940;
f = 50;

J = 0.4; % momentul de inertie
Kf = 0.1115; % coeficientul de frecare
Rr = 0.156; % rezistenta rotorica
Rs = 0.294; % rezistenta statorica
Lr = 0.0417; % inductanta rotorica
Ls = 0.0424; % inductanta statorica
LM = 0.041; % inductanta mutuala intre infasurarea statorica si infasurarea rotorica
MR = 0; % cuplul rezistent

alpha = Rr/Lr;
gamma = 1 - LM^2/Ls/Lr;
beta = LM/gamma/Ls/Lr;

omega = pi*n/30; % viteza unghiulara a rotorului

% ua = 220*sqrt(2)*sin(2*pi*f*t+pi/2);
% ub = 220*sqrt(2)*sin(2*pi*fn*t)

s = 0.02; % alunecarea motorului asincron
%% Cazul motorului sincron
% calculul parametrilor regulatorului
Hf = tf(2, conv([1, 8], [1, 10]));
[nom, denom] = tfdata(Hf);

T0 = 1.541 - 1.419;
A0 = 52.17;
K0 = 4/pi/A0;

K0 = 4*b/pi/A0;

% Controllers
% P controller
Kr_P = 0.5 * K0

% PI controller
Kr_PI = 0.45 * K0
Ti_PI = 0.8 * T0

% PID controller
Kr_PID = 0.6 * K0
Ti_PID = 0.5 * T0
Td_PID = 0.12 * T0

% Transfer functions for each controller
% P Controller
Hr_P = tf(Kr_P)
% step(feedback(Hr_P*Hf,1)); title("P controller");

% PI Controller
Hr_PI = tf([Kr_PI*Ti_PI, Kr_PI], [Ti_PI, 0])
% step(feedback(Hr_PI*Hf,1)); title("PI controller");

% PID Controller
Hr_PID = tf([Kr_PID*Ti_PID*Td_PID, Kr_PID*Ti_PID, Kr_PID], [Ti_PID, 0, 0])
% step(feedback(Hr_PID*Hf,1)); title("PID controller");
%% cazul motorului asincron
% PI controller
Kr_PI2 = Kr_PI/4
Ti_PI2 = Ti_PI

HR2 = tf([Kr_PI2*Ti_PI2, Kr_PI2], [Ti_PI2, 0]);

H2 = tf([0, Kr_PI2], [Ti_PI2, 0]);

H_PI = Kr_PI2 + H2