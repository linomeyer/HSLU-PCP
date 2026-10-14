:- use_module(library(clpr)).
fib_clp(N, F) :- { N = 0, F = 0 }.
fib_clp(N, F) :- { N = 1, F = 1 }.
fib_clp(N, F) :-
    { N >= 2, F = F1+F2, N1 = N-1, N2 = N-2 },
    fib_clp(N1, F1),
    fib_clp(N2, F2).

% a) Anfrage terminiert nicht, es wird endlos weitergesucht bis das Stack Limit erreicht wird und ein Fehler ausgegeben wird
% b) Die dritte Klausel wird immer gematcht wenn N ungebunden ist. Es werden also immer wieder grössere N versucht


fib_clp2(N, F) :- { N = 0, F = 0 }.
fib_clp2(N, F) :- { N = 1, F = 1 }.
fib_clp2(N, F) :-
    { N >= 2, F >= N - 1,                       % c) Änderung: Wir wissen N muss kleiner sein als F, also können wir N darauf beschränken und somit die Suche endlich machen
      F = F1 + F2, N1 = N - 1, N2 = N - 2 },
    fib_clp2(N1, F1),
    fib_clp2(N2, F2).



