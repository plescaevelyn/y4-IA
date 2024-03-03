clearvars
load('lab01_02.mat')

n = 40;

%% 1
datas = sort(data);
min = min(datas);
max = max(datas);
w = max - min;
m = round(sqrt(n));
omega = w/(m-1);

u = [];
u(1) = min - omega/2;
umax = max + omega/2;
xc = (min+max)/2

nru=max/omega;

i=2;
while i<=nru
    u(i) = u(i - 1) + omega;
    i = i + 1;
end

for j = 1 : (length(u) - 1)
    xci(j) = (u(j) + u(j + 1)) / 2;
end

Ai1 = zeros(1,length(u)-1);
Ai1(1) = ai(1);
for j = 2:(length(u) - 1)
    Ai1(j) = Ai1(j-1) + ai(j);
end

for j = 1:length(ai)
    f(j) = ai(j)/n;
end


Fi1 = zeros(1, length(u) - 1);
Fi1(1) = f(1);
for j = 2:(length(u) - 1)
    Fi1(j) = Fi1(j - 1) + fi(j);
end

for j = 1:(length(u) - 1)
    prod(j) = f(j) * xci(j);
end
sumfixci = sum(prod);

%% 2
% Arithmetic mean
x_ = mean(datas)

% Geometric mean
Mg=geomean(datas)

%Square Mean 
Msq= norm(datas)/sqrt(n) 

%Harmonic Mean
Mh= harmmean(datas)
%Median 
M_e = median(datas)
%Sampled (Corrected) Dispersion

s2= (1/(n-1)) * sum((datas - x_).^2)

%Estimated Dispersion
sigma2= (1/n) * sum((datas - x_).^2)

s= sqrt(s2)

sigmaa= sqrt(sigma2)

%Quartiles
Q1 = prctile(datas,25) 
Q2 = prctile(datas,50) 
Q3 = prctile(datas,75) 

Iq= Q3-Q1
q = Iq/Q2
Cv = s/x_

% x_punct= 