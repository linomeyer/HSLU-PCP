:- dynamic fak_as/2.          % allows change at runtime

% a)

% Value already saved
fak(N, F) :-
    fak_as(N, F), !,        % cut here so it doesn't keep matching the other cases when it already has this one saved
    write('(Hinweis: Fakultät von '), write(N),
    write(' war gespeichert)'), nl.

% recursion base
fak(0, 1).

% standard case
fak(N, F) :-
    N > 0,
    N1 is N - 1,
    fak(N1, F1),
    F is N * F1,
    asserta(fak_as(N, F)).    % save result in fak_as

% b)
fak_clear :-
    retractall(fak_as(_, _)),       % delete 
    write('(Hinweis: Alle gespeicherten Werte wurden gelöscht)'), nl.