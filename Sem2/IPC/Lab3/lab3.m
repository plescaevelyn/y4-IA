%c2dm
clc
%clear variables
close all

num = 4.3;
den = conv([5, 1], [23, 1]);
Tm=2.5;
G = tf(num, den, 'IOdelay', Tm);

timeconst1=5;
timeconst2=23;
T=(timeconst1+timeconst2)/2;
Ts = timeconst1/10;

[NUMd,DENd] = c2dm(num,den,Ts,'zoh');

Gd = tf(NUMd,DENd,Ts,'IOdelay',Tm/Ts,'variable','z^-1');
Gd2 = tf(Gd.Numerator,Gd.Denominator);

H0=tf(1,[T, 1],'IOdelay',Tm);

[NUMd,DENd] = c2dm(H0.Numerator,H0.Denominator,Ts,'zoh');

H0d = tf(NUMd,DENd,Ts,'IOdelay',Tm/Ts,'variable','z^-1');
H0d2 = tf(H0d.Numerator,H0d.Denominator);

%HR = 1/Gd * H0d/(1-H0d);
HR2 = 1/Gd2 * H0d2/(1-H0d2);

numHR = [0.03508, -0.09993, 0.09482, -0.02997];
denHR = [0.004489, -0.00451, -0.004138, 0.004159];
denHR1 = [1.9602, -3.85009858, 1.88989858];

HR = tf(numHR, denHR, Ts); 
HR1 = tf(numHR, denHR1, Ts); 

HR.ioDelay = 5;
HR1.ioDelay = 5;

HR;
zpk(HR);
zpk(HR1);

disp("Răspunsul sistemului, dacă regulatorul numeric este calculat prin metoda lui Dahlin (HR1) ")
stepinfo(out.simout.Data, out.simout.Time)

disp("Răspunsul sistemului dacă se utilizează regulatorul numeric modificat (HR11)")
stepinfo(out.simout1.Data, out.simout1.Time)

disp("Răspunsul sistemului dacă se utilizează regulatorul numeric modificat, iar variaţia semnalului de comandă este limitată ")
stepinfo(out.simout2.Data, out.simout2.Time)