perm(L) :- L = [_, _, _], member(a, L), member(b, L), member(c, L).

perm_cut1(L) :- L = [_, _, _], !, member(a, L), member(b, L), member(c, L).

perm_cut2(L) :- L = [_, _, _], member(a, L), !, member(b, L), member(c, L).

perm_cut3(L) :- L = [_, _, _], member(a, L), member(b, L), !, member(c, L).

% this makes the most sense, searches for one matching list and cuts off other matching permutations
perm_cut4(L) :- L = [_, _, _], member(a, L), member(b, L), member(c, L), !.
