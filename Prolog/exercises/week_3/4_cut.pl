% without Cut
p(X) :- a(X).                 % r1
p(X) :- b(X), c(X).           % r2
p(X) :- d(X).                 % r3

%p(X)
% r1: a(X)             -> s1 X = 1     

% r2: b(X), c(X)
%     |-- b(2), c(2)   -> s2 X = 2          
%     |-- b(3), c(3)   -> s3 X = 3          

% r3: d(X)             -> s4 X = 4          

% with Cut
p_cut(X) :- a(X).             % r1
p_cut(X) :- b(X), !, c(X).    % r2
p_cut(X) :- d(X).             % r3

%p_cut(X)
% r1: a(X)              -> s1 X = 1     

% r2: b(X), c(X)
%      |-- b(2), c(2)   -> s2 X = 2          
%      |-- b(3), ...    -> cut

% r3: d(X)              -> cut 

a(1).
b(2). b(3).
c(2). c(3).
d(4).