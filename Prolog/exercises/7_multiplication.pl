mult(_, 0, 0). % something times 0 is 0
mult(X, Y, Z) :-
    Y1 is Y - 1,
    mult(X, Y1, Z1),
    Z is Z1 + X.

% in mult rule: X = 3, Y = 4
% mult(3, 4, X) = Z = 9 + X = 12
% mult(3, 3, X) = Z = 6 + X = 9
% mult(3, 2, X) = Z = 3 + X = 6
% mult(3, 1, X) = Y = 1, Z = 0 + X = 3
% mult(3, 0, X) -> X = 3, Y = 0, Z = 0 -> matches base case

% b)
% base case matches so you get the first result
% press ;
% out of local stack error

% case also matches for recursion with Y = 0
% Y1 is 0 - 1 = -1
% then goes to -2, -3, -4, etc. and keeps going forever until memory is full

% solution, only if Y > 0

better_mult(_, 0, 0).
better_mult(X, Y, Z) :-
    Y > 0,
    Y1 is Y - 1,
    better_mult(X, Y1, Z1),
    Z is Z1 + X.