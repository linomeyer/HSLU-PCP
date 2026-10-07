% Endrekursive Fibonacci-Berechnung
fib_tr(N, F) :- fib_tr(N, 0, 1, F). 
fib_tr(0, A, _, A).                      
fib_tr(N, A, B, F) :-                    
    N1 is N - 1,
    N1 >= 0,
    Sum is A + B,
    fib_tr(N1, B, Sum, F).                % endrekursiver Aufruf

% Ein-/Ausgabe
io_fib :-
    write('Gib eine Zahl ein: '),
    read(N),                              % Zahl vom Benutzer einlesen
    fib_tr(N, F),                         % Fibonacci-Zahl berechnen
    write('Die '), write(N),
    write('. Fibonacci-Zahl ist '), write(F),
    nl.                                   % nl = newline