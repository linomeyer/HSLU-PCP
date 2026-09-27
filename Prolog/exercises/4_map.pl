n(red, green). n(red, yellow).
n(green, red). n(green, yellow).
n(yellow, red). n(yellow, green).

colors(LU, NW, OW, SZ, UR, ZG) :-
    UR = yellow, SZ = red,
    n(LU, OW), n(LU, ZG),  % LU neighbours
    n(ZG, SZ),             % ZG neighbours
    n(SZ, UR),             % SZ neighbours
    n(UR, NW),             % UR neighbours
    n(NW, OW).             % NW neighbours