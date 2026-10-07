warn_cut(T) :- T < 80, write('Temperatur ok'), !.
warn_cut(T) :- T < 100, write('Temperatur sehr warm'), !.
warn_cut(_) :- write('Temperatur zu heiss').

warn(T) :- T < 80, write('Temperatur ok').
warn(T) :- T >= 80, T < 100, write('Temperatur sehr warm').
warn(_) :- T >= 100, write('Temperatur zu heiss').

% cut
% Mit dem green cut wird sobald eine der Klauseln greift keine weitere mehr ausgeführt. Bsp. Wenn Klausel 1 greift werden 2 und 3 abgeschnitten
% Klauseln bei denen wir wissen, dass sie nicht zutreffen müssen so nicht ausgeführt werden

% ohne cut
% Damit die Funktionalität gleiche bleibt müssen wir die Klausel 2 und 3 so umschreiben, dass sie nicht gleichzeitig mit den vorherigen Klauseln zutreffen.
% Ohne cut werden bei jeder Abfrage alle 3 Klauseln gematcht.