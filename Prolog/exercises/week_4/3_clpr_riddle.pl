:- use_module(library(clpr)).
:- use_module(library(clpfd)).

% a)

age(Years) :- { 
      Daughter = 15,
      Mother  = 3 * Daughter,
      Mother + Years = 2 * (Daughter + Years) 
    }.

  % or just directly ask for {D = 15, M = 3*D, M + Y = 2*(D + Y)}.

  % answer is: in 15 years

% b)

donald_gerald_robert([D,O,N,A,L,D] + [G,E,R,A,L,D] = [R,O,B,E,R,T]) :-
    Vars = [D,O,N,A,L,G,E,R,B,T],           % define all possible letters
    Vars ins 0..9,                          % problem domain is 0 to 9
    all_distinct(Vars),                     
              100000*D + 10000*O + 1000*N + 100*A + 10*L + D +
              100000*G + 10000*E + 1000*R + 100*A + 10*L + D #=
              100000*R + 10000*O + 1000*B + 100*E + 10*R + T,
    D #\= 0, G #\= 0, R #\= 0,              % remove leading zeroes from first letter of words
    label(Vars).                            % assign values

    % answer: X = ([5, 2, 6, 4, 8, 5]+[1, 9, 7, 4, 8, 5]=[7, 2, 3, 9, 7, 0]) | 723970