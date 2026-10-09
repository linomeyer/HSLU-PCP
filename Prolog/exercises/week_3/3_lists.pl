% TODO Review again

% a) add_tail

add_tail(X, [], [X]).                       % empty list - this is the case at the end of the list - add X there

add_tail(X, [H | T], [H | T1]) :-           % common case - leave head behind (H | T becomes T) and recursively go to back of list
    add_tail(X, T, T1).


% b) del

del([], _, []).                             % empty list, nothing to delete

del([X | T], X, L1) :-                      % head = X, delete head / leave it behind and move forward
    del(T, X, L1).

del([H | T], X, [H | L1]) :-                % head is not X, keep head and move forward
    H \= X,
    del(T, X, L1).


% c) mem

mem_d(X, L) :- del(L, X, L1), L \= L1.     % delete X from L if output L1 is different - list changed


% d) rev_acc

rev_acc([], A, A).                          % list empty - finished accumulator is the result

rev_acc([H | T], A, R) :-                   % put H as head on accumulator - because we append everything at the Head the list gets reversed
    rev_acc(T, [H | A], R).


% e) rev

rev(L, R) :- rev_acc(L, [], R).             % call rev_acc with empty list as accumulator