% =====================================================================
%
% Usage:  ?- solve(relationship, 326).
%         ?- solve(sudoku, 140).
% =====================================================================

:- use_module(library(http/http_client)).
:- use_module(library(http/http_json)).
:- use_module(library(clpfd)).

% import methods from family exercise
:- consult(family).

% generic solve for both problems
solve(Type, Id) :-
    problem_url(Type, Id, GetUrl),
    http_get(GetUrl, json(Problem), []),            % fetch problem
    solve_problem(Type, Problem, Solution),          % solve problem
    problem_url(Type, PostUrl),
    http_post(PostUrl, json(json([id=Id, solution=Solution])), Response, []), % post answer, get response from problem provider
    format("Solution: ~w~nResponse from Problem Provider: ~w~n", [Solution, Response]). % string formatting: ~w = write() and ~n = newline


base_url('http://localhost:16316/problem/').

problem_url(Type, Url) :-                    % use this directly for POST
    base_url(Base),
    atom_concat(Base, Type, Url).

problem_url(Type, Id, Url) :-                % use for GET
    problem_url(Type, TypeUrl),
    format(atom(Url), '~w/~w', [TypeUrl, Id]).



% 4b) family relationships
solve_problem(relationship, Problem, Answer) :-
    member(firstPerson=Person1, Problem),
    member(relationship=Relation, Problem),
    member(secondPerson=Person2, Problem),

    % equals if call(offspring(fred, jim)) succeeds (matches with a fact) then Answer = true else Answer = false
    % not declarative :(
    ( 
        call(Relation, Person1, Person2) 
        -> Answer = true 
        ; Answer = false 
    ).

relation_answer(Relation, Person1, Person2, true) :-
    once(call(Relation, Person1, Person2)).
relation_answer(Relation, Person1, Person2, false) :-
    \+ call(Relation, Person1, Person2).

% 4c) Sudoku
solve_problem(sudoku, Problem, Rows) :-
    member(sudoku=Grid, Problem),
    maplist(replace_0, Grid, Rows),
    sudoku(Rows).


% replaces every 0 with a variable
replace_0([], []).
replace_0([0|T], [_|T2]) :- !, replace_0(T, T2).
replace_0([H|T], [H|T2]) :- replace_0(T, T2).


% sudoku solver from the lession
sudoku(Rows) :-
    append(Rows, Vs), Vs ins 1..9,
    maplist(all_distinct, Rows),
    transpose(Rows, Columns),
    maplist(all_distinct, Columns),
    Rows = [A, B, C, D, E, F, G, H, I],
    blocks(A, B, C), blocks(D, E, F), blocks(G, H, I),
    maplist(label, Rows).

blocks([], [], []).
blocks([J, K, L|Bs1], [M, N, O|Bs2], [P, Q, R|Bs3]) :-
    all_distinct([J, K, L, M, N, O, P, Q, R]),
    blocks(Bs1, Bs2, Bs3).