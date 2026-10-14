set_difference([], _, []).
set_difference([H|T], Set2, [H|Diff]) :-
    \+ member(H, Set2),            % Head of set 1 is not set 2 -> keep it
    set_difference(T, Set2, Diff).
set_difference([H|T], Set2, Diff) :-
    member(H, Set2),               % Head of set 1 is in set 2 -> leave it
    set_difference(T, Set2, Diff).