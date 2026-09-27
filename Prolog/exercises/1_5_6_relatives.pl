female(mary). female(liz). female(mia). female(tina). female(ann). female(sue). % all females
male(mike). male(jack). male(fred). male(tom). male(joe). male(jim).            % all males

parent(mary, mia). parent(mary, fred). parent(mary, tina).  % all childern of mary
parent(mike, mia). parent(mike, fred). parent(mike, tina).  % all children of mike
parent(liz, tom). parent(liz, joe).                         % allchildern of liz
parent(jack, tom). parent(jack, joe).                       % all childern of jack
parent(mia, ann).                                           % all childern of mia
parent(tina, sue). parent(tina, jim).                       % all childern of tina
parent(tom, sue). parent(tom, jim).                         % all childern of tom

mother(X,Y) :- female(X), parent(X,Y).
father(X,Y) :- male(X), parent(X,Y).

sibling(X, Y) :- parent(Z, Y), parent(Z, X).
sibling2(X, Y) :- mother(Z, Y), mother(Z, X).               % to not get them duplicate, use 1 parent, doesn't work for all half siblings ofc
sibling3(X, Y) :- mother(Z, Y), mother(Z, X), X \= Y.       % prevent X and Y being the same child

grandmother(X, Y) :- mother(X, Z), parent(Z, Y).            % X is the mother of unknown Z and Z is the mother of Y making X the grandmother
grandfather(X, Y) :- father(X, Z), mother(Z, Y).

offspring(X, Y) :- parent(Y, X).                            % X is an offspring of Y
offspring(X, Y) :- parent(Z, X), offspring(Z, Y).            % go to earlier generations X and check if Y is an offspring of one of them, making X and offspring of Y


% ------------------------------ 5   Family Operators -----------------------------------

:- op(700, xfx, mother).        % xfx = infix = mary mother mia mother ann doesn't work
:- op(700, xfx, offspring).     % 700 = precedence (same as =)

% ------------------------------ 6   Operators and arithmetic expressions -----------------------------------
% a)
% X is 16 / 4 / 2
% X = 2
% Der Operator / ist als yfx mit Prioritöt 400 definiert. current_op(P, T, /)
% yfx bedeutet linksassoziativ i.e. links darf ein Ausdruck mit derselben Prio sein (z.b. /), aber rechts MUSS ein kleinere Prio sein.
% wird also so gerechnet: (16 / 4) / 2
% bei xfy wäre es also so:  16 / (4 / 2)

% b) 
% Y = 3, X = Y - 1
% ergibt: Y = 3, X = 3 - 1
% = rechnet nicht sondern ist unifikation. Für X = Y - 1 wird also einfach Y durch eine 3 ersetzt

% c)
% Y = 3, X is Y - 1
% ergibt: Y = 3, X = 2
% 'is' rechnet den Term auf der rechten Seite aus, darum wird hier tatsächlich 3 - 1 ausgerechnet